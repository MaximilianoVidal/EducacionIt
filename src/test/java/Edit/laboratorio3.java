package Edit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class laboratorio3 {
    WebDriver driver;
    String url = "http://automationpractice.pl/index.php";
    File pantalla;
    String dirEvidencias= "..\\EducacionIt";


    @BeforeMethod
    public void setting() {
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void contactUs(){

        driver.findElement(By.linkText("Contact us")).click();
        Select selSubjet  = new Select (driver.findElement(By.id("id_contact")));
        String tituloEsperado = "Contact us - My Store";
        String actualTittle =  driver.getTitle();
        Assert.assertEquals(tituloEsperado,actualTittle);


        selSubjet.selectByVisibleText("Customer service");

        driver.findElement(By.name("from")).sendKeys("correo@gmail.com");
        driver.findElement (By.cssSelector("#fileUpload")).sendKeys(
                "E:\\OneDrive\\Desktop\\curriculum vitae MVdev.pdf");
        driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("123ABC");
        driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de Contacto a la Empresa");
        driver.findElement(By.id("submitMessage")).click();

        WebElement lblMensaje = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//p[contains(text(),'Your message has been successfully sent to our tea')]")));

            lblMensaje = driver.findElement(By.xpath
                    ("//p[contains(text(),'Your message has been successfully sent to our tea')]"));
        } catch (Exception e) {e.printStackTrace();}
        Assert.assertNotNull(lblMensaje);


    }

    @Test(priority=200,description="CP02 Funcionalidad Buscar Palabra Caso Feliz")
    public void buscarPalabra() throws IOException {
        // Capturar Evidencia
        pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pantalla, new File(dirEvidencias + "01_pantallaPrincipal.jpg"));

        WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
        txtBuscador.sendKeys("dress");

        // Capturar Evidencia
        pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pantalla, new File(dirEvidencias + "02_palabraABuscar.jpg"));

        WebElement btnLupa = driver.findElement(By.name("submit_search"));
        btnLupa.click();

        // Capturar Evidencia
        pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pantalla, new File(dirEvidencias + "03_resultadoBusqueda.jpg"));

    }

    @AfterSuite
    public void despuesDeLaSuite() {
        // Se ejecuta después de terminar todos los @Test
        driver.close();
    }

}
