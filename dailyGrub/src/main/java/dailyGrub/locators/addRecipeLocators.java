package dailyGrub.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dailyGrub.baseClass.BaseClassDailyGrub;

public class addRecipeLocators extends BaseClassDailyGrub {
	public WebDriverWait wait;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	Actions actions = new Actions(driver);
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div[1]/ul/li[9]/a/span")
	public WebElement ManageRecipe;
	@FindBy(xpath = "//a[normalize-space()='Add Recipe']")
	public WebElement AddRecipe;
	@FindBy(id = "season")
	public WebElement RecipeTypeDrpDwn;
	@FindBy(id = "recipe")
	public WebElement RecipeName;
	@FindBy(id = "category")
	public WebElement CategoryDrpDwn;
	@FindBy(id = "subcategory")
	public WebElement DietaryPreferenceDrpDwn;
	@FindBy(id = "Preparation")
	public WebElement PreparationTime;
	@FindBy(id = "id_Min")
	public WebElement MinBtnPrep;
	@FindBy(id = "id_Hrs")
	public WebElement MaxBtnPrep;
	@FindBy(id = "Servings")
	public WebElement Servings;
	@FindBy(id = "calory")
	public WebElement TotalCalories;
	@FindBy(id = "easy")
	public WebElement EasyDiffLvl;
	@FindBy(id = "medium")
	public WebElement MediumDiffLvl;
	@FindBy(id = "complex")
	public WebElement HardDiffLvl;
	@FindBy(id = "Fat")
	public WebElement Fat;
	@FindBy(id = "Carbs")
	public WebElement Carbs;
	@FindBy(id = "Protein")
	public WebElement Protein;
	@FindBy(id = "recipe_share")
	public WebElement EnableRecipeShareOption;
	@FindBy(id = "recommended")
	public WebElement DisplayinRecommendedSection;
	@FindBy(id = "all_ingredients")
	public WebElement Ingredients;
	@FindBy(xpath = "//*[@id=\"recipeform\"]/div/div[18]/div[1]/span/span[1]/span/ul/li/input")
	public WebElement ingredientsSearchField;
	@FindBy(id = "SMALLONIONGRATED")
	public WebElement SmallOnionGrated;
	@FindBy(id = "TOMATOCHOPPED")
	public WebElement TomatoChopped;
	@FindBy(id = "DAIYADFCHEDDARSHREDS")
	public WebElement DaiyaDfCheddarShreds;
	@FindBy(id = "WHOLLYGLUTENFREEPIESHELL")
	public WebElement WhollyGlutenFreePieShell;
	@FindBy(id = "select2-all_ingredients-results")
	public WebElement IngredientsOptions;
	@FindBy(xpath = "//*[@id=\"recipeform\"]/div/div[21]/div/span/span[1]/span/ul/li/input")
	public WebElement ToppingsSearchField;
	@FindBy(id = "select2-all_topping-results")
	public WebElement ToppingsOptions;
	@FindBy(id = "BODYBYBREE VANILLA PROTEIN")
	public WebElement  BodybyBreeVanillaProtein;
	@FindBy(id = "DRIED PARSLEY")
	public WebElement DriedParsley;
	@FindBy(id = "HEAVY CREAM")
	public WebElement HeavyCream;
	@FindBy(id = "Description")
	public WebElement Description;
	@FindBy(id = "catimg_lab")
	public WebElement UploadRecipeImage;
	@FindBy(id = "embed_link")
	public WebElement youtubeId;
	@FindBy(id = "step_title1")
	public WebElement StepTitle1;
	@FindBy(id = "step_title2")
	public WebElement StepTitle2;
	@FindBy(id = "Step1")
	public WebElement StepContent1;
	@FindBy(id = "Step")
	public WebElement StepContent2;
	@FindBy(id = "add_steps")
	public WebElement AddStepBtn;
	@FindBy(xpath = "//*[@id=\"steps_container\"]/div/div[1]/div/button")
	public WebElement RemoveStepBtn;
	@FindBy(id = "recipe_add")
	public WebElement SaveBtn;
	@FindBy(id = "cancel_button")
	public WebElement CancelBtn;
	@FindBy(id = "tooltip83349")
	public WebElement ToolTipOverLay;
	@FindBy(id = "swal2-content")
	public WebElement ConfirmationMsgPopup;
	@FindBy(css = "button.swal2-confirm")
	public WebElement OkBtn;
	@FindBy(xpath = "//button[@class='btn btn-success waves-effect waves-light']")
	public WebElement MobPreview;
	@FindBy(xpath = "//button[@class='close ctl-add-res-pop-ico']//span[@aria-hidden='true'][normalize-space()='×']")
	public WebElement CancelMobPreview;
	
	 public addRecipeLocators() {
	        if (driver != null) {
	            PageFactory.initElements(driver, this);
	            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Ensure wait is initialized
	            //JavascriptExecutor executor = (JavascriptExecutor)driver;
	        } else {
	            throw new IllegalStateException("Driver is not initialized! Check BaseClass.");
	        }
	    }
	
	public void clickManageRecipe() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ManageRecipe));
		ManageRecipe.click();
	}
	public void clickAddRecipe() {
		wait.until(ExpectedConditions.elementToBeClickable(AddRecipe));
		AddRecipe.click();
	}
	public void selectRecipeType(String RecipeValue) {
		wait.until(ExpectedConditions.elementToBeClickable(RecipeTypeDrpDwn));
		selectDropdownByVisibleText(RecipeTypeDrpDwn, RecipeValue);
	}
	public void enterRecipeName(String EnterRecipeName) {
		wait.until(ExpectedConditions.elementToBeClickable(RecipeName));
		RecipeName.sendKeys(EnterRecipeName);
	}	
	public void selectCategory(String EnterCategory) {
		wait.until(ExpectedConditions.elementToBeClickable(RecipeTypeDrpDwn));
		selectDropdownByVisibleText(CategoryDrpDwn, EnterCategory);
	}
	public void SelectDietaryPreference(String EnterDietaryPreference) {
		wait.until(ExpectedConditions.elementToBeClickable(DietaryPreferenceDrpDwn));
		selectDropdownByVisibleText(DietaryPreferenceDrpDwn, EnterDietaryPreference);
	}
	public void EnterPreparationTime(String EnterPreparationTime) {
		wait.until(ExpectedConditions.elementToBeClickable(PreparationTime));
		PreparationTime.sendKeys(EnterPreparationTime);
	}
	public void clickMinBtnPrep() {
		MinBtnPrep.click();
	}
	public void clickMaxBtnPrep() {
		MaxBtnPrep.click();
	}
	public void enterServings(String EnterServings) {
		wait.until(ExpectedConditions.elementToBeClickable(Servings));
		Servings.sendKeys(EnterServings);
	}
	public void enterTotalCalories(String EnterTotalCalories) {
		wait.until(ExpectedConditions.elementToBeClickable(TotalCalories));
		TotalCalories.sendKeys(EnterTotalCalories);
	}
	public void clickEasyDiffLvl() {
		//wait.until(ExpectedConditions.elementToBeClickable(EasyDiffLvl));
		EasyDiffLvl.click();
	}
	public void clickMediumDiffLvl() {
		MediumDiffLvl.click();
	}
	public void clickHardDiffLvl() {
		//wait.until(ExpectedConditions.elementToBeClickable(HardDiffLvl));
		HardDiffLvl.click();
	}
	public void enterFat(String EnterFat) {
		wait.until(ExpectedConditions.elementToBeClickable(Fat));
		Fat.sendKeys(EnterFat);
	}
	public void enterCarbs(String EnterCarbs) {
		wait.until(ExpectedConditions.elementToBeClickable(Carbs));
		Carbs.sendKeys(EnterCarbs);
	}
	public void enterProtein(String EnterProtein) {
		wait.until(ExpectedConditions.elementToBeClickable(Protein));
		Protein.sendKeys(EnterProtein);
	}
	public void clickEnableRecipeShareOption() {
		wait.until(ExpectedConditions.elementToBeClickable(EnableRecipeShareOption));
		EnableRecipeShareOption.click();
	}
	public void clickDisplayinRecommendedSection() {
		wait.until(ExpectedConditions.elementToBeClickable(DisplayinRecommendedSection));
		DisplayinRecommendedSection.click();
	}
	public void selectIngredients1(String IngredientsValue) {
		//actions.moveToElement(Ingredients).click().perform();
		executor.executeScript("arguments[0].scrollIntoView(true);",ingredientsSearchField);
		wait.until(ExpectedConditions.elementToBeClickable(ingredientsSearchField));
		selectDropdownByVisibleText(ingredientsSearchField, IngredientsValue);
	}
	public void selectIngredients() {
		executor.executeScript("arguments[0].scrollIntoView(true);",ingredientsSearchField);
		executor.executeScript("arguments[0].click();", ingredientsSearchField);
		wait.until(ExpectedConditions.elementToBeClickable(ingredientsSearchField));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ingredientsSearchField)));
		ingredientsSearchField.click();
	}
	public void enterIngredientsSearchField(String EnterIngredientsSearchField) {
		//wait.until(ExpectedConditions.elementToBeClickable(ingredientsSearchField));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ingredientsSearchField)));
		ingredientsSearchField.sendKeys(EnterIngredientsSearchField);
	}
	public void clickIngredientsOption() {
		wait.until(ExpectedConditions.elementToBeClickable(IngredientsOptions));
		IngredientsOptions.click();
	}
	public void EnterSmallOnionGrated(String enterSmallOnionGrated) {
		wait.until(ExpectedConditions.elementToBeClickable(SmallOnionGrated));
		SmallOnionGrated.sendKeys(enterSmallOnionGrated);
	}
	public void EnterTomatoChopped(String enterTomatoChopped) {
		wait.until(ExpectedConditions.elementToBeClickable(TomatoChopped));
		TomatoChopped.sendKeys(enterTomatoChopped);
	}
	public void EnterDaiyaDfCheddarShreds(String enterDaiyaDfCheddarShreds) {
		wait.until(ExpectedConditions.elementToBeClickable(DaiyaDfCheddarShreds));
		DaiyaDfCheddarShreds.sendKeys(enterDaiyaDfCheddarShreds);
	}
	public void EnterWhollyGlutenFreePieShell(String enterWhollyGlutenFreePieShell) {
		wait.until(ExpectedConditions.elementToBeClickable(WhollyGlutenFreePieShell));
		WhollyGlutenFreePieShell.sendKeys(enterWhollyGlutenFreePieShell);
	}
	public void enterToppingsSearchField(String EnterToppingsSearchField) {
		//wait.until(ExpectedConditions.elementToBeClickable(ingredientsSearchField));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ToppingsSearchField)));
		ToppingsSearchField.sendKeys(EnterToppingsSearchField);
	}
	public void clickToppingsOption() {
		wait.until(ExpectedConditions.elementToBeClickable(ToppingsOptions));
		ToppingsOptions.click();
	}
	public void enterBodybyBreeVanillaProtein(String EnterBodybyBreeVanillaProtein) {
		executor.executeScript("arguments[0].scrollIntoView(true);",BodybyBreeVanillaProtein);
		executor.executeScript("arguments[0].click();", BodybyBreeVanillaProtein);
		wait.until(ExpectedConditions.elementToBeClickable(BodybyBreeVanillaProtein));
		BodybyBreeVanillaProtein.sendKeys(EnterBodybyBreeVanillaProtein);
	}
	public void enterDriedParsley(String EnterDriedParsley) {
		wait.until(ExpectedConditions.elementToBeClickable(DriedParsley));
		DriedParsley.sendKeys(EnterDriedParsley);
	}
	public void enterHeavyCream(String EnterHeavyCream) {
		wait.until(ExpectedConditions.elementToBeClickable(HeavyCream));
		HeavyCream.sendKeys(EnterHeavyCream);
	}
	public void enterDescription(String EnterDescription) {
		wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description.sendKeys(EnterDescription);
	}
	public void clickUploadRecipeImage() {
		wait.until(ExpectedConditions.elementToBeClickable(UploadRecipeImage));
		UploadRecipeImage.click();
	}
	public void enterYoutubeID(String EnterYoutubeID) {
		wait.until(ExpectedConditions.elementToBeClickable(youtubeId));
		youtubeId.click();
		youtubeId.sendKeys(EnterYoutubeID);	
	}
	public void enterStepTitle1(String EnterStepTitle1) {
		wait.until(ExpectedConditions.elementToBeClickable(StepTitle1));
		StepTitle1.click();
		StepTitle1.sendKeys(EnterStepTitle1);	
	}
	public void enterStepTitle2(String EnterStepTitle2) {
		wait.until(ExpectedConditions.elementToBeClickable(StepTitle2));
		StepTitle2.click();
		StepTitle2.sendKeys(EnterStepTitle2);
	}
	public void enterStepContent1(String EnterStepContent1) {
		wait.until(ExpectedConditions.elementToBeClickable(StepContent1));
		StepContent1.click();
		StepContent1.sendKeys(EnterStepContent1);
	}
	public void enterStepContent2(String EnterStepContent2) {
		wait.until(ExpectedConditions.visibilityOf(StepContent2));	
		wait.until(ExpectedConditions.elementToBeClickable(StepContent2));
		StepContent2.click();
		StepContent2.sendKeys(EnterStepContent2);
	}
	public void clickAddStepBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(AddStepBtn));
//		if (ToolTipOverLay.isDisplayed()) {
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", ToolTipOverLay);
//		}
		AddStepBtn.click();
	}
	public void clickRemoveStepBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(RemoveStepBtn));
		RemoveStepBtn.click();
	}
	public void clickMobPreview() {
		executor.executeScript("window.scrollTo(0, 0);");
		wait.until(ExpectedConditions.visibilityOf(MobPreview));
		wait.until(ExpectedConditions.elementToBeClickable(MobPreview));
		MobPreview.click();
	}
	public void clickCancelMobPreview() {
		//executor.executeScript("arguments[0].scrollIntoView(true);",MobPreview);
		wait.until(ExpectedConditions.visibilityOf(CancelMobPreview));
		wait.until(ExpectedConditions.elementToBeClickable(CancelMobPreview));
		CancelMobPreview.click();
	}
	public void clickSaveBtn() {
		executor.executeScript("arguments[0].scrollIntoView(true);",SaveBtn);
		wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
		SaveBtn.click();
	}
	public void clickCancelBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
		SaveBtn.click();
	}
	public void clickOkBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(OkBtn));
		OkBtn.click();
	}
}
	
	