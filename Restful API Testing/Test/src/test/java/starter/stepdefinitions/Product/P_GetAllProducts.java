package starter.stepdefinitions.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Product.GetAllProduct;
import starter.user.Product.ResponseProduct;

public class P_GetAllProducts {

    @Steps
    GetAllProduct getAllProduct;

    @Steps
    ResponseProduct responseProduct;

    @Given("I set API endpoint for retrieve all users")
    public void i_set_api_endpoint_for_retrieve_all_users() {
        getAllProduct.SetApiEndpoint();
    }

    @When("I send GET request to retrieve all products to server")
    public void i_send_GET_request_to_retrieve_all_products_to_server() {
        getAllProduct.GetApiEndpoint();
    }

    @And("I receive status code 200")
    public void i_receive_status_code_200() {
        responseProduct.responseCode200();
    }

    @Then("I receive all products")
    public void i_receive_all_products() {
        getAllProduct.ReceiveAllProducts();
    }


}


