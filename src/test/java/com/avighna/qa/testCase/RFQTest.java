package com.avighna.qa.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
        rfqPage = new RFQPage(driver);
    }
    

    @DataProvider(name = "rfqData")
    public Object[][] getRFQTestData() {
        return new Object[][] {
            {"Bhawesh Sah", "6396505156", "10AAJCA1389G1ZY", "Hot Rolled", "0.8 mm thickness", "50 MT"},
            // {"Ravi Kumar", "8954497270", "22AABCN6808R1Z3", "Hot Rolled", "1.2 mm thickness", "25 MT"},
            // {"Neha Singh", "9758263603", "09AAACK4409J1ZI", "Hot Rolled", "0.6 mm thickness", "10 MT"}
        };
    }

    @Test(dataProvider = "rfqData")
    public void testFillRFQForm(String name, String mobile, String gstin, String category, String specification, String quantity) throws InterruptedException {
        rfqPage.fillRFQForm(name, mobile, gstin, category, specification, quantity);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(3000); // Optional pause
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            driver.quit();
        }
    }
}

