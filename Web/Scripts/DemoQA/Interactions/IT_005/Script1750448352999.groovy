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

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Draggable/li_Dragabble test'), 0)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Draggable/li_Dragabble test'))

WebUI.verifyElementText(findTestObject('DemoQA/Interactions/Page_Draggable/h1_Dragabble suite'), 'Dragabble')

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_Drag me a'), 200, 200)

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Draggable/a_Axis Restricted'), 0)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Draggable/a_Axis Restricted'))

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_Only X'), 100, 0)

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_Only Y'), 0, 100)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Draggable/a_Container Restricted'))

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_Im contained within the box'), 100, 100)

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_Im contained within my parent'), 100, 100)

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Draggable/a_Cursor Style'), 0)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Draggable/a_Cursor Style'))

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_I will always stick to the center'), 50, 
    50)

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_My cursor is at bottom'), 100, 100)

WebUI.dragAndDropByOffset(findTestObject('DemoQA/Interactions/Page_Draggable/div_My cursor is at top left'), 150, 150)

