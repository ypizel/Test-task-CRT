import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseObjectPage {

    protected WebDriver driver;

    public BaseObjectPage(WebDriver driver){
        this.driver = driver;
    }

    protected abstract Object open();

    public void waitElementToBeClickable(WebElement element){
        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
