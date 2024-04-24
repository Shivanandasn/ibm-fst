import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class clickbutton{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net");
        WebElement aboutus = driver.findElement(By.id("about-link"));
        aboutus.click();
        String Title= driver.getTitle();
        System.out.print(Title);


        //driver.quit();
    }
}


