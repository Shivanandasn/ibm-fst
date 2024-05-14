import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class crma8 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/crm/");

        WebElement usernameInput = driver.findElement(By.cssSelector("#user_name"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.cssSelector("#username_password"));
        passwordInput.sendKeys("pa$$w0rd");
        WebElement checkInput = driver.findElement(By.xpath("//*[@id=\"bigbutton\"]"));
        checkInput.click();

        WebElement navigationmenu = driver.findElement(By.cssSelector("#ajaxHeader > nav"));
        WebElement checkInput1 = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
        checkInput1.click();
        WebElement checkInput2 = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Accounts\"]"));
        checkInput2.click();
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.list.view")));

        // Get all rows of the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Print the names of the first 5 odd-numbered rows
        for (int i = 0; i < rows.size(); i++) {
            if (i % 2 != 0 && i < 10) { // Checking for odd number and printing only 5 rows
                WebElement row = rows.get(i);
                WebElement nameElement = row.findElement(By.cssSelector("td:nth-child(3)")); // Assuming the name is in the third column
                String name = nameElement.getText().trim();
                System.out.println("Name of row " + (i + 1) + ": " + name);
            }
        }

        driver.quit();
    }
}



     
