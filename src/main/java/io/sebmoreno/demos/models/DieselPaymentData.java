package io.sebmoreno.demos.models;

public record DieselPaymentData(String expirationdate,
                                String numbercard,
                                String feesamount,
                                String fullname,
                                String cvc,
                                String cedula) {
}
