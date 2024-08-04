package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FilterPage;
import pages.HomePage;
import pages.MobilePhonesPage;
import utils.Base;
import utils.Filter;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

public class AmazonFilterSteps extends Base {

    public HomePage homePage;
    public FilterPage filterPage;
    public MobilePhonesPage mobilePhonesPage;
    
    public AmazonFilterSteps(Base base) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        filterPage = PageFactory.initElements(driver, FilterPage.class);
        mobilePhonesPage = PageFactory.initElements(driver, MobilePhonesPage.class);
    }
    @Given("^I am on the Amazon home page$")
    public void iAmOnTheAmazonHomePage() {
    	openBaseURL();
    	homePage.acceptCookies();
    }

    @When("^I navigate to the Mobile Phones category$")
    public void iNavigateToTheMobilePhonesCategory() {
        filterPage.goToMobilePhonesAndSmartphonesSection();
    }

    @When("^I apply the following filters$")
    public void iApplyTheFollowingFilters(DataTable dataTable) {
        List<Map<String, String>> filters = dataTable.asMaps(String.class, String.class);
        Map<String, String> filterMap = filters.get(0);

        Filter filter = new Filter(
                filterMap.get("Brand"),
                filterMap.get("Camera"),
                filterMap.get("Year"),
                filterMap.get("Price Range").split("-")[0].trim(), 
                filterMap.get("Price Range").split("-")[1].trim()
        );
        filterPage.applyFilter(filter);
    }
    @Then("^I should see a list of \"([^\"]*)\" phones matching these criteria$")
    public void iShouldSeeAListOfPhonesMatchingTheseCriteria(String brand) {
    	mobilePhonesPage.verifyListedItemsWithNameContaining(brand);
        try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
