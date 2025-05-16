package POM;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import CommonMethods.CECommonMethods;
import CommonMethods.CheckDownloadedFile;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

public class CLPUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CECommonMethods ceMethods;

	public CLPUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		ceMethods = new CECommonMethods(driver);
	}

	public static By noOfRowsOnPage = By.xpath("//*[@class='rt-tr-group']");
	public static By pendingSupervisorStatusCLP = By.xpath("//div[text()='Pending Supervisor Approval']");
	public static By notApprovedCheckbox = By.xpath("(//*[@id='escalatedNoticeStatus']//input)[2]");
	public static By approved = By.xpath("(//*[@id='escalatedNoticeStatus']//input)[3]");
	public static By approvedAndApplied = By.xpath("(//*[@id='escalatedNoticeStatus']//input)[4]");
	public static By checkBoxForEscalatedNotice = By.xpath("//*[@id='escalatedNoticeStatus']//input");
	public static By escalatedNoticeStatusCLP = By.xpath("//label[text()='Escalated Notice Status']");
	public static String cLP = "//a[text()='Cases']";
	public static String cases = "//label[text()='Cases: ']";
	public static By firstCaseCLP = By.xpath("//*[@class='checkbox-holder']//../a");
	public static String cSLPSearchField = "//input[@name='searchQuery']";
	public static String violationTypeFilter = "//label[text()='Violation Type']";
	public static String violationTypeCol = "//div[contains(text(),'Violation Type')]";
	public static String locationCol = "//div[contains(text(),'Location')]";
	public static String apnCol = "//div[contains(text(),'APN')]";
	public static String assigneeCol = "//div[text()='Assignee']";
	public static String statusCol = "//div[text()='Status']";
	public static String createdCol = "//div[text()='Created']";
	public static String closedCol = "//div[text()='Closed']";
	public static String inspectionAssigneeCol = "//div[text()='Inspection Assignee']";
	public static String nextInsepectionAssingeeCol = "//div[text()='Next Scheduled Inspection']";
	public static String deleteCol = "//div[text()='Delete']";
	public static String caseStatusFilter = "//label[text()='Case Status']";
	public static String createdFilter = "//label[text()='Created']";
	public static String inspectionAssigneeFilter = "//div[text()='Inspection Assignee']";
	public static String nextScheduledInspectionFilter = "//div[text()='Next Scheduled Inspection']";
	public static String paginationField = "//div[@class='table__pagination-page-nos']//input";
	public static String nextPagination = "//div[@class='table__pagination-nav-btns']//button[@class='square-btn btn btn-default'][2]";
	public static String previousPagingation = "(//div[@class='table__pagination-nav-btns']//button)[1]";
	public static String caseID = "//span[@class='checkbox-holder']/following::a[1]";
	public static String caseNumberHeader = "//div[text()='Case Number']";
	public static String deleteLink = "//a[text()='Delete']";
	public static String deleteCasePopup = "//div[@class='modal-header' and text()='Delete Case']";
	public static String deleteTextField = "//input[@name='deleteText']";
	public static String deleteCaseButton = "//button[text()='Delete Case']";
	public static String validationMsgDeleteCase = "//div[@class='modal-base__error modal-base__error--show']";
	public static String casesCount = "(//div[@class='cs-listing__section__header']//following-sibling::span)[1]";
	public static String casesCount1 = "(//div[@class='cs-listing__section__header']//following-sibling::span)[1]";
	public static String doNotDeleteButton = "//button[text()='Do Not Delete']";
	public static String paginationCount = "//span[@class='table__pagination-of-text']";
	public static String violationTypePF = "//label[text()='Violation Type']";
	public static String caseStatusPF = "//label[text()='Case Status']";
	public static String createPF = "//label[text()='Created']";
	public static String inspectionAssigneePF = "//div[text()='Inspection Assignee']";
	public static String nextScheduledPF = "//label[text()='Next Scheduled Inspection']";
	public static String caseStatusDropDown = "//label[text()='Case Status']/following::span[1]";
	public static String violationTypesPF = "//label[text()='Violation Type']/following::span[1]";
	public static String closedOption = "//span[text()='Closed']";
	public static String animalviolationOption = "//label[text()='Animal'][@for='Violation Type-0']";
	public static String animalViolationOptionChk = "//input[@type='checkbox'][@name='Animal']";
	public static String closedStatusCLP = "//div[@class='rt-td']/div[text()='Closed']";
	public static String clearAllFiltersLink = "//a[text()='Clear all filters']";
	public static String filterSlider = "//i[@class='fa fa-2 fa-sliders']";
	public static String violationsFilter = "//label[@for='checkbox-violations']";
	public static String outstandingBalanceFilter = "//label[@for='checkbox-outstandingBalance']";
	public static String violationsFilterCLP = "//label[text()='Violations']";
	public static String outstandingBalanceFilterCLP = "//label[text()='Outstanding Balance']";
	public static String filterSliderClose = "//button[@class='drawer__close']";
	public static String columnControlWidget = "//i[@class='fa fa-2 fa-cog']";
	public static String columnOutstandingBalance = "//label[@for='checkbox-column-outstandingBalance' and text()='Outstanding Balance']";
	public static By outstandingBalanceChkboxWidget = By.xpath("//input[@id='checkbox-column-outstandingBalance']");
	public static String closeColumnControl = "//button[@class='drawer__close']";
	public static String dropdownOutstandingBalance = "//div[@id='outstandingBalance']//div/label[text()='Any']";
	public static String option2OB = "//label[@for='Outstanding Balance-2']";
	public static String applyButtonOB = "//label[@for='Outstanding Balance-2']//following::button[text()='Apply']";
	public static String crossSecondaryFilter = "//div[@class='filter-options violations']/following-sibling::button";
	public static String countSecondaryFilters = "//div[@class='filters-secondary__chip']";
	public static String cLPSearchField = "//input[@name='searchQuery']";
	public static String noCasesInfoMsg = "//div[@class='rt-noData']";
	public static String columnOutstandingBalanceCLP = "//div[text()='Outstanding Balance']";
	public static String restoreDefaultsLink = "//a[text()='Restore Defaults']";
	public static String saveAsButton = "//button[text()='Save As']";
	public static String saveAsPopup = "//div[text()='Save As']";
	public static String saveButton = "//button[text()='Save']";
	public static String errorMsgSaveAsPopup = "//span[text()='The Filter Name is required.']";
	public static String filterNameField = "//input[@placeholder='Enter Text']";
	public static String countFiltersSaveAs = "(//ul[@class='dropdown__options--single'])[1]/li";
	public static String crossIconFilters = "//button[@class='delete-btn  btn btn-primary']";
	public static String filtersDropdown = "(//div[@class='dropdown__selector__selected']/label)[1]";
	public static String createCaseButtonCLP = "//button[text()='Create Case']";
	public static String downloadButton = "//button[text()='Download']";
	public static String cSVOption = "//li[text()='CSV']";
	public static String openedCaseId = "//h2[@class='case-details__case-number']";
	public static String printButtonCLP = "//button[text()='Print']";
	public static String closeCaseIcon = "//div[@class='case-details__close-icon']/img";
	public static String cancelButtonCCP = "//button[text()='Cancel']";
	public static String agencyUserName = "//div[@class='app-header__user-name']/label";
	public static String mineButtonCLP = "//button[text()='Mine']";
	public static String assigneeColumn = "//span[@class='checkbox-holder']/following::span[2]";
	public static By mapViewIcon = By.xpath("//div[@class='cs-listing__section__header']//button");
	public static By mapViweZoomIn = By.xpath("//a[@class='leaflet-control-zoom-in']");
	public static By plusButtonHeader = By.cssSelector("#header div.app-header__new");

	public static By CLP = By.xpath(cLP);
	public static By Cases = By.xpath(cases);
	public static By ViolationTypeFilter = By.xpath(violationTypeFilter);

	public static By ViolationTypeCol = By.xpath(violationTypeCol);
	public static By LocationCol = By.xpath(locationCol);
	public static By ApnCol = By.xpath(apnCol);

	public static By AssigneeCol = By.xpath(assigneeCol);
	public static By StatusCol = By.xpath(statusCol);
	public static By CreatedCol = By.xpath(createdCol);
	public static By ClosedCol = By.xpath(closedCol);
	public static By InspectionAssigneeCol = By.xpath(inspectionAssigneeCol);
	public static By NextInsepectionAssingeeCol = By.xpath(nextInsepectionAssingeeCol);
	public static By DeleteCol = By.xpath(deleteCol);

	public static By CaseStatusFilter = By.xpath(caseStatusFilter);
	public static By CreatedFilter = By.xpath(createdFilter);
	public static By InspectionAssigneeFilter = By.xpath(inspectionAssigneeFilter);
	public static By NextScheduledInspectionFilter = By.xpath(nextScheduledInspectionFilter);
	public static By PaginationField = By.xpath(paginationField);
	public static By NextPagination = By.xpath(nextPagination);
	public static By PreviousPagingation = By.xpath(previousPagingation);
	public static By CaseID = By.xpath(caseID);
	public static By CaseNumberHeader = By.xpath(caseNumberHeader);
	public static By DeleteLink = By.xpath(deleteLink);
	public static By DeleteCasePopup = By.xpath(deleteCasePopup);
	public static By DeleteTextField = By.xpath(deleteTextField);
	public static By DeleteCaseButton = By.xpath(deleteCaseButton);
	public static By ValidationMsgDeleteCase = By.xpath(validationMsgDeleteCase);
	public static By CasesCount = By.xpath(casesCount);
	public static By CasesCount1 = By.xpath(casesCount1);
	public static By DoNotDeleteButton = By.xpath(doNotDeleteButton);
	public static By PaginationCount = By.xpath(paginationCount);
	public static By ViolationTypePF = By.xpath(violationTypePF);
	public static By CaseStatusPF = By.xpath(caseStatusPF);
	public static By CreatePF = By.xpath(createPF);
	public static By InspectionAssigneePF = By.xpath(inspectionAssigneePF);
	public static By NextScheduledPF = By.xpath(nextScheduledPF);
	public static By CaseStatusDropDown = By.xpath(caseStatusDropDown);
	public static By ViolationTypesPF = By.xpath(violationTypesPF);
	public static By ClosedOption = By.xpath(closedOption);
	public static By AnimalviolationOption = By.xpath(animalviolationOption);
	public static By AnimalViolationOptionChk = By.xpath(animalViolationOptionChk);

	public static By ClosedStatusCLP = By.xpath(closedStatusCLP);
	public static By ClearAllFiltersLink = By.xpath(clearAllFiltersLink);
	public static By FilterSlider = By.xpath(filterSlider);
	public static By ViolationsFilter = By.xpath(violationsFilter);
	public static By OutstandingBalanceFilter = By.xpath(outstandingBalanceFilter);
	public static By ViolationsFilterCLP = By.xpath(violationsFilterCLP);
	public static By OutstandingBalanceFilterCLP = By.xpath(outstandingBalanceFilterCLP);
	public static By FilterSliderClose = By.xpath(filterSliderClose);
	public static By ColumnControlWidget = By.xpath(columnControlWidget);
	public static By ColumnOutstandingBalance = By.xpath(columnOutstandingBalance);
	public static By CloseColumnControl = By.xpath(closeColumnControl);
	public static By DropdownOutstandingBalance = By.xpath(dropdownOutstandingBalance);
	public static By Option2OB = By.xpath(option2OB);
	public static By ApplyButtonOB = By.xpath(applyButtonOB);
	public static By CrossSecondaryFilter = By.xpath(crossSecondaryFilter);
	public static By CountSecondaryFilters = By.xpath(countSecondaryFilters);
	public static By CLPSearchField = By.xpath(cLPSearchField);
	public static By NoCasesInfoMsg = By.xpath(noCasesInfoMsg);
	public static By ColumnOutstandingBalanceCLP = By.xpath(columnOutstandingBalanceCLP);
	public static By RestoreDefaultsLink = By.xpath(restoreDefaultsLink);
	public static By SaveAsButton = By.xpath(saveAsButton);
	public static By SaveAsPopup = By.xpath(saveAsPopup);
	public static By SaveButton = By.xpath(saveButton);
	public static By ErrorMsgSaveAsPopup = By.xpath(errorMsgSaveAsPopup);
	public static By FilterNameField = By.xpath(filterNameField);
	public static By CountFiltersSaveAs = By.xpath(countFiltersSaveAs);
	public static By CrossIconFilters = By.xpath(crossIconFilters);
	public static By FiltersDropdown = By.xpath(filtersDropdown);
	public static By CreateCaseButtonCLP = By.xpath(createCaseButtonCLP);
	public static By DownloadButton = By.xpath(downloadButton);
	public static By CSVOption = By.xpath(cSVOption);
	public static By OpenedCaseId = By.xpath(openedCaseId);
	public static By PrintButtonCLP = By.xpath(printButtonCLP);
	public static By CloseCaseIcon = By.xpath(closeCaseIcon);
	public static By CancelButtonCCP = By.xpath(cancelButtonCCP);
	public static By AgencyUserName = By.xpath(agencyUserName);
	public static By MineButtonCLP = By.xpath(mineButtonCLP);
	public static By AssigneeColumn = By.xpath(assigneeColumn);
	public static By CSLPSearchField = By.xpath(cSLPSearchField);
	public static String CLPColumn = "//div[text()='%s']";
	public static String SecondaryFilters = "//label[@for='%s']";
	public static String SecondaryFilterCheckBox = "//input[@id='%s']";
	public static String SecondaryFilterCriteria = "//input[@name='%s']//parent::span//label";
	public static By caseIds = By.xpath("//span[@class='checkbox-holder']//following-sibling::a");
	public static By caseIdCheckboxCLP = By.xpath("//span[@class='checkbox-holder']//input[@class='checkbox__input']");
	public static By CLPmessage = By.xpath("//div[normalize-space()='No cases to display']");
	public static By generateNoticeButton = By.xpath("//button[normalize-space()='Generate Notice']");
	public static By continueNoticeButton = By.xpath("(//button[normalize-space()='Continue'])[1]");
	public static By continueNoticeButton2 = By.xpath("(//button[normalize-space()='Continue'])[2]");
	public static By continueNoticeButton3 = By.xpath("(//button[normalize-space()='Continue'])[3]");
	public static By htmlnotice = By.xpath("//button[normalize-space()='HTML Mandatory Notice']");
	public static By AssociatedFine = By.xpath("//span[contains(@class,'selected-notice')]");
	public static By genrateAndApplyNotices = By.xpath("//button[normalize-space()='Generate and Apply Notice']");
	public static By CaseInitiationFilter = By.xpath("//label[@for='checkbox-initiationType']");
	public static By filterDropdown = By
			.xpath("//div[@class='filter-options initiation-type']//div[@class='dropdown__selector__selected']");
	public static By ProactiveFilter = By.xpath("//label[normalize-space()='Proactive']");
	public static By ReactiveFilter = By.xpath("//label[normalize-space()='Reactive']");
	public static By closeFilter = By.xpath("//div[@class='filters-secondary__chip']//button[@type='button']");
	public static By caseInitiationLabel = By.xpath("//label[normalize-space()='Case Initiation']");
	public static int totalCountCases;
	String CountBefore;
	int BeforeDeleting;

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void CLP_VerifyCLPOpensUp() throws InterruptedException {

		waitUntilElementIsVisible(CLP);
		waitUntilElementPresent(CLP);
		scrollIntoView(CLP);
		waitForElementIsInteractable(CLP);
		waitForElementIsInteractable(CLP);
		clickByJsExecuter(CLP);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(Cases);
		waitUntilElementPresent(Cases);
		WebElement CasesText = waitUntilVisibleWE(Cases);
		if ((CasesText.isDisplayed()) == false) {

			SoftAssert s1 = new SoftAssert();
			s1.assertEquals(false, true);
			s1.assertAll();
		}

	}

	public void CLP_VerifyDefaultColumns() throws InterruptedException {

		implicitWaitforCustometime(5);
		WebElement DefaultCol1 = waitUntilVisibleWE(ViolationTypeCol);
		WebElement DefaultCol2 = waitUntilVisibleWE(LocationCol);
		WebElement DefaultCol3 = waitUntilVisibleWE(ApnCol);
		scrollIntoView(AssigneeCol);
		WebElement DefaultCol4 = waitUntilVisibleWE(AssigneeCol);
		scrollIntoView(StatusCol);
		WebElement DefaultCol5 = waitUntilVisibleWE(StatusCol);
		scrollIntoView(CreatedCol);
		WebElement DefaultCol6 = waitUntilVisibleWE(CreatedCol);
		scrollIntoView(ClosedCol);
		WebElement DefaultCol7 = waitUntilVisibleWE(ClosedCol);
		scrollIntoView(InspectionAssigneeCol);
		WebElement DefaultCol8 = waitUntilVisibleWE(InspectionAssigneeCol);
		scrollIntoView(NextInsepectionAssingeeCol);
		WebElement DefaultCol9 = waitUntilVisibleWE(NextInsepectionAssingeeCol);
		scrollIntoView(DeleteCol);
		WebElement DefaultCol10 = waitUntilVisibleWE(DeleteCol);

		if (((DefaultCol1.isDisplayed()) == true) && (DefaultCol2.isDisplayed() == true)
				&& (DefaultCol3.isDisplayed() == true) && (DefaultCol4.isDisplayed() == true)
				&& (DefaultCol5.isDisplayed() == true) && (DefaultCol6.isDisplayed() == true)
				&& (DefaultCol7.isDisplayed() == true) && (DefaultCol8.isDisplayed() == true)
				&& (DefaultCol9.isDisplayed() == true) && (DefaultCol1.isDisplayed() == true)) {

			SoftAssert s2 = new SoftAssert();
			s2.assertEquals(true, true);
			s2.assertAll();
		}

	}

	public void CLP_VerifyNavigationToNextPage() throws InterruptedException {

		waitUntilElementIsVisible(CaseID);
		String[] CaseIDBeforeClick = getTextElement(CaseID).split("-");
		String ID1 = CaseIDBeforeClick[1];
		scrollIntoView(NextPagination);
		waitForElementIsInteractable(NextPagination);
		waitForElementIsInteractable(NextPagination);
		clickByJsExecuter(NextPagination);
		waitForCurserRunning(5);
		forcedWaitTime(6);
		WaitForGridTableEnable();
		waitUntilElementIsVisible(CaseID);
		String[] CaseIDAfterClick = getTextElement(CaseID).split("-");
		String ID2 = CaseIDAfterClick[1];
		int differenceID = Integer.parseInt(ID2) - Integer.parseInt(ID1);
		System.out.println("ID 2 is " + ID2 + " ID 1 is " + ID1 + " Differnce is " + differenceID);

		if ((differenceID >= 50) == false) {
			SoftAssert s3 = new SoftAssert();
			s3.assertEquals(false, true);
			s3.assertAll();

		}

	}

	public void CLP_VerifynavigationToSpecificPage() throws InterruptedException {

		WebElement Pagination = waitUntilVisibleWE(PaginationField);

		Pagination.sendKeys(Keys.BACK_SPACE);
		Pagination.sendKeys("2");
		Pagination.sendKeys(Keys.RETURN);

	}

	public ArrayList<Integer> IDArray = new ArrayList<Integer>();

	public void CLP_VerifyDescendingOrderOfCases() throws InterruptedException {

		int FinalIDs = 0;

		waitUntilElementIsVisible(CaseID);
		waitForStaleElementReference(CaseID);
		List<WebElement> AllCasesID = waitUntilVisibleList(CaseID);
		int CountIDs = AllCasesID.size() / 2;
		for (int i = 0; i < CountIDs; i++) {
			WebElement IDList = AllCasesID.get(i);
			String[] IDList1 = IDList.getText().split("-");
			String IDs = IDList1[1];
			FinalIDs = Integer.parseInt(IDs);
			IDArray.add(FinalIDs);
		}
		Integer[] arr = new Integer[IDArray.size()];
		for (int i = 0; i < 1; i++) {
			arr[i] = IDArray.get(i);
			for (int j = i + 1; j < IDArray.size(); j++) {
				arr[j] = IDArray.get(j);
				if ((arr[j] < arr[i]) == false) {
					SoftAssert s5 = new SoftAssert();
					s5.assertEquals(false, true);
					s5.assertAll();
				}
			}
		}

	}

	public void CLP_VerifyAscendingOrderOfCases() throws InterruptedException {

		WaitForGridTableEnable();
		forcedWaitTime(2);
		waitUntilElementIsVisible(CaseNumberHeader);
		clickOn(CaseNumberHeader);
		waitForCurserRunning(4);
		forcedWaitTime(3);
		WaitForGridTableEnable();
		waitUntilElementIsVisible(CaseID);
		List<WebElement> AllCasesID = waitUntilVisibleList(CaseID);
		int CountIDs = AllCasesID.size() / 2;
		IDArray.clear();
		for (int i = 0; i < CountIDs; i++) {
			WebElement IDList = AllCasesID.get(i);
			String[] IDList1 = IDList.getText().split("-");
			String IDs = IDList1[1];
			int FinalIDs = Integer.parseInt(IDs);
			IDArray.add(FinalIDs);
		}
		Integer[] arr = new Integer[IDArray.size()];
		for (int i = 0; i < 1; i++) {
			arr[i] = IDArray.get(i);
			for (int j = i + 1; j < IDArray.size(); j++) {
				arr[j] = IDArray.get(j);
				if ((arr[j] > arr[i]) == false) {
					Assert.assertEquals(false, true);
				}
			}
		}

	}

	public void CLP_OpenDeleteCasePopup() throws InterruptedException {

		waitUntilElementIsVisible(CasesCount);
		String[] CountCases = getTextElement(CasesCount).split(" ");
		CountBefore = CountCases[0];

		BeforeDeleting = Integer.parseInt(CountBefore);

		By DeleteLink = By.xpath("(//a[text()='Delete'])[20]");
		waitUntilElementIsVisible(CaseNumberHeader);
		waitUntilElementPresent(CaseNumberHeader);
		clickOn(CaseNumberHeader);
		Thread.sleep(5000);
		waitUntilElementIsVisible(DeleteLink);
		waitUntilElementPresent(DeleteLink);
		scrollIntoView(DeleteLink);
		waitForElementIsInteractable(DeleteLink);
		scrollHorizontally(0);
		clickByJsExecuter(DeleteLink);
		Thread.sleep(5000);

		String DeleteCaseTitle = getTextElement(DeleteCasePopup);
		SoftAssert s7 = new SoftAssert();
		s7.assertEquals(DeleteCaseTitle, "Delete Case");
		s7.assertAll();

	}

	public void CLP_ValidationMsgForDeleteCase() throws InterruptedException {

		clickByJsExecuter(DoNotDeleteButton);
		waitUntilElementIsVisible(CasesCount);
		String[] CountCases = getTextElement(CasesCount).split("\\s+");

		CountBefore = CountCases[0];
		System.out.println("no of cases for delete " + CountCases[0]);

		BeforeDeleting = Integer.parseInt(CountBefore);
		clickByJsExecuter(DeleteLink);
		waitUntilElementPresent(DeleteCaseButton);
		waitForElementIsInteractable(DeleteCaseButton);
		waitForElementIsInteractable(DeleteTextField);
		clickByJsExecuter(DeleteCaseButton);
		waitUntilElementIsVisible(ValidationMsgDeleteCase);
		String ValidationMsgDltCase = getTextElement(ValidationMsgDeleteCase);
		String ExpectedMsg = "Please enter DELETE in all caps";

		SoftAssert s8 = new SoftAssert();
		s8.assertEquals(ValidationMsgDltCase, ExpectedMsg);
		s8.assertAll();

	}

	public void CLP_VerifyDeletedcase() throws InterruptedException {

		waitUntilElementIsVisible(DeleteTextField);
		waitUntilElementPresent(DeleteTextField);
		scrollIntoView(DeleteTextField);
		waitForElementIsInteractable(DeleteTextField);
		sendKeysWithWait(DeleteTextField, "DELETE");
		waitUntilElementIsVisible(DeleteCaseButton);
		waitForElementIsInteractable(DeleteCaseButton);
		clickOn(DeleteCaseButton);
		waitForCurserRunning(10);
		forcedWaitTime(3);
		waitUntilElementIsVisible(By.cssSelector("span.checkbox-holder + a"));
		waitUntilElementPresent(By.cssSelector("span.checkbox-holder + a"));
		waitUntilElementIsVisible(CasesCount);
		waitUntilElementIsVisible(CasesCount);
		waitUntilElementPresent(CasesCount);
		scrollIntoView(CasesCount);
		forcedWaitTime(4);
		String[] CountCases2 = getTextElement(CasesCount).split(" ");
		String CountAfter = CountCases2[0];
		int AfterDeleting = Integer.parseInt(CountAfter);
		if ((AfterDeleting < BeforeDeleting) == false) {

			SoftAssert s9 = new SoftAssert();
			s9.assertEquals(false, true, "Case did not get deleted!");
			s9.assertAll();
		}

	}

	public void CLP_VerifyCasesForDoNotDeleteOption() {

		waitUntilElementIsVisible(CasesCount);
		String[] CountCases = getTextElement(CasesCount).split(" ");
		String CountBefore = CountCases[0];
		int BeforeDeleting = Integer.parseInt(CountBefore);
		clickOn(DeleteLink);
		clickOn(DoNotDeleteButton);

		waitUntilElementIsVisible(CasesCount);
		String[] CountCases2 = getTextElement(CasesCount).split(" ");
		String CountAfter = CountCases2[0];
		int AfterDeleting = Integer.parseInt(CountAfter);
		if ((AfterDeleting == BeforeDeleting) == false) {

			SoftAssert s10 = new SoftAssert();
			s10.assertEquals(false, true);
			s10.assertAll();
		}

	}

	public int CLP_VerifyTotalCountOfCases() throws InterruptedException {
		waitUntilElementIsVisible(CasesCount);
		forcedWaitTime(5);
		String[] CountOfCases = getTextElement(CasesCount).split(" ");
		String CountHeader = CountOfCases[0];

		int CountAtHeader = Integer.parseInt(CountHeader);
		System.out.println(CountAtHeader);
		String[] PaginationCounts = getTextElement(PaginationCount).split(" ");
		int caseCount = findElementsSize(caseIdCheckboxCLP);
		Boolean checkNext = driver.findElement(NextPagination).isEnabled();
		while (checkNext) {
			waitUntilElementIsVisible(NextPagination);
			scrollIntoView(NextPagination);
			waitForElementIsInteractable(NextPagination);
			clickByJsExecuter(NextPagination);
			WaitForGridTableEnable();
			forcedWaitTime(5);
			scrollTillPageEnd();
			int case_Count = findElementsSize(caseIdCheckboxCLP);
			caseCount = caseCount + case_Count;
			waitUntilElementIsVisible(NextPagination);
			scrollIntoView(NextPagination);
			checkNext = driver.findElement(NextPagination).isEnabled();
		}

		forcedWaitTime(3);
		waitUntilElementIsVisible(CaseID);
		waitUntilElementPresent(CaseID);
		SoftAssert s11 = new SoftAssert();
		s11.assertEquals(CountAtHeader, caseCount);
		s11.assertAll();

		return caseCount;

	}
public static By pagenationBar= By.xpath("//div[@class='table__pagination-page-nos']//input");
	
	public int countCasesUsingPagenationToLastPage(int noOfElementsOnSinglePage) throws InterruptedException {
		waitUntilElementIsVisible(CasesCount);
		forcedWaitTime(5);
		String[] CountOfCases = getTextElement(CasesCount).split(" ");
		String CountHeader = CountOfCases[0];

		int CountAtHeader = Integer.parseInt(CountHeader);
		System.out.println(CountAtHeader);
		int caseCount;
		WebElement pagenationIndexBoxCLP = findElement(pagenationBar);
		String[] PaginationCounts = getTextElement(PaginationCount).split(" ");
		String pageCounts = PaginationCounts[1];
		int pageCnt = Integer.parseInt(pageCounts);
		System.out.println(pageCnt);
		if (pageCnt > 1) {

			caseCount = noOfElementsOnSinglePage * (pageCnt - 1);
			Actions a = new Actions(driver);
			a.moveToElement(pagenationIndexBoxCLP).doubleClick().build().perform();
			forcedWaitTime(2);
			a.sendKeys(pageCounts).sendKeys(Keys.ENTER).build().perform();
			forcedWaitTime(2);
			waitForElementIsInteractable(caseIdCheckboxCLP);
			int case_Count = findElementsSize(caseIdCheckboxCLP);
			caseCount = caseCount + case_Count;
		}

		else {
			caseCount = findElementsSize(caseIdCheckboxCLP);
			Boolean checkNext = driver.findElement(NextPagination).isEnabled();
			while (checkNext) {
				waitUntilElementIsVisible(NextPagination);
				scrollIntoView(NextPagination);
				waitForElementIsInteractable(NextPagination);
				clickByJsExecuter(NextPagination);
				WaitForGridTableEnable();
				forcedWaitTime(5);
				scrollTillPageEnd();
				int case_Count = findElementsSize(caseIdCheckboxCLP);
				caseCount = caseCount + case_Count;
				waitUntilElementIsVisible(NextPagination);
				scrollIntoView(NextPagination);
				checkNext = driver.findElement(NextPagination).isEnabled();
			}
		}

		forcedWaitTime(3);
		waitUntilElementIsVisible(CaseID);
		waitUntilElementPresent(CaseID);
		SoftAssert s11 = new SoftAssert();
		s11.assertEquals(caseCount, CountAtHeader);
		s11.assertAll();

		return caseCount;

	}

	public int totalCaseCountCDPHeader() throws InterruptedException {
		waitUntilElementIsVisible(CasesCount);
		forcedWaitTime(3);
		String[] CountOfCases = getTextElement(CasesCount).split(" ");
		String CountHeader = CountOfCases[0];

		int CountAtHeader = Integer.parseInt(CountHeader);
		return CountAtHeader;

	}

	public void CLP_VerifyPrimaryFilters() throws InterruptedException {

		WebElement PrimaryFilter1 = waitUntilVisibleWE(ViolationTypePF);
		WebElement PrimaryFilter2 = waitUntilVisibleWE(CaseStatusPF);
		WebElement PrimaryFilter3 = waitUntilVisibleWE(CreatePF);
		WebElement PrimaryFilter4 = waitUntilVisibleWE(InspectionAssigneePF);
		if (((PrimaryFilter1.isDisplayed()) == false) || (PrimaryFilter2.isDisplayed() == false)
				|| (PrimaryFilter3.isDisplayed() == false) || (PrimaryFilter4.isDisplayed() == false)) {

			SoftAssert s12 = new SoftAssert();
			s12.assertEquals(false, true);
			s12.assertAll();
		}

	}

	public void CLP_VerifyApplicationOfPrimaryFilters() throws InterruptedException {

		Boolean prePage = driver.findElement(PreviousPagingation).isEnabled();
		while (prePage) {
			waitForElementIsInteractable(PreviousPagingation);
			clickByJsExecuter(PreviousPagingation);
			prePage = driver.findElement(PreviousPagingation).isEnabled();
		}

		waitUntilElementIsVisible(CaseStatusDropDown);
		scrollIntoView(CaseStatusDropDown);
		waitForElementIsInteractable(CaseStatusDropDown);
		clickByJsExecuter(CaseStatusDropDown);
		forcedWaitTime(4);
		waitUntilElementPresent(ClosedOption);
		// movetoElementAndClick(ClosedOption);
		scrollIntoView(ClosedOption);
		clickByJsExecuter(ClosedOption);
		forcedWaitTime(3);

		waitUntilElementPresent(CaseStatusDropDown);
		waitForElementIsInteractable(CaseStatusDropDown);
		// movetoElementAndClick(CaseStatusDropDown);
		clickByJsExecuter(CaseStatusDropDown);
		waitUntilElementIsVisible(CaseID);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(4));
		waitUntilElementPresent(CaseID);
		waitUntilElementPresent(By.xpath("//input[@class='checkbox__input'][@type='checkbox']"));
		waitForElementIsInteractable(By.xpath("//input[@class='checkbox__input'][@type='checkbox']"));
		List<WebElement> AllCasesID = findElementsByXPath(CaseID);
		int CountIDs = AllCasesID.size();
		waitUntilElementIsVisible(ClosedStatusCLP);
		List<WebElement> ClosedCasesCount = findElementsByXPath(ClosedStatusCLP);
		int CountClosedCases = ClosedCasesCount.size();
		SoftAssert s13 = new SoftAssert();
		s13.assertEquals(CountClosedCases, CountIDs);
		s13.assertAll();

	}

	public void CLP_VerifyClearAllFiltersLinkText() throws InterruptedException {

		waitUntilElementIsVisible(ViolationTypesPF);
		scrollIntoView(ViolationTypesPF);
		waitForElementIsInteractable(ViolationTypesPF);
		clickByJsExecuter(ViolationTypesPF);

		waitForElementIsInteractable(AnimalViolationOptionChk);
		clickByJsExecuter(AnimalViolationOptionChk);

		waitForElementIsInteractable(ViolationTypesPF);
		clickOn(ViolationTypesPF);

		waitForCurserRunning(3);
		waitUntilElementIsVisible(ClearAllFiltersLink);
		scrollIntoView(ClearAllFiltersLink);
		WebElement ClearAllFilters = waitUntilVisibleWE(ClearAllFiltersLink);

		if ((ClearAllFilters.isDisplayed()) == false) {

			SoftAssert s14 = new SoftAssert();
			s14.assertEquals(false, true);
			s14.assertAll();
		}

	}

	public void CLP_VerifyClearAllFiltersLinkNotPresent() throws InterruptedException {

		scrollIntoView(ClearAllFiltersLink);
		clickByJsExecuter(ClearAllFiltersLink);

		waitUntilElementInvisibleLocated(ClearAllFiltersLink);
		List<WebElement> ClearAllFilters = driver.findElements(ClearAllFiltersLink);
		if ((ClearAllFilters.size() > 0) == true) {

			SoftAssert s15 = new SoftAssert();
			s15.assertEquals(false, true);
			s15.assertAll();
		}

	}

	public void CLP_VerifySelectionOfSecondaryFilters() throws InterruptedException {

		waitUntilElementIsVisible(FilterSlider);
		waitForElementIsInteractable(FilterSlider);
		clickByJsExecuter(FilterSlider);
		waitUntilElementIsVisible(ViolationsFilter);
		waitForElementIsInteractable(ViolationsFilter);
		clickOn(ViolationsFilter);
		waitUntilElementIsVisible(OutstandingBalanceFilter);
		waitForElementIsInteractable(OutstandingBalanceFilter);
		clickOn(OutstandingBalanceFilter);
		WebElement ViolationCheckbox = waitUntilVisibleWE(ViolationsFilter);

		WebElement OutstandingBalanceCheckbox = waitUntilVisibleWE(OutstandingBalanceFilter);
		if ((ViolationCheckbox.isEnabled() == false) || (OutstandingBalanceCheckbox.isEnabled() == false)) {

			SoftAssert s16 = new SoftAssert();
			s16.assertEquals(false, true);
			s16.assertAll();

		}

	}

	public void CLP_VerifyPresenceOfSecondaryFiltersUnderPrimaryFilters() throws InterruptedException {

		clickOn(FilterSliderClose);

		waitUntilElementIsVisible(ViolationsFilterCLP);
		WebElement ViolationSecondaryFilter = waitUntilVisibleWE(ViolationsFilterCLP);

		waitUntilElementIsVisible(OutstandingBalanceFilterCLP);
		WebElement OutstandingBalance2ndFilter = waitUntilVisibleWE(OutstandingBalanceFilterCLP);
		if ((ViolationSecondaryFilter.isDisplayed() == false) || (OutstandingBalance2ndFilter.isDisplayed() == false)) {

			SoftAssert s17 = new SoftAssert();
			s17.assertEquals(false, true);
			s17.assertAll();
		}

	}

	public void CLP_VerifyApplicationOfsecondaryFilters() throws InterruptedException {

		waitUntilElementIsVisible(ColumnControlWidget);
		waitForElementIsInteractable(ColumnControlWidget);
		clickByJsExecuter(ColumnControlWidget);
		waitUntilElementIsVisible(ColumnOutstandingBalance);
		waitForElementIsInteractable(ColumnOutstandingBalance);
		clickOn(ColumnOutstandingBalance);
		waitForElementIsInteractable(CloseColumnControl);
		clickOn(CloseColumnControl);
		waitForElementIsInteractable(DropdownOutstandingBalance);
		clickOn(DropdownOutstandingBalance);
		waitForElementIsInteractable(Option2OB);
		clickOn(Option2OB);
		waitForElementIsInteractable(ApplyButtonOB);
		clickOn(ApplyButtonOB);

	}

	public void CLP_VerifyRemovalOfSecondaryFilters() throws InterruptedException {

		waitUntilElementIsVisible(CountSecondaryFilters);
		List<WebElement> SecondaryFilters = waitUntilVisibleList(CountSecondaryFilters);
		int countSF1 = SecondaryFilters.size();
		clickOn(CrossSecondaryFilter);
		waitUntilElementIsVisible(CountSecondaryFilters);

		List<WebElement> SecondaryFilters2 = waitUntilVisibleList(CountSecondaryFilters);
		int countSF2 = SecondaryFilters2.size();
		if ((countSF1 > countSF2) == false) {

			SoftAssert s19 = new SoftAssert();
			s19.assertEquals(false, true);
			s19.assertAll();
		}

	}

	public void CLP_VerifySearchField() throws InterruptedException {

		waitUntilElementIsVisible(ClearAllFiltersLink);
		waitForElementIsInteractable(ClearAllFiltersLink);
		clickByJsExecuter(ClearAllFiltersLink);
		WaitForGridTableEnable();
		forcedWaitTime(4);
		String APN = "7030-0159-0010-000";
		sendKeysWithWait(CLPSearchField, APN);
		WaitForGridTableEnable();
		forcedWaitTime(4);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CaseID);
		waitForElementIsInteractable(CaseID);
		forcedWaitTime(4);
		List<WebElement> AllCasesID = driver.findElements(CaseID);
		int CountIDs = AllCasesID.size();

		forcedWaitTime(3);
		List<WebElement> APNCases = driver.findElements(By.xpath("//div[text()='" + (APN) + "']"));
		int APNCaseList = APNCases.size();
		if (APNCaseList < CountIDs) {

			SoftAssert s20 = new SoftAssert();
			s20.assertEquals(false, true);
			s20.assertAll();
		}

	}

	public void CLP_VerifyInfoMsgForNoSearchResults() throws InterruptedException {

		waitUntilElementIsVisible(ClearAllFiltersLink);
		waitForElementIsInteractable(ClearAllFiltersLink);
		clickOn(ClearAllFiltersLink);
		waitForCurserRunning(3);
		WaitForGridTableEnable();
		forcedWaitTime(4);
		String CLPSearchRandom = RandomStrings.requiredCharacters(15);
		sendKeysWithWait(CLPSearchField, CLPSearchRandom);
		waitForCurserRunning(3);
		WaitForGridTableEnable();
		forcedWaitTime(2);
		waitUntilElementIsVisible(NoCasesInfoMsg);
		String NoCasesMsg = getTextElement(NoCasesInfoMsg);
		SoftAssert s21 = new SoftAssert();
		s21.assertEquals(NoCasesMsg, "No cases to display");
		s21.assertAll();

	}

	public void CLP_VerifyAdditionOfColumns() throws InterruptedException {

		clickByJsExecuter(ClearAllFiltersLink);
		waitForCurserRunning(3);
		WaitForGridTableEnable();
		forcedWaitTime(4);
		waitForElementIsInteractable(ColumnControlWidget);
		clickOn(ColumnControlWidget);

		waitForElementIsInteractable(ColumnOutstandingBalance);
		System.out.println(driver.findElement(ColumnOutstandingBalance).isSelected());

		if (driver.findElements(RestoreDefaultsLink).size() == 0) {
			clickOn(ColumnOutstandingBalance);
		}
		waitForElementIsInteractable(CloseColumnControl);
		clickOn(CloseColumnControl);
		forcedWaitTime(2);
		WebElement ColumnAdded = waitUntilVisibleWE(ColumnOutstandingBalanceCLP);
		if ((ColumnAdded.isDisplayed() == false)) {

			SoftAssert s22 = new SoftAssert();
			s22.assertEquals(false, true);
			s22.assertAll();
		}

	}

	public void CLP_VerifyRestorationOfCheckedBoxes() throws InterruptedException {

		waitForElementIsInteractable(ColumnControlWidget);
		clickOn(ColumnControlWidget);
		waitForElementIsInteractable(RestoreDefaultsLink);
		clickOn(RestoreDefaultsLink);
		forcedWaitTime(2);
		waitUntilElementIsVisible(ColumnOutstandingBalance);
		WebElement OBColumn = waitUntilVisibleWE(ColumnOutstandingBalance);
		if ((OBColumn.isSelected() == true)) {

			SoftAssert s23 = new SoftAssert();
			s23.assertEquals(false, true);
			s23.assertAll();
		}

	}

	public void CLP_VerifyAddedColumnsAfterRestoreDefaultsLink() throws InterruptedException {

		clickOn(ColumnOutstandingBalance);

		waitForElementIsInteractable(RestoreDefaultsLink);
		clickOn(RestoreDefaultsLink);

		waitForElementIsInteractable(CloseColumnControl);
		clickOn(CloseColumnControl);

		waitUntilElementIsVisible(ColumnOutstandingBalanceCLP);
		List<WebElement> ColumnRemoved = driver.findElements(ColumnOutstandingBalanceCLP);
		if ((ColumnRemoved.size()) != 0) {

			SoftAssert s24 = new SoftAssert();
			s24.assertEquals(false, true);
			s24.assertAll();
		}

	}

	public void CLP_OpenSaveAsPopup() throws InterruptedException {

		waitUntilElementIsVisible(FiltersDropdown);
		waitForElementIsInteractable(FiltersDropdown);
		clickByJsExecuter(FiltersDropdown);

		int CountFiltersCross = driver.findElements(CrossIconFilters).size();
		if (CountFiltersCross > 0) {
			List<WebElement> DeleteFilters = waitUntilVisibleList(CrossIconFilters);
			for (int d = 0; d < CountFiltersCross - 2; d++) {
				WebElement CrossIcons = DeleteFilters.get(d);
				CrossIcons.click();

				waitForElementIsInteractable(CCPUtility.YesDelete);
				clickOn(CCPUtility.YesDelete);
			}
			waitForElementIsInteractable(FiltersDropdown);
			clickOn(FiltersDropdown);
		}

		forcedWaitTime(2);
		waitForElementIsInteractable(SaveAsButton);
		clickOn(SaveAsButton);
		waitForElementIsInteractable(SaveAsPopup);
		WebElement SaveasPopup = waitUntilVisibleWE(SaveAsPopup);
		if ((SaveasPopup.isDisplayed() == false)) {

			SoftAssert s25 = new SoftAssert();
			s25.assertEquals(false, true);
			s25.assertAll();

		}

	}

	public void CLP_VerifyValidationMessageForSaveBtn() throws InterruptedException {
		waitUntilElementIsVisible(SaveButton);
		waitForElementIsInteractable(SaveButton);
		clickOn(SaveButton);
		waitUntilElementIsVisible(ErrorMsgSaveAsPopup);
		WebElement ErrorMsg = waitUntilVisibleWE(ErrorMsgSaveAsPopup);
		if ((ErrorMsg.isDisplayed() == false)) {

			SoftAssert s26 = new SoftAssert();
			s26.assertEquals(false, true);
			s26.assertAll();
		}

	}

	public void CLP_VerifySavedFilter() throws InterruptedException {

		waitUntilElementIsVisible(FilterNameField);
		waitForElementIsInteractable(FilterNameField);
		String FilterNameRandom = RandomStrings.requiredString(6);
		sendKeysWithWait(FilterNameField, "Filter " + (FilterNameRandom));

		waitForElementIsInteractable(SaveButton);
		clickOn(SaveButton);

		waitForElementIsInteractable(FiltersDropdown);
		clickOn(FiltersDropdown);
		forcedWaitTime(5);

	}

	public void CLP_VerifyDeletionOfSavedFilter() throws InterruptedException {

		waitForElementIsInteractable(CountFiltersSaveAs);
		List<WebElement> CountFilters = waitUntilVisibleList(CountFiltersSaveAs);
		int FiltersCount = CountFilters.size();
		waitForElementIsInteractable(CrossIconFilters);
		clickOn(CrossIconFilters);
		waitForElementIsInteractable(CCPUtility.YesDelete);
		clickOn(CCPUtility.YesDelete);
		waitUntilElementIsVisible(CountFiltersSaveAs);
		waitForElementIsInteractable(CountFiltersSaveAs);
		forcedWaitTime(4);
		List<WebElement> CountFiltersAfter = waitUntilVisibleList(CountFiltersSaveAs);
		int FiltersCountAfter = CountFiltersAfter.size();
		if ((FiltersCountAfter < FiltersCount) == false) {
			System.out.println(FiltersCountAfter + " " + FiltersCount);
			SoftAssert s28 = new SoftAssert();
			s28.assertEquals(false, true);
			s28.assertAll();

		}

	}

	public void CLP_OpenCCPFromCreateCaseBtn() throws InterruptedException {
		waitForElementIsInteractable(CreateCaseButtonCLP);
		clickOn(CreateCaseButtonCLP);

		waitUntilElementIsVisible(CCPUtility.ViolationsTile);
		WebElement CCPElement = waitUntilVisibleWE20(CCPUtility.ViolationsTile);
		if ((CCPElement.isDisplayed()) == false) {

			SoftAssert s29 = new SoftAssert();
			s29.assertEquals(false, true);
			s29.assertAll();

		}

	}

	public void CLP_VerifyCSVFileDownloaded() throws InterruptedException {
		waitForElementIsInteractable(CancelButtonCCP);
		clickByJsExecuter(CancelButtonCCP);

		waitUntilElementIsVisible(ClearAllFiltersLink);
		Boolean flag = elementIsDisplayed(ClearAllFiltersLink);
		if (flag) {
			waitUntilElementIsVisible(ClearAllFiltersLink);
			waitForElementIsInteractable(ClearAllFiltersLink);
			clickByJsExecuter(ClearAllFiltersLink);
		}
		waitUntilElementIsVisible(DownloadButton);
		waitUntilElementPresent(DownloadButton);
		waitForElementIsInteractable(DownloadButton);
		clickOn(DownloadButton);
		waitUntilElementIsVisible(CSVOption);
		waitForElementIsInteractable(CSVOption);
		clickOn(CSVOption);
		waitForCurserRunning(3);
		driver.getTitle();
		CheckDownloadedFile.isFileDownloaded("AUTOMATION_NEW_AGENCY_06-21-2022_03_46 am.csv");

	}

	public void CLP_VerifyDirectionToCDP() throws InterruptedException {
		forcedWaitTime(3);
		waitForElementIsInteractable(CaseID);
		String FirstCasID = getTextElement(CaseID);
		clickOn(CaseID);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(OpenedCaseId);
		String[] OpenedID = getTextElement(OpenedCaseId).split(" #");
		String OpenedCase = OpenedID[1];

		SoftAssert s31 = new SoftAssert();
		s31.assertEquals(OpenedCase, FirstCasID);
		s31.assertAll();

	}

	public void CLP_VerifyDirectionToCLPPreview() throws InterruptedException {
		waitUntilElementIsVisible(CloseCaseIcon);
		waitForElementIsInteractable(CloseCaseIcon);
		clickOn(CloseCaseIcon);
		waitUntilElementIsVisible(PrintButtonCLP);
		waitUntilElementPresent(PrintButtonCLP);
		waitForElementIsInteractable(PrintButtonCLP);
		clickByJsExecuter(PrintButtonCLP);
		waitForCurserRunning(3);
		forcedWaitTime(5);
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		driver.switchTo().window(currentWindow);

	}

	public void CLP_VerifyMineButtonApplication() throws InterruptedException {

		CLP_VerifyCLPOpensUp();
		waitForCurserRunning(3);
		waitUntilElementIsVisible(MineButtonCLP);
		waitUntilElementPresent(MineButtonCLP);
		waitForElementIsInteractable(MineButtonCLP);
		clickOn(MineButtonCLP);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(CaseID);
		waitUntilElementPresent(CaseID);
		waitUntilElementPresent(By.xpath("//input[@class='checkbox__input'][@type='checkbox']"));
		waitForElementIsInteractable(By.xpath("//input[@class='checkbox__input'][@type='checkbox']"));
		List<WebElement> AllCasesID = waitUntilVisibleList(CaseID);
		int CountIDs = AllCasesID.size();
		String LoggedInUserName = getTextElement(AgencyUserName);
		waitUntilElementPresent(AssigneeColumn);
		waitUntilElementIsVisible(AssigneeColumn);
		scrollIntoView(AssigneeColumn);
		forcedWaitTime(3);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		
		//Fetch index where asignee column is present
		int indexOfAssigneeColumn = 0;
		List<WebElement> columns = findElementsByXPath(CDP_Utility.columnHeadingsOnCDP);
		System.out.println("size is " + columns.size());
		for (int i = 0; i <= columns.size() - 1; i++) {
			if (columns.get(i).getText().contains("Assignee")) {
				System.out.println("text found " + columns.get(i).getText());
				indexOfAssigneeColumn = i;
				break;
			}
		}
			indexOfAssigneeColumn=indexOfAssigneeColumn+1;
			System.out.println("index of assignee "+indexOfAssigneeColumn);
		
		List<WebElement> AssigneeList = driver
				.findElements(By.xpath("//div[@role='gridcell'][" +indexOfAssigneeColumn+"]"));
		int matched = 0;
		for (int i = 0; i < AssigneeList.size(); i++) {
			WebElement MatchAssignee = AssigneeList.get(i);
			waitForElementInteractable(MatchAssignee);
			String MatchUser = MatchAssignee.getText();
			System.out.println("Name of asisgnee "+MatchUser);
			if (MatchUser.equals(LoggedInUserName)) {
				matched++;
			}
		}
		boolean CompareCount = (matched == CountIDs);
		Reporter.log("How many matched "+matched+" "+CountIDs);
		Assert.assertTrue(CompareCount);

	}

	public void VerifyEscalatedColAndPendingApprovalStatus() throws InterruptedException {
		
		ceMethods.createCaseWithCustomeNotices("EscalatedNotice");
		ceMethods.closeCaseDetailPage();
		ceMethods.navigationToCaseListPage();
		WaitForGridTableEnable();
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		Boolean EsclatedCol = findElementByXPath(stringFormat(CLPColumn, "Escalated Notice Status")).isDisplayed();
		Boolean PendingApprovel = findElementByXPath(stringFormat(CLPColumn, "Pending Supervisor Approval")).isDisplayed();
		Assert.assertTrue(EsclatedCol, "Escalated Notice Status is not present.");
		Assert.assertTrue(PendingApprovel, "Pending Supervisor Approval is not present.");
	}

	public void VerifyEsclatedColStatusApproved() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("(//div[@role='grid']//a)[1]"));
		String CaseId = findElementByXPath("(//div[@role='grid']//a)[1]").getText();
		forcedWaitTime(3);
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginSupervisorManager_QAProdStage();
		Thread.sleep(2000);
		ceMethods.searchCaseAndNavigateToCDP(CaseId);
		waitUntilElementIsVisible(By.xpath("//button[text()='Approve Notice']"));
		ceMethods.approvedPendingEsclatedNoticeCDP();
		ceMethods.closeCaseDetailPage();
		waitForCurserRunning(5);
		Thread.sleep(4000);
		refreshPage();
		waitForCurserRunning(5);
		Thread.sleep(2000);
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.LoginAgency();
		ceMethods.searchCaseoOnCLP(CaseId);
		WaitForGridTableEnable();
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		Boolean EsclatedCol = findElementByXPath(stringFormat(CLPColumn, "Escalated Notice Status")).isDisplayed();
		Boolean PendingApprovel = findElementByXPath(stringFormat(CLPColumn, "Approved")).isDisplayed();
		Assert.assertTrue(EsclatedCol, "Escalated Notice Status is not present.");
		Assert.assertTrue(PendingApprovel, "Approved is not present.");
	}

	public void VerifyEsclatedColStatusApprovedAppliedCase() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath("(//div[@role='grid']//a)[1]"));
		String CaseId = findElementByXPath("(//div[@role='grid']//a)[1]").getText();
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginSupervisorManager_QAProdStage();
		Thread.sleep(2000);
		ceMethods.searchCaseAndNavigateToCDP(CaseId);
		ceMethods.applyEsclatedNoticeCDP();
		ceMethods.closeCaseDetailPage();
		waitForCurserRunning(5);
		Thread.sleep(4000);
		refreshPage();
		waitForCurserRunning(5);
		Thread.sleep(5000);
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}
		log.LoginAgency();
		ceMethods.searchCaseoOnCLP(CaseId);
		WaitForGridTableEnable();
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		Boolean EsclatedCol = findElementByXPath(stringFormat(CLPColumn, "Escalated Notice Status")).isDisplayed();
		Boolean PendingApprovel = findElementByXPath(stringFormat(CLPColumn, "Approved & Applied to Case"))
				.isDisplayed();
		Assert.assertTrue(EsclatedCol, "Escalated Notice Status is not present.");
		Assert.assertTrue(PendingApprovel, "Approved & Applied to Case is not present.");
	}

	public void VerifyEsclatedColStatusNotApproved() throws InterruptedException {
		ceMethods.createCaseWithCustomeNotices("EscalatedNotice");
		String CaseId = getTextElement(By.xpath("//h2[@class='case-details__case-number']")).split("#")[1];
		ceMethods.closeCaseDetailPage();
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}

		log.loginSupervisorManager_QAProdStage();
		Thread.sleep(2000);
		ceMethods.searchCaseAndNavigateToCDP(CaseId);
		ceMethods.rejectORNotApprovedEsclatedNoticeCDP();
		ceMethods.closeCaseDetailPage();
		waitForCurserRunning(5);
		Thread.sleep(4000);
		refreshPage();
		waitForCurserRunning(5);
		Thread.sleep(5000);
		log.LogOut();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//*[@class='app-header__user-name']/div")).size() > 0) {
			log.LogOut();
		}
		log.LoginAgency();
		ceMethods.searchCaseoOnCLP(CaseId);
		WaitForGridTableEnable();
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		Boolean EsclatedCol = findElementByXPath(stringFormat(CLPColumn, "Escalated Notice Status")).isDisplayed();
		Boolean PendingApprovel = findElementByXPath(stringFormat(CLPColumn, "Not Approved")).isDisplayed();
		Assert.assertTrue(EsclatedCol, "Escalated Notice Status is not present.");
		Assert.assertTrue(PendingApprovel, "Not Approved");

	}

	public void VerifyEsclatedColStatusSecondaryFilter() throws InterruptedException {
		scrollIntoView(ClearAllFiltersLink);
		clickByJsExecuter(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(ClearAllFiltersLink);
		WaitForGridTableEnable();
		ceMethods.navigationToCaseListPage();
		WaitForGridTableEnable();
		waitUntilElementIsVisible(FilterSlider);
		waitForElementIsInteractable(FilterSlider);
		clickByJsExecuter(FilterSlider);
		waitUntilElementIsVisible(By.xpath(stringFormat(SecondaryFilters, "checkbox-escalatedNoticeStatus")));
		Boolean secondaryFilter = elementIsDisplayed(
				By.xpath(stringFormat(SecondaryFilters, "checkbox-escalatedNoticeStatus")));
		clickByJsExecuter(By.xpath(stringFormat(SecondaryFilters, "checkbox-escalatedNoticeStatus")));
		clickOn(FilterSliderClose);
		waitUntilElementIsVisible(By.xpath(stringFormat(SecondaryFilters, "checkbox-escalatedNoticeStatus")));
		Boolean EsclatedNoticesecondaryFilters = elementIsDisplayed(
				By.xpath(stringFormat(SecondaryFilters, "escalatedNoticeStatus")));
		Assert.assertTrue(secondaryFilter, "Esclated Notice Status Secandary Filter Label is not present.");
		Assert.assertTrue(EsclatedNoticesecondaryFilters, "Esclated Notice Status Secandary Filter is not present.");
	}

	public void VerifyEsclatedColStatusPendingApprovalFilter() throws InterruptedException {
		ceMethods.escaltedNoticeFilterApply("Pending Supervisor Approval");
		waitUntilElementPresent(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		scrollIntoView(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		WaitForGridTableEnable();
		forcedWaitTime(5);
		List<WebElement> EsclatedNoitceStatus = driver
				.findElements(By.xpath("(//div[@class='rt-td'][@role='gridcell'])[6]"));
		Boolean matched = true;
		for (int i = 0; i < EsclatedNoitceStatus.size(); i++) {
			WebElement MatchAssignee = EsclatedNoitceStatus.get(i);
			waitForElementInteractable(MatchAssignee);
			String MatchUser = MatchAssignee.getText();
			if (MatchUser.equals("Pending Supervisor Approval")) {
				matched = true;
			} else {
				matched = false;
			}
		}
		Assert.assertTrue(matched);
	}

	public void VerifyEsclatedColStatusApprovedandAppliedCaseFilter() throws InterruptedException {
		// Clean Up Filter
		clickByJsExecuter(By.xpath(stringFormat(CLPUtility.SecondaryFilterCriteria, "Pending Supervisor Approval")));
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
		clickByJsExecuter(By.xpath(stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
		waitUntilElementPresent(By.xpath("//div[@class='dropdown__wrapper  dropdown__wrapper--open']"));
		WaitForGridTableEnable();
		ceMethods.escaltedNoticeFilterApply("Approved And Applied To Case");
		waitUntilElementPresent(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		scrollIntoView(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		WaitForGridTableEnable();
		forcedWaitTime(5);
		List<WebElement> EsclatedNoitceStatus = driver
				.findElements(By.xpath("(//div[@class='rt-td'][@role='gridcell'])[6]"));
		Boolean matched = false;
		for (int i = 0; i < EsclatedNoitceStatus.size(); i++) {
			WebElement MatchAssignee = EsclatedNoitceStatus.get(i);
			waitForElementInteractable(MatchAssignee);
			String MatchUser = MatchAssignee.getText();
			if (MatchUser.equals("Approved & Applied to Case")) {
				matched = true;
			} else {
				matched = false;
			}
		}
		Assert.assertTrue(matched);
	}

	public void VerifyEsclatedColStatusApprovedFilter() throws InterruptedException {
		clickByJsExecuter(By.xpath(stringFormat(CLPUtility.SecondaryFilterCriteria, "Approved And Applied To Case")));
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
		clickByJsExecuter(By.xpath(stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
		waitUntilElementPresent(By.xpath("//div[@class='dropdown__wrapper  dropdown__wrapper--open']"));
		WaitForGridTableEnable();
		ceMethods.escaltedNoticeFilterApply("Approved");
		waitUntilElementPresent(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		waitUntilElementIsVisible(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		scrollIntoView(By.xpath(stringFormat(CLPColumn, "Escalated Notice Status")));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		WaitForGridTableEnable();
		forcedWaitTime(5);
		List<WebElement> EsclatedNoitceStatus = driver
				.findElements(By.xpath("(//div[@class='rt-td'][@role='gridcell'])[6]"));
		Boolean matched = false;
		for (int i = 0; i < EsclatedNoitceStatus.size(); i++) {
			WebElement MatchAssignee = EsclatedNoitceStatus.get(i);
			waitForElementInteractable(MatchAssignee);
			String MatchUser = MatchAssignee.getText();
			if (MatchUser.equals("Approved")) {
				matched = true;
			} else {
				matched = false;
			}
		}
		Assert.assertTrue(matched);
	}

// new prod bug
	public void CLP_VerifyCountForSearchCreiteria(String s) throws InterruptedException {

		waitUntilElementIsVisible(By.xpath(cLPSearchField));
		sendKeysWithWait(By.xpath(cLPSearchField), s);
		forcedWaitTime(5);
		CLP_VerifyTotalCountOfCases();
	}

	public void selectCaseStatusOnCLP(String status) throws InterruptedException {
		waitUntilElementIsVisible(
				By.xpath("//div[@class='dropdown__wrapper']//div[@class='dropdown__selector__selected']"));
		clickByJsExecuter(By.xpath("//div[@class='dropdown__wrapper']//div[@class='dropdown__selector__selected']"));
		forcedWaitTime(2);

		if (status == "Open") {
			clickByJsExecuter(By.xpath("//input[@id='abatementStage-checkbox-1']"));
		} else {
			clickByJsExecuter(By.xpath("//input[@id='abatementStage-checkbox-0']"));
		}

		forcedWaitTime(3);
		clickOn(By.xpath("//label[normalize-space()='Case Status']"));

	}

}
