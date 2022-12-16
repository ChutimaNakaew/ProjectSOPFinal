package com.example.projectsopfinal.controllerdb;

import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/save-user")
//    public String saveUserTour(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:main";
//    }


    @RequestMapping(value = "/save-user", method = RequestMethod.GET)
    public String saveUserTour(Model model){
        model.addAttribute("user", new User());
        return "user/formtest";
    }
}
