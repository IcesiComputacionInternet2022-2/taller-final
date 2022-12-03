package icesi.VirtualStore.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import icesi.VirtualStore.dto.UserCreateDTO;
import icesi.VirtualStore.dto.UserDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:postgresql://localhost:49153/test" }
)
@ActiveProfiles("test")
public class UserServiceIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    private ObjectMapper objectMapper;

    private static final String USER_UUID = "44991aa0-6568-401c-b032-6b436a7812dd";


    @BeforeEach
    private void init() {
        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @SneakyThrows
    public void createUserSuccessfully() {
        UserCreateDTO baseUser = baseUser();
        String body = objectMapper.writeValueAsString(baseUser);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();

        UserCreateDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), UserCreateDTO.class);
        assertThat(userResult, hasProperty("email", is(baseUser.getEmail())));

    }

    @Test
    @SneakyThrows
    public void getUserSuccessfully() {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/" + USER_UUID))
                .andExpect(status().isOk())
                .andReturn();

        UserCreateDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), UserCreateDTO.class);

        assertThat(userResult, hasProperty("password", is("askhda123")));

    }

    @SneakyThrows
    private UserCreateDTO baseUser(){
        String body = parseResourceToString("JsonFiles/createUser.json");
        return objectMapper.readValue(body, UserCreateDTO.class);
    }
    @SneakyThrows
    private String parseResourceToString(String classPath) {
        Resource resource = new ClassPathResource(classPath);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }


}
