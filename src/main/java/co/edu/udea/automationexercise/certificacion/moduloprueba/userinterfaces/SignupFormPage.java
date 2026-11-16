package co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SignupFormPage {

    private SignupFormPage() {}

    public static final Target PASSWORD = Target.the("password").locatedBy("[data-qa='password']");
    public static final Target FIRST_NAME = Target.the("first name").locatedBy("[data-qa='first_name']");
    public static final Target LAST_NAME = Target.the("last name").locatedBy("[data-qa='last_name']");
    public static final Target ADDRESS = Target.the("address").locatedBy("[data-qa='address']");
    public static final Target COUNTRY = Target.the("country").locatedBy("[data-qa='country']");
    public static final Target STATE = Target.the("state").locatedBy("[data-qa='state']");
    public static final Target CITY = Target.the("city").locatedBy("[data-qa='city']");
    public static final Target ZIPCODE = Target.the("zipcode").locatedBy("[data-qa='zipcode']");
    public static final Target MOBILE = Target.the("mobile number").locatedBy("[data-qa='mobile_number']");
    public static final Target CREATE_ACCOUNT = Target.the("create account button").locatedBy("[data-qa='create-account']");
    public static final Target ACCOUNT_CREATED = Target.the("account created title").locatedBy("[data-qa='account-created']");
    public static final Target CONTINUE = Target.the("continue button").locatedBy("[data-qa='continue-button']");
}