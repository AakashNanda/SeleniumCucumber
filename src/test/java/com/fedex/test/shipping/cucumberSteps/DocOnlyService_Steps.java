package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.DocOnlyServiceObjects;
import com.fedex.test.shipping.ObjectsRepository.RateQuotesObjects;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryRateService;
import com.fedex.test.shipping.SummaryCardValidate.SummaryCardRateServiceDetails;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
    public class DocOnlyService_Steps extends SeleniumReusableMethods {

    public RateQuotesObjects rateQuotesObjects;
    public SummaryPageObjects summaryPageObjects;
    public DocOnlyServiceObjects docOnlyServiceObjects;
    public SummaryRateService summaryRateService;
    public SummaryCardRateServiceDetails summaryCardRateServiceDetails;

    public DocOnlyService_Steps(SharedDriverManager driver,DocOnlyServiceObjects docOnlyServiceObjects, SummaryPageObjects summaryPageObjects,
                                RateQuotesObjects rateQuotesObjects, SummaryRateService summaryRateService, SummaryCardRateServiceDetails summaryCardRateServiceDetails) {
            this.docOnlyServiceObjects=docOnlyServiceObjects;
            this.rateQuotesObjects=rateQuotesObjects;
            this.summaryPageObjects=summaryPageObjects;
            this.summaryRateService=summaryRateService;
            this.summaryCardRateServiceDetails=summaryCardRateServiceDetails;
            this.summaryPageObjects=summaryPageObjects;
    }


    @Then("^Verify ShipDate localized based on current locale$")
    public void verifyShipmentDate() throws Exception {
        waitForElement(rateQuotesObjects.rateServicesButton);
        verify_Shipment_Date(rateQuotesObjects.rateServicesButton,rateQuotesObjects.shipDateId);
    }
    @Then("^Verify RateQuote page texts are w.r.t language app is loaded$")
    public void altPickUpHeadingAndCB()  throws Exception{
        waitForElement(rateQuotesObjects.rateTableheading);
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            getTextFromAndCompareTextWithUI(rateQuotesObjects.rateTableheading, getRatingSectionComponentData("pageTitle"));
            getLabelTextAndCompare(rateQuotesObjects.shipDateId, getRatingSectionComponentData("shipDate"));
            getTextFromAndCompareTextWithUI(docOnlyServiceObjects.servicedisclaimer, getRatingSectionComponentData("rateDisclaimer"));
        } else {
            getTextFromAndCompareTextWithUIMobile(rateQuotesObjects.rateTableHeading, getRatingSectionComponentData("pageTitle"));
            getTextFromAndCompareTextWithUIMobile(docOnlyServiceObjects.serviceDisclaimer, getRatingSectionComponentData("rateDisclaimer"));
        }
    }

    @When("^Store Rate Service section details to verify in summary Page$")
    public void storeDeliveryServiceDetails() throws Exception {
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            summaryPageObjects.summaryDeliveryExpectedData = summaryRateService.storeDesktopRateServiceDetails();
        }
        else{
            summaryPageObjects.summaryDeliveryExpectedDataMobile=summaryRateService.storeMobileRateServiceDetails();
        }
    }

    @Then("^Validate Summary Page Rate Service section data VS User selected Data in respective Section$")
    public void validateRateServiceSection() throws Exception {
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            summaryCardRateServiceDetails.validateRateServiceSection();
        }
        else{
            summaryCardRateServiceDetails.validateRateServiceSectionMobile();
        }

    }

    @Then("^User Selects Value:\"([^\"]*)\" Shipment Quantity Unit$")
    public void selectTextInShipmentPieces(String valueToSelect) {
        selectValueInGivenElement(docOnlyServiceObjects.shipmentpieces, valueToSelect);
    }

    @Then("^Verify ShipDate list should be only two days$")
    public void verifyShipDate_ShouldBeOnlyTwoDays() throws InterruptedException {
        verifyShipDate_TwoDays(rateQuotesObjects.shipDateId);
    }

    @Then("^Verify Signature Service label w.r.t language app is loaded$")
    public void verifySignatureOption() {
        verifySignatureServiceOption(rateQuotesObjects.Signatureoptions);
    }

    @Then("^User selects shipDate as tomorrow$")
    public void verifyShipDate_Tomorrow() throws InterruptedException {
        verifyShipDate("1",rateQuotesObjects.shipDateId,docOnlyServiceObjects.amountsshown);
    }

    @Then("^User selects shipDate as today$")
    public void verifyShipDate_Today() throws InterruptedException {
        verifyShipDate("0",rateQuotesObjects.shipDateId,docOnlyServiceObjects.amountsshown);
    }

    @Then("^Verify Summary Service details text is w.r.t language app is loaded$")
    public void verifySummaryServiceSection() throws Exception {
        getTextFromAndCompareTextWithUI(docOnlyServiceObjects.summaryDeliveryheading, getSummaryDeliveryComponentData("delivery"));
        getTextFromAndCompareTextWithUI(docOnlyServiceObjects.summaryDeliveryedit, getSummaryComponentData("summaryEdit"));
    }


    
}