package io.sebmoreno.demos.models;

public record CheckoutInfo(Passenger passenger,
                           FacturingPerson facturingPerson,
                           CardHolder cardHolder) {
}
