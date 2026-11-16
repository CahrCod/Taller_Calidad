package co.edu.udea.automationexercise.certificacion.moduloprueba.questions;

import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** Precio con el que el carrito muestra un producto (por ejemplo "Rs. 500"). */
public class CartProductPrice implements Question<String> {

    private final String product;

    public CartProductPrice(String product) {
        this.product = product;
    }

    public static CartProductPrice of(String product) {
        return new CartProductPrice(product);
    }

    @Override
    public String answeredBy(Actor actor) {
        return CartPage.PRODUCT_PRICE.of(product).resolveFor(actor).getText().trim();
    }
}
