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

Mobile.startExistingApplication('com.swaglabsmobileapp')

Mobile.sendKeys(findTestObject('Object Repository/android.widget.EditText - Username'), 'standard_user')

Mobile.setEncryptedText(findTestObject('Object Repository/android.widget.EditText - Password'), 'qcu24s4901FyWDTwXGr6XA==', 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - LOGIN'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - ADD TO CART'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - ADD TO CART'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - 2'), 0)

Mobile.scrollToText('policy')

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - CHECKOUT'), 0)

Mobile.sendKeys(findTestObject('Object Repository/android.widget.EditText - ZipPostal Code'), '123')

Mobile.sendKeys(findTestObject('Object Repository/android.widget.EditText - Last Name'), 'dimas')

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - CONTINUE'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/android.widget.TextView - First Name is required'), 'First Name is required')

Mobile.sendKeys(findTestObject('Object Repository/android.widget.EditText - First Name'), 'ray')

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - CONTINUE (1)'), 0)

Mobile.scrollToText('policy')

Mobile.verifyElementText(findTestObject('Object Repository/android.widget.TextView - Total 43.18'), 'Total: $43.18')

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - FINISH'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/android.widget.TextView - THANK YOU FOR YOU ORDER'), 'THANK YOU FOR YOU ORDER')

Mobile.verifyElementText(findTestObject('Object Repository/android.widget.TextView - Your order has been dispatched, and will arrive just as fast as the pony can get there'), 
    'Your order has been dispatched, and will arrive just as fast as the pony can get there!')

Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.ImageView (7)'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.TextView - BACK HOME'), 0)

Mobile.closeApplication()

