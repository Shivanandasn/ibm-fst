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

public class testNGActivity06 {
    WebDriver driver;

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
    public void testNav() {
        // Wait until the URL contains the specified string
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        driver.findElement(By.id("grouptab_3")).click();

        WebElement dropdownMenu = driver.findElement(By.className("dropdown-menu"));
        List<WebElement> dropdownOptions = dropdownMenu.findElements(By.xpath("//a[starts-with(@id, 'moduleTab')]"));
        for (WebElement option : dropdownOptions) {
            System.out.println(option.getText());
        }

        driver.findElement(By.id("moduleTab_9_Calendar")).click();

        String expectedUrl = "https://alchemy.hguy.co/crm/index.php?module=Calendar&action=index&parentTab=Activities";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Calendar page is not opened");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
