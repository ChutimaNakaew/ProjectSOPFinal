package com.example.projectsopfinal.controllerdb;

import com.example.projectsopfinal.repository.PaymentService;
import com.example.projectsopfinal.repository.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    private PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @GetMapping("/payment")
    public String payments(Model model){
        model.addAttribute("payments", paymentService.getAllPay());
        return "user/Payment";
    }
}
