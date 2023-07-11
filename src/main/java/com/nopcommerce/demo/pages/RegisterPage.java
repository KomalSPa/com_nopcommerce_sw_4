package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By registerText = By.xpath("//h1[contains(text(),'Register')]\"), \"Register");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By emailId = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By registrationText = By.xpath("//div[contains(text(),'Your registration completed')]");
    By continueButtonText = By.xpath("//a[contains(text(),'Continue')]");
    By continueTab = By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]");

    public RegisterPage() {
    }

    public String verifyRegisterText() {
        return this.getTextFromElement(this.registerText);
    }

    public void enterFirstName(String text) {
        this.sendTextToElement(this.firstName, text + getAlphaNumericString(5));
    }

    public void enterLastName(String text) {
        this.sendTextToElement(this.lastName, text + getAlphaNumericString(5));
    }

    public void enterEmail(String text) {
        this.sendTextToElement(this.emailId, text);
    }

    public void enterPassword(String text) {
        this.sendTextToElement(this.password, text);
    }

    public void enterConfirmPassword(String text) {
        this.sendTextToElement(this.confirmPassword, text);
    }

    public void clickOnRegisterButton() {
        this.clickOnElement(this.registerButton);
    }

    public String verifyRegistrationText() {
        return this.getTextFromElement(this.registrationText);
    }

    public void clickOnContinueButton() {
        this.clickOnElement(this.continueButtonText);
    }

    public void clickOnContinueTab() {
        this.clickOnElement(this.continueTab);
    }
}
