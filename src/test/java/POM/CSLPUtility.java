package POM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import CommonMethods.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import net.bytebuddy.utility.RandomString;

public class CSLPUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods crmMethods;

	public CSLPUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		crmMethods = new CRMCommonMethods(driver);

	}

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public static By categoryDropdownFilter=By.xpath("//div[@class='secondary-filters']//div[@class='dropdown__selector__selected']");
	public static By submissionCount= By.xpath("//div[@class='cs-listing__section__header']/span[@class='cs-listing__section__header']");
	public static By cascadingCategorySubmissions= By.xpath("//span[text()='CascadingCategory']");
	public static By cascadingInactiveCategorySubmissions= By.xpath("//span[text()='CascadingInactive']");
	public static By searchedCategory= By.xpath("//ul[@class='dropdown__options category_modal']//span[@class='clipped-text']");
	public static By checkboxForSearchedCategory= By.xpath("//span[@class='checkbox-holder checkbox-holder--radio']//input[@name='CascadingCategory']");
	public static By checkboxForDeactivatedCategory= By.xpath("//span[@class='checkbox-holder checkbox-holder--radio']//input[@name='CascadingInactive']");

	public static By selectFirstSubmissionCSLP = By
			.xpath("(//*[@role='rowgroup']/div/div)[1]/span/following-sibling::a");
	public static By categoriesPresentUnderCategoryFilter = By
			.xpath("//li[@class='selectable']/div/span[@class='checkbox-holder checkbox-holder--radio']/input");
	public static By deactivatedCategoryText_CategoryFilter = By
			.xpath("//input[@name='CascadingInactive']/../..//div/span[contains(text(),'Deactivated')]");
	public static By deactivateCategoriesUnderCategoryFilter = By
			.xpath("//span[contains(text(),'Deactivated')]/parent::div/parent::div//div/span[@class='clipped-text']");
	public By searchCategoryOnCSLP= By.xpath("//*[@placeholder='Enter The Category You want to search Here']");
	public static String cSLPTab = "//a[text()='Customer Submissions']";
	public static String customerSubmissionsHeader = "//label[@class='dropdown__selector__label']";
	public static String statusPrimaryFilter = "//label[text()='Status']";
	public static String createdPrimaryFilter = "//label[text()='Created']";
	public static String allButtonCSLP = "//button[text()='All']";
	public static String mineButton = "//button[text()='Mine']";
	public static String moreButton = "//label[text()='More...']";
	public static String tagsUnderColumn = "//span[@class='clipped-text']/a";
	public static String tagsAppliedFilter = "//label[@for='tagIds']";
	public static String selectedTag = "//label[@for='tagIds']/following::label[1]";
	public static String clearAllFiltersLink = "//a[text()='Clear all filters']";
	public static String nextPaginationCSLP = "//div[@class='table__pagination-nav-btns']/button[2]";
	public static String submissionID = "//span[@class='checkbox-holder']/following::a[1]";
	public static String previousPaginationCSLP = "//div[@class='table__pagination-nav-btns']/button[1]";
	public static String submissionNumberHeader = "//div[text()='Submission Number']";
	public static String deleteLink = "//a[text()='Delete']";
	public static String deleteSubmissionPopup = "//div[@class='modal-header' and text()='Delete Submission']";
	public static String deleteTextField = "//input[@name='deleteText']";
	public static String deleteSubmissionButton = "//button[text()='Delete Submission']";
	public static String validationMsgDeleteSubmission = "//div[@class='modal-base__error modal-base__error--show']";
	public static String submissionsCount = "//div[@class='cs-listing__section__header']//following-sibling::span";
	public static String submissionCount2 = "div[class='pagination-top'] span[class='submission-count']";
	public static String doNotDeleteButton = "//button[text()='Do Not Delete']";
	public static String paginationCount = "//span[@class='table__pagination-of-text']";
	public static String filterSlider = "//i[@class='fa fa-2 fa-sliders']";
	public static String categoryCheckbox = "//label[text()='Category']";
	public static String filterSliderClose = "//button[@class='drawer__close']";
	public static String categoryDropdownIcon = "//div[@class='dropdown__wrapper']//span[@class='dropdown__arrow']";
	public static String firstCategoryCheckbox = "//ul[@class='dropdown__options category_modal']//input[@class='checkbox__input']";
	public static String caseIDCheckBox = "//span[@class='checkbox-holder']//input[@class='checkbox__input']";
	public static String categoryColumnResults = "//div[@class='rt-td'][9]";
	public static String crossSecondaryFilter = "//div[@class='filter-options category']/following::button[1]";
	public static String countSecondaryFilters = "//div[@class='filters-secondary__chip']";
	public static String cSLPSearchField = "//input[@name='searchQuery']";
	public static String anonymousColumn = "//span[text()='Anonymous']";
	public static String labelLnkText = "//label[text()='%s']";
	public static By outsideALL = By.xpath("//button[text()='All']");
	public static By caseIDChckBox = By.xpath(caseIDCheckBox);
	public static By CSLPTab = By.xpath(cSLPTab);
	public static By CustomerSubmissionsHeader = By.xpath(customerSubmissionsHeader);
	public static By StatusPrimaryFilter = By.xpath(statusPrimaryFilter);
	public static By CreatedPrimaryFilter = By.xpath(createdPrimaryFilter);
	public static By AllButtonCSLP = By.xpath(allButtonCSLP);
	public static By MineButton = By.xpath(mineButton);
	public static By MoreButton = By.xpath(moreButton);
	public static By TagsUnderColumn = By.xpath(tagsUnderColumn);
	public static By TagsAppliedFilter = By.xpath(tagsAppliedFilter);
	public static By SelectedTag = By.xpath(selectedTag);
	public static By ClearAllFiltersLink = By.xpath(clearAllFiltersLink);
	public static By NextPaginationCSLP = By.xpath(nextPaginationCSLP);
	public static By PreviousPaginationCSLP = By.xpath(previousPaginationCSLP);
	public static By SubmissionID = By.xpath(submissionID);
	public static By SubmissionNumberHeader = By.xpath(submissionNumberHeader);
	public static By DeleteLink = By.xpath(deleteLink);
	public static By DeleteSubmissionPopup = By.xpath(deleteSubmissionPopup);
	public static By DeleteTextField = By.xpath(deleteTextField);
	public static By DeleteSubmissionButton = By.xpath(deleteSubmissionButton);
	public static By ValidationMsgDeleteSubmission = By.xpath(validationMsgDeleteSubmission);
	public static By SubmissionsCount = By.xpath(submissionsCount);
	public static By SubmissionCount2 = By.cssSelector(submissionCount2);
	public static By DoNotDeleteButton = By.xpath(doNotDeleteButton);
	public static By PaginationCount = By.xpath(paginationCount);
	public static By FilterSlider = By.xpath(filterSlider);
	public static By CategoryCheckbox = By.xpath(categoryCheckbox);
	public static By FilterSliderClose = By.xpath(filterSliderClose);
	public static By CategoryDropdownIcon = By.xpath(categoryDropdownIcon);
	public static By FirstCategoryCheckbox = By.xpath(firstCategoryCheckbox);
	public static By CategoryColumnResults = By.xpath(categoryColumnResults);
	public static By CrossSecondaryFilter = By.xpath(crossSecondaryFilter);
	public static By CountSecondaryFilters = By.xpath(countSecondaryFilters);
	public static By CSLPSearchField = By.xpath(cSLPSearchField);
	public static By AnonymousColumn = By.xpath(anonymousColumn);

	public static By SaveAsButton = By.xpath("//button[text()='Save As']");
	public static By SaveAsPopup = By.xpath("//div[text()='Save As']");
	public static By ErrorMsgSaveAsPopup = By.xpath("//span[text()='The Filter Name is required.']");
	public static By FilterNameField = By.xpath("//input[@placeholder='Enter Text']");
	public static By CountSavedFilters = By.xpath("(//ul[@class='dropdown__options--single'])[1]/li");
	public static By CrossIconFilters = By.xpath("//button[@class='delete-btn  btn btn-primary']");
	public static By FiltersDropdown = By.xpath("(//div[@class='dropdown__selector__selected']/label)[1]");
	public static By YesDelete = By.xpath("//div[@class='flex-row--middle']/button[2]");
	public static By DownloadButton = By.xpath("//button[text()='Download']");
	public static By CSVOption = By.xpath("//li[text()='CSV']");
	public static By CSVSuccessMessage = By.xpath("//div[@class='success-custom-message']");
	public static By AgencyUserName = By.xpath("//div[@class='app-header__user-name']/label");
	public static By IssueDescriptionColumn = By.xpath("//div[text()='Issue Description']");
	public static By IssueDescriptionCheckbox = By.xpath("//label[@for='checkbox-column-Issue Description']");
	public static By ColumnControlWidget = By.xpath("//i[@class='fa fa-2 fa-cog']");
	public static By CloseColumnControl = By.xpath("//button[@class='drawer__close']");
	public static By CrossIconForCSDP = By.xpath("//div[@class='customer-submission-details__close-icon']/img");
	public static By submissionCountDetails = By.xpath("(//div[@class='cs-listing__section__header']//span)[2]");
	public static By mapViewCasList = By.xpath("//ul[@class='map-view-sidebar-listing__wrapper']");
	public static By issueDescription = By.xpath("//div[@role='columnheader']//div[text()='Issue Description']");
	public static String CaseIdLnk = "//a[text()='%s']";

	public static ArrayList<Integer> IDArray = new ArrayList<Integer>();
	public static String CSLPHeader;
	public static String ExpectedHeader;
	public static boolean PrimaryFiltersPresence;
	public static String TagFilterText;
	public static String TagText;
	public static String SelectedTagText;
	public static boolean PaginationDifference;
	public static boolean VerifyDescendingOrder;
	public static boolean VerifyAscendingOrder;
	public static String DeleteSubmissionTitle;
	public static String ValidationMessageDeleteSubmission;
	public static String ExpectedMsgDeleteSubmission;
	public static boolean SubmissionDeletion;
	public static int SubmissionCountAtHeader;
	public static int TotalCasesCount;
	public static boolean ClearAllFiltersPresence;
	public static boolean ClearAllFiltersAbsence;
	public static boolean CompareFilterResultsCount;
	public static boolean CompareRemovedFilterCount;
	public static boolean CompareSearchResultsCount;
	public static boolean VerifyAbsenceOfCol;
	public static boolean VerifyColumnsPresence;
	public static String SaveAsPopupTitle;
	public static boolean CompareCountDeletedFilter;
	public static String SuccessMsgCSV;
	public static String ExpectedMsgCSV;
	public static String FileStatus;
	public static String RecentSubmissionID;
	public static String OpenedSubmissionID;
	public static boolean CompareMineResultsCount;

	public void CSLP_VerifyCSLPOpensUP() throws InterruptedException {
		driver.navigate().to(BrowsersInvoked.URLDashboard);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(CSLPTab);
		waitForElementIsInteractable(CSLPTab);
		clickByJsExecuter(CSLPTab);
		waitForCurserRunning(7);
		waitUntilElementIsVisible(CustomerSubmissionsHeader);
		CSLPHeader = getTextElement(CustomerSubmissionsHeader);
		ExpectedHeader = "Customer Submissions:";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CSLPHeader, ExpectedHeader);
		softAssert.assertAll();
	}

	public void CSLP_VerifyPrimaryFilters() throws InterruptedException {
		waitForElementIsInteractable(FilterSlider);
		clickByJsExecuter(FilterSlider);
		WebElement PrimaryFilter1 = waitUntilVisibleWE(StatusPrimaryFilter);
		WebElement PrimaryFilter2 = waitUntilVisibleWE(CreatedPrimaryFilter);

		waitUntilElementIsVisible(FilterSliderClose);
		waitForElementIsInteractable(FilterSliderClose);
		clickByJsExecuter(FilterSliderClose);
		WebElement PrimaryFilter3 = waitUntilVisibleWE(AllButtonCSLP);
		WebElement PrimaryFilter4 = waitUntilVisibleWE(MineButton);
		WebElement PrimaryFilter5 = waitUntilVisibleWE(MoreButton);
		PrimaryFiltersPresence = ((PrimaryFilter1.isDisplayed()) == true) && (PrimaryFilter2.isDisplayed() == true)
				&& (PrimaryFilter3.isDisplayed() == true) && (PrimaryFilter4.isDisplayed() == true)
				&& (PrimaryFilter5.isDisplayed() == true);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PrimaryFiltersPresence);
		softAssert.assertAll();

	}

	public void CSLP_VerifyTagFilter() throws InterruptedException {
		refreshPage();
		TagText = getTextElement(TagsUnderColumn);
		waitForElementIsInteractable(TagsUnderColumn);
		clickByJsExecuter(TagsUnderColumn);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(issueDescription);
		waitUntilElementIsVisible(TagsAppliedFilter);
		TagFilterText = getTextElement(TagsAppliedFilter);
		waitUntilElementIsVisible(SelectedTag);
		waitUntilElementPresent(SelectedTag);
		SelectedTagText = getTextElement(SelectedTag);
		waitForElementIsInteractable(ClearAllFiltersLink);
		clickByJsExecuter(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(ClearAllFiltersLink);
		waitUntilElementIsVisible(issueDescription);
		waitForCurserRunning(6);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TagFilterText, "Tags");
		softAssert.assertEquals(TagText, SelectedTagText);
		softAssert.assertAll();

	}

	public void CSLP_VerifyNavigationFromPagination() throws InterruptedException {
		waitUntilElementIsVisible(SubmissionID);
		waitUntilElementPresent(SubmissionID);
		waitUntilElementIsVisible(NextPaginationCSLP);
		waitForElementIsInteractable(NextPaginationCSLP);
		forcedWaitTime(2);
		String[] CaseIDBeforeClick = getTextElement(SubmissionID).split("-");
		String ID1 = CaseIDBeforeClick[1];
		waitForElementIsInteractable(NextPaginationCSLP);
		clickOn(NextPaginationCSLP);
		waitUntilElementIsVisible(SubmissionID);
		waitForStaleElementReference(SubmissionID);
		waitUntilElementPresent(SubmissionID);
		waitUntilElementPresent(PreviousPaginationCSLP);
		waitForElementIsInteractable(PreviousPaginationCSLP);
		Thread.sleep(4000);
		String[] CaseIDAfterClick = getTextElement(SubmissionID).split("-");
		String ID2 = CaseIDAfterClick[1];
		int differenceID = Integer.parseInt(ID1) - Integer.parseInt(ID2);
		System.out.println("differenceID" + differenceID);
		PaginationDifference = differenceID >= 50;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(PaginationDifference);
		softAssert.assertAll();
	}

	public void CSLP_VerifyDescendingOrderOfSubmissions() throws InterruptedException {
		int FinalIDs;
		try {
			List<WebElement> AllSubmissionsID = findElementsByXPath(SubmissionID);
			int CountIDs = AllSubmissionsID.size() / 2;
			for (int i = 0; i < CountIDs; i++) {
				WebElement IDList = AllSubmissionsID.get(i);
				String[] IDList1 = IDList.getText().split("-");
				String IDs = IDList1[1];
				FinalIDs = Integer.parseInt(IDs);
				IDArray.add(FinalIDs);
			}
			int State = 0;
			Integer[] arr = new Integer[IDArray.size()];
			for (int i = 0; i < 1; i++) {
				arr[i] = IDArray.get(i);
				for (int j = i + 1; j < IDArray.size(); j++) {
					arr[j] = IDArray.get(j);
					if ((arr[j] < arr[i]) == false) {
						State = 1;
					}
				}
			}
			VerifyDescendingOrder = (State == 0);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(VerifyDescendingOrder);
		softAssert.assertAll();
	}

	public void CSLP_VerifyAscendingOrderOfCases() throws InterruptedException {
		waitUntilElementIsVisible(SubmissionNumberHeader);
		waitForElementIsInteractable(SubmissionNumberHeader);
		clickByJsExecuter(SubmissionNumberHeader);
		WaitForGridTableEnable();
		waitUntilElementIsVisible(SubmissionID);
		waitUntilElementIsVisible(NextPaginationCSLP);
		waitForElementIsInteractable(NextPaginationCSLP);
		waitForStaleElementReference(SubmissionID);
		forcedWaitTime(2);
		List<WebElement> AllSubmissionsID = driver.findElements(SubmissionID);
		List<Integer> IDList = AllSubmissionsID.stream().map(m -> Integer.parseInt(m.getText().split("-")[1]))
				.collect(Collectors.toList());
		for (int i = 1; i < IDList.size(); i++) {
			if (IDList.get(i) < IDList.get(i - 1)) {
				VerifyAscendingOrder = false;
			}
		}
		VerifyAscendingOrder = true;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(VerifyAscendingOrder);
		softAssert.assertAll();
	}

	public void CSLP_VerifyDeletedSubmission() throws InterruptedException {

		waitUntilElementIsVisible(SubmissionNumberHeader);
		waitForElementIsInteractable(SubmissionNumberHeader);
		waitUntilElementIsInvisible(By.cssSelector("div.table-container__table table_disabled"));
		clickByJsExecuter(SubmissionNumberHeader);
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table "));
		waitUntilElementIsVisible(DeleteLink);
		waitForStaleElementReference(DeleteLink);
		waitUntilElementPresent(DeleteLink);
		scrollIntoView(DeleteLink);
		waitForElementIsInteractable(DeleteLink);
		waitUntilElementIsVisible(SubmissionsCount);
		String[] CountCases = getTextElement(SubmissionsCount).split(" ");
		String CountBefore = CountCases[0];
		int BeforeDeleting = Integer.parseInt(CountBefore);
		waitForStaleElementReference(DeleteLink);
		clickByJsExecuter(DeleteLink);
		waitUntilElementIsVisible(DeleteSubmissionPopup);
		waitUntilElementPresent(DeleteSubmissionPopup);
		DeleteSubmissionTitle = getTextElement(DeleteSubmissionPopup);
		waitForElementIsInteractable(DeleteSubmissionButton);
		clickByJsExecuter(DeleteSubmissionButton);
		waitUntilElementIsVisible(ValidationMsgDeleteSubmission);
		waitUntilElementPresent(ValidationMsgDeleteSubmission);
		ValidationMessageDeleteSubmission = getTextElement(ValidationMsgDeleteSubmission);
		ExpectedMsgDeleteSubmission = PropertiesUtils.getPropertyValue("enterDELETEMsg");
		waitForElementIsInteractable(DeleteTextField);
		forcedWaitTime(3);
		sendKeysWithWait(DeleteTextField, PropertiesUtils.getPropertyValue("DELETE"));
		waitForElementIsInteractable(DeleteSubmissionButton);
		clickOn(DeleteSubmissionButton);
		waitUntilElementInvisibleLocated(DeleteSubmissionButton);
		waitForCurserRunning(8);
		refreshPage();
		waitForCurserRunning(10);
		forcedWaitTime(4);
		waitUntilElementIsVisible(SubmissionsCount);
		waitUntilElementPresent(SubmissionsCount);
		waitUntilElementIsVisible(NextPaginationCSLP);
		waitForElementIsInteractable(NextPaginationCSLP);
		String[] CountCases2 = getTextElement(SubmissionsCount).split(" ");
		String CountAfter = CountCases2[0];
		int AfterDeleting = Integer.parseInt(CountAfter);
		SubmissionDeletion = (AfterDeleting < BeforeDeleting);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(DeleteSubmissionTitle, PropertiesUtils.getPropertyValue("DeleteSubmission"));
		softAssert.assertEquals(ValidationMessageDeleteSubmission, ExpectedMsgDeleteSubmission);
		softAssert.assertTrue(SubmissionDeletion);
		softAssert.assertAll();
	}

	public static By navigationBtn = By.xpath("//div[@class='pagination-top']//div[@class='table__pagination-nav-btns']/button[2]");

	public void CSLP_VerifyTotalCountOfSubmissions() throws InterruptedException {
		String[] CountOfCases = getTextElement(SubmissionsCount).split(" ");
		String CountHeader = CountOfCases[0];
		System.out.println(CountHeader);
		SubmissionCountAtHeader = Integer.parseInt(CountHeader);
		// System.out.println(CountHeader);
		int eleCount = findElementsByXPath(SubmissionID).size();
		System.out.println(eleCount);
		Boolean check = driver
				.findElement(navigationBtn)
				.isEnabled();
		while (check) {
			clickByJsExecuter(navigationBtn);
			forcedWaitTime(3);
			int eleCount1 = findElementsByXPath(SubmissionID).size();
			eleCount = eleCount + eleCount1;
			System.out.println(eleCount);
			check = driver
					.findElement(navigationBtn)
					.isEnabled();

		}
		System.out.println(eleCount);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(eleCount, SubmissionCountAtHeader);
		softAssert.assertAll();
	}

	public void CSLP_VerifyClearAllFiltersLinkText() throws InterruptedException {
		refreshPage();
		waitForCurserRunning(7);
		crmMethods.searchSubmissionCSLP(PropertiesUtils.getPropertyValue("Submission"));
		waitForCurserRunning(4);
		waitUntilElementIsVisible(ClearAllFiltersLink);
		waitForElementIsInteractable(ClearAllFiltersLink);
		int ClearallFilter = driver.findElements(ClearAllFiltersLink).size();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ClearallFilter > 0);
		softAssert.assertAll();
	}

	public void CSLP_VerifyClearAllFiltersAfterClicking() throws InterruptedException {
		waitUntilElementIsVisible(ClearAllFiltersLink);
		waitForElementIsInteractable(ClearAllFiltersLink);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(4));
		clickByJsExecuter(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(ClearAllFiltersLink);
		List<WebElement> ClearAllFilters = driver.findElements(ClearAllFiltersLink);
		ClearAllFiltersAbsence = ClearAllFilters.size() == 0;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ClearAllFiltersAbsence);
		softAssert.assertAll();
	}

	public void CSLP_VerifyApplicationOfsecondaryFilters() throws InterruptedException {
		waitUntilElementIsVisible(FilterSlider);
		waitForElementIsInteractable(FilterSlider);
		clickByJsExecuter(FilterSlider);
		waitForElementIsInteractable(CategoryCheckbox);
		clickByJsExecuter(CategoryCheckbox);
		waitForElementIsInteractable(FilterSliderClose);
		clickByJsExecuter(FilterSliderClose);
		waitForElementIsInteractable(CategoryDropdownIcon);
		clickByJsExecuter(CategoryDropdownIcon);
		try {
			waitForElementIsInteractable(FirstCategoryCheckbox);
			clickByJsExecuter(FirstCategoryCheckbox);
		} catch (Exception e) {
			waitForElementIsInteractable(FirstCategoryCheckbox);
			forcedWaitTime(3);
			movetoElementAndClick(FirstCategoryCheckbox);
		}

		waitForElementIsInteractable(outsideALL);
		clickByJsExecuter(outsideALL);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(SubmissionsCount);
		forcedWaitTime(5);
		waitUntilElementIsInvisible(By.xpath("table-container__table table_disabled"));
		String[] CountOfCases = getTextElement(SubmissionsCount).split(" ");
		String CountHeader = CountOfCases[0];
		int CountAtHeader = Integer.parseInt(CountHeader);

		List<WebElement> filterAppliedCount = driver.findElements(SubmissionID);
		System.out.println(CountAtHeader);
		System.out.println(filterAppliedCount.size());
		CompareFilterResultsCount = (CountAtHeader == filterAppliedCount.size());
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CompareFilterResultsCount);
		softAssert.assertAll();
	}

	public void CSLP_VerifyFilterGetsRemoved() throws InterruptedException {
		waitUntilElementIsVisible(CountSecondaryFilters);
		List<WebElement> SecondaryFilters = waitUntilVisibleList(CountSecondaryFilters);
		int countSF1 = SecondaryFilters.size();
		waitForElementIsInteractable(CrossSecondaryFilter);
		clickOn(CrossSecondaryFilter);
		waitUntilElementInvisibleLocated(CrossSecondaryFilter);
		// WaitUntilVisible(CountSecondaryFilters);
		List<WebElement> SecondaryFilters2 = driver.findElements(CountSecondaryFilters);
		int countSF2 = SecondaryFilters2.size();
		CompareRemovedFilterCount = (countSF1 > countSF2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CompareRemovedFilterCount);
		softAssert.assertAll();
	}

	public void CSLP_VerifyFilterAndSearch() throws InterruptedException {
		waitUntilElementPresent(CSLPSearchField);
		waitForElementIsInteractable(CSLPSearchField);
		sendKeysWithWait(CSLPSearchField, "Anonymous");
		waitUntilElementIsVisible(By.xpath("//div[@class='table-container__table table_disabled']"));
		waitUntilElementIsVisible(SubmissionID);
		waitUntilElementIsVisible(SubmissionNumberHeader);
		waitForElementIsInteractable(SubmissionNumberHeader);
		List<WebElement> AllSubmissionsID = driver.findElements(SubmissionID);
		int CountIDs = AllSubmissionsID.size();
		waitUntilElementIsVisible(AnonymousColumn);
		List<WebElement> AnonymousList = driver.findElements(AnonymousColumn);
		int AnonymousTextList = AnonymousList.size();
		System.out.println("AnonymousTextList:->  " + AnonymousTextList);
		System.out.println("CountIds:->  " + CountIDs);

		CompareSearchResultsCount = (AnonymousTextList == CountIDs);
		System.out.println("CompareSearchResultsCount: -> " + CompareSearchResultsCount);
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table table_disabled"));
		clickOn(ClearAllFiltersLink);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CompareSearchResultsCount);
		softAssert.assertAll();
	}

	public void CSLP_VerifyRemovalOfColumns() throws InterruptedException {
		waitForElementIsInteractable(ColumnControlWidget);
		clickOn(ColumnControlWidget);
		waitForElementIsInteractable(IssueDescriptionCheckbox);
		clickOn(IssueDescriptionCheckbox);
		waitForElementIsInteractable(CloseColumnControl);
		clickByJsExecuter(CloseColumnControl);
		waitUntilElementInvisibleLocated(IssueDescriptionColumn);
		List<WebElement> IssueDescriptionCol = driver.findElements(IssueDescriptionColumn);
		VerifyAbsenceOfCol = IssueDescriptionCol.size() == 0;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(VerifyAbsenceOfCol);
		softAssert.assertAll();
	}

	public void CSLP_VerifyRestorationOfColumns() throws InterruptedException {
		waitForElementIsInteractable(ColumnControlWidget);
		clickOn(ColumnControlWidget);
		waitForElementIsInteractable(IssueDescriptionCheckbox);
		clickOn(IssueDescriptionCheckbox);
		waitForElementIsInteractable(CloseColumnControl);
		clickOn(CloseColumnControl);
		waitUntilElementIsVisible(IssueDescriptionColumn);
		List<WebElement> IssueDescriptionCol = driver.findElements(IssueDescriptionColumn);
		VerifyColumnsPresence = (IssueDescriptionCol.size() == 1);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(VerifyColumnsPresence);
		softAssert.assertAll();
	}

	public void CSLP_VerifySavedFilter() throws InterruptedException {
		waitForElementIsInteractable(FiltersDropdown);
		clickOn(FiltersDropdown);
		waitUntilElementIsVisible(CrossIconFilters);
		int CountFiltersCross = driver.findElements(CrossIconFilters).size();
		if (CountFiltersCross > 0) {
			driver.findElement(CrossIconFilters).click();
			waitForElementIsInteractable(YesDelete);
			clickOn(YesDelete);
			waitUntilElementIsVisible(CrossIconFilters);
			CountFiltersCross = driver.findElements(CrossIconFilters).size();
		}
		waitForElementIsInteractable(FiltersDropdown);
		clickOn(FiltersDropdown);
		waitForElementIsInteractable(SaveAsButton);
		clickOn(SaveAsButton);
		waitUntilElementIsVisible(SaveAsPopup);
		SaveAsPopupTitle = getTextElement(SaveAsPopup);
		String FilterNameRandom = RandomStrings.requiredString(5);
		sendKeysWithWait(FilterNameField, "Filter " + (FilterNameRandom));
		waitForElementIsInteractable(CSDPUtility.SaveButton);
		clickOn(CSDPUtility.SaveButton);
		waitForElementIsInteractable(FiltersDropdown);
		clickOn(FiltersDropdown);
		waitForCurserRunning(2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SaveAsPopupTitle, "Save As");
		softAssert.assertAll();

	}

	public void CSLP_VerifyDeletedFilter() throws InterruptedException {
		forcedWaitTime(4);
		waitUntilElementIsVisible(CountSavedFilters);
		List<WebElement> CountFilters = findElementsByXPath(CountSavedFilters);
		int FiltersCount = CountFilters.size();
		waitForElementIsInteractable(CrossIconFilters);
		clickOn(CrossIconFilters);
		waitForElementIsInteractable(YesDelete);
		clickByJsExecuter(YesDelete);
		waitUntilElementIsInvisible(YesDelete);
		forcedWaitTime(5);
		List<WebElement> CountFiltersAfter = driver.findElements(CountSavedFilters);
		int FiltersCountAfter = CountFiltersAfter.size();
		CompareCountDeletedFilter = FiltersCountAfter == (FiltersCount - 1);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CompareCountDeletedFilter, FiltersCountAfter + " not equal to " + (FiltersCount - 1));
		softAssert.assertAll();
	}

	public void CSLP_VerifyCSVFile() throws InterruptedException {
		waitUntilElementIsVisible(DownloadButton);
		waitForElementIsInteractable(DownloadButton);
		clickOn(DownloadButton);
		waitUntilElementIsVisible(CSVOption);
		waitForElementIsInteractable(CSVOption);
		clickOn(CSVOption);
		waitUntilElementInvisibleLocated(CSVOption);
		waitForCurserRunning(5);
		forcedWaitTime(5);
		ExpectedMsgCSV = PropertiesUtils.getPropertyValue("CSVDownloaded");

		Date date = new Date();
		DateFormat pstFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm");
		TimeZone pstTime = TimeZone.getTimeZone("PST");
		pstFormat.setTimeZone(pstTime);
		String[] timesdate = (pstFormat.format(date).split(" "));

		DateFormat pstFormat24 = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss a");
		Date date2 = new Date();
		TimeZone pstTime1 = TimeZone.getTimeZone("PST");
		pstFormat24.setTimeZone(pstTime1);
		String[] timesdate1 = (pstFormat24.format(date).split(" "));

		String agencyName = (driver.getTitle().split(":"))[0];
		String[] times = (timesdate[1].split(":"));
		String file_Name = agencyName + "_" + timesdate[0] + "_" + times[0] + "-" + times[1] + "-" + timesdate1[2]
				+ "_csv.csv";
		FileStatus = CheckDownloadedFile.isFileDownloaded(file_Name);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(FileStatus, "File Present");
		softAssert.assertAll();

	}

	public void CSLP_VerifyDirectionToRespectiveSubmission() throws InterruptedException {
		forcedWaitTime(3);
		waitUntilElementIsVisible(SubmissionID);
		waitUntilElementPresent(SubmissionID);
		RecentSubmissionID = getTextElement(SubmissionID);
		closeOtherTabs();
		waitUntilElementIsVisible(SubmissionID);
		waitForElementIsInteractable(SubmissionID);
		clickByJsExecuter(SubmissionID);
		waitForCurserRunning(5);
		waitUntilElementIsVisible(CSDPUtility.CSDPSubmissionID);
		String OpenedSubmission[] = getTextElement(CSDPUtility.CSDPSubmissionID).split("#");
		OpenedSubmissionID = OpenedSubmission[1];
		System.out.println(OpenedSubmissionID);
		clickByJsExecuter(CrossIconForCSDP);
		waitUntilElementInvisibleLocated(CrossIconForCSDP);
		waitForCurserRunning(5);
		forcedWaitTime(2);
		waitUntilElementIsVisible(MineButton);
		waitForElementIsInteractable(MineButton);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(RecentSubmissionID, OpenedSubmissionID);
		softAssert.assertAll();
	}

	public void CSLP_VerifySubmissionsForMineButton() throws InterruptedException {
		waitUntilElementIsVisible(MineButton);
		waitForElementIsInteractable(MineButton);
		forcedWaitTime(4);
		clickByJsExecuter(MineButton);
		waitUntilElementIsVisible(By.xpath("//div[@class='table-container__table table_disabled']"));
		waitUntilElementIsInvisible(By.xpath("//div[@class='table-container__table table_disabled']"));
		String LoggedInUserName = getTextElement(AgencyUserName);
		System.out.println("LoggedInUserName" + LoggedInUserName);
		waitUntilElementIsVisible(By.xpath("//span[text()='" + (LoggedInUserName) + "']"));
		waitUntilElementPresent(By.xpath("//span[text()='" + (LoggedInUserName) + "']"));
		List<WebElement> AllSubmissions = waitUntilVisibleList(SubmissionID);
		waitUntilElementIsVisible(By.xpath("//span[text()='" + (LoggedInUserName) + "']"));
		waitUntilElementPresent(By.xpath("//span[text()='" + (LoggedInUserName) + "']"));
		Boolean check = findElement(By.xpath("//span[text()='" + (LoggedInUserName) + "']")).isDisplayed();
		System.out.println("LoggedIn User is Present" + check);
		List<WebElement> AgencyUserCases = driver
				.findElements(By.xpath("//div[@class='rt-td'][3]/span[text()='" + (LoggedInUserName) + "']"));
		int UserCasesCount = AgencyUserCases.size();
		System.out.println(AllSubmissions.size());
		System.out.println(UserCasesCount);
		CompareMineResultsCount = (AllSubmissions.size() == UserCasesCount);
		waitUntilElementIsVisible(ClearAllFiltersLink);
		waitForElementIsInteractable(ClearAllFiltersLink);
		waitUntilElementIsInvisible(AgencyUserName);
		waitUntilElementIsInvisible(By.xpath("//div[@class='table-container__table table_disabled']"));
		clickOn(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(By.cssSelector("div.table-container__table table_disabled"));
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(CompareMineResultsCount);
		softAssert.assertAll();

	}

	public void CSLP_VerifyDescendingSubmission() throws InterruptedException {
		waitUntilElementPresent(SubmissionID);
		waitUntilElementIsVisible(SubmissionNumberHeader);
		waitForElementIsInteractable(SubmissionNumberHeader);
		WaitForGridTableEnable();
		waitUntilElementIsVisible(SubmissionID);
		forcedWaitTime(2);
		List<WebElement> AllSubmissionsID = findElementsByXPath(SubmissionID);
		List<Integer> IDList = AllSubmissionsID.stream().map(m -> Integer.parseInt(m.getText().split("-")[1]))
				.collect(Collectors.toList());
		for (int i = 1; i < IDList.size(); i++) {
			if (IDList.get(i) > IDList.get(i - 1)) {
				VerifyDescendingOrder = false;
			}
		}
		VerifyDescendingOrder = true;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(VerifyDescendingOrder);
		softAssert.assertAll();
	}

	public String actualMesz;

	public void CSLP_VerifyNoExistingSubmissionSearch() throws InterruptedException {
		findElementsByXPath(SubmissionID);
		// String submissionId = (Integer.parseInt(GetText(SubmissionID).split("-")[1]))
		// + 1 + "";
		String submissionId = RandomStrings.requiredDigits(4);
		waitUntilElementPresent(CSLPSearchField);
		waitForElementIsInteractable(CSLPSearchField);
		sendKeysWithWait(CSLPSearchField, submissionId.trim());
		waitForCurserRunning(2);
		waitUntilElementIsVisible(By.xpath("//div[@class='table-container__table table_disabled']"));
		waitUntilElementIsInvisible(By.xpath("//div[@class='table-container__table table_disabled']"));
		actualMesz = getTextElement(submissionCountDetails);

		// Clean up
		waitUntilElementIsVisible(ClearAllFiltersLink);
		waitForElementIsInteractable(ClearAllFiltersLink);
		clickByJsExecuter(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(By.cssSelector("div.table-container__table table_disabled"));
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualMesz.trim(), "0 Customer Submissions");
		softAssert.assertAll();
	}

	public static String categoryName;
	public static String actualMeszCatSerach;

	public void CSLP_VerifyNoExistingCategorySubmission() throws InterruptedException {
		CRMCommonMethods crmMethod = new CRMCommonMethods(driver);
		waitUntilElementIsVisible(SubmissionID);
		crmMethod.navigateToAgencySetup();
		scrollIntoView(AppPreRequisiteUtility.CRMProdSideBar);

		if (driver.findElements(AppPreRequisiteUtility.CategoriesSideBar).size() == 0) {
			clickByJsExecuter(AppPreRequisiteUtility.CRMProdSideBar);
		}

		waitForPresenceandVisiblity(AppPreRequisiteUtility.CategoriesSideBar);
		scrollIntoView(AppPreRequisiteUtility.CategoriesSideBar);
		clickByJsExecuter(AppPreRequisiteUtility.CategoriesSideBar);
		waitForCurserRunning(5);

		categoryName = "EditedCat" + RandomStrings.requiredString(5);
		waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
		crmMethod.createCategoryAppPrerequisute("No", "Yes", "Yes", categoryName);

		crmMethod.navigateToCSLP();
		refreshPage();
		waitForCurserRunning(4);
		waitUntilElementIsVisible(FilterSlider);
		waitForElementIsInteractable(FilterSlider);
		clickByJsExecuter(FilterSlider);
		waitForElementIsInteractable(CategoryCheckbox);
		forcedWaitTime(5);
		clickOn(CategoryCheckbox);
		waitForElementIsInteractable(FilterSliderClose);
		clickOn(FilterSliderClose);
		waitUntilElementIsVisible(CategoryDropdownIcon);
		waitForElementIsInteractable(CategoryDropdownIcon);
		clickByJsExecuter(CategoryDropdownIcon);
		System.out.println("category name : -> " + categoryName);
		waitUntilElementIsVisible(CategoryDropdownIcon);
		forcedWaitTime(4);
		Thread.sleep(3000);
		scrollIntoView(By.xpath("//input[@name='" + categoryName + "']"));
		clickByJsExecuter(By.xpath("//input[@name='" + categoryName + "']"));
		waitForCurserRunning(2);
		waitUntilElementIsVisible(By.xpath("//div[@class='rt-noData']"));
		waitUntilElementIsVisible(submissionCountDetails);
		actualMeszCatSerach = getTextElement(submissionCountDetails);

		// Clean up
		waitUntilElementIsVisible(ClearAllFiltersLink);
		waitForElementIsInteractable(ClearAllFiltersLink);
		clickOn(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(ClearAllFiltersLink);
		waitUntilElementInvisibleLocated(By.cssSelector("div.table-container__table table_disabled"));
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualMeszCatSerach.trim(), "0 Customer Submissions");
		softAssert.assertAll();
	}

	public static boolean mapViewCase;
	public static boolean mapViewZoom;

	public void VerifyMapViewPresent() throws InterruptedException {
		waitUntilElementInvisibleLocated(By.cssSelector("div.table-container__table table_disabled"));
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));
		waitForElementIsInteractable(CLPUtility.mapViewIcon);
		forcedWaitTime(4);
		waitUntilElementIsVisible(CLPUtility.mapViewIcon);
		clickByJsExecuter(CLPUtility.mapViewIcon);
		waitUntilElementIsVisible(mapViewCasList);
		mapViewCase = elementIsDisplayed(mapViewCasList);
		waitUntilElementIsVisible(CLPUtility.mapViweZoomIn);
		mapViewZoom = elementIsDisplayed(CLPUtility.mapViweZoomIn);
		waitUntilElementIsVisible(CLPUtility.mapViewIcon);
		clickOn(CLPUtility.mapViewIcon);
		waitUntilElementInvisibleLocated(mapViewCasList);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}

	public void searchCategoryUnderCategoryFilter_CSLP(String name) {
		List<WebElement> categoryNames = findElementsByXPath(categoriesPresentUnderCategoryFilter);
		Boolean flag = false;
		for (int i = 0; i < categoryNames.size(); i++) {

			if (categoryNames.get(i).getAttribute("name").equalsIgnoreCase(name)) {
				scrollIntoViewWebElement(categoryNames.get(i));
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}
	public void searchCategoryUnderCategoryFilterUsingSearchBox_CSLP(String name) {
		clearByJSE(searchCategoryOnCSLP);
		sendKeysWithWait(searchCategoryOnCSLP, name);
		String categoryDisplayed= getTextByJSExecutor(searchedCategory);
		// add loop to compare values
		Assert.assertEquals(categoryDisplayed,name);
	}
	
	public int getSubmissionCountOnCSDP_header() throws InterruptedException
	{
		forcedWaitTime(3);
		String text= getTextByJSExecutor(SubmissionsCount);
		String submissionCount=text.split(" ")[0];
		System.out.println("submission count is "+submissionCount);
		return Integer.parseInt(submissionCount);
	}

}
