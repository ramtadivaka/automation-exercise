package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Base;
import utils.Filter;

public class FilterPage extends Base {

	private WebDriver driver;

	public FilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	private WebElement allHamburgerMenuCTA;

	@FindBy(xpath = "//a/div[text()='Electronics & Computers']")
	private WebElement electronicsAndComputersDepartmentCTA;

	@FindBy(xpath = "//a[contains(text(),'Phones') and contains(text(),'Accessories')]")
	private WebElement phonesAndAccessoriesDepartmentCTA;

	@FindBy(xpath = "//a[text()='Mobile Phones & Smartphones']")
	private WebElement mobilePhonesAndSmartphonesCTA;

	@FindBy(xpath = "//a[contains(text(),'Smartphones')]")
	private WebElement smartPhonesCTA;

	@FindBy(xpath = "//input[@aria-label='Go - Submit price range' and @class='a-button-input' and @type='submit']")
	private WebElement goBtn;

	@FindBy(xpath = "//span[contains(text(),'Condition')]/parent::div//following-sibling::ul//span[text()='New']")
	private WebElement newConditionCTA;

	private WebElement refinementFilters(String key, String keyValue) {
	        return driver.findElement(By.xpath("//span[contains(text(),'" + key + "')]/parent::div//following-sibling::ul//span[contains(text(),'" + keyValue + "')]/preceding-sibling::div//i[contains(@class,'checkbox')]"));
	    }

	public void goToMobilePhonesAndSmartphonesSection() {
		allHamburgerMenuCTA.click();
		scrollIntoView(electronicsAndComputersDepartmentCTA);
		electronicsAndComputersDepartmentCTA.click();
		waitForElement(phonesAndAccessoriesDepartmentCTA, 3);
		mouseClick(phonesAndAccessoriesDepartmentCTA);
		waitForClickable(mobilePhonesAndSmartphonesCTA, 3);
		mobilePhonesAndSmartphonesCTA.click();
		waitForClickable(smartPhonesCTA, 3);
		smartPhonesCTA.click();
	}

	public void applyFilter(Filter filters) {
		WebElement brandCheckbox = refinementFilters("Brand", filters.getBrand());
		scrollIntoView(brandCheckbox);
		brandCheckbox.click();

		WebElement yearCheckbox = refinementFilters("Year", filters.getYear());
		scrollIntoView(yearCheckbox);
		yearCheckbox.click();

		WebElement cameraResolutionCheckbox = refinementFilters("Camera", filters.getCamera());
		scrollIntoView(cameraResolutionCheckbox);
		cameraResolutionCheckbox.click();

		newConditionCTA.click();

		driver.get(driver.getCurrentUrl() + "&low-price=" + filters.getLowerPriceBound() + ".0&high-price="
				+ filters.getUpperPriceBound());
		goBtn.click();
	}
}