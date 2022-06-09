package io.sebmoreno.demos.interactions;

import io.restassured.http.ContentType;
import io.sebmoreno.demos.utils.CallData;
import io.sebmoreno.demos.utils.Constants;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class RestInteraction {

	private static String url;
	private static String urlString;


	public static void setUrl(String url) {
		RestInteraction.url = (url);
	}


	public static void post(String endpoint, Map<String, String> data) {
		urlString = url.concat(endpoint);
		SerenityRest.given().auth().oauth2(Constants.TOKEN).contentType(ContentType.JSON).body(data).post(urlString);
		CallData.setData("idUser", "data.id");
		SerenityRest.lastResponse().prettyPeek();
	}

	public static void patch(String endpoint, Map<String, String> data) {
		urlString = url.concat(endpoint);
		SerenityRest.given().auth().oauth2(Constants.TOKEN).contentType(ContentType.JSON).body(data).patch(urlString.concat(Serenity.sessionVariableCalled("idUser")));
		CallData.setData("oldNameUser", "data.name");
		SerenityRest.lastResponse().prettyPeek();
	}

	public static void put(String endpoint, Map<String, String> data) {
		urlString = url.concat(endpoint);
		SerenityRest.given().auth().oauth2(Constants.TOKEN).contentType(ContentType.JSON).body(data).put(urlString.concat(Serenity.sessionVariableCalled("idUser")));
		SerenityRest.lastResponse().prettyPeek();
	}

	public static void get(String endpoint) {
		urlString = url.concat(endpoint);
		SerenityRest.given().auth().oauth2(Constants.TOKEN).get(urlString.concat(Serenity.sessionVariableCalled("idUser")));
		assertNotEquals(Serenity.sessionVariableCalled("oldNameUser"), CallData.getData("data.name"));
		SerenityRest.lastResponse().prettyPeek();
	}

	public static void delete(String endpoint) {
		urlString = url.concat(endpoint);
		SerenityRest.given().auth().oauth2(Constants.TOKEN).delete(urlString.concat(Serenity.sessionVariableCalled("idUser")));
	}

	public static void validateResponse(int responseCode) {
		SerenityRest.lastResponse().prettyPeek();
		if (!(SerenityRest.lastResponse().getBody().jsonPath().get("data.id")).equals("")) {
			assertNotNull(SerenityRest.lastResponse().getBody().jsonPath().get("data.id"));
		}
		assertEquals(responseCode, SerenityRest.lastResponse().statusCode());
	}
}
