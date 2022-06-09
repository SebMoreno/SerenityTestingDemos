package io.sebmoreno.demos.stepdefinitions;

import com.ibm.as400.access.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.sebmoreno.demos.models.UserRest;
import io.sebmoreno.demos.questions.UserRestResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static io.sebmoreno.demos.utils.Constants.TOKEN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.comparesEqualTo;

public class GoRestStepDefinition {
	@Given("{string} desea construir una petición en gorest con uri {string}")
	public void deseaConstruirUnaPeticionEnGorestConUri(String actorName, String baseUrl) {
		theActorCalled(actorName).whoCan(CallAnApi.at(baseUrl));
	}

	@When("Realiza un GET al endpoint {string}")
	public void realizaUnGETAlEndpoint(String endpoint) {
		theActorInTheSpotlight().attemptsTo(
			Get.resource(endpoint).with(request -> request.auth().oauth2(TOKEN))
		);
	}

	@Then("Valida que el codigo de estado sea {int} y los datos correspondan")
	public void validaQueElCodigoDeEstadoSeaYLosDatosCorrespondan(int code, UserRest user) {
		System.out.println(user);
		System.out.println(SerenityRest.lastResponse().jsonPath().get("data").toString());
		System.out.println(SerenityRest.lastResponse().jsonPath().getObject("data", UserRest.class));
		theActorInTheSpotlight().should(
			seeThatResponse(response -> response.statusCode(code)),
			seeThat(UserRestResponse.state(), comparesEqualTo(user))
		);
	}
}
