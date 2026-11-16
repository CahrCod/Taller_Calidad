package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    private HomePage() {}

    public static final String URL = "https://automationexercise.com/";
    public static final String LOGOUT_URL = URL + "logout";

    // Los selectores CSS con '/' se declaran con By.cssSelector: con locatedBy(...)
    // Serenity los confunde con XPath.

    public static final Target SIGNUP_LOGIN_LINK = Target.the("signup / login link")
            .located(By.cssSelector("a[href='/login']"));

    public static final Target PRODUCTS_LINK = Target.the("products link")
            .located(By.cssSelector("a[href='/products']"));

    public static final Target CART_LINK = Target.the("cart link")
            .located(By.cssSelector("ul.navbar-nav a[href='/view_cart']"));

    public static final Target LOGGED_IN_AS = Target.the("logged in as label")
            .locatedBy("//a[contains(.,'Logged in as')]");

    public static final Target LOGOUT_LINK = Target.the("logout link")
            .located(By.cssSelector("a[href='/logout']"));

    public static final Target DELETE_ACCOUNT_LINK = Target.the("delete account link")
            .located(By.cssSelector("a[href='/delete_account']"));
}
