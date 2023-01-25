package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private  WebDriver driver;
    private By RegisterButton = By.linkText("Register");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public LoginPage clickLoginPage(){
        clickLink("Log in");
        return new LoginPage(driver);
    }
    public RegisterPage clickRegister() {
        driver.findElement(RegisterButton).click();
        return new RegisterPage(driver);
    }
    private void clickLink(String link){
        driver.findElement(By.linkText(link)).click();
    }
}
