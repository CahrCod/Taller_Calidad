package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.WaitUntilGone;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/** Elimina un producto del carrito (el actor ya debe estar en la página del carrito). */
public class RemoveProductFromCart implements Task {

    private final String product;

    public RemoveProductFromCart(String product) {
        this.product = product;
    }

    public static RemoveProductFromCart named(String product) {
        return Tasks.instrumented(RemoveProductFromCart.class, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.DELETE_PRODUCT.of(product)),
                // El sitio borra la fila por AJAX: se espera a que desaparezca del DOM.
                WaitUntilGone.the(CartPage.PRODUCT_IN_CART.of(product)),
                Pause.forAMoment());
    }
}
