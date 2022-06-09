package io.sebmoreno.demos.models;

public record FacturingPerson(String firstName,
                              String lastName,
                              String docType,
                              String docNum,
                              String address,
                              String cellnumber) {
}
