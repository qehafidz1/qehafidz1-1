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
import starter.pages.CreatePage;
import starter.pages.DeleteQuestionPage;
import starter.pages.MainPage;

public class DeleteABook {
    @Steps
    MainPage mainPage;

    @Steps
    DeleteQuestionPage deleteBook;
    @When("I click the \"trash can\" button")
    public void iClickTheTrashCanButton() {
        mainPage.ClickOnDeleteButton();
    }

     @Then("a Pop-Up appears asking \"Are you sure want to delete this book?\"")
      public void aPopUpAppearsAskingTheDeleteButton() {
          deleteBook.VerifyIsDeleteQuestionDisplayed();
     }
     @When("I click the Yes button")
     public void iClickTheYesButton() {
        deleteBook.ClickDeleteQuestionButton();
     }

}
