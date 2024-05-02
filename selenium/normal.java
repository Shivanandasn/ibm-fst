import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class normal {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
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
    public void fillAndSubmitForm(String firstname, String lastname, String Email, String num, String message) {
        WebElement firstnameInput = driver.findElement(By.cssSelector("#firstName"));
        firstnameInput.clear();
        firstnameInput.sendKeys(firstname);

        WebElement lastnameInput = driver.findElement(By.cssSelector("#lastName"));
        lastnameInput.clear();
        lastnameInput.sendKeys(lastname);

        WebElement EmailInput = driver.findElement(By.cssSelector("#email"));
        EmailInput.clear();
        EmailInput.sendKeys(Email);

        WebElement numInput = driver.findElement(By.cssSelector("#number"));
        numInput.clear();
        numInput.sendKeys(num);

        WebElement messageInput = driver.findElement(By.cssSelector("#simpleForm > div > div:nth-child(5) > textarea"));
        messageInput.clear();
        messageInput.sendKeys(message);

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input"));
        submitButton.click();

        // Add assertions or validation if needed
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
