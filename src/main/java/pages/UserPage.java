package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Edit Account']")
    public WebElement userAccHeader;

    public UserPage(WebDriver webDriver) {
        super(webDriver);
        wait = new WebDriverWait(this.webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }
}
