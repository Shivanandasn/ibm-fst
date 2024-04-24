import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class a23{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");
        // Clear field to empty it from any previous data
        WebElement userInput=driver.findElement(By.name("Username"));
        userInput.clear();
        String user="admin";
        userInput.sendKeys(user);

        //driver.quit();
        WebElement password=driver.findElement(By.name("Password"));
        password.clear();
        String pid="*****";
        password.sendKeys(pid);

        WebElement checkInput=driver.findElement(By.cssSelector("button.ui.button[type='submit']"));
        checkInput.click();
driver.quit();

    }
}
