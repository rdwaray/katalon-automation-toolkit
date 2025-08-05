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

public class UtilityDropdown {
	//
	//	import utils.UtilityDropdown as UD
	//	import com.kms.katalon.core.testobject.ObjectRepository as OR
	//	import com.kms.katalon.core.model.FailureHandling
	//
	//	def dropdownObj = OR.findTestObject('Page/Demo/dropdown_Country')
	//
	//	// Select by text (akan otomatis log via LogHelper)
	//	UD.selectDropDownByText(dropdownObj, "Indonesia")
	//
	//	// Select by value (continue on failure supaya lanjut walau gagal)
	//	UD.selectDropDownByValue(dropdownObj, "ID", 10, FailureHandling.CONTINUE_ON_FAILURE)
	//
	//	// Select by index
	//	UD.selectDropDownByIndex(dropdownObj, 3)
	//
	//	// Print dropdown options (akan auto log via LogHelper)
	//	UD.printDropDownOptions(dropdownObj)
	//
	//	// Contoh TestObject null (akan auto log error + lanjut karena pakai CONTINUE)
	//	UD.selectDropDownByText(null, "Test", 30, FailureHandling.CONTINUE_ON_FAILURE)
	//	// Full
	//	UD.selectDropDownByValue(dropdownObj, "ID", 10, FailureHandling.CONTINUE_ON_FAILURE)
	//
	//	// Pakai timeout aja, failure handling default
	//	UD.selectDropDownByValue(dropdownObj, "ID", 10)
	//
	//	// Default semua (timeout 30, stop on failure)
	//	UD.selectDropDownByValue(dropdownObj, "ID")
	//

	private static final double DEFAULT_DELAY = 0.5

	@Keyword
	static void selectDropDownByText(TestObject to, String text, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[SELECT DROPDOWN] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebUI.delay(DEFAULT_DELAY)
			UtilityElement.waitForElementVisible(to, timeout)
			WebUI.selectOptionByLabel(to, text, false)
			LogHelper.passed("[SELECT DROPDOWN] By text: '${text}' on object: ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[SELECT DROPDOWN] Failed by text: '${text}' on object: ${to.getObjectId()}", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void selectDropDownByValue(TestObject to, String value, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[SELECT DROPDOWN] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebUI.delay(DEFAULT_DELAY)
			UtilityElement.waitForElementVisible(to, timeout)
			WebUI.selectOptionByValue(to, value, false)
			LogHelper.passed("[SELECT DROPDOWN] By value: '${value}' on object: ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[SELECT DROPDOWN] Failed by value: '${value}' on object: ${to.getObjectId()}", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}
	@Keyword
	static void selectDropDownByIndex(TestObject to, int index, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[SELECT DROPDOWN] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebUI.delay(DEFAULT_DELAY)
			UtilityElement.waitForElementVisible(to, timeout)
			WebUI.selectOptionByIndex(to, index)
			LogHelper.passed("[SELECT DROPDOWN] By index: '${index}' on object: ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[SELECT DROPDOWN] Failed by index: '${index}' on object: ${to.getObjectId()}", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static List<String> printDropDownOptions(TestObject to, int timeout = 30, FailureHandling flowControl = FailureHandling.CONTINUE_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[GET DROPDOWN OPTIONS] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return Collections.emptyList()
		}
		try {
			WebUI.delay(DEFAULT_DELAY)
			UtilityElement.waitForElementVisible(to, timeout)
			List<String> options = WebUI.getOptions(to).collect { it.getLabel() }
			LogHelper.info("=== Options of dropdown ${to.getObjectId()} ===")
			options.each { option ->
				LogHelper.info("[OPTION] ${option}")
			}
			return options
		} catch (Exception e) {
			LogHelper.error("[GET DROPDOWN OPTIONS] Failed on object: ${to.getObjectId()}", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
			return Collections.emptyList()
		} finally {
			LogHelper.flush()
		}
	}
}

