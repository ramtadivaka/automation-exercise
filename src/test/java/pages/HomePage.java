package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//input[contains(@id, 'accept') and @name='accept']")
	private WebElement acceptCookiesBtn;


	public void acceptCookies() {
		acceptCookiesBtn.click();
	}
}