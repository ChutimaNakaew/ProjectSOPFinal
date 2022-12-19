package com.example.projectsopfinal.controllerdb;

//import com.example.projectsopfinal.repository.ProvinceService;
import com.example.projectsopfinal.model.Tour;
import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.repository.TourService;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.Optional;


@Controller
public class TourThymeleafController {
    private TourService tourService;
//    private ProvinceService provinceService;

    @Autowired
    public TourThymeleafController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/main")
    public String tours(@RequestParam(value = "provinces", required=false) String provinces, @RequestParam(value = "filters", required=false) String filters, Model model) {
//        model.addAttribute("tours", tourService.getAllTours());
//        System.out.println(provinces);
//        return "user/main";
        if (provinces == null || provinces == "") {
            model.addAttribute("tours", tourService.getAllTours(filters));
        } else {
            model.addAttribute("tours", tourService.getToursByProvince(provinces, filters)); //, filters
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
        model.addAttribute("tours", tourService.TourByName(name));
        return "user/DetailTour";
    }

    @GetMapping("/form/{name}")
    public String formtour(@PathVariable("name") String name, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("tours", tourService.TourByName(name));
        return "user/Form";
    }

    @GetMapping("/maintour")
    public String maintours(@RequestParam(value = "provinces", required=false) String provinces, @RequestParam(value = "filters", required=false) String filters, Model model){
//        model.addAttribute("tours", tourService.getAllTours());
        if (provinces == null || provinces == ""){
            model.addAttribute("tours", tourService.getAllTours());
        }
        else {
            model.addAttribute("tours", tourService.getToursByProvince(provinces, filters));
        }
        return "admin/maintour";
    }

    @GetMapping(value = {"/edit-add/{id}", "/edit-add"})
    public String editTour(@PathVariable("id") Optional<String> id, Model model) {
        Tour tour = id.isPresent() ?
                tourService.findTourById(id.get()).get() : new Tour();
        model.addAttribute("tour", tour);
        return "admin/add-edit";
    }

    @PostMapping("/save-reservation")
    public String editTour(@ModelAttribute("tour") @Valid Tour tour,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/add-edit";
        }
        tourService.saveTour(tour);
        return "redirect:maintour";
    }

    @GetMapping("/delete-reservation/{id}")
    public String removeTour(@PathVariable("id") String id, Model model) {
        tourService.deleteTourById(id);
        model.addAttribute("tour", tourService.getAllTours());
        return "redirect:/maintour";
    }

    @GetMapping("/TourUpdate/{id}")
    public String TourUpdate(@PathVariable(value = "id") String id, Model model) {
        Tour tour = tourService.getTourById(id);

        model.addAttribute("tour", tour);
        return "admin/edittour";
    }

    @PostMapping("/UpdateForm")
    public String ChangeTour(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("province") String province,
                             @RequestParam("price") Double price,
                             @RequestParam("schedule") String schedule,
                             @RequestParam("img") String img,
                             @RequestParam("detail_img") String detail_img,
                             @RequestParam("detail") String detail,
                             @RequestParam("date_first") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date_first,
                             @RequestParam("date_second") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date_second,
                             @RequestParam("max_tourist") Integer max_tourist
    )
    {
        tourService.chageName(id, name, province, price, schedule, img, detail_img, detail, date_first, date_second, max_tourist);
        return "redirect:/maintour";
    }
}
