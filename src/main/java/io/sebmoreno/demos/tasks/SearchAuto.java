package io.sebmoreno.demos.tasks;


import io.sebmoreno.demos.models.SearchInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.CAR_SECTION_BUTTON;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.DISCOUNT_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.FINAL_DATE_INPUT;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.FINAL_HOUR_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.INITIAL_DATE_INPUT;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.INITIAL_HOUR_DROPDOWN;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.PLACE_INPUT;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.SEARCH_BUTTON;
import static io.sebmoreno.demos.userinterfaces.HomeDestinoJet.SUGGESTION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchAuto implements Task {

	final SearchInfo searchInfo;

	public SearchAuto(SearchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}

	public static SearchAuto with(SearchInfo searchInfo) {
		return Tasks.instrumented(SearchAuto.class, searchInfo);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Click.on(CAR_SECTION_BUTTON),
			Enter.keyValues(searchInfo.place()).into(PLACE_INPUT),
			Clear.field(PLACE_INPUT),
			Enter.theValue(searchInfo.place()).into(PLACE_INPUT),
			Clear.field(PLACE_INPUT),
			Enter.theValue(searchInfo.place()).into(PLACE_INPUT),
			Clear.field(PLACE_INPUT),
			Enter.keyValues(searchInfo.place()).into(PLACE_INPUT),
			Clear.field(PLACE_INPUT),
			Enter.keyValues(searchInfo.place()).into(PLACE_INPUT),
			WaitUntil.the(SUGGESTION, isVisible()).forNoMoreThan(20).seconds(),
			Hit.the(Keys.ARROW_DOWN, Keys.ENTER).into(PLACE_INPUT),
			Enter.theValue(searchInfo.initialDate()).into(INITIAL_DATE_INPUT),
			Hit.the(Keys.ENTER).into(INITIAL_DATE_INPUT),
			SelectFromOptions.byVisibleText(searchInfo.initialHour()).from(INITIAL_HOUR_DROPDOWN),
			Enter.theValue(searchInfo.finalDate()).into(FINAL_DATE_INPUT),
			Hit.the(Keys.ENTER).into(FINAL_DATE_INPUT),
			SelectFromOptions.byVisibleText(searchInfo.finalHour()).from(FINAL_HOUR_DROPDOWN),
			SelectFromOptions.byVisibleText(searchInfo.discount()).from(DISCOUNT_DROPDOWN),
			Click.on(SEARCH_BUTTON)
		);
	}
}
