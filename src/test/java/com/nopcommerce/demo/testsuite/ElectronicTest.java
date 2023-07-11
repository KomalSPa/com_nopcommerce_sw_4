package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    HomePage homePage = new HomePage();
    CellPhonePage cellPhonePage = new CellPhonePage();
    NokiaLumiaPage nokiaLumiaPage = new NokiaLumiaPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutAsGuestPage checkOutAsGuestPage = new CheckOutAsGuestPage();
    RegisterPage registerPage = new RegisterPage();
    BillingCheckOutPage billingCheckOutPage = new BillingCheckOutPage();
    ShippingMethodCheckoutPage shippingMethodCheckoutPage = new ShippingMethodCheckoutPage();
    PaymentMethodCheckOut paymentMethodCheckOut = new PaymentMethodCheckOut();
    PaymentCheckOut paymentCheckOut = new PaymentCheckOut();
    ConfirmOrderPage confirmorderPage = new ConfirmOrderPage();
    CompletedCheckoutPage completedCheckoutPage = new CompletedCheckoutPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        homePage.mouseHoverOnElectronics();
        homePage.mouseHoverOnCellPhoneAndClick();
        Assert.assertEquals(cellPhonePage.verifyCellPhoneText(),"Cell phones","InvalidText");
        // Assert.assertEquals(cellPhonePage.VerifyCellPhoneText(),"Cell phones","Test isnot Display");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnElectronics();
        homePage.mouseHoverOnCellPhoneAndClick();
        Assert.assertEquals(cellPhonePage.verifyCellPhoneText(),"Cell phones","InvalidText");
        cellPhonePage.clickOnList();
        cellPhonePage.clickOnNokia();
        Assert.assertEquals(nokiaLumiaPage.getNokiaLumiaText(),"Nokia Lumia 1020","InvalidText");
        Assert.assertEquals(nokiaLumiaPage.getNokiaLumiaPrice(),"$349.00","InvalidText");
        nokiaLumiaPage.changeQuantity();
        nokiaLumiaPage.clickOnAddToCartButton();
        Assert.assertEquals(nokiaLumiaPage.verifyGreenbarText(),"The product has been added to your shopping cart","Invalid Text");
        nokiaLumiaPage.verifyGreenbarText();
        nokiaLumiaPage.clickOnCrossButton();
        nokiaLumiaPage.mouseHoverOnShoppingCartButton();
        nokiaLumiaPage.clickOnGoToCart();
        Assert.assertEquals(shoppingCartPage.VerifytheShoppingCartText(),"Shopping cart","Invalid Text");
        shoppingCartPage.UpdateShoppingCart();
        // Assert.assertEquals(shoppingCartPage.getVerfiyUdateQuantity(),"2","InvalidText");
        //Assert.assertEquals(shoppingCartPage.getVerfiyTotal(),"$698.00","Invalid Text");
        shoppingCartPage.clickOnTerms();
        shoppingCartPage.clickOnCheckOut();
        Assert.assertEquals(checkOutAsGuestPage.VerifytheWelComeText(),"Welcome, Please Sign In!","Text is not matched");
        checkOutAsGuestPage.clickOnARegisterTab();
        //Assert.assertEquals(registerPage.verifyRegisterText(),"Register","Text is not matched");
        registerPage.enterFirstName("Hola");
        registerPage.enterLastName("Smith");
        registerPage.enterEmail("Hola123@mail.com");
        registerPage.enterPassword("lola123");
        registerPage.enterConfirmPassword("test123");
        registerPage.clickOnRegisterButton();
        Assert.assertEquals(registerPage.verifyRegistrationText(),"Your registration completed","InvalidText");
        registerPage.clickOnContinueButton();
        Assert.assertEquals(shoppingCartPage.VerifytheShoppingCartText(),"Shopping cart","InvalidText");
        shoppingCartPage.clickOnTerms();
        shoppingCartPage.clickOnCheckOutButton();
        //fill All Fields
        billingCheckOutPage.selectCountryFromDropDown("233");
        billingCheckOutPage.selectStateFromDropDown("0");
        billingCheckOutPage.enterBillingCity("London");
        billingCheckOutPage.enterBillingAddress("3,BondStreet");
        billingCheckOutPage.enterBillingZipcode("W2 5RT");
        billingCheckOutPage.enterBillingPhoneNumber("9858552255");
        registerPage.clickOnContinueTab();
        shippingMethodCheckoutPage.clickOn2ndDayAir();
        shippingMethodCheckoutPage.clickOnContinue();
        paymentMethodCheckOut.clickOnCreditCard();
        paymentMethodCheckOut.clickOnContinue();
        paymentCheckOut.selectCardTypeFromDropDown("visa");
        paymentCheckOut.enterCardHolderName("Jo Smith");
        paymentCheckOut.enterCardNumber("4222222222222");
        paymentCheckOut.selectExpiryMonthFromDropDown("10");
        paymentCheckOut.selectExpiryYearFromDropDown("2024");
        paymentCheckOut.enterCardCode("123");
        paymentCheckOut.clickOnContinueButton();
        Assert.assertEquals(confirmorderPage.VerifyCreditCardPaymentMethod(),"Credit Card","Method is not correct");
        Assert.assertEquals(confirmorderPage.VerifyShippingMethod2ndDayAir(),"2nd Day Air","Method is not correct");
        Assert.assertEquals(confirmorderPage.VerifytheNokiaTotalPrice(),"$698.00","Method is not correct");
        confirmorderPage.clickOnConFirm();
        Assert.assertEquals(completedCheckoutPage.verifyThankYouText(),"Thank you","Text isnot Display");
        Assert.assertEquals(completedCheckoutPage.verifySucessOrderText(),"Your order has been successfully processed!","Text isnot Display");
        completedCheckoutPage.clickOnContinue();
        Assert.assertEquals(homePage.verifyWelComeText(),"Welcome to our store","Text isnot Display");
        homePage.clickOnLogOut();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(baseUrl,currentUrl,"Invalid URL");
}}
