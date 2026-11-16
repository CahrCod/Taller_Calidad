package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    private CheckoutPage() {}

    public static final String URL = HomePage.URL + "checkout";

    public static final Target COMMENT = Target.the("order comment")
            .located(By.cssSelector("textarea[name='message']"));

    public static final Target PLACE_ORDER = Target.the("place order button")
            .located(By.cssSelector("a[href='/payment']"));
}