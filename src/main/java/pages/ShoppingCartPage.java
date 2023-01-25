package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;
    private By tablerow= By.xpath("//tr[@class='cart-item-row']");
    private By productname = By.xpath("//a[@class='product-name']");
    private By unitprice = By.xpath("//span[@class='product-unit-price']");
    private By tablecheckbox = By.xpath("//table[@class='cart']//input[@type='checkbox']");
    private By updatebutton = By.xpath("//input[@value='Update shopping cart']");
    private By termsofservice = By.xpath("//input[@name='termsofservice']");
    private By checkoutButton = By.xpath("//button[@type='submit']");
    private By couponfield = By.xpath("//input[@name='discountcouponcode']");
    private By applycouponButton = By.xpath("//input[@name='applydiscountcouponcode']");
    private By couponverificationMessage = By.xpath("//div[@class='message']");
    private By currentcodeMessage = By.xpath("//div[@class='current-code']");
    private By agreetermsMessage = By.xpath("//div[@id='terms-of-service-warning-box']//P");


    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }
    public void removeBlueJeans() {
        try {
            driver.findElement(By.xpath("//td[@class='product']//a[text()='Blue Jeans']//preceding::td[2]//input")).click();
            clickUpdateButton();
        }catch(NoSuchElementException e){
            System.out.println("No Blue Jeans Found!");
        }
    }
    public void removeMusic2_10(){
        List<WebElement> music = driver.findElements(By.xpath("//td[@class='product']//a[text()='Music 2']//following::td[1]"));
        for(int i = 0; i< music.size();i++){
            if(Double.parseDouble(music.get(i).getText())==10.0) {
            driver.findElement(By.xpath("(//td[@class='product']//a[text()='Music 2'])["+i+1+"]//preceding::td[2]//input")).click();
            }
            clickUpdateButton();
        }
    }
    public void emptyCart() {
        try {
            do {
                driver.findElement(tablecheckbox).click();
                clickUpdateButton();
            } while (driver.findElements(tablecheckbox).size() > 0);

        }catch(NoSuchElementException e){
            System.out.println("Shopping Cart is empty!");
        }
    }
//        for (WebElement e : driver.findElements(tablecheckbox)) {
//            e.click();
//            clickUpdateButton();
//        }
//    }

    public void clickUpdateButton(){
        driver.findElement(updatebutton).click();
    }
    public String gettdContent(int row,int column){
        if(column==3){
            return driver.findElement(By.xpath("//table[@class='cart']//tr["+row+"]//td["+column+"]//a")).getText();
        }else{
            if(column==4){
                return driver.findElement(By.xpath("//table[@class='cart']//tr["+row+"]//td["+column+"]//span[@class='product-unit-price']")).getText();
            }else{
                if(column==5){
                    return driver.findElement(By.xpath("//table[@class='cart']//tr["+row+"]//td["+column+"]//input")).getText();
            }
        return driver.findElement(By.xpath("//table[@class='cart']//tr["+row+"]//td["+column+"]//span[@class='product-subtotal']")).getText();
    }
        }
    }
    public void clickAgreeToTerms(){
        driver.findElement(termsofservice).click();
    }
    public CheckOutPage clickCheckOut(){
        driver.findElement(checkoutButton).click();
        return new CheckOutPage(driver);
    }
    public String getAlertTextandClose(){
        String alertText =driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        return alertText;
    }
    public void ApplyCoupon(String coupon){
        driver.findElement(couponfield).sendKeys(coupon);
        driver.findElement(applycouponButton).click();
    }
    public String getVerificationMessage(){
        return driver.findElement(couponverificationMessage).getText();
    }
    public String getCurrentCoupon(){
        return driver.findElement(currentcodeMessage).getText();
    }
    public String getAgreeTermsMessageandClose(){
      String message=  driver.findElement(agreetermsMessage).getText();
        driver.findElement(By.xpath("//button[@title='close']")).click();
        return  message;
    }
}

