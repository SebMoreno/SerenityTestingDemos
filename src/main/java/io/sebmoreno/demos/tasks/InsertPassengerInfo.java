package io.sebmoreno.demos.tasks;


import io.sebmoreno.demos.models.Passenger;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.BIRTH_DAY_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.BIRTH_MONTH_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.BIRTH_YEAR_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.CELLNUMBER_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.COMENTARY_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.DOC_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.DOC_TYPE_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.EMAIL_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.FIRSTNAME_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.GENDER_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.LASTNAME_INPUT;

public class InsertPassengerInfo implements Task {
	final Passenger passenger;

	public InsertPassengerInfo(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			SelectFromOptions.byVisibleText(passenger.gender()).from(GENDER_DROPDOWN),
			Enter.theValue(passenger.firstName()).into(FIRSTNAME_INPUT),
			Enter.theValue(passenger.lastName()).into(LASTNAME_INPUT),
			SelectFromOptions.byValue(passenger.docType()).from(DOC_TYPE_DROPDOWN),
			Enter.theValue(passenger.docNum()).into(DOC_INPUT),
			SelectFromOptions.byVisibleText(passenger.birthMonth()).from(BIRTH_MONTH_DROPDOWN),
			SelectFromOptions.byVisibleText(passenger.birthDay()).from(BIRTH_DAY_DROPDOWN),
			SelectFromOptions.byVisibleText(passenger.birthYear()).from(BIRTH_YEAR_DROPDOWN),
			Enter.theValue(passenger.email()).into(EMAIL_INPUT),
			Enter.theValue(passenger.cellnumber()).into(CELLNUMBER_INPUT),
			Enter.theValue(passenger.comentary()).into(COMENTARY_INPUT)
		);
	}
}
