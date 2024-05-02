import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.awt.Color.black;
import static org.openqa.selenium.devtools.v115.browser.Browser.close;


public class testnga7{
    WebDriver driver;


    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }



    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin", "password" },
                { "admin2", "password2" }
        };
    }


    @Test(dataProvider = "Authentication")
    public void testMethod(String sUsername, String sPassword) {
        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
        usernameInput.clear();
        usernameInput.sendKeys(sUsername);

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.clear();
        passwordInput.sendKeys(sPassword);

        WebElement checkInput = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        checkInput.click();
    }




    @AfterClass
    public void afterMethod() {
        driver.close();
    }

}






