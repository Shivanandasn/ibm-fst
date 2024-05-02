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


public class testnga3{
    // Declare the WebDriver object
    WebDriver driver;


    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }


    @Test
    public void TestCase1() {
        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys("password");

    }

    @Test
    public void TestCase2() {
        WebElement checkInput=driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
        checkInput.click();
        WebElement loginmessage=driver.findElement(By.id("action-confirmation"));
       Assert.assertEquals("Welcome Back, admin",loginmessage.getText());
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

}






