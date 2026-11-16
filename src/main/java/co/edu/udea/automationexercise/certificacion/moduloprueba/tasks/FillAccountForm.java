package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.models.UserData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.SignupFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class FillAccountForm implements Task {

    private final UserData user;

    public FillAccountForm(UserData user) {
        this.user = user;
    }

    public static FillAccountForm with(UserData user) {
        return Tasks.instrumented(FillAccountForm.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CloseAds.ifPresent(),
                Enter.theValue(user.getPassword()).into(SignupFormPage.PASSWORD),
                Enter.theValue(user.getFirstName()).into(SignupFormPage.FIRST_NAME),
                Enter.theValue(user.getLastName()).into(SignupFormPage.LAST_NAME),
                Enter.theValue(user.getAddress()).into(SignupFormPage.ADDRESS),
                SelectFromOptions.byVisibleText(user.getCountry()).from(SignupFormPage.COUNTRY),
                Enter.theValue(user.getState()).into(SignupFormPage.STATE),
                Enter.theValue(user.getCity()).into(SignupFormPage.CITY),
                Enter.theValue(user.getZipcode()).into(SignupFormPage.ZIPCODE),
                Enter.theValue(user.getMobile()).into(SignupFormPage.MOBILE),
                Pause.forAMoment(),
                Click.on(SignupFormPage.CREATE_ACCOUNT));
    }
}
