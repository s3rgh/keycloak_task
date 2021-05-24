package tests;

import dto.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveLoginTest extends TestBase {

    public static Object[][] usersTestData() {
        return new Object[][]{
                {"sergh", "123456"},
                {"serge", "qwerty"},
                {"1000000", "kek"}
        };
    }

    @ParameterizedTest
    @MethodSource("usersTestData")
    public void testLoginPositive(String login, String password) {
        app.getLoginPage()
                .loginUserAs(new User().withUserName(login).withPassword(password))
                .clickSubmitButton();

        assertTrue(app.getUserPage().userAccHeader.isDisplayed());
    }
}