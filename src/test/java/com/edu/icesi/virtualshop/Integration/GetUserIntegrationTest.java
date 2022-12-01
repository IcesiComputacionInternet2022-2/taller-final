package com.edu.icesi.virtualshop.Integration;

import com.edu.icesi.virtualshop.Integration.config.InitialDataConfig;
import com.edu.icesi.virtualshop.dto.UserCreateDTO;
import com.edu.icesi.virtualshop.dto.UserDTO;
import com.edu.icesi.virtualshop.error.exception.VirtualShopError;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.edu.icesi.virtualshop.constants.VirtualShopErrorCode.CODE_004;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:h2:mem:testdb" })
@Import({InitialDataConfig.class})
@ActiveProfiles("test")
public class GetUserIntegrationTest {


        private MockMvc mockMvc;

        @Autowired
        private WebApplicationContext webApplicationContext;

        @Autowired
        private ObjectMapper objectMapper;

        private static final String USER_ID = "34366239-3264-3430-2d34-6662642d3131";

        @BeforeEach
        public void init(){
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        }

        @Test
        @SneakyThrows
        public void getUserSuccessfully() {

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/" + USER_ID)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            UserCreateDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), UserCreateDTO.class);
            assertThat(userResult,hasProperty("email",is("juansedogs@gmail.com")));
        }

        @Test
        @SneakyThrows
        public void getAllAnimalsSuccessfully() {

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            String response = result.getResponse().getContentAsString();
            UserDTO[] userResults = userResults(response);
            assertThat(userResults[0], hasProperty("email", is("juansedogs@gmail.com")));
            assertThat(userResults[1], hasProperty("email", is("test@gmail.com")));
            assertThat(userResults[2], hasProperty("email", is("test2@gmail.com")));
        }
        @SneakyThrows
        private UserDTO[] userResults(String response){
            String[] users = response.substring(1,response.length()-1).split("},");
            UserDTO[] usersResults = new UserDTO[users.length];
            for(int i =0;i<users.length;i++){
                users[i] = users[i]+"}";
                usersResults[i]= objectMapper.readValue(users[i], UserDTO.class);
            }
            return usersResults;
        }

        @Test
        @SneakyThrows
        public void testNotFound() {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/" + "f35ae647-51eb-4c17-8d26-1c925cb6a4e6") //Not in the database
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            VirtualShopError userError = objectMapper.readValue(result.getResponse().getContentAsString(), VirtualShopError.class);
            assertThat(userError,hasProperty("code",is(CODE_004.toString())));
            assertThat(userError,hasProperty("message",is(CODE_004.getMessage())));
        }
    }
