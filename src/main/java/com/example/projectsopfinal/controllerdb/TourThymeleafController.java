package com.example.projectsopfinal.controllerdb;

//import com.example.projectsopfinal.repository.ProvinceService;
import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.repository.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Null;


@Controller
public class TourThymeleafController {
    private TourService tourService;
//    private ProvinceService provinceService;

    @Autowired
    public TourThymeleafController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/main")
    public String tours(@RequestParam(value = "provinces", required=false) String provinces, Model model) {
//        model.addAttribute("tours", tourService.getAllTours());
//        System.out.println(provinces);
//        return "user/main";
        if (provinces == null || provinces == ""){
            model.addAttribute("tours", tourService.getAllTours());
        }
        else {
            model.addAttribute("tours", tourService.getToursByProvince(provinces));
        }
        return "user/main";
    }
//    @GetMapping("/main")
//    public String provinces(Model model){
//        model.addAttribute("provinces", provinceService.getAllProvinces());
//        return "user/main";
//    }
    @GetMapping("/detail/{name}")
    public String detail(@PathVariable("name") String name, Model model) {
        model.addAttribute("tours", tourService.detailTourByName(name));
        return "user/DetailTour";
    }

    @GetMapping("/form/{name}")
    public String formtour(@PathVariable("name") String name, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("tours", tourService.detailTourByName(name));
        return "user/Form";
    }

    @GetMapping("/maintour")
    public String maintours(Model model){
        model.addAttribute("tours", tourService.getAllTours());
//        if (provinces == null || provinces == ""){
//            model.addAttribute("tours", tourService.getAllTours());
//        }
//        else {
//            model.addAttribute("tours", tourService.getToursByProvince(provinces));
//        }
        return "admin/maintour";
    }
}
