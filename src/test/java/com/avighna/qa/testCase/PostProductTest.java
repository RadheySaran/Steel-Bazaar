package com.avighna.qa.testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avighna.qa.base.Base;
import com.avighna.qa.pages.PostProduct;

public class PostProductTest extends Base {

    private WebDriver driver;
    private PostProduct postProduct;

    public PostProductTest(){
        super();
    }
    

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
        postProduct = new PostProduct(driver); // Initialize PostProduct page object
    }

    @Test
    public void search() throws Throwable {
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '85%';" +"document.body.style.overflow = 'auto';");



                postProduct.search("Null");
    }

    @AfterMethod
    public void tearDown() {
         
        
    }
}

