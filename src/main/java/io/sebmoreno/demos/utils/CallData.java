package io.sebmoreno.demos.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;


public class CallData {

    public static String getData(String data) {
        return SerenityRest.lastResponse().getBody().jsonPath().get(data).toString();
    }

    public static void setData(String key, String value){
        Serenity.setSessionVariable(key).to(getData(value));
    }

}
