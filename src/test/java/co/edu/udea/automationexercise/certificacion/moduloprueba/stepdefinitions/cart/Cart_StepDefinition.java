package co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.cart;

import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.CartProductPrice;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.CartProductQuantity;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.ProductInCart;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.AddProductToCart;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.GoToCart;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.RemoveProductFromCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.common.Customer_StepDefinition.PRODUCT_KEY;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Cart_StepDefinition {

    private Actor customer() {
        return OnStage.theActorInTheSpotlight();
    }

    // ---- Scenario Outline: Adding a product to the cart ----

    @When("I add the product {string} to the cart")
    public void iAddTheProductToTheCart(String product) {
        customer().attemptsTo(AddProductToCart.named(product));
    }

    @Then("the product {string} is in the shopping cart")
    public void theProductIsInTheShoppingCart(String product) {
        customer().attemptsTo(GoToCart.now());
        customer().should(seeThat(ProductInCart.named(product), is(true)));
    }

    @And("the product {string} has the price {string} and the quantity {string}")
    public void theProductHasThePriceAndTheQuantity(String product, String price, String quantity) {
        customer().should(
                seeThat(CartProductPrice.of(product), equalTo(price)),
                seeThat(CartProductQuantity.of(product), equalTo(quantity)));
    }

    // ---- Scenario: Removing a product from the cart ----

    @When("I remove that product from the cart")
    public void iRemoveThatProductFromTheCart() {
        String product = customer().recall(PRODUCT_KEY);
        customer().attemptsTo(
                GoToCart.now(),
                RemoveProductFromCart.named(product));
    }

    @Then("the cart no longer contains that product")
    public void theCartNoLongerContainsThatProduct() {
        String product = customer().recall(PRODUCT_KEY);
        customer().should(seeThat(ProductInCart.named(product), is(false)));
    }
}
