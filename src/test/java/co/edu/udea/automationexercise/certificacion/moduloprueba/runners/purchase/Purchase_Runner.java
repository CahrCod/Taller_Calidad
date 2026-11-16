package co.edu.udea.automationexercise.certificacion.moduloprueba.runners.purchase;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/purchase/Purchase.feature",
        glue = {"co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.hooks",
                "co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.common",
                "co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.purchase"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Purchase_Runner {}
