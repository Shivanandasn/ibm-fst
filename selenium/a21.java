import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class a21{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);


        driver.get("https://v1.training-support.net/selenium/tab-opener");

        String Title= driver.getTitle();
        System.out.print(Title);

        WebElement confirmButton=driver.findElement(By.xpath("//*[@id=\"launcher\"]"));
        confirmButton.click();

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Window Handles:");
        for (String handle : handles) {
            System.out.println(handle);
        }


        //String Title1= driver.getTitle();
        //System.out.print(Title1);

        //WebElement newTabButton = driver.findElement(By.xpath("//*[@id=\"actionButton\"]"));
       // newTabButton.click();


        //driver.quit();
    }
}
