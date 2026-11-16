package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.models.UserData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.SignupFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/** Registra un usuario nuevo y se detiene en la página "Account Created!". */
public class RegisterNewUser implements Task {

    /** Clave en la memoria del actor con el usuario creado (la usa Hooks para borrar la cuenta). */
    public static final String REGISTERED_USER = "registeredUser";

    private final UserData user;

    public RegisterNewUser(UserData user) {
        this.user = user;
    }

    public static RegisterNewUser with(UserData user) {
        return Tasks.instrumented(RegisterNewUser.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                StartSignup.with(user.getName(), user.getEmail()),
                FillAccountForm.with(user),
                WaitUntil.the(SignupFormPage.ACCOUNT_CREATED, isVisible()).forNoMoreThan(10).seconds(),
                Pause.forAMoment());
        actor.remember(REGISTERED_USER, user);
    }
}
