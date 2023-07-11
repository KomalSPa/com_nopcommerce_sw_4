package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutAsGuestPage extends Utility {
    By welcomeText = By.xpath("//h1[text()='Welcome, Please Sign In!']");
    By guestButton = By.xpath("//button[text()= 'Checkout as Guest']");
    By registerTab = By.xpath("//button[contains(text(),'Register')]");
    public String VerifytheWelComeText() {
        return getTextFromElement(welcomeText);
    }
    public void clickOnAsGuestButton() {
        clickOnElement(guestButton);
    }
    public void clickOnARegisterTab() {
        clickOnElement(registerTab);
    }
}
