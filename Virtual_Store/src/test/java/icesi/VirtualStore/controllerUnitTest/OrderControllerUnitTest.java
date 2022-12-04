package icesi.VirtualStore.controllerUnitTest;

import icesi.VirtualStore.constant.OrderStatus;
import icesi.VirtualStore.controller.OrderController;
import icesi.VirtualStore.dto.OrderDTO;
import icesi.VirtualStore.dto.OrderItemDTO;
import icesi.VirtualStore.dto.OrderUpdateDTO;
import icesi.VirtualStore.mapper.OrderMapper;
import icesi.VirtualStore.mapper.OrderMapperImpl;
import icesi.VirtualStore.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderControllerUnitTest {

    @Mock
    private OrderService orderService;

    private OrderMapper orderMapper;

    private OrderController orderController;

    @BeforeEach
    public void  init(){
        orderMapper = new OrderMapperImpl();
        orderController = new OrderController(orderService,orderMapper);
    }

    /*
    tests
    1 get Order
    2 get User Orders
    3 get All Orders
    4 Create Order
    5 Update Order
    6 Delete Order
     */

    @Test
    public void testGetOrder(){
        orderController.getOrder(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
        verify(orderService,times(1)).getOrder(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
    }

    @Test
    public void testGetUserOrders(){
        orderController.getUserOrders(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
        verify(orderService,times(1)).getUserOrders(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
    }

    @Test
    public void testGetAllOrders(){
        orderController.getAllOrders();
        verify(orderService,times(1)).getOrders();
    }

    @Test
    public void testCreateOrder(){
        OrderDTO orderDTO = new OrderDTO(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),10.0, OrderStatus.STATUS_02,
                new ArrayList<OrderItemDTO>(),UUID.fromString("00b0c882-7374-11ed-a1eb-0242ac120002"));

        orderController.createOrder(orderDTO);

        verify(orderService,times(1)).createOrder(orderMapper.fromDTO(orderDTO),orderDTO.getUserId(),orderDTO.getOrderItems());
    }

    @Test
    public void testUpdateOrder(){
        OrderUpdateDTO orderUpdateDTO =  new OrderUpdateDTO(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),OrderStatus.STATUS_03);
        orderController.updateOrder(orderUpdateDTO);
        verify(orderService,times(1)).updateOrder(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),orderUpdateDTO.getStatus().toString());
    }


    @Test
    public void testDeleteOrder(){
        orderController.deleteOrder(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
        verify(orderService,times(1)).deleteOrder(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
    }


}
