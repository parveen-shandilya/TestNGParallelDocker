package TestCases;

import static POM.CSDPUtility.SubmitAnywayButton;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import POM.CCPDirect20Utility;
import POM.CCPUtility;
import POM.CSDPGISDirect20Utility;
import POM.CSDPUtility;
import POM.CSLPUtility;
import POM.CSPExternalUtility;
import POM.CSPInternalUtility;
import POM.LoginUtility;

public class CSLP_Cascading extends BrowsersInvoked {

	
	ITestResult result;
	CCPUtility ccp;
	CSLPUtility cslp;
	CRMCommonMethods crmMethods;
	CSPInternalUtility csp;
	CSDPUtility csdp;
	CSPExternalUtility ext;

	@BeforeClass
	public void setUp() {
		Setup(); // sets driver for this thread
		
		cslp = new CSLPUtility(getDriver());
		crmMethods = new CRMCommonMethods(getDriver());
		csp = new CSPInternalUtility(getDriver());
		csdp = new CSDPUtility(getDriver());
		ext = new CSPExternalUtility(getDriver());

	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the driver for this thread
	}

	// Cascading test cases below

	String activeCascadingCategory = "CascadingCategory";
	String inactiveCascadingCategory = "CascadingInactive";

	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(getDriver());
		System.out.println(BrowsersInvoked.suiteName);
		if (BrowsersInvoked.suiteName.equalsIgnoreCase("CRMSuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCRMUsername, BrowsersInvoked.AgencyPassword);
		} else if (BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
		} else if (BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
		} else {
			log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
		}
	}

	@Test(priority = 1, description = "Verify active categories appears in alphabetic order on CSPL page under catgory dropdown filter")
	public void verifyAlphabeticOrderOfActiveCategories() throws InterruptedException {
		crmMethods.createSubmission("No", "Yes", "Yes", "Yes", "Yes", activeCascadingCategory);
		csp.waitForElementIsInteractable(csp.cascadingField1);
		csp.scrollIntoView(csp.cascadingField1);
		csp.sendKeysWithWait(csp.cascadingField1, "asd");
		csp.waitUntilElementPresent(CSPInternalUtility.CreateSubmissionButton);
		csp.scrollIntoView(CSPInternalUtility.CreateSubmissionButton);
		csp.clickByJsExecuter(CSPInternalUtility.CreateSubmissionButton);
		csp.waitForCurserRunning(10);

		csp.waitForCurserRunning(5);
		List<WebElement> DuplicateSubsPopup = getDriver().findElements(CSDPUtility.PossibleDuplicateSubmissionsPopup);
		if (DuplicateSubsPopup.size() == 1) {
			csp.scrollIntoView(SubmitAnywayButton);
			csp.waitForElementIsInteractable(SubmitAnywayButton);
			csp.clickByJsExecuter(SubmitAnywayButton);
			csp.waitForCurserRunning(4);
		}

		csdp.waitForElementIsInteractable(csdp.CSDPSubmissionID);
		Assert.assertTrue(csdp.elementIsDisplayed(csdp.CSDPSubmissionID));
		String submissionId = crmMethods.extractSubmissionIdOnCSDP(csdp.getTextElement(csdp.CSDPSubmissionID));
		Reporter.log(submissionId, true);

		crmMethods.navigateToCSLP();

		// applying category filter
		cslp.waitUntilElementIsVisible(cslp.FilterSlider);
		cslp.waitForElementIsInteractable(cslp.FilterSlider);
		cslp.clickByJsExecuter(cslp.FilterSlider);
		cslp.waitForElementIsInteractable(cslp.CategoryCheckbox);
		cslp.forcedWaitTime(5);
		cslp.clickOn(cslp.CategoryCheckbox);
		cslp.waitForElementIsInteractable(cslp.FilterSliderClose);
		cslp.clickOn(cslp.FilterSliderClose);
		cslp.waitUntilElementIsVisible(cslp.CategoryDropdownIcon);
		cslp.waitForElementIsInteractable(cslp.CategoryDropdownIcon);
		cslp.clickByJsExecuter(cslp.CategoryDropdownIcon);
//		cslp.waitUntilElementIsVisible(cslp.categoriesPresentUnderCategoryFilter);
		List<WebElement> categoryNames = cslp.findElementsByXPath(cslp.categoriesPresentUnderCategoryFilter);
		List<String> listOfCategory = new ArrayList<>();

		List<WebElement> categories = getDriver().findElements(By.cssSelector("div.category"));

		for (WebElement category : categories) {
			String name = category.findElement(By.className("clipped-text")).getText();

			WebElement sibling = null;
			try {
				sibling = category.findElement(By.xpath("following-sibling::div[1]"));
			} catch (Exception e) {

			}

			if (sibling == null || sibling.findElements(By.className("deactivated-label")).isEmpty()) {
				listOfCategory.add(name);
				System.out.println("Added active category: " + name);
			} else {
				System.out.println("Skipped deactivated category: " + name);
			}
		}


		System.out.println(listOfCategory);
		Boolean isAscendingOrder = crmMethods.isListInAscendingOrder(listOfCategory);
		int size = listOfCategory.size();
		System.out.println(size);
		Assert.assertTrue(isAscendingOrder);
	}

	@Test(priority = 2, description = "Verify that 'Deactivated Categories' section appears below 'Active Categories' section under 'Category' dropdown field, on 'CSLP' page.")
	public void verifyDeactivatedCategorySectionDisplayed() {
		cslp.searchCategoryUnderCategoryFilter_CSLP(inactiveCascadingCategory);
		Assert.assertTrue(cslp.elementIsDisplayed(cslp.deactivatedCategoryText_CategoryFilter));
	}

	@Test(priority = 3, description = "Verify Deactive categories appears in alphabetic order on CSPL page under catgory dropdown filter")
	public void verifyAlphabeticOrderOfDeactiveCategories() throws InterruptedException {

		List<WebElement> categoryNames = cslp.findElementsByXPath(cslp.deactivateCategoriesUnderCategoryFilter);
		List<String> listOfCategory = new ArrayList<>();

		for (int i = 0; i < 4; i++) {

			listOfCategory.add(categoryNames.get(i).getText());
		}
		Boolean isAscendingOrder = crmMethods.isListInAscendingOrder(listOfCategory);
		Assert.assertTrue(isAscendingOrder);

	}

	@Test(priority = 4, description = "Verify that 'Search' field appears above the 'Active Categories' section under 'Category' dropdown field, on 'CSLP' page.")
	public void verifySearchFieldIsDisplayedForCategoryFilter() {
		Assert.assertTrue(cslp.elementIsDisplayed(cslp.searchCategoryOnCSLP));

	}

	@Test(priority = 5, description = "Verify that user is able to search active categories in the 'Search' field under 'Category' dropdown field, on 'CSLP' page.")
	public void verifyUserIsAbleToSearchActiveCategory() {
		cslp.searchCategoryUnderCategoryFilterUsingSearchBox_CSLP(activeCascadingCategory);
	}

	@Test(priority = 6, description = "Verify that user is able to search inactive categories in the 'Search' field under 'Category' dropdown field, on 'CSLP' page.")
	public void verifyUserIsAbleToSearchInactiveCategory() {
		cslp.searchCategoryUnderCategoryFilterUsingSearchBox_CSLP(inactiveCascadingCategory);
	}

	@Test(priority = 7, description = "Verify that user is able to select any categories (Active and/or Inactive) under 'Category' dropdown field, on 'CSLP' page.")
	public void verifyUserIsAbleToSelectCategoryUnderCategoryDropdown() {
		cslp.searchCategoryUnderCategoryFilterUsingSearchBox_CSLP(activeCascadingCategory);
		// cslp.waitForElement(cslp.checkboxForSearchedCategory);
		cslp.clickByJsExecuter(cslp.checkboxForSearchedCategory);
		Assert.assertTrue(cslp.elementIsChecked(cslp.checkboxForSearchedCategory));

	}

	@Test(priority = 8, description = "Verify that appropriate submissions appear when user selects active categories from 'Category' dropdown field, on 'CSLP' page.")
	public void verifyAppropriateCategoryResults() throws InterruptedException {
		cslp.forcedWaitTime(2);
		List<WebElement> categoryField = cslp.findElementsByXPath(cslp.cascadingCategorySubmissions);
		int size = categoryField.size();
		for (int i = 0; i < size; i++) {
			String categoryName = categoryField.get(i).getText();
			Assert.assertEquals(categoryName, activeCascadingCategory);

		}

	}

	@Test(priority = 9, description = "Verify that appropriate submissions appear when user select deactivated categories from 'Category' dropdown field, on CSLP.")
	public void verifyAppropriateCategoryResults_inactiveCategories() throws InterruptedException {

		cslp.searchCategoryUnderCategoryFilterUsingSearchBox_CSLP(inactiveCascadingCategory);
		cslp.forcedWaitTime(1);
		cslp.waitUntilElementIsVisible(cslp.checkboxForDeactivatedCategory);
		cslp.waitForElementIsInteractable(cslp.checkboxForDeactivatedCategory);
		cslp.clickByJsExecuter(cslp.checkboxForDeactivatedCategory);
		cslp.forcedWaitTime(1);
		cslp.WaitForGridTableEnable();
		Assert.assertTrue(cslp.elementIsChecked(cslp.checkboxForDeactivatedCategory));

		int countThroughFilter = cslp.findElementsByXPath(cslp.caseIDChckBox).size();
		int countThroughCSLPHeader = cslp.getSubmissionCountOnCSDP_header();
		Assert.assertEquals(countThroughFilter, countThroughCSLPHeader);

	}

	@Test(priority = 10, description = "Verify that 'Deactivated categories' do not appear under 'Category' dropdown field while creating the submission on CSP")
	public void verifyDeactivatedCategoriesDontAppearOnCSP() throws InterruptedException {
		cslp.navigatePage(BrowsersInvoked.URLCreateCustomerSubmission);
		Thread.sleep(2000);
		cslp.refreshPage();
		cslp.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
		Thread.sleep(3000);
		cslp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		cslp.scrollIntoView(CSPInternalUtility.CategoryDropdown);
		cslp.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
		cslp.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
		cslp.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
		cslp.sendKeysWithWait(CSPInternalUtility.SearchCategory, inactiveCascadingCategory);
		Boolean isInactiveCategoryDisplayed = null;
		try {
			isInactiveCategoryDisplayed = cslp.findElementsSize(CSPInternalUtility.SearchResultsCategory)>0;
		} catch (Exception e) {
			// intentionally ignored
		}

		Assert.assertFalse(isInactiveCategoryDisplayed);

	}

	@Test(priority = 11, description = "Verify that 'Deactivated categories' do not appear under 'Category' dropdown field while creating the submission on Chromeless app.")
	public void verifyDeactivatedCategoriesDontAppearOnChromelessApp() throws InterruptedException {

		ext.CSPExternal_PreRequisite_OpenReportAnIssuePage();

		ext.waitUntilElementIsVisible(
				By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		ext.scrolltoPageTop();
		ext.scrollIntoView(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		ext.clickByJsExecuter(
				By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
		ext.waitUntilElementIsVisible(
				By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"));
		ext.sendKeysWithWait(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"),
				inactiveCascadingCategory);
		ext.waitUntilElementIsVisible(By.xpath("//div[@class='option-black']"));
		List<WebElement> categoriesDisplayed = ext.findElementsByXPath(By.xpath("//div[@class='option-black']"));
		for (WebElement category : categoriesDisplayed) {
			if (category.getText().equalsIgnoreCase(inactiveCascadingCategory)) {
				Assert.fail();

			}
		}

	}

}
