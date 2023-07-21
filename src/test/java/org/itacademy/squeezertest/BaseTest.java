package org.itacademy.squeezertest;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

@Log4j2
@Listeners
public class BaseTest {

    private final ResourceBundle bundle = ResourceBundle.getBundle("config");
    public final String SERVERADDRESS = bundle.getString("serverAddress");

    public final String appPackage = bundle.getString("appPackage");
    public final String appActivity = bundle.getString("appActivity");
    public final String platformName = bundle.getString("platformName");
    public final String platformVersion = bundle.getString("platformVersion");
    public final String deviceName = bundle.getString("deviceName");
    public final String appiumDriver = bundle.getString("appiumDriver");

    private AppiumDriver<MobileElement> driver;

    @BeforeClass
//    @Parameters({"platformName", "platformVersion", "deviceName", "appiumDriver", "appPackage", "appActivity"})
    public void beforeMethod(
//            String platformName,
//            String platformVersion,
//            String deviceName,
//            String appiumDriver,
//            String appPackage,
//            String appActivity
    ) {
        log.info("BEFORE METHOD");

        log.info("START TYPE LOCAL");
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true));
//                .savePageSource(true)
//                .enableLogs(LogType.BROWSER, Level.ALL));


        WebDriverRunner.closeWebDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        try {
            driver = new AppiumDriver<>(new URL(appiumDriver), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        WebDriverRunner.setWebDriver(driver);
    }
}