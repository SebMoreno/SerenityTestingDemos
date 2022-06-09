package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DieselCheckoutPage {
	public static final Target CORREO = Target.the("input del correo del usuario").locatedBy("id:client-pre-email");
	public static final Target BTN_CONTINUAR= Target.the("botón para continuar").locatedBy("//*[text()='Continuar']");
	public static final Target NOMBRE = Target.the("input del nombre de usuario").locatedBy("id:client-first-name");
	public static final Target APELLIDO = Target.the("input del apellido de usuario").locatedBy("id:client-last-name");
	public static final Target CEDULA = Target.the("input de cédula de usuario").locatedBy("id:client-document");
	public static final Target TELEFONO = Target.the("input del teléfono de usuario").locatedBy("id:client-phone");
	public static final Target TYC_CHECK = Target.the("checkbox de términos y condiciones").locatedBy("id:checkboxTyc");
	public static final Target BTN_GO_SHIPPING = Target.the("botón para ir a zona de envío").locatedBy("id:go-to-shipping");
	public static final Target DIRECCION = Target.the("input de la diracción de usuario").locatedBy("id:ship-street");
	public static final Target DEPARTAMENTO = Target.the("input del departamento de usuario").locatedBy("id:ship-state");
	public static final Target MUNICIPIO = Target.the("input del municipio de usuario").locatedBy("id:ship-city");
	public static final Target BTN_GO_PAY = Target.the("botón para ir a zona de envío").locatedBy("//*[@id='shipping-data']//button[text()='Ir para el Pago']");
	public static final Target INPUT_CCARD = Target.the("Número de la tarjeta").locatedBy("id:creditCardpayment-card-0Number");
	public static final Target OPT_CUOT = Target.the("Cantidad de cuotas").locatedBy("id:creditCardpayment-card-0Brand");
	public static final Target INPUT_NAMES = Target.the("Nombre y apellido dueño tarjeta").locatedBy("id:creditCardpayment-card-0Name");
	public static final Target OPT_MONTH = Target.the("Fecha mes de vencimiento de la cuenta").locatedBy("id:creditCardpayment-card-0Month");
	public static final Target OPT_YEAR = Target.the("Fecha año de vencimiento de la cuenta").locatedBy("id:creditCardpayment-card-0Year");
	public static final Target INPUT_COD = Target.the("Codigo de seguridad").locatedBy("id:creditCardpayment-card-0Code");
	public static final Target INPUT_CC = Target.the("Cedula del pagador").locatedBy("id:holder-document-0");
	public static final Target BTN_BUY_NOW = Target.the("Comprar ahora").locatedBy("(//*[@id='payment-data-submit'])[2]");
	public static final Target MODAL_FINAL = Target.the("Modal de mensaje de error final").locatedBy("//*[@class='payment-unauthorized-hello']");
}
