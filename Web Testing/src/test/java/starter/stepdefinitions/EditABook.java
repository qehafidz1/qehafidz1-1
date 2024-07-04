package starter.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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

public class EditABook {
    @Steps
    MainPage mainPage;
    @Steps
    InformationPage informationPage;
    @Steps
    CreatePage createPage;
    @Steps
    EditPage editPage;

    @When("I click the Edit button")
    public void iClickTheEditButton() {
        mainPage.ClickOnTheEditButton();
    }

    @Then("I am directed to the Edit page")
    public void iAmDirectedToTheEditPage() {
       Assertions.assertTrue(editPage.VerifyThatImOnEditPage());
    }

    @And("I click the Edit Book button")
    public void iClickTheEditBookButton() {
        createPage.ClickSaveBookButton();
    }

    @Then("I am directed to the Information Page")
    public void iAmDirectedToTheInformationPage() {
        informationPage.VerifyThatImOnBookInformartionPage();
    }

    // Negative Test

    @Then("I remain on the Edit page")
    public void iRemainOnTheEditPage() {
        Assertions.assertTrue(editPage.VerifyThatImOnEditPage());
    }

    @And("I input data including Author and Title but with a missing Year")
    public void iInputDataIncludingAuthorAndTitleButWithMissingYear() {
        createPage.InputtingData("aaa","aaa","");
    }


}
