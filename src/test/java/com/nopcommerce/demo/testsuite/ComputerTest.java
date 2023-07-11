package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class ComputerTest extends BaseTest {
    HomePage homePage = new HomePage();
    DeskTopPage deskTopPage = new DeskTopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutAsGuestPage checkOutAsGuestPage = new CheckOutAsGuestPage();
    BillingCheckOutPage checkOutPage = new BillingCheckOutPage();
    ShippingMethodCheckoutPage checkoutPage1 = new ShippingMethodCheckoutPage();
    PaymentMethodCheckOut checkOutPage2 = new PaymentMethodCheckOut();
    PaymentCheckOut checkOutPage3 = new PaymentCheckOut();
    ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();
    CompletedCheckoutPage completedCheckoutPage = new CompletedCheckoutPage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        homePage.selectMenu("computers");
        homePage.clickOnDesktop();
        deskTopPage.selectSortByName("6");
        Map<String, ArrayList> mapArrays = deskTopPage.arrangeProductInDescendingOrder();
        Assert.assertEquals(mapArrays.get("originalProductsName"), mapArrays.get("afterSortByZToAProductsName"));


    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.selectMenu("computers");
        homePage.clickOnDesktop();
        deskTopPage.selectSortByName("5");
        deskTopPage.clickOnAddToCart();
        Assert.assertEquals(buildYourOwnComputerPage.VerifytheTextBuildyourowncomputer(),"Build your own computer" , "Text is not Display");
        buildYourOwnComputerPage.selectProcessor("1");
        buildYourOwnComputerPage.selectRam("5");
        buildYourOwnComputerPage.selectHDDRadio();
        buildYourOwnComputerPage.selectOSRadiVistaPremium();
        buildYourOwnComputerPage.selectSoftware();
        Assert.assertEquals(buildYourOwnComputerPage.VerifythePrice(),"$1,475.00" , "Price is not match");
        buildYourOwnComputerPage.clickOnAddToCartButton();
        Assert.assertEquals(buildYourOwnComputerPage.VerifytheMessageOnTopGreenbar(),"The product has been added to your shopping cart","Message doesnot match");
        buildYourOwnComputerPage.clickOnCloseBar();
        buildYourOwnComputerPage.mouseHoverOnShoppingCart();
        buildYourOwnComputerPage.clickOnShoppingCart();
        Assert.assertEquals(shoppingCartPage.VerifytheShoppingCartText(),"Shopping cart","Text is not display");
        shoppingCartPage.UpdateQuntity();
        shoppingCartPage.UpdateShoppingCart();
        Assert.assertEquals(shoppingCartPage.verifytheTotalPrice(),"$2,950.00","Price is not match");
        shoppingCartPage.clickOnCheckBox();
        shoppingCartPage.clickOnCheckOutButton();
        Assert.assertEquals(checkOutAsGuestPage.VerifytheWelComeText(),"Welcome, Please Sign In!","Text is not matched");
        checkOutAsGuestPage.clickOnAsGuestButton();
        //Fill ALl Fields
        checkOutPage.enterBillingFirstName("Hono");
        checkOutPage.enterBillingLastName("Lulu");
        checkOutPage.enterBillingEmailAddress("hono@lulu.com");
        checkOutPage.selectCountryFromDropDown("123");
        checkOutPage.selectStateFromDropDown("0");
        checkOutPage.enterBillingCity("London");
        checkOutPage.enterBillingAddress("20,England Street");
        checkOutPage.enterBillingZipcode("AB1 2CD");
        checkOutPage.enterBillingPhoneNumber("1252968574123");
        checkOutPage.clickOnCheckOutButton();
        Thread.sleep(5000);
        checkoutPage1.clickOnRedioButtonBextDayAir();
        checkoutPage1.clickOnContinue();
        checkOutPage2.clickOnCreditCard();
        checkOutPage2.clickOnContinue();
        checkOutPage3.enterCardHolderName("Hono Lulu");
        checkOutPage3.enterCardNumber("1212121245457878");
        checkOutPage3.selectExpiryMonthFromDropDown("3");
        checkOutPage3.selectExpiryYearFromDropDown("2025");
        checkOutPage3.enterCardCode("9955");
        checkOutPage3.clickOnContinueButton();
        Assert.assertEquals(confirmOrderPage.VerifyCreditCardPaymentMethod(),"Credit Card","Method is not correct");
        Assert.assertEquals(confirmOrderPage.verifyShippingMethod(),"Next Day Air","method is not correct");
        Assert.assertEquals(confirmOrderPage.verifytheTotalPrice(),"$2,950.00","Price is not Match");
        confirmOrderPage.clickOnConFirm();
        Assert.assertEquals(completedCheckoutPage.verifyThankYouText(),"Thank you","Text is not Display");
        Assert.assertEquals(completedCheckoutPage.verifySucessOrderText(),"Your order has been successfully processed!","Text is not Display");
        completedCheckoutPage.clickOnContinue();
        Assert.assertEquals(homePage.verifyWelComeText(),"Welcome to our store","Text is not Display");
    }
}
