package com.neog.paymentservice.service;

import com.neog.paymentservice.model.PaymentDTO;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentImpl implements  PaymentService {

    @Override
    public String getPyamentLink(PaymentDTO payDetails) {
        return "stripr url";
    }

}
