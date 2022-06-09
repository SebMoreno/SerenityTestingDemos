package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationDestinoJetPage {
	public static final Target RESERVE_LABEL = Target.the("label con el código de reserva").locatedBy("//*[@class='carsConfirmationBox__reserveCode']");
	public static final Target FAILED_RESERVE_MODAL_LABEL = Target.the("label del modal de reserva fallida").locatedBy("//*[contains(@class,'sweet-alert')]/p");
}
