package POM;

import BrowsersBase.BrowsersInvoked;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;

public class MissingFlowUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public MissingFlowUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
	}

	
	public static String contactList = "(//div[@class='contact__suggestion contact__suggestion--individual'])[1]";
	public static String toasterMSGAttachment = "//div[text()='One/more files with unsupported format is/are discarded.']";
	public static String toasterMSGSize = "//div[text()='File size cannot exceed 15MB']";
	public static String uploadedImgTitle = "//div[@class='attachments-modal__saved-title']/span/b";
	public static String uploadedImgName = "//input[@name='title']";
	public static String uploadedImgLoc = "//input[@name='location']";
	public static String imgTitleonCCP = "//a[@class='attachments-tile__photo-title']";
	public static String imgDesconCCP = "//span[@class='clipped-text']";
	public static String imgLoconCCP = "//label[@class='attachments-tile__photo-location']";
	
	 public static By ContactList = By.xpath(contactList);
}
