package com.nopcommerce.demo.utilities;

import com.nopcommerce.demo.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Created by Jay Vaghani
 */
public class Utility extends ManageBrowser {
    public Utility() {
    }

    public static String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for(int i = 0; i < n; ++i) {
            int index = (int)((double)AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElement(By by, String text) {
        WebElement emailField = driver.findElement(by);
        emailField.sendKeys(new CharSequence[]{text});
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        String alertText = driver.switchTo().alert().getText();
        return alertText;
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int indexNum) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNum);
    }

    public void closeAllWindows(List<String> hList, String parentWindow) {
        Iterator var3 = hList.iterator();

        while(var3.hasNext()) {
            String str = (String)var3.next();
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }

    }

    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        Iterator var3 = hList.iterator();

        String title;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            String str = (String)var3.next();
            title = driver.switchTo().window(str).getTitle();
        } while(!title.contains(windowTitle));

        System.out.println("Found the right window....");
        return true;
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseClick = driver.findElement(by);
        actions.moveToElement(mouseClick).click().build().perform();
    }

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long)time));
        return (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(final By by, int time, int pollingTime) {
        Wait<WebDriver> wait = (new FluentWait(driver)).withTimeout(Duration.ofSeconds((long)time)).pollingEvery(Duration.ofSeconds((long)pollingTime)).ignoring(NoSuchElementException.class);
        WebElement element = (WebElement)wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
}
