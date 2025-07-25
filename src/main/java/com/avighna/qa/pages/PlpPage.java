package com.avighna.qa.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlpPage {

	WebDriver driver;

	public PlpPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[text()=\"View All\"])[1]")
	private WebElement viewAllButton;

	@FindBy(xpath = "(//img[@src=\"/static/media/plusFilledIcon.74d6daa7f208547719abdf3e51f9959c.svg\"])[2]")
	private WebElement plusButton;

	@FindBy(xpath = "(//*[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[1]")
	private WebElement checkBox;

	@FindBy(xpath = "(//*[text()=\"View More\"])[1]")
	private WebElement viewMoreButton;

	@FindBy(xpath = "//*[@class = \"py-2 px-3 text-sm font-medium rounded w-max category-0-2-1556 activeTabTitle-0-2-1557 \"]")
	private WebElement prodCtaegory1;

	@FindBy(xpath = "(//*[@class = \"py-2 px-3 text-sm font-medium rounded w-max category-0-2-1556  \"])[1]")
	private WebElement prodCtaegory2;

	@FindBy(xpath = "(//*[@class = \"attributeTitle-0-2-1581 text-xs font-medium\"])[1]")
	private WebElement thicknessValue;

	@FindBy(xpath = "(//*[@class=\"priceValue-0-2-1583 text-lg font-bold\"])[1]")
	private WebElement priceValue;

	@FindBy(xpath = "(//div[@class=\"text-sm font-medium text-wrap truncate catalogueName-0-2-1580\"])[1]")
	private WebElement catlogName;

	// PDP FOR Particular Catalog - xpath

	@FindBy(xpath = "//div[@class=\"catalogueName-0-2-345 text-2xl font-semibold\"]")
	private WebElement PDPcatlogName;

	@FindBy(xpath = "(//div[@class=\"attributeValue-0-2-411 flex justify-center items-center text-center !py-0 rounded-lg text-base font-medium\"])[1]")
	private WebElement PDPthicknessValue;

	@FindBy(xpath = "(//*[@class=\"priceValue-0-2-557 font-bold\"])[1]")
	private WebElement PDPpriceValue;

	public void ValidatePLP() {
		viewAllButton.click();
		plusButton.click();
		checkBox.click();
		String categoryName1 = prodCtaegory1.getText();
		String categoryName2 = prodCtaegory2.getText();
		thicknessValue.getText();
		priceValue.getText();
		catlogName.getText();

		try {
			viewMoreButton.click();
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			System.out.println("NO CATALOG PRESENT FOR " + categoryName1);
			prodCtaegory2.click();
			System.out.println(categoryName2 + "=catalog present");
		}

		PDPcatlogName.getText();
		PDPthicknessValue.getText();
		PDPpriceValue.getText();

	}

	

}
