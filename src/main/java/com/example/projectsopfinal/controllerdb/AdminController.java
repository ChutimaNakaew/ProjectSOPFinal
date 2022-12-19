package com.example.projectsopfinal.controllerdb;

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

    @Autowired
    public AdminController(TourService tourService, UserService userService) {
        this.tourService = tourService;
        this.userService = userService;
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
    public String UpdateState(@PathVariable("id") String id)
    {
        userService.updateStateTrue(id);
        return "redirect:/adminPayment";
    }

//        @GetMapping("/form/{name}")
//        public String formtour(@PathVariable("name") String name, Model model) {
//            User user = new User();
//            model.addAttribute("user", user);
//            model.addAttribute("tours", tourService.detailTourByName(name));
//            return "user/Form";
//        }
}
