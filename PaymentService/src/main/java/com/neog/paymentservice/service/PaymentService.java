package com.neog.paymentservice.service;

import com.neog.paymentservice.model.PaymentDTO;
import com.stripe.exception.StripeException;

public interface PaymentService {
    public String getPyamentLink(PaymentDTO payDetails) throws StripeException;
}
