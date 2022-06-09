package io.sebmoreno.demos.utils;

import io.cucumber.java.DataTableType;
import io.sebmoreno.demos.models.CardHolder;
import io.sebmoreno.demos.models.CheckoutInfo;
import io.sebmoreno.demos.models.DieselPaymentData;
import io.sebmoreno.demos.models.DieselUser;
import io.sebmoreno.demos.models.FacturingPerson;
import io.sebmoreno.demos.models.Passenger;
import io.sebmoreno.demos.models.PersonalData;
import io.sebmoreno.demos.models.SearchInfo;
import io.sebmoreno.demos.models.UserRest;
import java.util.Map;

public class Hooks {
	@DataTableType
	public SearchInfo getSearchInfo(Map<String, String> data) {
		return new SearchInfo(
			data.get("place"),
			data.get("initialDate"),
			data.get("initialHour"),
			data.get("finalDate"),
			data.get("finalHour"),
			data.get("discount"),
			data.get("carType")
		);
	}

	@DataTableType
	public CheckoutInfo getCheckoutInfo(Map<String, String> data) {
		return new CheckoutInfo(
			new Passenger(
				data.get("gender"),
				data.get("firstName"),
				data.get("lastName"),
				data.get("docType"),
				data.get("docNum"),
				data.get("birthMonth"),
				data.get("birthDay"),
				data.get("birthYear"),
				data.get("email"),
				data.get("cellnumber"),
				data.get("comentary")
			),
			new FacturingPerson(
				data.get("firstName"),
				data.get("lastName"),
				data.get("docType"),
				data.get("docNum"),
				data.get("address"),
				data.get("cellnumber")
			),
			new CardHolder(
				data.get("firstName"),
				data.get("lastName"),
				data.get("docType"),
				data.get("docNum"),
				data.get("expirationMonth"),
				data.get("expirationYear"),
				data.get("cvc"),
				data.get("cardNum")
			)
		);
	}

	@DataTableType
	public DieselUser getDieselUser(Map<String, String> data) {
		return new DieselUser(
			data.get("correo"),
			data.get("nombre"),
			data.get("apellido"),
			data.get("cedula"),
			data.get("telefono"),
			data.get("direccion"),
			data.get("departamento"),
			data.get("municipio")
		);
	}

	@DataTableType
	public DieselPaymentData getDieselPaymentData(Map<String, String> data) {
		return new DieselPaymentData(
			data.get("expirationdate"),
			data.get("numbercard"),
			data.get("feesamount"),
			data.get("fullname"),
			data.get("cvc"),
			data.get("cedula")
		);
	}

	@DataTableType
	public UserRest getUserRest(Map<String, String> data) {
		return new UserRest(
			data.get("name"),
			data.get("email"),
			data.get("gender"),
			data.get("status"),
			Integer.parseInt(data.get("id"))
		);
	}

	@DataTableType
	public PersonalData getPersonalData(Map<String, String> data) {
		return new PersonalData(
			data.get("firstName"),
			data.get("lastName"),
			data.get("email"),
			data.get("birthMonth"),
			data.get("birthDay"),
			data.get("birthYear"),
			data.get("city"),
			data.get("zipCode"),
			data.get("password"),
			data.get("languages").split(";")
		);
	}
}
