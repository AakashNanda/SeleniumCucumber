package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.DriverFactory;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
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
import java.util.List;

@SuppressWarnings("deprecation")
public class NonDocGroup_Steps extends SeleniumReusableMethods {

    public PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects;
    public RateQuotesObjects rateQuotesObjects;
    public PickUpAndDropOffObjects pickUpAndDropOffObjects;
    public PaymentObjects paymentObjects;
    public SummaryCardObjectsPackagingDetails summaryCardObjectsPackagingDetails;
    public ShipmentDetailsNonDocObjects shipmentDetailsNonDocObjects;

    public NonDocGroup_Steps(SharedDriverManager driver, PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects,
                             RateQuotesObjects rateQuotesObjects,
                             PickUpAndDropOffObjects pickUpAndDropOffObjects, PaymentObjects paymentObjects,SummaryCardObjectsPackagingDetails summaryCardObjectsPackagingDetails,
                               ShipmentDetailsNonDocObjects shipmentDetailsNonDocObjects  ) {
        this.packagingAndShipmentDetailsObjects=packagingAndShipmentDetailsObjects;
        this.rateQuotesObjects=rateQuotesObjects;
        this.pickUpAndDropOffObjects=pickUpAndDropOffObjects;
        this.paymentObjects=paymentObjects;
        this.summaryCardObjectsPackagingDetails=summaryCardObjectsPackagingDetails;
        this.shipmentDetailsNonDocObjects=shipmentDetailsNonDocObjects;
	}


    @Then("^User Selects Value:\"([^\"]*)\" in Type of Document$")
    public void selectTextInDocumentType(String value) throws IOException, InterruptedException {
        waitForElement(packagingAndShipmentDetailsObjects.shipDocType);
        if(Property.getProp("platform").equalsIgnoreCase("mobile")){
            selectValueByValueMobile("id" , packagingAndShipmentDetailsObjects.docType, value);
        }else{
            selectValuebyValue(packagingAndShipmentDetailsObjects.shipDocType, value);
        }
    }

    @Then("^User Selects FedEx Service as first rate button$")
    public void selectFedExServiceRateButton() {
        rateQuotesObjects.selectFedExServiceRateButton();
    }

    @Then("^User Selects Value:\"([^\"]*)\" in Bill Transportation To$")
    public void selectOptionInBillTransportationTo(String valueToSelect) throws InterruptedException {
        selectValuebyValue(paymentObjects.billTransportationTo, valueToSelect);
    }

    @Then("^User Enter Value:\"([^\"]*)\" FedEx account Number$")
    public void enterTextFedExAccountNumber(String valueToEnter) throws IOException, InterruptedException {
        enterValue(paymentObjects.fedexAccountNumberBillTransport, valueToEnter);
    }

    @Then("^User clicks on PickUp or DropOff Submit Button$")
    public void clickOnPickUpSubmit() throws InterruptedException {
        pickUpAndDropOffObjects.clickOnPickUpSubmit();
    }

    @And("^Verify Weight Unit list is not editable during item shipping$")
    public void weighUnitIsDisabled(){
        FieldIsEnabledOrDisabled(packagingAndShipmentDetailsObjects.itemWeightUnit);
    }

    @And("^Verify Currency list is not editable during item shipping$")
    public void currencyListIdDisabled(){
        FieldIsEnabledOrDisabled(packagingAndShipmentDetailsObjects.itemCustomsCurrency);
    }

    
    @Then("^User Selects Value:\"([^\"]*)\" Shipment Purpose$")
    public void User_selects_shipment_purpose(String value) throws InterruptedException, IOException{
    	if(Property.getProp("platform").equalsIgnoreCase("mobile")){
        	selectValueByValueMobile("id" , packagingAndShipmentDetailsObjects.shipmentPurpose, value);
        }else{
        	selectValuebyValue(packagingAndShipmentDetailsObjects.shipmntPurpose, value);
        	}
    }
    
    @Then("^User clicks on Add Another Item button$")
    public void User_clicks_on_Add_Another_Item() throws InterruptedException {
        scrollToElement(packagingAndShipmentDetailsObjects.addItemButton);
        clickOnElement(packagingAndShipmentDetailsObjects.addItemButton);
        reClickOnElement(packagingAndShipmentDetailsObjects.addItemButton);
    }

    
    @Then("^User clicks on Shipment Items Continue Button$")
    public void User_clicks_shipment_continue_button() throws InterruptedException {
        waitForElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        scrollToElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        clickOnElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        Thread.sleep(3000);
    }

    @When("^User clicks on ShipmentDetailsEdit summary card button$")
    public void clickOnRateServiceSectionEdit() throws InterruptedException {
        //waitForElement(rateQuotesObjects.shipDateId);
        scrollToElement(summaryCardObjectsPackagingDetails.summaryCustomEdit);
        clickOnElement(summaryCardObjectsPackagingDetails.summaryCustomEdit);
        waitForElement(packagingAndShipmentDetailsObjects.shipmentContinue);
    }

    @Then("^User Enter Value:\"([^\"]*)\" in Describe your document$")
    public void enterTextInDescribeYourDocument(String valueToEnter) throws IOException, InterruptedException {
        enterValue(packagingAndShipmentDetailsObjects.otherTypeDocumentDescription, valueToEnter);
        tabOut(packagingAndShipmentDetailsObjects.documentCustomsValue);
    }

    @Then("^User Enters Value:\"([^\"]*)\" Shipment Non Docs Harmonized Code$")
    public void enterTextInHarmonizedCode(String value) throws InterruptedException, IOException{
        waitForElement(shipmentDetailsNonDocObjects.harmonizedCodeinput);
        enterValue(shipmentDetailsNonDocObjects.harmonizedCodeinput, value);
    }

    @Then("^User Selects Country:\"([^\"]*)\" in Country of manufacture$")
    public void selectCountryOfManufacture(String valueToSelect) throws InterruptedException {
        selectValuebyValue(packagingAndShipmentDetailsObjects.shipmentCountryOfManufacture,valueToSelect);
    }

    @Then("^User Enter Value:\"([^\"]*)\" Shipment Weight$")
    public void enterTextInShipmentWeight(String valueToEnter) throws IOException, InterruptedException {
        enterValue(packagingAndShipmentDetailsObjects.shipmentWeight,valueToEnter);
    }

    @Then("^User clicks on Shipment Detail cancel button$")
    public void clickOnToCancel() throws InterruptedException {
        clickOnElement(packagingAndShipmentDetailsObjects.shipmentDetailsCancelButton);
    }

    @Then("^User Enter Value:\"([^\"]*)\" In Items Customs Value$")
    public void enterTextInShipmentItemCustomsValue(String valueToEnter) throws IOException, InterruptedException {
        enterValue(packagingAndShipmentDetailsObjects.shipmentItemCustomsValue,valueToEnter);
    }

    @Then("^Verify value displayed as:\"([^\"]*)\" for element:\"([^\"]*)\" HS code$")
    public void Verify_value_in_Element(String value, String  element) throws InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        waitForElement(shipmentDetailsNonDocObjects.harmonizedCodeinput);
        scrollToElement(shipmentDetailsNonDocObjects.harmonizedCodeinput);
        verifyValueInElement(value, element);
    }

    @Then("^User Enter Value:\"([^\"]*)\" Shipment Quantity$")
    public void enterTextInShipmentQuantity(String valueToEnter) throws IOException, InterruptedException {
        enterValue(packagingAndShipmentDetailsObjects.shipmentQuantity,valueToEnter);
    }
    @Then("^User clicks on item Shipment Details continue button$")
    public void clickOnItemContinue() throws InterruptedException {
        clickOnElement(packagingAndShipmentDetailsObjects.shipmentContinue);
    }
    @Then("^Verify whether \"([^\"]*)\" is displaying below \"([^\"]*)\" field$")
    public void verify_whether_is_displaying_below_field(String error, String field) {
        to_verify_whether_is_displaying_below_field(error,field,shipmentDetailsNonDocObjects);
    }
}