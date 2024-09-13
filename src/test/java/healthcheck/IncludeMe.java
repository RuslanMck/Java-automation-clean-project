package healthcheck;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.HealthCheckSteps;


public class IncludeMe {

    @Test(description = "Health check test example")
    @Description("Health check test example")
    public void includeMe(){
        HealthCheckSteps healthCheckSteps = new HealthCheckSteps();
        Assert.assertTrue(healthCheckSteps.checkLoginAndPassword("Login123", "123qwe123"));
        Assert.assertTrue(healthCheckSteps.checkLoginAndPassword("Login123123", "123qw12312"));
        Assert.assertTrue(healthCheckSteps.checkLoginAndPassword("Login123123", "123q123123w"));
        Assert.assertTrue(healthCheckSteps.checkLoginAndPassword("Logi", "123"));
        System.out.println("Included test");
    }
}
