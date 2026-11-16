package co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.common;

import co.edu.udea.automationexercise.certificacion.moduloprueba.models.UserData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.AddProductToCart;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.ConfirmAccountCreated;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.OpenTheStore;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.RegisterNewUser;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

/**
 * Pasos compartidos por Cart.feature y Purchase.feature.
 * Están en su propio paquete para no duplicarlos (Cucumber no permite dos
 * definiciones con el mismo texto cuando se cargan juntas).
 */
public class Customer_StepDefinition {

    public static final String PRODUCT_KEY = "productInCart";

    private static final String CUSTOMER_NAME = "Ana";
    private static final String DEFAULT_PRODUCT = "Blue Top";

    private Actor customer() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("I am a customer registered and logged in to the store")
    public void iAmACustomerRegisteredAndLoggedInToTheStore() {
        customer().attemptsTo(
                OpenTheStore.home(),
                RegisterNewUser.with(UserData.withName(CUSTOMER_NAME)),
                ConfirmAccountCreated.now());
    }

    @Given("I have a product in the shopping cart")
    public void iHaveAProductInTheShoppingCart() {
        customer().remember(PRODUCT_KEY, DEFAULT_PRODUCT);
        customer().attemptsTo(AddProductToCart.named(DEFAULT_PRODUCT));
    }
}
