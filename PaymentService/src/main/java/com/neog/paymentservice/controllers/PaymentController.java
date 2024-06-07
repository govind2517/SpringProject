package com.neog.paymentservice.controllers;

import com.neog.paymentservice.model.PaymentDTO;
import com.neog.paymentservice.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService payService;

    @PostMapping("/payment")
    public String getPaymentLink(@RequestBody PaymentDTO payDetails) throws StripeException {
        return payService.getPyamentLink(payDetails);
    }
}
