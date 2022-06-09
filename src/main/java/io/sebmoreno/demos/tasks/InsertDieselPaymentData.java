package io.sebmoreno.demos.tasks;

import io.sebmoreno.demos.models.DieselPaymentData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Switch;

import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.BTN_BUY_NOW;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.INPUT_CC;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.INPUT_CCARD;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.INPUT_COD;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.INPUT_NAMES;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.OPT_CUOT;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.OPT_MONTH;
import static io.sebmoreno.demos.userinterfaces.DieselCheckoutPage.OPT_YEAR;

public class InsertDieselPaymentData implements Task {
	private final DieselPaymentData dieselPaymentData;

	public InsertDieselPaymentData(DieselPaymentData dieselPaymentData) {
		this.dieselPaymentData = dieselPaymentData;
	}

	public static InsertDieselPaymentData withThese(DieselPaymentData data) {
		return Tasks.instrumented(InsertDieselPaymentData.class, data);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		var date = dieselPaymentData.expirationdate().split("/");
		actor.attemptsTo(
			Switch.toFrame(0),
			MoveMouse.to(INPUT_CCARD),
			Enter.theValue(dieselPaymentData.numbercard()).into(INPUT_CCARD),
			SelectFromOptions.byValue(dieselPaymentData.feesamount()).from(OPT_CUOT),
			Enter.theValue(dieselPaymentData.fullname()).into(INPUT_NAMES),
			SelectFromOptions.byVisibleText(date[0]).from(OPT_MONTH),
			SelectFromOptions.byVisibleText(date[1]).from(OPT_YEAR),
			Enter.theValue(dieselPaymentData.cvc()).into(INPUT_COD),
			Enter.theValue(dieselPaymentData.cedula()).into(INPUT_CC),
			Switch.toParentFrame(),
			Click.on(BTN_BUY_NOW)
		);
	}
}
