import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseUiTest {
    private Random random = new Random();
    private String email = "example" + random.nextInt(10_000_000) + "@mail.ru";

    @Test
    public void signUpWithCorrectEmailAndPassword() {
        Boolean isRegistered = new RegistrationPage(driver)
                .open()
                .registration(UserGenerator.getNewUser())
                .isRegistered();
        assertTrue(isRegistered);

    }

    @Test
    public void signUpWithNoPassword(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Boolean isRegistered = new RegistrationPage(driver)
                .open()
                .registration(UserGenerator.getWithoutPassword())
                .isRegistered();

//        String notificationText = registrationPage
//                .getNotificationText();

        assertFalse(isRegistered);
//        assertEquals(notificationText, "Enter password");
    }

    @Test
    public void signUpWithNoEmail(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
         registrationPage
                .open()
                .registration(UserGenerator.getWithoutEmail())
                ;

        String notificationText = registrationPage
                .getNotificationText();
//        assertFalse(isRegistered);
        assertNotEquals(notificationText, "Email address already exists. Go to login page.");
    }
}
