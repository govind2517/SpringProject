package com.neog.paymentservice.service;

import com.neog.paymentservice.model.PaymentDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StripePaymentImpl implements  PaymentService {


    @Value("${stripe.api.key}")
    String stripeApiKey;

    @Override
    public String getPyamentLink(PaymentDTO payDetails) throws StripeException {
        Stripe.apiKey = stripeApiKey;

        // generating order-id randomly, because in real time it will come from backend
        String orderId = UUID.randomUUID().toString();
        payDetails.setOrderId(orderId);

        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(payDetails.getAmount())
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName(payDetails.getOrderId()).build()
                        )
                        .build();
        Price price = Price.create(params);
        PaymentLinkCreateParams paramsPayLink =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://stripe.com/in")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(paramsPayLink);
        return paymentLink.getUrl();
    }

}
