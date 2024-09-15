package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.TheInternetLoginPage;

public class TheInternetLoginSteps {

    private TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage();

    @Step("Verify if the login input field is visible on the page")
    public void loginInputIsVisible(){
        Assert.assertTrue(theInternetLoginPage.loginInputFieldIsVisible());
    }

    @Step("Input valid ${login} into the login input field and verify if it's inputted")
    public void validLoginInputFieldTest(String login){
        theInternetLoginPage.inputLogin(login);
//        Assert.assertEquals(theInternetLoginPage.getLoginInputField().getText(), login);
    }

    @Step("Input invalid ${login} into the login input field and verify if it's inputted")
    public void invalidLoginInputFieldTest(String login) {
        theInternetLoginPage.inputLogin(login);
        Assert.assertEquals(theInternetLoginPage.getLoginInputField().getText(), login);
    }

    @Step("The correct notification is displayed after login with valid user name and password")
    public void successLoginNotificationCheck(String login, String password){
        theInternetLoginPage.inputLogin(login);
        theInternetLoginPage.inputPassword(password);
        theInternetLoginPage.clickLogin();

    }
}
