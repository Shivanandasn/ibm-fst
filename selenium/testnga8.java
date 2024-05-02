import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static java.awt.Color.black;
import static java.lang.String.valueOf;
import static org.openqa.selenium.devtools.v115.browser.Browser.close;


public class testnga8{
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }



    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin", "1", "asn@gmail.com", "9071520155", "hi" },
                { "admin", "2", "bsn@gmail.com", "9071520156", "hello" },
                { "admin", "3", "csn@gmail.com", "9071520157", "hi hello" }
        };
    }


    @Test(dataProvider = "Authentication")
    public void testMethod(String firstname, String lastname, String Email, String num, String message) {
        WebElement firstnameInput = driver.findElement(By.cssSelector("#firstName"));
        firstnameInput.clear();
        firstnameInput.sendKeys(firstname);

        WebElement lastnameInput = driver.findElement(By.cssSelector("#lastName"));
        lastnameInput.sendKeys(lastname);

        WebElement EmailInput = driver.findElement(By.cssSelector("#email"));
        EmailInput.sendKeys(Email);

        WebElement numInput = driver.findElement(By.cssSelector("#number"));
        numInput.sendKeys(num);

        WebElement messageInput = driver.findElement(By.cssSelector("#simpleForm > div > div:nth-child(5) > textarea"));
        messageInput.sendKeys(message);


        WebElement checkInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input"));
        checkInput.click();

        Alert alert=driver.switchTo().alert();
        alert.accept();

    }




    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

}






