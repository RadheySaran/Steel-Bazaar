package com.avighna.qa.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avighna.qa.base.Base;
import com.avighna.qa.pages.RFQPage;

public class RFQTest extends Base {

    private WebDriver driver;
    private RFQPage rfqPage;

    public RFQTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
        rfqPage = new RFQPage(driver);  // Initialize RFQPage object
    }

    @Test
    public void search() throws Throwable {
        rfqPage.fillRFQForm("Bhawesh Sah", "6396505156", "10AAJCA1389G1ZY", "Hot Rolled", "0.8 mm thickness", "50 MT");
    }

    @AfterMethod
    public void tearDown() {
    if (driver != null) {
        try {
            Thread.sleep(7000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
            // restore interrupted status
            Thread.currentThread().interrupt();
        }
        driver.quit();
        driver = null; 
    }
}

}

