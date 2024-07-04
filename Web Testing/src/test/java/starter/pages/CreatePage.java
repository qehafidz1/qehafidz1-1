package starter.pages;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CreatePage extends PageObject {
    // Verify That Im On The Create Book Page

    private By CreateBookPage()  {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    }

    @Step
    public boolean VerifyThatImOnCreatePagee() {
        return $(CreateBookPage()).isDisplayed();
    }

    // Inputting Bar

    private By Title(){
        return By.id("title");
    }

    private By Author(){
        return By.id("author");
    }

    private By PublishYear(){
        return By.id("publishYear");
    }

    @Step
    public void InputtingData(String title, String author, String publishYear) {
        $(Title()).type(title);
        $(Author()).type(author);
        $(PublishYear()).type(publishYear);
    }
    //  Save Book Button

    private By SaveBookButton(){
        return By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    }
    @Step
    public void ClickSaveBookButton() {
         $(SaveBookButton()).click();
    }

    // Error Notification
    private By ErrorNotification(){
        return By.xpath("//*[@id=\"notistack-snackbar\"]");
    }

    public boolean VerifyThatErrorNotificationOccured(){
        return $(ErrorNotification()).isDisplayed();
    }
}
