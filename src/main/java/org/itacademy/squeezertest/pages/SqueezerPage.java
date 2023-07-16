package org.itacademy.squeezertest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SqueezerPage {

    public SelenideElement inputServerAddress = $(By.id("uk.org.ngo.squeezer:id/server_address"));
    public SelenideElement buttonConnect = $(By.id("uk.org.ngo.squeezer:id/connect"));
    public SelenideElement buttonTipsOk = $(By.id("android:id/button1"));
    public SelenideElement buttonMyApps = $(By.xpath("(//android.widget.ImageView[@content-desc='Squeezer'])[5]"));
    public SelenideElement blockApps = $(By.xpath("//androidx.recyclerview.widget.RecyclerView"));
    public ElementsCollection listViewGroup = blockApps.$$(By.xpath(".//android.view.ViewGroup"));
    public SelenideElement viewMyAppsList = $(By.id("uk.org.ngo.squeezer:id/item_list"));

}