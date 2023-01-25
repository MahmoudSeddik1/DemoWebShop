package InnoScripta;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InnoHomepage {
    WebDriver driver;

    public InnoHomepage(WebDriver driver){
        this.driver=driver;
    }
    public void clickLink(String Link){
        driver.findElement(By.linkText(Link)).click();
    }
    public RegistrierenPage clickRegistrieren(){
        clickLink("Registrieren");
        return new RegistrierenPage(driver);
    }
    public AnmeldenPage clickAnmeldenNewTab(){
        driver.findElement(By.linkText("Anmelden")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        return new AnmeldenPage(driver);
    }

}
