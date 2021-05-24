package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    public WebDriver webDriver;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}