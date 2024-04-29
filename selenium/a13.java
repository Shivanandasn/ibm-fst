import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.apache.poi.sl.usermodel.TableCell.BorderEdge.left;
import static org.apache.poi.xslf.usermodel.XSLFTableStyle.TablePartStyle.firstCol;
import static org.apache.poi.xslf.usermodel.XSLFTableStyle.TablePartStyle.firstRow;
import static org.openqa.selenium.Keys.SHIFT;

public class a13{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);



        driver.get("https://v1.training-support.net/selenium/tables");

        String Title= driver.getTitle();
        System.out.print(Title);

        WebElement table = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table"));
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        int rowCount = rows.size();
        System.out.println("Number of rows: " + rowCount);

        WebElement firstRows = rows.get(0);
        List<WebElement> columns = firstRows.findElements(By.xpath(".//th"));
        int columnCount = columns.size();
        System.out.println("Number of columns: " + columnCount);

        List<WebElement> cols3 = table.findElements(By.xpath(".//tbody/tr[3]/td"));
        for (WebElement element : cols3) {
            System.out.println(element.getText());
        }

        List<WebElement> cols4 = table.findElements(By.xpath(".//tbody/tr[2]/td[2]"));
        for (WebElement element : cols4) {
            System.out.println(element.getText());
        }

        //driver.quit();
    }
}
