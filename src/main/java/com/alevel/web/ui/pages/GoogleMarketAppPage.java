package com.alevel.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMarketAppPage extends BasePage {

    public GoogleMarketAppPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='AHFaub']/span[contains(text(),'Rozetka')]")
    private WebElement appName;

    public String returnCurrentAppName(){
        return appName.getText();
    }
}