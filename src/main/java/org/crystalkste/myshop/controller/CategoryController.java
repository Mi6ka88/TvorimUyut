package org.crystalkste.myshop.controller;


import org.crystalkste.myshop.entity.Product;
import org.crystalkste.myshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/kitchen")
    public String kitchen(Model model) {
        List<Product> products = productRepository.findByCategoryName("Кухни");
        model.addAttribute("kitchen", products);
        return "kitchen";
    }

    @GetMapping("/bedroom")
    public String bedroom(Model model) {
        List<Product> products = productRepository.findByCategoryName("Спальни");
        model.addAttribute("bedroom", products);
        return "bedroom";
    }

    @GetMapping("/livingroom")
    public String livingroom(Model model) {
        List<Product> products = productRepository.findByCategoryName("Гостиная");
        model.addAttribute("livingroom", products);
        return "livingroom";
    }

    @GetMapping("/kidsroom")
    public String kidsroom(Model model) {
        List<Product> products = productRepository.findByCategoryName("Детская");
        model.addAttribute("kidsroom", products);
        return "kidsroom";
    }
}
