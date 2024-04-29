import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;
import static org.openqa.selenium.Keys.SHIFT;

public class a12{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);



        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String Title= driver.getTitle();
        System.out.print(Title);
        List<WebElement> textField = driver.findElements(By.id("dynamicText"));
        System.out.println(textField.size());

        boolean isEnabledButton = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println(isEnabledButton);

        WebElement select= driver.findElement(By.id("toggleInput"));
        select.click();
        boolean isEnabledButton2 = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println(isEnabledButton2);



        //driver.quit();
    }
}
