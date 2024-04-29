import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class a14{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);



        driver.get("https://v1.training-support.net/selenium/tables");

        String Title= driver.getTitle();
        System.out.print(Title);

        WebElement table = driver.findElement(By.xpath("//*[@id=\"sortableTable\"]"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        int rowCount = rows.size();
        System.out.println("Number of rows: " + rowCount);

        List<WebElement> columns = table.findElements(By.xpath(".//thead/tr/th"));
        int columnCount = columns.size();
        System.out.println("Number of columns: " + columnCount);

        List<WebElement> cols4 = table.findElements(By.xpath(".//tr[2]/td[2]"));
        for (WebElement element : cols4) {
            System.out.println(element.getText());
        }

        WebElement checkInput=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/thead/tr/th[1]"));
        checkInput.click();

        List<WebElement> cols5 = table.findElements(By.xpath(".//tr[2]/td[2]"));
        for (WebElement element : cols5) {
            System.out.println(element.getText());
        }


        List<WebElement> cols6 = table.findElements(By.xpath(".//tfoot/tr/th"));
        for (WebElement element : cols6) {
            System.out.println(element.getText());
        }
        //driver.quit();
    }
}
