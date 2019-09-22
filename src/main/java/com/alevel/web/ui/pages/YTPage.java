package com.alevel.web.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.alevel.helper.WaiterHelper.elementIsPresent;

public class YTPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(MainPage.class);

    public YTPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//yt-formatted-string[@class='style-scope ytd-channel-name' and text()]")
    private WebElement channelName;

    public String returnCurrentYTChannelName(){
        elementIsPresent(channelName);
        return channelName.getText();
    }
}