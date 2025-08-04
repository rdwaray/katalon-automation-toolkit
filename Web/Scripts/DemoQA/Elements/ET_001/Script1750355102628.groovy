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

WebUI.click(findTestObject('DemoQA/Elements/Page_TextBox/li_Text Box'))

WebUI.setText(findTestObject('Object Repository/DemoQA/Elements/Page_TextBox/input_username'), username)

WebUI.setText(findTestObject('Object Repository/DemoQA/Elements/Page_TextBox/input_email'), email)

WebUI.setText(findTestObject('Object Repository/DemoQA/Elements/Page_TextBox/input_currentaddress'), currentaddress)

WebUI.setText(findTestObject('Object Repository/DemoQA/Elements/Page_TextBox/input_permanentaddress'), permanentaddress)

WebUI.scrollToElement(findTestObject('Object Repository/DemoQA/Elements/Page_TextBox/button_Submit'), 1)
WebUI.click(findTestObject('Object Repository/DemoQA/Elements/Page_TextBox/button_Submit'))

WebUI.getText(findTestObject('Object Repository/DemoQA/Elements/Page_TextBox/li_Text Box'))

