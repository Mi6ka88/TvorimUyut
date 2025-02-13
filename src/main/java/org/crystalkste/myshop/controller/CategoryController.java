package org.crystalkste.myshop.controller;

import org.crystalkste.myshop.entity.Product;
import org.crystalkste.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class CategoryController {

    private final ProductService productService;

    @Autowired
    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/kitchen")
    public String kitchen(Model model) {
        List<Product> products = productService.getProductsByCategory("Кухни");
        model.addAttribute("kitchen", products);
        return "kitchen";
    }

    @GetMapping("/bedroom")
    public String bedroom(Model model) {
        List<Product> products = productService.getProductsByCategory("Спальни");
        model.addAttribute("bedroom", products);
        return "bedroom";
    }

    @GetMapping("/livingroom")
    public String livingroom(Model model) {
        List<Product> products = productService.getProductsByCategory("Гостиная");
        model.addAttribute("livingroom", products);
        return "livingroom";
    }

    @GetMapping("/kidsroom")
    public String kidsroom(Model model) {
        List<Product> products = productService.getProductsByCategory("Детская");
        model.addAttribute("kidsroom", products);
        return "kidsroom";
    }

    @GetMapping("/details")
    public String getProductDetails(@RequestParam("productId") Long productId, Model model) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "product-details";
        }
        return "Error";
    }
}