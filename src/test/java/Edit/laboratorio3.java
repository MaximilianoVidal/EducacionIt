package Edit;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class laboratorio3 {
    WebDriver driver;
    String url = "http://automationpractice.pl/index.php";
    WebElement element;

    @BeforeMethod
    public void laboratorio3() {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Sign")).click();
    }
    @Test
    public void contactUs(){

        driver.findElement(By.linkText("Contact us")).click();
        Select selSubjet  = new Select (driver.findElement(By.id("id_contact")));
        selSubjet.selectByVisibleText("Customer service");

        driver.findElement(By.name("from")).sendKeys("correo@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("correo@gmail.com");






    }


}
