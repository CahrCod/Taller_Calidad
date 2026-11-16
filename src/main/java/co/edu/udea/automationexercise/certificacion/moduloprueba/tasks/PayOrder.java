package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.models.CardData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/** Llena los datos de la tarjeta, paga y espera la confirmación de la orden. */
public class PayOrder implements Task {

    private final CardData card;

    public PayOrder(CardData card) {
        this.card = card;
    }

    public static PayOrder with(CardData card) {
        return Tasks.instrumented(PayOrder.class, card);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaymentPage.NAME_ON_CARD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(card.getNameOnCard()).into(PaymentPage.NAME_ON_CARD),
                Enter.theValue(card.getNumber()).into(PaymentPage.CARD_NUMBER),
                Enter.theValue(card.getCvc()).into(PaymentPage.CVC),
                Enter.theValue(card.getExpiryMonth()).into(PaymentPage.EXPIRY_MONTH),
                Enter.theValue(card.getExpiryYear()).into(PaymentPage.EXPIRY_YEAR),
                Pause.forAMoment(),
                Click.on(PaymentPage.PAY_BUTTON),
                WaitUntil.the(PaymentPage.ORDER_PLACED, isVisible()).forNoMoreThan(15).seconds(),
                Pause.forAMoment());
    }
}
