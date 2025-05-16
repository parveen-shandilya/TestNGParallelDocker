package POM;

import BrowsersBase.BrowsersInvoked;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import TestCases.CaseAssignment;
import BrowsersBase.BrowsersInvoked;

public class LoginUtility extends Helper {

	public WebDriver driver;

	static String Username = "okta-signin-username";
	static String Password = "okta-signin-password";
	static String Button = "okta-signin-submit";
	static String agencyLoggedInUsername = "//div[@class='app-header__user-name']/label";
	static String adminUsername = "//input[@placeholder='Enter Email']";
	static String adminPassword = "//input[@placeholder='Enter Password']";
	static String adminButton = "//button[text()='Login']";
	static String searchAgency = "//span[@class='agencies-listing__search']/input";
	static String enterAgencyIcon = "//div[@class='agencies-listing__agency-actions']/button[1]";
	static String plusIconToCECRM = "//*[@class='app-header__new']";

	public static By logout = By.xpath("//label[text()='Logout']");
	public static By username = By.xpath("//*[@class='app-header__user-name']/div");
	By UsernameField = By.id(LoginUtility.Username);
	By NextButton = By.id("idp-discovery-submit");
	public static By OKTAUsernameField = By.id("idp-discovery-username");
	By OKTAPasswordField = By.id("okta-signin-password");
	By OKTASubmitButton = By.id("okta-signin-submit");
	By PasswordField = By.id(LoginUtility.Password);
	By SubmitButton = By.id(LoginUtility.Button);
	By AdminUsername = By.xpath(LoginUtility.adminUsername);
	By AdminPassword = By.xpath(LoginUtility.adminPassword);
	By AdminButton = By.xpath(LoginUtility.adminButton);
	By SearchAgency = By.xpath(LoginUtility.searchAgency);
	By EnterAgencyIcon = By.xpath(LoginUtility.enterAgencyIcon);
	By AgencyLoggedInUsername = By.xpath(LoginUtility.agencyLoggedInUsername);
	By PlusIconToCECRM = By.xpath(LoginUtility.plusIconToCECRM);

	static String AgencyLoggedInUserName;
	public BrowsersInvoked browsersInvoked;

	public LoginUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		browsersInvoked = new BrowsersInvoked();

	}

	public void LoginAgency() throws InterruptedException {
		try {
			driver.navigate().to(BrowsersInvoked.AgencyURL);

			waitForPageLoadTime(20);
			if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("STAGE")
					|| BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {

				waitUntilElementIsVisible(OKTAUsernameField);
				waitForElementIsInteractable(OKTAUsernameField);
				sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.AgencyUsername);
				clickOn(NextButton);
				sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(OKTASubmitButton);
				clickOn(OKTASubmitButton);
			} else {
				waitForPageLoadTime(15);

				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, BrowsersInvoked.AgencyUsername);
				sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);

			}
			waitForCurserRunning(12);
			int checkele = driver
					.findElements(By.xpath("//h1[contains(text(),'Wait while we redirect you to your agency')]"))
					.size();
			if (checkele > 0) {
				WebElement ele = driver
						.findElement(By.xpath("//h1[contains(text(),'Wait while we redirect you to your agency')]"));
				waitForWebElementInvisiblilty(ele);
				waitForWebElementInvisiblilty(ele);
			}
			waitUntilElementIsVisible(PlusIconToCECRM);
			waitForElementIsInteractable(PlusIconToCECRM);
			WebElement CPPBtn = driver.findElement(PlusIconToCECRM);
			if (CPPBtn.isDisplayed() == false) {
				SoftAssert Assert = new SoftAssert();
				Assert.assertEquals(false, true);
			}

			AgencyLoggedInUserName = getTextElement(AgencyLoggedInUsername);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void LoginAdmin() {
		try {
			driver.navigate().to(BrowsersInvoked.AdminURL);

			sendKeysWithWait(AdminUsername, BrowsersInvoked.AdminUsername);

			sendKeysWithWait(AdminPassword, BrowsersInvoked.AdminPassword);
			clickOn(AdminButton);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LoginBasicSupervisor() {

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.basicSupervisorUserNameStage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.basicSupervisorUserNameStageGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.basicSupervisorHosted20_stage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.BasicSuperviserCI_hosted10);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.basicSupervisorCI_Direct20);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.basicSupervisorHosted20_CI);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.basicSupervisorUserNameQA);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.basicSupervisorUserNameQAGis20);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.basicSupervisorHosted20_QA);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.basicSupervisorUserNameProd);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.basicSupervisorUserNameProdGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.basicSupervisorHosted20_prod);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}




	}

	public void LoginNonSupervisor() {

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameStage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameStageGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonsupervisorHosted20_stage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonsupervisorCI_hosted10);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.noSupervisorCI_Direct20);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonsupervisorHosted20_CI);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}


		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonSupervisorUserNameQA);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonSupervisorUserNameQAGis20);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonSupervisorUserNameHost20_QA);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameProd);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameProdGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonsupervisorHosted20_prod);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}




	}

	public void LoginSupervisorManager() {
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameStage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameStageGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorMangerHosted20_stage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.SupervisorManagerCI_hosted10);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerCI_Direct20);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorMangerHosted20_CI);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerUserNameQA);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerUserNameQAGis20);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerUserNameHost20_QA);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameProd);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameProdGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorMangerHosted20_prod);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}


	}

	public void LoginSupervisorManagerAfterLogOff() throws InterruptedException {

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameStage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameStageGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorMangerHosted20_stage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerUserNameQA);
				sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);
				waitUntilElementIsVisible(PlusIconToCECRM);
				waitForElementIsInteractable(PlusIconToCECRM);
				
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerUserNameQAGis20);
				sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);
				waitUntilElementIsVisible(PlusIconToCECRM);
				waitForElementIsInteractable(PlusIconToCECRM);
			}
			
			//enter for hosted 2
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				
				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerUserNameHost20_QA);
				sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);
				waitUntilElementIsVisible(PlusIconToCECRM);
				waitForElementIsInteractable(PlusIconToCECRM);

	} 
			
			
			

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				try {
					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameProd);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					Thread.sleep(2000);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameProdGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorMangerHosted20_prod);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			

		}

		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, BrowsersInvoked.SupervisorManagerCI_hosted10);
				sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);
				waitUntilElementIsVisible(PlusIconToCECRM);
				waitForElementIsInteractable(PlusIconToCECRM);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, BrowsersInvoked.supervisorManagerCI_Direct20);
				sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);
				waitUntilElementIsVisible(PlusIconToCECRM);
				waitForElementIsInteractable(PlusIconToCECRM);
			}
		}

	}

	public void LoginNoSupervisorUserAfterLogOff() throws InterruptedException {
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("STAGE")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				try {
				//	driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameStage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameStageGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonsupervisorHosted20_stage);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, BrowsersInvoked.nonSupervisorUserNameQA);
				sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);
				waitUntilElementIsVisible(PlusIconToCECRM);
				waitForElementIsInteractable(PlusIconToCECRM);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				{
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonSupervisorUserNameQAGis20);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);
				}

			}
			
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

			
					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonSupervisorUserNameHost20_QA);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

		} 
		}	
			else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

				try {
					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameProd);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonSupervisorUserNameProdGis20);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {

				try {
					driver.navigate().to(BrowsersInvoked.AgencyURL);

					waitUntilElementIsVisible(OKTAUsernameField);
					waitForElementIsInteractable(OKTAUsernameField);
					sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.nonsupervisorHosted20_prod);
					clickOn(NextButton);
					sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(OKTASubmitButton);
					clickOn(OKTASubmitButton);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		}

		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {

					waitUntilElementIsVisible(UsernameField);
					waitForElementIsInteractable(UsernameField);
					sendKeysWithWait(UsernameField, BrowsersInvoked.nonsupervisorCI_hosted10);
					sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
					waitUntilElementIsVisible(SubmitButton);
					clickOn(SubmitButton);
					Thread.sleep(5000);
					waitUntilElementIsVisible(PlusIconToCECRM);
					waitForElementIsInteractable(PlusIconToCECRM);
				} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
					{
						waitUntilElementIsVisible(UsernameField);
						waitForElementIsInteractable(UsernameField);
						sendKeysWithWait(UsernameField, BrowsersInvoked.noSupervisorCI_Direct20);
						sendKeysWithWait(PasswordField, BrowsersInvoked.AgencyPassword);
						waitUntilElementIsVisible(SubmitButton);
						clickOn(SubmitButton);
						Thread.sleep(5000);
						waitUntilElementIsVisible(PlusIconToCECRM);
						waitForElementIsInteractable(PlusIconToCECRM);
					}

				}

			}

	}

	public void LoginOut() {
		try {
			driver.navigate().to(BrowsersInvoked.AgencyURL);

			waitUntilElementIsVisible(OKTAUsernameField);
			waitForElementIsInteractable(OKTAUsernameField);
			sendKeysWithWait(OKTAUsernameField, BrowsersInvoked.supervisorManagerUserNameStage);
			clickOn(NextButton);
			sendKeysWithWait(OKTAPasswordField, BrowsersInvoked.AgencyPassword);
			waitUntilElementIsVisible(OKTASubmitButton);
			clickOn(OKTASubmitButton);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LogOut() throws InterruptedException {

		waitUntilElementIsVisible(By.xpath("//*[@class='app-header__user-name']/div"));
		waitUntilElementPresent(By.xpath("//*[@class='app-header__user-name']/div"));
		clickByJsExecuter(By.xpath("//*[@class='app-header__user-name']/div"));
		waitUntilElementIsVisible(By.xpath("//label[text()='Logout']"));
		clickByJsExecuter(By.xpath("//label[text()='Logout']"));
		waitForCurserRunning(5);
		while (driver.findElements(By.xpath("//img[contains(@aria-label,'logo')]")).size() < 1) {
			waitForElementIsInteractable(By.xpath("//img[contains(@aria-label,'logo')]"));
			Boolean flag= elementIsDisplayed(By.xpath("//img[contains(@aria-label,'logo')]"));
			System.out.println("hello "+flag+" "+driver.findElements(By.xpath("//img[contains(@aria-label,'logo')]")).size());
			if(flag)
				break;
			LogOut();
		}
	}

	public void LoginAgencyUser(String Username, String Password) throws InterruptedException {
		try {
			driver.navigate().to(BrowsersInvoked.AgencyURL);

			//waitUntilElementIsVisible(UsernameField);

			//waitForPageLoadTime(20);
			if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("STAGE")
					|| BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {

				waitUntilElementIsVisible(OKTAUsernameField);
				waitForElementIsInteractable(OKTAUsernameField);
				sendKeysWithWait(OKTAUsernameField, Username);
				clickOn(NextButton);
				sendKeysWithWait(OKTAPasswordField, Password);
				waitUntilElementIsVisible(OKTASubmitButton);
				clickOn(OKTASubmitButton);
			
			} else {
				// WaitForPageLoadTime(15);

				waitUntilElementIsVisible(UsernameField);
				waitForElementIsInteractable(UsernameField);
				sendKeysWithWait(UsernameField, Username);
				sendKeysWithWait(PasswordField, Password);
				waitUntilElementIsVisible(SubmitButton);
				clickOn(SubmitButton);
				Thread.sleep(5000);
			
			}
			waitForCurserRunning(12);
			int checkele = driver
					.findElements(By.xpath("//h1[contains(text(),'Wait while we redirect you to your agency')]"))
					.size();
			if (checkele > 0) {
				WebElement ele = driver
						.findElement(By.xpath("//h1[contains(text(),'Wait while we redirect you to your agency')]"));

				waitForWebElementInvisiblilty(ele);
				waitForWebElementInvisiblilty(ele);
			}
			waitUntilElementIsVisible(PlusIconToCECRM);
			waitForElementIsInteractable(PlusIconToCECRM);
			WebElement CPPBtn = driver.findElement(PlusIconToCECRM);
			if (CPPBtn.isDisplayed() == false) {
				SoftAssert Assert = new SoftAssert();
				Assert.assertEquals(false, true);
			}

			AgencyLoggedInUserName = getTextElement(AgencyLoggedInUsername);
			Thread.sleep(5000);
		} catch (

		InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void loginSupervisorManager_QAProdStage() throws InterruptedException {
		// adding different agencyConfig in different RunEnvironment

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorManagerStage"), BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorManagerStageGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorMangerHosted20_stage"),
						BrowsersInvoked.AgencyPassword);
			}

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorManagerQA"),
						BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorManagerUserNameQAGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorMangerHosted20_QA"),
						BrowsersInvoked.AgencyPassword);
			}
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("PRODUCTION")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorManagerProd"),
						BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorManagerUserNameProdGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorMangerHosted20_prod"),
						BrowsersInvoked.AgencyPassword);
			}

		}
		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("SupervisorManagerCI_hosted10"),
						BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorManagerCI_Direct20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("supervisorMangerHosted20_CI"),
						BrowsersInvoked.AgencyPassword);
			}
	  }
	}

	public void loginBasicSupervisor_QAProdStage() throws InterruptedException {
		// adding different agencyConfig in different RunEnvironment

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorStage"), BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorStageGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorHosted20_stage"),
						BrowsersInvoked.AgencyPassword);
			}
			// LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisor"),
			// BrowsersInvoked.AgencyPassword);
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("BasicSupervisorQA"), BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorUserNameQAGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorHosted20_QA"),
						BrowsersInvoked.AgencyPassword);
			}

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("PRODUCTION")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("BasicSupervisorProd"),
						BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorUserNameProdGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorHosted20_prod"),
						BrowsersInvoked.AgencyPassword);
			}
		}
		else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("BasicSuperviserCI_hosted10"),
						BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorCI_Direct20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("basicSupervisorHosted20_CI"),
						BrowsersInvoked.AgencyPassword);
			}
		}
	}

	public void loginNoSupervisor_QAProdStage() throws InterruptedException {
		// adding different agencyConfig in different RunEnvironment
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonSupervisorStage"), BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonSupervisorStageGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonsupervisorHosted20_stage"),
						BrowsersInvoked.AgencyPassword);
			}
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonSupervisorQA"), BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonSupervisorUserNameQAGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonsupervisorHosted20_QA"),
						BrowsersInvoked.AgencyPassword);
			}

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("PRODUCTION")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonSupervisorProd"), BrowsersInvoked.AgencyPassword);
			} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonSupervisorUserNameProdGis20"),
						BrowsersInvoked.AgencyPassword);
			}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
				LoginAgencyUser(PropertiesUtils.getPropertyValue("nonsupervisorHosted20_prod"),
						BrowsersInvoked.AgencyPassword);
			}
		}
			// LoginAgencyUser(PropertiesUtils.getPropertyValue("nonSupervisorProd"),
			// BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
				if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise")) {
					LoginAgencyUser(PropertiesUtils.getPropertyValue("nonsupervisorCI_hosted10"), BrowsersInvoked.AgencyPassword);
				} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
					LoginAgencyUser(PropertiesUtils.getPropertyValue("noSupervisorCI_Direct20"),
							BrowsersInvoked.AgencyPassword);
				}else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20")) {
					LoginAgencyUser(PropertiesUtils.getPropertyValue("nonsupervisorHosted20_CI"),
							BrowsersInvoked.AgencyPassword);
				}
			}


	}

	public void loginUserOutsideOfGroup_QAStageProd() throws InterruptedException {
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("OutsideGroupUser"), BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("OutsideGroupUserStageGis20"),
						BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("outsideGroupUserHosted20_stage"),
						BrowsersInvoked.AgencyPassword);

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("OutsideGroupUserQA"), BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("OutsideGroupUserQAGis20"),
						BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("outsideGroupUserHosted20_QA"),
						BrowsersInvoked.AgencyPassword);

		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("production")) {

			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("OutsideGroupUserProd"),
						BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("OutsideGroupUserProdGis20"),
						BrowsersInvoked.AgencyPassword);

			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("outsideGroupUserHosted20_prod"),
						BrowsersInvoked.AgencyPassword);
		}else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("CI")) {
			if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("Enterprise"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue(""), BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("OutsideGroupUserCIDirect20"),
						BrowsersInvoked.AgencyPassword);
			else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase("EnterpriseHosted20"))
				LoginAgencyUser(PropertiesUtils.getPropertyValue("outsideGroupUserHosted20_CI"),
						BrowsersInvoked.AgencyPassword);

		}

		}
	}


