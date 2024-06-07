package com.neog.paymentservice.service;

import com.neog.paymentservice.model.PaymentDTO;

public interface PaymentService {
    public String getPyamentLink(PaymentDTO payDetails);
}
