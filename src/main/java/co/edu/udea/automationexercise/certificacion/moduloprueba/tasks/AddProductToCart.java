package co.edu.udea.automationexercise.certificacion.moduloprueba.tasks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.CloseAds;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.EnsureOnPage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.interactions.Pause;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/** Agrega un producto (por su nombre) al carrito desde la página de productos. */
public class AddProductToCart implements Task {

    private final String product;

    public AddProductToCart(String product) {
        this.product = product;
    }

    public static AddProductToCart named(String product) {
        return Tasks.instrumented(AddProductToCart.class, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(ProductsPage.URL),
                EnsureOnPage.withUrl(ProductsPage.URL),
                WaitUntil.the(ProductsPage.ADD_TO_CART.of(product), isVisible()).forNoMoreThan(20).seconds(),
                CloseAds.ifPresent(),
                Pause.forAMoment(),
                // Clic por JavaScript: evita que el panel que aparece al pasar el mouse tape el botón.
                JavaScriptClick.on(ProductsPage.ADD_TO_CART.of(product)),
                WaitUntil.the(ProductsPage.CONTINUE_SHOPPING, isVisible()).forNoMoreThan(10).seconds(),
                Pause.forAMoment(),
                Click.on(ProductsPage.CONTINUE_SHOPPING));
    }
}
