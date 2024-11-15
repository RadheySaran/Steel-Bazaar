package com.avighna.qa.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.avighna.qa.base.Base;
import com.avighna.qa.pages.Homepage;
import com.avighna.qa.pages.LoginPage;

public class homepageTest extends Base {

    Homepage homepage;

    public homepageTest(){
        super();
       
    }

    public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
	}

    @Test
	public void search() throws Throwable {
		
       homepage= new Homepage(driver);
       homepage.search(prop.getProperty("standard_Catalog"));
       

		
	}
		

		
	}

