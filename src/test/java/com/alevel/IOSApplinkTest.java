package com.alevel;

import com.alevel.web.ui.pages.AppStoreAppPage;
import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSApplinkTest extends TestBase {

    @Test
    public void checkThatAfterClickOnIOSIconOpensAppStorePage() throws InterruptedException {
        String appName = "Интернет-супермаркет Rozetka";
        AppStoreAppPage appStoreAppPage = new MainPage(driver)
                .clickIOSAppLink();
        String currentAppName = appStoreAppPage.returnCurrentAppName();
        Assert.assertTrue(helper.containsIgnoreCase(currentAppName,appName));
    }
}
