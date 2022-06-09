package io.sebmoreno.demos.models;

public record CardHolder(String firstName,
                         String lastName,
                         String docType,
                         String docNum,
                         String expirationMonth,
                         String expirationYear,
                         String cvc,
                         String cardNum) {
}
