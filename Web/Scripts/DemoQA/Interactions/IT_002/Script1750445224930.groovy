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
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('DemoQA/Interactions/Page_Sortable/h5_Interactions suite'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Selectable test'))

WebUI.verifyElementText(findTestObject('DemoQA/Interactions/Page_Selectable/h1_Selectable assert'), 'Selectable')

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Selectable/li_Morbi leo risus'), 0)

def driver = DriverFactory.getWebDriver()

List<By> multipleList = Arrays.asList(By.xpath('//li[normalize-space()=\'Cras justo odio\']'), By.xpath('//li[normalize-space()=\'Dapibus ac facilisis in\']'), 
    By.xpath('//li[normalize-space()=\'Morbi leo risus\']'), By.xpath('//li[normalize-space()=\'Porta ac consectetur ac\']'))

// Loop semua locator
for (By locator : multipleList) {
    List<WebElement> elements = driver.findElements(locator)

    for (WebElement el : elements) {
        el.click()
    }
}

WebUI.scrollToElement(findTestObject('DemoQA/Interactions/Page_Selectable/li_Five'), 0)

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/a_Grid'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_One'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Two'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Three'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Four'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Five'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Six'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Seven'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Eight'))

WebUI.click(findTestObject('DemoQA/Interactions/Page_Selectable/li_Nine'))

