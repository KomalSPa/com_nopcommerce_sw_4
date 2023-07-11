package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class NokiaLumiaPage extends Utility {
    By NokiaLumiaText = By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]");
    By NokiaLumiaPrice = By.xpath("//span[@id='price-value-20']");
    By Addtocartbutton = By.cssSelector("#add-to-cart-button-20");
    By Greenbar = By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");
    By crossbutton = By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]");
    By shoppingCart = By.xpath("//span[contains(text(),'Shopping cart')]");
    By clickoncart = By.xpath("//button[contains(text(),'Go to cart')]");

    public String getNokiaLumiaText(){
        return getTextFromElement(NokiaLumiaText);
    }
    public String getNokiaLumiaPrice(){
        return getTextFromElement(NokiaLumiaPrice);
    }
    public void changeQuantity() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#product_enteredQuantity_20")).clear();
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");
    }
    public void clickOnAddToCartButton(){
        clickOnElement(Addtocartbutton);
    }
    public String verifyGreenbarText(){
        return getTextFromElement(Greenbar);
    }
    public void clickOnCrossButton(){
        clickOnElement(crossbutton);
    }
    public void mouseHoverOnShoppingCartButton(){
        mouseHoverToElement(shoppingCart);
    }
    public void clickOnGoToCart(){
        clickOnElement(clickoncart);
    }

}
