package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.SignupFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Pulsa "Continue" tras crear la cuenta y deja al usuario logueado en el inicio.
 * Tras el clic, el sitio a veces muestra un anuncio de pantalla completa que bloquea
 * la navegación; por eso se abre el inicio directamente (la sesión ya está iniciada).
 */
public class ConfirmAccountCreated implements Task {

    public static ConfirmAccountCreated now() {
        return Tasks.instrumented(ConfirmAccountCreated.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SignupFormPage.CONTINUE),
                CloseAds.ifPresent(),
                Open.url(HomePage.URL),
                CloseAds.ifPresent(),
                WaitUntil.the(HomePage.LOGGED_IN_AS, isVisible()).forNoMoreThan(10).seconds(),
                Pause.forAMoment());
    }
}
