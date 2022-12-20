package com.example.paymentservice.controller;

import com.example.paymentservice.model.User;
import com.example.paymentservice.repository.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PaymentController {
    private PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/pay/{id}")
    public String payments(@PathVariable("id") String id, Model model){
//        User user = id.isPresent() ?
//                userService.findUserById(id.get()).get() : new User();
        model.addAttribute("user", id);
        model.addAttribute("payments", paymentService.getAllPay());
        return "Payment";
    }
}
