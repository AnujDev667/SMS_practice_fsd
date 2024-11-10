package com.designpatterns.factory;

public class PaymentFactory {
    public static Payment getInstance(PaymentType paymentType) {
        switch (paymentType) {
            case UPI:
                return new UpiPayment();
            case NEFT:
                return new NeftPayment();
            case RTGS:
                return new RtgsPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type");
        }
    }
}
