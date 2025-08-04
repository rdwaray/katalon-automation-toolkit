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

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Droppable/li_Droppable test'), 0)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Droppable/li_Droppable test'))

WebUI.verifyElementText(findTestObject('DemoQA/Interactions/Page_Droppable/h1_Droppable assert'), 'Droppable')

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Drag me a'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Drop here a'))

WebUI.getCSSValue(findTestObject('DemoQA/Interactions/Page_Droppable/div_Drop here a'), 'color')

WebUI.click(findTestObject('DemoQA/Interactions/Page_Droppable/a_Accept b'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Acceptable b'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Drop here b'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Not  Acceptable b'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Drop here b'))

WebUI.getCSSValue(findTestObject('DemoQA/Interactions/Page_Droppable/div_Drop here b'), 'color')

WebUI.click(findTestObject('DemoQA/Interactions/Page_Droppable/a_Prevent Propogation c'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Drag Me c'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Inner droppable (not greedy) c'))

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Droppable/div_Outer droppableInner droppable (not greedy) c'), 
    0)

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Drag Me c'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Inner droppable (greedy) c'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Drag Me c'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Outer droppableInner droppable (not greedy) c'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Drag Me c'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Outer droppableInner droppable (greedy) c'))

WebUI.getCSSValue(findTestObject('DemoQA/Interactions/Page_Droppable/div_Outer droppableInner droppable (not greedy) c'), 'color')

WebUI.getCSSValue(findTestObject('DemoQA/Interactions/Page_Droppable/div_Inner droppable (not greedy) c'), 'color')

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Droppable/a_Revert Draggable d'), 1)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Droppable/a_Revert Draggable d'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Not Revert d'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Drop here d'))

WebUI.dragAndDropToObject(findTestObject('DemoQA/Interactions/Page_Droppable/div_Will Revert d'), findTestObject('DemoQA/Interactions/Page_Droppable/div_Drop here d'))

WebUI.delay(3)

