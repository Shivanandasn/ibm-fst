import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class testNGActivity09 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void exampleTestCase() {
        WebElement username= driver.findElement(By.id("user_name"));
        username.sendKeys("admin");
        WebElement password=driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        WebElement button= driver.findElement(By.id("bigbutton"));
        button.click();
    }


    @Test
    public void testPrintTableRowNames() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        // Wait for the table to load
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.list.view")));

        // Get all rows of the table
        List<WebElement> rows = driver.findElements(By.cssSelector("table tr.oddListRowS1")); // Adjust the CSS selector according to your table structure

        String[] expectedNames = {"Mr. Raj Varma","Mr. Testing Demo57","Mr. Testing Navya45", "Mr. Testing Navya56", "Mr. Testing Navya7","Mr. Testing Navya30","Mr. Testing Navya47","Mr. navya Ajjar","deepali patil","DevLead"};
        String[] expectedUserNames = {"admin","admin","admin","admin","admin","admin","admin","admin","admin","admin",};

        for (int i = 0; i < rows.size() && i < 10; i++) {
            WebElement row = rows.get(i);
            WebElement nameElement = row.findElement(By.cssSelector("td[type='name'] a"));
            String name = nameElement.getText().trim();
            WebElement userElement = row.findElement(By.cssSelector("td[type='relate'] a"));
            String user = userElement.getText().trim();
            Assert.assertEquals(name, expectedNames[i], "Name of row " + (i + 1) + " is incorrect");
            Assert.assertEquals(user, expectedUserNames[i], "Name of row " + (i + 1) + " is incorrect");
        }
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
