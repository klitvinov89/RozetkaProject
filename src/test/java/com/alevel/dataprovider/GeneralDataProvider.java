package com.alevel.dataprovider;

public class GeneralDataProvider {

    @org.testng.annotations.DataProvider
    public Object[][] provide(){
        return new Object[][]{
                {"ноутбук asus"},
                {"4QW16ES"}
        };
    }
    public static final String  USER_NAME = "Константин Литвинов";
    public static final String  HEADER_PHONES_POPUP_CAPTION = "Контактные телефоны";
    public static final String  USER_EMAIL = "k.litvinov89@gmail.com";
    public static final String  USER_PASSWORD = "147866";
}
