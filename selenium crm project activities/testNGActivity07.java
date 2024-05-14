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

public class testNGActivity07 {
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
    public void testPhoneNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        // Click on the 'Leads' tab
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        // Wait for the element to be clickable
        WebElement leadElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[10]/span/span")));
        leadElement.click();


        // Wait for the phone number element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-5")));
        WebElement phoneNumberElement = driver.findElement(By.xpath("/html/body/div[4]/div/div[7]/div[2]/span"));
        String phoneNumber = phoneNumberElement.getText();
        System.out.println("Phone Number: " + phoneNumber);

        // Verify the phone number
        String expectedPhoneNumber = "8639293295";
        Assert.assertEquals(phoneNumber, expectedPhoneNumber, "Phone number does not match");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
