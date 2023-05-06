package pruebas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import paginas.PaginaInicio;
import paginas.pageLogin;

public class iniciarSessionTest {

    String url="http://automationpractice.pl/index.php";
    WebDriver driver;

    @BeforeSuite
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test
    public void iniciarSessionTest() throws Exception {

        //click on sinIn
        PaginaInicio inicio= new PaginaInicio(driver);
        inicio.clickSignIn();


        //ingresar las credenciales(email,password)
        pageLogin login= new pageLogin(driver);
        login.inputCredentials("maxividal77@gmail.com","ultrasafepassword");
    }

    @Test
    public void BuscarPalabra(){
        PaginaInicio inicio= new PaginaInicio(driver);
        inicio.WriteWord("dress");
        inicio.hacerBusqueda();
    }

    @AfterSuite
    public void tearDown() throws Exception {driver.close();}


}






