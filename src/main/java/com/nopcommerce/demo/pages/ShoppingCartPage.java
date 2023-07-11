package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShoppingCartPage extends Utility {
    By shoppingCartText = By.xpath("//div[@class='page-title']/h1[contains(text(),'Shopping cart')]");
    By updateCart = By.xpath("//button[@id='updatecart']");
    By price = By.xpath("//span[@class='product-subtotal'][text()='$2,950.00']");
    By checkboxTerms = By.id("termsofservice");
    By checkout = By.xpath("//button[@id='checkout']");
    By totalNokialumia = By.xpath("//tbody/tr[1]/td[6]/span[1]\"), \"$698.00");
    By quantityNokia = By.xpath("//td[@class='quantity']/child::input");
    By terms = By.id("termsofservice");
    By continueButton = By.xpath("//button[@id='checkout']");


    public String VerifytheShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }
    public void UpdateQuntity() throws InterruptedException {
        Thread.sleep(3000);
        WebElement Quantity = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        Quantity.clear();
        Quantity.sendKeys("2");
    }
    public void UpdateShoppingCart(){
        clickOnElement(updateCart);
    }
    public String verifytheTotalPrice() {
        return getTextFromElement(price);
    }
    public void clickOnCheckBox(){
        clickOnElement(checkboxTerms);
    }
    public void clickOnCheckOutButton(){
        clickOnElement(checkout);
    }
    public void verifyQuantity() throws InterruptedException {
        Thread.sleep(2000);
        String expectedQuantity = "2";
        WebElement wb = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        String actualQuantity = wb.getAttribute("value");
        //System.out.println(quantity);
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }
    public String getVerfiyUdateQuantity(){
        return getTextFromElement(quantityNokia);    }
    public String getVerfiyTotal(){
        return getTextFromElement(totalNokialumia);
    }
    public void clickOnTerms(){
        clickOnElement(terms);
    }
    public void clickOnCheckOut(){
        clickOnElement(continueButton);
    }
}
