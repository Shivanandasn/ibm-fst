import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;
import static org.openqa.selenium.Keys.SHIFT;

public class crma1{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();


        driver.get("https://alchemy.hguy.co/crm/");

        String Title= driver.getTitle();
        System.out.print(Title);


        driver.quit();
    }
}