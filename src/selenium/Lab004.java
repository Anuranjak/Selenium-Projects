//Click on the link below --> enter the pizza name in pizza section using shadow DOM
package selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

public class Lab004 {
    public static void main(String[] args) throws InterruptedException { // No need for throws InterruptedException
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/");
        driver.manage().window().maximize();
        // 1. Wait for the "Practice" link to be clickable:
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        WebElement practicePage = wait1.until(ExpectedConditions.elementToBeClickable(By.id("menu-item-4098")));
        practicePage.click();

        // 2. Wait for the new page to load (after the click):
        WebDriverWait waitAfterClick = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout
        try {
            waitAfterClick.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://bit.ly/tr_practice_2023']"))); // Replace with correct locator
            System.out.println("New Page Loaded");
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.PAGE_DOWN).perform();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Timeout, New page not loaded");
        }
        WebElement shadowDomLink = driver.findElement(By.xpath("//a[@href='https://selectorshub.com/shadow-dom-in-iframe/']"));
        shadowDomLink.click();
        //Handling Iframe
        WebDriverWait iFrameWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            iFrameWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='pact']")));
            System.out.println("iframe found");
            WebElement elementToHoverOver = driver.findElement(By.xpath("//iframe[@id='pact']")); // Replace with your element locator
            Actions actions = new Actions(driver);
            actions.moveToElement(elementToHoverOver).perform();
            System.out.println("hover successfully done");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='pact']"));
        driver.switchTo().frame(iframeElement);

        // Handling Shadow DOM inside Iframe.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement inputPizaaBox = (WebElement) js.executeScript("return document.querySelector(\"div#snacktime\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\")");
        inputPizaaBox.sendKeys("Farmhouse Pizza");
        Thread.sleep(5000);
        driver.quit();
    }
}

