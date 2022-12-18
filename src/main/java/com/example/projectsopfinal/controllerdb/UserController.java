package com.example.projectsopfinal.controllerdb;

import com.example.projectsopfinal.model.User;
import com.example.projectsopfinal.repository.PaymentService;
import com.example.projectsopfinal.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Controller
@CrossOrigin("*")
public class UserController {

    private UserService userService;
    private PaymentService paymentService;

    @Autowired
    public UserController(UserService userService, PaymentService paymentService) {
        this.userService = userService;
        this.paymentService = paymentService;
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "user/main";
        }
        userService.save(user);
        return "user/ConfirmTour";
    }

    @PostMapping("/save-pay")
    public String payTour(@RequestParam("bank") String bank, @RequestParam("id") String id, @RequestParam("image") MultipartFile image) throws IOException {
        userService.change(bank, id, image);
        return "redirect:/main";
    }

    @GetMapping("/delete-usertour/{id}")
    public String removeUserTour(@PathVariable("id") String id, Model model) {
        userService.deleteUserById(id);
        model.addAttribute("user", userService.getAllUsers());
        return "redirect:/main";
    }

    @GetMapping("/payment/{id}")
    public String userPayment(@PathVariable("id") Optional<String> id, Model model) {
        model.addAttribute("payments", paymentService.getAllPay());

        User user = id.isPresent() ?
                userService.findUserById(id.get()).get() : new User();
        model.addAttribute("user", user);
        return "user/Payment";
    }
//    @GetMapping(value = {"/edit-add-reservation/{id}", "/edit-add-reservation"})
//    public String editReservation(@PathVariable("id") Optional<String> id, Model model) {
//        Reservation reservation = id.isPresent() ?
//                reservationService.findReservationById(id.get()).get() : new Reservation();
//        model.addAttribute("reservation", reservation);
//        return "add-edit";
//    }

//    @GetMapping("/payment")
//    public String payments(Model model){
//        model.addAttribute("payments", paymentService.getAllPay());
//        return "user/Payment";
//    }
//    @GetMapping("/tourUser")
//    public String userTour(Model model) {
//        model.addAttribute("user", userService.getAllUsers());
//        return "user/UserBooking";
//    }
//    @GetMapping("/confirm/")
//    public String formTour(Model model) {
//        model.addAttribute("user", userService.findUserById(id));
//        return "user/DetailTour";
//    }

    @GetMapping("/adminViewlist")
    public String ShowUser(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "admin/AdminViewListName";
    }

    @GetMapping("/adminAllBooking")
    public String Booking(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "admin/adminAllBooking";
    }

    @GetMapping("/userdetail/{id}")
    public String userDetail(@PathVariable("id") String id, Model model) {
        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "admin/user_detail";
    }

    @GetMapping("/photos/{id}")
    public String getPhoto(Model model, @PathVariable String id) {
        User slip = userService.getId(id);
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(slip.getSlip().getData()));
        return "user/test";
    }
}

