package Edit;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class laboratorio1 {
    WebDriver driver;


    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void lab1Test() {
        setUp();
        System.out.println("hello automation world");
        driver.get("http://automationpractice.pl/index.php");
        driver.manage().window().maximize();
        WebElement webElement= driver.findElement(By.id("search_query_top"));
        webElement.click();
        webElement.sendKeys("blouse");
        webElement.sendKeys(Keys.ENTER);
        driver.manage().timeouts().getScriptTimeout();
        driver.close();

    }



}
