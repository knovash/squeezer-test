package org.itacademy.squeezertest;

import lombok.extern.log4j.Log4j2;
import org.itacademy.squeezertest.models.AppList;
import org.itacademy.squeezertest.steps.MyAppsSteps;
import org.itacademy.squeezertest.utils.DataProviderAppNames;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Set;

@Log4j2
@Listeners
public class SqueezerTest extends BaseTest {

    private MyAppsSteps myAppsSteps = new MyAppsSteps();

    @Test(testName = "Check my apps list",
            dataProvider = "appNames",
            dataProviderClass = DataProviderAppNames.class)
    public void squeezerMyAppsTest(AppList appListOriginal) {
        log.info("TEST MY APPS START");
        myAppsSteps.inputServerAddress(SERVERADDRESS);
        myAppsSteps.buttonConnectClick();
        myAppsSteps.buttonTipsOkClick();
        myAppsSteps.buttonMyAppsClick();
        Set<String> appNames = myAppsSteps.getListAppNames();
        log.info("APP LIST ORIGINAL: " + appListOriginal.names);
        log.info("APP LIST GET: " + appNames);
        Assert.assertEquals(appListOriginal.names, appNames);
    }
}