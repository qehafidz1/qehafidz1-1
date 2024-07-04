package starter.stepdefinitions.Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Product.DeleteAProduct;
import starter.user.Product.ResponseProduct;
public class P_DeleteAProduct
{
    @Steps
    DeleteAProduct deleteAProduct;

    @Steps
    ResponseProduct responseProduct;

    @Given("I set on the endpoint to delete the product")
    public void IsetOnTheEndpointToDeleteTheProduct(){
        deleteAProduct.ISetOnTheEndpointToDeleteTheproduct();
    }

    @When("I send DELETE request to server with valid ID")
    public void IsendDELETErequestToServerWithValidID(){
        deleteAProduct.ISendDELETERequestToServerWithValidId();
    }

    @Then("I get status code 200 DELETE")
    public void IgetStatusCode204DELETE(){
        responseProduct.responseCode200();
    }

}
