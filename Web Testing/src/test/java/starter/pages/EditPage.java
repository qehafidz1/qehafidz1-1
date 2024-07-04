package starter.pages;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditPage extends PageObject {
    // Verify That Im On The Create Book Page

    private By EditBookPage() {
        return By.xpath("//*[@id=\"root\"]/div[1]/h1");
    }

    @Step
    public boolean VerifyThatImOnEditPage() {
        return $(EditBookPage()).getText().equals("Edit Book");
    }

}
