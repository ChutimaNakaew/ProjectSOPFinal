package com.example.projectsopfinal.controllerdb;

import com.example.projectsopfinal.repository.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
//import com.example.projectsopfinal.repository.ProvinceService;
import com.example.projectsopfinal.model.Tour;
import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.repository.TourService;
import com.example.projectsopfinal.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Controller
public class AdminController {
    private TourService tourService;
    private UserService userService;

    private AdminService adminService;

    @Autowired
    public AdminController(TourService tourService, UserService userService, AdminService adminService) {
        this.tourService = tourService;
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/adminHome")
    public String adminHome(Model model) {
        model.addAttribute("tours", tourService.getAllTours());
        return "admin/adminHome";
    }

    @GetMapping("/adminPayment")
    public String adminPayment(Model model) {
        model.addAttribute("tours", userService.getAllUsers());
        return "admin/adminPayment";
    }

    @GetMapping("/adminCheckPayment/{id}")
    public String adminCheckPayment(@PathVariable("id") String id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(user.getSlip().getData()));
        model.addAttribute("user", user);
        return "admin/admincheckpayment";
    }

    @PostMapping("/updateStateTrue/{id}")
    public String updateStateTrue(@PathVariable("id") String id)
    {
        userService.updateStateTrue(id);
        return "redirect:/adminPayment";
    }


    @PostMapping("/updateStateFalse/{id}")
    public String updateStateFalse(@PathVariable("id") String id)
    {
        userService.updateStateFalse(id);
        return "redirect:/adminPayment";
    }

    @PostMapping("/changeStateFalse/{id}")
    public String changeStateFalse(@PathVariable("id") String id)
    {
        userService.changeStateFalse(id);
        return "redirect:/adminPaymentApprove";
    }

    @PostMapping("/changeStateTrue/{id}")
    public String changeStateTrue(@PathVariable("id") String id)
    {
        userService.updateStateTrue(id);
        return "redirect:/notPass";
    }



    @GetMapping("/adminPaymentApprove")
    public String adminPaymentApprove(Model model) {
        model.addAttribute("tours", userService.getAllUsers());
        return "admin/adminPaymentApprove";
    }

    @GetMapping("/notPass")
    public String notPass(Model model) {
        model.addAttribute("tours", userService.getAllUsers());
        return "admin/notPass";
    }

    @PostMapping("/adminLogin")
    public String findByUsername(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        String ans = adminService.findByUsername(username, password);
//        return "admin/adminLogin";
        System.out.println(ans);
        return "redirect:/"+ans;
//        if(ans == "pass"){
//            return "admin/adminHome";
//        }else {
//            return "admin/AdminLogin";
//        }
    }

    @GetMapping("/login")
    public String login() {
        return "admin/adminLogin";
    }

//        @GetMapping("/form/{name}")
//        public String formtour(@PathVariable("name") String name, Model model) {
//            User user = new User();
//            model.addAttribute("user", user);
//            model.addAttribute("tours", tourService.detailTourByName(name));
//            return "user/Form";
//        }
}
