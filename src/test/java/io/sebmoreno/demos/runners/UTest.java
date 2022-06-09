package io.sebmoreno.demos.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	glue = {"io.sebmoreno.demos.stepdefinitions", "io.sebmoreno.demos.utils"},
	features = "src/test/resources/features/utest.feature",
	snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class UTest {
}
