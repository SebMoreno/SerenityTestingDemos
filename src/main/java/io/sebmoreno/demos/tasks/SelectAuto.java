package io.sebmoreno.demos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static io.sebmoreno.demos.userinterfaces.CarsResultsDestinoJet.CAR_TYPE_BUTTON;
import static io.sebmoreno.demos.userinterfaces.CarsResultsDestinoJet.RESERVE_OPTION;

public class SelectAuto implements Task {
	private final String carType;
	private final String position;


	public SelectAuto(String carType, String position) {
		this.carType = carType;
		this.position = position;
	}

	public static SelectAuto from(String carType, String position) {
		return Tasks.instrumented(SelectAuto.class, carType, position);
	}

	public static SelectAuto fromTheTop(String carType) {
		return Tasks.instrumented(SelectAuto.class, carType, "1");
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Click.on(CAR_TYPE_BUTTON.of(carType)),
			Click.on(RESERVE_OPTION.of(position))
		);
	}
}
