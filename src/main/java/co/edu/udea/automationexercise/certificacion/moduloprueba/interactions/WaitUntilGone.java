package co.edu.udea.automationexercise.certificacion.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Espera a que un elemento desaparezca del DOM.
 * Busca el elemento de nuevo en cada intento (resolveAllFor), así no falla con
 * StaleElementReferenceException cuando el sitio elimina la fila por AJAX.
 */
public class WaitUntilGone implements Interaction {

    private static final long TIMEOUT_MILLIS = 15_000;
    private static final long POLL_MILLIS = 250;

    private final Target target;

    public WaitUntilGone(Target target) {
        this.target = target;
    }

    public static WaitUntilGone the(Target target) {
        return Tasks.instrumented(WaitUntilGone.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        long deadline = System.currentTimeMillis() + TIMEOUT_MILLIS;
        while (!target.resolveAllFor(actor).isEmpty() && System.currentTimeMillis() < deadline) {
            try {
                Thread.sleep(POLL_MILLIS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        // Si se agota el tiempo no se lanza error aquí: la Question del Then lo reportará.
    }
}
