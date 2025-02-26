package org.crystalkste.myshop.service;

import jakarta.transaction.Transactional;
import org.crystalkste.myshop.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Transactional
    public String processPayment(Payment payment) {
        paymentRepository.save(payment);
        if(payment.getAmount()<=0){
            throw new RuntimeException("Amount must be greater than zero");
        }
        return "Payment processed successfully";
    }
}
