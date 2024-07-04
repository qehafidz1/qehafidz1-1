package starter.stepdefinitions.Authentication;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Product.ResponseProduct;
import starter.user.Authentication.Register;

public class P_Register {
   @Steps
   ResponseProduct responseProduct;

   @Steps
   Register register;

   @Given("I set on the register endpoint")
   public void ISetRegisterPoint() {
      register.IsetOnTheLoginPoint();
   }

   @When("I send valid email and valid input and valid fullname")
   public void ISendToServerRegisterPostRequest(){
      register.ISendToServerRegisterPostWithValidInput();
   }

   @Then("My account is registered")
   public void MyAccountIsRegistered(){
       register.CheckThatIgetAuthenticationCode();
   }

   @When("I send valid with valid email and invalid password and valid fullname")
   public void IsendValidWithValidEmailAndInvalidPassword(){
      register.ISendToServerRegisterPostWithInvalidPassword();
   }
   @Then("My account is not registered")
   public void MyAccountIsNotRegistered(){
      register.CheckThatMyAccountAreNotRegistered();
   }

}
