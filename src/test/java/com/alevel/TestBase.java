package com.alevel;

import com.alevel.config.EnvConfig;
import com.alevel.helper.VerificationHelper;
import com.alevel.helper.WaiterHelper;
import com.alevel.listener.AllureListener;
import com.alevel.web.ui.driver.WebDriverFactory;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners({AllureListener.class})
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
//    @BeforeTest
    @Step("Initializing {0} webdriver")
    private void initWebDriver(String driverName){
        driver = WebDriverFactory.getDriver(driverName);
        driver.manage().timeouts().pageLoadTimeout(config.getTimeoutPageload(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(config.getTimeoutElemWait(), TimeUnit.SECONDS);
    }

    //Выполняется перед каждым методом помеченным аннотацией @Test
    @BeforeMethod
    public void setUp() {
        config = new EnvConfig(System.getProperty("environment", "prod"));

        driver = WebDriverFactory.getDriver(System.getProperty("browser", "chrome"));
        driver.manage().timeouts().pageLoadTimeout(config.getTimeoutPageload(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(config.getTimeoutElemWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();

        AllureListener.setDriver(driver);

        helper = new VerificationHelper();
        waithelper = new WaiterHelper(driver);
        openPage();
    }

    public void openPage() {
        driver.get(config.getWebUrl());
    }

    @Step("Open page {0}")
    private void openPage(String url){
        LOGGER.info("Opened page with url " + url);
        driver.get(url);
    }

    @AfterMethod
    @Step("Closing webdriver")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

















































































