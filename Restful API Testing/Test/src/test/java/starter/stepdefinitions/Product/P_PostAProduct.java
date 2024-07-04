package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Product.PostAProduct;
import starter.user.Product.ResponseProduct;


public class P_PostAProduct {

    @Steps
    PostAProduct postAProduct;

    @Steps
    ResponseProduct responseProduct;

    @Given("I set on the endpoint to post a request")
    public void i_set_on_the_endpoint_to_post_a_request() {
        postAProduct.ISetOnTheEndpointToPostARequest();
    }

    @When("I send POST to server with valid requirement")
    public void i_send_post_to_server_with_valid_requirement() {
        postAProduct.ISendPostToServerWithValidRequirement();
    }
    @And("I receive status code 201")
    public void i_receive_status_code_200() {
        responseProduct.responseCode200();
    }

    @Then("I receive the valid data for created product")
    public void iReceiveTheValidDataForCreatedProduct() {
        postAProduct.IReceiveTheValidDataForCreatedProduct();
    }

    @When("I send POST to server without name")
    public void ISendPostToServerWithoutName() {
        postAProduct.ISendPostToServerWithoutName();
    }

    @Then("I receive error message bacause i wrote it without name")
    public void IReceiveErrorMessageBCZWithoutName(){
        postAProduct.IReceiveErrorMessageForProductsNameCheck();
    }


}
