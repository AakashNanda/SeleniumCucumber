package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.DriverFactory;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPackaging;
import com.fedex.test.shipping.SummaryCardValidate.SummaryCardPackagingDetails;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class DocumentTypeMVP_Steps extends SeleniumReusableMethods {

    public PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects;
    public PickUpAndDropOffObjects pickUpAndDropOffObjects;
    public RateQuotesObjects rateQuotesObjects;
    public PaymentObjects paymentObjects;
    public SummaryPageObjects summaryPageObjects;
    public ThankYouPageObjects thankYouPageObjects;
    public SummaryPackaging summaryPackaging;
    public SummaryCardPackagingDetails summaryCardPackagingDetails;
    public DocumentTypeMVP_Steps(SharedDriverManager driver, PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects, RateQuotesObjects rateQuotesObjects,
                                            PickUpAndDropOffObjects pickUpAndDropOffObjects, PaymentObjects paymentObjects, SummaryPageObjects summaryPageObjects,
                                            ThankYouPageObjects thankYouPageObjects, SummaryPackaging summaryPackaging, SummaryCardPackagingDetails summaryCardPackagingDetails) {

        this.packagingAndShipmentDetailsObjects=packagingAndShipmentDetailsObjects;
        this.rateQuotesObjects=rateQuotesObjects;
        this.pickUpAndDropOffObjects=pickUpAndDropOffObjects;
        this.paymentObjects=paymentObjects;
        this.summaryPageObjects=summaryPageObjects;
        this.thankYouPageObjects=thankYouPageObjects;
        this.summaryPackaging=summaryPackaging;
        this.summaryCardPackagingDetails=summaryCardPackagingDetails;
    }

    @Then("^User selects value:\"([^\"]*)\" in Coverage Value Currency$")
    public void selectCoverageDeclaredValueCurrency(String valueToSelect) {
        selectByIndex(packagingAndShipmentDetailsObjects.coverageValueCurrency,valueToSelect);
    }

    @Then("^Store Packaging Details to verify in summary Page$")
    public void storePackageDetails() throws Exception {
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            summaryPageObjects.summaryPackagingExpectedData = summaryPackaging.storeDesktopPackagingDetails();
        }
        else{
            summaryPageObjects.summaryPackagingExpectedDataMobile=summaryPackaging.storeMobilePackagingDetails();
        }
    }

    @Then("^Validate Summary Page Packaging Details Data VS User entered Data in respective Section$")
    public void validatePackageSummaryCard() throws Exception {
        if (Property.getProp("platform").equalsIgnoreCase("desktop")) {
            summaryCardPackagingDetails.validatePackageDetailsSection();
        }
        else{
            summaryCardPackagingDetails.validatePackageDetailsSectionMobile();
        }
    }


    @Then("^Verify currency code is same as selected currency code in Shipment details$")
    public void CurrencySymbolValidation(){
        shipmentDetailsCurrencySymbolIsSameAsShipmentDetails(packagingAndShipmentDetailsObjects.documentCustomsCurrency);
    }

    @Then("^Verify Customs Value Cannot be grater than or equal to carriage value along with translation$")
    public void customsValueGreaterOrThanEqualToCarriageValueLimitsTranslation() {
        customsValueGreaterError(packagingAndShipmentDetailsObjects.documentCustomsValueError);
    }


    @Then("^Verify Type of Document contains all the below options$")
    public void Verify_Type_of_document_contains_all_options(List<String> options) throws IOException, InterruptedException {
        verify_select_options(options, packagingAndShipmentDetailsObjects.shipDocType);
        if(Property.getProp("platform").equalsIgnoreCase("mobile")){
            closekeyboard();
        }
    }

    @Then("^Verify Currency list is not editable during document shipping$")
    public void Verify_currency_list_is_not_displayed(){
        elementisDisplayedAndEnabled(packagingAndShipmentDetailsObjects.documentCurrency);
    }

    @Then("^Verify Document Shipment Error Messages w.r.t language app is loaded$")
    public void Verify_document_shipment_error_message() throws Exception {
        verify_other_document_error_messages(packagingAndShipmentDetailsObjects.describeDocumentError,"descriptionRequired");
        verify_other_document_error_messages_CustomsValError(packagingAndShipmentDetailsObjects.documentCustomsValueError,"customsValueRequired");
    }

    @Then("^Verify Document Shipment Page text w.r.t language app is loaded$")
    public void shipmentDetailsTitleTranslation() throws IOException {
        packagingAndShipmentDetailsObjects.documentShipmentPageDetails();
    }

}