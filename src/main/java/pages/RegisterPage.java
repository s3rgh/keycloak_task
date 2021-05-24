package pages;

import dto.NewUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password-confirm")
    public WebElement passwordConfirm;

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
        wait = new WebDriverWait(this.webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }

    public RegisterPage enterNewRegisteredUser(NewUser newUser) {
        firstName.click();
        firstName.sendKeys(newUser.getFirstName());
        lastName.click();
        lastName.sendKeys(newUser.getLastName());
        email.click();
        email.sendKeys(newUser.getEmail());
        userName.click();
        userName.sendKeys(newUser.getLogin());
        password.click();
        password.sendKeys(newUser.getPassword());
        passwordConfirm.click();
        passwordConfirm.sendKeys(newUser.getPassword());
        return this;
    }
}
