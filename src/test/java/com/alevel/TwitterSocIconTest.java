package com.alevel;

import com.alevel.web.ui.pages.FaceBookPage;
import com.alevel.web.ui.pages.MainPage;
import com.alevel.web.ui.pages.TwitterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwitterSocIconTest extends TestBase {

    @Test
    public void checkThatAfterClickOnTwitterSocIconOpensTwitterPage() throws InterruptedException {
        String twitterPageName = "Rozetka";
        TwitterPage twitterPage = new MainPage(driver)
                .clickOnTwitterSocNetworkIcon();
        String currentFBPageName = twitterPage.returnCurrentTwitterPageName();
        Assert.assertTrue(helper.containsIgnoreCase(currentFBPageName,twitterPageName));
    }
}