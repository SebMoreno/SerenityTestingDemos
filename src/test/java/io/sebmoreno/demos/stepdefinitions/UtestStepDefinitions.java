package io.sebmoreno.demos.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.sebmoreno.demos.interactions.InsertChips;
import io.sebmoreno.demos.models.PersonalData;
import java.util.Random;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;


public class UtestStepDefinitions {

	@When("Ingresa todos los datos de registro")
	public void ingresaTodosLosDatosDeRegistro(PersonalData personalData) {
		theActorInTheSpotlight().attemptsTo(
			Click.on(BECOME_A_TESTER_BUTTON),
			Enter.theValue(personalData.firstName()).into(FIRSTNAME_INPUT),
			Enter.theValue(personalData.lastName()).into(LASTNAME_INPUT),
			Enter.theValue(new Random().nextInt() + personalData.email()).into(EMAIL_INPUT),
			SelectFromOptions.byVisibleText(personalData.birthMonth()).from(BIRTH_MONTH_DROPDOWN),
			SelectFromOptions.byVisibleText(personalData.birthDay()).from(BIRTH_DAY_DROPDOWN),
			SelectFromOptions.byVisibleText(personalData.birthYear()).from(BIRTH_YEAR_DROPDOWN),
			InsertChips.list(personalData.languages()).into(LANGUAGES_INPUT),
			Click.on(ADDRESS_STEP_BUTTON),
			Enter.theValue(personalData.city()).into(CITY_INPUT),
			Hit.the(Keys.ARROW_DOWN, Keys.ENTER).into(CITY_INPUT),
			Enter.theValue(personalData.zipCode()).into(ZIP_INPUT),
			Click.on(DEVICES_STEP_BUTTON),
			Click.on(LAST_STEP_BUTTON),
			Enter.theValue(personalData.password()).into(PASSWORD_INPUT),
			Enter.theValue(personalData.password()).into(CONFIRM_PASSWORD_INPUT),
			CheckCheckbox.of(TERMS_OF_USE_CHECKBOX),
			CheckCheckbox.of(PRIVACY_CHECKBOX),
			Click.on(COMPLETE_BUTTON)
		);
	}

	@Then("Valida que aparezca el mensaje de confirmación {string}")
	public void validaQueAparezcaElMensajeDeConfirmacion(String msg) {
		theActorInTheSpotlight().wasAbleTo(WaitUntil.the(WELCOME_MESSAGE, isVisible()).forNoMoreThan(3).seconds());
		theActorInTheSpotlight().should(seeThat(Text.of(WELCOME_MESSAGE), equalTo(msg)));
	}
}
