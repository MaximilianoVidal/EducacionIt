package Edit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

public class ScrollScreenTest {

    WebDriver driver;
    @Test
    public void scrollScreenTest() throws Exception {
        driver = new ChromeDriver();
        driver.get("http://www.bbc.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("..\\EducacionIt\\evidencias\\fullpageScrenshot.png"));

    }
}
