package com.example.projectsopfinal.controllerdb;

import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.repository.PaymentService;
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
    private PaymentService paymentService;

    @Autowired
    public UserController(UserService userService, PaymentService paymentService) {
        this.userService = userService;
        this.paymentService = paymentService;
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "user/main";
        }
        userService.save(user);
        return "user/ConfirmTour";
    }

    @GetMapping("/delete-usertour/{id}")
    public String removeUserTour(@PathVariable("id") String id, Model model) {
        userService.deleteUserById(id);
        model.addAttribute("user", userService.getAllUsers());
        return "redirect:/main";
    }
    @GetMapping("/payment/{id}")
    public String userPayment(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", userService.getAllUsers());
        model.addAttribute("payments", paymentService.getAllPay());
        return "user/Payment";
    }

//    @GetMapping("/payment")
//    public String payments(Model model){
//        model.addAttribute("payments", paymentService.getAllPay());
//        return "user/Payment";
//    }
//    @GetMapping("/tourUser")
//    public String userTour(Model model) {
//        model.addAttribute("user", userService.getAllUsers());
//        return "user/UserBooking";
//    }
//    @GetMapping("/confirm/")
//    public String formTour(Model model) {
//        model.addAttribute("user", userService.findUserById(id));
//        return "user/DetailTour";
//    }

    @GetMapping("/adminViewlist")
    public String ShowUser(Model model){
//        User users = new User();
//        model.addAttribute("users", new User());
        model.addAttribute("user", userService.getAllUsers());
        return "admin/AdminViewListName";
    }
}
