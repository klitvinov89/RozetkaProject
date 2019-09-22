package com.alevel;

import com.alevel.web.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CitySelectTest extends TestBase{
    @Test
    public void checkThatUserCanSelectCityUsingCitySelectAtHeader() {
        String desiredSelectedCityName = "Харьков";
        String selectedCityName = new MainPage(driver)
                .clickOnTheCitySelectLink()
                .clickKharkivOnCitySelectPopUp()
                .returnCurrentSelectedCity();
        Assert.assertTrue(helper.containsIgnoreCase(desiredSelectedCityName, selectedCityName));
    }
}
