package io.sebmoreno.demos.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CommonStepDefinitions {
	@Before
	public void setup() {
		setTheStage(new OnlineCast());
	}

	@Given("{string} desea ir a la pagina de {string}")
	public void deseaIrALaPaginaDe(String actorName, String url) {
		theActorCalled(actorName).wasAbleTo(Open.url(url));
	}
}
