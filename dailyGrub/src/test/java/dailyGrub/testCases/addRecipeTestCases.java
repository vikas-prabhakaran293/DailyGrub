package dailyGrub.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dailyGrub.baseClass.BaseClassDailyGrub;
import dailyGrub.locators.loginPageLocators;
import dailyGrub.locators.recipeListPageLocators;
import dailyGrub.locators.addRecipeLocators;

public class addRecipeTestCases extends BaseClassDailyGrub {
	public loginPageLocators LoginPageLocators;
	public addRecipeLocators AddRecipeLocators;
	public loginTestCase LoginTestCase;
	public recipeListPageLocators RecipeListPageLocators;
	WebDriverWait wait;
	
	@BeforeClass
	public void launchBrowser() {
		browserLaunch();
        LoginPageLocators = PageFactory.initElements(driver, loginPageLocators.class);
        AddRecipeLocators = PageFactory.initElements(driver, addRecipeLocators.class);
        RecipeListPageLocators = PageFactory.initElements(driver, recipeListPageLocators.class);
		//LoginTestCase = new loginTestCase();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test(priority = 1)
	public void doLogin() throws InterruptedException {
		loginApplication("vikaspk@skadits.com","Testing@123");
		wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.AlertMessage)));
		Assert.assertTrue((LoginPageLocators.AlertMessage).isDisplayed());
		String AlertMessageForLogIn = LoginPageLocators.AlertMessage.getText();
		System.out.println("Alert Message For LogIn: "+ AlertMessageForLogIn);
		wait.until(ExpectedConditions.urlToBe("https://dev.dailygrub.store/dashboard"));
		String actualResult = driver.getCurrentUrl(); 
		String expectedResult = "https://dev.dailygrub.store/dashboard";
		Assert.assertEquals(actualResult,expectedResult);
		System.out.println("Logged in successfully and redirected to the Dashboard");
	}
	@Test(priority = 2)
	public void redirectToAddRecipe() {
		AddRecipeLocators.clickManageRecipe();
		AddRecipeLocators.clickAddRecipe();
		wait.until(ExpectedConditions.urlToBe("https://dev.dailygrub.store/add-recipe/"));
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev.dailygrub.store/add-recipe/";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("The page was redirected to the: "+actualResult);
	}
	@Test(priority = 3)
	public void AddRecipe() throws InterruptedException {
		AddRecipeLocators.selectRecipeType("Spring & Summer");
		AddRecipeLocators.enterRecipeName("Test Apple Crumbles");
		AddRecipeLocators.selectCategory("Dessert");
		AddRecipeLocators.SelectDietaryPreference("Gluten and Dairy Free");
		AddRecipeLocators.EnterPreparationTime("0030");
		AddRecipeLocators.clickMaxBtnPrep();
		AddRecipeLocators.clickMinBtnPrep();
		AddRecipeLocators.enterServings("4");
		AddRecipeLocators.enterTotalCalories("1300");
		AddRecipeLocators.clickMediumDiffLvl();
		AddRecipeLocators.enterFat("67");	
		AddRecipeLocators.enterCarbs("100");
		AddRecipeLocators.enterProtein("78");
		AddRecipeLocators.clickEnableRecipeShareOption();
		AddRecipeLocators.clickDisplayinRecommendedSection();
   }
	@Test(priority = 4)
	public void selectIngredients() throws InterruptedException {
		// Select Multiple Ingredients (Using List for Better Scalability)
				Thread.sleep(1000);
		        List<String> ingredients = Arrays.asList(    		
		            "SMALL ONION GRATED",
		            "TOMATO CHOPPED",
		            "DAIYA DF CHEDDAR SHREDS",
		            "WHOLLY GLUTEN FREE PIE SHELL"
		        );
		        for (String ingredient : ingredients) {
		            //AddRecipeLocators.selectIngredients();
		            Thread.sleep(1000);
		            AddRecipeLocators.enterIngredientsSearchField(ingredient);
		            Thread.sleep(1000);
		            AddRecipeLocators.clickIngredientsOption();
		            System.out.println(ingredient+" : Is selected");
		        }
		        //Enter Ingredients Measures
		        AddRecipeLocators.EnterSmallOnionGrated("3");
		        AddRecipeLocators.EnterTomatoChopped("4");
		        AddRecipeLocators.EnterDaiyaDfCheddarShreds("4");
		        AddRecipeLocators.EnterWhollyGlutenFreePieShell("2");
		        System.out.println("Ingredients added successfully!");
	}
	@Test(priority = 5)
	public void selectToppings() throws InterruptedException {
		// Select Multiple Toppings (Using List for Better Scalability)
		Thread.sleep(1000);
        List<String> toppings = Arrays.asList(    		
            "BODYBYBREE VANILLA PROTEIN",
            "DRIED PARSLEY",
            "HEAVY CREAM"
        );
        for (String topping : toppings) {
            //AddRecipeLocators.selectIngredients();
            Thread.sleep(1000);
            AddRecipeLocators.enterToppingsSearchField(topping);
            Thread.sleep(1000);
            AddRecipeLocators.clickToppingsOption();
            System.out.println(topping+ ": Is Selected" );
        }
        //Enter Ingredients Measures
        AddRecipeLocators.enterBodybyBreeVanillaProtein("2");
        AddRecipeLocators.enterDriedParsley("1");
        AddRecipeLocators.enterHeavyCream("2");
        System.out.println("Toppings added successfully!");
        
        AddRecipeLocators.enterDescription("Test Content");
	}
	@Test(priority = 5)
	public void uploadRecipeImage() throws AWTException, InterruptedException {
		
		AddRecipeLocators.clickUploadRecipeImage();
		
		StringSelection filePath = new StringSelection("C:\\Users\\HP\\Desktop\\Vikas\\Images for testing\\BBB\\1.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

	    // Use Robot class to simulate keyboard events
	    Robot robot = new Robot();
	    robot.delay(1000);
	    
	    // Press CTRL + V to paste
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    // Press Enter
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    System.out.println("Recipe Image added successfully!");
	    Thread.sleep(3000);
	}
	@Test(priority = 6)
	public void enterOtherDetails() {
		AddRecipeLocators.enterYoutubeID("https://www.youtube.com/watch?v=vFl6dLiUHtA&t=2s");
		//AddRecipeLocators.clickRemoveStepBtn();
		//AddRecipeLocators.clickAddStepBtn();
		AddRecipeLocators.enterStepTitle1("Test 1");
		AddRecipeLocators.enterStepContent1("Test Content");
		AddRecipeLocators.enterStepTitle2("Test 2");
		AddRecipeLocators.enterStepContent2("Sample Content");
		AddRecipeLocators.clickMobPreview();
		AddRecipeLocators.clickCancelMobPreview();
		System.out.println("Mobile preview was closed");
		AddRecipeLocators.clickSaveBtn();
		wait.until(ExpectedConditions.visibilityOf((AddRecipeLocators.ConfirmationMsgPopup)));
		Assert.assertTrue((AddRecipeLocators.ConfirmationMsgPopup).isDisplayed());
		String ConfirmationMsg = AddRecipeLocators.ConfirmationMsgPopup.getText();
		System.out.println("Confirmation message for add recipe: "+ ConfirmationMsg);
		AddRecipeLocators.clickOkBtn();
		wait.until(ExpectedConditions.urlToBe("https://dev.dailygrub.store/manage-recipe/"));
		String actualResult = driver.getCurrentUrl(); 
		String expectedResult = "https://dev.dailygrub.store/manage-recipe/";
		Assert.assertEquals(actualResult,expectedResult);
		System.out.println("The page was redirected to the list page.");
	}
	@Test(priority = 7)
	public void checkTheAddedRecord() {
		RecipeListPageLocators.enterSearchBar("Test Apple Crumbles");
		wait.until(ExpectedConditions.visibilityOf((RecipeListPageLocators.RecipeNameInList)));
		Assert.assertTrue((RecipeListPageLocators.RecipeNameInList).isDisplayed());
		String RecipeNameinList = RecipeListPageLocators.RecipeNameInList.getText();
		System.out.println("The newly added recipe was: "+ RecipeNameinList);
	}
	
	@AfterClass
	public void closeBrowser() {
		closeApp();
	}
}
