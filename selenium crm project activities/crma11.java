import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class crma11{
    public static void main(String[] args) {
        // Setup the Firefox driver (GeckoDriver) using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the CRM login page
            driver.get("http://alchemy.hguy.co/crm");

            // Initialize WebDriverWait with a 15 seconds timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Locate and interact with login elements
            WebElement usernameField = driver.findElement(By.id("user_name"));
            usernameField.sendKeys("admin");
            WebElement passwordField = driver.findElement(By.id("username_password"));
            passwordField.sendKeys("pa$$w0rd");
            driver.findElement(By.id("bigbutton")).click();

            // Wait until the Sales tab is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
            WebElement activity = driver.findElement(By.id("grouptab_0"));

            Actions action = new Actions(driver);
            action.moveToElement(activity).build().perform();

            WebElement nav = driver.findElement(By.id("moduleTab_9_Leads"));
            nav.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[4]")));

            WebElement importBtn = driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[4]"));
            importBtn.click();

            // Click on the Import button

            // Upload a file
            WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userfile")));
            String filePath = "C:\\Users\\ShivanandaSN\\Downloads\\Leads.csv";
            fileInput.sendKeys(filePath);

            // Click the Next button to proceed with the import
            WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("gonext")));
            nextButton1.click();

            WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("gonext")));
            nextButton2.click();

            // Submit to finish the import process
            WebElement nextButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gonext\"]")));
            nextButton3.click();

            WebElement importSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"importnow\"]")));
            importSubmitButton.click();

            WebElement viewLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[1]/div/div/div[1]/ul/li[3]/a/div[2]")));
            viewLead.click();

        } finally {
            // Ensure the browser is closed even if an exception occurs
           driver.quit();
        }
    }
}
