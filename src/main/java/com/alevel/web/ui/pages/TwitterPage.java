package com.alevel.web.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.alevel.helper.WaiterHelper.elementIsPresent;

public class TwitterPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(MainPage.class);

    public TwitterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='ProfileHeaderCard-nameLink u-textInheritColor js-nav']")
    private WebElement pageName;

    public String returnCurrentTwitterPageName(){
        elementIsPresent(pageName);
        return pageName.getText();
    }
}