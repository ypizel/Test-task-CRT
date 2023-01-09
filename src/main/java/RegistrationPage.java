import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BaseObjectPage{
    public static String REGISTRATION_PAGE = "http://localhost:5000/signup";
    private final By emailField = By.xpath("//input[contains(@placeholder, 'Email')]");
    private final By passwordField = By.xpath("//input[contains(@placeholder, 'Password')]");

    private final By notification = By.xpath("//div[contains(@class, 'notification')]");
    private final By confirmRegistrationButton = By.xpath("//button[contains(@class, 'button is-block is-info is-large is-fullwidth')]");

    private final By loginPageEmailField = By.xpath("//input[contains(@placeholder, 'Your Email')]");


    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public RegistrationPage open(){
        driver.get(REGISTRATION_PAGE);
        return this;
    }

    public RegistrationPage pause() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void waitVisability(WebElement element){
        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.visibilityOf(element));
    }
    public RegistrationPage setEmail(String email){
        WebElement element = driver.findElement(emailField);
        waitElementToBeClickable(element);
        element.sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
        return this;
    }

    public RegistrationPage clickConfirmRegistrationButton() {
        WebElement element = driver.findElement(confirmRegistrationButton);
        element.click();
        return this;
    }

    public RegistrationPage registration(User user) {
        pause();
        setEmail(user.getEmail());
        pause();
        setPassword(user.getPassword());
        pause();
        clickConfirmRegistrationButton();
        return this;
    }

    public boolean isRegistered() {
        pause();
        WebElement element = driver.findElement(loginPageEmailField);
        waitElementToBeClickable(element);
        return element.isDisplayed();
    }

    public String getNotificationText(){
        WebElement element = driver.findElement(notification);
        return element.getText();
    }
}
