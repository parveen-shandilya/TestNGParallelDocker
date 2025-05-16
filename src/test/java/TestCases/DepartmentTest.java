package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import Constant.CRMConstants;
import POM.*;
import net.bytebuddy.utility.RandomString;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static POM.CSDPUtility.*;
import static POM.CSDPUtility.SaveButton;
import static POM.CSLPUtility.*;
import static POM.Department.*;

public class DepartmentTest extends BrowsersInvoked {

	
	ITestResult result;
	CCPUtility ccp;
	Department department;
	CRMCommonMethods crmCommonMethods;
	SubmissionAssignmentUtility submissionAssignmentUtility;
	CSDPUtility csdp;
	int activeCountBefore, activeCountAfter, inactiveCountBefore, inactiveCountAfter;
	String depatName;
	CSLPUtility cslpUtility;

	@BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		ccp = new CCPUtility(getDriver());
		department = new Department(getDriver());
		crmCommonMethods = new CRMCommonMethods(getDriver());
		submissionAssignmentUtility = new SubmissionAssignmentUtility(getDriver());
		csdp = new CSDPUtility(getDriver());
		cslpUtility = new CSLPUtility(getDriver());

	}

	@AfterClass
	public void closeDriver() {
		tearDown(); // only closes the getDriver() for this thread
	}

	String exepectedText;
	String departmentCategory;

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

	@Test(priority = 1, description = "Verify that 'Create Department' popup opens up, after clicking on 'Create Department' button, on 'Department' Page.")
	public void verifyThatCreateDepartmentPopupOpensUp() throws InterruptedException {
		crmCommonMethods.navigateToAgencySetup();
		// got to the department page .
		department.waitUntilElementIsVisible(departmentTab);
		department.waitForElementIsInteractable(departmentTab);
		department.clickOn(departmentTab);
		department.forcedWaitTime(3);
		activeCountBefore = department.getCategoryCount();
		System.out.println("activeCountBefore: " + activeCountBefore);
		inactiveCountBefore = department.getInactiveCategoryCount();
		System.out.println("inactiveCountBefore: " + inactiveCountBefore);

		// department popup .
		department.waitUntilElementIsVisible(createDepartmentButton);
		department.waitForElementIsInteractable(createDepartmentButton);
		department.clickOn(createDepartmentButton);

		department.waitUntilElementIsVisible(departmentHeader);
		String actualHeaderTxt = department.getTextElement(departmentHeader);

		SoftAssert st = new SoftAssert();
		st.assertEquals(actualHeaderTxt, "Create Department", "header name doesnot match");
		st.assertAll();

	}

	@Test(priority = 2, description = "Verify that validation message appears, after clicking on 'Create Department' button, when mandatory fields are left blank, on 'Create Department' Popup.")
	public void verifyThatAppropriateValidationMessageAppearForMandatoryFields() throws InterruptedException {

		// click on create department button on 'Create Department' popup.
		department.waitUntilElementIsVisible(createDepartmentButtonPopup);
		department.waitForElementIsInteractable(createDepartmentButtonPopup);
		department.clickOn(createDepartmentButtonPopup);

		department.waitUntilElementIsVisible(nameValidationMessage);
		String acutalValidationMessageForName = department.getTextElement(nameValidationMessage);

		SoftAssert st = new SoftAssert();
		st.assertEquals(acutalValidationMessageForName, "The Name is required.", "validation message doesnot match");
		st.assertAll();

	}

	@Test(priority = 3, description = "Verify that appropriate information message appears, when no users are available under the 'Department Users' section, on 'Create Department' popup.")
	public void verifyThatAppropriateMessageAppearForDepartmentUsers() throws InterruptedException {

		department.waitUntilElementIsVisible(departmentUsers);

		String acutalMessageForDepartmentUsers = department.getTextElement(departmentUsers);

		SoftAssert st = new SoftAssert();
		st.assertEquals(acutalMessageForDepartmentUsers, "No users added to the department",
				"department message doesnot match");
		st.assertAll();
	}

	@Test(priority = 4, description = "Verify that validation message appears after clicking 'Create  Department' button, when user enters more than 128 characters in 'Name' field, on 'Create Department' popup. ")
	public void verifyThatValidationMessageAppearForNameField() throws InterruptedException {
		String dummyChar = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque pen1";
		department.waitForElementIsInteractable(nameField2);
		department.sendKeysWithWait(nameField2, dummyChar);
		department.waitForElementIsInteractable(createDepartmentButtonPopup);
		department.clickOn(createDepartmentButtonPopup);

		String acutalValidationMessageForName = department.getTextElement(nameValidationMessage);

		SoftAssert st = new SoftAssert();
		st.assertEquals(acutalValidationMessageForName, "128 character limit.", "validation message doesnot match");
		st.assertAll();
	}

	@Test(priority = 5, description = "Verify that user is able to create Department after clicking on 'Create Department' button, when user enter valid data in mandatory fields, on 'Create Department' Popup.")
	public void verifyThatUSerIsAbleCreateDepartment() throws InterruptedException {
		depatName = "Department" + RandomStrings.requiredCharacters(4);
		department.waitForElementIsInteractable(nameField2);
		department.clearByJSE(nameField2);
		department.sendKeysWithWait(nameField2, depatName);
		department.waitForElementIsInteractable(createDepartmentButtonPopup);
		department.clickOn(createDepartmentButtonPopup);
		department.forcedWaitTime(3);

		SoftAssert st = new SoftAssert();
		st.assertTrue(department.elementIsDisplayed(By.xpath(department.selectorFormate(departmentName, depatName))));
		st.assertAll();

	}

	@Test(priority = 6, enabled = true, description = "Verify that the count of active records gets increased, when user creates a new record, on 'Departments' page.")
	public void verifyCountGetIncreasedForActiveCount() throws InterruptedException {

		activeCountAfter = department.getCategoryCount();
		System.out.println("activeCountAfter: " + activeCountAfter);
		SoftAssert st = new SoftAssert();
		st.assertEquals(activeCountBefore + 1, activeCountAfter, "count doesnot match.");
		st.assertAll();

	}

	@Test(priority = 7, description = "Verify that 'Edit <Department Name>' popup appears after clicking 'Edit' icon, under 'Active Departments', on 'Departments' page.")
	public void verifyThatEditPopupShouldAppear() throws InterruptedException {

		department.clickByJsExecuter(
				By.xpath(department.stringFormat(editCategorysIcon, Integer.toString(activeCountAfter))));
		department.waitUntilElementIsVisible(departmentHeader);
		department.forcedWaitTime(3);
		String actualHeaderText = department.getTextElement(departmentHeader);
		String exepectedText = "Edit " + depatName;
		SoftAssert st = new SoftAssert();
		st.assertEquals(actualHeaderText, exepectedText, "header name doesnot match.");
		st.assertAll();

	}

	@Test(priority = 8, description = "Verify that record gets updated after clicking on 'Save' button, when user makes changes on 'Edit <Department name>' popup.")
	public void verifyThatUserIsAbleToEditDepartment() throws InterruptedException {

		department.waitUntilElementIsVisible(departmentHeader);
		department.forcedWaitTime(3);
		exepectedText = depatName + " Edited";
		department.clearByJSE(nameField2);
		department.sendKeysWithWait(nameField2, exepectedText);
		department.clickOn(SaveButton);
		department.forcedWaitTime(3);

		SoftAssert st = new SoftAssert();
		st.assertTrue(
				department.elementIsDisplayed(By.xpath(department.selectorFormate(departmentName, exepectedText))));
		st.assertAll();

	}

	@Test(priority = 9, description = "Verify that count of inactive records gets increased, when user creates a new inactive record, on 'Departments' page.")
	public void verifyThatUserIsAbleToCreateAnInactiveDepartment() throws InterruptedException {

		department.clickOn(createDepartmentButton);
		department.waitUntilElementIsVisible(departmentHeader);
		department.forcedWaitTime(3);
		String exepectedText = depatName + RandomStrings.requiredString(2);
		department.clearByJSE(nameField2);
		department.sendKeysWithWait(nameField2, exepectedText);
		department.clickOn(inactiveButton);
		department.clickOn(createDepartmentButtonPopup);
		department.forcedWaitTime(3);

		inactiveCountAfter = department.getInactiveCategoryCount();
		System.out.println("inactiveCountAfter: " + inactiveCountAfter);
		SoftAssert st = new SoftAssert();
		st.assertEquals(inactiveCountBefore + 1, inactiveCountAfter, "count doesnot match.");
		st.assertTrue(
				department.elementIsDisplayed(By.xpath(department.selectorFormate(departmentName, exepectedText))));
		st.assertAll();
	}

	@Test(priority = 10, enabled = true, description = "Verify that the count of active records gets increased, when user creates a new record, on 'Departments' page.")
	public void verifyThatUserIsAbleToActivateTheInactivateDepartment() throws InterruptedException {

		int count = inactiveCountAfter + activeCountAfter;
		department.clickByJsExecuter(By.xpath(department.stringFormat(editCategorysIcon, Integer.toString(count))));
		department.waitForCurserRunning(3);
		department.waitForElementIsInteractable(activeButton);
		department.clickByJsExecuter(activeButton);
		department.clickByJsExecuter(SaveButton);
		department.waitForCurserRunning(2);

		activeCountAfter = department.getCategoryCount();
		System.out.println("activeCountBefore: " + activeCountBefore);
		System.out.println("activeCountAfter: " + activeCountAfter);
		SoftAssert st = new SoftAssert();
		st.assertEquals(activeCountBefore + 2, activeCountAfter, "count doesnot match.");
		st.assertAll();

	}

	@Test(priority = 11, enabled = true, description = "Verify that created department appears under 'Select Department' dropdown , on 'Create a Category' popup.")
	public void verifyThatCreatedDepartmentShouldAppearUnderDropdown() throws InterruptedException {

		department.naviateToCategory();
		department.clickOn(CreateCategoryButton);
		try {
			department.waitUntilElementIsVisible(selectDepartment);
			department.waitForElementIsInteractable(selectDepartment);
			department.clickOn(selectDepartment);
		} catch (Exception e) {
			e.printStackTrace();
			department.waitUntilElementIsVisible(selectDepartment);
			department.waitForElementIsInteractable(selectDepartment);
			department.movetoElementAndClick(selectDepartment);
		}

		department.waitUntilElementIsVisible(By.xpath(department.stringFormat(selectDepartmentValue, "Test Dept1")));

		SoftAssert st = new SoftAssert();
		st.assertTrue(
				department.elementIsDisplayed(By.xpath(department.stringFormat(selectDepartmentValue, "Test Dept1"))));
		st.assertAll();

	}

	@Test(priority = 12, enabled = true, description = "Verify that user is able to create category with selected department, on 'Category' page.")
	public void verifyThatUserIsAbleTocreatCategoryUsingTheDepartmaent() throws InterruptedException {
		departmentCategory = "depart" + RandomStrings.requiredString(3);
		department.clickOn(By.xpath(department.stringFormat(selectDepartmentValue, "Test Dept1")));
		department.sendKeysWithWait(NameField, departmentCategory);
		department.waitForElementIsInteractable(CreateCategoryPopupBtn);
		department.clickOn(CreateCategoryPopupBtn);
		department.waitForCurserRunning(4);
		department.forcedWaitTime(4);
		SoftAssert st = new SoftAssert();
		st.assertTrue(department
				.elementIsDisplayed(By.xpath(department.stringFormat(selectDepartmentValue, departmentCategory))));
		st.assertAll();

	}

	@Test(priority = 13, enabled = true, description = "Verify that user is able to change category with diferent department, on 'Category' page.")
	public void verifyThatUserIsAbleToChangeTheCategoryInDepartment() throws InterruptedException {
		int count = department.getCategoryCount();
		department.scrollIntoView(By.xpath(department.stringFormat(selectDepartmentValue, departmentCategory)));
		department.waitForElementIsInteractable(
				By.xpath(department.stringFormat(editCategorysIcon, Integer.toString(count))));
		department.clickByJsExecuter(By.xpath(department.stringFormat(editCategorysIcon, Integer.toString(count))));
		department.forcedWaitTime(3);
		department.clearElement(NameField);

		String editDept = departmentCategory + "Edited" + RandomStrings.requiredString(2);
		department.sendKeysWithWait(NameField, editDept);
		department.waitForElementIsInteractable(SaveButton);
		department.clickByJsExecuter(SaveButton);
		department.waitForCurserRunning(5);
		department.forcedWaitTime(2);

		SoftAssert st = new SoftAssert();
		st.assertTrue(
				department.elementIsDisplayed(By.xpath(department.stringFormat(selectDepartmentValue, editDept))));
		st.assertAll();

	}

	@Test(priority = 14, enabled = true, description = "Verify that user is able to create assignment rule set with department category, on 'Assignment Rules' page.  ")
	public void verifyThatUserIsAbleToCreatedTheAssignmentRuleAssociatedWithDeartmentCategory()
			throws InterruptedException {
		crmCommonMethods.navigateToAgencySetup();
		crmCommonMethods.navigateToAssignmentRules();

		// use categoryName = "Dept Category"
		// use DeptName = "Test Dept1"
		submissionAssignmentUtility.SubmissionAssignmentBaseOnAddedRuleWithDeptCategory();

		SoftAssert st = new SoftAssert();
		st.assertTrue(department.elementIsDisplayed(customerSubmissionHeader));
		st.assertAll();

	}

	String CSDPSubmissionHeader, extractedSubmissionNumber;

	@Test(priority = 15, enabled = true, description = "Verify that appropriate 'Assigned To' , 'Collaborator's' & 'Department'  configured with the departmentCategory appears on 'CSDP'")
	public void verifyThatAppropriateAssigneeCollabAppearsOnCSDP() throws InterruptedException {

		String assigneeName = csdp.getTextElement(SubmissionAssingee);
		String actualCollabratorName = csdp.getTextElement(SubmissionCollaborator);
		String actualDepartmentName = csdp.getTextElement(departmentLabelCSDP);
		System.out.println("actualDepartmentName: " + actualDepartmentName);
		CSDPSubmissionHeader = department.getTextElement(CSDPSubmissionID);
		extractedSubmissionNumber = crmCommonMethods.extractSubmissionIdOnCSDP(CSDPSubmissionHeader);
		System.out.println("extractedSubmissionNumber: " + extractedSubmissionNumber);

		SoftAssert st = new SoftAssert();
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			st.assertEquals(assigneeName, "Mark Shane", "assignee  name text doesnot match");
			st.assertEquals(actualDepartmentName, "Test Dept1", "testDepartment name doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			st.assertEquals(assigneeName, "Amandeep Singh1", "assignee  name text doesnot match");
			st.assertEquals(actualDepartmentName, "Test Dept1", "testDepartment name doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			st.assertEquals(assigneeName, "Shane ES", "assignee  name text doesnot match");
			st.assertEquals(actualDepartmentName, "Test Dept1", "testDepartment name doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			st.assertEquals(actualCollabratorName, "Amandeep Singh1", "collabrator  name text doesnot match");
			st.assertEquals(actualDepartmentName, "Test Dept1", "testDepartment name doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			st.assertEquals(actualCollabratorName, "Amandeep Singh1", "collabrator  name text doesnot match");
			st.assertEquals(actualDepartmentName, "Test Dept1", "testDepartment name doesnot match");
		}
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			st.assertEquals(actualCollabratorName, "Amandeep Singh1", "collabrator  name text doesnot match");
			st.assertEquals(actualDepartmentName, "Test Dept1", "testDepartment name doesnot match");
		}
		st.assertAll();

	}

	@Test(priority = 16, enabled = true, description = "Verify that appropriate department name appears under departement column, on 'CSLP' page.")
	public void verifyThatAppropriateDepartmentAppearAssociatedWithSubmissionCSLP() throws InterruptedException {
		crmCommonMethods.navigateToCSLP();
		department.clickOn(FilterSlider);
		department.waitForElementIsInteractable(departmentCheckBoxCSLP);
		department.clickOn(departmentCheckBoxCSLP);
		department.waitForElementIsInteractable(FilterSliderClose);
		department.clickOn(FilterSliderClose);
		cslpUtility.sendKeysWithWait(CSLPSearchField, extractedSubmissionNumber);

		String acutaldepartValue = department
				.getTextElement(By.xpath(department.stringFormat(departmentColumnCSLP, extractedSubmissionNumber)));
		System.out.println("departValue: " + acutaldepartValue);

		SoftAssert st = new SoftAssert();
		st.assertEquals(acutaldepartValue, "Test Dept1", "department name doesnot match");
		st.assertAll();
	}

}
