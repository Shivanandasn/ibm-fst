import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;
import static org.openqa.selenium.Keys.SHIFT;

public class a8{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);



        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String Title= driver.getTitle();
        System.out.print(Title);


        WebElement toggle = driver.findElement(By.id("toggleCheckbox"));
        toggle.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> toggle.isDisplayed());
        toggle.click();


        WebElement Checkbox = driver.findElement(By.id("toggleCheckbox"));

        // Click the checkbox
        Checkbox.click();

        System.out.println("toggleCheckbox clicked");

        // Click the toggle checkbox button again
        Checkbox.click();

        // Wait until the checkbox disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toggleCheckbox")));

        System.out.println("toggleCheckbox disappeared");

        driver.quit();
    }
}
