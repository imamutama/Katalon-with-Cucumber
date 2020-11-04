import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Pembayaran {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("open browser and navigate url")
	def getNavigate() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('http://kitabisa.com')
		WebUI.delay(5)
	}

	@When("select campaign and Click Donasi")
	def selectCampaign() {
		WebUI.click(findTestObject('ObjectKitabisa/donasi_select'))
		WebUI.delay(3)
		WebUI.click(findTestObject('ObjectKitabisa/button_Donasi'))
		WebUI.delay(3)
	}

	@And("select amount,payment and enter(.*),(.*) and (.*)")
	def inputPayment(String fullname, String email, String remark){
		WebUI.click(findTestObject('ObjectKitabisa/nominalDonasi_10000'))
		WebUI.delay(3)
		WebUI.click(findTestObject('ObjectKitabisa/methodPembayaran_BCA'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('ObjectKitabisa/input_fullname'), fullname)
		WebUI.delay(3)
		WebUI.setText(findTestObject('ObjectKitabisa/input_email'), email)
		WebUI.delay(3)
		WebUI.setText(findTestObject('ObjectKitabisa/input_komentar'), remark)
		WebUI.delay(3)
		WebUI.click(findTestObject('ObjectKitabisa/button_pembayaran'))
	}
	@Then("verify and close back campaign")
	def closeCampaign() {
		def element = WebUI.verifyElementPresent(findTestObject('ObjectKitabisa/element_Banner'), 10)
		if(element==true){
			println("Success Input Data")
		}else{
			println("Gagal Input Data")
		}
		WebUI.delay(3)
		WebUI.click(findTestObject("Object Repository/ObjectKitabisa/close_banner"))
		WebUI.delay(3)
		WebUI.click(findTestObject("Object Repository/ObjectKitabisa/button_Kembali ke penggalangan"))
		WebUI.delay(3)
		WebUI.click(findTestObject("Object Repository/ObjectKitabisa/arrow_campaign"))
		WebUI.delay(3)
		WebUI.closeBrowser()
	}
}