import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGActivity04 {
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
        WebElement password=driver.findElement(By.id("username_password"));
        Assert.assertTrue(username.isEnabled());
        Assert.assertTrue(password.isEnabled());
        username.sendKeys(sUsername);
        password.sendKeys(sPassword);
        WebElement button= driver.findElement(By.id("bigbutton"));
        button.click();
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
