package io.sebmoreno.demos.models;

public record PersonalData(String firstName,
                           String lastName,
                           String email,
                           String birthMonth,
                           String birthDay,
                           String birthYear,
                           String city,
                           String zipCode,
                           String password,
                           String[] languages) {
}
