package starter.user.Authentication;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Register {

    private String URL = "https://altashop-api.fly.dev/api/auth/login";

  public String IsetOnTheLoginPoint(){
     return URL;
  }

    @Step
    public void ISendToServerRegisterPostWithValidInput(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");
        requestBody.put("fullname", "Firstname Lastname");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetOnTheLoginPoint());
    }

   @Step
   public void CheckThatIgetAuthenticationCode(){
      JsonSchemaHelper helper = new JsonSchemaHelper();
      String Schema = helper.getResponseSchema(JSON_Schema.REGISTER_SCHEMA);
      restAssuredThat(response -> response.body("data", Matchers.notNullValue()));
      restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));

   }

    @Step
    public void ISendToServerRegisterPostWithInvalidPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "AAA");
        requestBody.put("fullname", "Firstname Lastname");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetOnTheLoginPoint());
    }

    @Step
    public void CheckThatMyAccountAreNotRegistered(){
        restAssuredThat(response -> response.body("'data'", Matchers.nullValue()));
    }

}
