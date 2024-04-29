import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class a11 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println(title);
        WebElement checkBox=driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/label"));
        System.out.println("Checkbox displayed:"+checkBox.isDisplayed());
        System.out.println("Checkbox selected:"+checkBox.isSelected());
        WebElement select= driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        select.click();
        System.out.println("Checkbox selected:"+select.isSelected());


    }
}