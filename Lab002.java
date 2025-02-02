//Open ebay.com and search for MacMini --> Print a list of all Mac mini items with their respective specs.

package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Lab002 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath(("//*[@id='gh-ac']")));
        searchBox.sendKeys("macmini");
        WebElement searchButton = driver.findElement(By.className("gh-search-button__label"));
        searchButton.click();
        List<WebElement> listItems = driver.findElements(By.className("s-item__title"));
        System.out.println("List of mac mini:");
        for (WebElement item : listItems) {
            // Extract the text content of the element
            String itemText = item.getText();
            System.out.println(itemText);
        }
            try {
            Thread.sleep(Long.parseLong("5000"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            driver.quit();
    }
}
