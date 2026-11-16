package co.edu.udea.automationexercise.certificacion.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Pause implements Interaction {

    private final long millis;

    public Pause(long millis) {
        this.millis = millis;
    }

    /** Pausa visible entre pasos (rúbrica). Se puede cambiar con -Dpause.millis=0 */
    public static Pause forAMoment() {
        return Tasks.instrumented(Pause.class, Long.getLong("pause.millis", 1500L));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
