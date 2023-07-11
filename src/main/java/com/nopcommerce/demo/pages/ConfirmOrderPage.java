package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ConfirmOrderPage extends Utility {
    By paymentMethod = By.xpath("//span[contains(text(),'Credit Card')]");
    By shippingtMethod = By.xpath("//div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]");
    By price = By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]");
    By confirmbutton = By.xpath("//button[contains(text(),'Confirm')]");
    By secondDayAir = By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]");
    By verifyprice =By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]");
    public String VerifyCreditCardPaymentMethod() {
        return getTextFromElement(paymentMethod);
    }
    public String verifyShippingMethod() {
        return getTextFromElement(shippingtMethod);
    }
    public String verifytheTotalPrice() {
        return getTextFromElement(price);
    }
    public void clickOnConFirm() {
        clickOnElement(confirmbutton);    }

    public String VerifyShippingMethod2ndDayAir() {
        return getTextFromElement(secondDayAir);
    }
    public String VerifytheNokiaTotalPrice() {
        return getTextFromElement(verifyprice);
    }
}
