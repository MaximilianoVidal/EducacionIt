package Edit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class laboratorio4 {
    WebDriver driver;
    String url = "http://automationpractice.pl/index.php";


    @BeforeMethod
    public void setting() {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
}
