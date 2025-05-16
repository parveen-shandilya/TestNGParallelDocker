package POM;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static POM.CDP_Utility.Assignee;
import static POM.CSDPUtility.SubmissionAssingee;
import static POM.CSPInternalUtility.CloseSubmissionIcon;

public class SubmissionAssignmentUtility extends Helper{


    public WebDriver driver;
    public LoginUtility log;
    public CECommonMethods ce;
    public CRMCommonMethods crm;


    public SubmissionAssignmentUtility(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
        ce = new CECommonMethods(driver);
        crm = new CRMCommonMethods(driver);


    }

    

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();
	}

    public static String editAssignmentIcon = "//div[text()='Submission Received']//following::button[1]";
    public static  String editCaseAssingment = "//div[text()='Case Created']//following::button[1]";
    public static String editAssignmentPopup = "//div[@class='full-page-modal__header']/h1";
    public static String nameField = "//label[@title='Name']/following::input[@name='label']";
    public static String descriptionField = "//input[@name='description']";
    public static String actionDropdown = "//div[@class='Select-value']";
    public static String optionActionDropdown = "//*[text()='Submission Received']";
    public static String saveButton = "//button[text()='Save']";
    public static String crossIconRuleSet = "//div[@class='sortable-table__body__td']/button[2]";
    public static String validationNoRule = "//div[@class='modal-base__error modal-base__error--show']";
    public static String addRuleButton = "//button[text()='Add Rule']";
    public static String createRule = "//h1[text()='Create Rule']";
    public static String criteriaFields2 = "//label[@for='attribute']/following::div[@class='Select-placeholder'][1]";
    public static String criteriaFields = "(//label[contains(text(),'Select Option')])[1]";
    // Due to change in locator i have made a new one with same name
    //    public static String zipOption = "//*[text()='Zip']";
    public static String zipOption ="//*[span='Zip']";
    // Due to change in locator i have made a new one with same name
    //    public static String equalsOption = "//*[text()='Equals']";
    public static String equalsOption =" //*[@aria-label='Equals']";
    public static String addCriteriaLink = "//a[text()='Add Criteria']";
    public static String valueField = "//input[@name='value']";
    // Due to change in locator i have made a new one with same name
    //    public static String blockOption = "//*[text()='Block']";
    public static String blockOption = "(//*[span='Block'])[2]";
    // Due to change in locator i have made a new one with same name
    //  public static String equalsOption2 = "(//*[text()='Equals'])[2]";
    public static String equalsOption2 = "(//*[@aria-label='Equals'])";
    public static String valueField2 = "(//input[@name='value'])[2]";
    public static String caseAssigneeField = "//label[@for='caseAssignee']/following::label";
    public static String inspectionAssigneeField = "//label[@for='inspectionAssignee']/following::label[text()='Select Option']";
    public static String createRulebutton = "//button[text()='Create Rule']";
    public static String addedRule = "//div[@class='sortable-table__body__tr']";
    public static String editRuleIcon = "//div[@class='sortable-table__body__td']/button[1]";
    public static String crossCriteriaIcon = "(//div[@class='close-icon'])[2]";
    public static String saveButtonEditRule = "//h1[text()='Edit Rule']/following::button[text()='Save']";
    public static String assignCaseToColumn = "//div[@class='sortable-table__body__td'][2]";
    public static String deleteRuleIcon = "//div[@class='sortable-table__body__td']/button[2]";
    public static String inactiveToggle = "//button[text()='Inactive']";
    public static String activeToggle = "//button[text()='Active']";
    public static String defaultAssigneeField = "//label[@for='assignee']/following::label[1]";
    public static String selectCollaboratorField = "//label[@for='collaborators']/following::label[1]";
    public static String assigneeOption = "//label[@for='assignee']/following::ul/li[1]";
    public static String collaboratorsOption = "//label[@for='collaborators']/following::ul/li[1]";
    public static String assigneeOption2 = "//label[@for='assignee']/following::ul/li[2]";
    public static String assigneeSearch = "//div[@id='assignee']//input[@placeholder='Search...'][@name='query']";
    public static String searchedAssignee = "//div[@id='assignee']//ul//li//span//b";
    public static String collaboratorSearch = "//div[@id='collaborators']//input[@placeholder='Search...'][@name='query']";
    public static String collaboratorQA = "//label[@for='collaborators']/following::ul//li[@class='option']//b";
    public static String caseAssignee = "//label[@for='caseAssignee']/following::label[1]";

    public static By CriteriaFields2 = By.xpath(criteriaFields2);
    public static By EditAssignmentIcon = By.xpath(editAssignmentIcon);
    public static By EditCaseAssingment = By.xpath(editCaseAssingment);
    public static By AssigneeSearch = By.xpath(assigneeSearch);
    public static By SearchedAssignee = By.xpath(searchedAssignee);
    public static By CollaboratorSearch = By.xpath(collaboratorSearch);
    public static By EditAssignmentPopup = By.xpath(editAssignmentPopup);
    public static By NameField = By.xpath(nameField);
    public static By DescriptionField = By.xpath(descriptionField);
    public static By ActionDropdown = By.xpath(actionDropdown);
    public static By OptionActionDropdown = By.xpath(optionActionDropdown);
    public static By CrossIconRuleSet = By.xpath(crossIconRuleSet);
    public static By SaveButton = By.xpath(saveButton);
    public static By ValidationNoRule = By.xpath(validationNoRule);
    public static By AddRuleButton = By.xpath(addRuleButton);
    public static By CreateRule = By.xpath(createRule);
    public static By CriteriaFields = By.xpath(criteriaFields);
    public static By customLocationFieldsTab=By.xpath("(//div[@class='tabs__names']/div[text()='Custom Location Fields'])[1]");
	public static By customLocationFieldsTab2=By.xpath("(//div[@class='tabs__names']/div[text()='Custom Location Fields'])[2]");

    public static By ZipOption = By.xpath(zipOption);
    public static By EqualsOption = By.xpath(equalsOption);
    public static By ValueField = By.xpath(valueField);
    public static By AddCriteriaLink = By.xpath(addCriteriaLink);
    public static By EqualsOption2 = By.xpath(equalsOption2);
    public static By DefaultAssigneeField = By.xpath(defaultAssigneeField);
    public static By SelectCollaboratorField = By.xpath(selectCollaboratorField);
    public static By AssigneeOption = By.xpath(assigneeOption);
    public static By CollaboratorsOption = By.xpath(collaboratorsOption);
    public static By CreateRulebutton = By.xpath(createRulebutton);
    public static By AddedRule = By.xpath(addedRule);
    public static By EditRuleIcon = By.xpath(editRuleIcon);
    public static By AssigneeOption2 = By.xpath(assigneeOption2);
    public static By SaveButtonEditRule = By.xpath(saveButtonEditRule);
    public static By AssignCaseToColumn = By.xpath(assignCaseToColumn);
    public static By DeleteRuleIcon = By.xpath(deleteRuleIcon);
    public static By InactiveToggle = By.xpath(inactiveToggle);
    public static By BlockOption = By.xpath(blockOption);
    public static By ValueField2 = By.xpath(valueField2);
    public static By ActiveToggle = By.xpath(activeToggle);
    public static By CollaboratorQA = By.xpath(collaboratorQA);
    public static By CaseAssignee = By.xpath(caseAssignee);
    public static By caseAssigneeSearch=By.xpath("//div[@id='caseAssignee']//input[@placeholder='Search...'][@name='query']");
    public static By caseAssigneeList = By.xpath("(//label[@for='caseAssignee']/following::ul/li//b)[1]");
    public static By insepctionAssignee = By.xpath("//label[@for='inspectionAssignee']/following::label[1]");
    public static By insepctionAssigneeSearch =By.xpath("//div[@id='inspectionAssignee']//input[@placeholder='Search...'][@name='query']");
    public static By insepctionAssingeeList = By.xpath("//label[@for='inspectionAssignee']/following::ul/li//b");
    public static String collaborators = "//input[@name='%s']//parent::span//label";
    public static By customCategoryFieldTab = By.xpath("//div[text()='Custom Category Fields']");
    public static String cascadingCategoryOption = "//ul[@class='dropdown__options--single']//li//span[text()='%s']//..//a";

    public static By cascadingCategoryOption2 = By.xpath("//ul[@class='dropdown__options--single']//li//span[text()='CascadingCategory']");
    public static By customFiled1 = By.xpath("//li[@class='option option-pc']//span");
   public static By assignmentName = By.xpath("(//div[text()='Submission Received']//parent::div//div)[1]");
    public static By ruleName = By.xpath("(//div[@class='sortable-table__body__td'])//span[contains(text(),'CascadingField1')]");
    public static String ruleName1 = "(//div[@class='sortable-table__body__td'])//span[contains(text(),'CascadingField1')]";

    // for delete
    public static By deleteCustomCategoryRule = By.xpath("((//div[@class='sortable-table__body__td'])//span[contains(text(),'CascadingField1')]/../../div[@class='sortable-table__body__td']//button)[2]");

    public static By deleteRule = By.xpath("(((//div[@class='sortable-table__body__td'])//span)//parent::div//following-sibling::div//button[@class='delete-btn  btn btn-primary'])[1]");
    public static By ruleNames = By.xpath("(//div[@class='sortable-table__body__td'])//span");


    public  static String getSubmissionAttribute(String attr) {
        return "//*[span='"+attr+"']";
    }
    public  static String getSubmissionAttributeOperator(String attr) {
        return "//*[@aria-label='"+attr+"']";
        //(//*[@aria-label='Equals'])
    }

    public  String getSubmissionCollaborator(String col){
        return "//div[@id='collaborators']//ul//li//span//input[@name='"+col+"']";
    }

    public  String EditAssignmentPopupTitle;
    public  String NameValue;
    public  String RandomName;
    public  String NoRuleValidationText;
    public  String ExpectedValidation;
    public  String CreateRulePopupTitle;
    public  boolean SizeAfter;
    public  boolean CompareStr;
    public  boolean CompareCount_DeletedRule;

    public void SubmissionAssignment_OpenEditAssignmentPopup() throws InterruptedException {
        driver.navigate().to(BrowsersInvoked.URLAssignmentRules);
        waitForCurserRunning(7);
        waitUntilElementIsVisible(EditAssignmentIcon);
        waitUntilElementPresent(EditAssignmentIcon);
        waitForElementIsInteractable(EditAssignmentIcon);
        clickByJsExecuter(EditAssignmentIcon);
        waitUntilElementInvisibleLocated(EditAssignmentIcon);
        waitUntilElementIsVisible(EditAssignmentPopup);
        waitUntilElementPresent(EditAssignmentPopup);
        EditAssignmentPopupTitle =getTextElement(EditAssignmentPopup);
    }

    public  void SubmissionAssignment_VerifyNoUpdationWithoutARule() throws InterruptedException {
        RandomName = RandomStrings.requiredString(10);
        waitForElementIsInteractable(NameField);
        Thread.sleep(4000);
        WebElement Name = findElement(NameField);
        Name.clear();
        Name.sendKeys(RandomName);
        NameValue =waitUntilVisibleWE(NameField).getAttribute("value");

        int check = driver.findElements(CrossIconRuleSet).size();
        if (check > 0) {
            waitForElementIsInteractable(CrossIconRuleSet);
            Boolean crosscheck = driver.findElement(CrossIconRuleSet).isDisplayed();
            while (crosscheck) {
                waitForElementIsInteractable(CrossIconRuleSet);
                driver.findElement(CrossIconRuleSet).click();

                if (driver.findElements(CrossIconRuleSet).size() > 0) {
                    crosscheck = driver.findElement(CrossIconRuleSet).isDisplayed();
                } else {
                    crosscheck = false;
                }
            }
        }

        waitForElementIsInteractable(SaveButton);
        clickOn(SaveButton);
        waitForCurserRunning(3);
        waitUntilElementIsVisible(ValidationNoRule);
        NoRuleValidationText =getTextElement(ValidationNoRule);
        ExpectedValidation = "At least one rule should be present.";
    }

    public  void SubmissionAssignment_OpenCreateRulePopup() throws InterruptedException {
        clickOn(AddRuleButton);
        waitUntilElementIsVisible(CreateRule);
        CreateRulePopupTitle =getTextElement(CreateRule);
    }

    public  void SubmissionAssignment_AddMultipleCriterias() throws InterruptedException {
        waitUntilElementPresent(CriteriaFields);
        waitForElementIsInteractable(CriteriaFields);
        clickOn(CriteriaFields);
        Thread.sleep(3000);
        waitForElementIsInteractable(customLocationFieldsTab);
        clickOn(customLocationFieldsTab);
        waitForElementIsInteractable(ZipOption);
        forcedWaitTime(3);
        clickOn(ZipOption);
        clickOn(CriteriaFields2);
        waitForElementIsInteractable(EqualsOption);
        clickOn(EqualsOption);
        waitForElementIsInteractable(ValueField);
        sendKeysWithWait(ValueField, "77590");
        clickOn(AddCriteriaLink);
        waitForElementIsInteractable(CriteriaFields);
        clickOn(CriteriaFields);
        waitForElementIsInteractable(customLocationFieldsTab2);
        clickOn(customLocationFieldsTab2);
        waitForElementIsInteractable(BlockOption);
        clickOn(BlockOption);
        clickOn(CriteriaFields2);
        waitForElementIsInteractable(EqualsOption2);
        clickOn(EqualsOption2);
        waitForElementIsInteractable(ValueField2);
        sendKeysWithWait(ValueField2, "1");
        clickOn(DefaultAssigneeField);
        waitForElementIsInteractable(AssigneeOption);
        clickOn(AssigneeOption);
        waitForElementIsInteractable(SelectCollaboratorField);
        clickOn(SelectCollaboratorField);
        waitForElementIsInteractable(CollaboratorsOption);
        clickOn(CollaboratorsOption);
        waitForElementIsInteractable(CreateRulebutton);
        clickOn(CreateRulebutton);
        waitUntilElementInvisibleLocated(CreateRulebutton);
        waitForCurserRunning(2);
        waitUntilElementIsVisible(AddedRule);
        waitUntilElementPresent(AddedRule);
        List<WebElement> RulesCount = driver.findElements(AddedRule);
        SizeAfter = RulesCount.size() >= 1;
    }

    @Test(priority = 4)
    public  void SubmissionAssignment_VerifyAddedRule() throws InterruptedException {
    }

    @Test(priority = 5)
    public  void SubmissionAssignment_EditAddedRule() throws InterruptedException {
        String AssigneeBefore =getTextElement(AssignCaseToColumn);
        System.out.println("After Assignee: " + AssigneeBefore);
        waitUntilElementPresent(EditRuleIcon);
        clickOn(EditRuleIcon);
        waitUntilElementIsVisible(DefaultAssigneeField);
        waitForElementIsInteractable(DefaultAssigneeField);
        clickOn(DefaultAssigneeField);
        waitUntilElementIsVisible(AssigneeOption2);
        waitForElementIsInteractable(AssigneeOption2);
        clickOn(AssigneeOption2);
        waitForElementIsInteractable(SaveButtonEditRule);
        clickOn(SaveButtonEditRule);
        waitUntilElementInvisibleLocated(SaveButtonEditRule);
        waitForCurserRunning(8);
        waitUntilElementIsVisible(AssignCaseToColumn);
        waitUntilElementPresent(AssignCaseToColumn);
        waitUntilElementPresent(DeleteRuleIcon);
        waitForElementIsInteractable(DeleteRuleIcon);
        forcedWaitTime(2);
        String AssigneeAfter =getTextElement(AssignCaseToColumn);
        System.out.println("After Assignee: " + AssigneeAfter);
        CompareStr = AssigneeBefore.equalsIgnoreCase(AssigneeAfter);
    }

    public  void SubmissionAssignment_DeleteAddedRule() throws InterruptedException {
        List<WebElement> RulesCountBefore = driver.findElements(AddedRule);
        int BeforeDeleting = RulesCountBefore.size();
        clickOn(DeleteRuleIcon);
        waitUntilElementPresent(AddedRule);
        List<WebElement> RulesCountAfter = driver.findElements(AddedRule);
        int AfterDeleting = RulesCountAfter.size();
        CompareCount_DeletedRule = (AfterDeleting == BeforeDeleting - 1);
    }

    public  void SubmissionAssignment_AssignmentRuleUnderInactiveSection() throws InterruptedException {
        try{
            waitUntilElementPresent(AddRuleButton);
            waitForElementIsInteractable(AddRuleButton);
            clickByJsExecuter(AddRuleButton);
            waitForElementIsInteractable(CriteriaFields);
            clickOn(CriteriaFields);
            waitForElementIsInteractable(customLocationFieldsTab);
            clickOn(customLocationFieldsTab);
            waitForElementIsInteractable(ZipOption);
            clickOn(ZipOption);
            clickOn(CriteriaFields2);
            waitForElementIsInteractable(EqualsOption);
            clickOn(EqualsOption);
            waitForElementIsInteractable(ValueField);
            sendKeysWithWait(ValueField, "77590");
            clickOn(DefaultAssigneeField);
            waitForElementIsInteractable(AssigneeOption);
            clickOn(AssigneeOption);
            clickOn(SelectCollaboratorField);
            waitForElementIsInteractable(CollaboratorsOption);
            clickOn(CollaboratorsOption);
            clickOn(CreateRulebutton);
            waitUntilElementIsVisible(InactiveToggle);
            waitForElementIsInteractable(InactiveToggle);
            clickByJsExecuter(InactiveToggle);
            clickOn(SaveButton);
            waitUntilElementInvisibleLocated(SaveButton);
            waitForCurserRunning(4);
            waitUntilElementIsVisible(EditAssignmentIcon);
            waitUntilElementPresent(EditAssignmentIcon);
            waitForElementIsInteractable(EditAssignmentIcon);
            clickByJsExecuter(EditAssignmentIcon);
            waitForCurserRunning(4);
            waitUntilElementIsVisible(ActiveToggle);
            waitForElementIsInteractable(ActiveToggle);
            clickOn(ActiveToggle);
            waitForElementIsInteractable(SaveButton);
            clickOn(SaveButton);
            waitUntilElementInvisibleLocated(SaveButton);
            waitForCurserRunning(2);

        }catch (Exception e){
            waitUntilElementPresent(AddRuleButton);
            waitForElementIsInteractable(AddRuleButton);
            clickByJsExecuter(AddRuleButton);
            waitForElementIsInteractable(CriteriaFields);
            clickByJsExecuter(CriteriaFields);
            waitForElementIsInteractable(ZipOption);
            clickByJsExecuter(ZipOption);
            clickByJsExecuter(CriteriaFields);
            waitForElementIsInteractable(EqualsOption);
            clickByJsExecuter(EqualsOption);
            waitForElementIsInteractable(ValueField);
            sendKeysWithWait(ValueField, "77590");
            clickByJsExecuter(DefaultAssigneeField);
            waitForElementIsInteractable(AssigneeOption);
            clickByJsExecuter(AssigneeOption);
            clickByJsExecuter(SelectCollaboratorField);
            waitForElementIsInteractable(CollaboratorsOption);
            clickByJsExecuter(CollaboratorsOption);
            clickByJsExecuter(CreateRulebutton);
            waitUntilElementIsVisible(InactiveToggle);
            waitForElementIsInteractable(InactiveToggle);
            clickByJsExecuter(InactiveToggle);
            clickByJsExecuter(SaveButton);
            waitUntilElementInvisibleLocated(SaveButton);
            waitForCurserRunning(4);
            waitUntilElementIsVisible(EditAssignmentIcon);
            waitUntilElementPresent(EditAssignmentIcon);
            waitForElementIsInteractable(EditAssignmentIcon);
            clickByJsExecuter(EditAssignmentIcon);
            waitForCurserRunning(4);
            waitUntilElementIsVisible(ActiveToggle);
            waitForElementIsInteractable(ActiveToggle);
            clickByJsExecuter(ActiveToggle);
            waitForElementIsInteractable(SaveButton);
            clickByJsExecuter(SaveButton);
            waitUntilElementInvisibleLocated(SaveButton);
            waitForCurserRunning(2);
        }
    }

    public boolean submissionAssingee;
    public void SubmissionAssignmentBaseOnAddedRule() throws InterruptedException{
        waitUntilElementIsVisible(EditAssignmentIcon);
        waitForElementIsInteractable(EditAssignmentIcon);
        clickByJsExecuter(EditAssignmentIcon);
        waitUntilElementInvisibleLocated(EditAssignmentIcon);
        waitUntilElementIsVisible(EditAssignmentPopup);
        waitUntilElementPresent(EditAssignmentPopup);
        Thread.sleep(3000);
        ce.deleteRules(0);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Required", "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Not Required", "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Not Included", "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")){
        	
        	
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Required", "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Not Required", "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Not Included", "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else {
        ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Required", "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));
        ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Not Required", "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));
        ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Location Not Included", "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));

        }
        waitForElementIsInteractable(SaveButton);
        clickOn(SaveButton);
        waitUntilElementInvisibleLocated(SaveButton);
        waitForCurserRunning(5);
        crm.createSubmissionPreRequisite("No", "Yes", "Yes", "Yes", "Yes", "Location Required");
        //crm.createSubmission("No", "Yes", "Yes", "Yes", "Yes", "Location Required");
        waitForCurserRunning(10);
        forcedWaitTime(3);
        waitUntilElementIsVisible(SubmissionAssingee);
        String Assingee =getTextElement(SubmissionAssingee);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")){
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Mark Shane") ;
        }
        else if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("production")) {
        	  assert Assingee != null;
              submissionAssingee = Assingee.equalsIgnoreCase("Amandeep") ;
        }
        else{
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Shane ES") ;
        }
    }

    public void SubmissionAssignmentBaseOnAddedRuleWithDeptCategory() throws InterruptedException{
        waitUntilElementIsVisible(EditAssignmentIcon);
        waitForElementIsInteractable(EditAssignmentIcon);
        clickByJsExecuter(EditAssignmentIcon);
        waitUntilElementInvisibleLocated(EditAssignmentIcon);
        waitUntilElementIsVisible(EditAssignmentPopup);
        waitUntilElementPresent(EditAssignmentPopup);
        Thread.sleep(3000);
        ce.deleteRules(0);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Dept Category", "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")){


            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Dept Category", "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else {
            ce.addSubmissionAssignmentRule("Submission Category", "Equals", "Dept Category", "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));

        }
        waitForElementIsInteractable(SaveButton);
        clickOn(SaveButton);
        waitUntilElementInvisibleLocated(SaveButton);
        waitForCurserRunning(5);
        crm.createSubmissionPreRequisite("No", "Yes", "Yes", "Yes", "Yes", "Dept Category");
        //crm.createSubmission("No", "Yes", "Yes", "Yes", "Yes", "Location Required");
        waitForCurserRunning(10);
        forcedWaitTime(3);
        waitUntilElementIsVisible(SubmissionAssingee);
        String Assingee =getTextElement(SubmissionAssingee);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")){
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Mark Shane") ;
        }
        else if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("production")) {
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Amandeep") ;
        }
        else{
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Shane ES") ;
        }
    }


    public void SubmissionAssignmentBaseOnAddedRule(String categoryName , String operator , String value  ) throws InterruptedException{
        waitUntilElementIsVisible(EditAssignmentIcon);
        waitForElementIsInteractable(EditAssignmentIcon);
        clickByJsExecuter(EditAssignmentIcon);
        waitUntilElementInvisibleLocated(EditAssignmentIcon);
        waitUntilElementIsVisible(EditAssignmentPopup);
        waitUntilElementPresent(EditAssignmentPopup);
        Thread.sleep(3000);
        ce.deleteRules(0);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
            ce.addSubmissionAssignmentRule(categoryName, operator, value, "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addSubmissionAssignmentRule(categoryName, operator, value, "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")){


            ce.addSubmissionAssignmentRule(categoryName, operator, value, "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addSubmissionAssignmentRule(categoryName, operator, value, "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else {
            ce.addSubmissionAssignmentRule(categoryName, operator, value, "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addSubmissionAssignmentRule(categoryName, operator, value, "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));

        }
        waitForElementIsInteractable(SaveButton);
        clickOn(SaveButton);
        waitUntilElementInvisibleLocated(SaveButton);
        waitForCurserRunning(5);
        //crm.createSubmission("No", "Yes", "Yes", "Yes", "Yes", "Location Required");
        waitForCurserRunning(10);
        forcedWaitTime(3);
        waitUntilElementIsVisible(SubmissionAssingee);
        String Assingee =getTextElement(SubmissionAssingee);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")){
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Mark Shane") ;
        }
        else if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("production")) {
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Amandeep") ;
        }
        else{
            assert Assingee != null;
            submissionAssingee = Assingee.equalsIgnoreCase("Shane ES") ;
        }
    }


    public  boolean CaseAssingee;
    public  void CaseAssignmentBaseOnAddedRule() throws InterruptedException{
        int CancelSubmission = driver.findElements(CloseSubmissionIcon).size();
        if (CancelSubmission > 0) {
            scrollIntoView(CloseSubmissionIcon);
            clickByJsExecuter(CloseSubmissionIcon);

        }
        waitForCurserRunning(5);
        waitUntilElementIsVisible(EditCaseAssingment);
        waitForElementIsInteractable(EditCaseAssingment);
        clickByJsExecuter(EditCaseAssingment);
        waitUntilElementInvisibleLocated(EditCaseAssingment);
        waitUntilElementIsVisible(EditAssignmentPopup);
        waitUntilElementPresent(EditAssignmentPopup);

        ce.deleteRules(0);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
            ce.addCaseAssignmentRule("Case Violation", "Contains", "Water", "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
        	 ce.addCaseAssignmentRule("Case Violation", "Contains", "Water", "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else{
//            ce.addCaseAssignmentRule("Case Violation", "Contains", "Water 01", "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addCaseAssignmentRule("Case Violation", "Contains", "Water", "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));

        }
        String caseAssignee =getTextElement(By.xpath("(//div[@class='sortable-table__body__tr']//div)[2]"));
        waitForElementIsInteractable(SaveButton);
        clickOn(SaveButton);
        waitUntilElementInvisibleLocated(SaveButton);
        waitForCurserRunning(6);
        ce.createCaseCCP();
        waitForCurserRunning(10);
        forcedWaitTime(3);
        waitUntilElementIsVisible(Assignee);
        String Assingee =getTextElement(Assignee);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
            assert Assingee != null;
            CaseAssingee = Assingee.equalsIgnoreCase("Mark Shane");
        }
        else if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("production")) {
      	  assert Assingee != null;
      	CaseAssingee = Assingee.equalsIgnoreCase("Amandeep") ;
      }
        else{
            assert Assingee != null;
            CaseAssingee = Assingee.equalsIgnoreCase("Shane ES");
        }

    }

    public  void CaseAssignmentBaseOnAddedRule(String categoryName , String operator , String value  ) throws InterruptedException{
        int CancelSubmission = driver.findElements(CloseSubmissionIcon).size();
        if (CancelSubmission > 0) {
            scrollIntoView(CloseSubmissionIcon);
            clickByJsExecuter(CloseSubmissionIcon);

        }
        waitForCurserRunning(5);
        waitUntilElementIsVisible(EditCaseAssingment);
        waitForElementIsInteractable(EditCaseAssingment);
        clickByJsExecuter(EditCaseAssingment);
        waitUntilElementInvisibleLocated(EditCaseAssingment);
        waitUntilElementIsVisible(EditAssignmentPopup);
        waitUntilElementPresent(EditAssignmentPopup);

        clickOn(customCategoryFieldTab);

        ce.deleteRules(0);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
            ce.addCaseAssignmentRule(categoryName, operator, value, "Mark Shane", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
            ce.addCaseAssignmentRule(categoryName, operator, value, "Amandeep", PropertiesUtils.getPropertyValue("crmCustomerName"));
        }
        else{
//            ce.addCaseAssignmentRule("Case Violation", "Contains", "Water 01", "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));
            ce.addCaseAssignmentRule(categoryName, operator, value, "Shane ES", PropertiesUtils.getPropertyValue("crmCustomerName"));

        }
        String caseAssignee =getTextElement(By.xpath("(//div[@class='sortable-table__body__tr']//div)[2]"));
        waitForElementIsInteractable(SaveButton);
        clickOn(SaveButton);
        waitUntilElementInvisibleLocated(SaveButton);
        waitForCurserRunning(6);
        ce.createCaseCCP();
        waitForCurserRunning(10);
        forcedWaitTime(3);
        waitUntilElementIsVisible(Assignee);
        String Assingee =getTextElement(Assignee);
        if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
            assert Assingee != null;
            CaseAssingee = Assingee.equalsIgnoreCase("Mark Shane");
        }
        else if(BrowsersInvoked.RunEnvironment.equalsIgnoreCase("production")) {
            assert Assingee != null;
            CaseAssingee = Assingee.equalsIgnoreCase("Amandeep") ;
        }
        else{
            assert Assingee != null;
            CaseAssingee = Assingee.equalsIgnoreCase("Shane ES");
        }

    }


}
