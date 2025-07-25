package com.avighna.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostProduct {

    private WebDriver driver;
    private Actions actions;

    // --- Constructor ---
    public PostProduct(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // --- Web Elements ---

    @FindBy(xpath = "//div[contains(@class, 'webCloseButton')]/img[@alt='closeIcon']")
    private WebElement closeIcon;

    @FindBy(xpath = "//img[@class='cursor-pointer' and @alt='cartIcon']")
    private WebElement cartIcon;

    @FindBy(xpath = "//button[contains(text(), 'Login via email')]")
    private WebElement emailLoginButton;

    @FindBy(xpath = "//input[@placeholder='Enter Email Address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Enter Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[text()='Seller']")
    private WebElement sellerToggle;

    @FindBy(xpath = "//span[text()='My SteelBazaar']")
    private WebElement mysellerDropdown;

    @FindBy(xpath = "//span[text()='Post Product']")
    private WebElement postproducElement;

    @FindBy(xpath = "//button[text()='Add New Product']")
    private WebElement addNewProduct;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[contains(@class, 'PrivateSwitchBase-input') and @type='radio' and @value='27813']")
    private WebElement radioButton;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    private WebElement nextButtonElement;

    // --- Actions / Methods ---

    public void search(String searchText) throws InterruptedException {
        Thread.sleep(2000);
        closeIcon.click();

        Thread.sleep(2000);
        cartIcon.click();

        Thread.sleep(1000);
        emailLoginButton.click();

        emailInput.sendKeys("27AAQFT1057Q1ZD@gmail.com");

        Thread.sleep(1000);
        passwordInput.sendKeys("Tina@123");

        Thread.sleep(2000);
        loginButton.click();

        Thread.sleep(2000);
        cartIcon.click();

        Thread.sleep(1000);
        sellerToggle.click();

        mysellerDropdown.click();

        Thread.sleep(2000);
        postproducElement.click();

        Thread.sleep(2000);
        addNewProduct.click();

        moveMouseToElement(nextButton);
        radioButton.click();

        scrollToElement(nextButtonElement);
        moveMouseToElement(nextButtonElement);
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void moveMouseToElement(WebElement element) {
        try {
            actions.moveToElement(element).perform();
            Thread.sleep(1000);
            actions.moveToElement(element).click().perform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
