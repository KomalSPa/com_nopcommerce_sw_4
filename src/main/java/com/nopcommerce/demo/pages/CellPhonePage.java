package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CellPhonePage extends Utility {
    By cellphonesText = By.xpath("//div[@class='page-title']/h1[text() = 'Cell phones']");
    By listView = By.xpath("//div/a[text()='List']");
    By nokiaLumia =By.xpath("//h2/a[text()='Nokia Lumia 1020']");

    public String verifyCellPhoneText(){
        return getTextFromElement(cellphonesText);
    }
    public void clickOnList(){
        clickOnElement(listView);
    }
    public void clickOnNokia() throws InterruptedException {
        Thread.sleep(5000);
        clickOnElement(nokiaLumia);
    }}
