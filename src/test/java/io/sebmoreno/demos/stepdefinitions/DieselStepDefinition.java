package io.sebmoreno.demos.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.sebmoreno.demos.models.DieselPaymentData;
import io.sebmoreno.demos.models.DieselUser;
import io.sebmoreno.demos.tasks.InsertDieselPaymentData;
import io.sebmoreno.demos.tasks.SelectProduct;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.APELLIDO;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.BTN_CONTINUAR;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.BTN_GO_PAY;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.BTN_GO_SHIPPING;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.CEDULA;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.CORREO;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.DEPARTAMENTO;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.DIRECCION;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.MODAL_FINAL;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.MUNICIPIO;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.NOMBRE;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.TELEFONO;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.TYC_CHECK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class DieselStepDefinition {

	@Given("selecciona la camiseta numero {int} y inicia su compra con la talla {string}")
	public void seleccionaUnaCamisetaYIniciaSuCompraConLaTalla(int indexOfProduct, String size) {
		theActorInTheSpotlight().attemptsTo(SelectProduct.withSpecs(indexOfProduct, size));
	}

	@When("Ingresa datos propios")
	public void finalizaCompra(DieselUser dieselUser) {
		theActorInTheSpotlight().attemptsTo(
			Enter.theValue(dieselUser.correo()).into(CORREO),
			Click.on(BTN_CONTINUAR),
			Enter.theValue(dieselUser.nombre()).into(NOMBRE),
			Enter.theValue(dieselUser.apellido()).into(APELLIDO),
			Enter.theValue(dieselUser.cedula()).into(CEDULA),
			Enter.theValue(dieselUser.telefono()).into(TELEFONO),
			MoveMouse.to(TYC_CHECK),
			Click.on(TYC_CHECK),
			Click.on(BTN_GO_SHIPPING),
			Enter.theValue(dieselUser.direccion()).into(DIRECCION),
			SelectFromOptions.byVisibleText(dieselUser.departamento()).from(DEPARTAMENTO),
			SelectFromOptions.byVisibleText(dieselUser.municipio()).from(MUNICIPIO),
			Click.on(BTN_GO_PAY)
		);
	}

	@And("Ingresa datos de pago y finaliza la compra")
	public void ingresaDatosDePagoYFinalizaLaCompra(DieselPaymentData dieselPaymentData) {
		theActorInTheSpotlight().attemptsTo(InsertDieselPaymentData.withThese(dieselPaymentData));
	}

	@Then("Valida que aparezca el mensaje {string}")
	public void validaQueAparezcaElMensaje(String msg) {
		theActorInTheSpotlight().wasAbleTo(WaitUntil.the(MODAL_FINAL, isVisible()).forNoMoreThan(20).seconds());
		theActorInTheSpotlight().should(seeThat(Text.of(MODAL_FINAL).asString(), equalTo(msg)));
	}
}
