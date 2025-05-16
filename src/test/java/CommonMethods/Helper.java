package CommonMethods;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import LogUtility.Log;
import POM.CCPUtility;
import POM.CDPDirect20GisUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowsersBase.BrowsersInvoked;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import ExtentReport.ExtentReportClass;


public class Helper {
	public WebDriver driver;
	public WebDriverWait wait;
	public Wait<WebDriver> fluentWait;
	ExtentReportClass extentClass;

	public Helper(WebDriver driver) {
		this.driver = driver;
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			wait = new WebDriverWait(driver,
					Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("QAwaitTime120"))));

		} else {
			wait = new WebDriverWait(driver,
					Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("QAwaitTime120"))));
			fluentWait = new FluentWait<WebDriver>(driver);
		}

	}

	public void clickOnElement(WebElement element, String... label) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public String stringFormat(String Locator, String... values) {
		// Example XPath: "//div[@attribute1='%s' and @attribute2='%s']"
		return String.format(Locator, values);
	}

	public void navigateToURL(String Url) {
		driver.get(Url);

	}

	public void sendKeys(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public void moveToElement(By element) {
		WebElement ele = driver.findElement(element);
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String text = element.getText();
		return text;
	}

	public boolean elementIsSelected(By path) {
		try {
			WebElement ele = driver.findElement(path);
			return ele.isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitUntilElementPresent(By element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementClickable(WebElement element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.elementToBeClickable(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void tryWaitUntilElementPresent(By locator, int tries) {

		for (int i = 0; i < tries; i++) {
			try {
				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
						.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
						.ignoring(NoSuchElementException.class);
				fluentWait1.until(ExpectedConditions.presenceOfElementLocated(locator));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void implicitWaitforCustometime(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void waitUntilElementIsVisible(By element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
			// Thread.sleep(3000);
			fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitUntilWebElementIsVisible(WebElement element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.visibilityOf(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void waitForStaleElementReference(By element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(StaleElementReferenceException.class);
			fluentWait1.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tryWaitUntilElementIsVisible(By locator, int tries) {
		try {
			for (int i = 0; i < tries; i++) {
				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
						.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
						.ignoring(TimeoutException.class);
				fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementIsInteractable(By element) {

		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("QAwaitTime60"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.elementToBeClickable(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void waitForElementInteractable(WebElement edit) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
			fluentWait1.until(ExpectedConditions.elementToBeClickable(edit));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementIsInvisible(By element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(NoSuchElementException.class);
			fluentWait1.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementInvisibleLocated(By element) {

		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(TimeoutException.class);
			fluentWait1.until(ExpectedConditions.invisibilityOfElementLocated(element));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public boolean waitForElementContainsText(By ele, String text) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(TimeoutException.class);
			return fluentWait1.until(ExpectedConditions.textToBePresentInElementLocated(ele, text));
		} catch (WebDriverException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean waitForinvisibilityOfElementText(By ele, String text) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(TimeoutException.class);
			return fluentWait1.until(ExpectedConditions.invisibilityOfElementWithText(ele, text));
		} catch (WebDriverException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean waitForWebElementInvisiblilty(WebElement ele) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(TimeoutException.class);
			return fluentWait1.until(ExpectedConditions.invisibilityOf(ele));
		} catch (WebDriverException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void waitForCurserRunning(int tries) throws InterruptedException {

		for (int i = 1; i <= tries; i++) {
			try {
				int elecheck = driver.findElements(By.xpath("//img[@src='/assets/loading.gif']")).size();
				if (elecheck > 0) {
					WebElement ele = driver.findElement(By.xpath("//img[@src='/assets/loading.gif']"));
					wait.until(ExpectedConditions.invisibilityOf(ele));
				} else {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	public void waitForPageLoadTime(long time) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
	}

	public void scriptTimeout(long time) {
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(time));
	}

	public void clearByJSE(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", ele);

	}

	public String getTextByJSExecutor(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(element);
		String elementText = (String) js.executeScript("return arguments[0].innerText;", ele);
		return elementText;
	}

	public boolean elementIsDisplayed(By path) {
		try {
			WebElement ele = driver.findElement(path);
			return ele.isDisplayed();
		} catch (Exception e) {
			WebElement ele = driver.findElement(path);
			return ele.isDisplayed();
		}
	}

	public boolean elementIsChecked(By path) {
		try {
			WebElement ele = driver.findElement(path);
			return ele.isSelected();
		} catch (Exception e) {
			WebElement ele = driver.findElement(path);
			return ele.isSelected();
		}
	}

	public WebElement waitUntilVisibleWE(By element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(TimeoutException.class);
			return fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (WebDriverException e) {
			return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}
	}

	public WebElement waitUntilVisibleWE20(By element) {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
					.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
					.ignoring(TimeoutException.class);
			return fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (WebDriverException e) {
			return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}

	}

	public List<WebElement> waitUntilVisibleList(By element) {
		try {
			return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		} catch (WebDriverException e) {
			return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		}
	}

	public void clickOn(By element)  {
		waitForElementIsInteractable(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement ele = driver.findElement(element);
		ele.click();
		Log.info("Clicked on " + element);
	}

	public void sendKeysWithWait(By element, String value) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement ele = driver.findElement(element);
		ele.sendKeys(value);
		Log.info("Sendkeys on " + element + " with value " + value);
		Log.info("Project Directory -----  "+System.getProperty("user.dir"));
	}

	public void visibilityOfElementLocated(By element, int tries) {

		for (int i = 1; i <= tries; i++) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void clearElement(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		ele.clear();
		Log.info("Cleared value from " + element);
	}

	public void clickOnWE(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		Log.info("Clicked on " + element);
	}

	public void clickOnWE20(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		Log.info("Clicked on " + element);
	}

	public String getTextElement(By element) {

		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		// wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement ele = driver.findElement(element);
		String text = ele.getText();
		Log.info("GetText from" + element);
		return text;
	}

	public void tryWaitForElementInteractable(By locator, int tries) {
		try {
			for (int i = 0; i < tries; i++) {
				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime20"))))
						.pollingEvery(Duration.ofMillis(Long.parseLong(PropertiesUtils.getPropertyValue("waitTime5"))))
						.ignoring(TimeoutException.class);
				fluentWait1.until(ExpectedConditions.elementToBeClickable(locator));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeOtherTabs() throws InterruptedException {
		String originalHandle = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();

		for (String handle : tabs) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
		Log.info("Switched to Window " + originalHandle.toString());

	}

	public void scrollIntoView(By element) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement ele = driver.findElement(element);
			jse.executeScript("arguments[0].scrollIntoView(true);", ele);
			Log.info("Scroll Into View " + element);
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Scroll Into View failed. "+element);
		}
	}

	public void scrollHorizontally(int pixels) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + pixels + ", 0);");
		Log.info("Scrolled horizontally by " + pixels + " pixels.");
	}

	public void scrollIntoViewWebElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement ele = element;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Log.info("Scroll Into View By JS " + element);
	}

	public void scrolltoPageTop() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {
			jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			Log.info("Scroll to the Top.");
		} catch (Exception e) {
			Log.info("Scroll to the top Failed.");
		}
	}

	public void movetoElementAndClick(By selector) {
		try {
			Actions act = new Actions(driver);
			WebElement element = driver.findElement(selector);
			act.moveToElement(element).build().perform();
			act.click().build().perform();
			Log.info("Move to element and Click on " + element);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public void movetoElementAndClick(WebElement selector) {
		try {
			Actions act = new Actions(driver);
			WebElement element = selector;
			act.moveToElement(element).build().perform();
			act.click().build().perform();
			Log.info("Move to element and Click on " + element);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public String getValueAttribute(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		String text = ele.getAttribute("value");
		Log.info("Get Attribute value from " + element);
		return text;
	}

	public String getValueAttributeWebElement(WebElement element) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = element;
		String text = ele.getAttribute("value");
		return text;
	}

	public void clickByJsExecuter(By element) {
		waitForElementIsInteractable(element);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(element);
		jse.executeScript("arguments[0].click();", ele);
		Log.info("Click By JS " + element);
	}

	public void clickByJsExecuterWebElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement ele = element;
		jse.executeScript("arguments[0].click();", ele);
	}

	public void scrollToRight() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(6000,0)");
	}

	public void scrolltoUp() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-400)");
	}

	public void scrolltoUpCustom(int x, int y) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + x + ",-" + y + ")");
	}

	public WebElement findElementByXPath(String selector) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
		WebElement ele = driver.findElement(By.xpath(selector));
		return ele;
	}

	public List<WebElement> findElementsByXPath(By element) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		List<WebElement> ele = driver.findElements(element);
		return ele;
	}

	public int findElementsSize(By element) {
		int count = driver.findElements(element).size();
		return count;
	}

	public WebElement findElementByCssSelector(String selector) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		WebElement ele = driver.findElement(By.cssSelector(selector));
		return ele;
	}

	public List<WebElement> findElementsByCssSelector(String selector) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		List<WebElement> ele = driver.findElements(By.cssSelector(selector));
		return ele;
	}

	public WebElement findElementById(String selector) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		WebElement ele = driver.findElement(By.id(selector));
		return ele;
	}

	public WebElement findElementByPartialLinkTxt(String selector) {
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(selector)));
		WebElement ele = driver.findElement(By.partialLinkText(selector));
		return ele;
	}

	public WebElement findElementByName(String selector) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(selector)));
		WebElement ele = driver.findElement(By.name(selector));
		return ele;
	}

	public void scrollTillPageEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

	}

	public WebElement getWebElementCSSByJS(String CSSselector) {
		JavascriptExecutor jser = (JavascriptExecutor) driver;
		String query = "return document.querySelector('" + CSSselector;

		WebElement CCPBtnJSE = (WebElement) jser.executeScript(query);
		return CCPBtnJSE;
	}

	public WebElement findElement(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		return ele;
	}

	public void forcedWaitTime(long time) throws InterruptedException {
		long interval = 1000;
		long sec = time * interval;
		Thread.sleep(sec);
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void navigatePage(String url) {
		driver.get(url);
	}

	public void navigatePage2(String url) {
		driver.get(url);
		System.out.println(url);
	}

	public void waitForPresenceandVisiblity(By ele) {
		waitUntilElementIsVisible(ele);
		waitUntilElementPresent(ele);
	}

	public void moveToWebElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
	}

	public void moveToWebElementAndClick(WebElement element) {
		Actions a = new Actions(driver);
		waitUntilWebElementIsVisible(element);
		waitUntilElementClickable(element);

		a.moveToElement(element).click();
	}

	public void moveToWebElementAndClick(By element) {
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(element);
		a.moveToElement(ele).click();
	}

	public void moveToWebElementAndClickByCordinates(By element, int xCord, int yCord) {
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(element);
		a.moveToElement(ele, xCord, yCord).click().perform();
	}

	public void WaitForGridTableEnable() {
		waitUntilElementInvisibleLocated(By.cssSelector("div.table-container__table table_disabled"));
		waitUntilElementIsVisible(By.cssSelector("div.table-container__table"));
	}

	public String selectorFormate(String Selector, String... values) {
		return String.format(Selector, values);

	}

	public void handleReviewContact() throws InterruptedException {
		int warnningPopUp = findElementsSize(
				By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));

		if (warnningPopUp > 0) {
			waitForElementIsInteractable(
					By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
			try {
			clickOn(By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
			}
			catch(Exception e )
			{
				clickByJsExecuter(By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
			}

			waitUntilElementIsVisible(By.xpath("//button[text()='Keep contact']"));

			List<WebElement> keepContactBtn = driver.findElements(By.xpath("//button[text()='Keep contact']"));
			int size = keepContactBtn.size();

			for (int i = 0; i < size; i++) {
				scrollIntoViewWebElement(keepContactBtn.get(i));
				clickByJsExecuterWebElement(keepContactBtn.get(i));

			}

			clickOnCreateCaseButton();
			forcedWaitTime(3);
			handleReviewContact();

		}

	}
	
	
	public void handleReviewContactWhileUpdatingAddress() throws InterruptedException {
		int warnningPopUp = findElementsSize(
				By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));

		if (warnningPopUp > 0) {
			waitForElementIsInteractable(
					By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
			try {
			clickOn(By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
			}
			catch(Exception e )
			{
				clickByJsExecuter(By.xpath("//div[@class='modal-warning-text']//following-sibling::div//button"));
			}

			waitUntilElementIsVisible(By.xpath("//button[text()='Keep contact']"));

			List<WebElement> keepContactBtn = driver.findElements(By.xpath("//button[text()='Keep contact']"));
			int size = keepContactBtn.size();

			for (int i = 0; i < size; i++) {
				scrollIntoViewWebElement(keepContactBtn.get(i));
				clickByJsExecuterWebElement(keepContactBtn.get(i));

			}
			clickByJsExecuter(CDPDirect20GisUtility.EditsaveAddress);

			handleReviewContact();

		}

	}

	
	

	public void clickOnCreateCaseButton() throws InterruptedException {
		waitUntilElementIsVisible(CCPUtility.CreateCaseButton);
		scrollIntoView(CCPUtility.CreateCaseButton);
		waitForElementIsInteractable(CCPUtility.CreateCaseButton);
		WebElement ele = findElement(CCPUtility.CreateCaseButton);
		clickByJsExecuter(CCPUtility.CreateCaseButton);
		Thread.sleep(3000);
		// WaitUntilElementInvisible(CCPUtility.CreateCaseButton);
	}

	public String getSpecificAttribute(By element, String attribute) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		String text = ele.getAttribute(attribute);
		Log.info("Get Attribute value from " + element);
		return text;
	}

	public String getSpecificAttribute(WebElement element, String attribute) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = element;
		String text = ele.getAttribute(attribute);
		return text;

	}

	public void WaitForUntillCaseCountOne(By element) {
		String caseCount = driver.findElement(element).getText().split(" ")[0];
		Log.info("Case Count : " + caseCount);
		// (//span[@class='cases-count'])[1]
		while (caseCount != "1") {
			waitUntilElementPresent(element);
			caseCount = driver.findElement(element).getText().split(" ")[0];
		}
	}
	
	public void sendKeysUsingJs(By ele, String text)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "var element = arguments[0];"
		              + "var event = new Event('input', { bubbles: true });"
		              + "element.value = arguments[1];"
		              + "element.dispatchEvent(event);";
		jsExecutor.executeScript(script, driver.findElement(ele), text);
		Log.info("Send keys by JS "+ ele+" "+text);
	}
	

		public void sendKeysUsingActions(By ele, String text) throws InterruptedException {
		    Actions actions = new Actions(driver);
		    waitForElementIsInteractable(ele);
		    waitForPresenceandVisiblity(ele);
		    actions.moveToElement(driver.findElement(ele)).click().perform();
		    
		    for (char c : text.toCharArray()) {
		        actions.sendKeys(String.valueOf(c)).perform();
				Thread.sleep(200);
		    }
		    forcedWaitTime(2);
		    Log.info("Send keys using Actions class to element: " + text);
		
	}
		
		public List<String> getElementTextList(By locator) {
	        // Find all elements matching the selector
			waitForPresenceandVisiblity(locator);
	        List<WebElement> elements = driver.findElements(locator);
	        
	        // Extract the text of each element and return as a list
	        return elements.stream()
	                       .map(WebElement::getText)
	                       .collect(Collectors.toList());
	    }
}


