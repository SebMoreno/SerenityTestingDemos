package io.sebmoreno.demos.questions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sebmoreno.demos.models.UserRest;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class UserRestResponse implements Question<UserRest> {
	public static UserRestResponse state() {
		return new UserRestResponse();
	}

	@Override
	public UserRest answeredBy(Actor actor) {
		ObjectMapper obMapper = new ObjectMapper();
		obMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return SerenityRest.lastResponse().jsonPath().getObject("data", UserRest.class);
	}
}
