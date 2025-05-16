package POM;

import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import POM.CCPDirect20Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static POM.CCPUtility.softAssert;
import static java.util.Collections.replaceAll;


public class CSLPGisDirect20Utility extends Helper {

    public WebDriver driver;
    public Helper helper;
    LoginUtility log;
    CRMCommonMethods crmCommonMethod;
    CECommonMethods ceCommonMethod;

    public CSLPGisDirect20Utility(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
        crmCommonMethod= new CRMCommonMethods(driver);
        ceCommonMethod = new CECommonMethods(driver);

    }
    public void LoginAgency() throws InterruptedException {
        log.LoginAgency();

    }


        public static String invalidAddressIcon = "//div[@class='solid-img gis-invalid']";
        public static String validAddressIcon = "//div[@class='solid-img gis-valid']";

        public static By InvalidAddressIcon = By.xpath(invalidAddressIcon);
        public static By ValidAddressIcon = By.xpath(validAddressIcon);

        public static boolean InvalidIconStatus;
        public static boolean ValidIconStatus;
        public static String submissionId;

    public static String extractSubmissionNumber(String text) {
        String pattern = "\\b\\d{2}-\\d{3}\\b"; // Regex pattern to match the format 24-949
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return null;
        }
    }


        public  void CSLP_VerifyAppropriateIconAppearwithInvalidGisAddress() throws InterruptedException{
            crmCommonMethod.CRM_CreateSubmissionCustomeAddress("No","Yes","Yes","Yes","Yes","Location Required",CCPDirect20Utility.comcateAddresses,false,false);
            forcedWaitTime(4);
            submissionId = getTextElement(By.xpath("//h2[@class='customer-submission-details__number']"));

            System.out.println("submissionId : "+submissionId);
            forcedWaitTime(3);
            //extractSubmissionNumber(submissionId)
//            String submissionID2 =submissionId.split("#")[1].trim();
            String submissionID2 = ceCommonMethod.extractCaseIdOnCDP(submissionId);
            crmCommonMethod.closeSubmissionDetailPage();
            crmCommonMethod.navigateToCSLP();
            System.out.println("submissionId " +submissionID2);
            crmCommonMethod.SearchCaseOnCSLP(submissionID2);

            waitUntilElementIsVisible(InvalidAddressIcon);

            InvalidIconStatus=elementIsDisplayed(InvalidAddressIcon);

            softAssert.assertEquals(CSLPGisDirect20Utility.InvalidIconStatus,true);
            softAssert.assertAll();
        }


        public  void CSLP_VerifyAppropriateIconAppearwithValidGisAddress() throws InterruptedException{
            crmCommonMethod.CRM_CreateSubmissionCustomeAddress("No","Yes","Yes","Yes","Yes","Location Required",CCPDirect20Utility.gisDataAddress,false,false);
            Thread.sleep(5000);
            submissionId = getTextElement(By.xpath("//h2[@class='customer-submission-details__number']"));
            System.out.println("submissionID: "+submissionId);
//            String submissionID2 = submissionId.split("#")[1].trim();
            String submissionID2 = ceCommonMethod.extractCaseIdOnCDP(submissionId);
            System.out.println("submissionID2 : " + submissionID2);
            crmCommonMethod.closeSubmissionDetailPage();
            crmCommonMethod.navigateToCSLP();
            System.out.println("submissionId in 2ndTestcase " +submissionID2);
            crmCommonMethod.SearchCaseOnCSLP(submissionID2);
            waitUntilElementIsVisible(ValidAddressIcon);

            ValidIconStatus=elementIsDisplayed(ValidAddressIcon);


            softAssert.assertEquals(CSLPGisDirect20Utility.ValidIconStatus,true);
            softAssert.assertAll();

        }
    }

