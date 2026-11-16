package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/** Inicia sesión con email y contraseña desde el formulario "Login to your account". */
public class LogIn implements Task {

    private final String email;
    private final String password;

    public LogIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LogIn with(String email, String password) {
        return Tasks.instrumented(LogIn.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(LoginPage.URL),
                CloseAds.ifPresent(),
                Enter.theValue(email).into(LoginPage.LOGIN_EMAIL),
                Enter.theValue(password).into(LoginPage.LOGIN_PASSWORD),
                Pause.forAMoment(),
                Click.on(LoginPage.LOGIN_BUTTON),
                WaitUntil.the(HomePage.LOGGED_IN_AS, isVisible()).forNoMoreThan(15).seconds());
    }
}
