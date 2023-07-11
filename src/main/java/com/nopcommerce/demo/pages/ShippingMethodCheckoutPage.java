package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShippingMethodCheckoutPage extends Utility {
    By nextdayAir = By.id("shippingoption_1");
    By continuebutton = By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]");
    By secondayAir = By.xpath("//input[@id='shippingoption_2']");

    public void clickOnRedioButtonBextDayAir(){
        clickOnElement(nextdayAir);
    }
    public void clickOnContinue(){
        clickOnElement(continuebutton);
    }
    public void clickOn2ndDayAir(){
        clickOnElement(secondayAir);
    }
}
