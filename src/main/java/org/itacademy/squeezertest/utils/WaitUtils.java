package org.itacademy.squeezertest.utils;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class WaitUtils {

    public static void waitForElement(long millis) {
        log.info("wait");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElement() {
        log.info("wait");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElement(SelenideElement element) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElement(SelenideElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}