package com.alevel.web.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.alevel.helper.WaiterHelper.elementIsPresent;

public class FaceBookPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(MainPage.class);

    public FaceBookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[@id='seo_h1_tag']//span")
    private WebElement seoName;

    public String returnCurrentFBPageName(){
        elementIsPresent(seoName);
        return seoName.getText();
    }
}
