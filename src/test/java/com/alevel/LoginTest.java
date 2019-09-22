package com.alevel;

import com.alevel.dataprovider.GeneralDataProvider;
import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @Test
    public void checkUserLoginUsingPopUp() throws InterruptedException {
        String nameOfCurrentUser = GeneralDataProvider.USER_NAME;
        String loggedUser  = new MainPage(driver)
                .headerLoginButtonClick()
                .loginPopUpCredentialsInput(GeneralDataProvider.USER_EMAIL, GeneralDataProvider.USER_PASSWORD)
                .returnLoggedUserName();
            Assert.assertTrue(helper.containsIgnoreCase(loggedUser, nameOfCurrentUser));
        }
}

