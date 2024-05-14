import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;
import static org.openqa.selenium.Keys.SHIFT;

public class crma6{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();


        driver.get("https://alchemy.hguy.co/crm/");

        WebElement usernameInput = driver.findElement(By.cssSelector("#user_name"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.cssSelector("#username_password"));
        passwordInput.sendKeys("pa$$w0rd");
        WebElement checkInput=driver.findElement(By.xpath("//*[@id=\"bigbutton\"]"));
        checkInput.click();

        WebElement navigationmenu = driver.findElement(By.cssSelector("#ajaxHeader > nav"));
        WebElement checkInput1=driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));
        checkInput1.click();




        driver.quit();
    }
}