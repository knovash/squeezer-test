package org.itacademy.squeezertest.steps;

import com.codeborne.selenide.ElementsCollection;
import lombok.extern.log4j.Log4j2;
import org.itacademy.squeezertest.pages.SqueezerPage;
import org.itacademy.squeezertest.utils.WaitUtils;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Listeners
public class MyAppsSteps {

    private final SqueezerPage squeezerPage = new SqueezerPage();

    @Step("Input server address")
    public void inputServerAddress(String value) {
        log.info("inputServerAddress");
        WaitUtils.waitForElement(squeezerPage.inputServerAddress);
        Assert.assertTrue(squeezerPage.inputServerAddress.isDisplayed());
        log.info("inputServerAddress DISP: " + squeezerPage.inputServerAddress.isDisplayed());
        squeezerPage.inputServerAddress.setValue(value);
    }

    @Step("Button connect click")
    public void buttonConnectClick() {
        log.info("buttonConnectClick");
        WaitUtils.waitForElement(squeezerPage.buttonConnect);
        Assert.assertTrue(squeezerPage.buttonConnect.isDisplayed());
        log.info("buttonConnect DISP: " + squeezerPage.buttonConnect.isDisplayed());
        squeezerPage.buttonConnect.click();
    }

    @Step("Button tips ok click")
    public void buttonTipsOkClick() {
        log.info("buttonTipsOkClick");
        WaitUtils.waitForElement(squeezerPage.buttonTipsOk);
        Assert.assertTrue(squeezerPage.buttonTipsOk.isDisplayed());
        log.info("buttonTipsOk DISP: " + squeezerPage.buttonTipsOk.isDisplayed());
        squeezerPage.buttonTipsOk.click();
    }

    @Step("Button my apps click")
    public void buttonMyAppsClick() {
        log.info("buttonMyAppsClick");
        WaitUtils.waitForElement(squeezerPage.buttonMyApps);
        Assert.assertTrue(squeezerPage.buttonMyApps.isDisplayed());
        log.info("buttonMyApps DISP: " + squeezerPage.buttonMyApps.isDisplayed());
        squeezerPage.buttonMyApps.click();
    }

    @Step("Get list app names")
    public Set<String> getListAppNames() {
        log.info("viewMyAppsList");
        WaitUtils.waitForElement(squeezerPage.viewMyAppsList);
        Assert.assertTrue(squeezerPage.viewMyAppsList.isDisplayed());
        log.info("viewMyAppsList DISP: " + squeezerPage.viewMyAppsList.isDisplayed());
        ElementsCollection elementsMyApp = squeezerPage.viewMyAppsList.$$(By.xpath(".//android.view.ViewGroup"));
        log.info("SIZE: " + elementsMyApp.size());
        Set<String> listAppNames = elementsMyApp.stream()
                .map(element -> element.$(By.xpath(".//android.widget.TextView[1]")).getText())
                .peek(text -> log.info("APP: " + text))
                .collect(Collectors.toSet());
        return listAppNames;
    }
}