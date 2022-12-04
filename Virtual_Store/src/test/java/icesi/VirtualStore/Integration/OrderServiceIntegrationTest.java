package icesi.VirtualStore.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import icesi.VirtualStore.dto.OrderDTO;
import icesi.VirtualStore.dto.OrderUpdateDTO;
import icesi.VirtualStore.error.exception.VirtualStoreError;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
public class OrderServiceIntegrationTest {

    private MockMvc mockMvc;


    @Autowired
    private WebApplicationContext wac;

    private ObjectMapper objectMapper;

    private static final String ORDER_UUID = "ccc7ff73-1989-413a-ab52-9bec7a049e99";

    @BeforeEach
    public void init() {
        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @SneakyThrows
    public void getOrdersSuccessfully() {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        OrderDTO orderResult = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDTO.class);

        assertThat(orderResult, hasProperty("status", is("CREATED")));
    }

    @Test
    @SneakyThrows
    public void getOrderSuccessfully() {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/orders/" + ORDER_UUID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        OrderDTO orderResult = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDTO.class);

        assertThat(orderResult, hasProperty("status", is(OrderStatus.CREATED)));
    }

    @Test
    @SneakyThrows
    public void createOrderSuccessfully() {
        OrderDTO baseOrderDTO = baseOrder();
        String body = objectMapper.writeValueAsString(baseOrderDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();

        OrderDTO orderResult = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDTO.class);
        assertThat(orderResult, hasProperty("status", is(OrderStatus.CREATED)));

    }

    @Test
    @SneakyThrows
    public void updateOrderSuccessfully() {
        OrderUpdateDTO updateOrder = updateOrder();
        String body = objectMapper.writeValueAsString(updateOrder);
        mockMvc.perform(MockMvcRequestBuilders.put("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/orders/" + ORDER_UUID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        OrderDTO orderResult = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDTO.class);

        assertThat(orderResult, hasProperty("status", is(OrderStatus.COMPLETED)));
    }

    @Test
    @SneakyThrows
    public void deleteOrderSuccessfully() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/orders/" + ORDER_UUID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/orders/" + ORDER_UUID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();

        String response = result.getResponse().getContentAsString();

        VirtualStoreError err = objectMapper.readValue(response, VirtualStoreError.class);
        assertThat(err, hasProperty("message", is(VirtualStoreErrorCode.CODE_O_01.getMessage())));
        assertThat(err, hasProperty("code", is(VirtualStoreErrorCode.CODE_O_01)));
    }

    @SneakyThrows
    private OrderUpdateDTO updateOrder() {
        String body = parseResourceToString("JsonFiles/updateOrder.json");
        return objectMapper.readValue(body, OrderUpdateDTO.class);

    }

    @SneakyThrows
    private OrderDTO baseOrder() {
        String body = parseResourceToString("JsonFiles/createOrder.json");
        return objectMapper.readValue(body, OrderDTO.class);
    }

    @SneakyThrows
    private String parseResourceToString(String classPath) {
        Resource resource = new ClassPathResource(classPath);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

}
