package com.alevel;

import com.alevel.web.ui.pages.InstaPage;
import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstaPageTest extends TestBase {

    @Test
    public void checkThatAfterClickOnInstagramSocIconOpensInstagramPage() throws InterruptedException {
        String instaAccountName = "Rozetka";
        InstaPage instaPage = new MainPage(driver)
                .clickOnInstaSocNetworkIcon();
        String currentInstagramAccountName = instaPage.returnCurrentInstagrammAccountName();
        Assert.assertTrue(helper.containsIgnoreCase(currentInstagramAccountName,instaAccountName));
    }
}
