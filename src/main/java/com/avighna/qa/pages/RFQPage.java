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

    public RFQPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
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

    @FindBy(xpath = "//input[@id='Product Category*']")
    private WebElement CategoryDropdown;

   @FindBy(xpath = "//li[contains(text(), 'Hot Rolled')]")
   private WebElement hotRolledOption;

   @FindBy(xpath = "//input[@name='specification']")
   private WebElement OtpValidation;

   @FindBy(xpath = "//input[@placeholder='Enter' and @type='number']")
   private WebElement QuantityInput;

   @FindBy(xpath = "//img[contains(@src, 'plusIcon')]")
   private WebElement plusIcon;

   @FindBy(xpath = "//button[contains(text(), 'Verify')]")
   private WebElement VerifyButton;

   @FindBy(xpath = "//input[@placeholder='-' and @maxlength='1']")
   private WebElement EnterOTP;

   @FindBy(xpath = "//button[normalize-space()='Confirm']")
   private WebElement ConfirmOtp;

   @FindBy(xpath = "//img[@alt='closeIcon']")
   private WebElement CrossIcon;



    // --- Helper Validation Methods ---


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



   public void fillRFQForm(String name, String mobile, String gstin, String Category, String Specification, String Quantity) throws InterruptedException {
    try {
        Thread.sleep(2000);
        closeIcon.click();
    } catch (Exception e) {
        System.err.println("Failed to click close icon: " + e.getMessage());
        return;
    }

    try {
        Thread.sleep(2000);
        getQuoteButton.click();
    } catch (Exception e) {
        System.err.println("Failed to click Get Quote button: " + e.getMessage());
        return;
    }

    try {
        Thread.sleep(2000);
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid Name: " + name);
        }
        fullNameInput.click();
        fullNameInput.sendKeys(name);
        System.out.println("Entered Full Name: " + name);
    } catch (Exception e) {
        System.err.println("Error entering full name: " + e.getMessage());
        return;
    }

    try {
        Thread.sleep(2000);
        if (!isValidMobile(mobile)) {
            throw new IllegalArgumentException("Invalid Mobile Number: " + mobile);
        }
        Thread.sleep(1000);
        mobileNumberInput.click();
        mobileNumberInput.sendKeys(mobile);
        System.out.println("Entered Mobile Number: " + mobile);
    } catch (Exception e) {
        System.err.println("Error entering mobile number: " + e.getMessage());
        return;
    }

    try {
        Thread.sleep(2000);
        if (!isValidGSTIN(gstin)) {
            throw new IllegalArgumentException("Invalid GSTIN: " + gstin);
        }
        Thread.sleep(1000);
        gstinInput.click();
        gstinInput.sendKeys(gstin);
        System.out.println("Entered GSTIN: " + gstin);
       WebElement companyNameElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                                    .until(ExpectedConditions.visibilityOfElementLocated(
                                        By.xpath("//div[text()='ANI TECHNOLOGIES PRIVATE LIMITED']")));
         String companyName = companyNameElement.getText();
            System.out.println("Company Name: " + companyName);

       } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error entering GSTIN: " + e.getMessage());
        }



    try {
        Thread.sleep(2000);
        if (!locationDropdown.isDisplayed()) {
            throw new IllegalStateException("Location dropdown not visible");
        }
        locationDropdown.click();
        
    } catch (Exception e) {
        System.err.println("Error selecting location: " + e.getMessage());
        return;
    }

    try {
        Thread.sleep(2000);
        nextButton.click();
    } catch (Exception e) {
        System.err.println("Error clicking Next button: " + e.getMessage());
        return;
    }

    try{
        Thread.sleep(2000);
        CategoryDropdown.click();
        CategoryDropdown.sendKeys(Category);
        System.out.println("Entered Category: " + Category);
    } catch (Exception e){
        System.err.println("Error Clicking Category Dropdown" + e.getMessage());
        return;
    }

    try {
        Thread.sleep(2000); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(hotRolledOption));

        actions.moveToElement(hotRolledOption).click().perform();
        System.out.println("Selected category: Hot Rolled");
    } catch (Exception e) {
       System.err.println("Error selecting Hot Rolled category: " + e.getMessage());
       return;
}

   try{
         Thread.sleep(2000);
         OtpValidation.click();
         OtpValidation.sendKeys(Specification);
        System.out.println("Entered Specification: " + Specification);
    } catch (Exception e){
        System.err.println("Error Clicking Specification" + e.getMessage());
        return;
    }

    try{
        Thread.sleep(2000);
        QuantityInput.click();
        QuantityInput.sendKeys(Quantity);
        System.out.println("Entered Quantity: " + Quantity );
    } catch(Exception e){
        System.err.println("Error Clicking Quantity " + e.getMessage());
        return;
    }

    try {
        Thread.sleep(2000);
        plusIcon.click();
        System.out.println("Details have been successfully added.");
    } catch (Exception e) {
        System.err.println("Error clicking plusIcon: " + e.getMessage());
        return;
    }

    try{
        Thread.sleep(2000);
        VerifyButton.click();
        System.out.println("Verify Entred Number");
    } catch(Exception e){
      System.err.println("Error Clicking VerifyButton");
      return;
    }

    try{
         Thread.sleep(2000);
         EnterOTP.click();
    } catch (Exception e){
        System.err.println("Error Clicking OTP" + e.getMessage());
        return;
    }

     try{
        Thread.sleep(6000);
        ConfirmOtp.click();
        System.out.println("Confirm OTP");
    } catch(Exception e){
      return;
    }

     try {
        Thread.sleep(2000);
        CrossIcon.click();
        System.out.println("Request Submitted Successfully");
    } catch (Exception e) {
        System.err.println("Failed to click cross icon: " + e.getMessage());
        return;
    }

} 

}