package org.crystalkste.myshop.controller;

import org.crystalkste.myshop.data.Payment;
import org.crystalkste.myshop.service.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentClient paymentClient;

    @Autowired
    public PaymentController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @PostMapping("/payment")
    public String pay(@RequestBody Payment payment) {
        System.out.println("Получен запрос на оплату: " + payment);
        String result = paymentClient.processPayment(payment);
        System.out.println("Результат оплаты: " + result);
        return result;
    }
}
