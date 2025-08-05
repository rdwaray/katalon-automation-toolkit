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

import internal.GlobalVariable
import helper.LogHelper
import utils.UtilityElement

public class UtilityNavigation {

	//	import utils.UtilityNavigation as UN

	//	UN.refreshPage()
	//	UN.backPage()
	//	UN.forwardPage()
	//
	//	UN.switchToWindowByIndex(1)
	//	UN.switchToWindowByTitle('Google')
	//	UN.switchToDefaultTab()
	//
	//	UN.printAllWindowTitles()
	//
	//	UN.closeCurrentTab()
	//	UN.closeTabByIndex(2)
	//	UN.closeAllTabsExceptDefault()

	private static final double DEFAULT_DELAY = 0.5

	@Keyword
	static void refreshPage() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebUI.refresh()
			LogHelper.passed("[NAVIGATION] Page refreshed")
		} catch (Exception e) {
			LogHelper.error("[NAVIGATION] Failed to refresh page", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void backPage() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebUI.back()
			LogHelper.passed("[NAVIGATION] Navigate back")
		} catch (Exception e) {
			LogHelper.error("[NAVIGATION] Failed to navigate back", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void forwardPage() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebUI.forward()
			LogHelper.passed("[NAVIGATION] Navigate forward")
		} catch (Exception e) {
			LogHelper.error("[NAVIGATION] Failed to navigate forward", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToWindowByIndex(int index) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			List<String> windows = WebUI.getWindowHandles()
			if (index < 0 || index >= windows.size()) {
				throw new Exception("Window index out of range: ${index}")
			}
			WebUI.switchToWindowIndex(index)
			LogHelper.passed("[WINDOW] Switched to window index: ${index}")
		} catch (Exception e) {
			LogHelper.error("[WINDOW] Failed to switch to window index: ${index}", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToWindowByTitle(String expectedTitle) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			List<String> windows = WebUI.getWindowHandles()
			boolean found = false
			windows.eachWithIndex { handle, index ->
				WebUI.switchToWindowIndex(index)
				if (WebUI.getWindowTitle().equals(expectedTitle)) {
					LogHelper.passed("[WINDOW] Switched to window with title: ${expectedTitle}")
					found = true
					return
				}
			}
			if (!found) {
				LogHelper.warn("[WINDOW] No window with title: ${expectedTitle}")
			}
		} catch (Exception e) {
			LogHelper.error("[WINDOW] Failed to switch to window by title: ${expectedTitle}", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void switchToDefaultTab() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebUI.switchToWindowIndex(0)
			LogHelper.passed("[WINDOW] Switched to default tab (index 0)")
		} catch (Exception e) {
			LogHelper.error("[WINDOW] Failed to switch to default tab", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void printAllWindowTitles() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			List<String> windows = WebUI.getWindowHandles()
			windows.eachWithIndex { handle, index ->
				WebUI.switchToWindowIndex(index)
				String title = WebUI.getWindowTitle()
				println("Window title [${index}]: ${title}")
				LogHelper.passed("[WINDOW] Title [${index}]: ${title}")
			}
		} catch (Exception e) {
			LogHelper.error("[WINDOW] Failed to print all window titles", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void closeCurrentTab() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebUI.closeWindow()
			LogHelper.passed("[WINDOW] Closed current tab")
		} catch (Exception e) {
			LogHelper.error("[WINDOW] Failed to close current tab", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void closeTabByIndex(int index) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			List<String> windows = WebUI.getWindowHandles()
			if (index < 0 || index >= windows.size()) {
				LogHelper.warn("[WINDOW] Cannot close tab. Index ${index} is out of bounds.")
			} else {
				WebUI.switchToWindowIndex(index)
				WebUI.closeWindow()
				LogHelper.passed("[WINDOW] Closed tab at index: ${index}")
			}
		} catch (Exception e) {
			LogHelper.error("[WINDOW] Failed to close tab by index: ${index}", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void closeAllTabsExceptDefault() {
		try {
			WebUI.delay(DEFAULT_DELAY)
			List<String> windows = WebUI.getWindowHandles().collect()
			windows.eachWithIndex { handle, index ->
				if (index != 0) {
					WebUI.switchToWindowIndex(index)
					WebUI.closeWindow()
					LogHelper.passed("[WINDOW] Closed tab at index: ${index}")
				}
			}
			WebUI.switchToWindowIndex(0)
			LogHelper.passed("[WINDOW] All tabs closed except default")
		} catch (Exception e) {
			LogHelper.error("[WINDOW] Failed to close tabs", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}
}
