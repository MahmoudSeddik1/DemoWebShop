package purchase;

import basetests.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApplyCoupon extends BaseTests {
    @Test
    public void testApplyCoupon_Success(){
        String Coupon= "AutomationDiscount2";
        var mainPage= homePage.clickLoginPage().LogIn();
       var apparelPage = mainPage.clickApparelButton();
       var bluejeansPage =apparelPage.clickBlueJeans();
       bluejeansPage.enterquantity(5);
       bluejeansPage.clickAddToCart();
       goHome();
       var shoppingcartPage = mainPage.clickShoppingCart();
       shoppingcartPage.ApplyCoupon(Coupon);//gets 20% discount

        assertEquals(shoppingcartPage.getVerificationMessage(),"The coupon code was applied");
        assertTrue(shoppingcartPage.getCurrentCoupon().contains(Coupon));


    }
    @Test
    public void testApplyCoupon_Failure_IncorrectCode(){
        String Coupon= "InvalidCode!";
        var mainPage= homePage.clickLoginPage().LogIn();
        var apparelPage = mainPage.clickApparelButton();
        var bluejeansPage =apparelPage.clickBlueJeans();
        bluejeansPage.enterquantity(5);
        bluejeansPage.clickAddToCart();
        goHome();
        var shoppingcartPage = mainPage.clickShoppingCart();
        shoppingcartPage.ApplyCoupon(Coupon);//gets 20% discount

        assertEquals(shoppingcartPage.getVerificationMessage(),"The coupon code you entered couldn't be applied to your order");
//        assertTrue(shoppingcartPage.getCurrentCoupon().contains(Coupon));


    }
}
