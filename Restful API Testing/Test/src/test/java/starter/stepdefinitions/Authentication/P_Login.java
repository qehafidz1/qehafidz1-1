package starter.stepdefinitions.Authentication;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Login;
import starter.user.Authentication.Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class P_Login {
    @Steps
    Login login;

    @Steps
    Register register;

    @Given("I set on the Login endpoint")
    public void ISetOnTheLoginEndpoint() {
        login.IsetOnTheLoginPoint();
    }
    @When("I send valid email and valid input")
    public void ISendValidEmailAndValidInput() {
        login.ISendToServerLoginPostWithValidPassword();
    }
    @Then("My account is Logged")
    public void MyAccountIsLogged() {
        login.CheckThatMyLoginSuccedSoIgetAuthenticationCode();
    }

    @When("I send valid with valid email and invalid password")
    public void ISendToServerLoginPostWithInvalidPassword() {
        login.ISendToServerLoginPostWithInvalidPassword();
    }

    @Then("My account is not Logged")
    public void MyAccountIsNotLogged() {
        login.CheckThatMyAccountAreNotLogged();
    }

}




