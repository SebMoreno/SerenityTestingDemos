package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomeDestinoJet {
	public static final Target CAR_SECTION_BUTTON = Target.the("botón para ir a la sección de alquiler de autos").locatedBy("//*[@data-product='Car']//a");
	public static final Target PLACE_INPUT = Target.the("input para el lugar de recogida del auto").locatedBy("id:PickUpLocation");
	public static final Target INITIAL_DATE_INPUT = Target.the("input para la fecha de recogida del auto").locatedBy("id:PickUpDate");
	public static final Target INITIAL_HOUR_DROPDOWN = Target.the("dropdown para la hora de recogida del auto").locatedBy("id:PickUpTime");
	public static final Target FINAL_DATE_INPUT = Target.the("input para la fecha de entrega del auto").locatedBy("id:DropOffDate");
	public static final Target FINAL_HOUR_DROPDOWN = Target.the("dropdown para la hora de entrega del auto").locatedBy("id:DropOffTime");
	public static final Target DISCOUNT_DROPDOWN = Target.the("dropdown para seleccionar el descuento").locatedBy("id:corporateDiscount");
	public static final Target SEARCH_BUTTON = Target.the("botón de buscar").locatedBy("id:cars-trigger");
	public static final Target SUGGESTION = Target.the("botón de buscar").locatedBy(".tt-suggestion.tt-selectable");
}
