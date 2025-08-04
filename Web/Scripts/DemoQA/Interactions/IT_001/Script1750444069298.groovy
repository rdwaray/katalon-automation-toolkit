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

WebUI.click(findTestObject('DemoQA/Interactions/Page_Sortable/h5_Interactions suite'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Sortable/li_Sortable test'))

WebUI.verifyElementText(findTestObject('DemoQA/Interactions/Page_Sortable/h1_Sortable assert'), 'Sortable')

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Sortable/div_Five a'), 0)

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_One a'), findTestObject('DemoQA/Interactions/Page_Sortable/div_Six a'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_Five a'), findTestObject('DemoQA/Interactions/Page_Sortable/div_Two a'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_Four a'), findTestObject('DemoQA/Interactions/Page_Sortable/div_Three a'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Sortable/a_Grid'))

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Sortable/div_Five'), 0)

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_Four'), findTestObject('DemoQA/Interactions/Page_Sortable/div_One'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_Five'), findTestObject('DemoQA/Interactions/Page_Sortable/div_Two'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_Six'), findTestObject('DemoQA/Interactions/Page_Sortable/div_Three'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_Eight'), findTestObject('DemoQA/Interactions/Page_Sortable/div_Three'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Sortable/div_Nine'), findTestObject('DemoQA/Interactions/Page_Sortable/div_Three'))

