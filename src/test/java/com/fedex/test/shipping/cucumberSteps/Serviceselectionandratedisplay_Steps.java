package com.fedex.test.shipping.cucumberSteps;

import java.io.IOException;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.PickUpAndDropOffObjects;
import com.fedex.test.shipping.ObjectsRepository.RateQuotesObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;

import cucumber.api.java.en.Then;

public class Serviceselectionandratedisplay_Steps extends SeleniumReusableMethods{
	
	public RateQuotesObjects rateQuotesObjects;
	 
    public Serviceselectionandratedisplay_Steps(SharedDriverManager driver, RateQuotesObjects rateQuotesObjects) throws IOException {
        this.rateQuotesObjects=rateQuotesObjects;
    }
    
    @Then("^User Selects Signature services Checkbox:\"([^\"]*)\"$")
    public  void selectPrintLabelCheckBoxSelection(String flag) {
    	checkBoxSelect(flag,rateQuotesObjects.Signatureoptions);
    }

    @Then("^User selects directSignatureRequired signature option$")
    public  void directSignatureRequiredSignatureOption() throws InterruptedException {
        clickOnElement(rateQuotesObjects.directSignaturerequired);
    }
    
    @Then("^Verify Signature Service is listed in rate breakdown$")
    public  void verifySignatureOptionListedRateBreakdown() {
    	toVerifySignatureOptionListedRateBreakdown(rateQuotesObjects);

    }
}
