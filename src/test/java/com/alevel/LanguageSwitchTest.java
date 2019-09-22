package com.alevel;

import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageSwitchTest extends TestBase{

    @Test
    public void checkThatRuLanguageIsInactiveAfterUaLanguageClick(){
        boolean b = new MainPage(driver)
                .headerLanguageSwitchFromRuToUa()
                .returnStatusOfHeaderLanguageRu();
        Assert.assertTrue(b);
    }
}
