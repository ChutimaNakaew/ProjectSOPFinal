package com.example.projectsopfinal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailTour {
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detailTour() {
        return "user/DetailTour";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmTour() {
        return "user/ConfirmTour";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/AdminLogin";
    }

    @RequestMapping(value = "/listname", method = RequestMethod.GET)
    public String listName() {
        return "admin/AdminViewListName";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "user/Form";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String payment() {
        return "user/Payment";
    }

    @RequestMapping(value = "/notPass", method = RequestMethod.GET)
    public String notPass() {
        return "admin/notPass";
    }

    @RequestMapping(value = "/userdetail", method = RequestMethod.GET)
    public String userdetail() {
        return "admin/user_detail";
    }

    @RequestMapping(value = "/adminHome", method = RequestMethod.GET)
    public String adminHome() {
        return "admin/adminHome";
    }

    @RequestMapping(value = "/adminAllBooking", method = RequestMethod.GET)
    public String adminAllBooking() {
        return "admin/adminAllBooking";
    }

    @RequestMapping(value = "/adminPayment", method = RequestMethod.GET)
    public String adminPayment() {
        return "admin/adminPayment";
    }

    @RequestMapping(value = "/adminPaymentApprove", method = RequestMethod.GET)
    public String adminPaymentApprove() {
        return "admin/adminPaymentApprove";
    }

    @RequestMapping(value = "/adminCheckPayment", method = RequestMethod.GET)
    public String adminCheckPayment() {
        return "admin/admincheckpayment";
    }

    @RequestMapping(value = "/maintour", method = RequestMethod.GET)
    public String maintour() {
        return "admin/maintour";
    }

    @RequestMapping(value = "/edittour", method = RequestMethod.GET)
    public String edittour() {
        return "admin/edittour";
    }

    @RequestMapping(value = "/addtour", method = RequestMethod.GET)
    public String addtour() {
        return "admin/addtour";
    }
}
