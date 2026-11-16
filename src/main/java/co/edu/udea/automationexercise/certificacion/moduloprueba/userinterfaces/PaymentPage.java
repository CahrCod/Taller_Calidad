package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PaymentPage {

    private PaymentPage() {}

    public static final String URL = HomePage.URL + "payment";

    public static final Target NAME_ON_CARD = Target.the("name on card").locatedBy("[data-qa='name-on-card']");
    public static final Target CARD_NUMBER = Target.the("card number").locatedBy("[data-qa='card-number']");
    public static final Target CVC = Target.the("cvc").locatedBy("[data-qa='cvc']");
    public static final Target EXPIRY_MONTH = Target.the("expiry month").locatedBy("[data-qa='expiry-month']");
    public static final Target EXPIRY_YEAR = Target.the("expiry year").locatedBy("[data-qa='expiry-year']");
    public static final Target PAY_BUTTON = Target.the("pay and confirm order button").locatedBy("[data-qa='pay-button']");
    public static final Target ORDER_PLACED = Target.the("order placed title").locatedBy("[data-qa='order-placed']");
}