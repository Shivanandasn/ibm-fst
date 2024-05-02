import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.awt.Color.black;


public class testnga5{
   // WebDriver driver;


    @BeforeClass
    public void before() {
        System.out.println("before");
    }

@BeforeMethod
public void method(){
    System.out.println("method");
}

    @Test
    public void test1() {
        System.out.println("Test Case 1");
    }

    @Test
    public void test2() {
        System.out.println("Test Case 2");
    }



    @BeforeTest
    public void Test() {
        System.out.println("test");
    }

    @BeforeSuite
    public void suite() {
        System.out.println("suite");
    }

@BeforeGroups
    public void groups(){
        System.out.println("groups");
    }




}






