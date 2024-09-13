package selenideexample;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;
import pages.selenide.SelenideBlogPage;
import pages.selenide.SelenideHomePage;

public class SelenideExampleTest {

    @BeforeClass
    public void setUp() {

        Configuration.holdBrowserOpen = true;
        Configuration.savePageSource = false;
        Configuration.timeout = 3000;
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://www.google.nl/?hl=nl");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));


    }

    @Test
    public void selenideTest() {


        GoogleHomePage googleHomePage = new GoogleHomePage();
        SelenideHomePage selenideHomePage = new SelenideHomePage();
        SelenideBlogPage selenideBlogPage = new SelenideBlogPage();


        googleHomePage.waitUntilAcceptCookieButtonIsVisible().clickCookieAcceptButton().waitUntilSearchInputFieldIsVisible().inputSearchKey("Selenide").pressEnter();

        googleHomePage.waitUntilResultsAreVisible().verifyNumberOfResults(2).clickFirstResult();

        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://selenide.org/");

        selenideHomePage.waitUntilHeaderIsVisible().verifyHeaderText("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6").clickBlogLink();

        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://selenide.org/blog.html");

        selenideBlogPage.waitUntilHeaderIsVisible().checkHeaderText("Selenide blog");

    }
}

