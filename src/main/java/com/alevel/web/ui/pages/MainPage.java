package com.alevel.web.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import javax.swing.*;

import java.util.ArrayList;

import static com.alevel.helper.WaiterHelper.*;

public class MainPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(MainPage.class);
    //By searchInputLocator = By.xpath("//input[@name='q']");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //header
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@class='header-topline__user-link link-dashed']")
    private WebElement loginLink;

    @FindBy(xpath = "//button[@class='header-phones__button']")
    private WebElement headerPhone;

    @FindBy(xpath = "//p[@class='header-dropdown__title']")
    private WebElement headerContactPhonesPopupCaption;

    @FindBy(xpath = "//a[contains(text(), 'Отследить заказ')][1]")
    private WebElement headerOrderStatusLink;

    @FindBy(xpath = "//li[@class='header-topline__language-item']/span[@class='header-topline__language-item_state_active' and contains(text(),'RU')]")
    private WebElement headerLanguaugeRuActive;

    @FindBy(xpath = "//li[@class='header-topline__language-item']/span[@class='header-topline__language-item_state_active' and contains(text(),'UA')]")
    private WebElement headerLanguaugeUaActive;

    @FindBy(xpath = "//li[@class='header-topline__language-item']/a[contains(text(),'RU')]")
    private WebElement headerLanguaugeRuInactive;

    @FindBy(xpath = "//li[@class='header-topline__language-item']/a[contains(text(),'UA')]")
    private WebElement headerLanguaugeUaInactive;

    @FindBy(xpath = "//a[@class='header-cities__link link-dashed' and contains(text(),' Выберите город ')]")
    private WebElement headerCitiesSelect;

    @FindBy(xpath = "//div[@class='header-cities']//a ")
    private WebElement headerCitySelected;

    //login pop-up
    @FindBy(xpath = "//input[@id='auth_email']")
    private WebElement loginPopUpEmailInput;

    @FindBy(xpath = "//input[@id='auth_pass']")
    private WebElement loginPopUpPassInput;

    @FindBy(xpath = "//button[@class='button button_color_navy auth-modal__login-button']")
    private WebElement loginPopUpLogInButton;

    @FindBy(xpath = "//a[@class='header-topline__user-link link-dashed']")
    private WebElement loggedUserName;

    //CitiesSelectPop-Up
    @FindBy(xpath = "//a[@class='header-location__popular-link' and contains(text(),'Харьков ')]")
    private WebElement cityToSelectKharkiv;

    //LeftBar
    @FindBy(xpath = "//a[@class='main-stores__button' and @title='Приложение для Андроида']")
    private WebElement androidAppLink;

    @FindBy(xpath = "//a[@class='main-stores__button' and @title='Приложение для Айфона']")
    private WebElement iOSAppLink;

    //SocNetworks
    @FindBy(xpath = "//a[@class='main-socials__link main-socials__link_type_facebook']")
    private WebElement fbSocLink;

    @FindBy(xpath = "//a[@class='main-socials__link main-socials__link_type_twitter']")
    private WebElement twitterSocLink;

    @FindBy(xpath = "//a[@class='main-socials__link main-socials__link_type_youtube']")
    private WebElement youTubeSocLink;

    @FindBy(xpath = "//a[@class='main-socials__link main-socials__link_type_instagram']")
    private WebElement instagramSocLink;

    @FindBy(xpath = "//a[@class='main-socials__link main-socials__link_type_viber']")
    private WebElement viberSocLink;

    public MainPage inputSearchText(String text) {
        LOGGER.info("Text entered to search input '" + text + "'");
        searchInput.sendKeys(text);
        return this;
    }

    public SearchResultsPage startSearch() {
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public MainPage headerLoginButtonClick() {
        loginLink.click();
        return this;
    }

    public MainPage loginPopUpCredentialsInput(String userEmail, String userPassword) throws InterruptedException {
        loginPopUpEmailInput.sendKeys(userEmail);
        loginPopUpPassInput.sendKeys(userPassword);
        loginPopUpLogInButton.click();
//        loginPopUpLogInButton.wait(5000);
        return this;
    }

    public String returnLoggedUserName(){
        return loggedUserName.getText();
    }

    public MainPage headerPhoneLinkClick(){
        headerPhone.click();
        return this;
    }

    public String returnPhonesPopupCaption(){
        return headerContactPhonesPopupCaption.getText();
    }

    public SignInPage headerOrderStatusLinkClick(){
        headerOrderStatusLink.click();
        return new SignInPage(driver);
    }

    public MainPage headerLanguageSwitchFromRuToUa(){
        headerLanguaugeUaInactive.click();
        return this;
    }

    public boolean returnStatusOfHeaderLanguageRu() {
        elementIsPresent(headerLanguaugeRuInactive);
        return headerLanguaugeRuInactive.isDisplayed();
    }

    public GoogleMarketAppPage clickAndroidAppLink() throws InterruptedException {
        //find another expectation isClickable
        elementIsPresent(androidAppLink);
        Actions builder = new Actions(driver);
        builder.moveToElement(androidAppLink).perform();
        Thread.sleep(1000);
        androidAppLink.click();
        Thread.sleep(10000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String rozetka = tabs.get(0);
        String gm = tabs.get(1);
        System.out.println(tabs.get(1));
        driver.switchTo().window(rozetka);
        driver.close();
        driver.switchTo().window(gm);
//        String myWindowHandle = driver.getWindowHandle();
//        driver.switchTo().window(myWindowHandle);
        return new GoogleMarketAppPage(driver);
    }

    public AppStoreAppPage clickIOSAppLink() throws InterruptedException {
        elementIsPresent(iOSAppLink);
        Actions builder = new Actions(driver);
        builder.moveToElement(iOSAppLink).perform();
        Thread.sleep(1000);
        iOSAppLink.click();
        Thread.sleep(10000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String rozetka = tabs.get(0);
        String appstore = tabs.get(1);
        driver.switchTo().window(appstore);
        return new AppStoreAppPage(driver);
    }

    public MainPage clickOnTheCitySelectLink() {
        headerCitiesSelect.click();
        return this;
    }

    public MainPage clickKharkivOnCitySelectPopUp(){
        cityToSelectKharkiv.click();
        return this;
    }

    public String returnCurrentSelectedCity(){

        return headerCitySelected.getText();
    }

    public FaceBookPage clickOnFBSocNetworkIcon() throws InterruptedException {
        elementIsPresent(fbSocLink);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", fbSocLink);
        return new FaceBookPage(driver);
    }

    public TwitterPage clickOnTwitterSocNetworkIcon() throws InterruptedException {
        elementIsPresent(twitterSocLink);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", twitterSocLink);
        return new TwitterPage(driver);
    }

    public YTPage clickOnYTSocNetworkIcon() throws InterruptedException {
        elementIsPresent(youTubeSocLink);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", youTubeSocLink);
        return new YTPage(driver);
    }
    public InstaPage clickOnInstaSocNetworkIcon() throws InterruptedException {
        elementIsPresent(instagramSocLink);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", instagramSocLink);
        return new InstaPage(driver);
    }

    public ViberPage clickOnViberSocNetworkIcon() throws InterruptedException {
        elementIsPresent(viberSocLink);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", viberSocLink);
        return new ViberPage(driver);
    }
}


