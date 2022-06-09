package io.sebmoreno.demos.models;

public record SearchInfo(String place,
                         String initialDate,
                         String initialHour,
                         String finalDate,
                         String finalHour,
                         String discount,
                         String carType) {
}
