import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNGActivity02 {
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
        WebElement img= driver.findElement(By.xpath("/html/body/div[1]/div[1]/a"));
        String url=img.getAttribute("href");
        Assert.assertEquals(url, "http://www.suitecrm.com/", "URL attribute doesn't match the expected URL");
        System.out.println(url);

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
