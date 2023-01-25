package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    WebDriver driver;
    private By shoppingcartbutton = By.linkText("Shopping cart");
    private By apparelButton = By.linkText("Apparel & Shoes");
    private By logoutButton = By.linkText("Log out");
    private By accountinfo = By.xpath("(//a[@class='account'])[1]");
    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    public ApparelPage clickApparelButton(){
        driver.findElement(apparelButton).click();
        return new ApparelPage(driver);
    }
    public void clickLogOut(){
        driver.findElement(logoutButton).click();
    }
    public ShoppingCartPage clickShoppingCart(){
        driver.findElement(shoppingcartbutton).click();
        return new ShoppingCartPage(driver);
    }
    public void clickLink(String link){
        driver.findElement(By.linkText(link)).click();
    }
    public String getUsername(){
        return driver.findElement(accountinfo).getText();
    }
    public void clickToDismissAlert(){
        driver.switchTo().alert().accept();
    }


}
