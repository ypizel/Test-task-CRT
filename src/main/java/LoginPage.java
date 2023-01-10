import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseObjectPage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public static String LOGIN_PAGE = "http://localhost:5000/login";
    private final By emailField = By.xpath("//input[contains(@placeholder, 'Your Email')]");
    private final By passwordField = By.xpath("//input[contains(@placeholder, 'Your Password')]");
    private final By confirmLoginButton = By.xpath("//button[contains(@class, 'button is-block is-info is-large is-fullwidth')]");
    private final By welcomeTitle = By.xpath("//h1[contains(text(), 'Welcome')]");

    @Override
    public LoginPage open(){
        driver.get(LOGIN_PAGE);
        return this;
    }

    public LoginPage setEmail(String email){
        WebElement element = driver.findElement(emailField);
        waitElementToBeClickable(element);
        element.sendKeys(email);
        return this;
    }
    public LoginPage setPassword(String password){
        WebElement element = driver.findElement(passwordField);
        waitElementToBeClickable(element);
        element.sendKeys(password);
        return this;
    }
    public LoginPage clickConfirmLoginButton(){
        WebElement element = driver.findElement(confirmLoginButton);
        element.click();
        return this;
    }
    public LoginPage login(User user){
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickConfirmLoginButton();
        return this;
    }

    public boolean isLoggedIn(){
        WebElement element = driver.findElement(welcomeTitle);
        return element.isDisplayed();
    }
}
