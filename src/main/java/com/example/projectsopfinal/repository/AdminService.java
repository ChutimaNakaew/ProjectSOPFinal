package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Tour;
import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.model.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AdminService {
    private adminRepository adminRepository;


    @Autowired
    public AdminService(adminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

//    public Iterable<admin> findByNameAdmin(String name){
//        return adminRepository.findByUsername(name);
//    }

    public String findByUsername(String username, String password)
    {
        admin t = new admin();
        String u = "";
        String p = "";
        u = adminRepository.findByUsername(username).getUsername();
        p = adminRepository.findByUsername(username).getPassword();
        System.out.println(u);
        System.out.println("=======");
        System.out.println(p);
        System.out.println(username);
        System.out.println("=======");
        System.out.println(password);
        if (username.equals(u) && password.equals(p)){
            return "adminHome";
        }else {
            return "login";
        }
    }

//    public admin findByUsername2(String username){
//        return adminRepository.findByUsername(username);
//    }
}
