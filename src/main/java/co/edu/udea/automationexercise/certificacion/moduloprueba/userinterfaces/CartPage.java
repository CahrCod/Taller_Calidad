package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    private CartPage() {}

    public static final String URL = HomePage.URL + "view_cart";

    public static final Target PRODUCT_IN_CART = Target.the("{0} in the cart")
            .locatedBy("//td[@class='cart_description']/h4[contains(normalize-space(.),'{0}')]");

    public static final Target DELETE_PRODUCT = Target.the("delete {0} from the cart")
            .locatedBy("//tr[td[@class='cart_description']/h4[contains(normalize-space(.),'{0}')]]"
                    + "//a[contains(@class,'cart_quantity_delete')]");

    public static final Target PRODUCT_PRICE = Target.the("price of {0} in the cart")
            .locatedBy("//tr[td[@class='cart_description']/h4[contains(normalize-space(.),'{0}')]]"
                    + "/td[@class='cart_price']/p");

    public static final Target PRODUCT_QUANTITY = Target.the("quantity of {0} in the cart")
            .locatedBy("//tr[td[@class='cart_description']/h4[contains(normalize-space(.),'{0}')]]"
                    + "/td[@class='cart_quantity']/button");

    public static final Target EMPTY_CART = Target.the("empty cart message")
            .located(By.cssSelector("#empty_cart"));

    public static final Target PROCEED_TO_CHECKOUT = Target.the("proceed to checkout")
            .located(By.cssSelector("a.check_out"));
}