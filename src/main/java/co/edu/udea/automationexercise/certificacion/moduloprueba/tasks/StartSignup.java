package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class StartSignup implements Task {

    private final String name;
    private final String email;

    public StartSignup(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static StartSignup with(String name, String email) {
        return Tasks.instrumented(StartSignup.class, name, email);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.SIGNUP_LOGIN_LINK),
                Enter.theValue(name).into(LoginPage.SIGNUP_NAME),
                Enter.theValue(email).into(LoginPage.SIGNUP_EMAIL),
                Pause.forAMoment(),
                Click.on(LoginPage.SIGNUP_BUTTON));
    }
}
