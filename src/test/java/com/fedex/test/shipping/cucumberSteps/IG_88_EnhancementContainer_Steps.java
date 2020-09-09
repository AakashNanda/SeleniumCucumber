package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;



@SuppressWarnings("deprecation")

public class IG_88_EnhancementContainer_Steps extends SeleniumReusableMethods {

    public PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects;
    public PickUpAndDropOffObjects pickUpAndDropOffObjects;
    public RateQuotesObjects rateQuotesObjects;
    public PaymentObjects paymentObjects;
    public SummaryPageObjects summaryPageObjects;
    public ThankYouPageObjects thankYouPageObjects;

	public IG_88_EnhancementContainer_Steps(SharedDriverManager driver,PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects,RateQuotesObjects rateQuotesObjects,
                                            PickUpAndDropOffObjects pickUpAndDropOffObjects, PaymentObjects paymentObjects, SummaryPageObjects summaryPageObjects,
                                            ThankYouPageObjects thankYouPageObjects) {

        this.packagingAndShipmentDetailsObjects=packagingAndShipmentDetailsObjects;
        this.rateQuotesObjects=rateQuotesObjects;
        this.pickUpAndDropOffObjects=pickUpAndDropOffObjects;
        this.paymentObjects=paymentObjects;
        this.summaryPageObjects=summaryPageObjects;
        this.thankYouPageObjects=thankYouPageObjects;
	}



    
    @Then("User clicks on Shipment Continue Button")
    public void clicksOnShipmentContinueButton() throws InterruptedException {
	    waitForElement(packagingAndShipmentDetailsObjects.shipmentContinue);
	    scrollToElement(packagingAndShipmentDetailsObjects.shipmentContinue);
    	clickOnElement(packagingAndShipmentDetailsObjects.shipmentContinue);
    	Thread.sleep(3000);
        reClickOnElement(packagingAndShipmentDetailsObjects.shipmentContinue);
    }

    @Then("User clicks on Shipment Continue Button to continue")
    public void clicksOnShipmentContinueButtonTocontinue() throws InterruptedException {
        waitForElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        scrollToElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        clickOnElement(packagingAndShipmentDetailsObjects.shipmentContinue);

    }

    @Then("^User clicks on rate Button$")
    public void User_clicks_on_rate_Button() {
    	rateQuotesObjects.clickOnRatesButton();
    }

    
    @Then("^User clicks on Finalize Shipment Button$")
    public void clickOnFinalizeShipment() throws InterruptedException {
        waitForElement(summaryPageObjects.summaryModalFinalizeShipmentButton);
	    scrollToElement(summaryPageObjects.summaryModalFinalizeShipmentButton);
	    clickOnElement(summaryPageObjects.summaryModalFinalizeShipmentButton);
    }
    
    @Then("^User clicks on Continue to summary modal Button$")
    public void clickOnContinueToShipment() throws InterruptedException {
         Thread.sleep(3000);
	    waitForElement(summaryPageObjects.summarySubmit);
        scrollToElement(summaryPageObjects.summarySubmit);
        clickOnElement(summaryPageObjects.summarySubmit);
//        reClickOnElement(summaryPageObjects.summarySubmit);
    }

    @Then("User clicks on payment submit button")
    public void clickOnPaymentSubmit() throws InterruptedException {
//        Thread.sleep(3000);
        waitForElement(paymentObjects.paymentSubmit);
//	    scrollToElement(paymentObjects.paymentSubmit);
        clickOnElement(paymentObjects.paymentSubmit);
//        reClickOnElement(paymentObjects.paymentSubmit);
    }

    
    @Then("^Verify whether application launches to \"([^\"]*)\" URL$")
    public void verifyTermsUrl(String terms) {
    	verifyTermsurl(terms);
    }
    
    @Then("^User clicks on \"([^\"]*)\" link$")
    public void clickOnTermsLink(String terms) throws InterruptedException {
        clickonTermslink(terms,summaryPageObjects.termsOfuse,summaryPageObjects.termsAndconditions);
    }

    @Then("^User clicks on intraEU terms of use link in legal message$")
    public void clickOnIntraEuTemsOfUse() throws InterruptedException {
        clickOnElement(summaryPageObjects.intraEuTermsOfuse);
    }

    @Then("^User clicks on intraEU conditions of carriage link in legal message$")
    public void clickOnIntraEuConditionsCarriage() throws InterruptedException {
        clickOnElement(summaryPageObjects.intraEuConditionsOfCarriages);
    }
    
    @When("^User selects value:\"([^\"]*)\" in Pickup or DropOff Options$")
    public void selectPicUpOrDropOff(String valueToSelect) throws InterruptedException {
	    waitForElement(pickUpAndDropOffObjects.pickUpDropOffSelection);
    	selectValuebyValue(pickUpAndDropOffObjects.pickUpDropOffSelection,valueToSelect);
    }

    
    @Then("^User Enter Value:\"([^\"]*)\" in Document Customs Value$")
    public void enterTextInCustomsValue(String valueToEnter) throws IOException, InterruptedException {
        enterValue(packagingAndShipmentDetailsObjects.documentCustomsValue, valueToEnter);
    }
    
    @Then("^User clicks on Create another shipment button$")
    public void clickOnCreateAnotherShipment() throws InterruptedException {
    	clickOnElement(thankYouPageObjects.createAnothershipmentButton);
    }
    
}
