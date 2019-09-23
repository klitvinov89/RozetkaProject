package com.alevel;

import com.alevel.web.ui.pages.GoogleMarketAppPage;
import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

public class AndroidAppLinkTest extends TestBase {

    @Test
    @Tag(name = "test1")
    public void checkThatAfterClickOnAndroidIconOpensGoogleMarketPage() throws InterruptedException {
        String appName = "Интернет-супермаркет Rozetka";
        GoogleMarketAppPage googleMarketAppPage = new MainPage(driver)
                .clickAndroidAppLink();
        String currentAppName = googleMarketAppPage.returnCurrentAppName();
        Assert.assertTrue(helper.containsIgnoreCase(currentAppName,appName));
    }
}