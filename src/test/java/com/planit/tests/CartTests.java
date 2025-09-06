package com.planit.tests;

import org.testng.annotations.Test;
import com.planit.base.BaseTest;
import com.planit.pages.HomePage;
import com.planit.pages.ShopPage;
import com.planit.pages.CartPage;

import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTest {

    @Test(description = "Verify cart calculations for multiple products")
    public void verifyCartCalculations() {
        HomePage home = new HomePage(driver);
        ShopPage shop = home.clickShop();

        shop.buy("Stuffed Frog", 2);
        shop.buy("Fluffy Bunny", 5);
        shop.buy("Valentine Bear", 3);

        CartPage cart = shop.clickCart();

        // Expected prices
        double frogPrice = 10.99;
        double bunnyPrice = 9.99;
        double bearPrice = 14.99;

        // Verify subtotals
        assertEquals(cart.getSubtotal("Stuffed Frog"), frogPrice * 2, "Stuffed Frog subtotal mismatch");
        assertEquals(cart.getSubtotal("Fluffy Bunny"), bunnyPrice * 5, "Fluffy Bunny subtotal mismatch");
        assertEquals(cart.getSubtotal("Valentine Bear"), bearPrice * 3, "Valentine Bear subtotal mismatch");

        // Verify unit prices
        assertEquals(cart.getPrice("Stuffed Frog"), frogPrice);
        assertEquals(cart.getPrice("Fluffy Bunny"), bunnyPrice);
        assertEquals(cart.getPrice("Valentine Bear"), bearPrice);

        // Verify total = sum of subtotals
        double expectedTotal = (frogPrice * 2) + (bunnyPrice * 5) + (bearPrice * 3);
        assertEquals(cart.getTotal(), expectedTotal, "Cart total mismatch");
    }
}
