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

WebUI.click(findTestObject('DemoQA/Interactions/Page_Resizable/li_Resizable test'))

WebUI.verifyElementText(findTestObject('DemoQA/Interactions/Page_Resizable/h1_Resizable assert'), 'Resizable')

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Resizable/span_Resizable_react-resizable-handle react_781f9e (1)'), 
    0)

WebUI.dragAndDropByOffset(findTestObject('Object Repository/DemoQA/Interactions/Page_Resizable/span_Resizable box, starting at 200x200. Mi_4612a1 (1)'), 
    300, 250)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Resizable/h1_Resizable assert (1)'))

