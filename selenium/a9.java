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

public class a9{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/ajax");

        String Title= driver.getTitle();
        System.out.print(Title);

        WebElement toggle = driver.findElement(By.cssSelector("button.ui.button[onClick='loadText()']"));
        toggle.click();



                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Maximum wait time of 10 seconds

// Wait until the text changes to "I'm late!"
                //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#ajax-content h1"), "HELLO!"));
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#ajax-content h3"), "I'm late!"));

// Get and print the updated text
                WebElement ajaxContent1 = driver.findElement(By.cssSelector("#ajax-content h1"));
                WebElement ajaxContent = driver.findElement(By.cssSelector("#ajax-content h3"));
                String original = ajaxContent1.getText();
                System.out.println(original);
                String updatedText = ajaxContent.getText();
                System.out.println(updatedText);

              //  driver.quit();
            }

        //driver.quit();

}
