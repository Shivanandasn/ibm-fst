import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class crma9 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");
        WebElement username= driver.findElement(By.id("user_name"));
        username.sendKeys("admin");
        WebElement password=driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        WebElement button= driver.findElement(By.id("bigbutton"));
        button.click();
        // Close the browser
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        // Wait for the table to load
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.list.view")));

        // Get all rows of the table

        List<WebElement> rows = driver.findElements(By.cssSelector("table tr.oddListRowS1")); // Adjust the CSS selector according to your table structure

        for (int i = 0; i < rows.size() && i < 10; i++) {
            WebElement row = rows.get(i);
            WebElement nameElement = row.findElement(By.cssSelector("td[type='name'] a"));
            String name = nameElement.getText().trim();
            WebElement userElement = row.findElement(By.cssSelector("td[type='relate'] a"));
            String user = userElement.getText().trim();
            System.out.println("Name of row " + (i + 1) + ": " + name);
            System.out.println("Username of row " + (i + 1) + ": " + user);
        }

        driver.quit();
    }
}







