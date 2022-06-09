package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DieselShoppingCartPage {
	public static final Target BTN_FINALIZAR_COMPRA = Target.the("en el boton hombre").locatedBy("//*[text()='Finalizar compra']");
	public static final Target CORREO = Target.the("el correo de usuario").locatedBy("id:client-pre-email");
	public static final Target BTN_CONTINUAR= Target.the("el correo de usuario").locatedBy("//*[text()='Continuar']");

}
