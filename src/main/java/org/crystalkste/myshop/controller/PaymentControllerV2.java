package org.crystalkste.myshop.controller;


import org.crystalkste.myshop.entity.Payment;
import org.crystalkste.myshop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiPay")
public class PaymentControllerV2 {

    private final PaymentService paymentService;

    @Autowired
    PaymentControllerV2(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payment")
    public ResponseEntity<String> pay(@RequestBody Payment payment) {
        System.out.println("Получен запрос на оплату: " + payment);
        String result = paymentService.processPayment(payment);
        System.out.println("Результат оплаты: " + result);
        return ResponseEntity.ok(result);
    }
}
