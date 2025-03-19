//Open tutorials point web tables --> Delete one row using SVG
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Lab006 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'Web Tables']")));
            System.out.println("Web Table Appeared");
        } catch (Exception e) {
            System.err.println("Error: Web Table did not appear. " + e.getMessage());
        }
        Thread.sleep(3000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); //Increased timeout
        try {
            WebElement svgElements = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[3]/td[7]/a[2]//*[name()='svg']")));
            svgElements.click();
            System.out.println("Element successfully clicked");
            // Add verification here if needed (e.g., check if the element is gone).
        } catch (TimeoutException toe) {
            System.err.println("Timeout waiting for SVG element to be clickable: " + toe.getMessage());
        } catch (Exception e1) {
            System.err.println("Error interacting with SVG: " + e1.getMessage());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}

