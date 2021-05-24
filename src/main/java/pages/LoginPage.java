package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(xpath= "//*[@id=\"input-error\"]")
    public WebElement wrongLoginMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        wait = new WebDriverWait(this.webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage loginUserAs(User user) {
        userName.sendKeys(user.getUserName());
        password.sendKeys(user.getPassword());
        return this;
    }

    public RegisterPage openRegisterPage() {
        registerLink.click();
        return new RegisterPage(webDriver);
    }
}
