package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    private By gendermaleButton= By.xpath("//input[@id='gender-male']");
    private By genderfemaleButton = By.xpath("//input[@id='gender-female']");
    private By firstnamefield = By.xpath("//input[@id='FirstName']");
    private By lastnamefield = By.xpath("//input[@id='LastName']");
    private By emailfield = By.xpath("//input[@id='Email']");
    private By passwordfield = By.xpath("//input[@id='Password']");
    private By confirmpasswordfield = By.xpath("//input[@id='ConfirmPassword']");
    private By registerButton = By.xpath("//input[@id='register-button']");
    private By validationMessage = By.xpath("//div[@class='validation-summary-errors']//ul//li");

    public enum Gender{MALE,FEMALE}
    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }
    public void chooseGender(Gender gender){
        switch (gender){
            case MALE -> driver.findElement(gendermaleButton).click();
            case FEMALE -> driver.findElement(genderfemaleButton).click();
        }
    }
    public void setFirstName(String firstName){
        driver.findElement(firstnamefield).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        driver.findElement(lastnamefield).sendKeys(lastName);
    }
    public void setEmail(String email){
        driver.findElement(emailfield).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordfield).sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword){
        driver.findElement(confirmpasswordfield).sendKeys(confirmPassword);
    }
    public void clickRegister(){
        driver.findElement(registerButton).click();
    }
    public String getValidationMessage(){
        return driver.findElement(validationMessage).getText();
    }

}
