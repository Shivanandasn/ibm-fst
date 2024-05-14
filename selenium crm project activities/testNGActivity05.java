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

public class testNGActivity05 {
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
    @Parameters({ "sUsername", "sPassword" })
    public void exampleTestCase(String sUsername, String sPassword) {
        WebElement username= driver.findElement(By.id("user_name"));
        username.sendKeys("admin");
        WebElement password=driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        WebElement button= driver.findElement(By.id("bigbutton"));
        button.click();
    }

    @Test
    public void testNavbarBackgroundColor() {
        // Wait until the URL contains the specified string
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        // Find the navbar element using its class name
        WebElement navbar = driver.findElement(By.className("navbar-inverse"));

        // Get the background color of the navbar
        String backgroundColor = navbar.getCssValue("background");

        // Print the background color to the console
        System.out.println("Background color of the navbar: " + backgroundColor);
        Assert.assertEquals(backgroundColor, "rgb(83, 77, 100)", "Background color of the navbar is incorrect");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
