package co.edu.icesi.VirtualStore.controller;

import co.edu.icesi.VirtualStore.dto.CartItemDTO;
import co.edu.icesi.VirtualStore.mapper.ItemMapper;
import co.edu.icesi.VirtualStore.mapper.UserMapper;
import co.edu.icesi.VirtualStore.service.ItemsService;
import co.edu.icesi.VirtualStore.service.OrderService;
import co.edu.icesi.VirtualStore.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ViewControllerTest {

    private ViewController viewController;
    private UserService userService;
    private ItemsService itemsService;
    private OrderService orderService;
    private UserMapper userMapper;
    private ItemMapper itemMapper;
    private Model model;
    private HttpServletRequest httpServletRequest;
    private HttpSession httpSession;

    @BeforeEach
    public void init() {
        userService = mock(UserService.class);
        itemsService = mock(ItemsService.class);
        orderService = mock(OrderService.class);
        userMapper = mock(UserMapper.class);
        itemMapper = mock(ItemMapper.class);
        model = mock(Model.class);
        httpServletRequest = mock(HttpServletRequest.class);
        httpSession = mock(HttpSession.class);
        viewController = new ViewController(userService, itemsService, userMapper, itemMapper, orderService);
    }

    /*
    @Test
    public void testHome() {
        when(httpServletRequest.getSession()).thenReturn(any());
        when(model.addAttribute(any(), any())).thenReturn(model);
        assertEquals("home", viewController.home(model, httpServletRequest));
        verify(model, times(2)).addAttribute(any());
        verify(httpServletRequest, times(1)).getSession();
        verify(itemMapper, times(1)).cartItemfromItem(any());
        verify(itemsService, times(1)).getItems();
    }*/
}