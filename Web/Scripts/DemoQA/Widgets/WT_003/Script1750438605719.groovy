import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement

WebUI.click(findTestObject('DemoQA/Widgets/Page_Accordian/h5_Widgets suite'))

WebUI.click(findTestObject('DemoQA/Widgets/Page_DatePicker/li_Date Picker test'))

WebUI.verifyElementText(findTestObject('DemoQA/Widgets/Page_DatePicker/h1_Date Picker assert'), 'Date Picker')

WebUI.click(findTestObject('DemoQA/Widgets/Page_DatePicker/input_Select Date_datePickerMonthYearInput 1'))

String strKeys = Keys.BACK_SPACE.toString()

WebUI.sendKeys(findTestObject('DemoQA/Widgets/Page_DatePicker/input_Select Date_datePickerMonthYearInput 1'), strKeys.repeat(
        10))

WebUI.setText(findTestObject('DemoQA/Widgets/Page_DatePicker/input_Select Date_datePickerMonthYearInput 1'), '01/10/2011')

WebUI.click(findTestObject('DemoQA/Widgets/Page_DatePicker/h1_Date Picker assert'))

WebUI.click(findTestObject('DemoQA/Widgets/Page_DatePicker/input_Date And Time_dateAndTimePickerInput 2'))

WebUI.sendKeys(findTestObject('DemoQA/Widgets/Page_DatePicker/input_Date And Time_dateAndTimePickerInput 2'), strKeys.repeat(
        22))

WebUI.setText(findTestObject('DemoQA/Widgets/Page_DatePicker/input_Date And Time_dateAndTimePickerInput 2'), '01/10/2011  1:15 AM')

WebUI.click(findTestObject('DemoQA/Widgets/Page_DatePicker/h1_Date Picker assert'))

