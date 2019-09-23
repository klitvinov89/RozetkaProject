package com.alevel;

import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

public class CitySelectTest extends TestBase{
    @Test
    @Tag(name = "test1")
    public void checkThatUserCanSelectCityUsingCitySelectAtHeader() {
        String desiredSelectedCityName = "Харьков";
        String selectedCityName = new MainPage(driver)
                .clickOnTheCitySelectLink()
                .clickKharkivOnCitySelectPopUp()
                .returnCurrentSelectedCity();
        Assert.assertTrue(helper.containsIgnoreCase(desiredSelectedCityName, selectedCityName));
    }
}
