package dataProviders;

import org.testng.annotations.DataProvider;

public class TheInternetLoginDataProvider {

    @DataProvider
    public Object[][] userValidLoginDataProvider() {
        return new Object[][]{{"tomsmith"},
                {"invalidLogin"}};
    }



}
