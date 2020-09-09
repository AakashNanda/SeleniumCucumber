package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ObjectsRepository.HomePageObjects;
import com.fedex.test.shipping.ObjectsRepository.PackagingAndShipmentDetailsObjects;
import com.fedex.test.shipping.ObjectsRepository.PaymentObjects;
import com.fedex.test.shipping.ObjectsRepository.PickUpAndDropOffObjects;
import com.fedex.test.shipping.ObjectsRepository.RateQuotesObjects;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.DriverFactory;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryAltPickup;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryFrom;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPayment;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPickUpDropOff;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryShipmentDetails;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryTo;
import com.fedex.test.shipping.SummaryCardValidate.SummaryCardAddress;
import com.fedex.test.shipping.SummaryCardValidate.SummaryCardPackagingDetails;
import com.fedex.test.shipping.SummaryCardValidate.SummaryCardPayment;
import com.fedex.test.shipping.SummaryCardValidate.SummaryCardPickUpDropOff;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")

public class Navigation_and_Card_Design_Steps extends SeleniumReusableMethods {
	
	 public HomePageObjects homePageObjects;
	 public AddressEntryObjects addressEntryObjects;
	 public PickUpAndDropOffObjects pickUpAndDropOffObjects;
	 public PaymentObjects paymentObjects;
	 public AddressEntry_Steps addressEntry_Steps;
	 public SummaryPageObjects summaryPageObjects;
	 public SummaryFrom summaryFrom;
	 public SummaryCardAddress summaryCardAddress;
	 public SummaryTo summaryTo;
	 public SummaryShipmentDetails summaryShipmentDetails;
	 public SummaryCardPackagingDetails summaryCardPackagingDetails;
	 public SummaryPickUpDropOff summaryPickUpDropOff;
	 public SummaryCardPickUpDropOff summaryPagePickUpDropOff;
	 public SummaryPayment summaryPayment;
	 public SummaryCardPayment summaryCardPayment;
	 public SummaryAltPickup summaryAltPickup;
	 public RateQuotesObjects rateQuotesObjects;
	 
	 
	 

	    public Navigation_and_Card_Design_Steps(SharedDriverManager driver, 
	    		HomePageObjects homePageObjects, 
	    		AddressEntryObjects addressEntryObjects,
	    		PickUpAndDropOffObjects pickUpAndDropOffObjects,
	    		PaymentObjects paymentObjects,
	    		RateQuotesObjects rateQuotesObjects,
	    		SummaryFrom summaryFrom,
	    		SummaryCardAddress summaryCardAddress,
	    		SummaryTo summaryTo,SummaryShipmentDetails summaryShipmentDetails,
	    		SummaryCardPackagingDetails summaryCardPackagingDetails,
	    		SummaryPickUpDropOff summaryPickUpDropOff,SummaryPageObjects summaryPageObjects,
	    		SummaryCardPickUpDropOff summaryPagePickUpDropOff,
	    		SummaryPayment summaryPayment,
	    		SummaryCardPayment summaryCardPayment,
	    		SummaryAltPickup summaryAltPickup
	    		) {
	        this.homePageObjects=homePageObjects;
	        this.addressEntryObjects=addressEntryObjects;
	        this.pickUpAndDropOffObjects=pickUpAndDropOffObjects;
	        this.paymentObjects=paymentObjects;
	        this.summaryPageObjects= summaryPageObjects;
	        this.summaryFrom=summaryFrom;
	        this.summaryCardAddress=summaryCardAddress;
	        this.summaryTo=summaryTo;
	        this.summaryShipmentDetails=summaryShipmentDetails;
	        this.summaryCardPackagingDetails= summaryCardPackagingDetails;
	        this.summaryPickUpDropOff= summaryPickUpDropOff;
	        this.summaryPagePickUpDropOff= summaryPagePickUpDropOff;
	        this.summaryPayment= summaryPayment;
	        this.summaryCardPayment =summaryCardPayment;
	        this.summaryAltPickup=summaryAltPickup;
	        this.rateQuotesObjects=rateQuotesObjects;
	        
	    }
	    
	    @And("^User clicks on PickUpDropOffEdit summary card button$")
	    public  void clickOnPickUpDropOffSectionEdit() throws InterruptedException {
			Thread.sleep(3000);
	    	scrollToElement(pickUpAndDropOffObjects.summaryPickupEdit);
	    	clickOnElement(pickUpAndDropOffObjects.summaryPickupEdit);
	        waitForElement(pickUpAndDropOffObjects.pickupDetailscancel);
	    }

	    @Then("^User clicks on PickUp or DropOff cancel Button$")
	    public  void clickOnPickUpCancel() throws InterruptedException {
	    	clickOnElement(pickUpAndDropOffObjects.pickupDetailscancel);
	    }
	    
	    @Then("User clicks on payment cancel button")
	    public void clickOnPaymentCancel() throws InterruptedException {
	    	clickOnElement(paymentObjects.billingDetailscancel);
	    }
	    
	    @When("^User clicks on FromEdit summary card button$")
	    public void clickOnFromAddressSectionEdit() throws InterruptedException {
	    	waitForElementToBeClickable(addressEntryObjects.summaryFromedit);
	    	scrollToElement(addressEntryObjects.summaryFromedit);
	    	clickOnElement(addressEntryObjects.summaryFromedit);
			waitForElementToBeClickable(addressEntryObjects.fromAddresscancel);
	    }
	    
	    @Then("^User:\"([^\"]*)\" fills in From section$")
	    public void toFormClick(String userName) throws Exception {
			addressEntryObjects.fromSectionFill(userName);
	    }
	    
	    @When("^Store From Details to verify in summary Page$")
	    public void storeFromDetails() {
	        waitForElement(addressEntryObjects.fromfieldHeader);
	        summaryPageObjects.summaryFromExpectedData = summaryFrom.storeDesktopFromDetails();
	    }
	    
	    @Then("^Validate Summary Page To address data VS User entered Data in respective Section$")
	    public  void validateToAddressSection() {
	    	summaryCardAddress.validateToAddressSection();
	        
	    }
	    
	    @Then("^Validate Summary Page From address data VS User entered Data in respective Section$")
	    public  void validateFromAddressSection() {
	    	summaryCardAddress.validateFromAddressSection();
	    }
	    
	    @When("^Store To Details to verify in summary Page$")
	    public  void storeToDetails() {
	    	summaryPageObjects.summaryToExpectedData = summaryTo.storeDesktopToDetails();
	    }
	    
	    @When("^Store Document Shipment details to verify in summary Page$")
	    public  void storeDocumentShipmentDetails() {
	    	summaryPageObjects.summaryShipmentDetailsExpectedData = summaryShipmentDetails.storeDesktopShipmentDetails();
	    }
	    
	    @Then("^Validate Summary Page Shipment Details Data VS User entered Data in respective Section$")
	    public  void validatePackageDetailsSection() {
	    	summaryCardPackagingDetails.validatePackageSection();
	    }
	    
	    @When("^Store PickUp DropOff section details to verify in summary Page$")
	    public  void storePickUpDropOffDetails() {
	    	summaryPageObjects.summaryPickUpDropOffExpectedData = summaryPickUpDropOff.storeDesktopPickupDropOff();
	    }
	    
	    @Then("^Validate Summary Page PickUpDropOff section data VS User selected Data in respective Section$")
	    public  void validatePickUpDropOffSection() {
	    	summaryPagePickUpDropOff.validatePickUpDropOffSection();
	    }
	    
	    @Then("^Validate Summary Payment section data VS User selected Data in respective Section$")
	    public  void validatePaymentServiceSection() {
	    	summaryCardPayment.validatePaymentServiceSection();
	    }
	    
	    @Then("^User clicks on Make Changes Button$")
	    public  void clickOnMakeChanges() throws InterruptedException {
	    	clickOnElement(summaryPageObjects.summaryModalMakechanges);
	    }
	    
	    @Then("^User clicks on To update button$")
	    public  void clickOnToUpdate() {
	        clickOnElementJS(addressEntryObjects.toAddressupdate);
	    }
	    
	    @When("^User clicks on RateServiceEdit summary card button$")
	    public  void clickOnRateServiceSectionEdit() throws InterruptedException {
	    	clickOnElement(summaryPageObjects.summaryDeliveryedit);
	    }
	    
	    @When("^User clicks on AlternateFromAddressEdit summary card button$")
	    public  void clickOnFromAltAddressSectionEdit() throws InterruptedException {
	    	scrollToElement(summaryPageObjects.summaryFromAltOpenedit);
	    	clickOnElement(summaryPageObjects.summaryFromAltOpenedit);
	    }
	    
	    @Then("^User enters Value:\"([^\"]*)\" in Alternative Pickup Postal$")
	    public  void enterTextInAltPostal(String valueToEnter) throws InterruptedException, IOException {
	    	enterValue(addressEntryObjects.alternativePickuppostal, valueToEnter);
	    }
	    
	    @Then("^User enters Value:\"([^\"]*)\" in Alternative Pickup City$")
	    public  void enterTextInAltCity(String valueToEnter) throws InterruptedException, IOException {
	    	addressEntryObjects.alternativePickupcity.clear();
	    	enterValue(addressEntryObjects.alternativePickupcity, valueToEnter);
	    }
	    
	    @When("^Store Alternate Pickup Address Details to verify in summary Page$")
	    public  void storeALtPickupDetails() {
	        waitForElement(addressEntryObjects.alternativePickupAddressheading);
	        summaryPageObjects.summaryAltPickupData = summaryAltPickup.storeDesktopAltPickupDetails();
	    }
	    
	    @Then("^Validate Summary Page Alternate Pickup Address Data VS User entered Data in respective Section$")
	    public  void validateAlternatePickupAddressSection() {
	    	summaryCardAddress.validateAlternatePickupAddressSection();
	    }

	    @Then("^Verify pickup or dropoff page details$")
	    public void verifyPickupOrDropOffPageDetails() {
	    	toVerifyPickupOrDropOffPageDetails(pickUpAndDropOffObjects,rateQuotesObjects);
	    }
	    
	    @Then("^User selects value:\"([^\"]*)\" in Pickup Instruction$")
	    public  void selectPickUpInstruction(String valueToSelect) {
	        selectValueInGivenElement(pickUpAndDropOffObjects.pickUpInstrSelect, valueToSelect);
	    }
	    
	    @Then("^User enters value:\"([^\"]*)\" in Special Instructions$")
	    public   void enterValueInPickUpSpecialInstruction(String valueToEnter) {
	        enterTextInGivenElement(pickUpAndDropOffObjects.pickUpInstrInputFormControl, valueToEnter);
	    }
	    
	    @Then("^Verify Pickup Date localized based on current locale$")
	    public void verifyPickupDate() {
	        toverifyPickupDate(pickUpAndDropOffObjects);
	    }
	    
	    @Then("^Verify Pickup page texts are w.r.t language app is loaded$")
	    public  void altPickUpHeadingAndCB() throws IOException {
	    	toaltPickUpHeadingAndCB(pickUpAndDropOffObjects);
	    }
	    
	    @Then("^Verify Pickup cutOff instruction message wrt current locale$")
	    public  void verifyPickupCutOffInlineErrorModal() {
	    	toverifyPickupCutOffInlineErrorModal(rateQuotesObjects);
	    }

}
