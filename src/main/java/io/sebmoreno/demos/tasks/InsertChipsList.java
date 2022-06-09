package io.sebmoreno.demos.tasks;

import java.util.Arrays;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class InsertChipsList implements Task {
	private final String[] chips;
	private final Target target;

	public InsertChipsList(String[] chips, Target target) {
		this.chips = Arrays.copyOf(chips, chips.length);
		this.target = target;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Arrays.stream(chips).forEach(chip -> actor.attemptsTo(Enter.theValue(chip).into(target).thenHit(Keys.ENTER)));
	}
}
