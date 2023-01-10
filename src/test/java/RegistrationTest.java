import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseUiTest {

    @Test
    public void signUpWithCorrectEmailAndPassword() throws Exception {
        Boolean isRegistered = new RegistrationPage(driver)
                .open()
                .registration(UserGenerator.getNewUser())
                .isRegistered();

        assertTrue(isRegistered);
    }

    @Test
    public void signUpWithNoPassword() throws NoSuchElementException{
        RegistrationPage registrationPage = new RegistrationPage(driver);
        boolean isRegistered = new RegistrationPage(driver)
                .open()
                .registration(UserGenerator.getWithoutPassword())
                .isRegistered();

        assertFalse("Registration was completed without a password", isRegistered);

        String notificationText = registrationPage
                .getNotificationText();
        assertEquals("Enter password", notificationText);
    }

    @Test
    public void signUpWithNoEmail() throws NoSuchElementException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        boolean isRegistered = registrationPage
                .open()
                .registration(UserGenerator.getWithoutEmail())
                .isRegistered();
        assertFalse("Registration was completed without an email", isRegistered);

        String notificationText = registrationPage
                .getNotificationText();
        assertEquals( "Enter email", notificationText);
    }
}
