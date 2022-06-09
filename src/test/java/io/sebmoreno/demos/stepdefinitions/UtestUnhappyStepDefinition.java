package io.sebmoreno.demos.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import java.util.Map;
import net.serenitybdd.core.pages.WebElementExpectations;
import net.serenitybdd.core.pages.WebElementResolver;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.TextValue;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.ADDRESS_STEP_BUTTON;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.BECOME_A_TESTER_BUTTON;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.BIRTHDATE_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.BIRTH_DAY_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.BIRTH_MONTH_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.BIRTH_YEAR_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.CITY_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.CITY_INPUT;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.COMPLETE_BUTTON;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.DEVICES_STEP_BUTTON;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.DROPDOWN_OPTION;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.EMAIL_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.EMAIL_INPUT;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.FIRSTNAME_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.FIRSTNAME_INPUT;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.LASTNAME_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.LASTNAME_INPUT;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.LAST_STEP_BUTTON;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.OS_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.OS_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.PASSWORD_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.POLICYS_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.TERMS_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.ZIP_ERROR_LABEL;
import static io.sebmoreno.demos.userinterfaces.SignupPersonalUtestPage.ZIP_INPUT;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEmpty;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEmpty;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.stateOf;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBeNotEmpty;

public class UtestUnhappyStepDefinition {


	@And("Inicia proceso de registro")
	public void iniciaProcesoDeRegistro() {
		theActorInTheSpotlight().attemptsTo(Click.on(BECOME_A_TESTER_BUTTON));
	}

	@When("No ingresa ningún dato e intenta cambiar de paso")
	public void noIngresaNingunDatoEIntentaCambiarDePaso() {
		theActorInTheSpotlight().attemptsTo(Click.on(ADDRESS_STEP_BUTTON));
	}

	@Then("Valida que aparezcan los errores de inputs correspondientes en el paso de información personal")
	public void validaQueAparezcanLosErroresDeInputsCorrespondientes(Map<String, String> errors) {
		theActorInTheSpotlight().should(
			seeThat(Text.of(FIRSTNAME_ERROR_LABEL), equalTo(errors.get("firstName"))),
			seeThat(Text.of(LASTNAME_ERROR_LABEL), equalTo(errors.get("lastName"))),
			seeThat(Text.of(EMAIL_ERROR_LABEL), equalTo(errors.get("email"))),
			seeThat(Text.of(BIRTHDATE_ERROR_LABEL), equalTo(errors.get("birthDate")))
		);
	}

	@When("Ingresa datos validos de información personal")
	public void ingresaDatosValidosDeInformacionPersonal(Map<String, String> personalData) {
		theActorInTheSpotlight().attemptsTo(
			Enter.theValue(personalData.get("firstName")).into(FIRSTNAME_INPUT),
			Enter.theValue(personalData.get("lastName")).into(LASTNAME_INPUT),
			Enter.theValue(personalData.get("email")).into(EMAIL_INPUT),
			SelectFromOptions.byVisibleText(personalData.get("birthMonth")).from(BIRTH_MONTH_DROPDOWN),
			SelectFromOptions.byVisibleText(personalData.get("birthDay")).from(BIRTH_DAY_DROPDOWN),
			SelectFromOptions.byVisibleText(personalData.get("birthYear")).from(BIRTH_YEAR_DROPDOWN),
			Click.on(ADDRESS_STEP_BUTTON)
		);
	}

	@Then("Valida que aparezcan los errores de inputs correspondientes en el paso de direccion")
	public void validaQueAparezcanLosErroresDeInputsCorrespondientesEnElPasoDeDireccion(Map<String, String> errors) {
		theActorInTheSpotlight().should(
			seeThat(Text.of(CITY_ERROR_LABEL), equalTo(errors.get("city"))),
			seeThat(Text.of(ZIP_ERROR_LABEL), equalTo(errors.get("zip")))
		);
	}

	@And("Borra los datos por defecto del paso de dirección")
	public void borraLosDatosPorDefectoDelPasoDeDireccion() {
		theActorInTheSpotlight().attemptsTo(
			Wait.until(actor -> TextValue.of(CITY_INPUT).answeredBy(actor), not(emptyOrNullString())),
			Clear.field(CITY_INPUT),
			Clear.field(ZIP_INPUT)
		);
	}

	@And("Avanza con los valores por defecto del paso de dirección")
	public void avanzaConLosValoresPorDefectoDelPasoDeDireccion() {
		theActorInTheSpotlight().attemptsTo(
			Click.on(DEVICES_STEP_BUTTON)
		);
	}

	@And("Selecciona {string} de la lista de opciones de computadores")
	public void seleccionaDeLaListaDeOpcionesDeComputadores(String option) {
		theActorInTheSpotlight().attemptsTo(
			Click.on(OS_DROPDOWN),
			Click.on(DROPDOWN_OPTION.of(option)),
			Click.on(LAST_STEP_BUTTON)
		);
	}

	@Then("Valida que aparezca el error {string} por no tener ningun dispositivo seleccionado")
	public void validaQueAparezcaElErrorPorNoTenerNingunDispositivoSeleccionado(String error) {
		theActorInTheSpotlight().should(seeThat(Text.of(OS_ERROR_LABEL), equalTo(error)));
	}

	@And("Avanza con los valores por defecto del paso de dispositivos")
	public void avanzaConLosValoresPorDefectoDelPasoDeDispositivos() {
		theActorInTheSpotlight().attemptsTo(Click.on(LAST_STEP_BUTTON));
	}

	@And("Intenta completar el registro")
	public void intentaCompletarElRegistro() {
		theActorInTheSpotlight().attemptsTo(Click.on(COMPLETE_BUTTON));
	}

	@Then("Valida que aparezcan los errores correspondientes del último paso del registro")
	public void validaQueAparezcanLosErroresCorrespondientesDelUltimoPasoDelRegistro(Map<String, String> errors) {
		theActorInTheSpotlight().should(
			seeThat(Text.of(PASSWORD_ERROR_LABEL), equalTo(errors.get("password"))),
			seeThat(Text.of(TERMS_ERROR_LABEL), equalTo(errors.get("terms"))),
			seeThat(Text.of(POLICYS_ERROR_LABEL), equalTo(errors.get("policys")))
		);
	}
}
