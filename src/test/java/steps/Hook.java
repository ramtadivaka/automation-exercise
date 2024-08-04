package steps;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import utils.Base;


/**
 * @author 
 * 
 */

public class Hook extends Base {


    public Hook(Base base) {
    }

    @Before
    public void InitializeTest(Scenario scenario) {

        System.out.println("Opening the browser : Chrome");        
        System.setProperty("webdriver.chrome.logfile", "./chromedriver.log");
        Base.driver = new ChromeDriver();
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
        	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("screenshots/" + scenario.getName() + ".png"));
                System.out.println("Screenshot saved for failed test: " + scenario.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser");
        Base.driver.quit();
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        //@To-DO
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
    	//@To-DO
    }

}
