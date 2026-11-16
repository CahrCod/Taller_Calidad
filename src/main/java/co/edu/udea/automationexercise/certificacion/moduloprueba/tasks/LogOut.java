package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

/** Cierra la sesión abriendo /logout (no depende de que el menú esté visible ni de anuncios). */
public class LogOut implements Task {

    public static LogOut now() {
        return Tasks.instrumented(LogOut.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(HomePage.LOGOUT_URL),
                CloseAds.ifPresent(),
                Pause.forAMoment());
    }
}
