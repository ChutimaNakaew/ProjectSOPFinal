package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, String> {
}
