package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;

public class CartTests extends BaseTest {

    @Test(priority = 3)
    public void testCase3_validateCartTotals() {
        HomePage home = new HomePage(driver);
        home.goToShopPage();

        ShopPage shop = new ShopPage(driver);
        shop.buyStuffedFrog(2);
        shop.buyFluffyBunny(5);
        shop.buyValentineBear(3);
        shop.goToCart();

        CartPage cart = new CartPage(driver);

        double stuffedFrogPrice = cart.getProductPrice("Stuffed Frog");
        double fluffyBunnyPrice = cart.getProductPrice("Fluffy Bunny");
        double valentineBearPrice = cart.getProductPrice("Valentine Bear");

        Assert.assertEquals(cart.getProductSubtotal("Stuffed Frog"), stuffedFrogPrice * 2);
        Assert.assertEquals(cart.getProductSubtotal("Fluffy Bunny"), fluffyBunnyPrice * 5);
        Assert.assertEquals(cart.getProductSubtotal("Valentine Bear"), valentineBearPrice * 3);

        double expectedTotal = (stuffedFrogPrice * 2) + (fluffyBunnyPrice * 5) + (valentineBearPrice * 3);
        Assert.assertEquals(cart.getTotal(), expectedTotal);
    }
}