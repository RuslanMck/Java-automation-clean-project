package theInternetTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import dataProviders.TheInternetLoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TheInternetLoginPage;
import steps.TheInternetLoginSteps;


public class TheInternetLoginTests {

    private TheInternetLoginSteps theInternetLoginSteps = new TheInternetLoginSteps();
    private TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage();


    @BeforeClass
        public void setUp(){
        Configuration.browserSize= "1920x1080";
        Selenide.open("https://the-internet.herokuapp.com/login");

    }

//    @Test(description = "Validate the visibility of the login input field for the user")
//    public void loginInputVisibilityVerification(){
//        theInternetLoginSteps.loginInputIsVisible();
//    }

    @Test(dataProvider = "userValidLoginDataProvider",
            dataProviderClass = TheInternetLoginDataProvider.class,
            description = "Validate that login can be populated")
    public void validLoginIsInputted(String login){
        theInternetLoginSteps.validLoginInputFieldTest(login);
        Assert.assertEquals(theInternetLoginPage.getLoginInputField().getValue(), login);
        System.out.println(login + "is used");

    }

    @Test(description = "Validate the succass login notification")
    public void validSuccessNotificationIsDisplayed(){
        theInternetLoginSteps.successLoginNotificationCheck("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(theInternetLoginPage.getResultNotificationText(), "You logged into a secure area!\n" + "×");
    }

}
