import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;

public class a16{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);



        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        String Title= driver.getTitle();
        System.out.print(Title);

        WebElement usernameInput = driver.findElement(By.cssSelector("input[type='text'][class$='-username']"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password'][class$='-password']"));
        passwordInput.sendKeys("password");

      WebElement passwordInput1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[3]/input"));
        passwordInput1.sendKeys("password1");

        WebElement email = driver.findElement(By.cssSelector("input[type='email'][class^='email-']"));
        email.sendKeys("email");

        passwordInput.sendKeys(Keys.ENTER);

        WebElement checkInput=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/button"));
        checkInput.click();

        WebElement loginmessage=driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        String messageText = loginmessage.getText();
        System.out.println("login message: " + messageText);

        //driver.quit();
    }
}
