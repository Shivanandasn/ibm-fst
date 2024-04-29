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

public class a10{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);



        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String Title= driver.getTitle();
        System.out.print(Title);

        List<WebElement> checkbox = driver.findElements(By.id("dynamicCheckbox"));
        System.out.println(checkbox.size());

        WebElement checkbox1 = driver.findElement(By.id("dynamicCheckbox"));
        boolean isCheckboxVisible = checkbox1.isDisplayed();
        System.out.println("Is checkbox1 visible? " + isCheckboxVisible);

        WebElement removeButton = driver.findElement(By.id("toggleCheckbox"));
        removeButton.click();

        boolean isCheckboxVisibleAgain = checkbox1.isDisplayed();
        System.out.println("Is checkbox1 visible again? " + isCheckboxVisibleAgain);


        //driver.quit();
    }
}
