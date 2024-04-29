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

public class a17{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);



        driver.get("https://v1.training-support.net/selenium/selects");

        String Title= driver.getTitle();
        System.out.print(Title);

        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        select.selectByIndex(3);
        select.selectByValue("4");

        List<WebElement> options = select.getOptions();
        System.out.println("Options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }




        //driver.quit();
    }
}
