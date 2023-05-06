package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {

    //attributes or elements
    @FindBy(partialLinkText = "Sign")
    WebElement  lnkSignIn;

    @FindBy(id= "search_query_top")
    WebElement txtBuscador;

    @FindBy(name= "submit_search")
    WebElement btnLupe;


    //construtor
    public PaginaInicio(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    public void clickSignIn() {
        lnkSignIn.click();
    }

    public void WriteWord(String palabra){
        txtBuscador.sendKeys(palabra);
    }

    public void hacerBusqueda(){
        btnLupe.click();
    }





}
