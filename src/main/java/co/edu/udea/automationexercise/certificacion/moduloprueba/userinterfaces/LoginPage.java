package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    private LoginPage() {}

    public static final String URL = HomePage.URL + "login";

    // Formulario "New User Signup!"
    public static final Target SIGNUP_NAME = Target.the("signup name")
            .locatedBy("[data-qa='signup-name']");

    public static final Target SIGNUP_EMAIL = Target.the("signup email")
            .locatedBy("[data-qa='signup-email']");

    public static final Target SIGNUP_BUTTON = Target.the("signup button")
            .locatedBy("[data-qa='signup-button']");

    public static final Target EXISTING_EMAIL_ERROR = Target.the("existing email error")
            .locatedBy("//p[contains(text(),'Email Address already exist')]");

    // Formulario "Login to your account"
    public static final Target LOGIN_EMAIL = Target.the("login email")
            .locatedBy("[data-qa='login-email']");

    public static final Target LOGIN_PASSWORD = Target.the("login password")
            .locatedBy("[data-qa='login-password']");

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("[data-qa='login-button']");
}