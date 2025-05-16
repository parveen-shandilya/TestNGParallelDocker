package TestCases;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import ExtentReport.ExtentReportClass;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import POM.SmsAndEmailVerificationUtility;
import POM.SubmissionAssignmentUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static POM.SubmissionAssignmentUtility.*;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.st;

public class SubmissionAssignment extends BrowsersInvoked{

   
    CaseAssignmentUtility obj ;
    ExtentReportClass extentClass;
    ITestResult result;
    SubmissionAssignmentUtility  subAss;
    CRMCommonMethods crmCommonMethods;
    CECommonMethods ceCommonMethods;

  
    @BeforeClass
	public void setUp() {
		Setup(); // sets getDriver() for this thread
		
		subAss = new SubmissionAssignmentUtility(getDriver());
        crmCommonMethods = new CRMCommonMethods(getDriver());
        ceCommonMethods = new CECommonMethods(getDriver());
	}
	
	@AfterClass
	public void closeDriver() {
		tearDown();
	}

    @Test(priority = -1, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
    	LoginUtility log = new LoginUtility(getDriver());
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


    @Test(priority = 0,description = "Verify that 'Edit Assignment' popup opens up after clicking the 'Edit' icon next to 'Submission Assignment' rule on the 'Assignment Rules' page.")
    public void SubmissionAssignment_OpenEditAssignmentPopup() throws InterruptedException {
        subAss.SubmissionAssignment_OpenEditAssignmentPopup();
    }

    @Test(priority = 1,description = "Verify that user is not able to save the changes, when no Rule is added under 'Rules Set' tile, on 'Edit Assignment' popup. ")
    public void SubmissionAssignment_VerifyNoUpdationWithoutARule() throws InterruptedException {
        subAss.SubmissionAssignment_VerifyNoUpdationWithoutARule();
    }

    @Test(priority = 2,description = "Verify that 'Create Rule' popup opens up, when user clicks the 'Add Rule' button, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_OpenCreateRulePopup() throws InterruptedException {
        subAss.SubmissionAssignment_OpenCreateRulePopup();
    }

    @Test(priority = 3,description = "Verify that user is able to add multiple criterias under 'Define Critera' tile, after clicking on 'Add Criteria' link, on 'Create Rule' popup.")
    public void SubmissionAssignment_AddMultipleCriterias() throws InterruptedException {
        subAss.SubmissionAssignment_AddMultipleCriterias();
    }

    @Test(priority = 4,description = "Verify that the created rule gets added under 'Rules Set' tile, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_VerifyAddedRule() throws InterruptedException {
        subAss.SubmissionAssignment_VerifyAddedRule();
    }

    @Test(priority = 5,description = "Verify that user is able to edit the added Rules under 'Rules Set' tile, on 'Edit Assignment' popup")
    public void SubmissionAssignment_EditAddedRule() throws InterruptedException {
        subAss.SubmissionAssignment_EditAddedRule();
    }

    @Test(priority = 6,description = "Verify that user is able to delete that added Rules under 'Rules Set' tile, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_DeleteAddedRule() throws InterruptedException {
        subAss.SubmissionAssignment_DeleteAddedRule();
    }

    @Test(priority = 7,description = "Verify that Assignment Rule appears under 'Inactive' section, when user sets 'Status' toggle button as Inactive, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_AssignmentRuleUnderInactiveSection() throws InterruptedException {
        subAss.SubmissionAssignment_AssignmentRuleUnderInactiveSection();
    }

    @Test(priority = 8,description = "Verify submission assignment works as per configure rule.")
    public void SubmissionAssignmentBaseOnAddedRule() throws InterruptedException {
        subAss.SubmissionAssignmentBaseOnAddedRule();
    }

    @Test(priority = 9,description = "Verify Case assignment works as per configure rule.")
    public void CaseAssignmentBaseOnAddedRule() throws InterruptedException {
        subAss.CaseAssignmentBaseOnAddedRule();
    }



   @Test(priority = 10,description = "")
    public void verifyThatCascadingCustomFieldsAppear() throws InterruptedException {
       crmCommonMethods.navigateToAgencySetup();
       crmCommonMethods.navigateToAssignmentRules();
       subAss.waitUntilElementIsVisible(EditAssignmentIcon);
       subAss.waitForElementIsInteractable(EditAssignmentIcon);
       subAss.clickByJsExecuter(EditAssignmentIcon);
       subAss.waitForElementIsInteractable(AddRuleButton);
       subAss.clickByJsExecuter(AddRuleButton);
       subAss.waitForElementIsInteractable(CriteriaFields);
       subAss.clickByJsExecuter(CriteriaFields);
       subAss.waitUntilElementIsVisible(customCategoryFieldTab);
       subAss.clickByJsExecuter(customCategoryFieldTab);
       subAss.scrollIntoView(cascadingCategoryOption2);

       SoftAssert st = new SoftAssert();
       st.assertTrue(subAss.elementIsDisplayed(cascadingCategoryOption2));
       st.assertAll();

    }
    @Test(priority = 11,description = "")
    public void verifyThatEqualOperatorAppear() throws InterruptedException {

        subAss.waitUntilElementIsVisible(By.xpath(subAss.selectorFormate(cascadingCategoryOption,"CascadingCategory")));
        subAss.scrollIntoView(cascadingCategoryOption2);
        subAss.clickOn(By.xpath(subAss.selectorFormate(cascadingCategoryOption,"CascadingCategory")));
        subAss.waitUntilElementIsVisible(customFiled1);
        subAss.clickByJsExecuter(customFiled1);
        subAss.waitUntilElementIsVisible(CriteriaFields2);
        subAss.clickOn(CriteriaFields2);
        subAss.waitForElementIsInteractable(By.xpath(getSubmissionAttributeOperator("Contains")));

        SoftAssert st = new SoftAssert();
        st.assertTrue(subAss.elementIsDisplayed(By.xpath(getSubmissionAttributeOperator("Contains"))));
        st.assertAll();

    }

    @Test(priority = 12,description = "")
    public void verifyThatUSerIsAbleToAddAssignmentRule() throws InterruptedException {
       subAss.waitUntilElementIsVisible(By.xpath(getSubmissionAttributeOperator("Contains")));
        subAss.clickOn(By.xpath(getSubmissionAttributeOperator("Contains")));
        subAss.waitUntilElementIsVisible(CriteriaFields);
        subAss.clickOn(CriteriaFields);
        subAss.waitUntilElementIsVisible(By.xpath(getSubmissionAttribute("color1")));
        subAss.scrollIntoView(By.xpath(getSubmissionAttribute("color1")));
        subAss.clickOn(By.xpath(getSubmissionAttribute("color1")));

        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
            ceCommonMethods.addAssignee("Mark Shane","Amandeep Singh1");
        }
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
            ceCommonMethods.addAssignee("Amandeep","Amandeep Singh1");
        }
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
            ceCommonMethods.addAssignee("Shane ES","Amandeep Singh1");
        }
        subAss.waitForElementIsInteractable(CreateRulebutton);
        subAss.clickOn(CreateRulebutton);
        subAss.waitUntilElementInvisibleLocated(CreateRulebutton);
        SoftAssert st = new SoftAssert();
        st.assertTrue(subAss.elementIsDisplayed(ruleName));
        st.assertAll();

    }

    @Test(priority = 13,description = "")
    public void verifyThatUSerIsAbleToEditAddAssignmentRule() throws InterruptedException {
        subAss.clickOn(SaveButton);
        subAss.waitForCurserRunning(10);
        subAss.forcedWaitTime(3);
        subAss.waitUntilElementIsVisible(EditAssignmentIcon);
        subAss.waitForElementIsInteractable(EditAssignmentIcon);
        subAss.forcedWaitTime(3);
        subAss.clickOn(EditAssignmentIcon);
        subAss.waitForElementIsInteractable(NameField);
        subAss.forcedWaitTime(2);
        subAss.clearElement(NameField);
        subAss.sendKeysWithWait(NameField,"abcdUpdated");
        subAss.forcedWaitTime(3);
        subAss.clickOn(SaveButton);
        subAss.waitForCurserRunning(10);
        subAss.waitForPresenceandVisiblity(assignmentName);
        String actualTxt = subAss.getTextElement(assignmentName);
        SoftAssert st = new SoftAssert();
        st.assertEquals(actualTxt,"abcdUpdated");
        st.assertAll();

    }

    @Test(priority = 14,description = "")
    public void verifyThatUserIsAbleToDeleteAssignmentRule() throws InterruptedException {

        subAss.waitUntilElementIsVisible(EditAssignmentIcon);
        subAss.waitForElementIsInteractable(EditAssignmentIcon);
        subAss.clickOn(EditAssignmentIcon);

        List<WebElement> listBefore = subAss.findElementsByXPath(ruleNames);
        System.out.println(listBefore.size());
        int sizeBefore = (listBefore.size());

        subAss.clickOn(deleteRule);
        List<WebElement> listAfter = subAss.findElementsByXPath(ruleNames);
        System.out.println(listAfter.size());
        int sizeAfter = (listAfter.size());

        SoftAssert st = new SoftAssert();
        st.assertEquals(sizeBefore,sizeAfter+1);
        st.assertAll();

    }




}
