import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class a20{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);


        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        String Title= driver.getTitle();
        System.out.print(Title);
        WebElement confirmButton=driver.findElement(By.xpath("//*[@id=\"prompt\"]"));
        confirmButton.click();

        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);

       alert.sendKeys("Awesome");
       alert.accept();


        //driver.quit();
    }
}
