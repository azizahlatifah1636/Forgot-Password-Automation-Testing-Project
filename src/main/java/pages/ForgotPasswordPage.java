package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ForgotPasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");
    private By confirmationMessage = By.id("flash");
    private By alternativeMessage = By.tagName("h1");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickRetrievePassword() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(retrievePasswordButton));
        button.click();
    }

    public String getConfirmationMessage() {
        try {
            // Try flash message first
            WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(confirmationMessage));
            return message.getText();
        } catch (Exception e) {
            try {
                // Try h1 element as fallback
                WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(alternativeMessage));
                return message.getText();
            } catch (Exception e2) {
                // Return page source for debugging if both fail
                return driver.getPageSource();
            }
        }
    }

    public void navigateToLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }
}
