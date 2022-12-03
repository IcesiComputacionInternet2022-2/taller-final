package co.edu.icesi.JCStore.controller;

import co.edu.icesi.JCStore.constants.OrderStatus;
import co.edu.icesi.JCStore.dto.OrderDTO;
import co.edu.icesi.JCStore.mapper.OrderMapper;
import co.edu.icesi.JCStore.mapper.OrderMapperImpl;
import co.edu.icesi.JCStore.service.OrderService;
import co.edu.icesi.JCStore.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class OrderControllerTest {

    private OrderService orderService;
    private OrderMapper orderMapper;
    private OrderController orderController;

    @BeforeEach()
    public void init(){
        orderService = mock(OrderServiceImpl.class);
        orderMapper = new OrderMapperImpl();
        orderController = new OrderController(orderService, orderMapper);
    }

    @Test
    public void createOrderTest(){
        UUID uuidOrder = UUID.randomUUID();
        UUID uuidUser = UUID.randomUUID();
        OrderDTO orderDTO = new OrderDTO(uuidOrder,2000, OrderStatus.PENDING.name(),null,uuidUser);

        orderController.createOrder(orderDTO);
        verify(orderService, times(1)).createOrder(orderMapper.fromDTO(orderDTO));
    }

    @Test
    public void getOrdersTest(){
        orderController.getOrders();
        verify(orderService, times(1)).getOrders();
    }

    @Test
    public void getOrderDTOTest(){
        UUID uuidOrder = UUID.randomUUID();
        orderController.getOrderDTO(uuidOrder);
        verify(orderService, times(1)).getOrder(uuidOrder);
    }

    @Test
    public void updateOrderStatusTest(){
        UUID uuidOrder = UUID.randomUUID();
        OrderDTO orderDTO = new OrderDTO();
        orderController.updateOrderStatus(uuidOrder, orderDTO);
        verify(orderService, times(1)).updateOrderStatus(uuidOrder, orderMapper.fromDTO(orderDTO));
    }

    @Test
    public void getOrderMadeByUser(){
        UUID uuidUser = UUID.randomUUID();
        orderController.getOrdersMadeByUser(uuidUser);
        verify(orderService, times(1)).getOrdersMadeByUser(uuidUser);
    }

    @Test
    public void cancelOrderTest(){
        UUID uuidOrder = UUID.randomUUID();
        orderController.cancelOrder(uuidOrder);
        verify(orderService, times(1)).cancelOrder(uuidOrder);
    }


}
