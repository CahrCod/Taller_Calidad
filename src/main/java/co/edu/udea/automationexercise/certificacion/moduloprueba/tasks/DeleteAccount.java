package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.models.UserData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.DeleteAccountPage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Elimina la cuenta de prueba creada durante el escenario.
 * Si la sesión no está iniciada (por ejemplo, tras un LogOut), primero inicia sesión.
 */
public class DeleteAccount implements Task {

    private final UserData user;

    public DeleteAccount(UserData user) {
        this.user = user;
    }

    public static DeleteAccount of(UserData user) {
        return Tasks.instrumented(DeleteAccount.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(HomePage.URL),
                CloseAds.ifPresent());

        boolean loggedIn = !HomePage.LOGGED_IN_AS.resolveAllFor(actor).isEmpty();
        if (!loggedIn) {
            actor.attemptsTo(LogIn.with(user.getEmail(), user.getPassword()));
        }

        actor.attemptsTo(
                Open.url(DeleteAccountPage.URL),
                WaitUntil.the(DeleteAccountPage.ACCOUNT_DELETED, isVisible()).forNoMoreThan(15).seconds(),
                Pause.forAMoment());
    }
}
