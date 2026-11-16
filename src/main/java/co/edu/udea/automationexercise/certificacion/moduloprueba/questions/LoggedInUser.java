package co.edu.udea.automationexercise.certificacion.moduloprueba.questions;

import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

/**
 * Texto "Logged in as <nombre>" del menú, o cadena vacía si no hay sesión iniciada.
 * Busca sin esperar a que aparezca, para poder verificar también que NO hay sesión.
 */
public class LoggedInUser implements Question<String> {

    public static LoggedInUser label() {
        return new LoggedInUser();
    }

    @Override
    public String answeredBy(Actor actor) {
        List<WebElementFacade> labels = HomePage.LOGGED_IN_AS.resolveAllFor(actor);
        return labels.isEmpty() ? "" : labels.get(0).getText().trim();
    }
}
