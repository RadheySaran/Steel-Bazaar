package com.avighna.qa.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RFQPage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public RFQPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    // --- Web Elements ---

    @FindBy(xpath = "//div[contains(@class, 'webCloseButton')]/img[@alt='closeIcon']")
    private WebElement closeIcon;

    @FindBy(xpath = "//button[normalize-space(text())='Get Quote']")
    private WebElement getQuoteButton;

    @FindBy(xpath = "//input[@placeholder='Enter Full Name']")
    private WebElement fullNameInput;

    @FindBy(xpath = "//input[@name='mobileNumber']")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@placeholder='Enter GSTIN']")
    private WebElement gstinInput;

    @FindBy(xpath = "//*[contains(@class, 'cursor-pointer') and contains(@class, 'text-gray-500') and contains(@class, 'hover:text-black')]")
    private WebElement locationDropdown;

    @FindBy(xpath = "//button[normalize-space(text())='Next']")
    private WebElement nextButton;



    // --- Helper Validation Methods ---


     private void clickElement(WebElement element, String description) {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            System.out.println("Clicked: " + description);
        } catch (Exception e) {
            System.err.println("Error clicking " + description + ": " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void enterText(WebElement element, String value, String description) {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            element.clear();
            element.sendKeys(value);
            System.out.println("Entered " + description + ": " + value);
        } catch (Exception e) {
            System.err.println("Error entering " + description + ": " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z\\s]{3,50}$");
    }

    private boolean isValidMobile(String mobile) {
        return mobile != null && mobile.matches("^[6-9]\\d{9}$");
    }

    private boolean isValidGSTIN(String gstin) {
        return gstin != null && gstin.matches("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}[Z]{1}[0-9A-Z]{1}$");
    }

    

    // --- Action Method ---

    public void fillRFQForm(String name, String mobile, String gstin, String category, String specification, String quantity) throws InterruptedException {

        clickElement(closeIcon, "Close Icon");
        clickElement(getQuoteButton, "Get Quote Button");

        if (!isValidName(name)) throw new IllegalArgumentException("Invalid Name: " + name);
        enterText(fullNameInput, name, "Full Name");

        if (!isValidMobile(mobile)) throw new IllegalArgumentException("Invalid Mobile: " + mobile);
        enterText(mobileNumberInput, mobile, "Mobile Number");

        if (!isValidGSTIN(gstin)) throw new IllegalArgumentException("Invalid GSTIN: " + gstin);
        enterText(gstinInput, gstin, "GSTIN");

        try {
            WebElement companyNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='ANI TECHNOLOGIES PRIVATE LIMITED']")));
            System.out.println("Company Name: " + companyNameElement.getText());
        } catch (Exception e) {
            System.err.println("Company name not found: " + e.getMessage());
        }

        clickElement(locationDropdown, "Location Dropdown");
        clickElement(nextButton, "Next Button");
       
     
        
    }


    
}