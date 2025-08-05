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

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/div_Forms suite'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/li_Practice Form test'))

WebUI.verifyElementText(findTestObject('DemoQA/Elements/Page_UploadDownload/h1_Upload and Download assert'), 'Practice Form')

WebUI.setText(findTestObject('DemoQA/Forms/Page_Forms/input_Name_firstName'), FirstName)

WebUI.setText(findTestObject('DemoQA/Forms/Page_Forms/input_Name_lastName'), LastName)

WebUI.setText(findTestObject('DemoQA/Forms/Page_Forms/input_Email_userEmail'), Email)

WebUI.setText(findTestObject('DemoQA/Forms/Page_Forms/input_(10 Digits)_userNumber'), MobileNumber)

//WebUI.setText(findTestObject('DemoQA/Forms/Page_Forms/input_Date of Birth_dateOfBirthInput'), DateofBirth)
WebUI.setText(findTestObject('DemoQA/Forms/Page_Forms/textarea_Current Address_currentAddress'), Address)

WebUI.scrollToElement(findTestObject('DemoQA/Forms/Page_Forms/div_Subjects_subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3'), 
    0)

WebUI.click(findTestObject('Object Repository/DemoQA/Forms/Page_Forms/div_Subjects_subjects-auto-complete__value-_d244cf'))

WebUI.setText(findTestObject('Object Repository/DemoQA/Forms/Page_Forms/input_Subjects_subjectsInput'), 'ce')

WebUI.click(findTestObject('Object Repository/DemoQA/Forms/Page_Forms/div_Computer Science'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/label_Female'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/label_Other'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/label_Male'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/label_Reading'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/label_Sports'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/label_Music'))

WebUI.scrollToElement(findTestObject('DemoQA/Forms/Page_Forms/input_Select picture_uploadPicture'), 0)

WebUI.uploadFile(findTestObject('DemoQA/Forms/Page_Forms/input_Select picture_uploadPicture'), 'C:\\Users\\Ray\\Katalon Studio\\DemoQA\\Data Files\\sampleFile.jpeg')

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/div_Select State'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/div_NCR'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/div_Select City'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/div_Delhi'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/button_Submit'))

WebUI.getText(findTestObject('DemoQA/Forms/Page_Forms/div_Thanks for submitting the form'))

WebUI.click(findTestObject('DemoQA/Forms/Page_Forms/button_Close'))

