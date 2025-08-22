package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.List;

public class ElementExplorerTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void exploreForgotPasswordPage() throws InterruptedException {
        driver.get(ConfigReader.get("baseUrl") + "forgot_password");
        Thread.sleep(2000);
        
        System.out.println("=== FORGOT PASSWORD PAGE ELEMENTS ===");
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        
        // Find all input elements
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("\n=== INPUT ELEMENTS ===");
        for (int i = 0; i < inputs.size(); i++) {
            WebElement input = inputs.get(i);
            System.out.println("Input " + i + ":");
            System.out.println("  ID: " + input.getAttribute("id"));
            System.out.println("  Name: " + input.getAttribute("name"));
            System.out.println("  Type: " + input.getAttribute("type"));
            System.out.println("  Class: " + input.getAttribute("class"));
        }
        
        // Find all button elements
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("\n=== BUTTON ELEMENTS ===");
        for (int i = 0; i < buttons.size(); i++) {
            WebElement button = buttons.get(i);
            System.out.println("Button " + i + ":");
            System.out.println("  ID: " + button.getAttribute("id"));
            System.out.println("  Type: " + button.getAttribute("type"));
            System.out.println("  Text: " + button.getText());
            System.out.println("  Class: " + button.getAttribute("class"));
        }
        
        // Fill email and submit
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("test@example.com");
        
        WebElement submitButton = driver.findElement(By.id("form_submit"));
        submitButton.click();
        
        Thread.sleep(3000);
        
        System.out.println("\n=== AFTER SUBMIT ===");
        System.out.println("New URL: " + driver.getCurrentUrl());
        
        // Find all divs that might contain confirmation message
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        System.out.println("\n=== DIV ELEMENTS AFTER SUBMIT ===");
        for (int i = 0; i < divs.size(); i++) {
            WebElement div = divs.get(i);
            String text = div.getText();
            if (!text.trim().isEmpty()) {
                System.out.println("Div " + i + ":");
                System.out.println("  ID: " + div.getAttribute("id"));
                System.out.println("  Class: " + div.getAttribute("class"));
                System.out.println("  Text: " + text);
                System.out.println("  ---");
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
