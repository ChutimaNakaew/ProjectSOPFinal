package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Payment;
import com.example.projectsopfinal.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    public Payment savePay(Payment payment){
        return paymentRepository.save(payment);
    }

    public Iterable<Payment> getAllPay(){
        return paymentRepository.findAll();
    }

    public void deleteAllPay(){
        paymentRepository.deleteAll();
    }

    public void deletePayById(String id){
        paymentRepository.deleteById(id);
    }

    public Optional<Payment> findPayById(String id){
        return paymentRepository.findById(id);
    }
}
