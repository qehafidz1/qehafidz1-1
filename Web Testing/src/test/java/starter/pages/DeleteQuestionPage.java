package starter.pages;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;


public class DeleteQuestionPage extends  PageObject{
    @Step
    private By deleteQuestion() {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    }

    public boolean VerifyIsDeleteQuestionDisplayed() {
        return $(deleteQuestion()).isDisplayed();

    }

    public void ClickDeleteQuestionButton() {
        $(deleteQuestion()).click();
    }

}
