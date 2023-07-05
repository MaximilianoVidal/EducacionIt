package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageLogin {

    @FindBy(xpath ="//*[@id=\"email\"]")
    WebElement xlogin;

    @FindBy(css = "#passwd")
    WebElement txtPassword;
    String hola= "Hola";

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    public
    WebElement btnLogin;

    public pageLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



    public void inputCredentials(String email,String password){
        xlogin.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }





}
