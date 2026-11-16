package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DeleteAccountPage {

    private DeleteAccountPage() {}

    public static final String URL = HomePage.URL + "delete_account";

    public static final Target ACCOUNT_DELETED = Target.the("account deleted title")
            .locatedBy("[data-qa='account-deleted']");
}
