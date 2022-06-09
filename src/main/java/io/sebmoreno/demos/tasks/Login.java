package io.sebmoreno.demos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static io.sebmoreno.demos.userinterfaces.LoginGuruPage.BUTTON_LOGIN;
import static io.sebmoreno.demos.userinterfaces.LoginGuruPage.INPUT_PASSWORD;
import static io.sebmoreno.demos.userinterfaces.LoginGuruPage.INPUT_USER_NAME;

public class Login implements Task {

	private final String user;
	private final String password;

	public Login(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public static Login withCredentials(String user, String password) {
		return Tasks.instrumented(Login.class, user, password);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Enter.theValue(user).into(INPUT_USER_NAME),
			Enter.theValue(password).into(INPUT_PASSWORD),
			Click.on(BUTTON_LOGIN)
		);
	}
}
