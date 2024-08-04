package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class MobilePhonesPage {
	
	 @FindBy(xpath = "//div[@data-component-type='s-search-result' and contains(@data-cel-widget,'search_result')]//div[@data-cy='title-recipe']//span")
	    private List<WebElement> itemsList;
    

    
	 public void verifyListedItemsWithNameContaining(String itemName) {
	        for (WebElement item : itemsList) {
	            String displayedItemName = item.getText();
	            System.out.println(displayedItemName);
	            Assert.assertTrue(item.isDisplayed(), "Element is not displayed");
	            Assert.assertTrue(displayedItemName.contains(itemName), displayedItemName+" - does not contain "+itemName);
	        }
	    }
}
