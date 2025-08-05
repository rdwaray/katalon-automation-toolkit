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

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import helper.LogHelper
public class UtilityValidation {

	//	// Contoh Testing Validation
	//
	//	import utils.UtilityValidation as UV
	//
	//	// Element Detail dan Get Text
	//	UV.printElementDetails(findTestObject('Page/Login/txt_Username'))
	//	String usernameText = UV.getElementText(findTestObject('Page/Login/txt_Username'))
	//
	//	// Assert String
	//	UV.assertEqualsString('ExpectedUser', usernameText)
	//	UV.assertNotEqualsString('WrongUser', usernameText)
	//	UV.assertContainsString('User', usernameText)
	//
	//	// Assert Number
	//	UV.assertEqualsInteger(100, 100)
	//	UV.assertEqualsDouble(99.95, 100, 0.1)
	//
	//	// Validate All Links & Images di halaman
	//	UV.validateLinksAndImages()
	//
	//	// Click element di table
	//	UV.clickElementInTableCell(findTestObject('Page/Table/tbl_UserList'), 0, 'ray', 2, findTestObject('Page/Table/btn_Edit'))
	//
	//	// Validate semua gambar/link dalam container
	//	UV.validateAllImages(findTestObject('Page/Section/container'))
	//	UV.validateAllLinks(findTestObject('Page/Section/container'))
	//
	//	// Validate CSV Row
	//	String[] sampleRow = ['a', 'b', 'c']
	//	UV.validateRowLength(sampleRow, 3, 1)

	private static final double DEFAULT_DELAY = 0.5

	@Keyword
	static void printElementDetails(TestObject to) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			WebElement element = WebUiCommonHelper.findWebElement(to, 10)
			LogHelper.passed("[ELEMENT DETAIL] Object: ${to.getObjectId()}")
			println "=== Element Details ==="
			println "Tag Name   : ${element.getTagName()}"
			println "Text       : ${element.getText()}"
			println "Value      : ${element.getAttribute('value')}"
			println "Type       : ${element.getAttribute('type')}"
			println "Name       : ${element.getAttribute('name')}"
			println "Placeholder: ${element.getAttribute('placeholder')}"
			println "CSS Class  : ${element.getAttribute('class')}"
			println "Displayed  : ${element.isDisplayed()}"
			println "Enabled    : ${element.isEnabled()}"
			println "Location   : ${element.getLocation()}"
			println "Size       : ${element.getSize()}"
			println "========================"
		} catch (Exception e) {
			LogHelper.error("[ELEMENT DETAIL] Failed", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static String getElementText(TestObject to) {
		try {
			WebUI.delay(DEFAULT_DELAY)
			String text = WebUI.getText(to)
			LogHelper.passed("[GET TEXT] '${text}' from ${to.getObjectId()}")
			return text
		} catch (Exception e) {
			LogHelper.error("[GET TEXT] Failed on ${to.getObjectId()}", e)
			LogHelper.takeScreenshot()
			return ''
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void assertEqualsString(String expected, String actual) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			if (expected?.equals(actual)) {
				LogHelper.passed("[ASSERT] Passed — Expected: '${expected}' | Actual: '${actual}'")
			} else {
				LogHelper.error("[ASSERT] Failed — Expected: '${expected}' | Actual: '${actual}'")
				throw new AssertionError("Assertion failed: Expected '${expected}', got '${actual}'")
			}
		} catch (AssertionError e) {
			LogHelper.takeScreenshot()
			throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void assertEqualsDouble(double expected, double actual, double delta = 0.01) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			if (Math.abs(expected - actual) <= delta) {
				LogHelper.passed("[ASSERT] Passed — Expected: ${expected} ± ${delta} | Actual: ${actual}")
			} else {
				LogHelper.error("[ASSERT] Failed — Expected: ${expected} | Actual: ${actual}")
				throw new AssertionError("Assertion failed: Expected ${expected}, got ${actual}")
			}
		} catch (AssertionError e) {
			LogHelper.takeScreenshot()
			throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void assertEqualsInteger(int expected, int actual) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			if (expected == actual) {
				LogHelper.passed("[ASSERT] Passed — Expected: ${expected} | Actual: ${actual}")
			} else {
				LogHelper.error("[ASSERT] Failed — Expected: ${expected} | Actual: ${actual}")
				throw new AssertionError("Assertion failed: Expected ${expected}, got ${actual}")
			}
		} catch (AssertionError e) {
			LogHelper.takeScreenshot()
			throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void validateLinksAndImages() {
		WebUI.delay(DEFAULT_DELAY)
		try {
			def driver = DriverFactory.getWebDriver()
			driver.findElements(By.tagName("a")).each { el -> checkUrlStatus(el.getAttribute('href'), 'LINK') }
			driver.findElements(By.tagName("img")).each { el -> checkUrlStatus(el.getAttribute('src'), 'IMAGE') }
		} finally {
			LogHelper.flush()
		}
	}

	private static void checkUrlStatus(String url, String type) {
		if (!url?.trim()) return
			try {
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection()
				conn.setRequestMethod("GET")
				conn.setConnectTimeout(3000)
				conn.connect()
				int code = conn.getResponseCode()
				if (code == 200) {
					LogHelper.passed("[VALID ${type}] ${url}")
				} else {
					LogHelper.error("[BROKEN ${type}] ${url} - Status ${code}", new Exception("Broken ${type}"))
				}
			} catch (Exception e) {
				LogHelper.error("[ERROR ${type}] ${url} - ${e.message}", e)
			} finally {
				LogHelper.flush()
			}
	}

	@Keyword
	static void clickElementInTableCell(TestObject tableObj, int searchColIdx, String cellValue, int targetColIdx, TestObject innerElementObj) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			WebElement table = WebUiCommonHelper.findWebElement(tableObj, 10)
			List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"))

			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"))
				if (cells.size() > Math.max(searchColIdx, targetColIdx)) {
					String value = cells.get(searchColIdx).getText().trim()
					if (value.equalsIgnoreCase(cellValue)) {
						WebElement targetCell = cells.get(targetColIdx)
						WebElement innerElem = targetCell.findElement(By.xpath(innerElementObj.findPropertyValue('xpath')))
						innerElem.click()
						LogHelper.passed("[TABLE CLICK] Clicked '${innerElementObj.getObjectId()}' for '${cellValue}' at col ${targetColIdx}")
						return
					}
				}
			}
			LogHelper.warning("[TABLE CLICK] '${cellValue}' not found in table")
		} catch (Exception e) {
			LogHelper.error("[TABLE CLICK] Failed to click '${innerElementObj.getObjectId()}' for '${cellValue}'", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void validateAllImages(TestObject container) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			WebElement root = WebUiCommonHelper.findWebElement(container, 10)
			root.findElements(By.tagName("img")).each { img ->
				String src = img.getAttribute("src")
				if (src?.trim()) checkUrlStatus(src, "IMAGE")
			}
		} catch (Exception e) {
			LogHelper.error("[VALIDATE IMAGES] Failed", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void validateAllLinks(TestObject container) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			WebElement root = WebUiCommonHelper.findWebElement(container, 10)
			root.findElements(By.tagName("a")).each { link ->
				String href = link.getAttribute("href")
				if (href?.trim()) checkUrlStatus(href, "LINK")
			}
		} catch (Exception e) {
			LogHelper.error("[VALIDATE LINKS] Failed", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void validateRowLength(String[] row, int expectedLength, int rowIndex) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			if (row.length != expectedLength) {
				LogHelper.error("[CSV VALIDATION] Row ${rowIndex} invalid. Expected ${expectedLength}, got ${row.length}")
			} else {
				LogHelper.passed("[CSV VALIDATION] Row ${rowIndex} valid with ${row.length} columns.")
			}
		} finally {
			LogHelper.flush()
		}
	}
	@Keyword
	static void assertNotEqualsString(String unexpected, String actual) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			if (unexpected != actual) {
				LogHelper.passed("[ASSERT NOT EQUALS] Passed — Unexpected: '${unexpected}' | Actual: '${actual}'")
			} else {
				LogHelper.error("[ASSERT NOT EQUALS] Failed — Both are '${actual}'")
				throw new AssertionError("Assertion failed: Unexpected '${unexpected}', but got '${actual}'")
			}
		} catch (AssertionError e) {
			LogHelper.takeScreenshot()
			throw e
		} finally {
			LogHelper.flush()
		}
	}

	@Keyword
	static void assertContainsString(String expectedSubstring, String actual) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			if (actual.contains(expectedSubstring)) {
				LogHelper.passed("[ASSERT CONTAINS] Passed — '${actual}' contains '${expectedSubstring}'")
			} else {
				LogHelper.error("[ASSERT CONTAINS] Failed — '${actual}' does not contain '${expectedSubstring}'")
				throw new AssertionError("Assertion failed: '${actual}' does not contain '${expectedSubstring}'")
			}
		} catch (AssertionError e) {
			LogHelper.takeScreenshot()
			throw e
		} finally {
			LogHelper.flush()
		}
	}
	
	@Keyword
	//UV.validateLinksFromList(['https://google.com', 'https://openai.com'])

	static void validateLinksFromList(List<String> links) {
		WebUI.delay(DEFAULT_DELAY)
		try {
			if (!links) {
				LogHelper.warn("[VALIDATE LINKS] Link list is empty or null")
				return
			}
			links.each { url ->
				if (url?.trim()) {
					checkUrlStatus(url, "LINK")
				} else {
					LogHelper.warn("[VALIDATE LINKS] Skipped empty or invalid URL in list")
				}
			}
			LogHelper.passed("[VALIDATE LINKS] Successfully validated ${links.size()} links")
		} catch (Exception e) {
			LogHelper.error("[VALIDATE LINKS] Failed validating links list", e)
			LogHelper.takeScreenshot()
		} finally {
			LogHelper.flush()
		}
	}
	
}
