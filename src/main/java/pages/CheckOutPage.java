package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CheckOutPage {
    WebDriver driver;
    private By InStore = By.xpath("//input[@id='PickUpInStore']");
    private By shippingaddress_continueButton = By.xpath("//div[@id='shipping-buttons-container']//input");
    private By billing_continueButton = By.xpath("//div[@id='billing-buttons-container']//input");
    private By shippingmethod_Option1Button = By.xpath("//input[@id='shippingoption_0']");
    private By shippingmethod_Option2Button = By.xpath("//input[@id='shippingoption_1']");
    private By shippingmethod_Option3Button = By.xpath("//input[@id='shippingoption_2']");
    private By shippingmethod_continueButton = By.xpath("//div[@id='shipping-method-buttons-container']//input");
    private By paymentmethod_Option1Button = By.xpath("//input[@id='paymentmethod_0']");
    private By paymentmethod_Option2Button = By.xpath("//input[@id='paymentmethod_1']");
    private By paymentmethod_Option3Button = By.xpath("//input[@id='paymentmethod_2']");
    private By paymentmethod_Option4Button = By.xpath("//input[@id='paymentmethod_3']");
    private By paymentmethod_continueButton = By.xpath("//div[@id='payment-method-buttons-container']//input");
    private By paymentinfo_PaymentInfo = By.xpath("//div[@class='info']//td");
    private By paymentinfo_continueButton = By.xpath("//div[@id='payment-info-buttons-container']//input");
//    private By OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr["+row+"]//td[2]//span");
    private By confirm_confirmButton = By.xpath("//div[@id='confirm-order-buttons-container']//input");
    private By successmessage = By.xpath("//div[@class='title']//strong");
    private By orderNumber = By.xpath("//ul[@class='details']//li[1]");
    private By verificationconfirmaitonButton = By.xpath("//div[@class='buttons']//input");




    public enum ShippingAddress {INSTORE, SHIP}

    public enum ShippingMethod {GROUND, NEXTDAYAIR, SECONDDAYAIR}

    public enum PaymentMethod {CODELIVEDY, CHECKMONEY, CREDITCARD, PURCHASEORDER}

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;

    }

    public void BillingAddress() {
        driver.findElement(billing_continueButton).click();
       mywait(5);

    }

    public void ShippingAddress(ShippingAddress shippingAddress) {
        switch (shippingAddress) {
            case INSTORE -> {
                driver.findElement(InStore).click();
                driver.findElement(shippingaddress_continueButton).click();
            }

            case SHIP -> driver.findElement(shippingaddress_continueButton).click();
        }
    }

    public void ShippingMethod(ShippingMethod shippingMethod) {
        switch (shippingMethod) {
            case GROUND -> {
                driver.findElement(shippingmethod_Option1Button).click();
                driver.findElement(shippingmethod_continueButton).click();
            }
            case NEXTDAYAIR -> {
                driver.findElement(shippingmethod_Option2Button).click();
                driver.findElement(shippingmethod_continueButton).click();
            }
            case SECONDDAYAIR -> {
                driver.findElement(shippingmethod_Option3Button).click();
                driver.findElement(shippingmethod_continueButton).click();
            }
        }

    }

    public void PaymentMethod(PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case CHECKMONEY -> {
                driver.findElement(paymentmethod_Option2Button).click();
                driver.findElement(paymentmethod_continueButton).click();
            }
            case CODELIVEDY -> {
                driver.findElement(paymentmethod_Option1Button).click();
                driver.findElement(paymentmethod_continueButton).click();
            }
            case CREDITCARD -> {
                driver.findElement(paymentmethod_Option3Button).click();
                driver.findElement(paymentmethod_continueButton).click();
            }
            case PURCHASEORDER -> {
                driver.findElement(paymentmethod_Option4Button).click();
                driver.findElement(paymentmethod_continueButton).click();
            }


        }


    }
    public String PaymentInfo() {
        String info = driver.findElement(paymentinfo_PaymentInfo).getText();
        driver.findElement(paymentinfo_continueButton).click();
        return info;
    }
    public  class OrderConfirmation {
        int row;
        private By OrderConfirmTable;
        public double getSubTotal() {
            row =1;
            OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr["+row+"]//td[2]//span");
            return Double.parseDouble(driver.findElement(OrderConfirmTable).getText());
        }
        public double getShippingFee(){
            row = 2;
            OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr["+row+"]//td[2]//span");
            return Double.parseDouble(driver.findElement(OrderConfirmTable).getText());
        }
        public double getPaymentMethodFee(){
            row = 3;
            OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr["+row+"]//td[2]//span");
            return Double.parseDouble(driver.findElement(OrderConfirmTable).getText());
        }
        public double getTax(){
            row = 4;
            OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr["+row+"]//td[2]//span");
            return Double.parseDouble(driver.findElement(OrderConfirmTable).getText());
        }
        public double getDiscount(){
            if(driver.findElement(By.xpath("//table[@class='cart-total']//tr["+5+"]//td[1]//span")).getText().equals("Discount :")) {
                row = 5;
                OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr[" + row + "]//td[2]//span");
            }
            return Double.parseDouble(driver.findElement(OrderConfirmTable).getText());
        }
        public double getTotal(){
            if(driver.findElement(By.xpath("//table[@class='cart-total']//tr["+5+"]//td[1]//span")).getText().equals("Discount :")) {
                row = 6;
                OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr[" + row + "]//td[2]//span");
            }else{
                row = 5;
                OrderConfirmTable = By.xpath("//table[@class='cart-total']//tr[" + row + "]//td[2]//span");
            }
            return Double.parseDouble(driver.findElement(OrderConfirmTable).getText());
        }

        public void clickConfirm(){
            driver.findElement(confirm_confirmButton).click();
        }



    }

    public String  getVerificationSuccessMessage(){
        return driver.findElement(successmessage).getText();
    }
    public String getOrderNumber(){
        return driver.findElement(orderNumber).getText();
    }
    public void clickVerificationConfirm(){
        driver.findElement(verificationconfirmaitonButton).click();
    }








    public void mywait(int s){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    }
    public void test(int a, Object... v){
        String s = "1";
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(InStore)).click();




    }

}
