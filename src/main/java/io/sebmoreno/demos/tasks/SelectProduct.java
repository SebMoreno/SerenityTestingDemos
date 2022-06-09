package io.sebmoreno.demos.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static io.sebmoreno.demos.userinterfaces.DieselHomePage.AD_CLOSE_BUTTON;
import static io.sebmoreno.demos.userinterfaces.DieselHomePage.BTN_COMPRAR;
import static io.sebmoreno.demos.userinterfaces.DieselHomePage.BTN_DRESS;
import static io.sebmoreno.demos.userinterfaces.DieselHomePage.BTN_MEN;
import static io.sebmoreno.demos.userinterfaces.DieselHomePage.BTN_SHIRTS;
import static io.sebmoreno.demos.userinterfaces.DieselHomePage.CAMISA;
import static io.sebmoreno.demos.userinterfaces.DieselHomePage.TALLA;
import static io.sebmoreno.demos.userinterfaces.DieselShoppingCartPage.BTN_FINALIZAR_COMPRA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectProduct implements Task {
	String indexOfProduct;
	String size;

	public SelectProduct(int indexOfProduct, String size) {
		this.indexOfProduct = String.valueOf(indexOfProduct);
		this.size = size;
	}

	public static SelectProduct withSpecs(int indexOfProduct, String size) {
		return Instrumented.instanceOf(SelectProduct.class).withProperties(indexOfProduct, size);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Check.whether(WebElementQuestion.stateOf(AD_CLOSE_BUTTON), isVisible())
				.andIfSo(Click.on(AD_CLOSE_BUTTON)),
			MoveMouse.to(BTN_MEN),
			MoveMouse.to(BTN_DRESS),
			Click.on(BTN_SHIRTS),
			Check.whether(WebElementQuestion.stateOf(AD_CLOSE_BUTTON), isVisible())
				.andIfSo(Click.on(AD_CLOSE_BUTTON)),
			Click.on(CAMISA.of(indexOfProduct)),
			Click.on(TALLA.of(size)),
			Click.on(BTN_COMPRAR),
			Click.on(BTN_FINALIZAR_COMPRA)
		);
	}
}
