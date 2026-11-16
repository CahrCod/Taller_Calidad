package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenTheStore implements Task {

    public static OpenTheStore home() {
        return Tasks.instrumented(OpenTheStore.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().thePageNamed("pages.automationUrl"),
                WaitUntil.the(HomePage.SIGNUP_LOGIN_LINK, isVisible()).forNoMoreThan(20).seconds(),
                CloseAds.ifPresent(),
                Pause.forAMoment());
    }
}
