package com.alevel;

import com.alevel.web.ui.pages.MainPage;
import com.alevel.web.ui.pages.ViberPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViberPageTest extends TestBase {

    @Test
    public void checkThatAfterClickOnTwitterSocIconOpensTwitterPage() throws InterruptedException {
        String viberChatName = "Rozetka";
        ViberPage viberPage = new MainPage(driver)
                .clickOnViberSocNetworkIcon();
        String currentViberChatName = viberPage.returnCurrentYTChannelName();
        Assert.assertTrue(helper.containsIgnoreCase(currentViberChatName,viberChatName));
    }
}