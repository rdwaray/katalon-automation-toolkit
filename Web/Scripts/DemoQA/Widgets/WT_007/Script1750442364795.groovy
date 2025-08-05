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

WebUI.scrollToElement(findTestObject('DemoQA/Widgets/Page_Hover/li_Tool Tips test'), 1)

WebUI.click(findTestObject('DemoQA/Widgets/Page_Hover/li_Tool Tips test'))

WebUI.verifyElementText(findTestObject('DemoQA/Widgets/Page_Hover/h1_Tool Tips assert'), 'Tool Tips')

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_Hover/button_Hover me to see'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_Hover/input_Hover me to see_toolTipTextField'))

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_Hover/a_Contrary'))

WebUI.scrollToElement(findTestObject('DemoQA/Widgets/Page_Hover/a_1.10.32'), 0)

WebUI.mouseOver(findTestObject('DemoQA/Widgets/Page_Hover/a_1.10.32'))

