import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.awt.Color.black;


public class testnga2{
    // Declare the WebDriver object
    WebDriver driver;


    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void TestCase1() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
    }
    @Test(enabled = false)
    public void TestCase2() {
        WebElement green =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        Assert.assertTrue(green.isDisplayed());
        Assert.assertTrue(green.isSelected());
    }

    @Test
    public void TestCase3() {
    throw new SkipException("Skipping test case");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}






