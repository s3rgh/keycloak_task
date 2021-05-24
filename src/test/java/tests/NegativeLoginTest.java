package tests;

import dto.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeLoginTest extends TestBase {

  public static Object[][] usersTestData() {
    return new Object[][]{
            {"sergh1", "123456"},
            {"", ""},
            {"1000000", ""}
    };
  }

  @ParameterizedTest
  @MethodSource("usersTestData")
  public void testLoginNegative(String login, String password) {
    app.getLoginPage()
            .loginUserAs(new User().withUserName(login).withPassword(password))
            .clickSubmitButton();

    assertTrue(app.getLoginPage().wrongLoginMessage.isDisplayed());
  }
}
