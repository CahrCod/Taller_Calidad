package co.edu.udea.automationexercise.certificacion.moduloprueba.runners.register;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/register/Register_user.feature",
        glue = {"co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.hooks", "co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.register"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Register_user_Runner {}