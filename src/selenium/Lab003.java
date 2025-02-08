//Open Flipkart --> Electronics --> Search Powerbank --> high to low --> print title of first highest power bank
package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

public class Lab003 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Adjust timeout as needed
        try {
            WebElement loginPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_30XB9F"))); // Replace with the actual locator
            System.out.println("Login cancelled");
        } catch (TimeoutException e) {
            System.out.println("No alert recorded: " + e.getMessage());
        }
        WebElement elementToHoverOver = driver.findElement(By.xpath("//*[text()='Electronics']")); // Replace with your element locator
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHoverOver).perform();
        WebElement powerBankLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Powerbank')]")));
        System.out.println("element found");
        WebElement elementPowerBank = driver.findElement(By.xpath("//*[text()='Powerbank']")); // Replace with your element locator
        elementPowerBank.click();
        WebElement sorting = driver.findElement(By.xpath("//div[@class='zg-M3Z' and text()='Price -- High to Low']"));
        sorting.click();
        List<WebElement> listItems =  driver.findElements(By.cssSelector("a.wjcEIp"));
        System.out.println(listItems.get(0).getText());
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            // Handle the interruption (e.g., log it, exit the loop, etc.)
            System.err.println("Thread interrupted: " + e.getMessage());
        }
        driver.quit();
    }
}
