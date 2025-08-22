package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureUtils {
    
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    
    @Attachment(value = "Page source", type = "text/html")
    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
    
    @Attachment(value = "Console logs", type = "text/plain")
    public static String getConsoleLogs(String logs) {
        return logs;
    }
}
