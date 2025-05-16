package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import Constant.CRMConstants;
import POM.CCPUtility;
import POM.CaseAssignmentUtility;
import POM.CategoryPage;
import POM.LoginUtility;

public class Categories extends BrowsersInvoked {

	
	ITestResult result;
	CCPUtility ccp;
	CategoryPage category;
	int newResoTime;
	int categoriesCountBefore;
	String RandomCategoryname;
	
	
	
	@BeforeClass
    public void setUp() {
        Setup(); // sets driver for this thread
      
        ccp = new CCPUtility(getDriver());
		category = new CategoryPage(getDriver());
    }

    @AfterClass
    public void closeDriver() {
        tearDown(); // only closes the driver for this thread
    }

	

//	@Test(priority = 0)
//	public void LoginAgency() throws InterruptedException {
//		category.LoginAgency();
//
//	}
	
	
	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
		if(BrowsersInvoked.suiteName.equalsIgnoreCase("CRMSuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCRMUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
			}
			else {
				log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
			}
	}
	

	@Test(priority = 1, description = "Verify that user able to see Category Tab")
	public void categories_PreRequisite() throws InterruptedException {

		// Navigation to Category
		category.naviateToCategory();
		// Get Tab Text
		String tabTitle = category.getCategoryTabName();

		// Assert Text
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tabTitle, CRMConstants.CATEGORY_TAB_TITLE);
		softAssert.assertAll();

	}

	@Test(priority = 2, description = "Verify that default category and Edit Category pop up")
	public void categories_VerifyDefaultCategory() throws InterruptedException {

		// get Other category
		String otherTabTitle = category.getOtherDefaultCategory();

		// Edit the Category
		category.clickOnEditCategoryIcon();

		// get the Edit Category pop up title
		String EditOtherPopupTitle = category.getEditCategoryPopupTitle();

		// close the pop up
		category.closeTheEditCategoryPopup();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(otherTabTitle.equals(CRMConstants.OTHERR_CATEGORY));
		softAssert.assertTrue(EditOtherPopupTitle.equals(CRMConstants.EDIT_OTHER));

	}

	@Test(priority = 3)
	public void categories_UpdateDefaultResolutionTime() throws InterruptedException {
		// get resolution time before updating
		int resoTimeBefore = category.getResolutionTime();

		// edit resolution time
		category.clickOnEditDefalutResoTime();

		// get edit resolution pop up title
		String editResolutionPopupTitle = category.getEditResolutionPopupTitle();

		// clear the resolution time field
		category.clearResoTimeField();

		// set the time value
		String time = RandomStrings.requiredDigits(2);
		newResoTime = Integer.parseInt(category.setResolutionTime(time));

		// click on save button
		category.clickOnSaveButton();

		int resoTextAfter = category.getResolutionTime();
		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(editResolutionPopupTitle.equals(CRMConstants.EDIT_DEFAULT_RESOLUTION_TIME));
		softAssert.assertEquals(newResoTime, resoTextAfter);
		softAssert.assertAll();

	}

	@Test(priority = 4)

	public void categories_OpenCreateACategoryPopup() throws InterruptedException {

		categoriesCountBefore = category.getCategoryCount();

		// click on create category button
		category.clickOnCreateCategoryBtn();

		// get the create category pop up title
		String createCategoryPopupTitle = category.getCreateCategoryTitle();

		// click on the create category button on pop up
		category.clickOnCreateCategoryPopbtn();

		// get the name required validation text
		String nameFieldValidationMsg = category.getCategoryNameValidationText();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(createCategoryPopupTitle.equals(CRMConstants.CATEGORY_POPUP_TITLE));
		softAssert.assertTrue(nameFieldValidationMsg.equals(CRMConstants.CATEGORY_NAME_REQUIRED));
		softAssert.assertAll();

	}

	@Test(priority = 5)
	public void categories_VerifyResolutionTimeOnCreateCategoryPopup() throws InterruptedException {

		// get resolution time
		String resoTimeOnPopup = category.ResolutionTimeOnCategoryPopup();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(resoTimeOnPopup.equals(String.valueOf(newResoTime)));
		softAssert.assertAll();

	}

	@Test(priority = 6)
	public void Categories_AddKeywordsAndCustomFields() throws InterruptedException {

		// Add Category Keywords
		category.addCategoryKeywords(10);

		// Get Added Category Count
		int KeywordsSizeBefore = category.getAddedKeywordCount();

		// Delete Category
		category.deleteAddedkeywords(7);
		int KeywordsSizeAfter = category.getAddedKeywordCount();

		// click on Add Field Link
		category.clickOnAddFieldLink();

		// Get added field count
		int FieldsCount = category.getAddedFieldCount();

		// click on create category button

		category.clickOnCreateCategoryPopbtn();

		String LabelFieldValidationMsg = category.getCatLabelValidationText();

		// set the label Text

		category.setCategoryLabelText();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(KeywordsSizeBefore == 10);
		softAssert.assertTrue(KeywordsSizeAfter == (KeywordsSizeBefore - 7));
		softAssert.assertTrue(FieldsCount == 1);
		softAssert.assertTrue(LabelFieldValidationMsg.equals(CRMConstants.CATEGORY_LABEL_REQUIRED));
		softAssert.assertAll();

	}

	@Test(priority = 7)
	public void Categories_VerifyLinkedEmailTemplates() throws InterruptedException {

		// Click on Email Drop down
		category.clickOnDropdownLinkemail();

		// Select Email Template
		category.selectEmailTemplateOption();

		// click on Template Cancel button
		category.clickOnTemplateCancelBtn();

		// get Label Text
		String LabelText = category.getLabelText();

		// Click on Email Drop down
		category.clickOnDropdownLinkemail();

		// Select Email Template
		category.selectEmailTemplateOption();

		// get email Template Text
		String CheckedTemplate = category.getTextEmailTemplateOption();

		// click on Template save Button
		category.clickOnTemplateSaveBtn();

		// get selected Template
		String SelectedTemplate = category.getSelectedTemplate();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(LabelText.equals("Select"));
		softAssert.assertTrue(CheckedTemplate.equals(SelectedTemplate));
		softAssert.assertAll();

	}

	@Test(priority = 8)
	public void Categories_VerifyCategoryCreation() throws InterruptedException {

		// set category Name
		RandomCategoryname = category.setCategoryName();

		// click on create category button

		category.clickOnCreateCategoryPopbtn();

		// wait for Create Category button invisibility
		category.waitForButtonInvisibility();

		// get Category count
		int CategoriesCountAfter1 = category.getCategoryCount();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CategoriesCountAfter1 == (categoriesCountBefore + 1));
		softAssert.assertAll();

	}

	@Test(priority = 9)
	public void Categories_VerifyNoCategoryCreationOnCancel() throws InterruptedException {

		// click on create category button

		category.clickOnCreateCategorybutton();

		// set category Name,
		RandomCategoryname = category.setCategoryName();

		// Click on Email Drop down
		category.clickOnDropdownLinkemail();

		// Select Email Template
		category.selectEmailTemplateOption();

		category.closeTheEditCategoryPopup();


		// get Category count
		int CategoriesCountAfter1 = category.getCategoryCount();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CategoriesCountAfter1 == (categoriesCountBefore + 1));
		softAssert.assertAll();

	}

	@Test(priority = 10)
	public void Categories_CantCreateCategoryWithExistingName() throws InterruptedException {

		// click on create category button

		category.clickOnCreateCategorybutton();
		// set category Name
		String categoryname = category.setCategoryNameCustom("Location Required");

		// click on create category button
		category.clickOnCreateCategoryPopbtn();
		
		String NotificationText = category.getExistingCatValidationText();

		category.closeTheEditCategoryPopup();
		
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(3);
		
		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(NotificationText.equals(CRMConstants.CATEGORY_EXIST_ERROR_MESSAGE));
		softAssert.assertAll();
		

	}

	@Test(priority = 11)
	public void Categories_VerifyUpdatedCategory() throws InterruptedException {
		
		// get inactive category count 
		int InactiveCountBefore = category.getInactiveCategoryCount();

		// Click on the edit category icon 
		category.clicOnEditCategoryActive();
		
		//click on inactive toggle button on edit category page
		category.clickOnInactiveToggleButton();
		
		// clear the category name 
		category.clearCategoryName();
		
		
		// set category Name
		String categoryname = category.setCategoryNameCustom("Edited " + RandomCategoryname);

		// click on Save button 
		category.clickOnSaveButton();
		Helper helper = new Helper(getDriver());
		helper.waitForCurserRunning(3);
		helper.forcedWaitTime(3);
		
		int InactiveCountAfter = category.getInactiveCategoryCount();
		
		Assert.assertEquals(InactiveCountAfter, (InactiveCountBefore + 1));

		
		
	}

	@Test(priority = 12)
	public void Categories_VerifyAccurateCount() throws InterruptedException {
	
		// get count from header
		int CategoriesCountHeader1 = category.getCategoryCount();
		
		// get count from grid 
		int CountCategoriesActual = category.getCountFormGrid();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CategoriesCountHeader1 == CountCategoriesActual);
		softAssert.assertAll();

	}

}
