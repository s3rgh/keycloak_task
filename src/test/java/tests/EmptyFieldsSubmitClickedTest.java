package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmptyFieldsSubmitClickedTest extends TestBase {

    @Test
    public void testEmptyLoginFieldsSubmit() {
        app.getLoginPage().clickSubmitButton();
        assertTrue(app.getLoginPage().wrongLoginMessage.isDisplayed());
    }
}