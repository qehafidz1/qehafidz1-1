package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Product.CreateAComment;
import starter.user.Product.ResponseProduct;

public class P_CreateAComment {

    @Steps
    CreateAComment createAComment;

    @Steps
    ResponseProduct responseProduct;
    @Given("I have a valid user authentication token")
    public void iHaveAValidUserAuthenticationToken() {
        createAComment.SetValidAPIOnPoint();
    }

    @When("I send a POST request to the comment creation endpoint with valid comment data")
    public void ISendCommentPostToServer() {
        createAComment.ISendCommentPostToServer();
    }


    @Then("the comment should be successfully created in the database")
    public void theCommentShouldBeSuccessfullyCreatedInTheDatabase() {
        createAComment.IReceiveTheValidDataForCreatedComment();
    }

    // Negatives Testing

    @When("I send a POST request to the comment creation endpoint with invalid input")
    public void iSendAPOSTRequestToTheCommentCreationEndpointWithInvalidCommentData() {
        createAComment.ISendCommentPostToServerWithWronginput();
    }

    @And("I receive status code 500")
    public void iReceiveStatusCode500() {
        responseProduct.responseCode500();
    }


    @Then("the comment should not be created in the database")
    public void theCommentShouldNotBeCreatedInTheDatabase() {
        // Verifikasi bahwa komentar tidak berhasil dibuat dalam database
        createAComment.CheckThatTheDataIsNotCreated();
    }





}
