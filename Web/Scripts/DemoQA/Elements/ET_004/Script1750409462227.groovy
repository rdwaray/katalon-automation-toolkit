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

WebUI.click(findTestObject('DemoQA/Elements/Page_WebTables/li_Web Tables'))

WebUI.verifyElementText(findTestObject('DemoQA/Elements/Page_WebTables/li_Web Tables test assert'), 'Web Tables')

WebUI.verifyElementText(findTestObject('DemoQA/Elements/Page_WebTables/div_Cierra assert'), 'Cierra')

WebUI.selectOptionByValue(findTestObject('DemoQA/Elements/Page_WebTables/select_5 rows10 rows20 rows25 rows50 rows100 rows'), 
    '100', false)

WebUI.selectOptionByValue(findTestObject('DemoQA/Elements/Page_WebTables/select_5 rows10 rows20 rows25 rows50 rows100 rows'), 
    '5', false)

WebUI.click(findTestObject('DemoQA/Elements/Page_WebTables/button_Add'))

WebUI.setText(findTestObject('DemoQA/Elements/Page_WebTables/input_First Name_firstName'), 'Ray')

WebUI.setText(findTestObject('DemoQA/Elements/Page_WebTables/input_Last Name_lastName'), 'DWA')

WebUI.setText(findTestObject('DemoQA/Elements/Page_WebTables/input_Email_userEmail'), 'email@aa.com')

WebUI.setText(findTestObject('DemoQA/Elements/Page_WebTables/input_Age_age'), '42')

WebUI.setText(findTestObject('DemoQA/Elements/Page_WebTables/input_Salary_salary'), '599999')

WebUI.setText(findTestObject('DemoQA/Elements/Page_WebTables/input_Department_department'), 'QA')

WebUI.click(findTestObject('DemoQA/Elements/Page_WebTables/button_Submit'))

WebUI.verifyElementText(findTestObject('DemoQA/Elements/Page_WebTables/div_Ray assert'), 'Ray')

WebUI.setText(findTestObject('DemoQA/Elements/Page_WebTables/input_Add_searchBox'), 'Ray')

