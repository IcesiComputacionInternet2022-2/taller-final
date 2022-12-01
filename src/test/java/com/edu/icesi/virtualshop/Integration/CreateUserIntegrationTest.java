package com.edu.icesi.virtualshop.Integration;

import com.edu.icesi.virtualshop.Integration.config.InitialDataConfig;
import com.edu.icesi.virtualshop.dto.UserCreateDTO;
import com.edu.icesi.virtualshop.dto.UserDTO;
import com.edu.icesi.virtualshop.error.exception.VirtualShopError;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStreamReader;
import java.io.Reader;

import static com.edu.icesi.virtualshop.constants.VirtualShopErrorCode.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:h2:mem:testdb" })
@Import({InitialDataConfig.class})
@ActiveProfiles("test")
public class CreateUserIntegrationTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    private ObjectMapper objectMapper;
    private UserDTO userDTO;

    @BeforeEach
    private void init(){
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @SneakyThrows
    public void createUserSuccesfully(){
        String body = parseResourceToString("createUser.json");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();

        UserCreateDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), UserCreateDTO.class);
        assertThat(userResult,hasProperty("email",is("juandavid227@hotmail.com")));
    }

    @Test
    @SneakyThrows
    public void createUserRepeated(){ //IS CONFLICT
        String body = parseResourceToString("createUser.json");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isBadRequest())
                .andReturn();

        VirtualShopError userError = objectMapper.readValue(result.getResponse().getContentAsString(), VirtualShopError.class);
        assertThat(userError,hasProperty("code",is(CODE_003.toString())));
        assertThat(userError,hasProperty("message",is(CODE_003.getMessage())));
    }

    @Test
    @SneakyThrows
    public void testEmailDomain(){
        UserCreateDTO baseUser = baseUser();
        baseUser.setEmail("sinArroba");
        String body = objectMapper.writeValueAsString(baseUser);
        MvcResult result = getBadRequestResult(body);

        VirtualShopError userError = objectMapper.readValue(result.getResponse().getContentAsString(), VirtualShopError.class);
        assertThat(userError,hasProperty("code",is(CODE_006.toString())));
        assertThat(userError,hasProperty("message",is(CODE_006.getMessage())));
    }

    @Test
    @SneakyThrows
    public void testInvalidPhone(){
        UserCreateDTO baseUser = baseUser();
        baseUser.setPhoneNumber("3207553421");
        String body = objectMapper.writeValueAsString(baseUser);
        MvcResult result = getBadRequestResult(body);

        VirtualShopError userError = objectMapper.readValue(result.getResponse().getContentAsString(), VirtualShopError.class);
        assertThat(userError,hasProperty("code",is(CODE_007.toString())));
        assertThat(userError,hasProperty("message",is(CODE_007.getMessage())));
    }
    @Test
    @SneakyThrows
    public void testCantCreateWithoutNumberOrEmail(){
        UserCreateDTO baseUser = baseUser();
        baseUser.setEmail(null);
        baseUser.setPhoneNumber(null);
        String body = objectMapper.writeValueAsString(baseUser);
        MvcResult result = getBadRequestResult(body);
        VirtualShopError userError = objectMapper.readValue(result.getResponse().getContentAsString(), VirtualShopError.class);
        assertThat(userError,hasProperty("code",is(CODE_005.toString())));
        assertThat(userError,hasProperty("message",is(CODE_005.getMessage())));
    }

    @SneakyThrows
    private MvcResult getBadRequestResult(String body){
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isBadRequest())
                .andReturn();
        return result;
    }

    @SneakyThrows
    private String parseResourceToString(String classPath){
        Resource resource = new ClassPathResource(classPath);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)){
            return FileCopyUtils.copyToString(reader);
        }
    }

    @SneakyThrows
    private UserCreateDTO baseUser(){
        String body = parseResourceToString("createUser.json");
        return objectMapper.readValue(body, UserCreateDTO.class);
    }
}
