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

public class GridHelper {

	@Keyword
	def int[] gridToXY(int row, int col, int maxRow, int maxCol, int screenWidth, int screenHeight) {
		int x = ((col + 0.5) * screenWidth / maxCol) as int
		int y = ((row + 0.5) * screenHeight / maxRow) as int
		return [x, y]
	}

	@Keyword
	def void tapGrid(int row, int col, int maxRow, int maxCol, int screenWidth, int screenHeight) {
		int[] pos = gridToXY(row, col, maxRow, maxCol, screenWidth, screenHeight)
		Mobile.tapAtPosition(pos[0], pos[1])
		//		CustomKeywords.'GridHelper.tapGrid'(3, 3, 6, 6, 1220, 2712)
	}

	@Keyword
	def void swipeGrid(int fromRow, int fromCol, int toRow, int toCol, int maxRow, int maxCol, int screenWidth, int screenHeight) {
		int[] start = gridToXY(fromRow, fromCol, maxRow, maxCol, screenWidth, screenHeight)
		int[] end = gridToXY(toRow, toCol, maxRow, maxCol, screenWidth, screenHeight)
		Mobile.swipe(start[0], start[1], end[0], end[1])
	}

	@Keyword
	def loginBase() {
		Mobile.startExistingApplication('com.swaglabsmobileapp')

		Mobile.sendKeys(findTestObject('Object Repository/android.widget.EditText - Username'), 'standard_user')

		Mobile.setEncryptedText(findTestObject('Object Repository/android.widget.EditText - Password'),
				'qcu24s4901FyWDTwXGr6XA==', 0)

		Mobile.hideKeyboard()

		Mobile.tap(findTestObject('Object Repository/android.widget.TextView - LOGIN'), 0)
	}
}

