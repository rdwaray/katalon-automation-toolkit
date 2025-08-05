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

WebUI.click(findTestObject('DemoQA/Widgets/Page_Accordian/h5_Widgets suite'))

WebUI.scrollToElement(findTestObject('DemoQA/Widgets/Page_MenuHover/li_Menu test'), 1)

WebUI.click(findTestObject('DemoQA/Widgets/Page_MenuHover/li_Menu test'))

WebUI.verifyElementText(findTestObject('DemoQA/Widgets/Page_MenuHover/h1_Menu assert'), 'Menu')

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_Main Item 1'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_Main Item 2'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_Sub Item 1'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_Sub Item 2'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_SUB SUB LIST'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_Sub Sub Item 1'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_Sub Sub Item 2'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_MenuHover/a_Main Item 3'))

