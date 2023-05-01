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

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class laboratorio3 {
    WebDriver driver;
    String url = "http://automationpractice.pl/index.php";
    WebElement element;
    File pantalla;
    String dirEvidencias= "‪E:\\OneDrive\\Desktop\\java proyectos\\dataStuff";


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
        String tituloEsperado = "Contact i - My Store";
        String actualTittle =  driver.getTitle();
        Assert.assertEquals(tituloEsperado,actualTittle);


        selSubjet.selectByVisibleText("Customer service");

        driver.findElement(By.name("from")).sendKeys("correo@gmail.com");
        driver.findElement (By.cssSelector("#fileupload")).sendKeys("E:\\OneDrive\\Desktop\\curriculum vitae MVdev.pdf");
        driver.findElement(By.id("submitMessage")).click();
        WebElement lblMensaje = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your message has been successfully sent to our tea')]")));

            lblMensaje = driver.findElement(By.xpath("//p[contains(text(),'Your message has been successfully sent to our tea')]"));
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
