package co.edu.udea.automationexercise.certificacion.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

/**
 * Tras un clic que navega, el sitio a veces muestra un anuncio de pantalla completa
 * (#google_vignette) que bloquea la navegación. Si el navegador no llegó a la página
 * esperada, esta interacción la abre directamente.
 */
public class EnsureOnPage implements Interaction {

    private final String url;

    public EnsureOnPage(String url) {
        this.url = url;
    }

    public static EnsureOnPage withUrl(String url) {
        return Tasks.instrumented(EnsureOnPage.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String current = driver.getCurrentUrl().split("#")[0];
        if (!current.startsWith(url)) {
            driver.get(url);
        }
    }
}
