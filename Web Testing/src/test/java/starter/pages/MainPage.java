package starter.pages;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;




public class MainPage extends PageObject {

    private By TheMainPage() {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/h1");
    }


    @Step
    public boolean VerifyThatImOnTheMainPage() {
        return $(TheMainPage()).isDisplayed();
    }


    //============================================================================================
    //       CREATE         READ          EDIT         DELETE         BUTTON
    //============================================================================================

    // Plus Button (CREATE BUTTON)

    private By PlusButton() {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/a");
    }

    @Step
    public void ClickOnThePlusButton() {
        $(PlusButton()).click();
    }

    // READ BUTTON

    private By InformationPageButton(){
        return By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[8]/td[5]/div/a[1]");
    }

    @Step
    public void ClickOnTheInformationPageButton() {
        $(InformationPageButton()).click();
    }

    // Edit Button

    private By EditButton(){
        return By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[7]/td[5]/div/a[2]");
    }

    @Step
    public void ClickOnTheEditButton() {
        $(EditButton()).click();
    }

    // Delete Button

    private By DeleteButton(){
        return By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[6]/td[5]/div/a[3]");
    }

    @Step
    public void ClickOnDeleteButton() {
        $(DeleteButton()).click();
    }

    //============================================================================================================
    //                                 TABLE
    //============================================================================================================

    private By TableCellTester_Number(){
        return By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[44]/td[1]");
    }

    @Step("My input is saved and visible on the info button")
    public boolean CheckIfTheNumberCreatedDataIsExist() {
      return $(TableCellTester_Number()).getText().equals("44");

    }





}







