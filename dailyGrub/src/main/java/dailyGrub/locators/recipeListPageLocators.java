package dailyGrub.locators;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dailyGrub.baseClass.BaseClassDailyGrub;

public class recipeListPageLocators extends BaseClassDailyGrub{
	public WebDriverWait wait;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	Actions actions = new Actions(driver);
	
	@FindBy(id = "recipe_list_filter")
	public WebElement SearchBar;
	@FindBy(xpath = "//td[normalize-space()='TEST APPLE CRUMBLES']")
	public WebElement RecipeNameInList;
	
	public recipeListPageLocators() {
        if (driver != null) {
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Ensure wait is initialized
            //JavascriptExecutor executor = (JavascriptExecutor)driver;
        } else {
            throw new IllegalStateException("Driver is not initialized! Check BaseClass.");
        }
    }
	
	public void enterSearchBar(String EnterSearchBar) {
		wait.until(ExpectedConditions.elementToBeClickable(SearchBar));
		SearchBar.sendKeys(EnterSearchBar);
	}
}
