package org.crystalkste.myshop.controller;

import org.crystalkste.myshop.entity.Order;
import org.crystalkste.myshop.entity.Product;
import org.crystalkste.myshop.repository.OrderRepository;
import org.crystalkste.myshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Product product = productRepository.findById(order.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        order.setProduct(product);
        order.setCategory(product.getCategoryName());
        order.setProductName(product.getName());
        return orderRepository.save(order);
    }

}
