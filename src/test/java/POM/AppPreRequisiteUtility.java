package POM;

import BrowsersBase.BrowsersInvoked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;

import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;

import static POM.Department.*;

public class AppPreRequisiteUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;
	Helper helper;
	CECommonMethods ceCommonMethod;
	CreateCRMUserUtility createCRMUser;
	UserManagementUtility umUtils;
	Department department;

	public AppPreRequisiteUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
		ceCommonMethod = new CECommonMethods(driver);
		createCRMUser = new CreateCRMUserUtility(driver);
		umUtils = new UserManagementUtility(driver);

	}
	public static By ceTabOnAgenctSetupPage= By.xpath("//label[text()='CE']");
	public static By categoriesPage = By.xpath("//label[text()='Categories']");
	public static By assignmentRules = By.xpath("//label[text()='Assignment Rules']");
	public static By violationsTabOnAgencySetup=By.xpath("//label[text()='Violations']");
	public static By securedLocationSetting= By.xpath("//div[text()='Secured Location Settings']");
	public static By locationAndMapsTab= By.xpath("//label[text()='Location and Maps']");

	public static By AppMenuIcon = By.xpath("//div[@class='app-header__menu__icon']");
	public static By financeMenu = By.xpath("//div//label[text()='Finance']");
	public static By AgencySetupIcon = By
			.xpath("//a[@class='tools-dropdown__tool-img tools-dropdown__tool-img--setup']");
	public static By AgencySetUpIconLbl = By.xpath("//label[text()='Agency Setup']//preceding-sibling::a");
	public static By LocationManagementTab = By.xpath("//label[text()='Location Management']");
	
//	public static By securedLocationSetting= By.xpath("//div[text()='Secured Location Settings']");
//	public static By locationAndMapsTab= By.xpath("//label[text()='Location and Maps']");
//
	public static By contactsTab = By.xpath("//div[@class='sidebar__options-container'] //label[text()='Contacts']");
	public static By LocationandMapsTab = By.xpath("//label[text()='Location and Maps']");
	public static By FieldMappingTab = By.xpath("//label[text()='Field Mapping']");
	public static By CheckMappingInput = By.xpath("//input[@name='address'][@type='TEXT']");
	public static By MappedStreetName = By.xpath("(//input[@name='mappedValue'])[3]");
	public static By MappedStreetNum = By.xpath("(//input[@name='mappedValue'])[2]");
	public static By MappedOwnerStreeNum = By.xpath("(//input[@name='mappedValue'])[8]");
	public static By MappedOwnerStreeName = By.xpath("(//input[@name='mappedValue'])[9]");
	public static By MappedCity = By.xpath("//td[contains(text(),'CITY*')]//following-sibling::td//input");
	public static By MappedState = By.xpath("//td[contains(text(),'STATE*')]//following-sibling::td//input");
	public static By MappedZip = By.xpath("//td[contains(text(),'ZIP*')]//following-sibling::td//input");
	public static By MappedSecUnitNo = By
			.xpath("(//td[contains(text(),'SECONDARY UNIT NUMBER')]//following-sibling::td//input)[1]");
	public static By MappedAPN = By.xpath("(//td[contains(text(),'APN')]//following-sibling::td//input)[1]");
	public static By MappedOwnerName = By
			.xpath("(//td[contains(text(),'OWNER NAME')]//following-sibling::td//input)[1]");
	public static By MappedOwnerStreetNum = By
			.xpath("(//td[contains(text(),'STREET NUMBER')]//following-sibling::td//input)[2]");
	public static By MappedOwnerStreetName = By
			.xpath("(//td[contains(text(),'STREET NAME')]//following-sibling::td//input)[2]");
	public static By MappedOwnerCity = By.xpath("(//td[contains(text(),'CITY')]//following-sibling::td//input)[2]");
	public static By MappedOwnerState = By.xpath("(//td[contains(text(),'STATE')]//following-sibling::td//input)[2]");
	public static By MappedOwnerZip = By.xpath("(//td[contains(text(),'ZIP')]//following-sibling::td//input)[2]");

	public static By CheckMappingSaveBtn = By.xpath("//button[contains(text(),'Check Mapping and Save')]");
	public static By parcelLayerTab = By.xpath("//div[contains(text(),'Parcel Layer Mappings')]");
	public static By LCFTab = By.xpath("//div[text()='Location Custom Fields']");
	public static By CreateCustomFieldButton = By.xpath("//button[text()='Create Custom Field']");
	public static By OpenedPopupsTitle = By.xpath("//div[@class='modal-header']");
	public static By NameFieldLCF = By.xpath("//input[@name='label']");
	public static By TypeDropdownField = By.xpath("//div[@class='Select-placeholder']");
	public static By CreateCustomFieldButton2 = By.xpath("//div[@class='modal-footer']//button[2]");
	public static By MapLayersTab = By.xpath("//div[text()='Map Layers']");
	public static By UploadMapLayerButton = By.xpath("//button[text()='Upload Map Layer']");
	public static By LabelField = By.xpath("//input[@name='label']");
	public static By ReplaceFile = By.xpath("//label[@for='file-upload__kml'][@class='file-upload__label']");
	public static By UploadFileLink = By.xpath("//label[@for='file-upload__kml']");
	public static By UploadFileInput = By.xpath("//input[@id='file-upload__kml']");
	public static By CreateMapLayerButton = By.xpath("//button[text()='Create Map Layer']");
	public static By AgencyBoundaryTab = By.xpath("//div[text()='Agency Boundary']");
	public static By AgencyBoundayTitle = By.xpath("//div[@class='flex-column--left agency-boundary__title']//h4");
	public static By AgencyMapSettingTitle = By.xpath("//div[@class='agency-setup-tab map-settings']//h4");
	public static By UploadAgencyBoundary = By.xpath("//input[@id='file-upload__boundary']");
	public static By UploadKMZFileInput = By.xpath("//input[@id='file-upload__boundary']");
	public static By MapSettingsTab = By.xpath("//div[text()='Map Settings']");
	public static By SaveChangesButton = By.xpath("//button[text()='Save Changes']");
	public static By CenterLongitudeField = By.xpath("//input[@name='centerLongitude']");
	public static By CenterLatitudeField = By.xpath("//input[@name='centerLatitude']");
	public static By TextOptionType = By.xpath("//div[text()='Text']");
	public static By LCFsActiveCount = By.xpath("(//div[@class='agency-setup-tab__section__header']/h2)[1]");
	public static By ICCActiveCount = By.xpath("(//div[@class='agency-setup-tab__section__header']/h2)[1]");
	public static By LCCActiveCount = By.xpath("(//div[@class='agency-setup-tab__section__header']/h2)[1]");
	public static By MapLayerUploadFile = By.xpath("//input[@id='file-upload__kml']");
	public static By SaveButton = By.xpath("//button[text()='Save']");
	public static By UploadedFileLabel = By.xpath("//div[@class='file-upload']//b");
	public static By AgencyParcelFileInput = By.xpath("//input[@id='file-upload__layer']");
	public static By RefreshLinkText = By.xpath("//a[text()='Refresh']");
	public static By ForcedAbatementTab = By.xpath("//div[@class='tabs__names']/div[text()='Forced Abatement']");
	public static By CreateFAActivityButton = By.xpath("//button[text()='Create Forced Abatement Activity']");
	public static By LabelFieldFAA = By.xpath("//input[@name='label']");
	public static By DescriptionFieldFA = By.xpath("//textarea[@name='description']");
	public static By AddFieldLinkTextFA = By.xpath("//a[@class='fields-container__add-field']");
	public static By LabelRequiredFAAYes = By.xpath("//div[@class='fields-container tile']//button[text()='Yes']");
	public static By TypeDropdownFA = By.xpath("//div[@class='Select-value']");
	public static By CreateFAActivityButton2 = By
			.xpath("//h1[text()='Create Forced Abatement Activity']/following::button[2]");
	public static By CreatedFAALabel = By.xpath("//div[@class='sortable-table__body__td'][1]");
	public static By FieldsLabel = By.xpath("//div[@class='tile-header']/following::input[@name='label']");
	public static By ViolationsSidebarOption = By.xpath("//label[text()='Violations']");
	public static By CreateViolationButton = By.xpath("//button[text()='Create Violation']");
	public static By CreateViolationButton2 = By.xpath("(//button[text()='Create Violation'])[2]");
	public static String inspectionRequiredToggleNo  = "//button[normalize-space()='%s']";
	public static By CreateViolationPopup = By.xpath("//h1[text()='Create Violation']");
	public static By ViolationTypeDropdown = By
			.xpath("//label[@title='Violation Type']/following::div[@class='Select-placeholder']");
	public static By CaseManagementSidebar = By.xpath("//label[text()='Case Management']");
	public static By WaterVioOption = By.xpath("//div[text()='Water']");
	public static By GeneralVioOption = By.xpath("//div[text()='General']");
	public static By VioOptionGeneral = By.xpath("//div[@aria-label='General']");
	public static By AppliedToLegalEntries = By.xpath("//button[text()='Applied to Legal Entities']");
	public static By LegalEntityToggle = By.xpath("//button[text()='Legal Entity']");
	public static By VioOptionAnimal = By.xpath("//div[@aria-label='Animal']");
	public static By AnimalVioOption = By.xpath("//div[text()='Animal']");
	public static By MunicipalCodeField = By.xpath("//label[text()='Municipal Code']/following::span[1]");
	public static By MunicipalCodeOption = By.xpath("//ul[@class='picklist-with-handler__picklist-section']/li");
	public static By AddedViolationsRows = By.xpath("//div[@class='sortable-table__body__tr']");
	public static By DispositionsTab = By.xpath("//div[text()='Dispositions']");
	public static By InvalidDisposition = By.xpath("//button[text()='Invalid Dispositions']");
	public static By CreateInvalidDispositionButton = By.xpath("//button[text()='Create Invalid Disposition']");
	public static By CreateInvalidDispositionPopup = By.xpath("//div[text()='Create Invalid Disposition']");
	public static By CreateDispositionButton = By.xpath("//button[text()='Create Disposition']");
	public static By LabelValidation = By.xpath("//span[@class='field__error']");
	public static By InvalidDispositionsToggle = By.xpath("//button[text()='Invalid Dispositions']");
	public static By ActiveDispositionsHeader = By.xpath("//div[text()='Dispositions']/following::h2");
	public static By MunicipalCodeTab = By.xpath("//div[text()='Municipal Code']");
	public static By CreateMunicipalCodeButton = By.xpath("//button[text()='Create Municipal Code']");
	public static By CreateMunicipalCodePopup = By.xpath("//div[text()='Create Municipal Code']");
	public static By ArticleNumberField = By.xpath("//input[@name='articleNumber']");
	public static By DescriptionField = By.xpath("//textarea[@name='description']");
	public static By ResolutionActionField = By.xpath("//textarea[@name='resolutionAction']");
	public static By CreateMunicipalCodeButton2 = By.xpath("//div[@class='municipal-code-form__footer']/button[2]");
	public static By CEProdSideBar = By.xpath("//h6[text()='PRODUCT SETTINGS']/following::label[1]");
	public static By UserManagementSidebar = By.xpath("//label[text()='User Management']");
	public static By NoticesSidebar = By.xpath("//label[text()='Notices']");
	public static By ViolationsTab = By.xpath("//div[text()='Violations']");
	public static By CRMProdSideBar = By
			.xpath("//div[@class='sidebar__options-container__options flex-column--left'][2]/label");
	public static By CategoriesSideBar = By.xpath("//label[text()='Categories']");
	public static By FinesSideBar = By.xpath("//label[text()='Fines']");
	public static By violationSideBar = By.xpath("//label[text()='Violations']");
	public static By LateFeeSubtab = By.xpath("//div[text()='Late Fees']");
	public static By SubmissionSettingsSideBar = By.xpath("//label[text()='Submission Settings']");
	public static By CodeEnforcementOption = By.xpath("//label[text()='Code Enforcement Case']");
	public static By CreateACasePopupTitle = By.xpath("//h1[text()='Create A Case']");
	public static By CancelButton = By.xpath("//button[text()='Cancel']");
	public static By AuditTrial = By.xpath("//label[text()='Audit Trail']");
	public static By CreateFineBtn = By.xpath("//div[@class='agency-setup-tab__section__header']//button[text()='Create Fine']");
	public static By CreateFinePopup = By.xpath("//div[@class='modal-header']");
	public static By CancelCreateFine = By.xpath("//button[text()='Cancel']");
	public static By DoNotAttachedNoticeChk = By.xpath("//label[text()='Do not associate a notice']");
	public static By CreateFinePopUpbtn = By
			.xpath("//div[text()='Create Fine'][@class='modal-header']//parent::div//button[text()='Create Fine']");

	public static By CrtFineLabelValidMsg = By.xpath("(//span[@class='field__error'])[1]");
	public static By CrtFineDefaultAmountValidMsg = By.xpath("//span[normalize-space()='Number should be greater than 0']");
	public static By CrtFineNoticeRequiredValidMsg = By.xpath("(//span[@class='field__error'])[3]");
	public static By CrtFineLabelName = By.xpath("//input[@name='label']");
	public static By CrtDefaultAmnt = By.xpath("//input[@name='defaultAmount']");
	public static By ActiveFines = By.xpath("(//div[@class='agency-setup-tab__section__header']//h2)[1]");
	public static By CrtFineSelectNoitce = By.xpath("//span[text()='Select Notice']");
	public static By CrtFineCheckHtmlNotice = By
			.xpath("(//input[@name='associatedNoticeIds'][@type='checkbox'][not (@disabled)])[1]");
	public static By CrtFineCheckHtmlNotice1 = By
			.xpath("(//li[@class='multi']//input[@class='checkbox__input'][not(@disabled)]/following-sibling::label[@class='checkbox__content htmlfor--enabled'])[1]");
	public static By CrtFineApplyNotices = By.xpath("//button[text()='Apply']");
	public static By CreateFineGridValLable = By.xpath("(//div[@class='rt-tr-group']//div[@class='rt-td']//div)[1]");
	public static By CrtFineGridDefAmt = By.xpath("(//div[@class='rt-tr-group']//div[@class='rt-td'])[4]");
	public static By EditActiveFine = By.xpath(
			"//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//button[@class='edit-btn space-right btn btn-primary']");
	public static By EditSavebtn = By.xpath("//button[text()='Save']");
	public static By EditInactiveFine = By.xpath(
			"//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//button[@class='edit-btn space-right btn btn-primary']");
	public static By InactiveFinebtn = By.xpath("//button[text()='Inactive']");
	public static By ActiveFinetoogle = By.xpath("//button[text()='Active']");
	public static By InactiveFines = By.xpath("(//div[@class='agency-setup-tab__section__header']//h2)[2]");
	public static By InactiveFineGridData = By.xpath(
			"//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-tr-group']//div[@class='rt-td']");
	public static By ActiveFineGridData = By.xpath(
			"//h2[contains(text(),'Active')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-tr-group']//div[@class='rt-td']");
	public static By CreateLateFeebtn = By.xpath("//button[text()='Create Late Fee']");
	public static By CreateLateFeePopupText = By.xpath("//div[text()='Create Late Fee']");
	public static By CreateLateFeebtnpopup = By
			.xpath("//div[text()='Create Late Fee']//ancestor::div//button[text()='Create Late Fee']");
	public static By CrtLateFineLabelName = By
			.xpath("//div[text()='Create Late Fee']//parent::div//input[@name='label']");
	public static By CrtLateFineLabeldesc = By
			.xpath("//div[text()='Create Late Fee']//parent::div//input[@name='description']");
	public static By CrtLateFeeManualToggle = By
			.xpath("//div[text()='Create Late Fee']//parent::div//button[text()='Manual Late Fee']");
	public static By CrtLateFeeFlatToggle = By
			.xpath("//div[text()='Create Late Fee']//parent::div//button[text()='Flat Late Fee']");
	public static By CrtLateFeeFixedAmtToggle = By
			.xpath("//div[text()='Create Late Fee']//parent::div//button[text()='Fixed Amount']");
	public static By CrtLateFeeAmount = By.xpath("//div[text()='Create Late Fee']//parent::div//input[@name='amount']");
	public static By AfterDayLateFeePayDue = By
			.xpath("//div[text()='Create Late Fee']//parent::div//input[@name='payByDays']");
	public static By CrtLateFeeOutstdBalToggle = By
			.xpath("//div[text()='Create Late Fee']//parent::div//button[text()='% of outstanding balance']");
	public static String createNonHtmlNoticeBtn = "//button[text()='Create Non-HTML Notice']";
	public static String createNonHtmlNoticePopup = "//div[text()='Create Non-HTML Notice']";
	public static String labelField = "//input[@name='label']";
	public static String createNoticeBtn = "//button[text()='Create Notice']";
	public static String createHtmlNoticeBtn = "//button[text()='Create HTML Notice']";
	public static String createHtmlNoticePopup = "//h1[text()='Create HTML Notice']";
	public static String mergeFieldsLink = "//span[text()='Merge Fields']";
	public static String addMergeFieldsPopup = "//div[text()='Add Merge Fields']";
	public static String countNotices = "//div[@class='agency-setup-tab__section__header']/h2";
	public static String categoryDropdown = "//div[@class='Select-value']";
	public static String categoryOption = "//*[text()='Case Activity']";
	public static String fieldResults = "//div/div[@class='rt-td']/a";
	public static String categoryResults = "//div[text()='Case Activity']";
	public static String doneButton = "//button[text()='Done']";
	public static String previewButton = "//button[text()='Preview']";
	public static String previewPopupBody = "//div[@class='modal-base__body']//div/p";
	public static String fADocumentToggle = "//button[text()='FA Document']";
	public static String noticesPageLink = "//label[text()='Notices']";
	public static String editIconNotice = "//button[@class='edit-btn space-right btn btn-primary']";
	public static String noticeLabelColumn = "//div[@class='sortable-table__body__td'][1]";
	public static String noticesCountHeader = "//div[@class='agency-setup-tab__section__header']/h2";
	public static String noticesCountActual = "//div[@class='sortable-table__body__td'][1]";
	public static String linkToVioTypesField = "//span[@class='Select-placeholder placeholder']";
	public static String waterOptionToLink = "//*[text()='Water']";
	public static String appHeaderIcon = "//div[@class='app-header__menu__icon']";
	public static String agencySetupLabel = "//label[text()='Agency Setup']";
	public static By CreateNonHtmlNoticeBtn = By.xpath(createNonHtmlNoticeBtn);
	public static By CreateNonHtmlNoticePopup = By.xpath(createNonHtmlNoticePopup);
	public static By CreateNoticeBtn = By.xpath(createNoticeBtn);
	public static By CreateHtmlNoticeBtn = By.xpath(createHtmlNoticeBtn);
	public static By MergeFieldsLink = By.xpath(mergeFieldsLink);
	public static By AddMergeFieldsPopup = By.xpath(addMergeFieldsPopup);
	public static By CreateHtmlNoticePopup = By.xpath(createHtmlNoticePopup);
	public static By CountNotices = By.xpath(countNotices);
	public static By CategoryDropdown = By.xpath(categoryDropdown);
	public static By CategoryOption = By.xpath(categoryOption);
	public static By FieldResults = By.xpath(fieldResults);
	public static By CategoryResults = By.xpath(categoryResults);
	public static By DoneButton = By.xpath(doneButton);
	public static By PreviewButton = By.xpath(previewButton);
	public static By PreviewPopupBody = By.xpath(previewPopupBody);
	public static By FADocumentToggle = By.xpath(fADocumentToggle);
	public static By NoticesPageLink = By.xpath(noticesPageLink);
	public static By EditIconNotice = By.xpath(editIconNotice);
	public static By NoticeLabelColumn = By.xpath(noticeLabelColumn);
	public static By NoticesCountHeader = By.xpath(noticesCountHeader);
	public static By NoticesCountActual = By.xpath(noticesCountActual);
	public static By LinkToVioTypesField = By.xpath(linkToVioTypesField);
	public static By WaterOptionToLink = By.xpath(waterOptionToLink);
	public static By AppHeaderIcon = By.xpath(appHeaderIcon);
	public static By AgencySetupLabel = By.xpath(agencySetupLabel);
	public static String noticeName = "//div[@class='sortable-table__body__td'][contains(text(),'%s')]";
	public static String attachedNotice = "//input[@name='associatedNoticeIds'][@type='checkbox'][not (@disabled)]//parent::span//label[contains(text(),'%s')]";

	public static By gISServiceParcel = By.xpath("//button[contains(text(),'GIS Service Parcel')]");
	public static By fromParcelFile = By.xpath("//button[contains(text(),'From Parcel File')]");
	public static By ownerZipGIS = By.xpath("//div[@class='Select-menu-outer']//div[contains(text(),'OWNER_ZIP')]");
	public static By ownerZip = By.xpath("//div[@class='Select-menu-outer']//div[contains(text(),'owner_zip')]");
	public static By picklistAdd = By.xpath("//a[@class='picklist-options__add']");
	public static By blockTxt = By.xpath("(//input[@placeholder='Enter Text'][@name='option'])[1]");
	public static By blockTxt2 = By.xpath("(//input[@placeholder='Enter Text'][@name='option'])[2]");
	public static String CrtFineFieldValidMsg = "(//span[@class='field__error'])[%s]";
	public static By inspectionReq = By.xpath("//button[@class='square-btn btn btn-default'][text()='No']");

	public static String LCFTabTitle;
	public static String CLCFPopupTitle;
	public static String ExpectedCLCFTitle;
	public static String RandomCLFName;
	public static int LCFsCountBefore;
	public static int LCFsCountAfter;
	public static boolean CompareLCFsCount;
	public static String MapLayerTabTitle;
	public static String RandomLabelName;
	public static int MapLayerCountBefore;
	public static int MapLayerCountAfter;
	public static boolean CompareMapLayersCount;
	public static String CreateMLPopupTitle;
	public static String ExpectedCreateMLTitle;
	public static String ActualBoundaryFile;
	public static String ExpectedBoundaryFile;
	public static String BoundaryTabTitle;
	public static String ActualAPZipFile;
	public static String ExpectedAPZipFile;
	public static String MapSettingsTabTitle;
	public static String MapSettingsTitle;
	public static String AddedFAActivity;
	public static String AddedFAActivityFirst;
	public static String AddedFAActivityCount;
	public static String CreateViolationTitle;
	public static boolean CheckVio1;
	public static boolean CheckVio2;
	public static String DispositionsPopupTitle;
	public static String LabelValidationMsg;
	public static String[] DispositionsHeader;
	public static int DispositionsHeaderCount;
	public static String ExpectedDispositionsPopupTitle;
	public static String ExpDispositionLabelValidationMsg;
	public static boolean CheckDispositionCount;
	public static String CreateMunicipalCodePopupTitle;
	public static String AddedMuncipalCode;
	public static int CurrentNoticesCount;
	public static boolean CompareCountNonHTML;
	public static boolean CompareCountHTML;
	public static boolean CompareCountFADoc;
	public static String GetCRMTrace;
	public static boolean ToggleButtonState1;
	public static boolean ToggleButtonState2;
	public static boolean CCPStatus;
	public static String RandomArticleNumber;

	public static String locationMapLayerEnterprise = PropertiesUtils.getPropertyValue("locationMapLayerEnterprise");
	public static String locationMapLayerGIS12O = PropertiesUtils.getPropertyValue("locationMapLayerGIS12O");
	public static String locationParcelFileEnterprise = PropertiesUtils
			.getPropertyValue("locationParcelFileEnterprise");
	public static String locationParcelFileGIS12O = PropertiesUtils.getPropertyValue("locationParcelFileGIS12O");
	public static String centerLongitudeEnterprise = PropertiesUtils.getPropertyValue("centerLongitudeEnterprise");
	public static String centerLongitudeGIS12O = PropertiesUtils.getPropertyValue("centerLongitudeGIS12O");
	public static String centerLatitudeGIS120 = PropertiesUtils.getPropertyValue("centerLatitudeGIS120");
	public static String centerLatitudeEnterprise = PropertiesUtils.getPropertyValue("centerLatitudeEnterprise");

	public static By agencies = By.xpath("//a[text()='Agencies']");
	public static By agencyNamee = By.xpath("(//div[@role='grid']//div[@role='gridcell'])[1]");
	public static By picklistOpt = By.xpath("//a[@class='picklist-options__add']");
	public static By picklistInputField = By.xpath("(//input[@placeholder='Enter Text'][@name='option'])[1]");
	public static By picklistInputField2 = By.xpath("(//input[@placeholder='Enter Text'][@name='option'])[2]");
	public static By KMLFile = By.xpath("//button[text()='KML File']");
	public static By KMLUpload = By.xpath("//input[@id='file-upload__kml']");
	public static By activeMapLayers = By.cssSelector("div.sortable-table__body__td");
	public static By managePicklist = By.xpath("//div[contains(text(),'Manage Picklist')]");
	public static By proposedFA = By.xpath("//h4[contains(text(),'Proposed Forced Abatement')]");
	public static By FAActivities = By.xpath("(//span[contains(text(),'Forced Abatement Activities')])[1]//parent::h2");
	public static By CreateVioEscalateNotieYesBtn = By.xpath(
			"//label[@title='Supervisor Approval Required?']//parent::div//following-sibling::div//button[text()='Yes']");
	public static By linkToVioTypes = By.xpath(
			"//label[text()='Link to Violation types']//parent::div//following-sibling::div//span[@class='Select-arrow']");
	public static By FADocBtn = By.xpath("//button[text()='FA Document']");


	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void AgencySetup_VerifyAppConfigurations(String agencyName) throws InterruptedException {
		waitUntilElementIsVisible(agencies);
		waitUntilElementPresent(agencies);
		clickOn(agencies);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(LoginAgencyUtility.SearchAgency);
		waitUntilElementPresent(LoginAgencyUtility.SearchAgency);
		waitForElementIsInteractable(LoginAgencyUtility.SearchAgency);
		driver.findElement(LoginAgencyUtility.SearchAgency).clear();
		scrollIntoView(LoginAgencyUtility.SearchAgency);
		sendKeysWithWait(LoginAgencyUtility.SearchAgency, agencyName);
		waitForPresenceandVisiblity(By.xpath(ReportCRMUtility.AgencyNameGrid(agencyName)));
		// Thread.sleep(3000);
		waitUntilElementPresent(By.xpath(ReportCRMUtility.AgencyNameGrid(agencyName)));
		String agencyId = getTextElement(agencyNamee);
		System.out.println("Agency Details\n");
		System.out.println("Created Agency : " + agencyId);
		System.out.println("Agency Name : " + agencyName);
		System.out.println("Agency Details\n");
		scrollIntoView(LoginAgencyUtility.EnterAgencyIcon);
		waitForStaleElementReference(LoginAgencyUtility.EnterAgencyIcon);
		waitForElementIsInteractable(LoginAgencyUtility.EnterAgencyIcon);
		clickByJsExecuter(LoginAgencyUtility.EnterAgencyIcon);
		int tabscount;
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		tabscount = tabs.size();
		System.out.println(tabscount);
		while (tabscount != 2) {
			tabs = new ArrayList<>(driver.getWindowHandles());
			tabscount = tabs.size();
		}
		System.out.println(tabscount);
		try {
			driver.switchTo().window((String) tabs.get(1));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		waitForPresenceandVisiblity(DashBoardCRMUtility.CRMToggle);
		waitUntilElementPresent(DashBoardCRMUtility.CRMToggle);
		GetCRMTrace = getTextElement(DashBoardCRMUtility.CRMToggle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.GetCRMTrace, "CRM");
		softAssert.assertAll();
	}

	public void AddCustomLocationfields(String locationfieldName, String type) throws InterruptedException {
		String LCFCountAtHeader[] = getTextElement(LCFsActiveCount).split(" ");
		LCFsCountBefore = Integer.parseInt(LCFCountAtHeader[0]);
		waitForPresenceandVisiblity(CreateCustomFieldButton);
		clickByJsExecuter(CreateCustomFieldButton);
		waitUntilElementIsVisible(OpenedPopupsTitle);
		CLCFPopupTitle = getTextElement(OpenedPopupsTitle);
		ExpectedCLCFTitle = "Create Location Custom Field";

		if (locationfieldName.equalsIgnoreCase("Zip")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
				waitUntilElementIsVisible(gISServiceParcel);
				waitForElementIsInteractable(gISServiceParcel);
				clickOn(gISServiceParcel);
				waitUntilElementIsVisible(NameFieldLCF);
				waitForElementIsInteractable(NameFieldLCF);
				sendKeysWithWait(NameFieldLCF, locationfieldName);
				forcedWaitTime(2);
				waitForPresenceandVisiblity(TypeDropdownField);
				waitForElementIsInteractable(TypeDropdownField);
				clickOn(TypeDropdownField);
				forcedWaitTime(2);
				waitForPresenceandVisiblity(ownerZipGIS);
				waitForElementIsInteractable(ownerZipGIS);
				clickOn(ownerZipGIS);
			} else {
				waitUntilElementIsVisible(fromParcelFile);
				waitForElementIsInteractable(fromParcelFile);
				forcedWaitTime(1);
				clickOn(fromParcelFile);
				waitUntilElementIsVisible(NameFieldLCF);
				waitForElementIsInteractable(NameFieldLCF);
				sendKeysWithWait(NameFieldLCF, locationfieldName);
				waitForPresenceandVisiblity(TypeDropdownField);
				waitForElementIsInteractable(TypeDropdownField);
				clickOn(TypeDropdownField);
				waitForPresenceandVisiblity(ownerZip);
				waitForElementIsInteractable(ownerZip);
				clickOn(ownerZip);
			}

		} else if (locationfieldName.equalsIgnoreCase("Zone")) {
			waitForElementIsInteractable(NameFieldLCF);
			sendKeysWithWait(NameFieldLCF, locationfieldName);
			waitForPresenceandVisiblity(TypeDropdownField);
			waitForElementIsInteractable(TypeDropdownField);
			clickOn(TypeDropdownField);
			waitForPresenceandVisiblity(By.xpath("//div[text()='" + type + "']"));
			waitForElementIsInteractable(By.xpath("//div[text()='" + type + "']"));
			clickOn(By.xpath("//div[text()='" + type + "']"));

			waitForElementIsInteractable(picklistOpt);
			clickOn(picklistOpt);

			clickByJsExecuter(picklistOpt);
			waitForElementIsInteractable(picklistInputField);
			sendKeysWithWait(picklistInputField, "A");

			waitForElementIsInteractable(picklistInputField2);
			sendKeysWithWait(picklistInputField2, "B");

		}

		else {

			waitForElementIsInteractable(NameFieldLCF);
			sendKeysWithWait(NameFieldLCF, locationfieldName);
			waitForPresenceandVisiblity(TypeDropdownField);
			waitForElementIsInteractable(TypeDropdownField);
			clickOn(TypeDropdownField);
			waitForPresenceandVisiblity(By.xpath("//div[text()='" + type + "']"));
			waitForElementIsInteractable(By.xpath("//div[text()='" + type + "']"));
			clickOn(By.xpath("//div[text()='" + type + "']"));
		}

		waitForPresenceandVisiblity(CreateCustomFieldButton2);
		waitForElementIsInteractable(CreateCustomFieldButton2);
		clickOn(CreateCustomFieldButton2);
		waitUntilElementInvisibleLocated(CreateCustomFieldButton2);
		waitForCurserRunning(4);
		waitForPresenceandVisiblity(LCFTab);
		waitForPresenceandVisiblity(LCFsActiveCount);

		String LCFCountAtHeader2[] = getTextElement(LCFsActiveCount).split(" ");
		LCFsCountAfter = Integer.parseInt(LCFCountAtHeader2[0]);
		CompareLCFsCount = (LCFsCountAfter == (LCFsCountBefore + 1));
	}

	public void AgencySetup_VerifyCaseAssignmentRules() throws InterruptedException {
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToAssignmentRules();
		crmCommonMethod.editCaseAssignmentRule();
		ceCommonMethod.deleteRules(0);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("WaterViolation"), PropertiesUtils.getPropertyValue("AgencyCE2User"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("AnimalViolation"), PropertiesUtils.getPropertyValue("AgencyCE2User"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("FireViolation"), PropertiesUtils.getPropertyValue("AgencyCEUser"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("WaterFFViolation"), PropertiesUtils.getPropertyValue("AgencyCEUser"), PropertiesUtils.getPropertyValue("Amandeep"));
		}

		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("WaterViolation"), PropertiesUtils.getPropertyValue("AgencyCE2User"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("AnimalViolation"), PropertiesUtils.getPropertyValue("AgencyCE2User"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("FireViolation"), PropertiesUtils.getPropertyValue("AgencyCEUser"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("WaterFFViolation"), PropertiesUtils.getPropertyValue("AgencyCEUser"), PropertiesUtils.getPropertyValue("Amandeep"));
		} else {
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("WaterViolation"), PropertiesUtils.getPropertyValue("AgencyCE2User"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("AnimalViolation"), PropertiesUtils.getPropertyValue("AgencyCE2User"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("FireViolation"), PropertiesUtils.getPropertyValue("AgencyCEUser"), PropertiesUtils.getPropertyValue("Amandeep"));
			forcedWaitTime(2);
			ceCommonMethod.addCaseAssignmentRule(PropertiesUtils.getPropertyValue("attributeCaseViolation"), PropertiesUtils.getPropertyValue("contains"), PropertiesUtils.getPropertyValue("WaterFFViolation"), PropertiesUtils.getPropertyValue("AgencyCEUser"), PropertiesUtils.getPropertyValue("Amandeep"));
		}

		waitForElementIsInteractable(SaveButton);
		clickOn(SaveButton);
		waitUntilElementInvisibleLocated(SaveButton);
		waitForCurserRunning(2);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();

	}

	public void AgencySetup_VerifySubmissionAssignmentRules() throws InterruptedException {

		Thread.sleep(4000);
		crmCommonMethod.editSubmissionAssignmentRule();
		ceCommonMethod.deleteRules(0);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationReq"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotRequired"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotIncluded"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
		}

		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationReq"), PropertiesUtils.getPropertyValue("AgencyCRMUser"),
					PropertiesUtils.getPropertyValue("AmandeepSingh"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotRequired"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotIncluded"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
		}

		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationReq"), "CE To CRM User",
					PropertiesUtils.getPropertyValue("AmandeepSingh"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotRequired"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotIncluded"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("AmandeepSingh"));
		}

		else {
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationReq"), PropertiesUtils.getPropertyValue("AgencyCRMUser"),
					PropertiesUtils.getPropertyValue("Amandeep"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotRequired"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("Amandeep"));
			ceCommonMethod.addSubmissionAssignmentRule(PropertiesUtils.getPropertyValue("attributeSubmissionCategory"), PropertiesUtils.getPropertyValue("equals"), PropertiesUtils.getPropertyValue("LocationNotIncluded"),
					PropertiesUtils.getPropertyValue("AgencyCRMUser"), PropertiesUtils.getPropertyValue("Amandeep"));
		}

		waitForElementIsInteractable(SaveButton);
		clickOn(SaveButton);
		waitUntilElementInvisibleLocated(SaveButton);
		waitForCurserRunning(2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();

	}


	public void AgencySetup_VerifyCreationOfLCFs() throws InterruptedException {

		waitForPresenceandVisiblity(LCFTab);
		scrollIntoView(LCFTab);
		clickByJsExecuter(LCFTab);
		LCFTabTitle = getTextElement(LCFTab);
		waitForPresenceandVisiblity(CreateCustomFieldButton);
		AddCustomLocationfields(PropertiesUtils.getPropertyValue("zip"), PropertiesUtils.getPropertyValue("typePopulated"));
		AddCustomLocationfields(PropertiesUtils.getPropertyValue("block"), PropertiesUtils.getPropertyValue("typeNumber"));
		AddCustomLocationfields(PropertiesUtils.getPropertyValue("zone"), PropertiesUtils.getPropertyValue("typePicklist"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.LCFTabTitle, PropertiesUtils.getPropertyValue("LocationCustomField"));
		softAssert.assertEquals(AppPreRequisiteUtility.CLCFPopupTitle, AppPreRequisiteUtility.ExpectedCLCFTitle);
		softAssert.assertTrue(AppPreRequisiteUtility.CompareLCFsCount);
		softAssert.assertAll();

	}

	public void AgencySetup_VerifyUploadedMapLayer() throws InterruptedException {
		waitForCurserRunning(3);
		// refreshPage();
		forcedWaitTime(3);
		waitForPresenceandVisiblity(AppMenuIcon);
		waitForElementIsInteractable(AppMenuIcon);
		clickByJsExecuter(AppMenuIcon);
		waitForPresenceandVisiblity(AgencySetupIcon);
		waitForElementIsInteractable(AgencySetupIcon);
		clickByJsExecuter(AgencySetupIcon);
		waitForPresenceandVisiblity(LocationManagementTab);
		waitForElementIsInteractable(LocationManagementTab);
		clickByJsExecuter(LocationManagementTab);
		waitForPresenceandVisiblity(LocationandMapsTab);
		waitForElementIsInteractable(LocationandMapsTab);
		clickByJsExecuter(LocationandMapsTab);
		waitForPresenceandVisiblity(LCFTab);
		waitForPresenceandVisiblity(MapLayersTab);
		waitForElementIsInteractable(MapLayersTab);
		clickByJsExecuter(MapLayersTab);
		waitForPresenceandVisiblity(MapLayersTab);
		MapLayerTabTitle = getTextElement(MapLayersTab);
		waitForPresenceandVisiblity(LCFsActiveCount);
		String MapLayerCountAtHeader[] = getTextElement(LCFsActiveCount).split(" ");
		MapLayerCountBefore = Integer.parseInt(MapLayerCountAtHeader[0]);
		waitForPresenceandVisiblity(UploadMapLayerButton);
		waitForElementIsInteractable(UploadMapLayerButton);
		clickByJsExecuter(UploadMapLayerButton);
		waitForPresenceandVisiblity(OpenedPopupsTitle);
		CreateMLPopupTitle = getTextElement(OpenedPopupsTitle);
		ExpectedCreateMLTitle = "Create Map Layer";
		RandomLabelName = RandomStrings.requiredCharacters(6);
		waitForElementIsInteractable(LabelField);
		sendKeysWithWait(LabelField, RandomLabelName);
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			waitForElementIsInteractable(KMLFile);
			clickByJsExecuter(KMLFile);
			WebElement UploadMapLayer = driver.findElement(KMLUpload);
			UploadMapLayer.sendKeys(System.getProperty("user.dir") + locationMapLayerGIS12O);
			waitForPresenceandVisiblity(ReplaceFile);
		} 
		else {
			WebElement UploadMapLayer = driver.findElement(KMLUpload);
			UploadMapLayer.sendKeys(System.getProperty("user.dir") + locationMapLayerEnterprise);
			waitForPresenceandVisiblity(ReplaceFile);
		}
		waitForElementIsInteractable(CreateMapLayerButton);
		clickByJsExecuter(CreateMapLayerButton);
		waitForCurserRunning(10);
		forcedWaitTime(8);
		refreshPage();
		waitForCurserRunning(10);
		waitForPresenceandVisiblity(MapLayersTab);
		waitForElementIsInteractable(MapLayersTab);
		clickByJsExecuter(MapLayersTab);
		Thread.sleep(3000);
		System.out.println("successfully entered in maplayers tab");
		waitForCurserRunning(3);
		waitForPresenceandVisiblity(UploadMapLayerButton);
		waitForElementIsInteractable(UploadMapLayerButton);
		Thread.sleep(3000);
		waitForPresenceandVisiblity(activeMapLayers);
		System.out.println("successfully see the active map layers ");
		String MapLayerCountAtHeader2[] = getTextElement(LCFsActiveCount).split(" ");
		MapLayerCountAfter = Integer.parseInt(MapLayerCountAtHeader2[0]);
		CompareMapLayersCount = (MapLayerCountAfter == (MapLayerCountBefore + 1));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(MapLayerTabTitle, "Map Layers");
		softAssert.assertEquals(CreateMLPopupTitle, ExpectedCreateMLTitle);
		softAssert.assertTrue(CompareMapLayersCount);

	}

	public void AgencySetup_VerifyUploadedAgencyBoundary() throws InterruptedException {
		refreshPage();
		waitForCurserRunning(8);
		waitForPresenceandVisiblity(AgencyBoundaryTab);
		scrollIntoView(AgencyBoundaryTab);
		waitForElementIsInteractable(AgencyBoundaryTab);
		clickByJsExecuter(AgencyBoundaryTab);
		waitForPresenceandVisiblity(AgencyBoundayTitle);
		BoundaryTabTitle = getTextElement(AgencyBoundayTitle);
		WebElement UploadBoundaryFile = driver.findElement(UploadAgencyBoundary);
		if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)){
			UploadBoundaryFile.sendKeys(System.getProperty("user.dir") + locationMapLayerGIS12O);
			waitForCurserRunning(10);
			waitForPresenceandVisiblity(AgencyBoundayTitle);
			}
		else  {
			UploadBoundaryFile.sendKeys(System.getProperty("user.dir") + locationMapLayerEnterprise);
			waitForCurserRunning(10);
			waitForPresenceandVisiblity(AgencyBoundayTitle);
		}

		waitForPresenceandVisiblity(RefreshLinkText);
		int CheckRefresh = driver.findElements(RefreshLinkText).size();
		if (CheckRefresh == 0) {
			CheckRefresh = driver.findElements(RefreshLinkText).size();
		}
		while (CheckRefresh > 0) {
			scrollIntoView(RefreshLinkText);
			waitForPresenceandVisiblity(RefreshLinkText);
			waitForElementIsInteractable(RefreshLinkText);
			waitForElementIsInteractable(RefreshLinkText);
			clickByJsExecuter(RefreshLinkText);
			waitForCurserRunning(10);
			CheckRefresh = driver.findElements(RefreshLinkText).size();
		}
		waitForPresenceandVisiblity(UploadedFileLabel);
		scrollIntoView(UploadedFileLabel);
		ActualBoundaryFile = getTextElement(UploadedFileLabel);
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterprise) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
			ExpectedBoundaryFile = PropertiesUtils.getPropertyValue("AgencyBoundayEnterPrise");
		} else {
			ExpectedBoundaryFile = PropertiesUtils.getPropertyValue("AgencyBoundayGIS");

		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(BoundaryTabTitle, "Agency Boundary");
		softAssert.assertEquals(ActualBoundaryFile, ExpectedBoundaryFile);
		softAssert.assertAll();

	}

	public void AgencySetup_VerifyUploadedAgencyParcelFile() throws InterruptedException {

		waitForPresenceandVisiblity(MapSettingsTab);
		scrollIntoView(MapSettingsTab);
		waitForElementIsInteractable(MapSettingsTab);
		clickByJsExecuter(MapSettingsTab);
		waitForCurserRunning(8);
		forcedWaitTime(4);
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterprise) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
			MapSettingsTabTitle = getTextElement(MapSettingsTab);
			MapSettingsTitle = getTextElement(AgencyMapSettingTitle);
			WebElement UploadBoundaryFile = driver.findElement(AgencyParcelFileInput);
			UploadBoundaryFile.sendKeys(System.getProperty("user.dir") + locationParcelFileEnterprise);
			waitForCurserRunning(15);
			waitForPresenceandVisiblity(AgencyMapSettingTitle);
		}
		refreshPage();
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(MapSettingsTab);
		waitForElementIsInteractable(MapSettingsTab);
		clickByJsExecuter(MapSettingsTab);
		waitForCurserRunning(2);
		waitUntilElementIsVisible(RefreshLinkText);
		int CheckRefresh = driver.findElements(RefreshLinkText).size();
		if (CheckRefresh == 0) {
			CheckRefresh = driver.findElements(RefreshLinkText).size();
		}
		while (CheckRefresh > 0) {
			scrollIntoView(RefreshLinkText);
			waitForElementIsInteractable(RefreshLinkText);
			waitForElementIsInteractable(RefreshLinkText);
			clickByJsExecuter(RefreshLinkText);
			waitForCurserRunning(5);
			CheckRefresh = driver.findElements(RefreshLinkText).size();
		}

		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterprise)) {
			waitForPresenceandVisiblity(CenterLongitudeField);
			waitForElementIsInteractable(CenterLongitudeField);
			clearElement(CenterLongitudeField);
			sendKeysWithWait(CenterLongitudeField, centerLongitudeEnterprise);
			clearElement(CenterLatitudeField);
			waitForPresenceandVisiblity(CenterLatitudeField);
			sendKeysWithWait(CenterLatitudeField, centerLatitudeEnterprise);

		} 
		
		else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
			waitForPresenceandVisiblity(CenterLongitudeField);
			waitForElementIsInteractable(CenterLongitudeField);
			clearElement(CenterLongitudeField);
			sendKeysWithWait(CenterLongitudeField, centerLongitudeEnterprise);
			clearElement(CenterLatitudeField);
			waitForPresenceandVisiblity(CenterLatitudeField);
			sendKeysWithWait(CenterLatitudeField, centerLatitudeEnterprise);

		}
		
		else {
			waitForPresenceandVisiblity(CenterLongitudeField);
			waitForElementIsInteractable(CenterLongitudeField);
			clearElement(CenterLongitudeField);
			sendKeysWithWait(CenterLongitudeField, centerLongitudeGIS12O);
			clearElement(CenterLatitudeField);
			waitForPresenceandVisiblity(CenterLatitudeField);
			sendKeysWithWait(CenterLatitudeField, centerLatitudeGIS120);

		}

		JavascriptExecutor jser = (JavascriptExecutor) driver;
		jser.executeScript("window.scrollBy(0,450)", "");
		WebElement SaveChangesButtonMS = (WebElement) jser.executeScript(
				"return document.querySelector('div > div.agency-setup-tab__actions.map-settings__actions > button.square-btn.btn.btn-primary')");
		waitUntilWebElementIsVisible(SaveChangesButtonMS);
		waitForElementInteractable(SaveChangesButtonMS);
		clickOnWE(SaveChangesButtonMS);
		waitForCurserRunning(8);
		forcedWaitTime(4);
		SoftAssert softAssert = new SoftAssert();
		
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterprise)) {
			waitForPresenceandVisiblity(UploadedFileLabel);
			ActualAPZipFile = getTextElement(UploadedFileLabel);
			ExpectedAPZipFile = PropertiesUtils.getPropertyValue("AgencyZipFileEnterPrise");
			softAssert.assertEquals(MapSettingsTabTitle, "Map Settings");
			softAssert.assertEquals(MapSettingsTitle, "Agency Parcel File");
			softAssert.assertEquals(ActualAPZipFile, ExpectedAPZipFile);
			softAssert.assertAll();
		}		

	}

	public void AgencySetup_VerifyCreatedUser() throws InterruptedException {
		refreshPage();
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(AppMenuIcon);
		crmCommonMethod.navigateToAgencySetup();
		ceCommonMethod.navigateToUserManagement();
		createCRMUser.CreateCRMUser_CreateProductAdminUser();

		// Add More Pre-requisite Users for Stage ,QA and Production
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("Two"), PropertiesUtils.getPropertyValue("User"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("Amandeep"), PropertiesUtils.getPropertyValue("singh1"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("mark"), PropertiesUtils.getPropertyValue("shane"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("shane"), PropertiesUtils.getPropertyValue("es"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("ce"), PropertiesUtils.getPropertyValue("User"), PropertiesUtils.getPropertyValue("ProductAdminCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("crm"), PropertiesUtils.getPropertyValue("User"), PropertiesUtils.getPropertyValue("ProductAdminCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("dummy"), PropertiesUtils.getPropertyValue("User"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("Supervisor"), PropertiesUtils.getPropertyValue("manager"), PropertiesUtils.getPropertyValue("SupervisorMan"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("non"), PropertiesUtils.getPropertyValue("Supervisor"), PropertiesUtils.getPropertyValue("NoSupervisor"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("basic"), PropertiesUtils.getPropertyValue("Supervisor"), PropertiesUtils.getPropertyValue("BasicSuperv"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("AgencyCRM"), PropertiesUtils.getPropertyValue("User"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("AgencyCE"), PropertiesUtils.getPropertyValue("User"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		ceCommonMethod.createCustomeUsers(PropertiesUtils.getPropertyValue("AgencyCE2"), PropertiesUtils.getPropertyValue("User"), PropertiesUtils.getPropertyValue("AdminCRMCEM"));
		forcedWaitTime(4);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CreateCRMUserUtility.CreateProductAdminUser_CompareCount, true);
		softAssert.assertAll();
	}

	public void AddNonRequiredLabelFAAActivity(String actvityName, String labelName) throws InterruptedException {
		waitUntilElementIsVisible(CreateFAActivityButton);
		waitUntilElementPresent(CreateFAActivityButton);
		waitForElementIsInteractable(CreateFAActivityButton);
		waitForElementIsInteractable(CreateFAActivityButton);
		forcedWaitTime(4);
		forcedWaitTime(4);
		scrolltoPageTop();
		clickByJsExecuter(CreateFAActivityButton);
		waitForPresenceandVisiblity(LabelFieldFAA);
		waitForElementIsInteractable(LabelFieldFAA);
		sendKeysWithWait(LabelFieldFAA, actvityName);
		String RandomDescription = RandomStrings.requiredString(20);
		waitUntilElementIsVisible(DescriptionFieldFA);
		waitForElementIsInteractable(DescriptionFieldFA);
		sendKeysWithWait(DescriptionFieldFA, RandomDescription);
		clickByJsExecuter(AddFieldLinkTextFA);
		sendKeysWithWait(FieldsLabel, labelName);
		clickByJsExecuter(CreateFAActivityButton2);
		// WaitForCurserRunning(2);
		waitForPresenceandVisiblity(CreatedFAALabel);
		AddedFAActivity = getTextElement(CreatedFAALabel);
	}

	public void AddRequiredNonRequiredLabelToFAAActivity(String labelCount, String labelName, String required,
			String type) throws InterruptedException {
		clickByJsExecuter(AddFieldLinkTextFA);

		// Add Label Name
		waitUntilElementIsVisible(
				By.xpath("(//div[@class='tile-header']/following::input[@name='label'])[" + labelCount + "]"));
		waitForElementIsInteractable(
				By.xpath("(//div[@class='tile-header']/following::input[@name='label'])[" + labelCount + "]"));
		sendKeysWithWait(By.xpath("(//div[@class='tile-header']/following::input[@name='label'])[" + labelCount + "]"),
				labelName);

		// Check Required or Not Required
		if (required.equalsIgnoreCase("YES")) {
			waitForElementIsInteractable(By.xpath("(//input[@value='" + labelName
					+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[2]//button[contains(text(),'Yes')]"));
			clickOn(By.xpath("(//input[@value='" + labelName
					+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[2]//button[contains(text(),'Yes')]"));
		}

		// click on Type drop down
		waitForElementIsInteractable(By.xpath("(//input[@value='" + labelName
				+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[4]//span[@class='Select-arrow']"));
		clickOn(By.xpath("(//input[@value='" + labelName
				+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[4]//span[@class='Select-arrow-zone']//span"));

		// Select Type
		if (type.equalsIgnoreCase("Picklist")) {
			waitForElementIsInteractable(By.xpath("(//input[@value='" + labelName
					+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[4]//div[@class='Select-menu-outer']//div[contains(text(),'"
					+ type + "')]"));

			scrollIntoView(By.xpath("(//input[@value='" + labelName
					+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[4]//div[@class='Select-menu-outer']//div[contains(text(),'"
					+ type + "')]"));
			forcedWaitTime(1);
			clickOn(By.xpath("(//input[@value='" + labelName
					+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[4]//div[@class='Select-menu-outer']//div[contains(text(),'"
					+ type + "')]"));

			waitUntilElementIsVisible(managePicklist);
			forcedWaitTime(2);
			clickByJsExecuter(picklistOpt);
			forcedWaitTime(2);
			clickByJsExecuter(picklistOpt);
			waitForElementIsInteractable(picklistInputField);
			sendKeysWithWait(picklistInputField, "Yes");

			waitForElementIsInteractable(picklistInputField2);
			sendKeysWithWait(picklistInputField2, "No");
			waitUntilElementIsVisible(EditSavebtn);
			waitForElementIsInteractable(EditSavebtn);
			clickOn(EditSavebtn);

		} else {
			waitForElementIsInteractable(By.xpath("(//input[@value='" + labelName
					+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[4]//div[@class='Select-menu-outer']//div[contains(text(),'"
					+ type + "')]"));
			clickOn(By.xpath("(//input[@value='" + labelName
					+ "']//ancestor::div[@class='field-section field-section--required  col-md-12 col-12']//following-sibling::div)[4]//div[@class='Select-menu-outer']//div[contains(text(),'"
					+ type + "')]"));
		}

	}

	public void AgencySetup_VerifyAdditionOfFAActivity() throws InterruptedException {

		String req = PropertiesUtils.getPropertyValue("required");
		List<String> required = Arrays.asList(req.split(","));

		crmCommonMethod.navigateToAgencySetup();
		forcedWaitTime(3);
		crmCommonMethod.navigationToFAAAdmin(CaseManagementSidebar);
		waitForPresenceandVisiblity(ForcedAbatementTab);
		scrollIntoView(ForcedAbatementTab);
		waitForElementIsInteractable(ForcedAbatementTab);
		waitForElementIsInteractable(ForcedAbatementTab);
		clickByJsExecuter(ForcedAbatementTab);
		waitUntilElementIsVisible(proposedFA);
		waitForElementIsInteractable(CreateFAActivityButton);
		clickByJsExecuter(CreateFAActivityButton);
		waitForPresenceandVisiblity(LabelFieldFAA);
		waitForElementIsInteractable(LabelFieldFAA);
		sendKeysWithWait(LabelFieldFAA, "Forced Abatement");
		String RandomDescription = RandomStrings.requiredString(20);
		sendKeysWithWait(DescriptionFieldFA, RandomDescription);
		AddRequiredNonRequiredLabelToFAAActivity("1", PropertiesUtils.getPropertyValue("selectDate"), required.get(1), PropertiesUtils.getPropertyValue("date"));
		AddRequiredNonRequiredLabelToFAAActivity("2", PropertiesUtils.getPropertyValue("caseID"), required.get(0), PropertiesUtils.getPropertyValue("text"));
		AddRequiredNonRequiredLabelToFAAActivity("3", PropertiesUtils.getPropertyValue("caseNum"), required.get(0), PropertiesUtils.getPropertyValue("number"));
		AddRequiredNonRequiredLabelToFAAActivity("4", PropertiesUtils.getPropertyValue("otherLinkedCase"), required.get(0), PropertiesUtils.getPropertyValue("picklist"));

		waitUntilElementIsVisible(CreateFAActivityButton2);
		scrollIntoView(CreateFAActivityButton2);
		waitForElementIsInteractable(CreateFAActivityButton2);
		clickByJsExecuter(CreateFAActivityButton2);
		waitForCurserRunning(4);
		waitForPresenceandVisiblity(CreatedFAALabel);
		AddedFAActivityFirst = getTextElement(CreatedFAALabel);
		AddNonRequiredLabelFAAActivity(PropertiesUtils.getPropertyValue("activityTwo"), PropertiesUtils.getPropertyValue("label"));
		AddNonRequiredLabelFAAActivity(PropertiesUtils.getPropertyValue("responsive"), PropertiesUtils.getPropertyValue("response"));
		AddedFAActivityCount = getTextByJSExecutor(FAActivities).split(" ")[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.AddedFAActivityFirst, "Forced Abatement");
		softAssert.assertNotEquals(Integer.parseInt(AppPreRequisiteUtility.AddedFAActivityCount), 3);
		softAssert.assertAll();
	}

	public static String getMuncipalVioCode(String codeName) {

		String xPath = "//div[contains(text(),'" + codeName + "')]";
		return xPath;
	}

	public void AgencySetup_VerifyCreationOfMunicipalCode() throws InterruptedException {
		crmCommonMethod.navigationToViolationAdmin(ViolationsSidebarOption);
		waitUntilElementIsVisible(MunicipalCodeTab);
		waitUntilElementPresent(MunicipalCodeTab);
		waitForElementIsInteractable(MunicipalCodeTab);
		clickByJsExecuter(MunicipalCodeTab);
		waitForPresenceandVisiblity(CreateMunicipalCodeButton);
		clickByJsExecuter(CreateMunicipalCodeButton);
		waitForPresenceandVisiblity(CreateMunicipalCodePopup);
		CreateMunicipalCodePopupTitle = getTextElement(CreateMunicipalCodePopup);
		RandomArticleNumber = RandomStrings.requiredDigits(4);
		String RandomDescription = RandomStrings.requiredCharacters(50);
		String RandomResolutionAction = RandomStrings.requiredCharacters(20);
		sendKeysWithWait(ArticleNumberField, RandomArticleNumber);
		sendKeysWithWait(DescriptionField, RandomDescription);
		sendKeysWithWait(ResolutionActionField, RandomResolutionAction);
		waitForElementIsInteractable(CreateMunicipalCodeButton2);
		clickByJsExecuter(CreateMunicipalCodeButton2);
		waitForCurserRunning(2);
		waitUntilElementInvisibleLocated(CreateMunicipalCodeButton2);
		waitForPresenceandVisiblity(By.xpath(getMuncipalVioCode(RandomArticleNumber)));
		AddedMuncipalCode = getTextElement(By.xpath(getMuncipalVioCode(RandomArticleNumber)));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.CreateMunicipalCodePopupTitle, "Create Municipal Code");
		softAssert.assertEquals(AppPreRequisiteUtility.AddedMuncipalCode, AppPreRequisiteUtility.RandomArticleNumber);
		softAssert.assertAll();

	}

	public void AgencySetup_VerifyCreationOfViolations() throws InterruptedException {

		crmCommonMethod.navigationToViolationAdmin(ViolationsSidebarOption);
		waitUntilElementIsVisible(ViolationsTab);
		waitUntilElementPresent(ViolationsTab);
		waitForElementIsInteractable(ViolationsTab);
		clickByJsExecuter(ViolationsTab);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(CreateViolationButton);
		waitForElementIsInteractable(CreateViolationButton);
		clickByJsExecuter(CreateViolationButton);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(CreateViolationPopup);
		CreateViolationTitle = getTextElement(CreateViolationPopup);
		crmCommonMethod.addNewViolationAdmin(PropertiesUtils.getPropertyValue("WaterViolation"));
		waitForPresenceandVisiblity(AddedViolationsRows);
		List<WebElement> AddedViolations = findElementsByXPath(AddedViolationsRows);
		CheckVio1 = (AddedViolations.size() == 1);
		refreshPage();
		waitForPresenceandVisiblity(CreateViolationButton);
		scrollIntoView(CreateViolationButton);
		waitForElementIsInteractable(CreateViolationButton);
		clickByJsExecuter(CreateViolationButton);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(CreateViolationPopup);
		crmCommonMethod.addNewViolationAdmin(PropertiesUtils.getPropertyValue("AnimalViolation"));
		refreshPage();
		waitForPresenceandVisiblity(CreateViolationButton);
		scrollIntoView(CreateViolationButton);
		waitForElementIsInteractable(CreateViolationButton);
		clickByJsExecuter(CreateViolationButton);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(CreateViolationPopup);
		crmCommonMethod.addNewViolationAdmin(PropertiesUtils.getPropertyValue("WaterFFViolation"));
		refreshPage();
		waitForPresenceandVisiblity(CreateViolationButton);
		scrollIntoView(CreateViolationButton);
		waitForElementIsInteractable(CreateViolationButton);
		clickByJsExecuter(CreateViolationButton);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(CreateViolationPopup);
		crmCommonMethod.addNewViolationAdmin(PropertiesUtils.getPropertyValue("FireViolation"));
		refreshPage();
		waitForPresenceandVisiblity(CreateViolationButton);
		scrollIntoView(CreateViolationButton);
		waitForElementIsInteractable(CreateViolationButton);
		clickByJsExecuter(CreateViolationButton);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(CreateViolationPopup);
		crmCommonMethod.addNewCitationViolation(PropertiesUtils.getPropertyValue("CitationViolation"));
		refreshPage();
		waitForPresenceandVisiblity(CreateViolationButton);
		scrollIntoView(CreateViolationButton);
		waitForElementIsInteractable(CreateViolationButton);
		clickByJsExecuter(CreateViolationButton);
		waitForCurserRunning(2);
		waitForPresenceandVisiblity(CreateViolationPopup);
		crmCommonMethod.addNewCitationViolation(PropertiesUtils.getPropertyValue("citationVio"));
		waitForPresenceandVisiblity(AddedViolationsRows);
		AddedViolations = findElementsByXPath(AddedViolationsRows);
		CheckVio2 = (AddedViolations.size() == 5);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CheckVio1);
		softAssert.assertTrue(CheckVio2);
		softAssert.assertAll();
	}

	public void AgencySetup_VerifyInvalidDispositionCreation() throws InterruptedException {
		CRMCommonMethods crmCommonMethod = new CRMCommonMethods(driver);
		crmCommonMethod.navigateToDisposition();
		waitForElementIsInteractable(CreateInvalidDispositionButton);
		clickByJsExecuter(CreateInvalidDispositionButton);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(CreateInvalidDispositionPopup);
		DispositionsPopupTitle = getTextElement(CreateInvalidDispositionPopup);
		ExpectedDispositionsPopupTitle = PropertiesUtils.getPropertyValue("invaliddisposition");
		waitForElementIsInteractable(CreateDispositionButton);
		clickByJsExecuter(CreateDispositionButton);
		waitForPresenceandVisiblity(LabelValidation);
		LabelValidationMsg = getTextElement(LabelValidation);
		ExpDispositionLabelValidationMsg = PropertiesUtils.getPropertyValue("labelreq");
		waitForElementIsInteractable(LabelField);
		sendKeysWithWait(LabelField, PropertiesUtils.getPropertyValue("invalidDisposition"));
		waitForElementIsInteractable(CreateDispositionButton);
		clickByJsExecuter(CreateDispositionButton);
		waitUntilElementInvisibleLocated(CreateDispositionButton);
		waitForCurserRunning(5);
		refreshPage();
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(DispositionsTab);
		waitForPresenceandVisiblity(DispositionsTab);
		waitForElementIsInteractable(DispositionsTab);
		waitForElementIsInteractable(DispositionsTab);
		clickByJsExecuter(DispositionsTab);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(InvalidDisposition);
		waitForElementIsInteractable(InvalidDisposition);
		waitForElementIsInteractable(InvalidDisposition);
		clickByJsExecuter(InvalidDisposition);
		waitForPresenceandVisiblity(By.xpath(getMuncipalVioCode(PropertiesUtils.getPropertyValue("invalidDisposition"))));
		waitForPresenceandVisiblity(ActiveDispositionsHeader);
		DispositionsHeader = getTextElement(ActiveDispositionsHeader).split(" ");
		DispositionsHeaderCount = Integer.parseInt(DispositionsHeader[0]);
		CheckDispositionCount = (DispositionsHeaderCount == 1);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.DispositionsPopupTitle,
				AppPreRequisiteUtility.ExpectedDispositionsPopupTitle);
		softAssert.assertEquals(AppPreRequisiteUtility.LabelValidationMsg,
				AppPreRequisiteUtility.ExpDispositionLabelValidationMsg);
		softAssert.assertTrue(AppPreRequisiteUtility.CheckDispositionCount);
		softAssert.assertAll();
	}

	public void AgencySetup_VerifyCreationOfNonHTMLNotice() throws InterruptedException {

		JavascriptExecutor jser = (JavascriptExecutor) driver;
		forcedWaitTime(3);
		for (int i = 0; i < 8; i++) {

			waitForPresenceandVisiblity(CountNotices);
			String[] NoticesSplit = getTextElement(CountNotices).split(" ");
			String CountText = NoticesSplit[0];
			int NoticesCountBefore = Integer.parseInt(CountText);
			jser.executeScript("window.scrollBy(0,-450)", "");
			waitForPresenceandVisiblity(CreateNonHtmlNoticeBtn);
			waitForElementIsInteractable(CreateNonHtmlNoticeBtn);
			clickByJsExecuter(CreateNonHtmlNoticeBtn);
			waitForPresenceandVisiblity(LabelField);
			waitForElementIsInteractable(LabelField);
			String RandomLabel = "Non-HTML " + RandomStrings.requiredCharacters(8);
			sendKeysWithWait(LabelField, RandomLabel);
			waitForElementIsInteractable(CreateNoticeBtn);
			clickByJsExecuter(CreateNoticeBtn);
			waitForCurserRunning(2);

			waitForPresenceandVisiblity(CreateNonHtmlNoticeBtn);
			waitForElementIsInteractable(CreateNonHtmlNoticeBtn);
			clickByJsExecuter(CreateNonHtmlNoticeBtn);
			waitForPresenceandVisiblity(LabelField);
			waitForElementIsInteractable(LabelField);
			sendKeysWithWait(LabelField, "Non-HTMLabcd");
			waitForElementIsInteractable(CreateNoticeBtn);
			clickByJsExecuter(CreateNoticeBtn);
			waitForCurserRunning(2);

			waitForPresenceandVisiblity(CountNotices);
			refreshPage();
			waitForCurserRunning(2);
			waitForPresenceandVisiblity(CountNotices);
			waitForPresenceandVisiblity(CreateHtmlNoticeBtn);
			waitUntilElementIsVisible(
					By.xpath("//div[@class='sortable-table__body__td'][contains(text(),'" + RandomLabel + "')]"));
			String[] NoticesSplit2 = getTextElement(CountNotices).split(" ");
			String CountText2 = NoticesSplit2[0];
			CurrentNoticesCount = Integer.parseInt(CountText2);
			CompareCountNonHTML = CurrentNoticesCount == (NoticesCountBefore + 2);
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.CompareCountNonHTML, true);
		softAssert.assertAll();
	}

	public void CreateViolationEscalatedNotice(String escalatedNotice, String violationLink, String fAdocument,
			String noticeName) throws InterruptedException {
		forcedWaitTime(4);
		waitForPresenceandVisiblity(CountNotices);
		String[] NoticesSplit = getTextElement(CountNotices).split(" ");
		String CountText = NoticesSplit[0];
		int NoticesCountBefore = Integer.parseInt(CountText);
		waitForElementIsInteractable(CreateHtmlNoticeBtn);
		clickByJsExecuter(CreateHtmlNoticeBtn);
		waitForElementIsInteractable(LabelField);

		if (escalatedNotice.equalsIgnoreCase("Yes")) {
			sendKeysWithWait(LabelField, noticeName);

			waitForElementIsInteractable(CreateVioEscalateNotieYesBtn);
			clickByJsExecuter(CreateVioEscalateNotieYesBtn);
		}

		if (violationLink.equalsIgnoreCase("Yes")) {
			sendKeysWithWait(LabelField, noticeName);
			waitForElementIsInteractable(linkToVioTypes);
			clickByJsExecuter(linkToVioTypes);
			List<WebElement> elements = driver.findElements(By.xpath("//ul//li[@class='multi']//label"));
			for (WebElement ele : elements) {
				forcedWaitTime(1);
				ele.click();
			}

		}

		if (fAdocument.equalsIgnoreCase("Yes")) {
			waitForElementIsInteractable(FADocBtn);
			clickByJsExecuter(FADocBtn);

		}

		waitForElementIsInteractable(CreateVioEscalateNotieYesBtn);
		clickByJsExecuter(CreateVioEscalateNotieYesBtn);
		List<WebElement> elements = driver.findElements(By.xpath("//ul//li[@class='multi']//label"));
		for (WebElement ele : elements) {
			forcedWaitTime(1);
			ele.click();
		}

		WebElement switchFrame = waitUntilVisibleWE(TemplateManagementUtility.IframeBody);
		driver.switchTo().frame(switchFrame);
		waitForElementIsInteractable(TemplateManagementUtility.MessageBody);
		sendKeysWithWait(TemplateManagementUtility.TemplateEmailBodyMsz, noticeName);
		forcedWaitTime(4);
		driver.switchTo().defaultContent();
		forcedWaitTime(4);

		waitForElementIsInteractable(CreateNoticeBtn);
		clickByJsExecuter(CreateNoticeBtn);
		waitForCurserRunning(4);
		forcedWaitTime(3);
		waitForPresenceandVisiblity(CreateHtmlNoticeBtn);
		waitForPresenceandVisiblity(CountNotices);
		forcedWaitTime(2);
		String[] NoticesSplit2 = getTextElement(CountNotices).split(" ");
		String CountText2 = NoticesSplit2[0];
		int NoticesCountAfter = Integer.parseInt(CountText2);
		CompareCountHTML = NoticesCountAfter == (NoticesCountBefore + 1);
	}

	public void AgencySetup_VerifyCreationOfHTMLNotice() throws InterruptedException {

		String escalatedNot = PropertiesUtils.getPropertyValue("EscalatedNotice");
		List<String> EscNotice = Arrays.asList(escalatedNot.split(","));

		String vioLink = PropertiesUtils.getPropertyValue("violationLink");
		List<String> VioLink = Arrays.asList(vioLink.split(","));

		String FADoc = PropertiesUtils.getPropertyValue("FADocument");
		List<String> FADocument = Arrays.asList(FADoc.split(","));

		crmCommonMethod.navigationToNotices();
		for (int i = 0; i < 8; i++) {

			Thread.sleep(4000);
			waitForPresenceandVisiblity(CountNotices);
			String[] NoticesSplit = getTextElement(CountNotices).split(" ");
			String CountText = NoticesSplit[0];
			int NoticesCountBefore = Integer.parseInt(CountText);
			waitForElementIsInteractable(CreateHtmlNoticeBtn);
			clickByJsExecuter(CreateHtmlNoticeBtn);
			String RandomLabel = "HTML " + RandomStrings.requiredCharacters(8);
			waitForElementIsInteractable(LabelField);
			sendKeysWithWait(LabelField, RandomLabel);
			waitUntilElementIsVisible(MergeFieldsLink);
			waitUntilElementIsVisible(MergeFieldsLink);
			waitUntilElementPresent(MergeFieldsLink);
			clickByJsExecuter(MergeFieldsLink);
			waitUntilElementIsVisible(FieldResults);
			clickByJsExecuter(FieldResults);
			waitUntilElementIsVisible(DoneButton);
			clickByJsExecuter(DoneButton);

			waitForElementIsInteractable(CreateNoticeBtn);
			clickByJsExecuter(CreateNoticeBtn);
			waitForCurserRunning(4);
			forcedWaitTime(3);
			waitForPresenceandVisiblity(CreateHtmlNoticeBtn);
			waitForPresenceandVisiblity(CountNotices);
			waitForPresenceandVisiblity(
					By.xpath("//div[@class='sortable-table__body__td'][contains(text(),'" + RandomLabel + "')]"));
			String[] NoticesSplit2 = getTextElement(CountNotices).split(" ");
			String CountText2 = NoticesSplit2[0];
			int NoticesCountAfter = Integer.parseInt(CountText2);
			CompareCountHTML = NoticesCountAfter == (NoticesCountBefore + 1);
		}

		CreateViolationEscalatedNotice(EscNotice.get(0), VioLink.get(1), FADocument.get(1), PropertiesUtils.getPropertyValue("ESCNotice"));
		CreateViolationEscalatedNotice(EscNotice.get(1), VioLink.get(0), FADocument.get(1), PropertiesUtils.getPropertyValue("HTMLMandatoryNotice"));
		CreateViolationEscalatedNotice(EscNotice.get(1), VioLink.get(0), FADocument.get(1), PropertiesUtils.getPropertyValue("VioLinkedFine"));
		CreateViolationEscalatedNotice(EscNotice.get(1), VioLink.get(0), FADocument.get(1), PropertiesUtils.getPropertyValue("HTMLFlatFine"));
		CreateViolationEscalatedNotice(EscNotice.get(1), VioLink.get(0), FADocument.get(0), PropertiesUtils.getPropertyValue("FADocWithFlatFine"));
		CreateViolationEscalatedNotice(EscNotice.get(1), VioLink.get(0), FADocument.get(0), PropertiesUtils.getPropertyValue("VSFineLinkedToFADoc"));
		CreateViolationEscalatedNotice(EscNotice.get(1), VioLink.get(0), FADocument.get(1), PropertiesUtils.getPropertyValue("ViolationSpecificFine"));

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.CompareCountHTML, true);
		softAssert.assertAll();

	}

	public void AgencySetup_VerifyCreationOfFADocument() throws InterruptedException {
		Thread.sleep(4000);
		waitForPresenceandVisiblity(CreateHtmlNoticeBtn);
		waitForElementIsInteractable(CreateHtmlNoticeBtn);
		clickByJsExecuter(CreateHtmlNoticeBtn);
		waitForPresenceandVisiblity(FADocumentToggle);
		waitForElementIsInteractable(FADocumentToggle);
		clickByJsExecuter(FADocumentToggle);
		forcedWaitTime(3);
		String RandomLabel = "FA Doc " + RandomStrings.requiredCharacters(8);
		waitForPresenceandVisiblity(LabelField);
		sendKeysWithWait(LabelField, RandomLabel);
		clickByJsExecuter(MergeFieldsLink);
		waitForElementIsInteractable(FieldResults);
		clickByJsExecuter(FieldResults);
		waitForElementIsInteractable(DoneButton);
		clickByJsExecuter(DoneButton);
		waitForCurserRunning(4);
		waitForElementIsInteractable(CreateNoticeBtn);
		clickByJsExecuter(CreateNoticeBtn);
		waitForCurserRunning(8);
		waitForPresenceandVisiblity(CountNotices);
		waitForPresenceandVisiblity(
				By.xpath("//div[@class='sortable-table__body__td'][contains(text(),'" + RandomLabel + "')]"));
		String[] NoticesSplit2 = getTextElement(CountNotices).split(" ");
		String CountText2 = NoticesSplit2[0];
		int NoticesCountAfter = Integer.parseInt(CountText2);
		CompareCountFADoc = NoticesCountAfter == (CurrentNoticesCount + 1);

		forcedWaitTime(3);

		// Add more FA Notice For Pre-requisite
		ceCommonMethod.creationCustomeFANotices(PropertiesUtils.getPropertyValue("HTMLFADoc"),
				PropertiesUtils.getPropertyValue("FANoticeMergeField"));
		forcedWaitTime(3);
		ceCommonMethod.creationCustomeFANotices(PropertiesUtils.getPropertyValue("HTMLmuniCodeResolutionImg"),
				PropertiesUtils.getPropertyValue("FAMuniCode"));
		forcedWaitTime(3);

		for (int i = 0; i < 10; i++) {
			String fADocumentName = "HTML FA " + RandomStrings.requiredString(6);
			ceCommonMethod.creationCustomeFANotices(fADocumentName,
					PropertiesUtils.getPropertyValue("FANoticeMergeField"));
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(AppPreRequisiteUtility.CompareCountFADoc, true);
		softAssert.assertAll();
	}

	public void AgencySetup_VerifyCreationOfCategories() throws InterruptedException {

		String ChckBox = PropertiesUtils.getPropertyValue("checkbox");
		List<String> checkBox = Arrays.asList(ChckBox.split(","));

		String incLoc = PropertiesUtils.getPropertyValue("IncludeLocation");
		List<String> Includelocation = Arrays.asList(incLoc.split(","));

		String Keyword = PropertiesUtils.getPropertyValue("Keywords");
		List<String> KeyWords = Arrays.asList(Keyword.split(","));

		refreshPage();
		waitForCurserRunning(8);
		crmCommonMethod.navigateToAgencySetup();
		scrollIntoView(CRMProdSideBar);

		if (!driver.findElement(CategoriesSideBar).isDisplayed()) {
			waitForElementIsInteractable(CRMProdSideBar);
			clickByJsExecuter(CRMProdSideBar);
		}

		waitForPresenceandVisiblity(CategoriesSideBar);
		scrollIntoView(CategoriesSideBar);
		waitForElementIsInteractable(CategoriesSideBar);
		clickByJsExecuter(CategoriesSideBar);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);

		// Add more 3 category to complete the pre-requisite for the CE and CRM
		for (int i = 0; i < 3; i++) {
			String categoryName = "Category " + RandomStrings.requiredString(5);
			crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(1), Includelocation.get(0), KeyWords.get(0), categoryName);
		}

		// Add more 3 category to complete the pre-requisite for the CE and CRM
		for (int i = 0; i < 3; i++) {
			String categoryName = "Category " + RandomStrings.requiredString(5);
			crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(1), Includelocation.get(1), KeyWords.get(0), categoryName);
		}

		// Mandatory Category for the CRM and CRM External
		waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
		crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(1), Includelocation.get(0), KeyWords.get(0), PropertiesUtils.getPropertyValue("LocationNotRequired"));
		crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(0), Includelocation.get(0), KeyWords.get(0), PropertiesUtils.getPropertyValue("LocationReq"));
		crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(1), Includelocation.get(1), KeyWords.get(0), PropertiesUtils.getPropertyValue("LocationNotIncluded"));
		crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(1),Includelocation.get(0),KeyWords.get(0),PropertiesUtils.getPropertyValue("CascadingInactive"));
		crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(1),Includelocation.get(0),KeyWords.get(0),PropertiesUtils.getPropertyValue("DeptCategory"));
		crmCommonMethod.createCasCategoryAppPreRequisite(checkBox.get(1),Includelocation.get(0),KeyWords.get(0),PropertiesUtils.getPropertyValue("CascadingCategory"));

//		 Add more 3 category to complete the pre-requisite for the CE and CRM
		for (int i = 0; i < 3; i++) {
			String categoryName = "Category " + RandomStrings.requiredString(5);
			crmCommonMethod.createCategoryAppPrerequisute(checkBox.get(0), Includelocation.get(0), KeyWords.get(0), categoryName);
		}



		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();
	}

	public void AgencySetup_VerifySavedSubmissionSettings() throws InterruptedException {

		refreshPage();
		waitForCurserRunning(8);
		crmCommonMethod.navigateToAgencySetup();
		waitForPresenceandVisiblity(CRMProdSideBar);
		if (!driver.findElement(SubmissionSettingsSideBar).isDisplayed()) {
			waitForPresenceandVisiblity(CRMProdSideBar);
			scrollIntoView(CRMProdSideBar);
			waitForElementIsInteractable(CRMProdSideBar);
			clickByJsExecuter(CRMProdSideBar);
			waitForPresenceandVisiblity(SubmissionSettingsSideBar);

		}
		waitForPresenceandVisiblity(SubmissionSettingsSideBar);
		scrollIntoView(SubmissionSettingsSideBar);
		clickByJsExecuter(SubmissionSettingsSideBar);
		waitForPresenceandVisiblity(SubmissionSettingsUtility.NoToggle1);
		scrollIntoView(SubmissionSettingsUtility.NoToggle1);
		waitForElementIsInteractable(SubmissionSettingsUtility.NoToggle1);
		clickByJsExecuter(SubmissionSettingsUtility.NoToggle1);
		scrollIntoView(SubmissionSettingsUtility.YesToggle2);
		waitForElementIsInteractable(SubmissionSettingsUtility.YesToggle2);
		clickByJsExecuter(SubmissionSettingsUtility.YesToggle2);
		waitForElementIsInteractable(SaveChangesButton);
		clickByJsExecuter(SaveChangesButton);
		waitForCurserRunning(4);
		waitForPresenceandVisiblity(SubmissionSettingsUtility.NoToggle1);
		String GetClassT1 = findElement(SubmissionSettingsUtility.NoToggle1).getAttribute("class");
		ToggleButtonState1 = GetClassT1.equals("square-btn btn btn-primary");
		String GetClassT2 = findElement(SubmissionSettingsUtility.YesToggle2).getAttribute("class");
		ToggleButtonState2 = GetClassT2.equals("square-btn btn btn-primary");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(AppPreRequisiteUtility.ToggleButtonState1);
		softAssert.assertTrue(AppPreRequisiteUtility.ToggleButtonState2);
		softAssert.assertAll();
	}

	public void AgencySetup_VerifySuccessfulDirectionToCCP() throws InterruptedException {
		waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
		scrollIntoView(CSPInternalUtility.PlusIconToCRM);
		waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
		clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);

		waitForPresenceandVisiblity(CodeEnforcementOption);
		waitForElementIsInteractable(CodeEnforcementOption);
		clickByJsExecuter(CodeEnforcementOption);

		waitForCurserRunning(8);
		waitForPresenceandVisiblity(CreateACasePopupTitle);
		List<WebElement> CCPHeader = driver.findElements(CreateACasePopupTitle);
		CCPStatus = CCPHeader.size() == 1;
		waitForPresenceandVisiblity(CancelButton);
		scrollIntoView(CancelButton);
		waitForElementIsInteractable(CancelButton);
		clickByJsExecuter(CancelButton);
		waitForCurserRunning(4);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(AppPreRequisiteUtility.CCPStatus);
		softAssert.assertAll();
	}

	public void AgencySetup_VerifyCreationOf50PlusCases() throws InterruptedException {

		for (int i = 0; i <= 50; i++) {
			ceCommonMethod.createCaseCCP();
			clickByJsExecuter(CloseCaseUtility.CloseCDPIcon);

		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void AgencySetup_VerifyCreationOf50PlusSubmissions() throws InterruptedException {

		String paraonymous = PropertiesUtils.getPropertyValue("Anonymous");
		List<String> anonymous = Arrays.asList(paraonymous.split(","));

		String paracust = PropertiesUtils.getPropertyValue("Customer");
		List<String> customer = Arrays.asList(paracust.split(","));

		String paratags = PropertiesUtils.getPropertyValue("Tags");
		List<String> tags = Arrays.asList(paratags.split(","));

		String paralocation = PropertiesUtils.getPropertyValue("Location");
		List<String> location = Arrays.asList(paralocation.split(","));

		String parattachments = PropertiesUtils.getPropertyValue("Attachments");
		List<String> attachments = Arrays.asList(parattachments.split(","));

		for (int i = 0; i <= 50; i++) {
			crmCommonMethod.createSubmissionPreRequisite(anonymous.get(1), customer.get(0), tags.get(1), location.get(1), attachments.get(1), PropertiesUtils.getPropertyValue("LocationNotRequired"));
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void AgencySetup_VerifyCaseCreationWithEntityViolation() throws InterruptedException {

		int CheckCancel = driver.findElements(CSPInternalUtility.CancelCreateCase).size();
		if (CheckCancel > 0) {
			waitForPresenceandVisiblity(CSPInternalUtility.CancelCreateCase);
			scrollIntoView(CSPInternalUtility.CancelCreateCase);
			waitForElementIsInteractable(CSPInternalUtility.CancelCreateCase);
			clickByJsExecuter(CSPInternalUtility.CancelCreateCase);

		}
		int CancelSubmission = driver.findElements(CSPInternalUtility.CloseSubmissionIcon).size();
		if (CancelSubmission > 0) {
			waitForPresenceandVisiblity(CSPInternalUtility.CloseSubmissionIcon);
			scrollIntoView(CSPInternalUtility.CloseSubmissionIcon);
			waitForElementIsInteractable(CSPInternalUtility.CloseSubmissionIcon);
			clickByJsExecuter(CSPInternalUtility.CloseSubmissionIcon);

		}
		int CreateCaseCheck = driver.findElements(CSPInternalUtility.PlusIconToCRM).size();
		if (CreateCaseCheck > 0) {
			waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
			scrollIntoView(CSPInternalUtility.PlusIconToCRM);
			waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
			clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
			waitForPresenceandVisiblity(CodeEnforcementOption);
			waitForElementIsInteractable(CodeEnforcementOption);
			clickByJsExecuter(CodeEnforcementOption);

		}

		crmCommonMethod.addLocation();
		crmCommonMethod.addContact();
		waitForPresenceandVisiblity(CCPUtility.ViolationSearchBox);
		clickByJsExecuter(CCPUtility.ViolationSearchBox);
		waitForPresenceandVisiblity(CCPUtility.ViolationSearchBox);
		sendKeysWithWait(CCPUtility.ViolationSearchBox, PropertiesUtils.getPropertyValue("AnimalViolation"));
		waitForPresenceandVisiblity(CCPUtility.ViolationsList);
		clickByJsExecuter(CCPUtility.ViolationsList);
		waitForPresenceandVisiblity(CCPUtility.AnimalColourField);
		sendKeysWithWait(CCPUtility.AnimalColourField, PropertiesUtils.getPropertyValue("Black"));
		waitForPresenceandVisiblity(PerformInspectionUtility.AddButtonViolation);
		clickByJsExecuter(PerformInspectionUtility.AddButtonViolation);
		waitForPresenceandVisiblity(PerformInspectionUtility.AddanotherAnimalLinkText);
		clickByJsExecuter(PerformInspectionUtility.AddanotherAnimalLinkText);
		waitForPresenceandVisiblity(CCPUtility.AnimalColourField);
		sendKeysWithWait(CCPUtility.AnimalColourField, PropertiesUtils.getPropertyValue("White"));
		waitForPresenceandVisiblity(PerformInspectionUtility.AddButtonViolation);
		clickByJsExecuter(PerformInspectionUtility.AddButtonViolation);
		waitForPresenceandVisiblity(CCPUtility.CreateCaseButton);
		clickByJsExecuter(CCPUtility.CreateCaseButton);
		/*
		 * waitForPresenceandVisiblity(CCPUtility.AssignCaseTo);
		 * clickByJsExecuter(CCPUtility.AssignCaseTo);
		 * waitForPresenceandVisiblity(CCPUtility.InspectionAssigneeTo);
		 * clickByJsExecuter(CCPUtility.InspectionAssigneeTo);
		 */
		waitForCurserRunning(4);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvStage"))) {
			ceCommonMethod.selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCRMUser"));
			ceCommonMethod.selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("MarkShane"));
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase(PropertiesUtils.getPropertyValue("RunEnvProd"))) {
			ceCommonMethod.selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCRMUser"));
			ceCommonMethod.selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("AmandeepSingh"));

		} else {
			ceCommonMethod.selectCaseAssineCCP(PropertiesUtils.getPropertyValue("AgencyCRMUser"));
			ceCommonMethod.selectInspectionAssineCCP(PropertiesUtils.getPropertyValue("Shane"));
		}
		waitForPresenceandVisiblity(CCPUtility.CreateScheduleInspectionButton);
		clickByJsExecuter(CCPUtility.CreateScheduleInspectionButton);
		waitForPresenceandVisiblity(CloseCaseUtility.CloseCDPIcon);
		clickByJsExecuter(CloseCaseUtility.CloseCDPIcon);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();

	}

	public String CreateFineText;
	public int CloseCreateFinePOpup;

	public void AgencySetup_VerifyCreateFinePopup() throws InterruptedException {

		refreshPage();
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToFines();
		waitUntilElementIsVisible(CreateFineBtn);
		scrollIntoView(CreateFineBtn);
		clickByJsExecuter(CreateFineBtn);
		waitForPresenceandVisiblity(CreateFinePopup);
		CreateFineText = getTextElement(CreateFinePopup);
		scrollIntoView(CancelCreateFine);
		clickByJsExecuter(CancelCreateFine);
		waitUntilElementInvisibleLocated(CancelCreateFine);
		CloseCreateFinePOpup = driver.findElements(CreateFinePopup).size();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CreateFineText, "Create Fine");
		softAssert.assertEquals(CloseCreateFinePOpup, 0);
		softAssert.assertAll();

	}

	public String ActualCrtFineLabelValidMsg;
	public String ActualCrtFineDefaultAmntValidMsg;

	public String ExpectedCrtFineLabelValidMsg = PropertiesUtils.getPropertyValue("labelreq");
	public String ExpectedCrtFineDefaultAmntValidMsg = PropertiesUtils.getPropertyValue("NumberShouldbeGreaterThan0");

	public String ActualNoticeRequiresValidMsg;
	public String ExpectedNoticeRequiresValidMsg = PropertiesUtils.getPropertyValue("noticeReq");

	public String labelName;
	public String DefaultFineAmount;
	public int BeforActiveFines;
	public int AfterActiveFines;

	public void create_FlatFineNoNoticesViolationAttached(String flatFineName, String amount)
			throws InterruptedException {

		String ActiveFinesVal = (getTextElement(ActiveFines).split(" "))[0];
		BeforActiveFines = Integer.parseInt(ActiveFinesVal);
		scrollIntoView(CreateFineBtn);
		waitForPresenceandVisiblity(CreateFineBtn);
		clickByJsExecuter(CreateFineBtn);
		waitUntilElementIsVisible(DoNotAttachedNoticeChk);
		forcedWaitTime(2);
		clickByJsExecuter(DoNotAttachedNoticeChk);
		clickByJsExecuter(CreateFinePopUpbtn);
		forcedWaitTime(3);
		waitForPresenceandVisiblity(CrtFineLabelValidMsg);
		ActualCrtFineLabelValidMsg = getTextElement(CrtFineLabelValidMsg);
		ActualCrtFineDefaultAmntValidMsg = getTextElement(CrtFineDefaultAmountValidMsg);
		sendKeysWithWait(CrtFineLabelName, flatFineName);
		sendKeysWithWait(CrtDefaultAmnt, amount);
		clickByJsExecuter(CreateFinePopUpbtn);
		waitUntilElementInvisibleLocated(CreateFinePopUpbtn);
		waitForPresenceandVisiblity(ActiveFines);
		AfterActiveFines = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualCrtFineLabelValidMsg, ExpectedCrtFineLabelValidMsg);
		softAssert.assertEquals(ActualCrtFineDefaultAmntValidMsg, ExpectedCrtFineDefaultAmntValidMsg);
		softAssert.assertEquals(BeforActiveFines + 1, AfterActiveFines);
		softAssert.assertAll();

	}

	public void 	create_FlatFineAttachedNotices(String flatFineName, String amount, String noticeName)
			throws InterruptedException {

		String ActiveFinesVal = (getTextElement(ActiveFines).split(" "))[0];
		BeforActiveFines = Integer.parseInt(ActiveFinesVal);
		waitForPresenceandVisiblity(CreateFineBtn);
		scrollIntoView(CreateFineBtn);
		waitForElementIsInteractable(CreateFineBtn);
		clickByJsExecuter(CreateFineBtn);
		scrollIntoView(CreateFinePopUpbtn);
		waitForPresenceandVisiblity(CreateFinePopUpbtn);
		waitForElementIsInteractable(CreateFinePopUpbtn);
		clickByJsExecuter(CreateFinePopUpbtn);
		waitForPresenceandVisiblity(CrtFineNoticeRequiredValidMsg);
		ActualNoticeRequiresValidMsg = getTextElement(CrtFineNoticeRequiredValidMsg);
		sendKeysWithWait(CrtFineLabelName, flatFineName);
		sendKeysWithWait(CrtDefaultAmnt, amount);
		waitForPresenceandVisiblity(CrtFineSelectNoitce);
		clickByJsExecuter(CrtFineSelectNoitce);
		try {
			waitUntilElementIsVisible(CrtFineSelectNoitce);
		} catch (Exception e) {
			clickOn(CrtFineSelectNoitce);
		}
		scrollIntoView(By.xpath(stringFormat(attachedNotice, noticeName)));
		waitForPresenceandVisiblity(By.xpath(stringFormat(attachedNotice, noticeName)));
		clickByJsExecuter(By.xpath(stringFormat(attachedNotice, noticeName)));
		waitForPresenceandVisiblity(CrtFineApplyNotices);
		clickByJsExecuter(CrtFineApplyNotices);
		waitForElementIsInteractable(CreateFinePopUpbtn);
		clickByJsExecuter(CreateFinePopUpbtn);
		waitForPresenceandVisiblity(ActiveFines);
		AfterActiveFines = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualNoticeRequiresValidMsg, ExpectedNoticeRequiresValidMsg);
		softAssert.assertEquals(BeforActiveFines, AfterActiveFines);
		softAssert.assertAll();

	}

	public void CreationViolationSpecificOnlyFine(String violationFineName, String amount, boolean attachednotice,
			boolean linkViolation, String noticeName, String violations) throws InterruptedException {


		FinesUtility fines = new FinesUtility(driver);
		String ActiveFinesVal = (getTextElement(ActiveFines).split(" "))[0];
		BeforActiveFines = Integer.parseInt(ActiveFinesVal);
		waitForPresenceandVisiblity(CreateFineBtn);
		scrollIntoView(CreateFineBtn);
		waitForElementIsInteractable(CreateFineBtn);
		clickByJsExecuter(CreateFineBtn);
		waitForPresenceandVisiblity(CreateFinePopUpbtn);
		waitForElementIsInteractable(CreateFinePopUpbtn);
		fines.selectViolationSpecifcToggelButton();

		String ViolationfineName = fines.setCustomefineName(violationFineName);
		fines.setValueInDefaultAmountField(amount);
		if (attachednotice) {
			fines.SelectNoticeAndFAdocument(noticeName);

		}

		if (linkViolation && !attachednotice) {
			fines.SelectViolationSpecification(violations);
			clickByJsExecuter(DoNotAttachedNoticeChk);

		}

		fines.clickCreateFineButtonOnCreateFinePage();
		waitUntilElementInvisibleLocated(CreateFinePopUpbtn);
		String actualCreatedFine = fines.getCreatedFineText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ViolationfineName, actualCreatedFine, PropertiesUtils.getPropertyValue("FineNotCreated"));
		softAssert.assertAll();
	}

	public void AgencySetup_VerifyFlatFineCreationDoNotAttachedNotices() throws InterruptedException {

		String ActiveFinesVal = (getTextElement(ActiveFines).split(" "))[0];
		BeforActiveFines = Integer.parseInt(ActiveFinesVal);
		scrollIntoView(CreateFineBtn);
		waitForPresenceandVisiblity(CreateFineBtn);
		clickByJsExecuter(CreateFineBtn);
		waitUntilElementIsVisible(DoNotAttachedNoticeChk);
		forcedWaitTime(2);
		// waitForElementIsInteractable(DoNotAttachedNoticeChk);
		clickByJsExecuter(DoNotAttachedNoticeChk);
		forcedWaitTime(1);
		clickByJsExecuter(CreateFinePopUpbtn);
		forcedWaitTime(4);
		waitForPresenceandVisiblity(CrtFineLabelValidMsg);
		ActualCrtFineLabelValidMsg = getTextElement(CrtFineLabelValidMsg);
		ActualCrtFineDefaultAmntValidMsg = getTextElement(CrtFineDefaultAmountValidMsg);
		labelName = RandomStrings.requiredString(3) + "Fine";
		sendKeysWithWait(CrtFineLabelName, labelName);
		DefaultFineAmount = RandomStrings.requiredDigits(4);
		sendKeysWithWait(CrtDefaultAmnt, DefaultFineAmount);
		clickByJsExecuter(CreateFinePopUpbtn);
		waitUntilElementInvisibleLocated(CreateFinePopUpbtn);
		waitForPresenceandVisiblity(ActiveFines);
		AfterActiveFines = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualCrtFineLabelValidMsg, ExpectedCrtFineLabelValidMsg);
		softAssert.assertEquals(ActualCrtFineDefaultAmntValidMsg, ExpectedCrtFineDefaultAmntValidMsg);
		softAssert.assertEquals(BeforActiveFines + 1, AfterActiveFines);
		softAssert.assertAll();

		create_FlatFineNoNoticesViolationAttached(PropertiesUtils.getPropertyValue("FlatFIneWithNoNoticeOrFA"), PropertiesUtils.getPropertyValue("Amount"));

	}

	public void AgencySetup_VerifyFlatFineCreationAttachedNotices() throws InterruptedException {

		String ActiveFinesVal = (getTextElement(ActiveFines).split(" "))[0];
		BeforActiveFines = Integer.parseInt(ActiveFinesVal);
		waitForPresenceandVisiblity(CreateFineBtn);
		scrollIntoView(CreateFineBtn);
		waitForElementIsInteractable(CreateFineBtn);
		clickByJsExecuter(CreateFineBtn);
		waitForPresenceandVisiblity(CreateFinePopUpbtn);
		waitForElementIsInteractable(CreateFinePopUpbtn);
		clickByJsExecuter(CreateFinePopUpbtn);
		waitForPresenceandVisiblity(CrtFineNoticeRequiredValidMsg);
		ActualNoticeRequiresValidMsg = getTextElement(CrtFineNoticeRequiredValidMsg);
		labelName = RandomStrings.requiredString(3) + "Fine";
		sendKeysWithWait(CrtFineLabelName, labelName);
		DefaultFineAmount = RandomStrings.requiredDigits(4);
		sendKeysWithWait(CrtDefaultAmnt, DefaultFineAmount);
		Thread.sleep(2000);
		waitForPresenceandVisiblity(CrtFineSelectNoitce);
		clickOn(CrtFineSelectNoitce);
		Thread.sleep(1000);
		scrollIntoView(CrtFineCheckHtmlNotice1);
		Thread.sleep(2000);
		waitForElementIsInteractable(CrtFineCheckHtmlNotice1);
		clickOn(CrtFineCheckHtmlNotice1);
		waitForPresenceandVisiblity(CrtFineApplyNotices);
		clickByJsExecuter(CrtFineApplyNotices);
		waitForElementIsInteractable(CreateFinePopUpbtn);
		clickByJsExecuter(CreateFinePopUpbtn);
		waitUntilElementInvisibleLocated(CreateFinePopUpbtn);
		waitForPresenceandVisiblity(ActiveFines);
		forcedWaitTime(3);
		AfterActiveFines = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualNoticeRequiresValidMsg, ExpectedNoticeRequiresValidMsg);
		softAssert.assertEquals(BeforActiveFines + 1, AfterActiveFines);
		softAssert.assertAll();

		create_FlatFineAttachedNotices(PropertiesUtils.getPropertyValue("HTMLMandatoryNotice"), PropertiesUtils.getPropertyValue("Amount"), PropertiesUtils.getPropertyValue("HTMLMandatoryNotice"));
		create_FlatFineAttachedNotices(PropertiesUtils.getPropertyValue("FlatFinewithFA"), PropertiesUtils.getPropertyValue("Amount"), PropertiesUtils.getPropertyValue("FADocWithFlatFine"));
		create_FlatFineAttachedNotices(PropertiesUtils.getPropertyValue("FlatFineWithNotice"), PropertiesUtils.getPropertyValue("Amount"), PropertiesUtils.getPropertyValue("HTMLFlatFine"));
		create_FlatFineAttachedNotices(PropertiesUtils.getPropertyValue("VSFineLinkedToFADoc"), PropertiesUtils.getPropertyValue("Amount"), PropertiesUtils.getPropertyValue("VSFineLinkedToFADoc"));

	}

	public String LabelValBefore;
	public String labelNameAfter;
	public String DefltAmtAfter;
	public String DefltAmtBefore;
	public String EditedLabelName;
	public String EditedDefAmt;

	public void AgencySetup_VerifyFlatFineEdit() throws InterruptedException {

		waitForPresenceandVisiblity(EditActiveFine);
		scrollIntoView(EditActiveFine);
		clickByJsExecuter(EditActiveFine);
		waitForPresenceandVisiblity(CrtFineLabelName);
		waitForElementIsInteractable(CrtFineLabelName);
		forcedWaitTime(2);
		LabelValBefore = driver.findElement(CrtFineLabelName).getAttribute("value");
		labelNameAfter = RandomStrings.requiredString(3) + "FineEdited";
		clearByJSE(CrtFineLabelName);
		waitForElementIsInteractable(CrtFineLabelName);
		forcedWaitTime(2);
		driver.findElement(CrtFineLabelName).sendKeys(labelNameAfter);
		// SendKeys(CrtFineLabelName, labelNameAfter);
		DefltAmtAfter = RandomStrings.requiredDigits(2);
		clearElement(CrtDefaultAmnt);
		sendKeysWithWait(CrtDefaultAmnt, DefltAmtAfter);
		DefltAmtAfter = driver.findElement(CrtDefaultAmnt).getAttribute("value");
		waitForElementIsInteractable(EditSavebtn);
		clickByJsExecuter(EditSavebtn);
		waitForCurserRunning(2);
		waitUntilElementInvisibleLocated(EditSavebtn);
		waitForPresenceandVisiblity(CreateFineGridValLable);
		EditedLabelName = getTextElement(CreateFineGridValLable);
		EditedDefAmt = getTextElement(CrtFineGridDefAmt);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(labelNameAfter.trim(), EditedLabelName.trim());
		softAssert.assertAll();

	}

	public int InactivefineCountBefore;
	public int InactivefineCountafter;
	public String activeFineLabel;
	public Boolean inactiveFineLabel;

	public void AgencySetup_VerifyInactivateActiveFines() throws InterruptedException {

		waitForPresenceandVisiblity(EditActiveFine);
		InactivefineCountBefore = Integer.parseInt((getTextElement(InactiveFines)).split(" ")[0]);
		scrollIntoView(EditActiveFine);
		waitForElementIsInteractable(EditActiveFine);
		clickByJsExecuter(EditActiveFine);
		activeFineLabel = driver.findElement(CrtFineLabelName).getAttribute("value");
		waitForPresenceandVisiblity(InactiveFinebtn);
		scrollIntoView(InactiveFinebtn);
		waitForElementIsInteractable(InactiveFinebtn);
		forcedWaitTime(2);
		clickByJsExecuter(InactiveFinebtn);
		scrollIntoView(EditSavebtn);
		waitForElementIsInteractable(EditSavebtn);
		clickByJsExecuter(EditSavebtn);
		waitUntilElementInvisibleLocated(EditSavebtn);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(InactiveFines);
		forcedWaitTime(2);
		List<String> allinactiveFineLabels = new ArrayList<>();
		InactivefineCountafter = Integer.parseInt((getTextElement(InactiveFines)).split(" ")[0]);
		driver.findElements(InactiveFineGridData).stream().forEach(x -> allinactiveFineLabels.add(x.getText()));
		inactiveFineLabel = allinactiveFineLabels.contains(activeFineLabel);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(InactivefineCountBefore + 1, InactivefineCountafter);
		softAssert.assertEquals(inactiveFineLabel, Boolean.TRUE);
		softAssert.assertAll();

	}

	public int activefineCountBefore;
	public int activefineCountafter;
	public String InactiveFineLabel;
	public Boolean ActiveFineLabel;

	public void AgencySetup_VerifyActivateInactiveFines() throws InterruptedException {

		waitForPresenceandVisiblity(ActiveFines);
		scrollIntoView(ActiveFines);
		waitForElementIsInteractable(EditInactiveFine);
		activefineCountBefore = Integer.parseInt((getTextElement(ActiveFines)).split(" ")[0]);
		clickByJsExecuter(EditInactiveFine);
		forcedWaitTime(4);
		waitForPresenceandVisiblity(CrtFineLabelName);
		InactiveFineLabel = driver.findElement(CrtFineLabelName).getAttribute("value");
		scrollIntoView(ActiveFinetoogle);
		waitForElementIsInteractable(ActiveFinetoogle);
		clickByJsExecuter(ActiveFinetoogle);
		waitForElementIsInteractable(EditSavebtn);
		clickByJsExecuter(EditSavebtn);
		waitUntilElementInvisibleLocated(EditSavebtn);
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(ActiveFines);
		forcedWaitTime(2);
		scrollIntoView(ActiveFines);
		List<String> allactiveFineLabels = new ArrayList<>();
		activefineCountafter = Integer.parseInt((getTextElement(ActiveFines)).split(" ")[0]);
		driver.findElements(ActiveFineGridData).stream().forEach(x -> allactiveFineLabels.add(x.getText()));
		ActiveFineLabel = allactiveFineLabels.contains(InactiveFineLabel);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(activefineCountBefore + 1, activefineCountafter);
		softAssert.assertEquals(ActiveFineLabel, Boolean.TRUE);
		softAssert.assertAll();

	}

	public String ActualcreateLateFeePOp;
	public String ExpectedCreateLateFeePopup = "Create Late Fee";
	public int CloseCreateLateFeePOpup;
	public String ExpectedCrtLateFeeLabelValidMsg = PropertiesUtils.getPropertyValue("labelreq");
	public String ActualCrtLateFeeLabelValidMsg;

	public void AgencySetup_VerifyOpenCloseCreateLateFeePopup() throws InterruptedException {

		crmCommonMethod.navigateToLateFeesSubTab();
		scrollIntoView(CreateLateFeebtn);
		clickByJsExecuter(CreateLateFeebtn);
		waitUntilElementIsVisible(CreateLateFeePopupText);
		ActualcreateLateFeePOp = getTextElement(CreateLateFeePopupText);
		scrollIntoView(CreateLateFeebtnpopup);
		clickByJsExecuter(CreateLateFeebtnpopup);
		forcedWaitTime(3);
		waitUntilElementIsVisible(CrtFineLabelValidMsg);
		scrollIntoView(CrtFineLabelValidMsg);
		ActualCrtLateFeeLabelValidMsg = getTextElement(CrtFineLabelValidMsg);
		scrollIntoView(CancelButton);
		clickByJsExecuter(CancelButton);
		waitUntilElementInvisibleLocated(CancelButton);
		CloseCreateLateFeePOpup = driver.findElements(CreateFinePopup).size();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualcreateLateFeePOp, ExpectedCreateLateFeePopup);
		softAssert.assertEquals(CloseCreateLateFeePOpup, 0);
		softAssert.assertEquals(ActualCrtLateFeeLabelValidMsg, ExpectedCrtLateFeeLabelValidMsg);
		softAssert.assertAll();

	}

	public String LateFeeLabel;
	public String LateFeeLabelDesc;
	public String LateFeeAmount;
	public String PayDueAfterDay;
	public int AfterActiveLateFeeCount;
	public int BeforeActiveLateFeeCount;
	public Boolean NewAddedLateFeeLable;

	public void AgencySetup_VerifyCreateFixedManualFlatFineLateFee() throws InterruptedException {

		crmCommonMethod.navigateToLateFeesSubTab();
		BeforeActiveLateFeeCount = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);
		scrollIntoView(CreateLateFeebtn);

		clickByJsExecuter(CreateLateFeebtn);

		LateFeeLabel = RandomStrings.requiredCharacters(3) + " LateFine";
		sendKeysWithWait(CrtLateFineLabelName, LateFeeLabel);

		LateFeeLabelDesc = RandomStrings.requiredCharacters(3) + " LateFineDesc";
		sendKeysWithWait(CrtLateFineLabeldesc, LateFeeLabelDesc);

		clickByJsExecuter(CrtLateFeeManualToggle);

		clickByJsExecuter(CrtLateFeeFlatToggle);

		clickByJsExecuter(CrtLateFeeFixedAmtToggle);

		scrollIntoView(CrtLateFeeAmount);

		LateFeeAmount = RandomStrings.requiredDigits(4);
		sendKeysWithWait(CrtLateFeeAmount, LateFeeAmount);
		PayDueAfterDay = RandomStrings.requiredDigits(1);

		sendKeysWithWait(AfterDayLateFeePayDue, PayDueAfterDay);

		clickByJsExecuter(CreateLateFeebtnpopup);
		waitUntilElementInvisibleLocated(CreateLateFeebtnpopup);
		forcedWaitTime(2);
		AfterActiveLateFeeCount = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);

		List<String> allactiveLateFeeLabels = new ArrayList<>();
		driver.findElements(ActiveFineGridData).stream().forEach(x -> allactiveLateFeeLabels.add(x.getText()));

		NewAddedLateFeeLable = allactiveLateFeeLabels.contains(LateFeeLabel);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(BeforeActiveLateFeeCount + 1, AfterActiveLateFeeCount);
		softAssert.assertEquals(NewAddedLateFeeLable, Boolean.TRUE);
		softAssert.assertAll();

	}

	public void AgencySetup_VerifyCreateOutStdManualFlatFineLateFee() throws InterruptedException {

		crmCommonMethod.navigateToLateFeesSubTab();
		BeforeActiveLateFeeCount = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);
		scrollIntoView(CreateLateFeebtn);
		clickByJsExecuter(CreateLateFeebtn);
		LateFeeLabel = RandomStrings.requiredCharacters(3) + " LateFine";
		sendKeysWithWait(CrtLateFineLabelName, LateFeeLabel);
		LateFeeLabelDesc = RandomStrings.requiredCharacters(3) + " LateFineDesc";
		sendKeysWithWait(CrtLateFineLabeldesc, LateFeeLabelDesc);
		clickByJsExecuter(CrtLateFeeManualToggle);
		clickByJsExecuter(CrtLateFeeFlatToggle);
		clickByJsExecuter(CrtLateFeeOutstdBalToggle);
		scrollIntoView(CrtLateFeeAmount);
		LateFeeAmount = RandomStrings.requiredDigits(4);
		sendKeysWithWait(CrtLateFeeAmount, LateFeeAmount);
		PayDueAfterDay = RandomStrings.requiredDigits(1);
		sendKeysWithWait(AfterDayLateFeePayDue, PayDueAfterDay);
		clickByJsExecuter(CreateLateFeebtnpopup);
		waitUntilElementInvisibleLocated(CreateLateFeebtnpopup);
		forcedWaitTime(2);
		AfterActiveLateFeeCount = Integer.parseInt((getTextElement(ActiveFines).split(" "))[0]);
		List<String> allactiveLateFeeLabels = new ArrayList<>();
		driver.findElements(ActiveFineGridData).stream().forEach(x -> allactiveLateFeeLabels.add(x.getText()));
		NewAddedLateFeeLable = allactiveLateFeeLabels.contains(LateFeeLabel);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(BeforeActiveLateFeeCount + 1, AfterActiveLateFeeCount);
		softAssert.assertEquals(NewAddedLateFeeLable, Boolean.TRUE);
		softAssert.assertAll();

	}

	public int InactiveLateFeeCountBefore;
	public int InactiveLateFeeCountafter;
	public String activeLateFeeLabel;
	public Boolean inactiveLateFeeLabel;

	public void AgencySetup_VerifyInactivateActiveLateFee() throws InterruptedException {

		crmCommonMethod.navigateToLateFeesSubTab();
		InactiveLateFeeCountBefore = Integer.parseInt((getTextElement(InactiveFines)).split(" ")[0]);
		clickByJsExecuter(EditActiveFine);
		forcedWaitTime(2);
		activeLateFeeLabel = driver.findElement(CrtFineLabelName).getAttribute("value");
		scrollIntoView(InactiveFinebtn);

		clickByJsExecuter(InactiveFinebtn);

		clickByJsExecuter(EditSavebtn);
		waitUntilElementInvisibleLocated(EditSavebtn);
		forcedWaitTime(2);
		List<String> allinactiveFineLabels = new ArrayList<>();
		InactiveLateFeeCountafter = Integer.parseInt((getTextElement(InactiveFines)).split(" ")[0]);
		driver.findElements(InactiveFineGridData).stream().forEach(x -> allinactiveFineLabels.add(x.getText()));

		inactiveLateFeeLabel = allinactiveFineLabels.contains(activeLateFeeLabel);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(InactiveLateFeeCountBefore + 1, InactiveLateFeeCountafter);
		softAssert.assertEquals(inactiveLateFeeLabel, Boolean.TRUE);
		softAssert.assertAll();

	}

	public int activeLateFeeCountBefore;
	public int activeLateFeeCountafter;
	public String InactiveLateFeeLabel;
	public Boolean ActiveLateFeeLabel;

	public void AgencySetup_VerifyActivateInActiveLateFee() throws InterruptedException {

		crmCommonMethod.navigateToLateFeesSubTab();
		waitUntilElementIsVisible(EditInactiveFine);
		activeLateFeeCountBefore = Integer.parseInt((getTextElement(ActiveFines)).split(" ")[0]);
		clickByJsExecuter(EditInactiveFine);
		forcedWaitTime(2);
		InactiveLateFeeLabel = driver.findElement(CrtFineLabelName).getAttribute("value");
		scrollIntoView(ActiveFinetoogle);
		Thread.sleep(2000);
		// clickByJsExecuter(ActiveFinetoogle);
		clickOn(ActiveFinetoogle);
		clickByJsExecuter(EditSavebtn);
		waitUntilElementInvisibleLocated(EditSavebtn);
		forcedWaitTime(2);
		List<String> allactiveFineLabels = new ArrayList<>();
		activeLateFeeCountafter = Integer.parseInt((getTextElement(ActiveFines)).split(" ")[0]);
		driver.findElements(ActiveFineGridData).stream().forEach(x -> allactiveFineLabels.add(x.getText()));

		ActiveLateFeeLabel = allactiveFineLabels.contains(InactiveLateFeeLabel);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(activeLateFeeCountBefore + 1, activeLateFeeCountafter);
		softAssert.assertEquals(ActiveLateFeeLabel, Boolean.TRUE);
		softAssert.assertAll();

	}

	public int ICCactiveCountBefore;
	public int ICCactiveCountAfter;
	public int LCCactiveCountBefore;
	public int LCCactiveCountAfter;

	public void AgencySetup_VerifyContactCustomFields(String labelText) throws InterruptedException {
		scrollIntoView(contactsTab);
		forcedWaitTime(3);
		waitForElementIsInteractable(contactsTab);
		clickOn(contactsTab);
		if (labelText.equalsIgnoreCase("IndiviualContact")) {
			String[] ICCActiveCountBefore = getTextElement(ICCActiveCount).split(" ");
			ICCactiveCountBefore = Integer.parseInt(ICCActiveCountBefore[0]);
			waitForCurserRunning(5);
			forcedWaitTime(1);
			scrollIntoView(CreateCustomFieldButton);
			waitForElementIsInteractable(CreateCustomFieldButton);
			forcedWaitTime(1);
			clickOn(CreateCustomFieldButton);
			sendKeysWithWait(LabelField, "IndiviualContact");
			forcedWaitTime(1);
			clickOn(TypeDropdownField);
			forcedWaitTime(1);
			clickOn(TextOptionType);
			forcedWaitTime(1);
			clickOn(CreateCustomFieldButton2);
			waitForCurserRunning(5);
			forcedWaitTime(1);
			String[] ICCActiveCountAfter = getTextElement(ICCActiveCount).split(" ");
			ICCactiveCountAfter = Integer.parseInt(ICCActiveCountAfter[0]);
			Assert.assertEquals(ICCactiveCountBefore + 1, ICCactiveCountAfter);
		} else if (labelText.equalsIgnoreCase("LegalContact")) {
			waitForElementIsInteractable(AppliedToLegalEntries);
			clickByJsExecuter(AppliedToLegalEntries);
			String[] LCCActiveCountBefore = getTextElement(LCCActiveCount).split(" ");
			LCCactiveCountBefore = Integer.parseInt(LCCActiveCountBefore[0]);
			waitForCurserRunning(5);
			forcedWaitTime(2);
			waitForElementIsInteractable(CreateCustomFieldButton);
			clickByJsExecuter(CreateCustomFieldButton);
			waitForElementIsInteractable(LegalEntityToggle);
			clickByJsExecuter(LegalEntityToggle);
			sendKeysWithWait(LabelField, "LegalContact");
			forcedWaitTime(3);
			clickOn(TypeDropdownField);
			forcedWaitTime(2);
			waitForElementIsInteractable(TextOptionType);
			clickOn(TextOptionType);
			waitForElementIsInteractable(CreateCustomFieldButton2);
			clickOn(CreateCustomFieldButton2);
			waitForCurserRunning(2);
			String[] LCCActiveCountAfter = getTextElement(LCCActiveCount).split(" ");
			LCCactiveCountAfter = Integer.parseInt(LCCActiveCountAfter[0]);
			Assert.assertEquals(LCCactiveCountBefore + 1, LCCactiveCountAfter);
		}

	}

	public void createRoles() throws InterruptedException {

		refreshPage();
		waitForCurserRunning(5);
		waitForPresenceandVisiblity(AppMenuIcon);
		crmCommonMethod.navigateToAgencySetup();

		ceCommonMethod.navigateToUserManagement();
		ceCommonMethod.openCreateRolePopUp();
		ceCommonMethod.roleCreationWithCECRMSettings(PropertiesUtils.getPropertyValue("NoSupervisor"), PropertiesUtils.getPropertyValue("NoSupervisorRole"),
				PropertiesUtils.getPropertyValue("NoSupervisorRoleDescription"));
		ceCommonMethod.openCreateRolePopUp();
		ceCommonMethod.roleCreationWithCECRMSettings(PropertiesUtils.getPropertyValue("BasicSuperv"), PropertiesUtils.getPropertyValue("BasicSuperv"),
				PropertiesUtils.getPropertyValue("BasicSupervRoleDescription"));
		ceCommonMethod.openCreateRolePopUp();
		ceCommonMethod.roleCreationWithCECRMSettings(PropertiesUtils.getPropertyValue("SupervisorMan"), PropertiesUtils.getPropertyValue("SupervisorMan"),
				PropertiesUtils.getPropertyValue("BasicSupervRoleDescription"));

	}

	public void createGroups() throws InterruptedException {

		 String listusers1 = PropertiesUtils.getPropertyValue("users.groups1");
         List<String> myList = Arrays.asList(listusers1.split(","));
         
         
         String listusers2 = PropertiesUtils.getPropertyValue("users.groups2");
         List<String> myList2 = Arrays.asList(listusers2.split(","));

		umUtils.createGroupWithUser(PropertiesUtils.getPropertyValue("Group1"), PropertiesUtils.getPropertyValue("Group1Description"), myList);
		forcedWaitTime(4);
		umUtils.createGroupWithUser(PropertiesUtils.getPropertyValue("Group2"), PropertiesUtils.getPropertyValue("Group1Description"), myList2);
	}

	public void createDepartment() throws InterruptedException {

		crmCommonMethod.navigateToAgencySetup();
		clickOn(departmentTab);
		waitUntilElementIsVisible(createDepartmentButton);
		waitForElementIsInteractable(createDepartmentButton);
		clickOn(createDepartmentButton);
		waitUntilElementIsVisible(LabelField);
		waitForElementIsInteractable(LabelField);
		sendKeysWithWait(LabelField,PropertiesUtils.getPropertyValue("TestDept"));
		clickOn(createDepartmentButtonPopup);
		forcedWaitTime(4);
		waitUntilElementIsVisible(createDepartmentButton);
		waitForElementIsInteractable(createDepartmentButton);
		clickOn(createDepartmentButton);
		waitUntilElementIsVisible(LabelField);
		waitForElementIsInteractable(LabelField);
		sendKeysWithWait(LabelField,PropertiesUtils.getPropertyValue("TestDept1"));
		clickOn(createDepartmentButtonPopup);

	}

}
