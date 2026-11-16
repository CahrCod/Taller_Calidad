package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.EnsureOnPage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.CartPage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.CheckoutPage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/** Desde el carrito: Proceed To Checkout, comentario de la orden y Place Order. */
public class CheckoutOrder implements Task {

    private final String comment;

    public CheckoutOrder(String comment) {
        this.comment = comment;
    }

    public static CheckoutOrder withComment(String comment) {
        return Tasks.instrumented(CheckoutOrder.class, comment);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GoToCart.now(),
                Click.on(CartPage.PROCEED_TO_CHECKOUT),
                EnsureOnPage.withUrl(CheckoutPage.URL),
                CloseAds.ifPresent(),
                WaitUntil.the(CheckoutPage.COMMENT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(comment).into(CheckoutPage.COMMENT),
                Pause.forAMoment(),
                Click.on(CheckoutPage.PLACE_ORDER),
                EnsureOnPage.withUrl(PaymentPage.URL),
                CloseAds.ifPresent());
    }
}
