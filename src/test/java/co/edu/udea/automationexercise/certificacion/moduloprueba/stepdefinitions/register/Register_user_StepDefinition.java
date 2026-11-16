package co.edu.udea.automationexercise.certificacion.moduloprueba.stepdefinitions.register;

import co.edu.udea.automationexercise.certificacion.moduloprueba.models.UserData;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.AccountCreatedMessage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.CurrentUrl;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.IsVisible;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.LoggedInUser;
import co.edu.udea.automationexercise.certificacion.moduloprueba.questions.PageTitle;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.ConfirmAccountCreated;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.LogOut;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.OpenTheStore;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.RegisterNewUser;
import co.edu.udea.automationexercise.certificacion.moduloprueba.tasks.StartSignup;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.HomePage;
import co.edu.udea.automationexercise.certificacion.moduloprueba.userinterfaces.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Register_user_StepDefinition {

    private static final String HOME_TITLE = "Automation Exercise";
    private static final String EMAIL_KEY = "registeredEmail";
    private static final String EXISTING_USER_NAME = "Maria";

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    // ---- Scenario: Arriving at the store ----

    @Given("I am a new user")
    public void iAmANewUser() {
        // Contexto: el actor (creado en Hooks) llega sin cuenta ni sesión.
        // Ese estado se verifica al final del escenario con "I am not logged in".
    }

    @When("I open the Automation Exercise store")
    public void iOpenTheAutomationExerciseStore() {
        user().attemptsTo(OpenTheStore.home());
    }

    @Then("I see the home page")
    public void iSeeTheHomePage() {
        user().should(
                seeThat(CurrentUrl.value(), equalTo(HomePage.URL)),
                seeThat(PageTitle.value(), equalTo(HOME_TITLE)));
    }

    @And("I see the option to sign up")
    public void iSeeTheOptionToSignUp() {
        user().should(seeThat(IsVisible.the(HomePage.SIGNUP_LOGIN_LINK), is(true)));
    }

    @And("I am not logged in")
    public void iAmNotLoggedIn() {
        user().should(seeThat(LoggedInUser.label(), equalTo("")));
    }

    // ---- Scenario Outline: Successful registration ----

    @Given("I am a new user on the store home page")
    public void iAmANewUserOnTheStoreHomePage() {
        user().attemptsTo(OpenTheStore.home());
    }

    @When("I register as {string} using a new email address")
    public void iRegisterAsUsingANewEmailAddress(String name) {
        user().attemptsTo(RegisterNewUser.with(UserData.withName(name)));
    }

    @Then("I see the successful registration message")
    public void iSeeTheSuccessfulRegistrationMessage() {
        user().should(seeThat(AccountCreatedMessage.text(), containsString("ACCOUNT CREATED")));
    }

    @And("I am logged in as {string}")
    public void iAmLoggedInAs(String name) {
        // Tras "Account Created!" el usuario pulsa Continue y debe ver su nombre en el menú.
        user().attemptsTo(ConfirmAccountCreated.now());
        user().should(seeThat(LoggedInUser.label(), containsString("Logged in as " + name)));
    }

    // ---- Scenario: Registration with an email address that already exists ----

    @Given("a user is already registered in the store")
    public void aUserIsAlreadyRegisteredInTheStore() {
        UserData existing = UserData.withName(EXISTING_USER_NAME);
        user().remember(EMAIL_KEY, existing.getEmail());
        user().attemptsTo(
                OpenTheStore.home(),
                RegisterNewUser.with(existing),
                ConfirmAccountCreated.now(),
                LogOut.now());
    }

    @When("I try to sign up again with that same email address")
    public void iTryToSignUpAgainWithThatSameEmailAddress() {
        String email = user().recall(EMAIL_KEY);
        user().attemptsTo(StartSignup.with(EXISTING_USER_NAME, email));
    }

    @Then("I see the message that the email address already exists")
    public void iSeeTheMessageThatTheEmailAddressAlreadyExists() {
        user().should(seeThat(IsVisible.the(LoginPage.EXISTING_EMAIL_ERROR), is(true)));
    }

    @And("I remain on the signup page")
    public void iRemainOnTheSignupPage() {
        user().should(seeThat(CurrentUrl.value(), containsString("/signup")));
    }
}
