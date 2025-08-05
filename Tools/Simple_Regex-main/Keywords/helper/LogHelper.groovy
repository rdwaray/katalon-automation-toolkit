package helper

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration
import utils.RuntimeInfo
public class LogHelper {

	private static PrintWriter fileLog
	
//	printDropDownOptions
//	sendKeysWithJS
//	clickMultipleTime
//	
//	
//	clickAndHold
//	resizeElement
//	longPress
//	switchToFrameByIndex
//	switchToFrameByNameOrId
//	switchToFrameByLocator
//	printAllWindowTitles
//	closeAllTabsExceptDefault
//	
//	
//	switchToWindowByTitle
//	
//	closeTabByIndex
//	
//	findElementInOpenShadowRoot
//	findElementInClosedShadowRootJS
//	printElementDetails
//	
//	assertEqualsDouble
//	assertEqualsInteger
//	validateLinksAndImages
//	validateAllImages
//	clickElementInTableCell
//	validateAllLinks
//	validateRowLength
	
	
	
	@Keyword
	static void initLogs() {
		//		try {
		//			if (fileLog == null) {
		//				String baseFolder = RunConfiguration.getProjectDir() + "/Reports/output/"
		//				new File(baseFolder).mkdirs()
		//				String timestamp = new Date().format('yyyyMMdd_HHmmss')
		//				String filePath = "${baseFolder}log_${timestamp}.txt"
		//				fileLog = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)), true)
		//				KeywordUtil.logInfo("[LOG] Log file created at: ${filePath}")
		//			}
		//		} catch (Exception e) {
		//			KeywordUtil.markFailed("Failed to initialize log file: " + e.message)
		//		}
		try {
			if (fileLog == null) {
				String baseFolder = RunConfiguration.getProjectDir() + "/Reports/output/"
				new File(baseFolder).mkdirs()
				String timestamp = new Date().format('yyyyMMdd_HHmmss')
				String filePath = "${baseFolder}log_${timestamp}.txt"
				fileLog = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)), true)
				KeywordUtil.logInfo("[LOG] Log file created at: ${filePath}")

				if (RuntimeInfo.currentTestCase) {
					fileLog.println("[LOG] Current Test Case: ${RuntimeInfo.currentTestCase}")
				}
				if (RuntimeInfo.currentTestSuite) {
					fileLog.println("[LOG] Current Test Suite: ${RuntimeInfo.currentTestSuite}")
				}
				if (RuntimeInfo.currentSuiteCollection) {
					fileLog.println("[LOG] Current Suite Collection: ${RuntimeInfo.currentSuiteCollection}")
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Failed to initialize log file: " + e.message)
		}
	}

	@Keyword
	static void writeLog(String message) {
		String finalMessage = "${getTimestamp()} | ${message}"
		KeywordUtil.logInfo(finalMessage)
		if (fileLog != null) {
			fileLog.println(finalMessage)
		}
	}

	@Keyword
	static void closeLogs() {
		if (fileLog != null) {
			fileLog.close()
			fileLog = null
		}
	}

	private static String getTimestamp() {
		return new Date().format('HH:mm:ss')
	}

	@Keyword
	static void info(String message) {
		KeywordUtil.logInfo("[INFO] " + message)
		writeLog("[INFO] " + message)
	}

	@Keyword
	static void warning(String message) {
		KeywordUtil.markWarning("[WARN] " + message)
		writeLog("[WARN] " + message)
	}

	@Keyword
	static void passed(String message) {
		KeywordUtil.markPassed("[PASS] " + message)
		writeLog("[PASS] " + message)
	}

	@Keyword
	static void error(String message, Exception e = null) {
		KeywordUtil.markFailed("[ERROR] " + message)
		writeLog("[ERROR] " + message)
		if (e != null) {
			writeLog("[STACK] " + e.getMessage())
		}
	}

	@Keyword
	static void takeScreenshot() {
		WebUI.takeScreenshot()
		writeLog("[SCREENSHOT] Screenshot taken.")
	}

	@Keyword
	static void flush() {
		if (fileLog != null) {
			fileLog.flush()
		}
	}
}
