import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class lastactivity {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/popups");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        WebElement hoverable = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/button"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        String hoveredText = hoverable.getText();
        System.out.println("Hovered text : " + hoveredText);

        WebElement login= driver.findElement(By.cssSelector("button.ui.huge[onClick='openModal()']"));
        login.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");
        WebElement login2= driver.findElement(By.cssSelector("button.ui.button[onClick='signIn()']"));
        login2.click();

        WebElement finalText = driver.findElement(By.id("action-confirmation"));
        String text = finalText.getText();
        System.out.println(text);
        //driver.quit();

    }
}




















