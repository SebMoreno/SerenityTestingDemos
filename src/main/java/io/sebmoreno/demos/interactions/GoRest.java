package io.sebmoreno.demos.interactions;

import java.util.Map;

public class GoRest {

    public static void setUrl(String url) {
        RestInteraction.setUrl(url);
    }

    public static void createUser(String endpoint, Map<String, String> data) {
        RestInteraction.post(endpoint, data);
    }

    public static void modifiqueUserName(String endpoint, Map<String, String> data) {
        RestInteraction.patch(endpoint, data);
    }

    public static void modifiqueUserData(String endpoint, Map<String, String> data) {
        RestInteraction.put(endpoint, data);
    }

    public static void getUserData(String endpoint) {
        RestInteraction.get(endpoint);
    }

    public static void deleteUserData(String endpoint) {
        RestInteraction.delete(endpoint);
    }

    public static void validateResponse(int responseCode) {
        RestInteraction.validateResponse(responseCode);
    }
}
