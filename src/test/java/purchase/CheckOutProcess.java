package purchase;

import basetests.BaseTests;
import org.testng.annotations.Test;
import pages.CheckOutPage;

import static org.testng.Assert.assertEquals;

public class CheckOutProcess extends BaseTests {
    @Test
    public void testCheckoutProcess(){
       var mainpage =homePage.clickLoginPage().LogIn();
       var shoppingCartPage= mainpage.clickShoppingCart();
       shoppingCartPage.emptyCart();
       goHome();
       var blueJeansPage = mainpage.clickApparelButton().clickBlueJeans();
       blueJeansPage.enterquantity(5);
       blueJeansPage.clickAddToCart();
       goHome();
       mainpage.clickShoppingCart();
       shoppingCartPage.ApplyCoupon("AutomationDiscount2");
       shoppingCartPage.clickAgreeToTerms();
       var checkoutPage = shoppingCartPage.clickCheckOut();
       checkoutPage.BillingAddress();
       checkoutPage.ShippingAddress(CheckOutPage.ShippingAddress.INSTORE);
//       checkoutPage.ShippingMethod(CheckOutPage.ShippingMethod.NEXTDAYAIR);
       checkoutPage.PaymentMethod(CheckOutPage.PaymentMethod.CHECKMONEY);
       checkoutPage.PaymentInfo();
       CheckOutPage.OrderConfirmation orderConfirmation = checkoutPage.new OrderConfirmation();
        System.out.println("Sub-Total is: "+orderConfirmation.getSubTotal() );
        System.out.println("Shipping Fee is: "+orderConfirmation.getShippingFee());
        System.out.println("Payment Method Fee is: "+ orderConfirmation.getPaymentMethodFee());
        System.out.println("Tax is: "+orderConfirmation.getTax());
        System.out.println("Discount is: "+orderConfirmation.getDiscount());
        System.out.println("Total is: "+orderConfirmation.getTotal());
        orderConfirmation.clickConfirm();
        assertEquals(checkoutPage.getVerificationSuccessMessage(),"Your order has been successfully processed!","Order is not verified");
        System.out.println(checkoutPage.getOrderNumber());
        checkoutPage.clickVerificationConfirm();





    }
}
