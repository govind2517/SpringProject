package com.neog.paymentservice.controllers;

import com.neog.paymentservice.model.PaymentDTO;
import com.neog.paymentservice.service.PaymentService;
import com.stripe.exception.StripeException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Enumeration;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService payService;

    @PostMapping("/payment")
    public String getPaymentLink(@RequestBody PaymentDTO payDetails) throws StripeException {
        return payService.getPyamentLink(payDetails);
    }

    @PostMapping("/webhook")
    public void webhook(HttpServletRequest request, HttpServletResponse response) throws StripeException {
        System.out.println("Got webhook event start");
        Enumeration<String> attributeNames = request.getAttributeNames();
        for(String key : Collections.list(attributeNames)){
            System.out.println("key :: "+key);
        }
        System.out.println("Got webhook event end");
    }
}
