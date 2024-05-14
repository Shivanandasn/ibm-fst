import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class crma10 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");
        // Enter login credentials into the respective fields
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        // Click login
        driver.findElement(By.id("bigbutton")).click();
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dashletTable")));
        // Count and Print the number and title of each Dashlet into the console
        List<WebElement> dashlets = driver.findElements(By.className("dashlet-title"));
        int numOfDashlets = dashlets.size();
        System.out.println("Total number of dashlets present are: "+ numOfDashlets);
        System.out.println("Titles of each dashlet present on home page: ");
        for(WebElement i: dashlets){
            System.out.println(i.getText());
        }
        // close browser
        driver.quit();
    }
}