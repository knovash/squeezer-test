package org.itacademy.squeezertest;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

@Log4j2
public class BaseTest {

    private final ResourceBundle bundle = ResourceBundle.getBundle("config");
    public final String SERVERADDRESS = bundle.getString("serverAddress");
    public final String APPIUMDRIVER = bundle.getString("appiumDriver");
    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    @Parameters({"platformName", "platformVersion", "deviceName", "appiumDriver", "appPackage", "appActivity"})
    public void beforeMethod(
            String platformName,
            String platformVersion,
            String deviceName,
            String appiumDriver,
            String appPackage,
            String appActivity
    ) {
        log.info("BEFORE METHOD");
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