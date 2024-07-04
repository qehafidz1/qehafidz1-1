package starter.stepdefinitions.Order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;
import starter.user.Orders.CreateAnOrder;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class P_CreateAnOrder {

    @Steps
    CreateAnOrder createAnOrder;

    @Given("I have set order on point")
    public void iHaveSetOrderOnPoint() {

    }

    @When("I send a POST request to the order creation endpoint with valid data")
    public void iSendAPostRequestToTheOrderCreationEndpointWithValidData() {
        createAnOrder.sendValidOrderToServer();
    }

    @When("I send a POST request to the order creation endpoint with invalid data")
    public void iSendAPostRequestToTheOrderCreationEndpointWithInvalidData() {
        createAnOrder.sendInvalidOrderToServer();
    }

    @Then("the order should be successfully created in the database")
    public void theOrderShouldBeSuccessfullyCreatedInTheDatabase() {
        createAnOrder.verifyOrderCreatedSuccessfully();
    }

    @Then("the order should not be created in the database")
    public void theOrderShouldNotBeCreatedInTheDatabase() {
        createAnOrder.verifyInvalidOrderNotCreated();
    }
}

