package co.edu.udea.automationexercise.certificacion.moduloprueba.runners.cart;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/cart/Cart.feature",
        glue = {"co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.hooks",
                "co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.common",
                "co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.cart"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Cart_Runner {}
