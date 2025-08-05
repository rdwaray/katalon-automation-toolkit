package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import helper.LogHelper
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

public class UtilityShadow {

	//	import utils.UtilityShadow as US
	//	import utils.UtilityElement as UE
	//
	//	// Open Shadow DOM Example
	//	TestObject shadowHost = findTestObject('Page/ShadowHost')
	//	TestObject insideShadowElement = findTestObject('Page/InsideShadow')
	//	WebElement shadowElem = US.findElementInOpenShadowRoot(shadowHost, insideShadowElement)
	//	if (shadowElem != null) {
	//		shadowElem.click()
	//	}
	//
	//	// Closed Shadow DOM Example (pakai CSS selector)
	//	String shadowHostQuery = 'my-custom-element'
	//	String insideShadowQuery = 'button.submit'
	//	WebElement closedShadowElem = US.findElementInClosedShadowRootJS(shadowHostQuery, insideShadowQuery)
	//	if (closedShadowElem != null) {
	//		closedShadowElem.click()
	//	}
	//
	private static final double DEFAULT_DELAY = 0.5

	@Keyword
	static WebElement findElementInOpenShadowRoot(TestObject shadowHost, TestObject insideShadowElement) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebElement host = WebUiCommonHelper.findWebElement(shadowHost, 10)
			LogHelper.passed("[SHADOW DOM] Found Shadow Host: ${shadowHost.getObjectId()}")

			SearchContext shadowRoot = host.getShadowRoot()
			String insideXpath = insideShadowElement.findPropertyValue('xpath')
			WebElement shadowElement = shadowRoot.findElement(By.xpath(insideXpath))
			LogHelper.passed("[SHADOW DOM] Found element inside Open Shadow DOM: ${insideShadowElement.getObjectId()}")
			return shadowElement
		} catch (Exception e) {
			LogHelper.error("[SHADOW DOM] Failed to find element inside Open Shadow DOM", e)
			LogHelper.takeScreenshot()
			return null
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static WebElement findElementInClosedShadowRootJS(String shadowHostQuery, String insideShadowQuery) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebDriver driver = DriverFactory.getWebDriver()
			JavascriptExecutor js = (JavascriptExecutor) driver
			WebElement element = (WebElement) js.executeScript(
					"return document.querySelector(arguments[0]).shadowRoot.querySelector(arguments[1]);",
					shadowHostQuery, insideShadowQuery)
			if (element != null) {
				LogHelper.passed("[SHADOW DOM] Found element in Closed Shadow DOM with JS selector")
			} else {
				LogHelper.warn("[SHADOW DOM] Element in Closed Shadow DOM returned NULL")
			}
			return element
		} catch (Exception e) {
			LogHelper.error("[SHADOW DOM] Failed to find element in Closed Shadow DOM with JS", e)
			LogHelper.takeScreenshot()
			return null
		} finally {
			LogHelper.flush()
		}
	}
}

