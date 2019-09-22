package com.alevel.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppStoreAppPage extends BasePage {

    public AppStoreAppPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='product-header__title app-header__title']")
    private WebElement appName;

    public String returnCurrentAppName(){
        return appName.getText();
    }
}