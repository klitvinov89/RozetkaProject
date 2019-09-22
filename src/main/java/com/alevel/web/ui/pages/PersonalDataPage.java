package com.alevel.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDataPage extends BasePage {

    public PersonalDataPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "//header[@class='profile-heading']/*[contains(text(),'Мои заказы')]")
    @FindBy(xpath = "//h1[@class='float-lt']")
    private WebElement personalPageCaption;

    public String returnPersonalPageCaption(){
        return personalPageCaption.getText();
    }
}
