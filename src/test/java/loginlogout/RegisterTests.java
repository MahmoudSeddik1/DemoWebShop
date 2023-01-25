package loginlogout;

import basetests.BaseTests;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTests {
    @Test
    public void RegisterTest1_EmailAlreadyExists(){
        var registerPage = homePage.clickRegister();
        registerPage.chooseGender(RegisterPage.Gender.MALE);
        registerPage.setFirstName("TEST");
        registerPage.setLastName("TESTER");
        registerPage.setEmail("test.tester@test.test");
        registerPage.setPassword("Test123!");
        registerPage.setConfirmPassword("Test123!");
        registerPage.clickRegister();
        assertEquals(registerPage.getValidationMessage(),"The specified email already exists","Validation message not available!");
    }

}
