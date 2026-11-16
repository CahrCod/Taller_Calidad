package co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.hooks;

import co.edu.udea.automationexercise.certificacion.moduloprueba.models.UserData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.DeleteAccount;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.RegisterNewUser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    /**
     * Al terminar cada escenario: si se creó una cuenta, se elimina para no dejar
     * datos de prueba en el sitio; luego se cierra el navegador.
     * La limpieza no hace fallar el escenario: si no se puede borrar, solo se registra un aviso.
     */
    @After
    public void cleanUpAndDrawTheCurtain() {
        try {
            Actor actor = OnStage.theActorInTheSpotlight();
            UserData user = actor.recall(RegisterNewUser.REGISTERED_USER);
            if (user != null) {
                actor.attemptsTo(DeleteAccount.of(user));
            }
        } catch (Exception | AssertionError e) {
            LOGGER.warn("No se pudo eliminar la cuenta de prueba: {}", e.getMessage());
        } finally {
            OnStage.drawTheCurtain();
        }
    }
}
