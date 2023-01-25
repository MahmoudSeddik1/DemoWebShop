package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public String username= "mahmoud.seddik@expleogroup.test";
    private String password = "Tosca1234!";
    private By EmailField = By.id("Email");
    private By PasswordField = By.id("Password");
    private By RememberMeBox = By.id("RememberMe");
    private By LoginButton = By.xpath("//div[@class='buttons']//input[@type='submit']");
    private By emailvalidationerror = By.xpath("//span[@class='field-validation-error']");
    private By validationsummary = By.xpath("//div[@class='validation-summary-errors']");
    private By LogoutButton = By.linkText("Log out");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    ;
    public void enteremail_predefined() {
        driver.findElement(EmailField).sendKeys(username);
    }
    public void enteremail_custom(String Username) {
        driver.findElement(EmailField).sendKeys(Username);
    }
    public MainPage LogIn(){
        enteremail_predefined();
        enterpassword_predefined();
        clickRememberMe();
        clickLogin();
//        driver.switchTo().window("Save password?").close();
        return new MainPage(driver);
    }
    public void enterpassword_predefined() {
        driver.findElement(PasswordField).sendKeys(password);

    }

    public void enterpassword_custom(String Password) {
        driver.findElement(PasswordField).sendKeys(Password);
        System.out.println("Font size of word 'Password' is : " +
                driver.findElement(By.xpath("//label[@for='Password']")).getCssValue("font-size"));//trying to get CSS property
    }

    public MainPage clickLogin() {
        driver.findElement(LoginButton).click();
        return new MainPage(driver);
    }



    public void clickRememberMe() {
        driver.findElement(RememberMeBox).click();
    }

    public boolean checkValidationMessage() {
        try {
            if (driver.findElement(emailvalidationerror).isDisplayed())
                return true;
            else
                return false;

        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean checkIncorrectPassword() {
        try {
            if (driver.findElement(validationsummary).isDisplayed()
                    && driver.findElement(validationsummary).getText()
                    .contains("The credentials provided are incorrect"))
                return true;
            else
                return false;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkIncorrectEmail() {
        try {
            if (driver.findElement(validationsummary).isDisplayed()
                    && driver.findElement(validationsummary).getText()
                    .contains("No customer account found"))
                return true;
            else
                return false;

        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void normalLogin(String username, String password){
        driver.findElement(EmailField).sendKeys(username);
        driver.findElement(PasswordField).sendKeys(password);


    }
    public void clickLogout(){
        driver.findElement(LoginButton).click();
    }
}
