package POM;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import static POM.CitationUtility.ActiveViolationCount;

public class Department extends Helper {

    CRMCommonMethods crmCommonMethods;
    Helper helper;

    public static String categoriesTab = "//div[@class='tab-name tab-name--active']";
    public static String otherDefaultCategory = "//div[@class='sortable-table__body__td' and text()='Other']";
    public static String editDefaultLink = "a#edit-default-resolution";
    public static String resolutionTimePopup = "//div[@class='modal-header']";
    public static String resolutionTimeField = "//input[@name='resolveByDays']";
    public static String saveButton = "//button[text()='Save']";
    public static String cancelButton = "//button[text()='Cancel']";
    public static String defaultResolutionTime = "//span[@class='default-resolve-by-days']";
    public static String editCategoryIcon = "//button[@class='edit-btn space-right btn btn-primary']";
    public static String editOtherPopup = "//div[@class='full-page-modal__header']/h1";
    public static String validationMsgResolutionTime = "//span[@class='field__error']";
    public static String createCategoryButton = "//button[text()='Create Category']";
    public static String createACategoryPopup = "//div[@class='full-page-modal__header']/h1";
    public static String resolutionTime = "//span[@class='default-resolve-by-days']";
    public static String createCategoryPopupBtn = "//div[@class='full-page-modal__header']//following::button[text()='Create Category']";
    public static String validationMsgNameField = "(//span[@class='field__error'])[1]";
    public static String resolutionTimeOnCategoryPopup = "//input[@name='resolveByDays']";
    public static String keywordsField = "//input[@name='tags-input']";
    public static String addedKeywords = "//div[@class='chip__body']";
    public static String deleteIconKeyword = "//button[@class='chip__close-button']";
    public static String addFieldLink = "//a[text()='Add Field']";
    public static String addedFields = "//div[@class='category-modal__custom-fields']//li";
    public static String labelValidationMsg = "//div[@class='category-modal__custom-field']//span";
    public static String labelField = "//input[@name='label']";
    public static By labelField2 = By.xpath("(//input[@name='label'])[2]");
    public static String dropdownLinkEmail = "//span[@class='dropdown__arrow']";
    public static String emailTemplatesOptions = "//div[@id='templateIds']//label";
    public static String templatesCancelButton = "//div[@class='flex-row--center dropdown__actions']/button[1]";
    public static String templatesSaveButton = "//div[@class='flex-row--center dropdown__actions']/button[2]";
    public static String labelSelect = "//div[@class='dropdown__selector__selected']/label";
    public static String selectedTemplates = "//div[@class='dropdown__selector__selected']/label";
    public static String nameField = "//input[@name='name']";
    //	    public static String categoriesCountHeader = "//div[@class='agency-setup-tab__section__header']/h2";
    public static String categoriesCountHeader = "(//div[@class='agency-setup-tab__section__header']/h2)[1]";
    public static String addedCategories = "//li[@class='sortable__element']";
    public static String notificationMsg = "//div[@class='notification-message']";
    public static String editCategoryIcon2 = "(//button[@class='edit-btn space-right btn btn-primary'])[2]";
    public static String inactiveToggle = "//button[text()='Inactive']";
    public static String inactiveCategoriesCount = "(//div[@class='agency-setup-tab__section__header']/h2)[2]";
    public static String inactiveAddedCategories = "//div[@class='rt-tr-group']";
    public static String actualCategoriesCount = "//div[@class='sortable-table__body__tr']";
    public static String locationRequiredCheckbox = "//label[text()='Location Required']";
    public static String noLocationToggle = "//button[text()='No']";
    public static By CategoriesTab = By.xpath(categoriesTab);
    public static By OtherDefaultCategory = By.xpath(otherDefaultCategory);
    public static By EditDefaultLink = By.cssSelector(editDefaultLink);
    public static By ResolutionTimePopup = By.xpath(resolutionTimePopup);
    public static By ResolutionTimeField = By.xpath(resolutionTimeField);
    public static By SaveButton = By.xpath(saveButton);
    public static By CancelButton = By.xpath(cancelButton);
    public static By DefaultResolutionTime = By.xpath(defaultResolutionTime);
    public static By EditCategoryIcon = By.xpath(editCategoryIcon);
    public static By EditOtherPopup = By.xpath(editOtherPopup);
    public static By ValidationMsgResolutionTime = By.xpath(validationMsgResolutionTime);
    public static By ResolutionTime = By.xpath(resolutionTime);
    public static By CreateCategoryButton = By.xpath(createCategoryButton);
    public static By CreateACategoryPopup = By.xpath(createACategoryPopup);
    public static By CreateCategoryPopupBtn = By.xpath(createCategoryPopupBtn);
    public static By ValidationMsgNameField = By.xpath(validationMsgNameField);
    public static By ResolutionTimeOnCategoryPopup = By.xpath(resolutionTimeOnCategoryPopup);
    public static By KeywordsField = By.xpath(keywordsField);
    public static By AddedKeywords = By.xpath(addedKeywords);
    public static By DeleteIconKeyword = By.xpath(deleteIconKeyword);
    public static By AddFieldLink = By.xpath(addFieldLink);
    public static By AddedFields = By.xpath(addedFields);
    public static By LabelValidationMsg = By.xpath(labelValidationMsg);
    public static By LabelField = By.xpath(labelField);
    public static By DropdownLinkEmail = By.xpath(dropdownLinkEmail);
    public static By EmailTemplatesOptions = By.xpath(emailTemplatesOptions);
    public static By TemplatesCancelButton = By.xpath(templatesCancelButton);
    public static By TemplatesSaveButton = By.xpath(templatesSaveButton);
    public static By LabelSelect = By.xpath(labelSelect);
    public static By SelectedTemplates = By.xpath(selectedTemplates);
    public static By NameField = By.xpath(nameField);
    public static By CategoriesCountHeader = By.xpath(categoriesCountHeader);
    public static By AddedCategories = By.xpath(addedCategories);
    public static By NotificationMsg = By.xpath(notificationMsg);
    public static By EditCategoryIcon2 = By.xpath(editCategoryIcon2);
    public static By InactiveToggle = By.xpath(inactiveToggle);
    public static By InactiveCategoriesCount = By.xpath(inactiveCategoriesCount);
    public static By ActualCategoriesCount = By.xpath(actualCategoriesCount);
    public static By LocationRequiredCheckbox = By.xpath(locationRequiredCheckbox);
    public static By NoLocationToggle = By.xpath(noLocationToggle);
    public static String RandomCategoryname = RandomStrings.requiredCharacters(4);
    public static String NewResoTime;
    public static int CategoriesCountBefore;
    public static String TabTitle;
    public static String OtherTabTitle;
    public static String EditOtherPopupTitle;
    public static String EditResolutionPopupTitle;
    public static String ResolutionTimeValidationMsg;
    public static String[] ResoTextAfter;
    public static String CreateCategoryPopupTitle;
    public static String NameFieldValidationMsg;
    public static String ResoTimeOnPopup;
    public static String LabelFieldValidationMsg;
    public static String LabelText;
    public static String CheckedTemplate;
    public static String SelectedTemplate;
    public static String NotificationText;
    public static int KeywordsSizeBefore;
    public static int KeywordsSizeAfter;
    public static int FieldsCount;
    public static int CategoriesCountAfter1;
    public static int CategoriesCountAfter2;
    public static int CategoriesCountAfter3;
    public static int InactiveCountAfter;
    public static int InactiveCountBefore;
    public static int CategoriesCountHeader1;
    public static int CountCategoriesActual;
    public static By addFieldCustomField = By.xpath("((//div[@class='category-modal__custom-fields'])//a)[1]");
    public static By addSecondayCustomField = By.xpath("//a[normalize-space()='Add Secondary Custom Field']");
    public static By secondaryCustomFieldsSection = By.xpath("//h5[normalize-space()='Secondary Custom Fields (1)']");
    public static By labelCustomFields = By.xpath("(//label[@title='Label'])[2]");
    public static By requiredCustomFields = By.xpath("(//label[@title='Required?'])[2]");
    public static By statusCustomFields = By.xpath("(//label[@title='Status'])[3]");
    public static By typeCustomFields = By.xpath("(//label[@title='Type'])[2]");
    public static By secondaryCustomField2 = By.xpath("//h5[normalize-space()='Secondary Custom Fields (2)']");
    public static By labelSecondaryCustomFields2 = By.xpath("(//label[@title='Label'])[3]");
    public static By requiredSecondaryCustomFields2 = By.xpath("(//label[@title='Required?'])[3]");
    public static By statusSecondaryCustomFields2 = By.xpath("(//label[@title='Status'])[4]");
    public static By typeSecondaryCustomFields2 = By.xpath("(//label[@title='Type'])[3]");
    public static By closeButtonSecondaryCustomField = By.xpath("//div[@class='parent-of-subcategory']//div[@class='button-right-align']//button");
    public static By labelFieldValidationMessage = By.xpath("(//span[contains(@class,'field__error')][normalize-space()='The Label is required.'])[1]");
    public static By primaryQuestionValidationMessage = By.xpath("(//span[normalize-space()='Picklist type should have options'])[1]");
    public static By primaryQuestionLabelTextValidationMessage = By.xpath("(//span[contains(@class,'field__error')][normalize-space()='The Label is required.'])[2]");
    public static By labelFieldValidationMessageSecondaryCustom = By.xpath("(//span[contains(@class,'field__error')][normalize-space()='The Label is required.'])[3]");
    public static By typeDropdown = By.xpath("//div[contains(@class,'Select-value')]");
    public static By numberDropDownType = By.xpath("//div[contains(@aria-label,'Number')]");
    public static By primaryOptionsDropdown = By.xpath("((//div[contains(text(),'Select Option')])[2])//..");
    public static By containsDropdownTxt = By.xpath("//div[text()='Contains']");
    public static By nameFieldSeondaryCustom = By.xpath("(//input[@name='name'])[2]");
    public static By labelFieldSecondaryCustomField = By.xpath("(//input[@name='label'])[2]");
    public static By labelFieldSecondaryCustomField3 = By.xpath("(//input[@name='label'])[3]");
    public static String lastRowCountCategory = "((//li[@class='sortable__element'])[%s])//div[@class='sortable-table__body__td'][1]";
    public static String editCategorysIcon = "(//button[@class='edit-btn space-right btn btn-primary'])[%s]";
    public static By labelFieldSecondaryCustomField4 = By.xpath("(//input[@name='label'])[4]");
    public static By equalsDropdownTxt = By.xpath("//div[text()='Equals']");
    public static By labelFieldSecondaryCustomField5 = By.xpath("(//input[@name='label'])[5]");
    public static By nameFieldSeondaryCustom3 = By.xpath("(//input[@name='name'])[3]");
    public static By addSecondayCustomField2 = By.xpath("(//a[normalize-space()='Add Secondary Custom Field'])[2]");
    public static By requiredYesToggle = By.xpath("(//div[@class='field__input row']//button[text()='Yes'])[3]");
    public static By requiredNoToggle = By.xpath("(//div[@class='field__input row']//button[text()='No'])[3]");
    public static By createSubmissionButton = By.xpath("//button[text()='Create Submission']");
    public static String categoryValidationMessageCSP = "//span[normalize-space()='%s']";
    public static By dropdownCategoryCSPExternal = By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']");
    public static By searchCategoryCSPExternal = By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']");
   public static String dropDownOptionCategory = ("//div[@class='option-black'][contains(text(),'%s')]");
    public static By issueDescriptionField = By.xpath("//textarea[@name='description']");
    public static By categorySecondaryFieldText = By.xpath("//input[@type='TEXT']");
    public static By categoryCSP = By.xpath("//input[@type='NUMBER']");
    public static By enterTextCategory1CSP= By.xpath("(//input[@placeholder='Enter Text'])[5]");
    public static By enterTextCategory2CSP= By.xpath("(//input[@placeholder='Enter Text'])[7]");
    public static String breedCategoryfieldCSP = "(//label[text()='%s'])";
    public static By requiredSecondaryCustomFields =By.xpath("(//div[@class='field__input row']//button[text()='Yes'])[4]");
    public static By requiredSecondaryCategoryCustomFields2 =By.xpath("(//div[@class='field__input row']//button[text()='Yes'])[6]");
    public static By breedTextCustomField= By.xpath("(//input[@placeholder='Enter Text'])[6]");
    public static By breed2TextCustomField= By.xpath("(//input[@placeholder='Enter Text'])[8]");
    public static By enterTextCategory1CSPExternal= By.xpath("(//input[@placeholder='Enter Text'])[1]");
    public static By enterTextCategory2CSPExternal= By.xpath("(//input[@placeholder='Enter Text'])[3]");
    public static By breedTextCustomFieldCSPExternal= By.xpath("(//input[@placeholder='Enter Text'])[2]");
    public static By breed2TextCustomFieldCSPExternal= By.xpath("(//input[@placeholder='Enter Text'])[4]");
    public static By hypenTextForCascadinField2 = By.xpath("(//div[@class='field-div'])[3]//div//span");
    public static By cascadingLabelValueOnCSDP = By.xpath("(//div[@class='field-div'])[1]//div//span");
    public static By cascadingSubFieldLabelValueOnCSDP = By.xpath("(//div[@class='field-div'])[2]//div//span");
   public static By inactiveButton = By.xpath("(//button[text()='Inactive'])[1]");
    public static By activeButton = By.xpath("(//button[text()='Active'])[1]");


   public static By createDepartmentButton = By.xpath("//button[text()='Create Department']");
   public static By createDepartmentButtonPopup = By.xpath("(//button[text()='Create Department'])[2]");
    public static By departmentHeader = By.xpath("//div[@class='full-page-modal__header']//h1");

    public static By nameValidationMessage = By.xpath("//span[@class='field__error']");
    public static By departmentTab = By.xpath("//label[text()='Departments']");
    public static By  departmentUsers = By.xpath("//div[@class='tile-empty-msg']");
    public static By  nameField2  = By.xpath("//input[@placeholder='Enter Text']");
    public static String departmentName = "//div[text()='%s']";
    public static By selectDepartment = By.xpath("//span[@class='Select-arrow-zone']");
    public static String selectDepartmentValue = "//div[text()='%s']";
    public static By customerSubmissionHeader = By.xpath("//h2[@class='customer-submission-details__number']");
    public static By departmentLabelCSDP = By.xpath("((//div[@class='field-section']//label[text()='Department'])//..)//label[@class='field__label-data-field']");
   public static By departmentCheckBoxCSLP= By.xpath("//label[@for='checkbox-departmentIds']");
   public static String departmentColumnCSLP = "(//a[text()='%s']//..//..)//div[13]";
    public static int activeCount;
    public WebDriver driver;
    LoginUtility log;

    public Department(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
    }

    public void LoginAgency() throws InterruptedException {
        log.LoginAgency();

    }

    public void naviateToCategory() throws InterruptedException {
        driver.navigate().to(BrowsersInvoked.URLCategories);
        waitForCurserRunning(5);
    }

    public void createDepartment() throws InterruptedException {
        crmCommonMethods.navigateToAgencySetup();
        helper.clickOn(departmentTab);
        waitUntilElementIsVisible(createDepartmentButton);
        waitForElementIsInteractable(createDepartmentButton);
        helper.clickOn(createDepartmentButton);
        waitUntilElementIsVisible(LabelField);
        waitForElementIsInteractable(LabelField);
        helper.sendKeysWithWait(LabelField,"Test Dept");
        helper.clickOn(createDepartmentButtonPopup);
        wait(2000);
        waitUntilElementIsVisible(createDepartmentButton);
        waitForElementIsInteractable(createDepartmentButton);
        helper.clickOn(createDepartmentButton);
        waitUntilElementIsVisible(LabelField);
        waitForElementIsInteractable(LabelField);
        helper.sendKeysWithWait(LabelField,"Test Dept1");
        helper.clickOn(createDepartmentButtonPopup);

    }



    public String getCategoryTabName() {
        waitUntilElementIsVisible(CategoriesTab);
        waitUntilElementPresent(CategoriesTab);
        String tabName = getTextElement(CategoriesTab);
        return tabName;
    }

    public String getOtherDefaultCategory() throws InterruptedException {
        forcedWaitTime(1);
        waitUntilElementIsVisible(OtherDefaultCategory);
        waitUntilElementPresent(OtherDefaultCategory);
        String defaultCategory = getTextElement(OtherDefaultCategory);
        return defaultCategory;
    }

    public void clickOnEditCategoryIcon() {
        scrollToRight();
        waitUntilElementPresent(EditCategoryIcon);
        waitForElementIsInteractable(EditCategoryIcon);
        clickByJsExecuter(EditCategoryIcon);
        waitUntilElementIsVisible(EditOtherPopup);

    }

    public String getEditCategoryPopupTitle() {
        waitUntilElementPresent(EditOtherPopup);
        String title = getTextElement(EditOtherPopup);
        return title;
    }

    public void closeTheEditCategoryPopup() {
        waitUntilElementIsVisible(CancelButton);
        waitForElementIsInteractable(CancelButton);
        clickByJsExecuter(CancelButton);
        waitUntilElementInvisibleLocated(CancelButton);
    }

    public int getResolutionTime() {
        waitUntilElementIsVisible(ResolutionTime);
        waitUntilElementPresent(ResolutionTime);
        String[] ResoTextBefore = getTextElement(ResolutionTime).split(" ");
        int resolutionTime = Integer.parseInt(ResoTextBefore[0]);
        return resolutionTime;
    }

    public void clickOnEditDefalutResoTime() {
        waitForElementIsInteractable(EditDefaultLink);
        moveToElement(EditDefaultLink);
        clickByJsExecuter(EditDefaultLink);
    }

    public String getEditResolutionPopupTitle() {
        waitUntilElementIsVisible(ResolutionTimePopup);
        waitUntilElementPresent(ResolutionTimePopup);
        String title = getTextElement(ResolutionTimePopup);
        return title;
    }

    public void clearResoTimeField() {
        waitForElementIsInteractable(ResolutionTimeField);
        WebElement ResolutionField = driver.findElement(ResolutionTimeField);
        ResolutionField.clear();
    }

    public String setResolutionTime(String time) {
        WebElement ResolutionField = driver.findElement(ResolutionTimeField);
        ResolutionField.sendKeys(time);
        return time;
    }

    public void clickOnSaveButton() throws InterruptedException {
        waitForElementIsInteractable(SaveButton);
        clickByJsExecuter(SaveButton);
        waitUntilElementInvisibleLocated(SaveButton);
        waitForCurserRunning(5);
    }

    public int getCategoryCount() {
        String[] HeaderCount = getTextElement(CategoriesCountHeader).split(" ");
        int count = Integer.parseInt(HeaderCount[0]);
        return count;
    }

    public void clickOnCreateCategoryBtn() throws InterruptedException {
        waitForElementIsInteractable(CreateCategoryButton);
        clickByJsExecuter(CreateCategoryButton);
        waitForCurserRunning(2);
    }

    public String getCreateCategoryTitle() {
        waitUntilElementIsVisible(CreateACategoryPopup);
        waitForElementIsInteractable(CreateACategoryPopup);
        String title = getTextElement(CreateACategoryPopup);
        return title;
    }

    public void clickOnCreateCategoryPopbtn() {
        clickByJsExecuter(CreateCategoryPopupBtn);

    }

    public String getCategoryNameValidationText() {
        String text = getTextElement(ValidationMsgNameField);
        return text;
    }

    public String ResolutionTimeOnCategoryPopup() {
        String ResoTimeOnPopup = driver.findElement(ResolutionTimeOnCategoryPopup).getAttribute("value");
        return ResoTimeOnPopup;
    }

    public void addCategoryKeywords(int count) {
        waitUntilElementIsVisible(KeywordsField);
        waitUntilElementPresent(KeywordsField);
        WebElement AddKeywordsField = findElement(KeywordsField);
        for (int i = 0; i < count; i++) {
            String RandomKeyword = RandomStrings.requiredCharacters(4);
            AddKeywordsField.sendKeys(RandomKeyword);
            AddKeywordsField.sendKeys(Keys.SPACE);
        }
    }

    public void deleteAddedkeywords(int count) throws InterruptedException {
        waitUntilElementIsVisible(AddedKeywords);
        waitUntilElementPresent(AddedKeywords);
        List<WebElement> KeywordsAdded = driver.findElements(AddedKeywords);
        for (int i = 0; i < count; i++) {
            forcedWaitTime(1);
            clickOn(DeleteIconKeyword);
        }
    }

    public int getAddedKeywordCount() {

        waitUntilElementIsVisible(AddedKeywords);
        List<WebElement> KeywordsAfterDeletion = driver.findElements(AddedKeywords);
        int count = KeywordsAfterDeletion.size();
        return count;
    }

    public void clickOnAddFieldLink() throws InterruptedException {
        clickOn(AddFieldLink);
    }

    public int getAddedFieldCount() {
        List<WebElement> FieldsAdded = driver.findElements(AddedFields);
        int fieldCount = FieldsAdded.size();
        return fieldCount;
    }

    public String getCatLabelValidationText() {
        String text = getTextElement(LabelValidationMsg);
        return text;
    }

    public void setCategoryLabelText() {
        sendKeysWithWait(LabelField, "TextLabel");
    }

    public void clickOnDropdownLinkemail() throws InterruptedException {
        waitUntilElementPresent(DropdownLinkEmail);
        waitForElementIsInteractable(DropdownLinkEmail);
        clickOn(DropdownLinkEmail);
    }

    public void selectEmailTemplateOption() throws InterruptedException {
        waitForElementIsInteractable(EmailTemplatesOptions);
        clickOn(EmailTemplatesOptions);
    }

    public void clickOnTemplateCancelBtn() throws InterruptedException {
        waitForElementIsInteractable(TemplatesCancelButton);
        clickOn(TemplatesCancelButton);

    }

    public String getLabelText() {
        waitUntilElementIsVisible(LabelSelect);
        String text = getTextElement(LabelSelect);
        return text;
    }

    public String getTextEmailTemplateOption() {
        waitUntilElementIsVisible(EmailTemplatesOptions);
        String text = getTextElement(EmailTemplatesOptions);
        return text;
    }

    public void clickOnTemplateSaveBtn() {
        waitForElementIsInteractable(TemplatesSaveButton);
        scrollIntoView(TemplatesSaveButton);
        clickByJsExecuter(TemplatesSaveButton);
    }

    public String getSelectedTemplate() {
        waitUntilElementIsVisible(SelectedTemplates);
        String text = getTextElement(SelectedTemplates);
        return text;
    }

    public String setCategoryName() {
        String RandomCN = RandomStrings.requiredCharacters(5);
        String categoryName = "Category " + RandomCN;
        sendKeysWithWait(NameField, RandomCategoryname);
        return categoryName;
    }

    public String setCategoryNameCustom(String name) {
        sendKeysWithWait(NameField, name);
        return name;
    }

    public void waitForButtonInvisibility() throws InterruptedException {
        waitUntilElementInvisibleLocated(CreateCategoryPopupBtn);
        waitForCurserRunning(5);

    }

    public int getCategoryCountHeader() {
        waitUntilElementIsVisible(CategoriesCountHeader);
        waitUntilElementPresent(CategoriesCountHeader);
        String[] HeaderCount = getTextElement(CategoriesCountHeader).split(" ");
        int count = Integer.parseInt(HeaderCount[0]);
        return count;
    }

    public void clickOnCreateCategorybutton() throws InterruptedException {
        waitUntilElementIsVisible(CreateCategoryButton);
        waitUntilElementPresent(CreateCategoryButton);
        waitForElementIsInteractable(CreateCategoryButton);
        clickOn(CreateCategoryButton);
    }

    public String getExistingCatValidationText() {
        waitUntilElementIsVisible(NotificationMsg);
        String text = getTextElement(NotificationMsg);
        return text;
    }

    public int getInactiveCategoryCount() {
        waitUntilElementIsVisible(InactiveCategoriesCount);
        waitUntilElementPresent(InactiveCategoriesCount);
        String[] InactiveCountHeader = getTextElement(InactiveCategoriesCount).split(" ");
        int count = Integer.parseInt(InactiveCountHeader[0]);
        return count;
    }

    public void clicOnEditCategoryActive() throws InterruptedException {
        waitForElementIsInteractable(EditCategoryIcon2);
        clickOn(EditCategoryIcon2);
        forcedWaitTime(4);
    }

    public void clickOnInactiveToggleButton() throws InterruptedException {
        waitUntilElementIsVisible(InactiveToggle);
        waitUntilElementPresent(InactiveToggle);
        waitForElementIsInteractable(InactiveToggle);
        clickByJsExecuter(InactiveToggle);
        forcedWaitTime(2);
    }

    public void clearCategoryName() {
        WebElement NameFld = waitUntilVisibleWE(NameField);
        NameFld.clear();
    }

    public int getCountFormGrid() {

        List<WebElement> ActualCountCategories = driver.findElements(ActualCategoriesCount);
        int count = ActualCountCategories.size();
        return count;
    }

    public String selectorFormate(String Selector, String... values) {
        return String.format(Selector, values);

    }

    public int getActiveHeaderCount() throws InterruptedException {
        forcedWaitTime(4);
        activeCount = Integer.parseInt(getTextElement(ActiveViolationCount).split(" ")[0]);
        return activeCount;
    }


}
