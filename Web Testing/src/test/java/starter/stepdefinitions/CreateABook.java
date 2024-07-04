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
import starter.pages.CreatePage;
import starter.pages.MainPage;


public class CreateABook {
    @Steps
    MainPage mainPage;
    @Steps
    CreatePage createPage;

    @Given("I am on the main page")
    public void iAmOnTheMainPage() {
        mainPage.openUrl("https://mini-book-store-fe.vercel.app/");
        Assertions.assertTrue(mainPage.VerifyThatImOnTheMainPage());
    }

    @When("I click the plus button")
    public void clickThePlusButton() {
       mainPage.ClickOnThePlusButton();
    }

    @Then("I am directed to the Create page")
    public void iAmDirectedToTheCreatePage() {
        Assertions.assertTrue(createPage.VerifyThatImOnCreatePagee());
    }

    @When("I input valid data including Title, Author, and Publish Year")
    public void iInputValidDataIncludingTitleAuthorAndPublishYear() {
        createPage.InputtingData("aaa","aaa","212");
    }

    @And("I click the Create Book button")
    public void iClickTheCreateBookButton() {
        createPage.ClickSaveBookButton();
    }

    @Then("I am directed to the main menu page")
    public void iAmDirectedToTheMainMenuPage() {
        Assertions.assertTrue(mainPage.VerifyThatImOnTheMainPage());
    }

    @And("My input is saved and visible on the info button")
    public void myInputIsSavedAndVisibleOnTheInfoButton() {
        mainPage.CheckIfTheNumberCreatedDataIsExist();
    }

    // Negatives Test

    // Without Title
    @When("I input data including Author and Publish Year but with a missing Title")
    public void iInputDataIncludingAuthorAndPublishYearButWithMissingTitle() {
        createPage.InputtingData("","aaa","212");
    }

    @Then("I remain on the Create page")
    public void remainOnTheCreatePage() {
        Assertions.assertTrue(createPage.VerifyThatImOnCreatePagee());
    }

    @And("An error occurs")
    public void anErrorOccurs() {
        Assertions.assertTrue(createPage.VerifyThatErrorNotificationOccured());
    }

    // With Negative Number

    @When("I input data including Author and Title but with a negative Year")
    public void iInputDataIncludingAuthorAndTitleButWithNegativeYear() {
        createPage.InputtingData("aaa","aaa","-111");
    }



}
