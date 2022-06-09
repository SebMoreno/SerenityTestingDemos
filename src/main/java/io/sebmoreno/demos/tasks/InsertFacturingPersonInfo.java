package io.sebmoreno.demos.tasks;

import io.sebmoreno.demos.models.FacturingPerson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.ADDRESS_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.FAC_CELLNUMBER_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.FAC_DOC_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.FAC_DOC_TYPE_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.FAC_FIRSTNAME_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.FAC_LASTNAME_INPUT;

public class InsertFacturingPersonInfo implements Task {
	final FacturingPerson facturingPerson;

	public InsertFacturingPersonInfo(FacturingPerson facturingPerson) {
		this.facturingPerson = facturingPerson;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Enter.theValue(facturingPerson.firstName()).into(FAC_FIRSTNAME_INPUT),
			Enter.theValue(facturingPerson.lastName()).into(FAC_LASTNAME_INPUT),
			SelectFromOptions.byValue(facturingPerson.docType()).from(FAC_DOC_TYPE_DROPDOWN),
			Enter.theValue(facturingPerson.docNum()).into(FAC_DOC_INPUT),
			Enter.theValue(facturingPerson.address()).into(ADDRESS_INPUT),
			Enter.theValue(facturingPerson.cellnumber()).into(FAC_CELLNUMBER_INPUT)
		);
	}
}
