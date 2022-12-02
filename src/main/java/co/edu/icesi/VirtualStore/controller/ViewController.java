package co.edu.icesi.VirtualStore.controller;

import co.edu.icesi.VirtualStore.dto.*;
import co.edu.icesi.VirtualStore.mapper.ItemMapper;
import co.edu.icesi.VirtualStore.mapper.UserMapper;
import co.edu.icesi.VirtualStore.model.Order;
import co.edu.icesi.VirtualStore.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ViewController {

    private final UserService userService;
    private final ItemsService itemsService;

    private final UserMapper userMapper;
    private final ItemMapper itemMapper;
    private final OrderService orderService;

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("role", session.getAttribute("role")).toString();
        model.addAttribute("items", itemsService.getItems().stream().map(itemMapper::cartItemfromItem).collect(Collectors.toList()));
        return "home";
    }

    @GetMapping("/admin")
    public String admin(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (((LoggedUserDTO) session.getAttribute("LoggedUser")).getRole().getName().equals("Administrator user"))
            return "admin";
        return "redirect:/home";
    }

    @PostMapping("/addCartItem")
    public String addCartItem(CartItemDTO item, HttpServletRequest request){
        HttpSession session = request.getSession();
        LoggedUserDTO loggedUserDTO = ((LoggedUserDTO) session.getAttribute("LoggedUser"));
        loggedUserDTO.getCart().getItems().add(item);
        return "redirect:/home";
    }


    @GetMapping("/getUsers")
    public String getUsers(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (((LoggedUserDTO) session.getAttribute("LoggedUser")).getRole().getName().equals("Administrator user")) {
            model.addAttribute("users", userService.getUsers());
            return "getUsers";
        }
        return "redirect:/home";
    }

    @GetMapping("/getCart")
    public String getCart(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        LoggedUserDTO loggedUserDTO = ((LoggedUserDTO) session.getAttribute("LoggedUser"));
        model.addAttribute("items", loggedUserDTO.getCart().getItems());
        return "cart";
    }

    @PostMapping("/removeItem")
    public String removeCartItem(CartItemDTO item, HttpServletRequest request) {
        HttpSession session = request.getSession();
        LoggedUserDTO loggedUserDTO = ((LoggedUserDTO) session.getAttribute("LoggedUser"));
        loggedUserDTO.getCart().getItems().removeIf(cartItemDTO -> (cartItemDTO.getId().equals(item.getId())));
        return "redirect:/getCart";
    }

    @PostMapping("/removeOrder")
    public String removeOrder(Order order) {
        orderService.removeOrder(order.getId());
        return "redirect:/getOrders";
    }

    @GetMapping("/createOrder")
    public String createOrder(HttpServletRequest request) {
        HttpSession session = request.getSession();
        LoggedUserDTO loggedUserDTO = ((LoggedUserDTO) session.getAttribute("LoggedUser"));
        orderService.createOrder(userMapper.fromLoggedUserDTO(loggedUserDTO), loggedUserDTO.getCart());
        loggedUserDTO.setCart(new CartDTO());
        return "redirect:/getOrders";
    }

    @GetMapping("/getOrders")
    public String getOrders(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        LoggedUserDTO loggedUserDTO = ((LoggedUserDTO) session.getAttribute("LoggedUser"));
        model.addAttribute("orders", orderService.getOrdersByUserId(loggedUserDTO.getId()));
        return "order";
    }

    @GetMapping("/createNewItem")
    public String createItem(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (((LoggedUserDTO) session.getAttribute("LoggedUser")).getRole().getName().equals("Administrator user")) {
            model.addAttribute("itemDTO", new ItemDTO());
            return "createItem";
        }
        return "redirect:/home";
    }

    @PostMapping("/createItem")
    public String createItem(@Valid @ModelAttribute ItemDTO itemDTO, BindingResult errors, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (((LoggedUserDTO) session.getAttribute("LoggedUser")).getRole().getName().equals("Administrator user")) {

            if (hasBindingErrors(errors, model)) {
                try {
                    itemsService.addItem(itemMapper.fromDTO(itemDTO));
                    model.addAttribute("itemResponse", true);
                } catch (RuntimeException runtimeException) {
                    model.addAttribute("itemResponse", false);
                    model.addAttribute("message", runtimeException.getMessage());
                }
            }
            return "createItem";
        }
        return "redirect:/home";
    }

    @GetMapping("/modifyItem")
    public String modifyItem(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (((LoggedUserDTO) session.getAttribute("LoggedUser")).getRole().getName().equals("Administrator user")) {
            return "modifyItem";
        }
        return "redirect:/home";
    }

    @PostMapping("/updateItem")
    public String modifyItem(@RequestParam(value = "itemID", required = false) UUID itemID, @RequestParam(value = "attribute", required = false) String attribute, @RequestParam(value = "newValue", required = false) String newValue, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (((LoggedUserDTO) session.getAttribute("LoggedUser")).getRole().getName().equals("Administrator user")) {
            try {
                itemsService.modifyItem(itemID, attribute, newValue);
                model.addAttribute("itemResponse", true);
            } catch (RuntimeException runtimeException) {
                model.addAttribute("itemResponse", false);
                model.addAttribute("attribute", attribute);
                model.addAttribute("message", runtimeException.getMessage());
            }
            return "modifyItem";
        }
        return "redirect:/home";
    }

    private boolean hasBindingErrors(BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("itemResponse", false);
            model.addAttribute("message", Objects.requireNonNull(errors.getFieldError()).getDefaultMessage());
            return false;
        }
        return true;
    }
}