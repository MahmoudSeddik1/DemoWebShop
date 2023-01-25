package purchase;

import basetests.BaseTests;
import org.junit.*;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AddToCart extends BaseTests {
    @Test
    public void testAddToCart(){
        int qty = 5;
        var loginpage = homePage.clickLoginPage();
        loginpage.enteremail_predefined();
        loginpage.enterpassword_predefined();
        loginpage.clickRememberMe();
        var mainpage = loginpage.clickLogin();
//        mainpage.clickToDismissAlert();

        mainpage.clickShoppingCart().removeBlueJeans(); //Removing blue jeans if any is existing in shopping cart
        options().setImplicitWaitTimeout(Duration.ofSeconds(5));
        goHome();
        var bluejeanspage = mainpage.clickApparelButton().clickBlueJeans();
        bluejeanspage.enterquantity(qty);
        bluejeanspage.clickAddToCart();
        var shoppingcartpage = mainpage.clickShoppingCart();
        for(int i = 1;i<10;i++){
            if(shoppingcartpage.gettdContent(i,3).equals("Blue Jeans")){
                double qtycalc = Double.parseDouble(shoppingcartpage.gettdContent(i, 6)) / Double.parseDouble(shoppingcartpage.gettdContent(i, 4));
                assertEquals(qtycalc,qty ,"Error in quantity!");
                break;
            }
        }



    }
}
