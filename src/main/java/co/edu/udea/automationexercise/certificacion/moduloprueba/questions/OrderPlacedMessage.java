package co.edu.udea.automationexercise.certificacion.moduloprueba.questions;

import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OrderPlacedMessage implements Question<String> {

    public static OrderPlacedMessage text() {
        return new OrderPlacedMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return PaymentPage.ORDER_PLACED.resolveFor(actor).getText().toUpperCase();
    }
}
