package appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pages.LoginPage;
import pages.RegisterPage;
import pages.UserPage;

public class ApplicationManager {

    public static WebDriver webDriver;

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private UserPage userPage;

    public ApplicationManager() {
    }

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--verbose");
        options.addArguments("--whitelisted-ips='127.0.0.1:8080'");
        options.addArguments("--headless");
        options.addArguments("--window-size=1366x768");
        options.addArguments("--disable-notifications");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        userPage = new UserPage(webDriver);
        webDriver.get("http://localhost:8080/auth/realms/Demo/account");
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> webDriver.quit())
        );
    }

    public void stop() {
        //webDriver.quit();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public UserPage getUserPage() {
        return userPage;
    }
}