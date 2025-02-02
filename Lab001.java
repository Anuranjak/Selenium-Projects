package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Lab001 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.VWO.com");
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");
        WebElement passwordBox = driver.findElement(By.id("login-password"));
        passwordBox.sendKeys("12356");
        WebElement signInButton = driver.findElement(By.id("js-login-btn"));
        signInButton.click();
        WebElement linkFreeTrial = driver.findElement(By.linkText("Start a free trial"));
        linkFreeTrial.click();
        try {
            Thread.sleep(Long.parseLong("5000"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}