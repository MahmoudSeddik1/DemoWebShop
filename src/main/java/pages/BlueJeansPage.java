package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BlueJeansPage {
    WebDriver driver;
    private By qtybox = By.id("addtocart_36_EnteredQuantity");
    private By price = By.xpath("//span[@class='price-value-36']");
    private By addtocartbutton = By.id("add-to-cart-button-36");
    public BlueJeansPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterquantity(int quantity){
        driver.findElement(qtybox).sendKeys(Keys.chord(Keys.BACK_SPACE,""+quantity+""));
    }
    public double getPrice(){
        return Double.parseDouble(driver.findElement(price).getText());
    }
    public void clickAddToCart(){
        driver.findElement(addtocartbutton).click();
    }
}
