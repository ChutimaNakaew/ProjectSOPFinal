package com.example.projectsopfinal.controllerdb;

import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "user/main";
        }
        userService.saveUser(user);
        return "redirect:main";
    }

    @GetMapping("/adminViewlist")
    public String ShowUser(Model model){
//        User users = new User();
//        model.addAttribute("users", new User());
        model.addAttribute("user", userService.getAllUsers());
        return "admin/AdminViewListName";
    }
}
