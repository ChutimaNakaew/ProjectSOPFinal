package com.example.projectsopfinal.controllerdb;

import com.example.projectsopfinal.repository.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourThymeleafController {
    private TourService tourService;

    @Autowired
    public TourThymeleafController(TourService tourService){
        this.tourService = tourService;
    }
    @GetMapping("/main")
    public String tours(Model model){
        model.addAttribute("tours", tourService.getAllTours());
        return "user/main";
    }
    @GetMapping("/detail")
    public String detail(Model model){
        model.addAttribute("tours", tourService.getAllTours());
        return "user/DetailTour";
    }
}
