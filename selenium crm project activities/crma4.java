import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;
import static org.openqa.selenium.Keys.SHIFT;

public class crma4{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();


        driver.get("https://alchemy.hguy.co/crm/");

        WebElement usernameInput = driver.findElement(By.cssSelector("#user_name"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.cssSelector("#username_password"));
        passwordInput.sendKeys("pa$$w0rd");
        passwordInput.sendKeys(Keys.ENTER);
        WebElement checkInput=driver.findElement(By.xpath("//*[@id=\"bigbutton\"]"));
        checkInput.click();


        driver.quit();
    }
}