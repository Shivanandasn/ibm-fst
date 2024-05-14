import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class crma12 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
//
//      // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        String parentWindowHandler = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement login = driver.findElement(By.id("user_name"));
        login.sendKeys("admin");
        WebElement pwd = driver.findElement(By.id("username_password"));
        pwd.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_3")));
        WebElement activity = driver.findElement(By.id("grouptab_3"));

        Actions action = new Actions(driver);
        action.moveToElement(activity).build().perform();

        WebElement nav = driver.findElement(By.id("moduleTab_9_Meetings"));
        nav.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[1]")));

        WebElement schBtn = driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[1]"));
        schBtn.click();

        //wait for the page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"save_and_send_invites_header\"]")));

        //Meeting name
        WebElement meetName = driver.findElement(By.id("name"));
        meetName.sendKeys("Testing");

        //invitees list
        WebElement Invitees = driver.findElement(By.id("invitees_search"));
        Invitees.click();

        //wait for the invitees to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"list_div_win\"]/table")));

        //add invitees
        driver.findElement(By.id("invitees_add_1")).click();
        driver.findElement(By.id("invitees_add_2")).click();
        driver.findElement(By.id("invitees_add_3")).click();

        //Click Save
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"SAVE_HEADER\"]"));
        saveBtn.click();

        //View Meetings
        WebElement viewBtn = driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[2]"));
        viewBtn.click();

        //Close the browser
        driver.quit();
    }
}











