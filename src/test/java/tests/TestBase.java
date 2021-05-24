package tests;

import appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase implements TestLifecycleLogger {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeEach
    public void setUp() {
        app.init();
    }

    @AfterEach
    public void tearDown() {
        app.stop();
    }
}