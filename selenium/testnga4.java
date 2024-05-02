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


public class testnga4{
    // Declare the WebDriver object
    WebDriver driver;


    @BeforeClass(alwaysRun = true)
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

    @Test (groups = "HeaderTests")
    public void TestCase2() {
        WebElement header =driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        Assert.assertEquals("Third header",header.getText());
        WebElement header5 =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        Assert.assertEquals("rgb(33, 186, 69)",header5.getCssValue("Color"));
    }


    @Test(groups = "ButtonTests")
    public void TestCase3() {
        WebElement button =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/button[4]"));
        Assert.assertEquals("Olive",button.getText());
        WebElement button1 =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        Assert.assertEquals("rgb(255, 255, 255)",button1.getCssValue("Color"));
    }






    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

}






