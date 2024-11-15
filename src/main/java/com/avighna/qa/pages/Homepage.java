package com.avighna.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage{
    
    WebDriver driver;

    public Homepage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
    @FindBy(xpath = "(//input[@placeholder='Search anything in steel...'])[1]")
    private WebElement cataloguesearchfield;
     
    @FindBy(xpath = "//li[text()='tata Hot Rolled Single length coil 10']")
    private WebElement cataloguefind;
     
    @FindBy(xpath = "//img[@class='cursor-pointer' and @src='/static/media/footerLogo.0b4b88fa279567e1afede2ba2f373af4.svg']")
    private WebElement steelbazaarIcon;

    @FindBy(xpath = "//img[@class='cursor-pointer' and @src='/static/media/footerLogo.0b4b88fa279567e1afede2ba2f373af4.svg']")
    private WebElement Categories;

    @FindBy(xpath = "(//button[normalize-space(text())='View All'])[1]")
    private WebElement viewallbutton;

     
    public void search(String searchText) throws Throwable {
		cataloguesearchfield.click();
		
		cataloguesearchfield.sendKeys("tata Hot Rolled Single length coil 10");

    
       if (cataloguefind != null){
        cataloguefind.click();
        System.out.println("catalogue found ");
       }
       else{
        System.out.println("catalogue not found ");
       }

       steelbazaarIcon.click();

       viewallbutton.click();


        
       }

       
	
		
	}


