package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        t.setUsername(username);
        t.setPassword(password);
        if (username.equals(u) && password.equals(p)){
            return "adminMenu";
        }else {
            return "login";
        }
    }

//    public admin adminUsername(String username, String password)
//    {
//        admin t = new admin();
//        String u = "";
//        String p = "";
//        u = adminRepository.findByUsername(username).getUsername();
//        p = adminRepository.findByUsername(username).getPassword();
//        t.setUsername(username);
//        t.setPassword(password);
//        return t;
//    }

//    public admin findByUsername2(String username){
//        return adminRepository.findByUsername(username);
//    }
}
