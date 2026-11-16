package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {

    private ProductsPage() {}

    public static final String URL = HomePage.URL + "products";

    public static final Target ADD_TO_CART = Target.the("add to cart of {0}")
            // contains(): los anuncios del sitio a veces insertan enlaces dentro del nombre del producto.
            .locatedBy("(//div[@class='productinfo text-center'][contains(normalize-space(p),'{0}')]"
                    + "/a[contains(@class,'add-to-cart')])[1]");

    public static final Target CONTINUE_SHOPPING = Target.the("continue shopping button")
            .located(By.cssSelector("#cartModal .close-modal"));

    public static final Target VIEW_CART = Target.the("view cart link")
            .located(By.cssSelector("#cartModal a[href='/view_cart']"));
}