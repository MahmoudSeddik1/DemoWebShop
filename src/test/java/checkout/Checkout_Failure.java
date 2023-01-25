package checkout;

import basetests.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Checkout_Failure extends BaseTests {
    @Test
    public void testing_Checkout_Failure(){
       var mainPage=  homePage.clickLoginPage().LogIn();
       mainPage.clickApparelButton().clickBlueJeans().clickAddToCart();
      var shoppingPage =mainPage.clickShoppingCart();
      shoppingPage.clickCheckOut();

      assertEquals(shoppingPage.getAgreeTermsMessageandClose(),"Please accept the terms of service before the next step.","Error message is not available!");




    }
}
