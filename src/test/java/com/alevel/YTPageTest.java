package com.alevel;

import com.alevel.web.ui.pages.MainPage;
import com.alevel.web.ui.pages.YTPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YTPageTest extends TestBase {

    @Test
    public void checkThatAfterClickOnTwitterSocIconOpensTwitterPage() throws InterruptedException {
        String youtubeChannelName = "Rozetka";
        YTPage ytPage = new MainPage(driver)
                .clickOnYTSocNetworkIcon();
        String currentYTChannelName = ytPage.returnCurrentYTChannelName();
        Assert.assertTrue(helper.containsIgnoreCase(currentYTChannelName,youtubeChannelName));
    }
}