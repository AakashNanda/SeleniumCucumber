package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPayment;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.IOException;

public class PaymentGroup_Steps extends SeleniumReusableMethods {


    public HomePageObjects homePageObjects;
    public AddressEntryObjects addressEntryObjects;
    public PaymentObjects paymentObjects;
    public SummaryPageObjects summaryPageObjects;
    public SummaryPayment summaryPayment;

    public PaymentGroup_Steps(SharedDriverManager driver, HomePageObjects homePageObjects, AddressEntryObjects addressEntryObjects, PaymentObjects paymentObjects,SummaryPageObjects summaryPageObjects,
         SummaryPayment summaryPayment) throws IOException {
        this.homePageObjects = homePageObjects;
        this.addressEntryObjects = addressEntryObjects;
        this.paymentObjects=paymentObjects;
        this.summaryPageObjects=summaryPageObjects;
        this.summaryPayment=summaryPayment;
    }

    @Then("^User Enter Value:\"([^\"]*)\" Payment reference$")
    public  void enterTextInPaymentReference(String valueToEnter) throws IOException,InterruptedException {
        enterValue(paymentObjects.reference, valueToEnter);
    }

    @Then("^User Selects Value:\"([^\"]*)\" in Bill Duties and Taxes$")
    public  void selectOptionInBillDutiesAndTaxes(String valueToSelect) {
        selectValueInGivenElement(paymentObjects.billDutiesTaxes, valueToSelect);
    }

    @When("^Store Payment section details to verify in summary Page$")
    public  void storePaymentDetails() {
        summaryPageObjects.summaryPaymentExpectedData = summaryPayment.storeDesktopPaymentServiceDetails();
    }

    @When("^User clicks on PaymentEdit summary card button$")
    public  void clickOnPickUpDropOffSectionEdit() throws InterruptedException  {
        clickOnElement(paymentObjects.summaryPaymentEdit);
        waitForElement(paymentObjects.billingDetailsUpdate);
    }

    @Then("^User Enter Value:\"([^\"]*)\" FedEx duties account Number$")
    public  void enterTextFedExDutiesAccountNumber(String valueToEnter) throws IOException ,InterruptedException{
        enterValue(paymentObjects.fedexAccountNumberBillDuties, valueToEnter);
    }


    @Then("^User Enter Value:\"([^\"]*)\" in P.O.No$")
    public  void enterTextInPONumber(String valueToEnter) throws NullPointerException,IOException,InterruptedException{
        enterValue(paymentObjects.poNumber, valueToEnter);
    }

    @Then("^User Enter Value:\"([^\"]*)\" in Invoice No$")
    public  void enterTextInInvoiceNumber(String valueToEnter) throws IOException,InterruptedException {
        enterValue(paymentObjects.invoiceNumber, valueToEnter);
    }

    @Then("^User Enter Value:\"([^\"]*)\" in DeptNo$")
    public  void enterTextInDeptNumber(String valueToEnter) throws IOException,InterruptedException {
        enterValue(paymentObjects.deparmentNumber, valueToEnter);
        waitForElement(paymentObjects.deparmentNumber);
    }

    @Then("^User Enter Value:\"([^\"]*)\" Recepient TaxId Field$")
    public void enterTextInRecepientTaxIdField(String valueToEnter) throws IOException,InterruptedException {
        enterValue(paymentObjects.recepientTaxId, valueToEnter);
    }

    @Then("^User Enter Value:\"([^\"]*)\" Sender TaxId Field$")
    public  void enterTextInSenderTaxIdField(String valueToEnter)throws IOException,InterruptedException {
        enterValue(paymentObjects.senderTaxId, valueToEnter);
    }

    @Then("User clicks on payment summary edit button")
    public  void clickOnPaymentEditButton() throws InterruptedException {
        clickOnElement(paymentObjects.summaryPaymentEdit);
    }

}
