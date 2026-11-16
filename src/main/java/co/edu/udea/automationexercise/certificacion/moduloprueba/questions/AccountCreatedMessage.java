package co.edu.udea.automationexercise.certificacion.moduloprueba.questions;

import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.SignupFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AccountCreatedMessage implements Question<String> {

    public static AccountCreatedMessage text() {
        return new AccountCreatedMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return SignupFormPage.ACCOUNT_CREATED.resolveFor(actor).getText().toUpperCase();
    }
}
