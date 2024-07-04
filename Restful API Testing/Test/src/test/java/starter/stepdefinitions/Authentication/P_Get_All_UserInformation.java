package starter.stepdefinitions.Authentication;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.GetAllUserInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class P_Get_All_UserInformation {

    @Steps
    GetAllUserInformation getAllUserInformation;

    @Given("I set on API Get All User on point")
    public void i_set_on_API_Get_All_User_on_point() {
        getAllUserInformation.SetGetAllUSerInformationApiEndPoint();
    }
    @When("I send GET request to retrieve all user information")
    public void i_send_GET_request_to_retrieve_all_user_information() {
        getAllUserInformation.SendToServerAllUserInformationGetRequest();
    }
    @And("And I receive all user information")
    public void and_I_receive_all_user_information() {
       getAllUserInformation.ReceiveAllUserInformation();
    }


}
