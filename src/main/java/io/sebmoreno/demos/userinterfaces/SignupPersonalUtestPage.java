package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SignupPersonalUtestPage {
	public static Target BECOME_A_TESTER_BUTTON = Target.the("botón para iniciar el ciclo de registro").locatedBy("//*[text()='Become a uTester']");
	public static final Target FIRSTNAME_INPUT = Target.the("input para introducir el nombre").locatedBy("id:firstName");
	public static final Target LASTNAME_INPUT = Target.the("input para introducir el apellido").locatedBy("id:lastName");
	public static final Target EMAIL_INPUT = Target.the("input para introducir el email").locatedBy("id:email");
	public static final Target BIRTH_MONTH_DROPDOWN = Target.the("dropdown para introducir el mes de nacimiento").locatedBy("id:birthMonth");
	public static final Target BIRTH_DAY_DROPDOWN = Target.the("dropdown para introducir el día de nacimiento").locatedBy("id:birthDay");
	public static final Target BIRTH_YEAR_DROPDOWN = Target.the("dropdown para introducir el año de nacimiento").locatedBy("id:birthYear");
	public static final Target LANGUAGES_INPUT = Target.the("input para introducir los lenguajes").locatedBy("//input[@type='search']");
	public static final Target ADDRESS_STEP_BUTTON = Target.the("botón para ir al paso de ingreso de dirección").locatedBy("//*[contains(text(),'Next: Location')]");
	public static final Target FIRSTNAME_ERROR_LABEL = Target.the("label del mesaje de error del input nombre").locatedBy("id:firstNameError");
	public static final Target LASTNAME_ERROR_LABEL = Target.the("label del mesaje de error del input apellido").locatedBy("id:lastNameError");
	public static final Target EMAIL_ERROR_LABEL = Target.the("label del mesaje de error del input email").locatedBy("id:emailError");
	public static final Target BIRTHDATE_ERROR_LABEL = Target.the("label del mesaje de error de la fecha de nacimiento").locatedBy("id:birthDateError");
	public static final Target CITY_INPUT = Target.the("input para introducir la ciudad").locatedBy("id:city");
	public static final Target ZIP_INPUT = Target.the("input para introducir el codigo zip").locatedBy("id:zip");
	public static final Target DEVICES_STEP_BUTTON = Target.the("botón para ir al paso de ingreso de dispositivos").locatedBy("//*[contains(text(),'Next: Devices')]");
	public static final Target CITY_ERROR_LABEL = Target.the("label del mesaje de error del input ciudad").locatedBy("//*[@id='city']/following-sibling::*[contains(@class,'error-msg')]//ng-message");
	public static final Target ZIP_ERROR_LABEL = Target.the("label del mesaje de error del input zip").locatedBy("//*[@id='zip']/following-sibling::*[contains(@class,'error-msg')]//ng-message");
	public static final Target DROPDOWN_OPTION = Target.the("opción general de algún dropdown").locatedBy("//*[contains(text(),'{0}')]");
	public static final Target OS_DROPDOWN = Target.the("botón para abrir las opciones del dropdown de selección de OS").locatedBy("name:osId");
	public static final Target LAST_STEP_BUTTON = Target.the("botón para ir al último paso del registro").locatedBy("//*[contains(text(),'Next: Last Step')]");
	public static final Target OS_ERROR_LABEL = Target.the("label del mesaje de error por no seleccionar ningún dispositivo").locatedBy("//*[@class='btn-inline-error']");
	public static final Target PASSWORD_INPUT = Target.the("input para introducir la contraseña").locatedBy("id:password");
	public static final Target CONFIRM_PASSWORD_INPUT = Target.the("input para introducir la confirmación de la contraseña").locatedBy("id:confirmPassword");
	public static final Target TERMS_OF_USE_CHECKBOX = Target.the("checkbox para aceptar los términos de uso").locatedBy("id:termOfUse");
	public static final Target PRIVACY_CHECKBOX = Target.the("checkbox para aceptar las políticas de seguridad y privacidad").locatedBy("id:privacySetting");
	public static final Target COMPLETE_BUTTON = Target.the("botón para completar la configuración del perfil").locatedBy("id:laddaBtn");
	public static final Target PASSWORD_ERROR_LABEL = Target.the("label del mesaje de error del input password").locatedBy("//*[@id='confirmPassword']/following-sibling::*[@class='error-msg']");
	public static final Target TERMS_ERROR_LABEL = Target.the("label del mesaje de error del checkbox de terminos y condiciones").locatedBy("//*[@id='termOfUse']/following-sibling::*[@class='error-msg']");
	public static final Target POLICYS_ERROR_LABEL = Target.the("label del mesaje de error del checkbox de políticas de seguridad").locatedBy("//*[@id='privacySetting']/following-sibling::*[@class='error-msg']");
	public static final Target WELCOME_MESSAGE = Target.the("mensaje de bienvenida").locatedBy("//*[@id='mainContent']//h1");
}
