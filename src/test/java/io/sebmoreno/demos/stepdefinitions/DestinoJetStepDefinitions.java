package io.sebmoreno.demos.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.sebmoreno.demos.models.CheckoutInfo;
import io.sebmoreno.demos.models.SearchInfo;
import io.sebmoreno.demos.tasks.InsertInfo;
import io.sebmoreno.demos.tasks.SearchAuto;
import io.sebmoreno.demos.tasks.SelectAuto;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.CONFIRM_RESERVE_BUTTON;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.RESERVE_BUTTON;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.TYC_CHECKBOX;
import static io.sebmoreno.demos.userinterfaces.ConfirmationDestinoJetPage.FAILED_RESERVE_MODAL_LABEL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class DestinoJetStepDefinitions {

	@When("Busca el alquiler de un automovil con la siguiente informacion")
	public void buscaElAlquilerDeUnAutomovilConLaSiguienteInformacion(SearchInfo searchInfo) {
		theActorInTheSpotlight().attemptsTo(
			SearchAuto.with(searchInfo),
			SelectAuto.fromTheTop(searchInfo.carType())
		);
	}

	@And("Ingresa los datos de reserva")
	public void ingresaLosDatosDeReserva(CheckoutInfo checkoutInfo) {
		theActorInTheSpotlight().attemptsTo(
			InsertInfo.with(checkoutInfo.passenger()),
			InsertInfo.with(checkoutInfo.facturingPerson()),
			InsertInfo.with(checkoutInfo.cardHolder()),
			CheckCheckbox.of(TYC_CHECKBOX),
			Click.on(RESERVE_BUTTON),
			WaitUntil.the(CONFIRM_RESERVE_BUTTON, isVisible()),
			Click.on(CONFIRM_RESERVE_BUTTON)
		);
	}

	@Then("Valida que se haya fallado en la reserva del auto")
	public void validaQueSeHayaFalladoEnLaReservaDelAuto() {
		theActorInTheSpotlight().attemptsTo(
			WaitUntil.the(FAILED_RESERVE_MODAL_LABEL, isVisible()).forNoMoreThan(20).seconds()
		);
		theActorInTheSpotlight().should(
			seeThat(Text.of(FAILED_RESERVE_MODAL_LABEL).asString(), containsString("La reserva no fue confirmada, por favor intente de nuevo."))
		);
	}


}
