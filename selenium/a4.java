import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class a4{
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");

        String Title= driver.getTitle();
        System.out.print(Title);


        WebElement thirdHeader = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        String thirdHeaderText = thirdHeader.getText();
        System.out.println("Text of the third header: " + thirdHeaderText);




        WebElement fifthHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        String headerColor = fifthHeader.getCssValue("color");
        System.out.println("Color of the fifth header: " + headerColor);
        String hexaValue=rgbToHex(headerColor);
        System.out.println(hexaValue);



        WebElement violetButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/button[3]"));
        String buttonClasses = violetButton.getAttribute("class");
        System.out.println("Classes of the violet button: " + buttonClasses);


        WebElement greybutton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        String text1 = greybutton.getText();
        System.out.println("Classes of the violet button: " + text1);

driver.quit();

    }

    public static String rgbToHex(String rgbValue) {
        String[] rgbComponents = rgbValue.replace("rgb(", "").replace(")", "").split(", ");
        int r = Integer.parseInt(rgbComponents[0]);
        int g = Integer.parseInt(rgbComponents[1]);
        int b = Integer.parseInt(rgbComponents[2]);
        return String.format("#%02x%02x%02x", r, g, b);
    }




}