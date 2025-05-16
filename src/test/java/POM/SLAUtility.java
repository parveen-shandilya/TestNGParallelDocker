package POM;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class SLAUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;

	public SLAUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		crmCommonMethod= new CRMCommonMethods(driver);
	}
	
	 public static String sLASideBar = "//label[text()='SLA']";
	    public static String sLAName = "//input[@name='label']";
	    public static String sLADescription = "//input[@name='description']";
	    public static String sLaHeaderLabel = "//div[text()='SLA']";
	    public static String createSLABtn = "//button[text()='Create SLA']";
	    public static String crtSLAHeaderPopup = "//div[@class='modal-header']//h1[text()='Create SLA']";
	    public static String crtSLACancel = "//div[@class='modal-header']//button[text()='Cancel']";
	    public static String crtSLACreateSLA = "//div[@class='modal-header']//button[text()='Create SLA']";
	    public static String editSLASave = "//div[@class='modal-header']//button[text()='Save']";
	    public static String crtSLANameValid = "(//span[@class='field__error'])[1]";
	    public static String crtSLAGlobalValid = "(//div[@class='modal-body']/div)[1]";
	    public static String crtSLAddRuleBtn = "//button[text()='Add Rule']";
	    public static String crtSLACrtRuleHeader = "//h1[text()='Create Rule']";
	    public static String crtRuleCncel = "//h1[text()='Create Rule']//parent::div//button[text()='Cancel']";
	    public static String crtRuleCreateRule = "//h1[text()='Create Rule']//parent::div//button[text()='Create Rule']";
	    public static String crtRuleSpecifyActValid = "//h2[text()='Specify Action']//ancestor::div[@class='fields-container tile']//span[@class='field__error']";
	    public static String closeCriteria = "(//div[@class='close-icon'])[2]";
	    public static String esclateToSelectArrow = "//label[@title='Escalate To']//parent::div//parent::div//span[@class='Select-arrow']";
	    public static String selectEsclateValue = "(//li[@class='multi']//input[@type='checkbox'])[1]";

	    public static String freqSendingArrow = "//label[@title='Frequency of Sending Notifications']//parent::div//parent::div//span[@class='Select-arrow']";
	    public static String freqSendingValue = "//div[@class='Select-menu-outer']//div[@aria-label='Daily']";
	    public static String editRule = "(//h2[text()='Rules Set']//ancestor::div[@class='fields-container tile']//button)[2]";
	    public static String editSaveRule = "//h1[text()='Edit Rule']//ancestor::div[@class='modal-header']//button[text()='Save']";
	    public static String activeSLADet = "//h2[contains(text(),'Active')]";
	    public static String existingErrorTemplate = "//div[contains(text(),'Duplicate name. Please use a different name.')]";
	    public static String inactiveToggle = "//button[text()='Inactive']";
	    public static String inActiveSLADet = "//h2[contains(text(),'Inactive')]";
	    public static String activeToggle = "//button[text()='Active']";
	    public static By slaGridDataCount = By.xpath("(//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])");
        public static By inacticeSLAGridCount = By.xpath("(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])");

	    public static By SLASideBar = By.xpath(sLASideBar);
	    public static By InActiveSLADet = By.xpath(inActiveSLADet);
	    public static By InactiveToggle = By.xpath(inactiveToggle);
	    public static By ActiveToggle = By.xpath(activeToggle);
	    public static By ExistingErrorTemplate = By.xpath(existingErrorTemplate);
	    public static By EditSLASave = By.xpath(editSLASave);
	    public static By ActiveSLADet = By.xpath(activeSLADet);
	    public static By EditSaveRule = By.xpath(editSaveRule);
	    public static By SLADescription = By.xpath(sLADescription);
	    public static By SLAName = By.xpath(sLAName);
	    public static By SLaHeaderLabel = By.xpath(sLaHeaderLabel);
	    public static By CreateSLABtn = By.xpath(createSLABtn);
	    public static By CrtSLAHeaderPopup = By.xpath(crtSLAHeaderPopup);
	    public static By CrtSLACancel = By.xpath(crtSLACancel);
	    public static By CrtSLACreateSLA = By.xpath(crtSLACreateSLA);
	    public static By CrtSLANameValid = By.xpath(crtSLANameValid);
	    public static By CrtSLAGlobalValid = By.xpath(crtSLAGlobalValid);
	    public static By CrtSLAddRuleBtn = By.xpath(crtSLAddRuleBtn);
	    public static By CrtSLACrtRuleHeader = By.xpath(crtSLACrtRuleHeader);
	    public static By CrtRuleCncel = By.xpath(crtRuleCncel);
	    public static By CrtRuleCreateRule = By.xpath(crtRuleCreateRule);
	    public static By CrtRuleSpecifyActValid = By.xpath(crtRuleSpecifyActValid);
	    public static By CloseCriteria = By.xpath(closeCriteria);
	    public static By EsclateToSelectArrow = By.xpath(esclateToSelectArrow);
	    public static By SelectEsclateValue = By.xpath(selectEsclateValue);
	    public static By FreqSendingArrow = By.xpath(freqSendingArrow);
	    public static By FreqSendingValue = By.xpath(freqSendingValue);
	    public static By EditRule = By.xpath(editRule);
	    public static String ActualSLAHeader;
	    public static String expectedSLAHeader = "SLA";
	    public static String actualSLApopHeader;
	    public static String expectedSLApopHeader = "Create SLA";
	    public static int SLApopHeader;

	    public static String actualGlobalValidSLA;
	    public static String expectedGlobalValidSLA = "At least one rule should be present.";

	    public static String actualNameValidSLA;
	    public static String expectedNameValidSLA = "The Name is required.";

	    public static String actualcrtRuleHeader;
	    public static String expectedCrtRuleHeader = "Create Rule";



	    public void LoginAdmin() throws InterruptedException {
			log.LoginAgency();

		}
	    
	    public  void AgencySetup_SLAPreRequisite() throws InterruptedException {
	        waitUntilElementIsVisible(NotificationManagementUtility.CaseNavigation);
	        scrollIntoView(NotificationManagementUtility.CaseNavigation);
	        crmCommonMethod.navigateToAgencySetup();
	        crmCommonMethod.navigateToSLA();
	        ActualSLAHeader = getTextElement(SLaHeaderLabel);
	        waitUntilElementIsVisible(CreateSLABtn);
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(ActualSLAHeader, expectedSLAHeader);
	        softAssert.assertAll();

	    }

	    public  void AgencySetup_CreateSLAPopupOpenAndClose() throws InterruptedException {
	        waitUntilElementIsVisible(CreateSLABtn);
	        scrollIntoView(CreateSLABtn);
	        BeforeactiveSLACount = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        waitForElementIsInteractable(CreateSLABtn);
	        clickByJsExecuter(CreateSLABtn);
	        waitUntilElementIsVisible(CrtSLAHeaderPopup);
	        actualSLApopHeader = getTextElement(CrtSLAHeaderPopup);
	        waitUntilElementIsVisible(CrtSLACancel);
	        scrollIntoView(CrtSLACancel);
	        waitForElementIsInteractable(CrtSLACancel);
	        clickByJsExecuter(CrtSLACancel);
	        waitUntilElementInvisibleLocated(CrtSLACancel);
	        waitUntilElementIsVisible(CrtSLAHeaderPopup);
	        SLApopHeader = driver.findElements(CrtSLAHeaderPopup).size();
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(actualSLApopHeader, expectedSLApopHeader);
	        softAssert.assertEquals(SLApopHeader == 0, true);
	        softAssert.assertAll();


	    }


	    public  int actualcrtRuleHeader1;

	    public  void AgencySetup_CreateSLAPopupValidatiions() throws InterruptedException {

	        waitUntilElementIsVisible(CreateSLABtn);
	        scrollIntoView(CreateSLABtn);
	        waitForElementIsInteractable(CreateSLABtn);
	        clickByJsExecuter(CreateSLABtn);


	        waitUntilElementIsVisible(CrtSLACreateSLA);
	        scrollIntoView(CrtSLACreateSLA);
	        waitForElementIsInteractable(CrtSLACreateSLA);
	        clickByJsExecuter(CrtSLACreateSLA);
	        waitUntilElementIsVisible(CrtSLANameValid);
	        waitUntilElementIsVisible(CrtSLAGlobalValid);
	        actualNameValidSLA = getTextElement(CrtSLANameValid);
	        actualGlobalValidSLA = getTextElement(CrtSLAGlobalValid);
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(actualNameValidSLA, expectedNameValidSLA);
	        softAssert.assertEquals(actualGlobalValidSLA, expectedGlobalValidSLA);

	        softAssert.assertAll();
	    }


	    public  String actualAddRuleAttributValidation;
	    public  String actualAddRuleOperatorValidation;
	    public  String actualAddRuleValueValidation;

	    public  String actualEsclatToValidation;
	    public  String UseTemplateValidation;
	    public  String actualFreqSendingValidation;


	    public  String expectedAddRuleAttributValidation = "The Attribute is required.";
	    public  String expectedAddRuleOperatorValidation = "The Operator is required.";
	    public  String expectedAddRuleValueValidation = "The Value is required.";

	    public  String expectedEsclatToValidation = "The Escalate To is required.";
	    public  String expectedUseTemplateValidation = "The Template is required.";
	    public  String expectedFreqSendingValidation = "The Frequency is required.";

	    public  void AgencySetup_CreateSLAAddRuleValidations() throws InterruptedException {

	        scrollIntoView(CrtSLAddRuleBtn);
	        Thread.sleep(2000);
	        waitForElementIsInteractable(CrtSLAddRuleBtn);
	        clickByJsExecuter(CrtSLAddRuleBtn);
	        waitUntilElementIsVisible(CrtSLACrtRuleHeader);
	        actualcrtRuleHeader = getTextElement(CrtSLACrtRuleHeader);
	        scrollIntoView(CrtRuleCncel);
	        Thread.sleep(3000);
	        waitForElementIsInteractable(CrtRuleCncel);
	        clickOn(CrtRuleCncel);
	        waitUntilElementIsVisible(CrtSLACrtRuleHeader);
	        actualcrtRuleHeader1 = driver.findElements(CrtSLACrtRuleHeader).size();
	        scrollIntoView(CrtSLAddRuleBtn);
	        waitForElementIsInteractable(CrtSLAddRuleBtn);
	        clickOn(CrtSLAddRuleBtn);
	        waitForCurserRunning(3);


	        waitUntilElementIsVisible(NotificationManagementUtility.CrtRuleAddCriteria);
	        waitForElementIsInteractable(NotificationManagementUtility.CrtRuleAddCriteria);
	        clickOn(NotificationManagementUtility.CrtRuleAddCriteria);

	        waitUntilElementIsVisible(CrtRuleCreateRule);
	        scrollIntoView(CrtRuleCreateRule);
	        waitForElementIsInteractable(CrtRuleCreateRule);
	        clickOn(CrtRuleCreateRule);

	        waitUntilElementIsVisible(NotificationManagementUtility.CrtRuleCriteriaValid);
	        waitUntilVisibleList(NotificationManagementUtility.CrtRuleCriteriaValid);
	        waitUntilVisibleList(CrtRuleSpecifyActValid);
	        ArrayList<String> criteriaValid = new ArrayList<>();
	        driver.findElements(NotificationManagementUtility.CrtRuleCriteriaValid).stream().forEach(x -> criteriaValid.add(x.getText()));

	        actualAddRuleAttributValidation = criteriaValid.get(2);
	        actualAddRuleOperatorValidation = criteriaValid.get(3);
	        actualAddRuleValueValidation = criteriaValid.get(4);

	        waitUntilElementIsVisible(CrtRuleSpecifyActValid);
	        scrollIntoView(CrtRuleSpecifyActValid);

	        ArrayList<String> specifyActValid = new ArrayList<String>();
	        driver.findElements(CrtRuleSpecifyActValid).stream().forEach(x -> specifyActValid.add(x.getText()));
	        actualEsclatToValidation = specifyActValid.get(0);
	        UseTemplateValidation = specifyActValid.get(1);
	        actualFreqSendingValidation = specifyActValid.get(2);
	        
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(actualcrtRuleHeader1 == 1, true);
	        softAssert.assertEquals(actualcrtRuleHeader, expectedCrtRuleHeader);
	        softAssert.assertEquals(actualAddRuleAttributValidation, expectedAddRuleAttributValidation);
	        softAssert.assertEquals(actualAddRuleOperatorValidation, expectedAddRuleOperatorValidation);
	        softAssert.assertEquals(actualAddRuleValueValidation, expectedAddRuleValueValidation);

	        softAssert.assertEquals(actualEsclatToValidation, expectedEsclatToValidation);
	        softAssert.assertEquals(UseTemplateValidation, expectedUseTemplateValidation);
	        softAssert.assertEquals(actualFreqSendingValidation, expectedFreqSendingValidation);

	        softAssert.assertAll();
	    }

	    public  String selectedAttriVal;
	    public  String selectedCatVal;
	    public  String AddedRuleDesc;

	    public  void AgencySetup_CreateSLA_AddRule() throws InterruptedException {
	        waitUntilElementIsVisible(CloseCriteria);
	        scrollIntoView(CloseCriteria);
	        waitForElementIsInteractable(CloseCriteria);
	        clickOn(CloseCriteria);

	        waitUntilElementIsVisible(NotificationManagementUtility.ValueSelectArrow);
	        clickOn(NotificationManagementUtility.ValueSelectArrow);

	        waitUntilElementIsVisible(NotificationManagementUtility.SelectValue);
	        clickByJsExecuter(NotificationManagementUtility.SelectValue);

	        waitUntilElementIsVisible(NotificationManagementUtility.SelectedAttribute);
	        waitUntilElementIsVisible(NotificationManagementUtility.SelectedValue);
	        selectedAttriVal = getTextElement(NotificationManagementUtility.SelectedAttribute);
	        selectedCatVal = getTextElement(NotificationManagementUtility.SelectedValue);


	        waitUntilElementIsVisible(EsclateToSelectArrow);
	        clickOn(EsclateToSelectArrow);

	        waitUntilElementIsVisible(SelectEsclateValue);
	        clickByJsExecuter(SelectEsclateValue);

	        waitUntilElementIsVisible(NotificationManagementUtility.UseEmialTemplateSelectArrow);
	        clickOn(NotificationManagementUtility.UseEmialTemplateSelectArrow);

	        waitUntilElementIsVisible(NotificationManagementUtility.SelectUseEmailTemp);
	        clickOn(NotificationManagementUtility.SelectUseEmailTemp);

	        waitUntilElementIsVisible(FreqSendingArrow);
	        clickOn(FreqSendingArrow);

	        waitUntilElementIsVisible(FreqSendingValue);
	        clickOn(FreqSendingValue);

	        waitUntilElementIsVisible(NotificationManagementUtility.CrtCreateRule);
	        scrollIntoView(NotificationManagementUtility.CrtCreateRule);
	        waitForElementIsInteractable(NotificationManagementUtility.CrtCreateRule);
	        clickByJsExecuter(NotificationManagementUtility.CrtCreateRule);
	        waitForCurserRunning(5);

	        waitUntilElementIsVisible(NotificationManagementUtility.AddedRuleCriteria);
	        scrollIntoView(NotificationManagementUtility.AddedRuleCriteria);
	        AddedRuleDesc = getTextElement(NotificationManagementUtility.AddedRuleCriteria);
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(AddedRuleDesc.contains(selectedCatVal), true);
	        softAssert.assertEquals(AddedRuleDesc.contains(selectedAttriVal), true);
	        softAssert.assertAll();

	    }


	    public  String EdditedRuleDesc;

	    public  void AgencySetup_CreateSLA_EditAddRule() throws InterruptedException {

	        waitUntilElementIsVisible(EditRule);
	        waitForElementIsInteractable(EditRule);
	        scrollIntoView(EditRule);
	        clickOn(EditRule);

	        waitUntilElementIsVisible(NotificationManagementUtility.ValueSelectArrow);
	        clickOn(NotificationManagementUtility.ValueSelectArrow);

	        waitUntilElementIsVisible(NotificationManagementUtility.SelectValue);
	        clickByJsExecuter(NotificationManagementUtility.SelectValue);

	        waitForElementIsInteractable(NotificationManagementUtility.SelectCatValue2);
	        clickByJsExecuter(NotificationManagementUtility.SelectCatValue2);

	        waitUntilElementIsVisible(NotificationManagementUtility.ValueSelectArrow);
	        clickOn(NotificationManagementUtility.ValueSelectArrow);

	        waitUntilElementIsVisible(NotificationManagementUtility.SelectedValue);
	        selectedCatVal = getTextElement(NotificationManagementUtility.SelectedValue);

	        waitUntilElementIsVisible(EditSaveRule);
	        scrollIntoView(EditSaveRule);
	        waitForElementIsInteractable(EditSaveRule);
	        clickOn(EditSaveRule);
	        waitForCurserRunning(4);

	        waitUntilElementIsVisible(NotificationManagementUtility.AddedRuleCriteria);
	        scrollIntoView(NotificationManagementUtility.AddedRuleCriteria);
	        EdditedRuleDesc = getTextElement(NotificationManagementUtility.AddedRuleCriteria);
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(EdditedRuleDesc.contains(selectedCatVal), true);

	        softAssert.assertAll();


	    }


	    public  String sLALableName;
	    public  String actualSLAName;
	    public  String sLADesription;
	    public  String actuaalsLADesription;
	    public  int AfteractiveSLACount;
	    public  int BeforeactiveSLACount;
	    public  String newAddedSLA;

	    public  String GetActiveSLAGridData(int index) {
	        String xPath = "(//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])[" + index + "]";
	        return xPath;
	    }

	    public  void AgencySetup_CreateSLA() throws InterruptedException {

	        String rndString = RandomStrings.requiredCharacters(4);
	        sLALableName = "SLA" + rndString;
	        sLADesription = "SLADesc" + rndString;
	        waitUntilElementIsVisible(ActiveSLADet);
	        scrollIntoView(ActiveSLADet);
	        waitUntilElementIsVisible(SLAName);
	        scrollIntoView(SLAName);
	        waitForElementIsInteractable(SLAName);
	        clickOn(SLAName);
	        Thread.sleep(4000);
	        sendKeysWithWait(SLAName, sLALableName);
	        waitForElementIsInteractable(SLADescription);
	        clickOn(SLADescription);
	        Thread.sleep(2000);
	        sendKeysWithWait(SLADescription, sLADesription);
	        scrollIntoView(CrtSLACreateSLA);
	        waitForElementIsInteractable(CrtSLACreateSLA);
	        clickOn(CrtSLACreateSLA);
	        waitForCurserRunning(8);
	        Thread.sleep(4000);
	        
	        
	        if(findElementsSize(FinesUtility.fineGridNextbtn) > 0) {
	        Boolean nextbtn = findElement(FinesUtility.fineGridNextbtn).isEnabled();
			while(nextbtn) {
				clickByJsExecuter(FinesUtility.fineGridNextbtn);
				forcedWaitTime(2);
				nextbtn = findElement(FinesUtility.fineGridNextbtn).isEnabled();
				
			}
	    }
	        waitUntilElementIsVisible(ActiveSLADet);
	        scrollIntoView(ActiveSLADet);
	        
	        int count = findElementsSize(slaGridDataCount);
	        AfteractiveSLACount = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        //int gridindx = 4 * AfteractiveSLACount;
	        scrollIntoView(By.xpath(GetActiveSLAGridData(count - 3)));
	        newAddedSLA = getTextElement(By.xpath(GetActiveSLAGridData(count - 3)));
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(newAddedSLA, sLALableName);
	        softAssert.assertEquals(AfteractiveSLACount, BeforeactiveSLACount + 1);
	        softAssert.assertAll();
	    }


	    public  String GetActiveSLAEditIcon(int index) {

	        String xPath = "(//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td']//button)[" + index + "]";
	        return xPath;

	    }


	    public  String newEditSLA;
	    public  String EditsLADesription;

	    public  void AgencySetup_EditSLA() throws InterruptedException {

	        forcedWaitTime(2);
	        waitUntilElementIsVisible(ActiveSLADet);
	        scrollIntoView(ActiveSLADet);
	        BeforeactiveSLACount = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        int indx = BeforeactiveSLACount;
	        int count = findElementsSize(slaGridDataCount);
//	        waitForElementIsInteractable(By.xpath(GetActiveSLAEditIcon(indx)));
	        //clickByJsExecuter(By.xpath(GetActiveSLAEditIcon(indx)));
	        String sLAName = getTextElement(By.xpath(GetActiveSLAGridData(count - 3)));
	        String sLADescriptionName = getTextElement(By.xpath(GetActiveSLAGridData(count - 2)));
	        clickByJsExecuter(By.xpath(GetActiveSLAEditIcon(count/4)));

	        waitUntilElementIsVisible(SLAName);
	        waitForElementIsInteractable(SLAName);
	        sLALableName = "EditSLA" + RandomStrings.requiredCharacters(4);
			System.out.println("sLALableName : "+sLALableName);
	        forcedWaitTime(2);
	        clearByJSE(SLAName);
	        waitForElementIsInteractable(SLAName);
	        forcedWaitTime(2);
	        sendKeysWithWait(SLAName, sLALableName);
	        waitForElementIsInteractable(SLADescription);
	        clearElement(SLADescription);
	        waitForElementIsInteractable(SLADescription);
	        sLADesription = "EditSLADesc" + RandomStrings.requiredCharacters(4);
			System.out.println("sLADesription: "+sLADesription);
	        forcedWaitTime(2);
	        sendKeysWithWait(SLADescription, sLADesription);
	        scrollIntoView(EditSLASave);
	        waitForElementIsInteractable(EditSLASave);
	        forcedWaitTime(2);
	        clickOn(EditSLASave);
	        waitUntilElementInvisibleLocated(EditSLASave);
	        waitForCurserRunning(5);
	        waitUntilElementIsVisible(ActiveSLADet);
	        if(findElementsSize(FinesUtility.fineGridNextbtn) > 0) {
		        Boolean nextbtn = findElement(FinesUtility.fineGridNextbtn).isEnabled();
				while(nextbtn) {
					clickByJsExecuter(FinesUtility.fineGridNextbtn);
					forcedWaitTime(2);
					nextbtn = findElement(FinesUtility.fineGridNextbtn).isEnabled();
					
				}
		    }
	        forcedWaitTime(4);
	        scrollIntoView(ActiveSLADet);

	        AfteractiveSLACount = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        int gridindx = 4 * AfteractiveSLACount;
	        newEditSLA = getTextElement(By.xpath(GetActiveSLAGridData(count - 3)));
			System.out.println("newEditSLA: "+ newEditSLA);
	        EditsLADesription = getTextElement(By.xpath(GetActiveSLAGridData(count - 2)));
			System.out.println("EditsLADesription: " +EditsLADesription);
			SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(newEditSLA, sLALableName);
	        softAssert.assertEquals(EditsLADesription, sLADesription);
	        softAssert.assertAll();
	    }


	    public  String existingSLAName;
	    public  String existingsLADesription;
	    public  String expectedduplicatErrorMessage = "Duplicate name. Please use a different name.";
	    public  String actualErrorMsg;

	    public  void AgencySetup_ErrorMessageAppearCreatingExistingSLAName() throws InterruptedException {

	        waitUntilElementIsVisible(ActiveSLADet);
	        scrollIntoView(ActiveSLADet);
	        AfteractiveSLACount = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        int gridindx = 4 * AfteractiveSLACount;
	        int count = findElementsSize(slaGridDataCount);
	        existingSLAName = getTextElement(By.xpath(GetActiveSLAGridData(count - 3)));
	        existingsLADesription = getTextElement(By.xpath(GetActiveSLAGridData(count - 2)));
	        waitUntilElementIsVisible(CreateSLABtn);
	        scrollIntoView(CreateSLABtn);
	        waitForElementIsInteractable(CreateSLABtn);
	        clickByJsExecuter(CreateSLABtn);
	        waitUntilElementIsVisible(SLAName);
	        waitForElementIsInteractable(SLAName);
	        sendKeysWithWait(SLAName, existingSLAName);
	        waitForElementIsInteractable(SLADescription);
	        sendKeysWithWait(SLADescription, existingsLADesription);
	        AgencySetup_CreateSLAAddRuleValidations();
	        AgencySetup_CreateSLA_AddRule();
	        scrollIntoView(CrtSLACreateSLA);
	        waitForElementIsInteractable(CrtSLACreateSLA);
	        clickOn(CrtSLACreateSLA);
	        waitForCurserRunning(3);
	        waitUntilElementIsVisible(ExistingErrorTemplate);
	        actualErrorMsg = getTextElement(ExistingErrorTemplate);
	        scrollIntoView(CrtSLACancel);
	        waitForElementIsInteractable(CrtSLACancel);
	        clickByJsExecuter(CrtSLACancel);
	        waitUntilElementInvisibleLocated(CrtSLACancel);
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(actualErrorMsg, expectedduplicatErrorMessage);
	        softAssert.assertAll();


	    }


	    public  String GetInactiveSLAGridData(int index) {
	        String xPath = "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])[" + index + "]";
	        return xPath;
	    }

	    public  String GetInactiveSLAEditIcon(int index) {
	        String xPath = "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td']//button)[" + index + "]";
	        return xPath;
	    }


	    public  String activeSLAName;
	    public  String inactivateSLA;
	    public  int activeSLACount;
	    public  int inactiveSLACount;
	    public  int inactiveSLACountBefore;

	    public  void AgencySetup_InactivteActiveSLA() throws InterruptedException {


	        waitUntilElementIsVisible(InActiveSLADet);
	        waitUntilElementIsVisible(ActiveSLADet);
	        scrollIntoView(InActiveSLADet);
	        inactiveSLACountBefore = Integer.parseInt(getTextElement(InActiveSLADet).split(" ")[0]);
	        scrollIntoView(ActiveSLADet);
	        activeSLACount = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        int count = findElementsSize(slaGridDataCount);
	        String activeSLAName = getTextElement(By.xpath(GetActiveSLAGridData(count - 3)));
	        clickByJsExecuter(By.xpath(GetActiveSLAEditIcon(count/4)));

	        forcedWaitTime(2);
	        scrollIntoView(InactiveToggle);
	        waitForElementIsInteractable(InactiveToggle);
	        clickOn(InactiveToggle);

	        forcedWaitTime(2);
	        scrollIntoView(EditSLASave);
	        waitForElementIsInteractable(EditSLASave);
	        clickOn(EditSLASave);
	        waitForCurserRunning(5);
	        waitUntilElementIsVisible(InActiveSLADet);
	        scrollIntoView(InActiveSLADet);
	        inactiveSLACount = Integer.parseInt(getTextElement(InActiveSLADet).split(" ")[0]);
	        int indx = 4 * inactiveSLACount;
	        int inactivecount = findElementsSize(inacticeSLAGridCount);

	        inactivateSLA = getTextElement(By.xpath(GetInactiveSLAGridData(inactivecount - 3)));
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(inactiveSLACountBefore + 1, inactiveSLACount);
	        softAssert.assertEquals(activeSLAName, inactivateSLA);
	        softAssert.assertAll();
	    }


	    public  String inactiveSLAName;
	    public  String ActivateSLA;
	    public  int activeSLACountBefore;

	    public  void AgencySetup_ActivateInactiveSLA() throws InterruptedException {
	        waitUntilElementIsVisible(ActiveSLADet);
	        waitUntilElementIsVisible(InActiveSLADet);
	        scrollIntoView(ActiveSLADet);
	        activeSLACountBefore = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        scrollIntoView(InActiveSLADet);
	        inactiveSLACount = Integer.parseInt(getTextElement(InActiveSLADet).split(" ")[0]);
	        int indx = 4 * inactiveSLACount;
	        Thread.sleep(2000);     
	        int count = findElementsSize(inacticeSLAGridCount);
	        String activeSLAName = getTextElement(By.xpath(GetInactiveSLAEditIcon(count/4)));
	        clickByJsExecuter(By.xpath(GetInactiveSLAEditIcon(count/4)));
	        forcedWaitTime(4);
	        waitUntilElementIsVisible(ActiveToggle);
	        scrollIntoView(ActiveToggle);
	        waitForElementIsInteractable(ActiveToggle);
	        clickOn(ActiveToggle);

	        forcedWaitTime(2);
	        scrollIntoView(EditSLASave);
	        waitForElementIsInteractable(EditSLASave);
	        clickOn(EditSLASave);
	        waitForCurserRunning(5);
	        waitUntilElementIsVisible(ActiveSLADet);
	        forcedWaitTime(4);
	        scrollIntoView(ActiveSLADet);
	        activeSLACount = Integer.parseInt(getTextElement(ActiveSLADet).split(" ")[0]);
	        int gridindx = 4 * activeSLACount;
	        
	        if(findElementsSize(FinesUtility.fineGridNextbtn) > 0) {
		        Boolean nextbtn = findElement(FinesUtility.fineGridNextbtn).isEnabled();
				while(nextbtn) {
					clickByJsExecuter(FinesUtility.fineGridNextbtn);
					forcedWaitTime(2);
					nextbtn = findElement(FinesUtility.fineGridNextbtn).isEnabled();
					
				}
		    }
	        
	        int Activecount = findElementsSize(slaGridDataCount);
	        waitUntilElementIsVisible(By.xpath(GetActiveSLAGridData(Activecount - 3)));
	        scrollIntoView(By.xpath(GetActiveSLAGridData(Activecount - 3)));
	        activeSLAName = getTextElement(By.xpath(GetActiveSLAGridData(Activecount - 3)));
	        
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(activeSLACountBefore + 1, activeSLACount);
	        softAssert.assertEquals(activeSLAName, inactivateSLA);
	        softAssert.assertAll();

	    }

	
	 
}
