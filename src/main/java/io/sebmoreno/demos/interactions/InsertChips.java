package io.sebmoreno.demos.interactions;

import io.sebmoreno.demos.tasks.InsertChipsList;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class InsertChips {
	private final String[] chips;

	public InsertChips(String[] chips) {
		this.chips = chips;
	}

	public static InsertChips list(String[] chips) {
		return new InsertChips(chips);
	}

	public InsertChipsList into(Target target) {
		return Tasks.instrumented(InsertChipsList.class, chips, target);
	}
}

