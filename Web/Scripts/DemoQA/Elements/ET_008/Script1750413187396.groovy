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

WebUI.click(findTestObject('DemoQA/Elements/Page_TextBox/h5_ElementTest'))

WebUI.click(findTestObject('DemoQA/Elements/Page_Dynamic Properties/li_Dynamic Properties test'))

WebUI.verifyElementText(findTestObject('DemoQA/Elements/Page_Dynamic Properties/h1_Dynamic Properties assert'), 'Dynamic Properties')

WebUI.waitForElementVisible(findTestObject('DemoQA/Elements/Page_Dynamic Properties/button_Visible After 5 Seconds'), 7)

WebUI.waitForElementClickable(findTestObject('DemoQA/Elements/Page_Dynamic Properties/button_Will enable 5 seconds'), 7)

WebUI.getCSSValue(findTestObject('DemoQA/Elements/Page_Dynamic Properties/button_Color Change'), 'color')

