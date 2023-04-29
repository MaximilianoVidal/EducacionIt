package Edit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class laboratorio2 {


    WebDriver driver;
    String url = "http://automationpractice.pl/index.php";
    WebElement element;

    @BeforeMethod
    public void lab2_E2() {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Sign")).click();
    }

    @Test
    public void goLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("#email_create")).sendKeys("unodostres@gmail.com");
        driver.findElement(By.cssSelector("#email_create")).sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.findElement(By.cssSelector("#id_gender1")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));

        driver.findElement(By.id("customer_firstname")).sendKeys("myname");
        driver.findElement(By.id("customer_lastname")).sendKeys("mySecondname");

        element = driver.findElement(By.xpath("//*[@id='email']"));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();

        element.sendKeys("newmail@gmail.com");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("password");

        Select selDays = new Select(driver.findElement(By.name("days")));
        selDays.selectByVisibleText("18 ");

        Select selMonths = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selMonths.selectByValue("6");

        Select selYear = new Select(driver.findElement(By.cssSelector("#years")));
        selYear.selectByValue("1999");

        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        driver.findElement(By.cssSelector("#optin")).click();

        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();



        driver.quit();

    }

}