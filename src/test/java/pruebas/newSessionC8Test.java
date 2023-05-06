package pruebas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import paginas.PaginaInicio;
import paginas.pageLogin;

public class newSessionC8Test {
    String url="http://automationpractice.pl/index.php";
    WebDriver driver;

    @BeforeSuite
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test (dataProvider = "Login data")
    public void iniciarSessionTest(String mail,String password) throws Exception {

        //click on sinIn
        PaginaInicio inicio= new PaginaInicio(driver);
        inicio.clickSignIn();


        //ingresar las credenciales(email,password)
        pageLogin login= new pageLogin(driver);
        login.inputCredentials(mail,password);
    }


    @DataProvider (name="Login data")
    public Object[][] obtenerData(){
        Object [][] data = new Object[5][2];
        data[0][0] = "mail@gmail.com";
        data[0][1] = "password123";

        data[1][0] = "mai2l@gmail.com";
        data[1][1] = "password123";

        data[2][0] = "mail1@gmail.com";
        data[2][1] = "password123";

        data[3][0] = "mail3@gmail.com";
        data[3][1] = "password123";

        data[4][0] = "mail4@gmail.com";
        data[4][1] = "password1234";

        return data;
    }






    @Test (enabled = false)
    public void BuscarPalabra(){
        PaginaInicio inicio= new PaginaInicio(driver);
        inicio.WriteWord("dress");
        inicio.hacerBusqueda();
    }

    @AfterSuite
    public void tearDown() throws Exception {driver.close();}
}
