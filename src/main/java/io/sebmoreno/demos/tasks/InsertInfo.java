package io.sebmoreno.demos.tasks;

import io.sebmoreno.demos.models.CardHolder;
import io.sebmoreno.demos.models.FacturingPerson;
import io.sebmoreno.demos.models.Passenger;
import net.serenitybdd.screenplay.Tasks;

public class InsertInfo {
	final Passenger passenger;

	public InsertInfo(Passenger passenger) {
		this.passenger = passenger;
	}

	public static InsertPassengerInfo with(Passenger passanger) {
		return Tasks.instrumented(InsertPassengerInfo.class, passanger);
	}

	public static InsertFacturingPersonInfo with(FacturingPerson passenger) {
		return Tasks.instrumented(InsertFacturingPersonInfo.class, passenger);
	}

	public static InsertCardHolderInfo with(CardHolder passenger) {
		return Tasks.instrumented(InsertCardHolderInfo.class, passenger);
	}
}

