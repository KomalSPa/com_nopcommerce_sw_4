package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Jay Vaghani
 */
public class HomePage extends Utility {

    By desktop = By.linkText("Desktop");
    By welcomeText = By.xpath("//h2[contains(text(),'Welcome to our store')]");
    By logoutButton = By.xpath("//a[contains(text(),'Log out')]");

    By loginLink = By.linkText("Log in");

    By registerLink = By.linkText("Register");

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }
    public void selectMenu(String menu){
        String mainmenu = menu.toLowerCase();
        String expression = "//a[@href ='/" + mainmenu + "']";
        driver.findElement(By.xpath(expression)).click();
        String curruntUrl = driver.getCurrentUrl();
      //  Assert.assertEquals("Navigated successfully", curruntUrl, "Do not Navigate" + menu);
    }
    public void clickOnDesktop() { clickOnElement(desktop); }
    public void mouseHoverOnElectronics(){
        mouseHoverToElement(By.xpath("//div/ul[@class='top-menu notmobile']/li[2]/a[@href='/electronics']"));
    }
    public void mouseHoverOnCellPhoneAndClick(){
        mouseHoverToElementAndClick(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
    }
    public String verifyWelComeText(){
        return getTextFromElement(welcomeText);
    }
    public void clickOnLogOut() { clickOnElement(logoutButton);}
}
