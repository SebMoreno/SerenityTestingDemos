package io.sebmoreno.demos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginGuruPage {
	public static final Target INPUT_USER_NAME = Target.the("el nombre de usuario").locatedBy("name:uid");
	public static final Target INPUT_PASSWORD = Target.the("el password de usuario").locatedBy("name:password");
	public static final Target BUTTON_LOGIN = Target.the("en el botón Login").locatedBy("//*[@value='LOGIN']");
	public static final Target TITLE = Target.the("el título de la página")
		.locatedBy("//*[text()='Manger Id : mgr123']");
}
