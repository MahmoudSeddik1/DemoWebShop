package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparelPage {
    WebDriver driver;
    private By blueJeans = By.linkText("Blue Jeans");
    private By addtocartbutton= By.xpath("//input[@type='button']");
    public ApparelPage(WebDriver driver){
        this.driver=driver;
    }
    public BlueJeansPage clickBlueJeans(){
        driver.findElement(blueJeans).click();
        return new BlueJeansPage(driver);
    }

}
