package co.edu.udea.automationexercise.certificacion.moduloprueba.questions;

import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** Cantidad con la que el carrito muestra un producto. */
public class CartProductQuantity implements Question<String> {

    private final String product;

    public CartProductQuantity(String product) {
        this.product = product;
    }

    public static CartProductQuantity of(String product) {
        return new CartProductQuantity(product);
    }

    @Override
    public String answeredBy(Actor actor) {
        return CartPage.PRODUCT_QUANTITY.of(product).resolveFor(actor).getText().trim();
    }
}
