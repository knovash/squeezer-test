package org.itacademy.squeezertest;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

@Log4j2
public class BaseTest {

    private final ResourceBundle bundle = ResourceBundle.getBundle("config");
    public final String APPPAKAGE = bundle.getString("appPackage");
    public final String APPACTIVITY = bundle.getString("appActivity");
    public final String SERVERADDRESS = bundle.getString("serverAddress");
    public final String APPIUMDRIVER = bundle.getString("appiumDriver");
    public final String PLATFORMNAME = bundle.getString("platformName");
    public final String PLATFORMVERSION = bundle.getString("platformVersion");
    public final String DEVICENAME = bundle.getString("deviceName");

    private AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void beforeMethod() {
        log.info("BEFORE METHOD");
        WebDriverRunner.closeWebDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORMNAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORMVERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICENAME);
        capabilities.setCapability("appPackage", APPPAKAGE);
        capabilities.setCapability("appActivity", APPACTIVITY);
        try {
            driver = new AppiumDriver<>(new URL(APPIUMDRIVER), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        WebDriverRunner.setWebDriver(driver);
    }
}