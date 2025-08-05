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
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import internal.GlobalVariable
import helper.LogHelper

public class UtilityElement {
	//	import utils.UtilityElement as UE

	//	// PAUSE (delay)
	//	UE.pause(2000)  // Delay 2 detik
	//
	//	// WAIT FOR ELEMENT
	//	UE.waitForElementVisible(findTestObject('Page/Login/txt_Username'))
	//
	//	// SEND KEYS (input)
	//	UE.sendKeys(findTestObject('Page/Login/txt_Username'), "tester")
	//
	//	// SEND KEYS WITH JS
	//	UE.sendKeysWithJS(findTestObject('Page/Login/txt_Username'), "testerJS")
	//
	//	// SAFE CLICK
	//	UE.safeClick(findTestObject('Page/Login/btn_Login'))
	//
	//	// DOUBLE CLICK
	//	UE.doubleClick(findTestObject('Page/Data/txt_Field'))
	//
	//	// CLICK MULTIPLE TIMES
	//	UE.clickMultipleTime(findTestObject('Page/Like/btn_Like'), 5, 500)
	//
	//	// RIGHT CLICK WITH JS
	//	UE.rightClickWithJS(findTestObject('Page/ContextMenu/area_RightClick'))
	//
	//	// DRAG & DROP
	//	UE.dragAndDrop(findTestObject('Page/Drag/source_Item'), findTestObject('Page/Drag/target_Box'))
	//
	//	// DRAG & DROP BY OFFSET
	//	UE.dragAndDropByOffset(findTestObject('Page/Drag/source_Item'), 100, 0)
	//
	//	// CLICK AND HOLD (DRAG THEN RELEASE ON TARGET)
	//	UE.clickAndHold(findTestObject('Page/Drag/source_Item'), findTestObject('Page/Drag/target_Box'))
	//
	//	// RESIZE ELEMENT
	//	UE.resizeElement(findTestObject('Page/Resize/handle_Resizer'), 50, 50)
	//
	//	// LONG PRESS
	//	UE.longPress(findTestObject('Page/Button/btn_Hold'), 3000)  // 3 detik hold
	//

	private static final double DEFAULT_DELAY = 0.5

	@Keyword
	static void pause(int timeoutMillis) {
		try {
			WebUI.delay(timeoutMillis / 1000.0)
			LogHelper.passed("[ELEMENT][PAUSE] Delay selama ${timeoutMillis} ms")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][PAUSE] Gagal delay", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void waitForElementVisible(TestObject to, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][WAIT] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebUI.waitForElementVisible(to, timeout)
			LogHelper.passed("[ELEMENT][WAIT] Element visible: ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][WAIT] Gagal menemukan element: ${to.getObjectId()}", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void sendKeys(TestObject to, String text, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][SEND KEYS] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			waitForElementVisible(to, timeout, flowControl)
			WebUI.clearText(to)
			WebUI.setText(to, text)
			LogHelper.passed("[ELEMENT][SEND KEYS] '${text}' ke ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][SEND KEYS] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void safeClick(TestObject to, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][CLICK] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			waitForElementVisible(to, timeout, flowControl)
			WebUI.click(to)
			LogHelper.passed("[ELEMENT][CLICK] Element: ${to.getObjectId()}")
		} catch (Exception e) {
			try {
				WebElement elem = WebUiCommonHelper.findWebElement(to, timeout)
				WebUI.executeJavaScript("arguments[0].click();", [elem])
				LogHelper.passed("[ELEMENT][CLICK JS] Fallback click JS: ${to.getObjectId()}")
			} catch (Exception ex) {
				LogHelper.error("[ELEMENT][CLICK JS] Gagal fallback click JS", ex)
				LogHelper.takeScreenshot()
				if (flowControl == FailureHandling.STOP_ON_FAILURE) throw ex
			}
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void doubleClick(TestObject to, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][DOUBLE CLICK] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			waitForElementVisible(to, timeout, flowControl)
			WebUI.doubleClick(to)
			LogHelper.passed("[ELEMENT][DOUBLE CLICK] ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][DOUBLE CLICK] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void clickMultipleTime(TestObject to, int times, int delayMs, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][CLICK MULTI] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			for (int i = 1; i <= times; i++) {
				safeClick(to, timeout, flowControl)
				pause(delayMs)
			}
			LogHelper.passed("[ELEMENT][CLICK MULTI] ${times}x pada ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}
	@Keyword
	static void rightClickWithJS(TestObject to, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][RIGHT CLICK JS] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebElement elem = WebUiCommonHelper.findWebElement(to, timeout)
			String js = "var evt = new MouseEvent('contextmenu',{bubbles:true,cancelable:true,view:window,button:2});arguments[0].dispatchEvent(evt);"
			WebUI.executeJavaScript(js, [elem])
			LogHelper.passed("[ELEMENT][RIGHT CLICK JS] ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][RIGHT CLICK JS] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void dragAndDrop(TestObject source, TestObject target, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (source == null || target == null) {
			LogHelper.error("[ELEMENT][DRAG] Source atau Target null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("Source/Target cannot be null")
			return
		}
		try {
			WebElement src = WebUiCommonHelper.findWebElement(source, timeout)
			WebElement tgt = WebUiCommonHelper.findWebElement(target, timeout)
			new Actions(WebUI.getWebDriver()).dragAndDrop(src, tgt).perform()
			LogHelper.passed("[ELEMENT][DRAG] ${source.getObjectId()} → ${target.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][DRAG] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void dragAndDropByOffset(TestObject to, int xOffset, int yOffset, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][DRAG OFFSET] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebElement elem = WebUiCommonHelper.findWebElement(to, timeout)
			new Actions(WebUI.getWebDriver()).dragAndDropBy(elem, xOffset, yOffset).perform()
			LogHelper.passed("[ELEMENT][DRAG OFFSET] ${to.getObjectId()} sejauh (${xOffset}, ${yOffset})")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][DRAG OFFSET] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void clickAndHold(TestObject source, TestObject target, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (source == null || target == null) {
			LogHelper.error("[ELEMENT][CLICK HOLD] Source atau Target null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("Source/Target cannot be null")
			return
		}
		try {
			WebElement src = WebUiCommonHelper.findWebElement(source, timeout)
			WebElement tgt = WebUiCommonHelper.findWebElement(target, timeout)
			new Actions(WebUI.getWebDriver()).clickAndHold(src).moveToElement(tgt).release().perform()
			LogHelper.passed("[ELEMENT][CLICK HOLD] ${source.getObjectId()} → ${target.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][CLICK HOLD] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void resizeElement(TestObject to, int xOffset, int yOffset, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][RESIZE] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebElement resizer = WebUiCommonHelper.findWebElement(to, timeout)
			new Actions(WebUI.getWebDriver()).clickAndHold(resizer).moveByOffset(xOffset, yOffset).release().perform()
			LogHelper.passed("[ELEMENT][RESIZE] ${to.getObjectId()} sebesar (${xOffset}, ${yOffset})")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][RESIZE] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void longPress(TestObject to, int durationMillis, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][LONG PRESS] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebElement elem = WebUiCommonHelper.findWebElement(to, timeout)
			new Actions(WebUI.getWebDriver()).clickAndHold(elem).pause(durationMillis).release().perform()
			LogHelper.passed("[ELEMENT][LONG PRESS] ${to.getObjectId()} selama ${durationMillis} ms")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][LONG PRESS] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}
	@Keyword
	static void sendKeysWithJS(TestObject to, String text, int timeout = 30, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		if (to == null) {
			LogHelper.error("[ELEMENT][JS SEND KEYS] TestObject is null", null)
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw new IllegalArgumentException("TestObject cannot be null")
			return
		}
		try {
			WebElement elem = WebUiCommonHelper.findWebElement(to, timeout)
			String safeText = text.replace("'", "\\'")
			WebUI.executeJavaScript("arguments[0].value='${safeText}'", [elem])
			LogHelper.passed("[ELEMENT][JS SEND KEYS] '${text}' ke ${to.getObjectId()}")
		} catch (Exception e) {
			LogHelper.error("[ELEMENT][JS SEND KEYS] Gagal", e)
			LogHelper.takeScreenshot()
			if (flowControl == FailureHandling.STOP_ON_FAILURE) throw e
		} finally {
			LogHelper.flush()
		}
	}
}
