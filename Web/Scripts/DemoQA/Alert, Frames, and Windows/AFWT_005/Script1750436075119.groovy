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

WebUI.click(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Windows/div_Alerts, Frame  Windows suite'))

WebUI.click(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/li_Modal Dialogs test'))

WebUI.verifyElementText(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/h1_Modal Dialogs assert'), 'Modal Dialogs')

WebUI.click(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/button_Small modal'))

WebUI.verifyElementText(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/div_Small Modal assert'), 'Small Modal')

WebUI.click(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/button_Close small'))

WebUI.click(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/button_Large modal'))

WebUI.verifyElementText(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/div_Large Modal assert'), 'Large Modal')

WebUI.click(findTestObject('DemoQA/Alert, Frames, and Windows/Page_Modal/button_Close large'))

