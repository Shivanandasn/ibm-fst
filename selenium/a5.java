import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;

public class a5{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/input-events");

        String Title= driver.getTitle();
        System.out.print(Title);

//       WebElement leftClick = driver.findElement(By.id("wrapD3Cube"));
//        Actions actions = new Actions(driver);
//        actions.click(leftClick).build().perform();
//
//        WebElement clickable = driver.findElement(By.id("wrapD3Cube"));
//        new Actions(driver)
//                .doubleClick(clickable)
//                .perform();
//        WebElement dc = driver.findElement(By.className("active"));
//        String vdc=dc.getText();
//        System.out.println(vdc);

        WebElement rightClick = driver.findElement(By.id("wrapD3Cube"));
        new Actions(driver)
                .contextClick(rightClick)
                .perform();






        //driver.quit();
    }
}