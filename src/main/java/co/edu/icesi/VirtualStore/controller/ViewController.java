package co.edu.icesi.VirtualStore.controller;

import co.edu.icesi.VirtualStore.constant.UserErrorCode;
import co.edu.icesi.VirtualStore.dto.*;
import co.edu.icesi.VirtualStore.error.exception.UserError;
import co.edu.icesi.VirtualStore.error.exception.UserException;
import co.edu.icesi.VirtualStore.mapper.ItemMapper;
import co.edu.icesi.VirtualStore.mapper.UserMapper;
import co.edu.icesi.VirtualStore.service.ItemsService;
import co.edu.icesi.VirtualStore.service.LoginService;
import co.edu.icesi.VirtualStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class ViewController {

    private final UserService userService;
    private final LoginService loginService;
    private final ItemsService itemsService;
    private final UserMapper userMapper;
    private final ItemMapper itemMapper;

    @GetMapping("/signIn")
    public String signIn(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @GetMapping("/login")
    public String login(@Valid @ModelAttribute LoginDTO loginDTO, BindingResult errors, Model model, HttpServletRequest request) {
        if (!hasBindingErrors(errors, model, "loginResponse")) {
            try {
                TokenDTO tokenDTO = loginService.login(loginDTO);
                LoggedUserDTO loggedUserDTO = userMapper.loggedUserFromUser(userService.getUserByEmailOrPhoneNumber(loginDTO.getEmailPhone()));
                HttpSession session = request.getSession();
                session.setAttribute(HttpHeaders.AUTHORIZATION, "Bearer " + tokenDTO.getToken());
                session.setAttribute("LoggedUser", loggedUserDTO);
                return loggedUserDTO.getRole().getName().equals("Basic user") ? "redirect:/home" : "redirect:/admin";
            } catch (UserException userException) {
                model.addAttribute("loginResponse", false);
                model.addAttribute("message", userException.getError().getMessage());
            }
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (((LoggedUserDTO) session.getAttribute("LoggedUser")).getRole().getName().equals("Administrator user"))
            return "admin";
        return "redirect:/home";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "createUser";
    }

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult errors, Model model) {
        if (!hasBindingErrors(errors, model, "userResponse")) {
            try {
                validateEmptyIdentifiers(userDTO);
                userService.createUser(userMapper.fromDTO(userDTO));
                model.addAttribute("userResponse", true);
            } catch (UserException userException) {
                model.addAttribute("userResponse", false);
                model.addAttribute("message", userException.getError().getMessage());
            }
        }
        return "createUser";
    }

    @GetMapping("/getUsers")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "getUsers";
    }

    @GetMapping("/createNewItem")
    public String createItem(Model model) {
        model.addAttribute("itemDTO", new ItemDTO());
        return "createItem";
    }

    @PostMapping("/createItem")
    public String createItem(@Valid @ModelAttribute ItemDTO itemDTO, BindingResult errors, Model model) {
        if (!hasBindingErrors(errors, model, "itemResponse")) {
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

    @GetMapping("/modifyItem")
    public String modifyItem() {
        return "modifyItem";
    }

    @PostMapping("/updateItem")
    public String modifyItem(@RequestParam(value = "itemID", required = false) UUID itemID, @RequestParam(value = "attribute", required = false) String attribute, @RequestParam(value = "newValue", required = false) String newValue, Model model) {
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

    private void validateEmptyIdentifiers(UserDTO userDTO) {
        if (Optional.ofNullable(userDTO.getEmail()).isEmpty() && Optional.ofNullable(userDTO.getPhoneNumber()).isEmpty())
            throw new UserException(HttpStatus.BAD_REQUEST, new UserError(UserErrorCode.CODE_02, UserErrorCode.CODE_02.getMessage()));
    }

    private boolean hasBindingErrors(BindingResult errors, Model model, String attributeName) {
        if (errors.hasErrors()) {
            model.addAttribute(attributeName, false);
            model.addAttribute("message", Objects.requireNonNull(errors.getFieldError()).getDefaultMessage());
            return true;
        }
        return false;
    }
}