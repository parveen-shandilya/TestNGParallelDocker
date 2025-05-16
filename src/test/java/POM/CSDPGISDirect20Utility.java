package POM;

import BrowsersBase.BrowsersInvoked;
import TestCases.CCP;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;

import static POM.CCPDirect20Utility.searchLocationKeyHost20_prod;
import static POM.CCPUtility.*;

public class CSDPGISDirect20Utility extends Helper{

    public WebDriver driver;
    LoginUtility log;
    CRMCommonMethods crmCommonMethod;
    CECommonMethods ceCommonMethod;
    CCPDirect20Utility CCPDirect20Utils;
    public Helper helper;

    public CSDPGISDirect20Utility(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log = new LoginUtility(driver);
        crmCommonMethod = new CRMCommonMethods(driver);
        ceCommonMethod = new CECommonMethods(driver);
    }

    public void LoginAgency() throws InterruptedException {
        log.LoginAgency();

    }

  public static String editLocation_btn = "//div[@class='edit-address__actions']//button[@class='edit-btn  btn btn-primary']";
  public static String searchLocation_text = "//input[@placeholder='Enter Address, APN or Drop a pin on Map']";
  public static By SearchLocation_text = By.xpath(searchLocation_text);
  public static By EditLocation_btn = By.xpath(editLocation_btn);
   public static By addAddressManuallyPopup = By.xpath("//h2[text()='Add Address Manually']");
   public static By addAddressBttn = By.xpath("//button[text()='Add Address']");


        public static Boolean GISsectionstatus;
        public static Boolean APNsectionstatus;
        public static Boolean ComcateApplicationsectionstaus;
        public static boolean gisValidationButton;
        public static boolean validateAddressBtn;
        public static String ValidateStreetAdd;
        public static String validatestate;
        public static String validateCity;
        public static String validateZip;
        public static String validateApn;
        public static String validateOwnerName;
        public static String validateOwnerAddress;



        public  void EditLocationonSearchLocationCSDP() throws InterruptedException {

            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o))
            {
                waitUntilElementIsVisible(EditLocation_btn);
                waitForElementIsInteractable(EditLocation_btn);
                clickByJsExecuter(EditLocation_btn);
                waitForCurserRunning(3);
                waitUntilElementIsVisible(SearchLocation_text);
                waitForElementIsInteractable(SearchLocation_text);
                crmCommonMethod.searchLocationCSP(CCPDirect20Utils.searchLocationKey1O);
                Thread.sleep(2000);
                System.out.println("successfully search ....");
                //   Thread.sleep(2000);
                // clickOn(SearchLocation_text);

                String address = getTextByJSExecutor(By.xpath("//span[@class='space-left']"));
                System.out.println("address:  " + address);

                clickOn(SearchLocation_text);
                // Thread.sleep(2000);
                sendKeysWithWait(SearchLocation_text, address);

                waitUntilElementIsVisible(CCPDirect20Utils.GisDataAddress);
                GISsectionstatus = findElement(CCPDirect20Utils.GisDataAddressSection).isDisplayed();
                System.out.println("GISsectionstatus:  " + GISsectionstatus);
                APNsectionstatus = findElement(CCPDirect20Utils.APNAddressSection).isDisplayed();
                System.out.println("APNsectionstatus:  " + APNsectionstatus);
                ComcateApplicationsectionstaus = findElement(CCPDirect20Utils.ComcateApplicationSection).isDisplayed();
                forcedWaitTime(4);

                waitUntilElementIsVisible(CCPDirect20Utils.GisDataAddress);
                waitForElementIsInteractable(CCPDirect20Utils.GisDataAddress);
                clickOn(CCPDirect20Utils.GisDataAddress);
                waitForCurserRunning(3);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                forcedWaitTime(4);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                clickOn(CDPDirect20GisUtility.EditsaveAddress);
                waitForCurserRunning(2);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                ValidateStreetAdd = getTextElement(CCPDirect20Utils.StreetLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.stateLabel);
                validatestate = getTextElement(CCPDirect20Utils.stateLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.CityLabel);
                validateCity = getTextElement(CCPDirect20Utils.CityLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.ZipLabel);
                validateZip = getTextElement(CCPDirect20Utils.ZipLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.apnLabel);
                validateApn = getTextElement(CCPDirect20Utils.apnLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.OwnerName);
                validateOwnerName = getTextElement(CCPDirect20Utils.OwnerName);
                waitUntilElementIsVisible(CCPDirect20Utils.OwnerAddress);
                validateOwnerAddress = getTextElement(CCPDirect20Utils.OwnerAddress);


                SoftAssert sft = new SoftAssert();
                sft.assertEquals(CSDPGISDirect20Utility.GISsectionstatus, Boolean.TRUE);
                sft.assertEquals(CSDPGISDirect20Utility.ComcateApplicationsectionstaus, Boolean.TRUE);
                sft.assertEquals(CSDPGISDirect20Utility.APNsectionstatus, Boolean.TRUE);
                sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton, true);
                sft.assertEquals((CSDPGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validatestate.isEmpty(), false);
                sft.assertEquals((CSDPGISDirect20Utility.validateCity).isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validateZip.isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validateApn.isEmpty(), false);
                sft.assertEquals((CSDPGISDirect20Utility.validateOwnerName).isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
                sft.assertAll();
            }else{
                waitUntilElementIsVisible(EditLocation_btn);
                waitForElementIsInteractable(EditLocation_btn);
                clickByJsExecuter(EditLocation_btn);
                waitForCurserRunning(3);
                waitUntilElementIsVisible(SearchLocation_text);
                waitForElementIsInteractable(SearchLocation_text);
                crmCommonMethod.searchLocationCSP(searchLocationKeyHost20_prod);
                Thread.sleep(2000);
                System.out.println("successfully search ....");
                //   Thread.sleep(2000);
                // clickOn(SearchLocation_text);

                String address = getTextByJSExecutor(By.xpath("//span[@class='space-left']"));
                System.out.println("address:  "+address);

                clickOn(SearchLocation_text);
                // Thread.sleep(2000);
                sendKeysWithWait(SearchLocation_text,address);

                waitUntilElementIsVisible(CCPDirect20Utils.GisDataAddress);
                GISsectionstatus = findElement(CCPDirect20Utils.GisDataAddressSection).isDisplayed();
                System.out.println("GISsectionstatus:  "+GISsectionstatus);
                APNsectionstatus = findElement(CCPDirect20Utils.APNAddressSection).isDisplayed();
                System.out.println("APNsectionstatus:  "+APNsectionstatus);
                ComcateApplicationsectionstaus = findElement(CCPDirect20Utils.ComcateApplicationSection).isDisplayed();
                forcedWaitTime(4);

                waitUntilElementIsVisible(CCPDirect20Utils.GisDataAddress);
                waitForElementIsInteractable(CCPDirect20Utils.GisDataAddress);
                clickOn(CCPDirect20Utils.GisDataAddress);
                waitForCurserRunning(3);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                forcedWaitTime(4);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                clickOn(CDPDirect20GisUtility.EditsaveAddress);
                waitForCurserRunning(2);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                ValidateStreetAdd = getTextElement(CCPDirect20Utils.StreetLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.stateLabel);
                validatestate = getTextElement(CCPDirect20Utils.stateLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.CityLabel);
                validateCity = getTextElement(CCPDirect20Utils.CityLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.ZipLabel);
                validateZip = getTextElement(CCPDirect20Utils.ZipLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.apnLabel);
                validateApn = getTextElement(CCPDirect20Utils.apnLabel);
                waitUntilElementIsVisible(CCPDirect20Utils.OwnerName);
                validateOwnerName = getTextElement(CCPDirect20Utils.OwnerName);
                waitUntilElementIsVisible(CCPDirect20Utils.OwnerAddress);
                validateOwnerAddress = getTextElement(CCPDirect20Utils.OwnerAddress);



                SoftAssert sft = new SoftAssert();
                sft.assertEquals(CSDPGISDirect20Utility.GISsectionstatus, Boolean.TRUE);
                sft.assertEquals(CSDPGISDirect20Utility.ComcateApplicationsectionstaus, Boolean.TRUE);
                sft.assertEquals(CSDPGISDirect20Utility.APNsectionstatus, Boolean.TRUE);
                sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
                sft.assertEquals((CSDPGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validatestate.isEmpty(), false);
                sft.assertEquals((CSDPGISDirect20Utility.validateCity).isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validateZip.isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validateApn.isEmpty(), false);
                sft.assertEquals((CSDPGISDirect20Utility.validateOwnerName).isEmpty(), false);
                sft.assertEquals(CSDPGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
                sft.assertAll();

            }


        }



        public  void EditLocationonPinCSDP() throws InterruptedException {

            refreshPage();
            waitForCurserRunning(4);
            waitUntilElementIsVisible(EditLocation_btn);
            waitUntilElementIsVisible(EditLocation_btn);
            clickByJsExecuter(EditLocation_btn);
            waitForCurserRunning(3);
            waitUntilElementIsVisible(SearchLocation_text);
            waitUntilElementIsVisible(SearchLocation_text);
            ceCommonMethod.CCPGisDirectPinLocation();
            String address = getTextByJSExecutor(By.xpath("//span[@class='space-left']"));
            System.out.println("address:  "+address);

            clickOn(SearchLocation_text);
            // Thread.sleep(2000);
            sendKeysWithWait(SearchLocation_text,address);
            GISsectionstatus = findElement(CCPDirect20Utils.GisDataAddressSection).isDisplayed();
            APNsectionstatus = findElement(CCPDirect20Utils.APNAddressSection).isDisplayed();
            ComcateApplicationsectionstaus = findElement(CCPDirect20Utils.ComcateApplicationSection).isDisplayed();
            forcedWaitTime(4);
            waitUntilElementIsVisible(CCPDirect20Utils.GisDataAddress);
            waitUntilElementIsVisible(CCPDirect20Utils.GisDataAddress);
            clickOn(CCPDirect20Utils.GisDataAddress);
            waitForCurserRunning(3);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            forcedWaitTime(4);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
            waitUntilElementIsInvisible(CDPDirect20GisUtility.EditsaveAddress);
            waitForCurserRunning(2);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
            gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
            ValidateStreetAdd = getTextElement(CCPDirect20Utils.StreetLabel);
            waitUntilElementIsVisible(CCPDirect20Utils.stateLabel);
            validatestate = getTextElement(CCPDirect20Utils.stateLabel);
            waitUntilElementIsVisible(CCPDirect20Utils.CityLabel);
            validateCity = getTextElement(CCPDirect20Utils.CityLabel);
            waitUntilElementIsVisible(CCPDirect20Utils.ZipLabel);
            validateZip = getTextElement(CCPDirect20Utils.ZipLabel);
            waitUntilElementIsVisible(CCPDirect20Utils.apnLabel);
            validateApn = getTextElement(CCPDirect20Utils.apnLabel);
            waitUntilElementIsVisible(CCPDirect20Utils.OwnerName);
            validateOwnerName = getTextElement(CCPDirect20Utils.OwnerName);
            waitUntilElementIsVisible(CCPDirect20Utils.OwnerAddress);
            validateOwnerAddress = getTextElement(CCPDirect20Utils.OwnerAddress);


            SoftAssert sft = new SoftAssert();
            sft.assertEquals(CSDPGISDirect20Utility.GISsectionstatus, Boolean.TRUE);
            sft.assertEquals(CSDPGISDirect20Utility.ComcateApplicationsectionstaus, Boolean.TRUE);
            sft.assertEquals(CSDPGISDirect20Utility.APNsectionstatus, Boolean.TRUE);
            sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
            sft.assertEquals((CSDPGISDirect20Utility.ValidateStreetAdd).isEmpty(), false);
            sft.assertEquals(CSDPGISDirect20Utility.validatestate.isEmpty(), false);
            sft.assertEquals((CSDPGISDirect20Utility.validateCity).isEmpty(), false);
            sft.assertEquals(CSDPGISDirect20Utility.validateZip.isEmpty(), false);
            sft.assertEquals(CSDPGISDirect20Utility.validateApn.isEmpty(), false);
            sft.assertEquals((CSDPGISDirect20Utility.validateOwnerName).isEmpty(), false);
            sft.assertEquals(CSDPGISDirect20Utility.validateOwnerAddress.isEmpty(), false);
            sft.assertAll();

        }


        public  void EditLocationonPinGISValidatedButtonAppearCSDP() throws InterruptedException {

            refreshPage();
            waitForCurserRunning(4);
            waitUntilElementIsVisible(EditLocation_btn);
            waitUntilElementPresent(EditLocation_btn);
            waitUntilElementIsVisible(EditLocation_btn);
            clickByJsExecuter(EditLocation_btn);
            waitUntilElementIsVisible(SearchLocation_text);
            waitUntilElementPresent(SearchLocation_text);
            waitUntilElementIsVisible(SearchLocation_text);
            ceCommonMethod.CCPGisDirectPinLocation();

            String address = getTextByJSExecutor(By.xpath("//span[@class='space-left']"));
            System.out.println("address:  "+address);

            clickOn(SearchLocation_text);
            // Thread.sleep(2000);
            sendKeysWithWait(SearchLocation_text,address);
            waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
            waitUntilElementPresent(CCPDirect20Utils.ApnAddrresses);
            scrollIntoView(CCPDirect20Utils.ApnAddrresses);
            waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
            clickOn(CCPDirect20Utils.ApnAddrresses);
            waitForCurserRunning(8);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            forcedWaitTime(4);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
            waitUntilElementIsInvisible(CDPDirect20GisUtility.EditsaveAddress);
            waitForCurserRunning(2);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
            gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);


            SoftAssert sft = new SoftAssert();
            sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
            sft.assertAll();

        }


        public  void EditLocationonSearchAPNGISValidatedButtonAppearCSDP() throws InterruptedException {

            if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)){
                refreshPage();
                waitForCurserRunning(4);
                waitUntilElementIsVisible(EditLocation_btn);
                waitUntilElementPresent(EditLocation_btn);
                waitUntilElementIsVisible(EditLocation_btn);
                clickByJsExecuter(EditLocation_btn);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                clickOn(CCPUtility.LocationFld);
                clearElement(CCPUtility.LocationFld);
                sendKeysWithWait(CCPUtility.LocationFld, "17816113033");
                waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
                scrollIntoView(CCPDirect20Utils.ApnAddrresses);
                waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
                clickOn(CCPDirect20Utils.ApnAddrresses);
                waitForCurserRunning(8);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                forcedWaitTime(4);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
                waitUntilElementIsInvisible(CDPDirect20GisUtility.EditsaveAddress);
                waitForCurserRunning(2);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);

                SoftAssert sft = new SoftAssert();
                sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
                sft.assertAll();
            }else{
                refreshPage();
                waitForCurserRunning(4);
                waitUntilElementIsVisible(EditLocation_btn);
                waitUntilElementPresent(EditLocation_btn);
                waitUntilElementIsVisible(EditLocation_btn);
                clickByJsExecuter(EditLocation_btn);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                clickOn(CCPUtility.LocationFld);
                clearElement(CCPUtility.LocationFld);
                sendKeysWithWait(CCPUtility.LocationFld,"7030-0207-0006-000" );
                waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
                scrollIntoView(CCPDirect20Utils.ApnAddrresses);
                waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
                clickOn(CCPDirect20Utils.ApnAddrresses);
                waitForCurserRunning(8);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                forcedWaitTime(4);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
                waitUntilElementIsInvisible(CDPDirect20GisUtility.EditsaveAddress);
                waitForCurserRunning(2);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);

                SoftAssert sft = new SoftAssert();
                sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
                sft.assertAll();
            }

        }


        public  void VerifyUserAbletoValidateAddressWithGISDataAddressOnCSDP() throws InterruptedException {
            if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)){
                refreshPage();
                waitForCurserRunning(4);
                waitUntilElementIsVisible(EditLocation_btn);
                waitUntilElementIsVisible(EditLocation_btn);
                clickByJsExecuter(EditLocation_btn);
                waitForCurserRunning(3);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
                waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                clickOn(CCPUtility.LocationFld);
                clearElement(CCPUtility.LocationFld);
                crmCommonMethod.searchLocationCSP(CCPDirect20Utils.searchLocationKey1O);
                String address = getTextByJSExecutor(By.xpath("//span[@class='space-left']"));
                String address1= "215 QUEST PARK ST";
                System.out.println("address1:  "+address1);

                clickOn(SearchLocation_text);
                // Thread.sleep(2000);
                sendKeysWithWait(SearchLocation_text,address1);

                forcedWaitTime(3);
                waitUntilElementIsVisible(CCPDirect20Utils.ComcateAddresses);
                scrollIntoView(CCPDirect20Utils.ComcateAddresses);
                waitUntilElementIsVisible(CCPDirect20Utils.ComcateAddresses);
                clickByJsExecuter(CCPDirect20Utils.ComcateAddresses);
                waitForCurserRunning(2);
                forcedWaitTime(2);
                if(findElementsSize(addAddressManuallyPopup)>0){
                    waitUntilElementIsVisible(addAddressBttn);
                    forcedWaitTime(3);
                    clickOn(addAddressBttn);
                }
                waitForCurserRunning(3);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                forcedWaitTime(4);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
                waitForCurserRunning(5);
                waitUntilElementIsInvisible(CDPDirect20GisUtility.EditsaveAddress);
//                waitForCurserRunning(2);
                validateAddressBtn = findElementsSize(CDPDirect20GisUtility.ValidateAddressbtnCDP)>0;
                waitUntilElementIsVisible(CDPDirect20GisUtility.ValidateAddressbtnCDP);
                clickOn(CDPDirect20GisUtility.ValidateAddressbtnCDP);
                waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
                waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
                clickByJsExecuter(By.xpath("//div[@class='cross']"));
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                ceCommonMethod.SelectGISDataAddressOnCSDP();
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);


                SoftAssert sft = new SoftAssert();
                sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
                sft.assertEquals(CSDPGISDirect20Utility.validateAddressBtn,true);
                sft.assertAll();
            }else {
                refreshPage();
                waitForCurserRunning(4);
                waitUntilElementIsVisible(EditLocation_btn);
                waitUntilElementIsVisible(EditLocation_btn);
                clickByJsExecuter(EditLocation_btn);
                waitForCurserRunning(3);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(SearchLocation_text);
                waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
                waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                clickOn(CCPUtility.LocationFld);
                clearElement(CCPUtility.LocationFld);
                crmCommonMethod.searchLocationCSP(CSPInternalGISDirect20Utility.searchLocationHosted20);
                String address = getTextByJSExecutor(By.xpath("//span[@class='space-left']"));
                System.out.println("address:  "+address);

                clickOn(SearchLocation_text);
                // Thread.sleep(2000);
                sendKeysWithWait(SearchLocation_text,address);

                forcedWaitTime(4);
                waitUntilElementIsVisible(CCPDirect20Utils.ComcateAddresses);
                waitUntilElementIsVisible(CCPDirect20Utils.ComcateAddresses);
                clickByJsExecuter(CCPDirect20Utils.ComcateAddresses);
                waitForCurserRunning(3);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                forcedWaitTime(4);
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
                clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
                waitUntilElementIsInvisible(CDPDirect20GisUtility.EditsaveAddress);
                waitForCurserRunning(2);
                validateAddressBtn = elementIsDisplayed(CDPDirect20GisUtility.ValidateAddressbtnCDP);
                waitUntilElementIsVisible(CDPDirect20GisUtility.ValidateAddressbtnCDP);
                clickOn(CDPDirect20GisUtility.ValidateAddressbtnCDP);
                waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
                waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
                clickByJsExecuter(By.xpath("//div[@class='cross']"));
                waitUntilElementIsVisible(CCPUtility.LocationFld);
                ceCommonMethod.SelectGISDataAddressOnCSDP();
                waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
                gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);


                SoftAssert sft = new SoftAssert();
                sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
                sft.assertEquals(CSDPGISDirect20Utility.validateAddressBtn,true);
                sft.assertAll();
            }

        }


        public  void VerifyUserAbletoValidateAddressWithGISAPNAddressOnCSDP() throws InterruptedException {
          if(agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)){
              ceCommonMethod.SelectComcateApplicationAddressOnCSDP();
              validateAddressBtn = elementIsDisplayed(CDPDirect20GisUtility.ValidateAddressbtnCDP);
              waitUntilElementIsVisible(CDPDirect20GisUtility.ValidateAddressbtnCDP);
              clickOn(CDPDirect20GisUtility.ValidateAddressbtnCDP);
              waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
              waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
              clickByJsExecuter(By.xpath("//div[@class='cross']"));
              waitUntilElementIsVisible(CCPUtility.LocationFld);
              clickOn(CCPUtility.LocationFld);
              clearElement(CCPUtility.LocationFld);
              sendKeysWithWait(CCPUtility.LocationFld, "17816113033");
              waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
              scrollIntoView(CCPDirect20Utils.ApnAddrresses);
              waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
              clickOn(CCPDirect20Utils.ApnAddrresses);
              waitForCurserRunning(8);
              waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
              forcedWaitTime(4);
              waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
              clickOn(CDPDirect20GisUtility.EditsaveAddress);
              waitForCurserRunning(2);
              waitUntilElementIsVisible(EditLocation_btn);
              waitUntilElementPresent(EditLocation_btn);
              gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);


              SoftAssert sft = new SoftAssert();
              sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
              sft.assertAll();
          }else{
              ceCommonMethod.SelectComcateApplicationAddressOnCSDP();
              validateAddressBtn = elementIsDisplayed(CDPDirect20GisUtility.ValidateAddressbtnCDP);
              waitUntilElementIsVisible(CDPDirect20GisUtility.ValidateAddressbtnCDP);
              clickOn(CDPDirect20GisUtility.ValidateAddressbtnCDP);
              waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
              waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
              clickByJsExecuter(By.xpath("//div[@class='cross']"));
              waitUntilElementIsVisible(CCPUtility.LocationFld);
              clickOn(CCPUtility.LocationFld);
              clearElement(CCPUtility.LocationFld);
              sendKeysWithWait(CCPUtility.LocationFld, "7030-0207-0006-000");
              waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
              scrollIntoView(CCPDirect20Utils.ApnAddrresses);
              waitUntilElementIsVisible(CCPDirect20Utils.ApnAddrresses);
              clickOn(CCPDirect20Utils.ApnAddrresses);
              waitForCurserRunning(8);
              waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
              forcedWaitTime(4);
              waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
              clickOn(CDPDirect20GisUtility.EditsaveAddress);
              waitForCurserRunning(2);
              waitUntilElementIsVisible(EditLocation_btn);
              waitUntilElementPresent(EditLocation_btn);
              gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);


              SoftAssert sft = new SoftAssert();
              sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
              sft.assertAll();
          }

        }


        public  void ValidatedManuallyAddedAddressOnCSDP() throws InterruptedException{
            waitUntilElementIsVisible(EditLocation_btn);
            waitUntilElementPresent(EditLocation_btn);
            waitUntilElementIsVisible(EditLocation_btn);
            clickByJsExecuter(EditLocation_btn);
            waitUntilElementIsVisible(SearchLocation_text);
            waitUntilElementIsVisible(SearchLocation_text);

            waitUntilElementIsVisible(CDPDirect20GisUtility.StreetAddresstxt);
            clearElement(CDPDirect20GisUtility.StreetAddresstxt);
            waitUntilElementIsVisible(CDPDirect20GisUtility.StreetAddresstxt);
            sendKeysWithWait(CDPDirect20GisUtility.StreetAddresstxt,RandomStrings.requiredString(7));


            waitUntilElementIsVisible(CDPDirect20GisUtility.SecUnittxt);
            clearElement(CDPDirect20GisUtility.SecUnittxt);
            waitUntilElementIsVisible(CDPDirect20GisUtility.SecUnittxt);
            sendKeysWithWait(CDPDirect20GisUtility.SecUnittxt,RandomStrings.requiredString(4));


            waitUntilElementIsVisible(CDPDirect20GisUtility.CityNametxt);
            clearElement(CDPDirect20GisUtility.CityNametxt);
            waitUntilElementIsVisible(CDPDirect20GisUtility.CityNametxt);
            sendKeysWithWait(CDPDirect20GisUtility.CityNametxt,RandomStrings.requiredString(7));

            waitUntilElementIsVisible(CDPDirect20GisUtility.ZipNotxt);
            clearElement(CDPDirect20GisUtility.ZipNotxt);
            waitUntilElementIsVisible(CDPDirect20GisUtility.ZipNotxt);
            sendKeysWithWait(CDPDirect20GisUtility.ZipNotxt,RandomStrings.requiredDigits(4));

            waitUntilElementIsVisible(CDPDirect20GisUtility.ApnNotxt);
            clearElement(CDPDirect20GisUtility.ApnNotxt);
            waitUntilElementIsVisible(CDPDirect20GisUtility.ApnNotxt);
            sendKeysWithWait(CDPDirect20GisUtility.ApnNotxt,RandomStrings.requiredDigits(11));

            forcedWaitTime(4);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            clickOn(CDPDirect20GisUtility.EditsaveAddress);
            waitForCurserRunning(2);
            waitUntilElementIsVisible(EditLocation_btn);
            waitUntilElementPresent(EditLocation_btn);

            validateAddressBtn = elementIsDisplayed(CDPDirect20GisUtility.ValidateAddressbtnCDP);
            waitUntilElementIsVisible(CDPDirect20GisUtility.ValidateAddressbtnCDP);
            clickOn(CDPDirect20GisUtility.ValidateAddressbtnCDP);
            waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
            waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
            clickByJsExecuter(By.xpath("//div[@class='cross']"));
            waitUntilElementIsVisible(CCPUtility.LocationFld);
            ceCommonMethod.SelectGISDataAddressOnCDP();
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
            gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);


            SoftAssert sft = new SoftAssert();
            sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
            sft.assertEquals(CSDPGISDirect20Utility.validateAddressBtn,true);
            sft.assertAll();
        }



        public  void ValidatedAddressOnWithPinLocationCSDP() throws InterruptedException{

            waitUntilElementIsVisible(EditLocation_btn);
            waitUntilElementPresent(EditLocation_btn);
            waitUntilElementIsVisible(EditLocation_btn);
            clickByJsExecuter(EditLocation_btn);
            waitUntilElementIsVisible(SearchLocation_text);
            waitUntilElementIsVisible(SearchLocation_text);
            ceCommonMethod.CCPGisDirectPinLocation();
            forcedWaitTime(4);
            waitUntilElementIsVisible(CCPDirect20Utils.ComcateAddresses);
            waitUntilElementIsVisible(CCPDirect20Utils.ComcateAddresses);
            clickByJsExecuter(CCPDirect20Utils.ComcateAddresses);
            forcedWaitTime(4);
            waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
            clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);
            waitForCurserRunning(2);
            waitUntilElementIsVisible(EditLocation_btn);
            waitUntilElementPresent(EditLocation_btn);
            validateAddressBtn = elementIsDisplayed(CDPDirect20GisUtility.ValidateAddressbtnCDP);
            waitUntilElementIsVisible(CDPDirect20GisUtility.ValidateAddressbtnCDP);
            Thread.sleep(3000);
            clickOn(CDPDirect20GisUtility.ValidateAddressbtnCDP);
            waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
            waitUntilElementIsVisible(By.xpath("//div[@class='cross']"));
            clickByJsExecuter(By.xpath("//div[@class='cross']"));
            waitUntilElementIsVisible(CCPUtility.LocationFld);
            ceCommonMethod.SelectGISDataAddressOnCSDP();

            waitUntilElementIsVisible(CDPDirect20GisUtility.EditGISvalidateBtnCDP);
            gisValidationButton = elementIsDisplayed(CDPDirect20GisUtility.EditGISvalidateBtnCDP);


            SoftAssert sft = new SoftAssert();
            sft.assertEquals(CSDPGISDirect20Utility.gisValidationButton,true);
            sft.assertEquals(CSDPGISDirect20Utility.validateAddressBtn,true);
            sft.assertAll();
        }





    }
