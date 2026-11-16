package co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.purchase;

import co.edu.udea.automationexercise.certificacion.moduloprueba.models.CardData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.OrderPlacedMessage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.CheckoutOrder;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.PayOrder;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

/** Los pasos del Background y "I have a product in the shopping cart" están en stepdefinitions.common. */
public class Purchase_StepDefinition {

    private static final String ORDER_COMMENT = "Pedido de prueba automatizada - Taller Calidad de Software";

    private Actor customer() {
        return OnStage.theActorInTheSpotlight();
    }

    @When("I complete the purchase details and confirm the order")
    public void iCompleteThePurchaseDetailsAndConfirmTheOrder() {
        customer().attemptsTo(
                CheckoutOrder.withComment(ORDER_COMMENT),
                PayOrder.with(CardData.valid()));
    }

    @Then("I see the message that the order has been placed")
    public void iSeeTheMessageThatTheOrderHasBeenPlaced() {
        customer().should(seeThat(OrderPlacedMessage.text(), containsString("ORDER PLACED")));
    }
}
