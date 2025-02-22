package org.crystalkste.myshop.service;


import org.crystalkste.myshop.data.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "payment-service", url = "http://localhost:9090")
public interface PaymentClient {
    @PostMapping("/payment")
    String processPayment(@RequestBody Payment payment);
}