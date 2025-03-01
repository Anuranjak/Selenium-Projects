//Open below-mentioned site -->Print all rows & columns dynamically & Get the details of any specific row and any column.
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Lab005 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        WebDriverWait webTableWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //Print all rows and columns dynamically:
        try {
            webTableWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'Web Tables']")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //Find no. of rows and columns
        WebElement table = driver.findElement(By.cssSelector("table.table-striped.mt-3"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        System.out.println("No. of rows = " + rows_table.size());

        if (!rows_table.isEmpty()) {
            WebElement headerRow = rows_table.getFirst();
            List<WebElement> columns_row = headerRow.findElements(By.tagName("th"));
            if (columns_row.isEmpty()) {
                columns_row = headerRow.findElements(By.tagName("td"));
            }
            System.out.println("No. of columns = " + columns_row.size());
            for (WebElement row : rows_table){ //Print all the data present in the table
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.println(cell.getText() + " | ");
                }
            }
        } else {
            System.out.println("Table is empty.");
        }
        // Access the cell in the 3rd row and 2nd column
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement targetRow = rows.get(2); // 3rd row (index 2)
        List<WebElement> cells = targetRow.findElements(By.tagName("td"));
        WebElement targetCell = cells.get(1); // 2nd column (index 1)
        String cellContent = targetCell.getText();
        System.out.println("Cell content: " + cellContent);
        Thread.sleep(3000);
        driver.quit();
    }
}
