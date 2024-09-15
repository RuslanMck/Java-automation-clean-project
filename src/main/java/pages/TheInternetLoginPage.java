package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Setter
public class TheInternetLoginPage extends BasePage {


    private SelenideElement loginInputField = Selenide.$("#username");
    private SelenideElement passwordInputField = Selenide.$("#password");
    private SelenideElement loginButton = Selenide.$("[type='submit']");
    private SelenideElement resultNotification = Selenide.$("#flash");

    public boolean loginInputFieldIsVisible() {
        return loginInputField.is(Condition.visible);
    }

    public boolean passwordInputFieldIsVisible() {
        return passwordInputField.is(Condition.visible);
    }

    public boolean loginButtonIsVisible() {
        return loginButton.is(Condition.visible);
    }

    public void inputLogin(String login) {
        loginInputField.setValue(login);
    }

    public void inputPassword(String login) {
        passwordInputField.setValue(login);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public String getResultNotificationText(){
        return resultNotification.getText();
    }
}
