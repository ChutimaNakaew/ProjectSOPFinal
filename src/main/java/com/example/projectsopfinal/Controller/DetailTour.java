package com.example.projectsopfinal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailTour {
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detailTour(){
        return "DetailTour";
    }
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(){
        return "user/Form";
    }
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String payment(){
        return "user/Payment";
    }
    @RequestMapping(value = "/notPass", method = RequestMethod.GET)
    public String notPass(){
        return "admin/notPass";
    }
    @RequestMapping(value = "/userdetail", method = RequestMethod.GET)
    public String userdetail(){
        return "admin/user_detail";
    }
}
