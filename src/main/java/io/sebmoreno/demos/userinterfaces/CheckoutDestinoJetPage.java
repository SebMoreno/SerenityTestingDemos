package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutDestinoJetPage {
	public static final Target GENDER_DROPDOWN = Target.the("dropdown para seleccionar el género").locatedBy("id:Gender-Adult-0");
	public static final Target FIRSTNAME_INPUT = Target.the("input para el nombre").locatedBy("id:FirstName-Adult-0");
	public static final Target LASTNAME_INPUT = Target.the("input para el apellido").locatedBy("id:LastName-Adult-0");
	public static final Target DOC_TYPE_DROPDOWN = Target.the("dropdown para seleccionar el tipo de documento").locatedBy("id:DocumentType-Adult-0");
	public static final Target DOC_INPUT = Target.the("input para el documento").locatedBy("id:EmployeeId-Adult-0");
	public static final Target BIRTH_MONTH_DROPDOWN = Target.the("dropdown para seleccionar el mes de nacimiento").locatedBy("id:Month-Adult-0");
	public static final Target BIRTH_DAY_DROPDOWN = Target.the("dropdown para seleccionar el dia de nacimiento").locatedBy("id:Day-Adult-0");
	public static final Target BIRTH_YEAR_DROPDOWN = Target.the("dropdown para seleccionar el año de nacimiento").locatedBy("id:Year-Adult-0");
	public static final Target EMAIL_INPUT = Target.the("input para el email").locatedBy("id:Email");
	public static final Target CELLNUMBER_INPUT = Target.the("input para el telefono de contacto").locatedBy("id:PhoneNumber");
	public static final Target COMENTARY_INPUT = Target.the("input para el comentario").locatedBy("id:coemntario");
	public static final Target FAC_FIRSTNAME_INPUT = Target.the("input para el nombre de facturación").locatedBy("id:FirstName");
	public static final Target FAC_LASTNAME_INPUT = Target.the("input para el apellido de facturación").locatedBy("id:LastName");
	public static final Target FAC_DOC_TYPE_DROPDOWN = Target.the("dropdown para seleccionar el tipo de documento de facturación").locatedBy("id:DocumentType");
	public static final Target FAC_DOC_INPUT = Target.the("input para el documento de facturación").locatedBy("id:CustomerId");
	public static final Target ADDRESS_INPUT = Target.the("input para la dirección de facturación").locatedBy("id:Address");
	public static final Target FAC_CELLNUMBER_INPUT = Target.the("input para el telefono de facturación").locatedBy("id:Telephone");
	public static final Target HOLDER_FIRSTNAME_INPUT = Target.the("input para el nombre del titular de la tarjeta").locatedBy("id:name");
	public static final Target HOLDER_LASTNAME_INPUT = Target.the("input para el apellido del titular de la tarjeta").locatedBy("id:lastName");
	public static final Target HOLDER_DOCTYPE_DROPDOWN = Target.the("dropdown para el tipo de documento del titular de la tarjeta").locatedBy("id:documentType");
	public static final Target HOLDER_DOC_INPUT = Target.the("input para el documento del titular de la tarjeta").locatedBy("id:employeeId");
	public static final Target EXPIRATION_MONTH_DROPDOWN = Target.the("dropdown para el mes de expiración de la tarjeta").locatedBy("id:expirationMonth");
	public static final Target EXPIRATION_YEAR_DROPDOWN = Target.the("dropdown para el año de expiración de la tarjeta").locatedBy("id:expirationYear");
	public static final Target CVC_INPUT = Target.the("input para el código de seguridad de la tarjeta").locatedBy("id:cvc");
	public static final Target CARD_INPUT = Target.the("input para el número de la tarjeta").locatedBy("id:number");
	public static final Target RESERVE_BUTTON = Target.the("botón para realizar la reserva").locatedBy("//button[text()='Reservar']");
	public static final Target TYC_CHECKBOX = Target.the("checkbox de términos y condiciones").locatedBy("id:term-and-conditions");
	public static final Target CONFIRM_RESERVE_BUTTON = Target.the("botón para confirmar la reserva").locatedBy("//*[@class='confirm']");
}
