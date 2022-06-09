package io.sebmoreno.demos.models;

import org.jetbrains.annotations.NotNull;

public record UserRest(String name,
                       String email,
                       String gender,
                       String status,
                       int id) implements Comparable<UserRest> {
	@Override
	public int compareTo(@NotNull UserRest u) {
		return u.name().equals(name) &&
			u.email().equals(email) &&
			u.gender().equals(gender) &&
			u.status().equals(status) ?
			0 : -1;
	}

	@Override
	public String toString() {
		return "UserRest{" +
			"name='" + name + '\'' +
			", email='" + email + '\'' +
			", gender='" + gender + '\'' +
			", status='" + status + '\'' +
			'}';
	}
}
