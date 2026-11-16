package co.edu.udea.automationexercise.certificacion.moduloprueba.questions;

import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/** ¿El carrito muestra el producto indicado? (el actor debe estar en la página del carrito). */
public class ProductInCart implements Question<Boolean> {

    private final String product;

    public ProductInCart(String product) {
        this.product = product;
    }

    public static ProductInCart named(String product) {
        return new ProductInCart(product);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Busca de nuevo cada vez: el sitio elimina la fila del DOM al borrar el producto.
        return !CartPage.PRODUCT_IN_CART.of(product).resolveAllFor(actor).isEmpty();
    }
}
