package io.sebmoreno.demos.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.sebmoreno.demos.tasks.Login;
import net.serenitybdd.screenplay.questions.Text;

import static io.sebmoreno.demos.userinterfaces.LoginGuruPage.TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class GuruLoginStepDefinition {

	@When("Ingresa nombre de usuario {string} y password {string}")
	public void ingresaNombreDeUsuarioYPassword(String user, String password) {
		theActorInTheSpotlight().attemptsTo(Login.withCredentials(user, password));
	}

	@Then("Valida que el titulo sea {string}")
	public void validaQueElTituloSea(String expectedTitle) {
		theActorInTheSpotlight().should(
			seeThat(Text.of(TITLE), equalTo(expectedTitle))
				.orComplainWith(
					AssertionError.class,
					"El texto: '%s', no es igual al obtenido: '%s'"
						.formatted(expectedTitle, Text.of(TITLE).answeredBy(theActorInTheSpotlight()))
				)
		);
	}
}
