package com.alevel.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name= 'login']")
    private WebElement userEmailInput;

    @FindBy(xpath = "//input[@name= 'password']")
    private WebElement userPasswordInput;

    @FindBy(xpath = "//button[@class= 'btn-link btn-link-blue btn-link-sign']")
    private WebElement LogInButton;

    public PersonalDataPage loginPageCredentialsInput(String userEmail, String userPassword) throws InterruptedException {
        userEmailInput.sendKeys(userEmail);
        userPasswordInput.sendKeys(userPassword);
        LogInButton.click();
//        LogInButton.wait(5000);
        return new PersonalDataPage(driver);
    }

}
