package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.NewUser;
import dto.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpTest extends TestBase {

    public static Iterator<Object[]> registerUsersFromJson() throws IOException {
        StringBuilder json;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/users.json"))) {
            json = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                json.append(line);
                line = reader.readLine();
            }
        }
        Gson gson = new Gson();
        List<NewUser> users = gson.fromJson(json.toString(), new TypeToken<List<NewUser>>(){}.getType());
        return users.stream().map((u) -> new Object[]{u}).collect(Collectors.toList()).iterator();
    }

    @ParameterizedTest
    @MethodSource("registerUsersFromJson")
    public void testSignUp(NewUser newUser) {
        app.getLoginPage()
                .openRegisterPage()
                .enterNewRegisteredUser(newUser)
                .clickSubmitButton();

        assertTrue(app.getUserPage().userAccHeader.isDisplayed());
    }
}
