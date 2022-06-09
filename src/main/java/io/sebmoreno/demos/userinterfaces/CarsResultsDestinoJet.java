package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CarsResultsDestinoJet {
	public static final Target CAR_TYPE_BUTTON = Target.the("botón del tipo de auto").locatedBy("//label[*//text()='{0}']");
	public static final Target RESERVE_OPTION = Target.the("botón de reserva de auto").locatedBy("(//*[contains(@class,'carRecommendation__action-btn')])[{0}]");
}
