package co.edu.udea.automationexercise.certificacion.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CloseAds implements Interaction {

    public static CloseAds ifPresent() {
        return Tasks.instrumented(CloseAds.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).evaluateJavascript(
                "document.querySelectorAll('ins.adsbygoogle, iframe[id^=aswift], #google_vignette')"
              + ".forEach(e => e.remove());");
    }
}
