import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;
import static org.openqa.selenium.Keys.SHIFT;

public class crma5{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/crm/");

        WebElement usernameInput = driver.findElement(By.cssSelector("#user_name"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.cssSelector("#username_password"));
        passwordInput.sendKeys("pa$$w0rd");
        WebElement checkInput=driver.findElement(By.xpath("//*[@id=\"bigbutton\"]"));
        checkInput.click();

        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));


        WebElement navigationPanel = driver.findElement(By.className("navbar-inverse"));
        String navigationPanelColor = navigationPanel.getCssValue("background-color");
        System.out.println("Navigation panel background color: " + navigationPanelColor);


        driver.quit();
    }
}