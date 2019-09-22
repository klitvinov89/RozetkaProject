package com.alevel;

import com.alevel.web.ui.pages.FaceBookPage;
import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FBSocIconTest extends TestBase {

    @Test
    public void checkThatAfterClickOnFBSocIconOpensFBPage() throws InterruptedException {
        String fbPageName = "Rozetka";
        FaceBookPage faceBookPage = new MainPage(driver)
                .clickOnFBSocNetworkIcon();
        String currentFBPageName = faceBookPage.returnCurrentFBPageName();
        Assert.assertTrue(helper.containsIgnoreCase(currentFBPageName,fbPageName));
    }
}