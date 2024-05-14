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

public class testNGActivity10 {
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
    public void testPrintTableRowNames() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dashletTable")));

        // Count and Print the number and title of each Dashlet into the console
        List<WebElement> dashlets = driver.findElements(By.className("dashlet-title"));
        int numOfDashlets = dashlets.size();
        System.out.println(numOfDashlets);
        for(WebElement i: dashlets){
            System.out.println(i.getText());
        }
        int expectedNumOfDashlets = 10;
        String[] expectedDashletTitles = {"MY OPEN CASES", "MY OPEN TASKS", "MY EVENT", "EMAILS", "MY CONTRACTS",
                "MY LEADS", "MY ACTIVITY STREAM", "MY LEADS", "MY MEETINGS", "MY TOP OPEN OPPORTUNITIES"};

        // Assertions
        Assert.assertEquals(numOfDashlets, expectedNumOfDashlets, "Total number of dashlets is incorrect");

        for (int i = 0; i < expectedNumOfDashlets; i++) {
            Assert.assertEquals(dashlets.get(i).getText(), expectedDashletTitles[i], "Title of dashlet " + (i + 1) + " is incorrect");
        }
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
