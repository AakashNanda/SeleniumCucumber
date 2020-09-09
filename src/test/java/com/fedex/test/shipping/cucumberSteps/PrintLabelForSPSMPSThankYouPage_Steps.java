package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.*;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPayment;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;

public class PrintLabelForSPSMPSThankYouPage_Steps  extends SeleniumReusableMethods {


    public ThankYouPageObjects thankYouPageObjects;
    public ThankYouPage_Steps  thankYouPage_Steps;
    public CommercialInvoiceObjects commercialInvoiceObjects;

    public PrintLabelForSPSMPSThankYouPage_Steps (SharedDriverManager driver, ThankYouPageObjects thankYouPageObjects,
                                                  ThankYouPage_Steps thankYouPage_Steps,
                                                   CommercialInvoiceObjects commercialInvoiceObjects) throws IOException {
       this.thankYouPageObjects=thankYouPageObjects;
       this.thankYouPage_Steps=thankYouPage_Steps;
       this.commercialInvoiceObjects=commercialInvoiceObjects;

    }




    @Then("^Verify Thank You page PickUp Confirmation texts are w.r.t language app is loaded$")
    public  void thankYouPagePickUpConfirmationSection() throws Exception {
        waitForElement(thankYouPageObjects.confirmationHeader);
        getTextFromAndCompareTextWithUI(thankYouPageObjects.pickupOrDropOffText, getConfirmationSectionPickUpDropOffComponentData("pickupOrDropOffText"));
    }

    @Then("^Verify Thank You page PickUp Confirmation Number texts are w.r.t language app is loaded$")
    public  void thankYouPagePickUpConfirmationNumberTextLanguage() throws Exception{
        waitForElement(thankYouPageObjects.confirmationHeader);
        getTextFromAndCompareTextWithUI(thankYouPageObjects.pickupConfirmationTrackSectionHeading,getConfirmationSectionComponentData("pickupConfirmationTitle"));
    }

    @Then("^Verify Thank You page DropOff Confirmation texts are w.r.t language app is loaded$")
    public  void thankYouPageDropOffConfirmationSection() throws Exception {
         waitForElement(thankYouPageObjects.confirmationHeader);
        getTextFromAndCompareTextWithUI(thankYouPageObjects.dropOffText, getConfirmationSectionPickUpDropOffComponentData("dropOffText"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.dropOffTextDec, getConfirmationSectionPickUpDropOffComponentData("dropOffTextDec"));
    }

    @Then("^Verify Thank You page Already Schedule PickUp Confirmation texts are w.r.t language app is loaded$")
    public void thankYouPageAlreadySchedulePickupConfirmationSection() throws Exception {
        waitForElement(thankYouPageObjects.confirmationHeader);
        getTextFromAndCompareTextWithUI(thankYouPageObjects.alreadySchedulePickUpText, getConfirmationSectionPickUpDropOffComponentData("alreadySchedulePickUpText"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.alreadyScheduleTextPickUpDec, getConfirmationSectionPickUpDropOffComponentData("alreadyScheduleTextPickUpDec"));
    }

    @Then("^Verify whether user navigates to new tab when clicks on Print Documents button when label:\"([^\"]*)\" and invoice:\"([^\"]*)\"$")
    public  void userClicksOnPrintDocumentLabelVerifyOpensNewTab(String labelFlag, String invoiceFlag) {
        toUserClicksOnPrintDocumentLabelVerifyOpensNewTab(labelFlag, invoiceFlag,thankYouPageObjects,thankYouPage_Steps);

    }

    @Then("^User Enter Value:\"([^\"]*)\" Additional Invoice Info one$")
    public void enterTextInAdditionalInvoiceInfoOne(String valueToEnter) throws IOException, InterruptedException {
        enterValue(commercialInvoiceObjects.additionalInvoiceInfoOne,valueToEnter);
    }

    @Then("^User Enter Value:\"([^\"]*)\" Additional Invoice Info two$")
    public void enterTextInAdditionalInvoiceInfoTwo(String valueToEnter) throws IOException, InterruptedException {
        enterValue(commercialInvoiceObjects.additionalInvoiceInfoTwo,valueToEnter);
    }


    @Then("^Verify whether user navigates to new tab when clicks on Print Documents button when label:\"([^\"]*)\"")
    public void verify_whether_user_navigates_to_new_tab_when_clicks_on_Print_Documents_button_when_label(String labelFlag) {
    	UserClicksOnPrintDocumentLabelVerifyOpensNewTab(labelFlag,thankYouPage_Steps,thankYouPageObjects);

    }

    @Then("^Verify Thank You page texts are w.r.t language app is loaded$")
    public  void thankYouPageTextLanguage()throws Exception {
        waitForElement(thankYouPageObjects.confirmationHeader);
        toThankYouPageTextLanguage(thankYouPageObjects);
        }

    @Then("^Verify Download PDF link below Label and invoice$")
     public  void downloadLabelLink() {
       toDownloadLabelLink(thankYouPageObjects);

    }

    @Then("^User selects Yes Pro Forma Invoice radio button$")
    public void yesProForma() throws InterruptedException, IOException {
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            waitForElement(commercialInvoiceObjects.commercialYesProRadio);
            clickOnElementJS(commercialInvoiceObjects.commercialYesProRadio);
        } else {
            waitForElement(commercialInvoiceObjects.commercialYesProRadio);
            clickOnElementJS(commercialInvoiceObjects.commercialYesProRadio);
        }
    }

    @Then("^User selects Yes Commercial Invoice radio button$")
    public void yesCommerical() throws InterruptedException, IOException {

        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            waitForElement(commercialInvoiceObjects.commercialYesRadioButton);
            clickOnElement(commercialInvoiceObjects.commercialYesRadioButton);
        } else {
            waitForElement(commercialInvoiceObjects.commercialYesRadioButton);
            clickOnElement(commercialInvoiceObjects.commercialYesRadioButton);
        }
    }

    @Then("^User selects value:\"([^\"]*)\" in terms of sale$")
    public  void termsOfSale(String valueToSelect) {
        selectValueInGivenElement(commercialInvoiceObjects.termsOfSale, valueToSelect);
    }
}

