package loginlogout;

import basetests.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    @Test
    public void LoginTest1_Success(){
        String username = "mahmoud.seddik@expleogroup.test";
        String password = "Tosca1234!";
        var loginpage = homePage.clickLoginPage();
        loginpage.enteremail_custom(username);
        loginpage.enterpassword_custom(password);
        var mainpage = loginpage.clickLogin();
        assertEquals(mainpage.getUsername(),username,"Incorrect username!");
        mainpage.clickLogOut();


    }
    @Test
    public void LoginTest2_Failure_InvalidEmail(){
        String username = "mahmoud.seddik";
        String password = "Tosca123";
        var loginpage = homePage.clickLoginPage();
        loginpage.enteremail_custom(username);
        loginpage.enterpassword_custom(password);
        assertTrue(loginpage.checkValidationMessage(),"Validation message is not displayed!");
    }
    @Test
    public void LoginTest3_Failure_IncorrectPassword(){
        String username = "mahmoud.seddik@expleogroup.test";
        String password = "Tosca1234";
        var loginpage = homePage.clickLoginPage();
        loginpage.enteremail_custom(username);
        loginpage.enterpassword_custom(password);
        loginpage.clickLogin();
        assertTrue(loginpage.checkIncorrectPassword(),"Validation message is not displayed!");
    }
    @Test
    public void LoginTest4_Failure_IncorrectEmail(){
        String username = "ahmoud.seddik@expleogroup.test";
        String password = "Tosca123";
        var loginpage = homePage.clickLoginPage();
        loginpage.enteremail_custom(username);
        loginpage.enterpassword_custom(password);
        loginpage.clickLogin();
        assertTrue(loginpage.checkIncorrectEmail(),"Validation message is not displayed!");
    }
    @Test(dataProvider = "Excel")
    public void DataDriven(String username, String password){
        var loginpage = homePage.clickLoginPage();
        loginpage.normalLogin(username,password);
        impWait(5);
        assertTrue(loginpage.checkValidationMessage());
        loginpage.clickLogout();

    }

}
