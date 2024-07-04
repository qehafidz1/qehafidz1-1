package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Product.AssignAProductRating;
import starter.user.Product.ResponseProduct;

public class P_CreateARating {

    @Steps
    AssignAProductRating assignAProductRating;
    @Steps
    ResponseProduct responseProduct;


    @When("I send a POST request to the rating creation endpoint with valid rating data")
    public void iSendAPostRequestToTheRatingCreationEndpointWithValidRatingData() {
        assignAProductRating.sendPostRequestToCreateRating();
    }

    @Then("the rating should be successfully created in the database")
    public void theRatingShouldBeSuccessfullyCreatedInTheDatabase() {
        assignAProductRating.receiveValidStatusCodeAndData();
    }

    @When("I send a POST request to the comment creation endpoint with invalid URL")
    public void iSendAPostRequestToTheRatingCreationEndpointWithInvalidURL() {
        assignAProductRating.sendPostRequestToInvalidURL();
    }

    @And("I receive status code 400")
    public void IReceiveStatusCode400() {
        responseProduct.responseCode400();
    }
    @Then("I receive message {string}")
    public void iReceiveMessage() {
        assignAProductRating.receiveErrorStatusCodeAndMessage();
    }
}
