package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Lab008 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder = 'Username']"))).sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        password.sendKeys("admin123");
        WebElement submit = driver.findElement(By.xpath("//button[@type= 'submit']"));
        submit.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']"))).click();
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder = 'First Name']"))).sendKeys("Newbie");
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder = 'Last Name']"))).sendKeys("Demo");
        WebElement save = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        save.click();
        System.out.println("Credentials saved");
        Thread.sleep(5000);
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']"))).click();
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@placeholder='Type for hints...'])[1]"))).sendKeys("Newbie");
        Thread.sleep(3000);
        WebElement search = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        search.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
