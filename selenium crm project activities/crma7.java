import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class crma7 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/crm/");

        WebElement usernameInput = driver.findElement(By.cssSelector("#user_name"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.cssSelector("#username_password"));
        passwordInput.sendKeys("pa$$w0rd");
        WebElement checkInput = driver.findElement(By.xpath("//*[@id=\"bigbutton\"]"));
        checkInput.click();

        WebElement navigationmenu = driver.findElement(By.cssSelector("#ajaxHeader > nav"));
        WebElement checkInput1 = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
        checkInput1.click();
        WebElement checkInput2 = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"));
        checkInput2.click();

        WebElement leadElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[id='adspan_683f9f93-9423-1a6e-4a4d-5fd8a89ceaab']")));
        leadElement.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-5")));


        WebElement phoneNumberElement = driver.findElement(By.xpath("/html/body/div[4]/div/div[7]/div[2]/span"));


        String phoneNumber = phoneNumberElement.getText();
        System.out.println("Phone Number: " + phoneNumber);



        driver.quit();
    }

}
