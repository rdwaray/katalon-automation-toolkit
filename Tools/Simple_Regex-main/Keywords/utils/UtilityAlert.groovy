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
import org.openqa.selenium.Alert
import org.openqa.selenium.NoAlertPresentException
import org.openqa.selenium.WebDriver
import internal.GlobalVariable


import helper.LogHelper

//UA.acceptAlert()
//UA.dismissAlert()
//UA.getAlertText
//UA.sendKeysToAlert("Halo")
public class UtilityAlert {
	private static final double DEFAULT_DELAY = 0.3

	@Keyword
	static boolean isAlertPresent(FailureHandling flowControl = FailureHandling.CONTINUE_ON_FAILURE) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebDriver driver = DriverFactory.getWebDriver()
			driver.switchTo().alert()
			LogHelper.info("[IS ALERT PRESENT] Alert is present")
			return true
		} catch (NoAlertPresentException e) {
			LogHelper.info("[IS ALERT PRESENT] No alert present")
			return false
		} catch (Exception e) {
			LogHelper.error("[IS ALERT PRESENT] Error checking alert presence", e)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
			return false
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void acceptAlert(FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebDriver driver = DriverFactory.getWebDriver()
			Alert alert = driver.switchTo().alert()
			String alertText = alert.getText()
			alert.accept()
			LogHelper.passed("[ACCEPT ALERT] '${alertText}'")
		} catch (NoAlertPresentException e) {
			LogHelper.warn("[ACCEPT ALERT] No alert present - ${e.getMessage()}")
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
		} catch (Exception e) {
			LogHelper.error("[ACCEPT ALERT] Failed", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void dismissAlert(FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebDriver driver = DriverFactory.getWebDriver()
			Alert alert = driver.switchTo().alert()
			String alertText = alert.getText()
			alert.dismiss()
			LogHelper.passed("[DISMISS ALERT] '${alertText}'")
		} catch (NoAlertPresentException e) {
			LogHelper.warn("[DISMISS ALERT] No alert present - ${e.getMessage()}")
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
		} catch (Exception e) {
			LogHelper.error("[DISMISS ALERT] Failed", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static String getAlertText(FailureHandling flowControl = FailureHandling.CONTINUE_ON_FAILURE) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebDriver driver = DriverFactory.getWebDriver()
			Alert alert = driver.switchTo().alert()
			String alertText = alert.getText()
			LogHelper.info("[GET ALERT TEXT] '${alertText}'")
			return alertText
		} catch (NoAlertPresentException e) {
			LogHelper.warn("[GET ALERT TEXT] No alert present - ${e.getMessage()}")
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
			return null
		} catch (Exception e) {
			LogHelper.error("[GET ALERT TEXT] Failed", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
			return null
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static String sendKeysToAlert(String inputText, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebDriver driver = DriverFactory.getWebDriver()
			Alert alert = driver.switchTo().alert()
			alert.sendKeys(inputText)
			String alertText = alert.getText()
			alert.accept()
			LogHelper.passed("[SEND KEYS TO ALERT] Input: '${inputText}' | Alert Text: '${alertText}'")
			return alertText
		} catch (NoAlertPresentException e) {
			LogHelper.warn("[SEND KEYS TO ALERT] No alert present - ${e.getMessage()}")
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
			return null
		} catch (Exception e) {
			LogHelper.error("[SEND KEYS TO ALERT] Failed", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) {
				throw e
			}
			return null
		} finally {
			LogHelper.flush()
		}
	}
}


