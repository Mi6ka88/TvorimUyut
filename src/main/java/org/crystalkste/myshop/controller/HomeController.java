package org.crystalkste.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "homePage";
    }
    @GetMapping("/checkout.html")
    public String checkout() {
        return "checkout";
    }
    @GetMapping("/about-us")
    public String aboutUs() {
        return "about-us";
    }
}
