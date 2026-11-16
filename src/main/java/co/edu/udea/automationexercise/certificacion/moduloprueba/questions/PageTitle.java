package co.edu.udea.automationexercise.certificacion.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/** Título de la pestaña del navegador. */
public class PageTitle implements Question<String> {

    public static PageTitle value() {
        return new PageTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getTitle();
    }
}
