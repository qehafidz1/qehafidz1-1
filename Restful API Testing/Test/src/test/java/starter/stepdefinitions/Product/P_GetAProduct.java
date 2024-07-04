package starter.stepdefinitions.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import starter.user.Product.GetAProduct;
import starter.user.Product.ResponseProduct;

public class P_GetAProduct {

    @Steps
    GetAProduct getAProduct;

    @Steps
    ResponseProduct responseproduct;

    @Given("I set endpoint API to retrieve a product with valid id")
    public void i_set_endpoint_api_to_retrieve_a_product_with_valid_id() {
        getAProduct.GetRequestToRetrieveAProductWithValidId();
    }

    @When("I send GET request to retrieve a product to server with valid ID")
    public void iSend_get_request_to_retrieve_a_product_to_server_with_valid_id(){
        getAProduct.GetRequestToRetrieveAProductWithValidId();
    }

    @And("I receive status code 200 meaning suceed to request GET to server")
    public void ReceiveStatusCode200(){
        responseproduct.responseCode200();
    }

    @Then("I receive the product")
    public void ReceiveTheProduct(){
        getAProduct.iReceiveTheProduct();
    }

    // Negative Test

    @Given("I set endpoint API to retrieve a product with invalid id")
    public void i_set_endpoint_api_to_retrieve_a_product_with_invalid_id(){
        getAProduct.ISetApiEndpointForRetrieveAProductWithInvalidId();
    }

    @When("I send GET request to retrieve a product to server with invalid ID")
    public void iSend_get_request_to_retrieve_a_product_to_server_with_invalid_id(){
        getAProduct.GetRequestToRetrieveAProductWithInvalidId();
    }

    @And("I receive status code 404")
    public void ReceiveStatusCode404(){
        responseproduct.responseCode404();
    }

    @And("I receive the error message")
    public void ReceiveTheErrorMessage(){
        getAProduct.CheckThatIReceiveError();
    }

}
