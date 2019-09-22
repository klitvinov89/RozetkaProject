package com.alevel;

import com.alevel.config.EnvConfig;
import com.alevel.helper.VerificationHelper;
import com.alevel.helper.WaiterHelper;
import com.alevel.web.ui.driver.WebDriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private static final Logger LOGGER = Logger.getLogger(TestBase.class);

    /*
        LOGGER.fatal(); - всё сломано
        LOGGER.info(); - всё ок
        LOGGER.error(); - где-то вылез эксепшен
        LOGGER.debug(); - больше информации, когда у вас особенно закрученый
        LOGGER.trace(); - очень подкапотно, не используем
     */

    protected WebDriver driver;
    protected VerificationHelper helper;
    protected EnvConfig config;
    protected WaiterHelper waithelper;

    //перед всеми тестовыми методами
    @BeforeTest
    public void setUp() {
        config = new EnvConfig(System.getProperty("environment", "prod"));

        driver = WebDriverFactory.getDriver(System.getProperty("browser", "chrome"));
        driver.manage().timeouts().pageLoadTimeout(config.getTimeoutPageload(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(config.getTimeoutElemWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.get(config.getWebUrl());


        helper = new VerificationHelper();
        waithelper = new WaiterHelper(driver);
    }

    //Выполняется перед каждым методом помеченным аннотацией @Test
    @BeforeMethod
    public void openPage(){
//        LOGGER.info("Opened page with url " + config.getWebUrl());
        driver.get(config.getWebUrl());
    }

    @AfterMethod
    public void closePage(){
        driver.quit();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
