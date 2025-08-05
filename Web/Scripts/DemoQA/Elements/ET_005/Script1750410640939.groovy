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

WebUI.click(findTestObject('DemoQA/Elements/Page_Button/li_Buttons test'))

WebUI.verifyElementText(findTestObject('DemoQA/Elements/Page_Button/h1_Buttons assert'), 'Buttons')

WebUI.doubleClick(findTestObject('DemoQA/Elements/Page_Button/button_Double Click Me'))

WebUI.getText(findTestObject('DemoQA/Elements/Page_Button/p_You have done a double click'))

WebUI.rightClick(findTestObject('DemoQA/Elements/Page_Button/button_Right Click Me'))

WebUI.getText(findTestObject('DemoQA/Elements/Page_Button/p_You have done a right click'))

WebUI.click(findTestObject('DemoQA/Elements/Page_Button/button_Click Me'))

WebUI.getText(findTestObject('DemoQA/Elements/Page_Button/p_You have done a dynamic click'))

