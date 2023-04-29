package Edit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class login extends laboratorio2{


    public login() {
        element.findElement(By.name("\"customer_firstname\""));
        element.sendKeys("daniel");

        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        element.sendKeys("vidal");

        driver.findElement(By.id("passwd")).sendKeys("password");
        element.sendKeys("ultrasafepasword");
        element.findElement(By.name("password"));
        element.findElement(By.name("days"));
        Select select = new Select(element);
        select.selectByVisibleText("18  ");


        /**Date d = new Date(1);
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
         String date = formatter.format(d);
         String splitter[] = date.split("-");
         String month_year = splitter[1];
         String day = splitter[0];
         System.out.println(month_year);
         System.out.println(day);**/

    }

}
