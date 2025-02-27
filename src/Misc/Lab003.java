package Misc;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab003 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://amityonline.com/amity/home/eligibility?f=5245045");
        driver.manage().window().maximize();
        WebElement searchButton = driver.findElement(By.className("header_login__wzVUA"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4)); // Adjust timeout as needed
        try {
            WebElement formElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Form_control__eYGP8"))); // Replace with the actual locator
            System.out.println("Form page loaded!");
            // Now you can interact with the form
        } catch (TimeoutException e) {
            System.out.println("Form page did not load within the timeout: " + e.getMessage());
            // Handle the timeout (take screenshot, log error, fail the test)
        }
        WebElement email = driver.findElement(By.cssSelector("[placeholder='Enter Email Id']"));
        email.sendKeys("anuranjak@amityonline.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("AU12201996");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"_modal\"]/div/div/div/form/button"));
        submitButton.click();
        System.out.println("Login Successful");
        try {
            Thread.sleep(Long.parseLong("5000"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(Long.parseLong("5000"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
