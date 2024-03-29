package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import support.DriverFactory;

import static java.lang.System.out;
import static setup.Environments.getPlatform;
import static setup.Environments.getTools;
import static utils.Screenshots.takingScreenshot;
import static support.GetSecrets.getSecrets;

public class Hooks extends DriverFactory {

    @Before
    public void start(Scenario scenario) throws Exception {
        driverFactory().setDriver();
        out.println("*********************************");
        out.println("Starting Test Execution...");

        if (getPlatform().equals("Android") && getTools().equals("appium")) {
            out.println("Platform Name: [" + getPlatform() + "]");
            out.println("Running Scenario: [" + scenario.getName() + "]");
            out.println("Execution Tag: " + scenario.getSourceTagNames());

        } else if (getPlatform().equals("Android") && getTools().equals("bs")) {
            out.println("Platform Name: [" + getPlatform() + "]");
            out.println("Device Name: [" + getSecrets().getDevice() + "]");
            out.println("BrowserStack Version: [" + getSecrets().getVersion() + "]");
            out.println("Running Scenario: [" + scenario.getName() + "]");
        }
        out.println("*********************************");
    }

    @AfterStep
    public void addingEvidenceReport(Scenario scenario) {
        takingScreenshot(scenario);
    }

    @After
    public void finish(Scenario scenario) {
        out.println(" ");
        out.println("*********************************");
        out.println("Scenario Status: [" + scenario.getStatus() + "]");
        out.println("Finishing Test Execution...");
        out.println("*********************************");
        out.println(" ");
        driver.quit();
    }
}