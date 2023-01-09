import org.junit.Test;
import static org.junit.Assert.*;


public class LoginTest extends BaseUiTest{

    @Test
    public void loginWithExistedUser(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        User newUser = UserGenerator.getNewUser();

        registrationPage
                .open()
                .registration(newUser);

        boolean isLoggedIn = loginPage
                .login(newUser)
                .isLoggedIn();
        assertTrue(isLoggedIn);
    }
}
