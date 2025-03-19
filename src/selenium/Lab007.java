//OPEN website aqi.in --> Search India --> Print top most polluted city --> Print its corresponding value by relative locators
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab007 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            //using partial text to find class name in Xpath:
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'content grow text-[2.5vw]')]")));
            System.out.println("Class successfully loaded");
        }catch (Exception e){
            System.err.println("Page not loaded" + e.getMessage());
        }
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@placeholder = \"Search\"]"));
        searchTextBox.sendKeys("India" + Keys.ENTER);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> list_of_States = driver.findElements(By.xpath("//a[1]/div[1]/p[1]"));
        if (!list_of_States.isEmpty()) { // Check if the list is not empty
            WebElement firstStateElement = list_of_States.getFirst(); // Get the first element (index 0)
            String firstStateText = firstStateElement.getText(); // Get the text of the first element
            System.out.println("Text of the first state: " + firstStateText);
            String S1 = driver.findElement(with(By.tagName("div")).toRightOf(firstStateElement)).getText();
            String S2 = driver.findElement(with(By.tagName("p")).toLeftOf(firstStateElement)).getText();
            System.out.println(firstStateElement.getText() + "-->" + S1 + "-->" + S2);
        } else {
            System.out.println("No state elements found with the given XPath.");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
