package com.alevel.helper;

import com.alevel.web.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterHelper extends BasePage {

    public WaiterHelper(WebDriver driver) {
        super(driver);
    }

//    public static void waitUntilElementIsVisible( WebElement element){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

    public static ExpectedCondition<Boolean> elementIsPresent(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            private WebElement element;
            public ExpectedCondition<Boolean> forElement(WebElement element) {
                this.element = element;
                return this;
            }

            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }

            @Override
            public String toString() {
                return element.toString() + " to be present";
            }

        }.forElement(element);
    }
}
