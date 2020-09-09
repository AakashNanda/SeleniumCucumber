package com.fedex.test.shipping.cucumberSteps;


import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.fedex.test.shipping.ObjectsRepository.SummaryModalWindowObjects;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryFrom;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPackaging;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPayment;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPickUpDropOff;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryRateService;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryTo;

import cucumber.api.java.en.Then;

public class SummaryofShipmentConfirmationModal_Steps extends SeleniumReusableMethods {
	
	 public SummaryModalWindowObjects summaryModalWindowObjects;
	 public SummaryPageObjects summaryPageObjects;
	 
	 public SummaryofShipmentConfirmationModal_Steps(SharedDriverManager driver,
			 SummaryModalWindowObjects summaryModalWindowObjects,
			 SummaryPageObjects summaryPageObjects) {
		 this.summaryModalWindowObjects=summaryModalWindowObjects;
		 this.summaryPageObjects=summaryPageObjects;
	 } 
	
	
	@Then("^User clicks on Recipient Address Details Button$")
    public  void clickOnRecipientAddressDetails() throws InterruptedException {
        clickOnElement(summaryModalWindowObjects.addressDetailsto);
    }
	
	  @Then("^Verify Recipient Address Details on summary modal window vs stored data from Recipient address Details$")
	    public  void validateSummaryModalWindowRecipientAddressDetails() throws Exception {
	       tovalidateSummaryModalWindowRecipientAddressDetails(summaryModalWindowObjects);
	    }
	  
	  @Then("^User clicks on Sender Address Details Button$")
	    public  void clickOnSenderAddressDetails() throws InterruptedException {
		  clickOnElement(summaryModalWindowObjects.addressDetailsfrom);
	    }
	  
	  @Then("^Verify Sender Address Details on summary modal window vs stored data from Sender address Details$")
	    public  void validateSummaryModalWindowSenderAddressDetails() throws Exception {
	       toValidateSummaryModalWindowSenderAddressDetails(summaryModalWindowObjects);
	    }
	  
	  @Then("^User clicks on Close icon in summary window$")
	    public  void clickOnCloseIcon() throws InterruptedException {
		  clickOnElement(summaryModalWindowObjects.summaryModalCloseicon);
	    }
	  
	  @Then("^Verify PriceBreakDown Details$")
	    public  void validatePriceBreakDownSection() throws JSONException, IOException, Exception {
		  toValidatePriceBreakDownSection(summaryPageObjects);
	    }

	  @Then("^Verify Sender Address Name and Company on summary modal window vs stored data from Sender address section$")
	    public  void validateSummaryModalWindowFromAddressSection() throws Exception {
	        toValidateSummaryModalWindowFromAddressSection(summaryPageObjects,summaryModalWindowObjects);
	    }
	  
	  @Then("^Verify Recipient Address Name and Company on summary modal window vs stored data from Recipient address section$")
	    public  void validateSummaryModalWindowTOAddressSection() throws Exception {
		  toValidateSummaryModalWindowTOAddressSection(summaryPageObjects,summaryModalWindowObjects);
	    }
	  
	  @Then("^Verify Delivery details on summary modal window vs stored data from Delivery section$")
	    public  void validateSummaryModalWindowDeliverySection() {
	        tovalidateSummaryModalWindowDeliverySection(summaryPageObjects);

	    }
	  
	  @Then("^Verify Package details on summary modal window vs stored data from package along with item section$")
	    public  void validateSummaryModalWindowPackageSection() {
		  toValidateSummaryModalWindowPackageSection(summaryPageObjects);
	    }
	  
	  @Then("^Verify Payment details on summary modal window vs stored data from Payment section$")
	    public  void validateSummaryModalWindowPaymentSection() {
		  tovalidateSummaryModalWindowPaymentSection(summaryPageObjects);
	    }
	  
	  @Then("^Verify Legal message text is w.r.t language app is loaded$")
	    public  void verifyFromFieldLabels() throws JSONException, IOException, Exception {
		  toVerifyFromFieldLabels(summaryModalWindowObjects);
	    }
}
