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

WebUI.scrollToElement(findTestObject('DemoQA/Widgets/Page_SelectMenu/li_Select Menu test'), 1)

WebUI.click(findTestObject('DemoQA/Widgets/Page_SelectMenu/li_Select Menu test'))

WebUI.verifyElementText(findTestObject('DemoQA/Widgets/Page_SelectMenu/h1_Select Menu assert'), 'Select Menu')

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Select Option (1)'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Group 1, option 1'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Group 1, option 1_1'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Group 1, option 2'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Select Title (1)'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Dr'))

WebUI.scrollToElement(findTestObject('DemoQA/Widgets/Page_SelectMenu/select_RedBlueGreenYellowPurpleBlackWhiteVoiletIndigoMagentaAqua'), 
    0)

WebUI.selectOptionByValue(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/select_RedBlueGreenYellowPurpleBlackWhiteVo_537a50'), 
    '1', true)

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Select (1)'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Green'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Blue'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Black'))

WebUI.click(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/div_Red'))

WebUI.selectOptionByValue(findTestObject('Object Repository/DemoQA/Widgets/Page_SelectMenu/select_VolvoSaabOpelAudi'), 
    'saab', true)

