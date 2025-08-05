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


import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import internal.GlobalVariable
import helper.LogHelper
import utils.UtilityElement


public class UtilityFrame {

	//	import utils.UtilityFrame as UF
	//	import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
	//
	//	// Switch ke frame by index
	//	UF.switchToFrameByIndex(0)
	//
	//	// Switch ke frame by name/id
	//	UF.switchToFrameByNameOrId('frameName')
	//
	//	// Switch ke frame by locator (XPath)
	//	UF.switchToFrameByLocator("//iframe[@id='frameExample']")
	//
	//	// Switch ke frame by TestObject
	//	TestObject frameObj = findTestObject('Page/YourPage/frame_Object')
	//	UF.switchToFrameByTestObject(frameObj)
	//
	//	// Switch ke parent frame
	//	UF.switchToParentFrame()
	//
	//	// Switch ke default content
	//	UF.switchToDefaultContent()
	//
	private static final double DEFAULT_DELAY = 0.5

	private static WebDriver getDriver() {
		return DriverFactory.getWebDriver()
	}

	@Keyword
	static void switchToFrameByIndex(int index) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			getDriver().switchTo().frame(index)
			LogHelper.passed("[SWITCH FRAME] By index: ${index}")
		} catch (Exception e) {
			LogHelper.error("[SWITCH FRAME] Failed by index: ${index}", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToFrameByNameOrId(String nameOrId) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			getDriver().switchTo().frame(nameOrId)
			LogHelper.passed("[SWITCH FRAME] By name/id: ${nameOrId}")
		} catch (Exception e) {
			LogHelper.error("[SWITCH FRAME] Failed by name/id: ${nameOrId}", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToFrameByLocator(String locator) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebElement frameElement = getDriver().findElement(By.xpath(locator))
			getDriver().switchTo().frame(frameElement)
			LogHelper.passed("[SWITCH FRAME] By locator: ${locator}")
		} catch (Exception e) {
			LogHelper.error("[SWITCH FRAME] Failed by locator: ${locator}", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToFrameByTestObject(TestObject to) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			UtilityElement.waitForElementVisible(to, 30)
			WebUI.switchToFrame(to, 30)
			LogHelper.passed("[SWITCH FRAME] By TestObject: ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[SWITCH FRAME] Failed by TestObject: ${to.getObjectId()}", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToDefaultContent() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			getDriver().switchTo().defaultContent()
			LogHelper.passed("[SWITCH FRAME] Switched to default content")
		} catch (Exception e) {
			LogHelper.error("[SWITCH FRAME] Failed to switch to default content", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToParentFrame() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			getDriver().switchTo().parentFrame()
			LogHelper.passed("[SWITCH FRAME] Switched to parent frame")
		} catch (Exception e) {
			LogHelper.error("[SWITCH FRAME] Failed to switch to parent frame", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}
}

