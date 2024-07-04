package starter.pages;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class InformationPage extends PageObject {
    // Verify That Im On The Information Page

    private By BookInformationPage() {
        return By.xpath("//*[@id=\"root\"]/div/h1");
    }

    @Step
    public boolean VerifyThatImOnBookInformartionPage() {
        return $(BookInformationPage()).getText().equals("Show Book");
    }
}
