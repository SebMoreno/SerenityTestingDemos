package io.sebmoreno.demos.tasks;

import io.sebmoreno.demos.models.CardHolder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.CARD_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.CVC_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.EXPIRATION_MONTH_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.EXPIRATION_YEAR_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.HOLDER_DOCTYPE_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.HOLDER_DOC_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.HOLDER_FIRSTNAME_INPUT;
import static io.sebmoreno.demos.userinterfaces.CheckoutDestinoJetPage.HOLDER_LASTNAME_INPUT;

public class InsertCardHolderInfo implements Task {
	final CardHolder cardHolder;

	public InsertCardHolderInfo(CardHolder cardHolder) {
		this.cardHolder = cardHolder;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Enter.theValue(cardHolder.firstName()).into(HOLDER_FIRSTNAME_INPUT),
			Enter.theValue(cardHolder.lastName()).into(HOLDER_LASTNAME_INPUT),
			SelectFromOptions.byValue(cardHolder.docType()).from(HOLDER_DOCTYPE_DROPDOWN),
			Enter.theValue(cardHolder.docNum()).into(HOLDER_DOC_INPUT),
			SelectFromOptions.byVisibleText(cardHolder.expirationMonth()).from(EXPIRATION_MONTH_DROPDOWN),
			SelectFromOptions.byVisibleText(cardHolder.expirationYear()).from(EXPIRATION_YEAR_DROPDOWN),
			Enter.theValue(cardHolder.cvc()).into(CVC_INPUT),
			Enter.theValue(cardHolder.cardNum()).into(CARD_INPUT)
		);
	}
}
