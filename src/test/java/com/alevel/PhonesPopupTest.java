package com.alevel;

import com.alevel.dataprovider.GeneralDataProvider;
import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhonesPopupTest extends TestBase{

    @Test
    public void checkThatPonePopupOpenedAfterClick(){
        String popUpCaption = GeneralDataProvider.HEADER_PHONES_POPUP_CAPTION;
        String captionOnPopup = new MainPage(driver)
                .headerPhoneLinkClick()
                .returnPhonesPopupCaption();
        Assert.assertTrue(helper.containsIgnoreCase(captionOnPopup, popUpCaption));
    }
}
