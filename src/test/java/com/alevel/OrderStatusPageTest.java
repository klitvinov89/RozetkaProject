package com.alevel;

import com.alevel.dataprovider.GeneralDataProvider;
import com.alevel.web.ui.pages.MainPage;
import com.alevel.web.ui.pages.PersonalDataPage;
import com.alevel.web.ui.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderStatusPageTest extends TestBase{

    @Test
    public void checkThatAfterLoginUserRedirectedToDetailPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        SignInPage signInPage = mainPage.headerOrderStatusLinkClick();
        PersonalDataPage personalDataPage = signInPage.loginPageCredentialsInput(GeneralDataProvider.USER_EMAIL, GeneralDataProvider.USER_PASSWORD);
        String pageCaption = personalDataPage.returnPersonalPageCaption();
        Assert.assertTrue(helper.containsIgnoreCase(pageCaption, "Мои заказы"));
    }
}
