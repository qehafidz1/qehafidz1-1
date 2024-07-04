package starter.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.EditPage;
import starter.pages.InformationPage;
import starter.pages.CreatePage;
import starter.pages.MainPage;

public class GotoInformationPage {
   @Steps
    MainPage mainPage;

   @Steps
    InformationPage informationPage;

   @When("I click the \"i\" button")
    public void iClickTheIButton() {
       mainPage.ClickOnTheInformationPageButton();
   }

}
