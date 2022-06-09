package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DieselHomePage {
	public static final Target AD_CLOSE_BUTTON = Target.the("botón para cerrar anunncio").locatedBy("id:btnNoIdWpnPush");
	public static final Target BTN_MEN = Target.the("botón para opciones para hombre").locatedBy("id:men");
	public static final Target BTN_DRESS = Target.the("botón para elección de ropa").locatedBy("id:aAPPARELm");
	public static final Target BTN_SHIRTS = Target.the("botón de elección de camisetas").locatedBy("//*[@id='aAPPARELm']//*[text()='Camisetas']");
	public static final Target CAMISA = Target.the("imagen de una camiseta en específico").locatedBy("(//*[@class='box-item text-center'])[{0}]");
	public static final Target TALLA = Target.the("talla de un producto").locatedBy("//*[text()='{0}']");
	public static final Target BTN_COMPRAR = Target.the("boton de compra").locatedBy("(//*[@class='buy-button buy-button-ref'])[1]");
}
