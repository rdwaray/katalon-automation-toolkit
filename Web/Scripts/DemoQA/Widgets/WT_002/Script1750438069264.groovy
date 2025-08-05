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

WebUI.click(findTestObject('DemoQA/Widgets/Page_AutoComplete/li_Auto Complete test'))

WebUI.verifyElementText(findTestObject('DemoQA/Widgets/Page_AutoComplete/h1_Auto Complete assert'), 'Auto Complete')

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Type multiple color names_auto-complete_ecc757'))

WebUI.setText(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/input_Type multiple color names_autoComplet_e23c2f'), 
    'red')

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Red'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Red_1'))

WebUI.setText(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/input_Type multiple color names_autoComplet_e23c2f'), 
    'gree')

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Green'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_RedGreen'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Green_css-xb97g8 auto-complete__multi-v_216c45'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Type single color name_auto-complete__v_774fb0 (1)'))

WebUI.setText(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/input_Type single color name_autoCompleteSi_4b3ca5 (1)'), 
    'pu')

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Purple'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Purple_1'))

WebUI.setText(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/input_Type single color name_autoCompleteSi_4b3ca5 (1)'), 
    'o')

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_AutoComplete/div_Yellow'))

