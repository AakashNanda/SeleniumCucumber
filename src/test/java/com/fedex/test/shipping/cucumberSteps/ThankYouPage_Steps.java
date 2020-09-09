package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.HomePageObjects;
import com.fedex.test.shipping.ObjectsRepository.ThankYouPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import cucumber.api.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.io.IOException;

public class ThankYouPage_Steps extends SeleniumReusableMethods {

    public ThankYouPageObjects thankYouPageObjects;
    public HomePageObjects homePageObjects;


    public ThankYouPage_Steps(SharedDriverManager driver, ThankYouPageObjects thankYouPageObjects,HomePageObjects homePageObjects) {
        this.thankYouPageObjects = thankYouPageObjects;
        this.homePageObjects = homePageObjects;

    }


    @Then("^Verify Invoice section is displayed w.r.t selected option:\"([^\"]*)\"$")
    public void verifyInvoiceSection(String invoiceType) {
        waitForElement(thankYouPageObjects.confirmationPrintSectionSubHeading);
        verifyInvoiceSection(invoiceType, thankYouPageObjects.printInvoiceDescText, thankYouPageObjects.printInvoiceCheckboxLabel);
    }

    @Then("^User Selects Print Label Checkbox:\"([^\"]*)\"$")
    public void selectPrintLabelCheckBoxSelection(String flag) {
        checkBoxSelect(flag, thankYouPageObjects.printLabelCheckboxLabel.get(0));
    }

    @Then("^User Selects Print Invoice Checkbox:\"([^\"]*)\"$")
    public void selectPrintInvoiceCheckBoxSelection(String flag) {
        checkBoxSelect(flag, thankYouPageObjects.printInvoiceCheckboxLabel.get(0));
    }

    @Then("^User clicks on Print Document button$")
    public void clickOnPrintLabel() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if ( elementisDisplayedAndEnabled(thankYouPageObjects.CloseButtonpopup)) {
                clickOnElement(thankYouPageObjects.CloseButton);
                clickOnElement(thankYouPageObjects.printDocumentsButton);
            } else {
                waitForElement(thankYouPageObjects.printDocumentsButton);
                clickOnElement(thankYouPageObjects.printDocumentsButton);
            }
        } catch (NoSuchElementException e) {
            clickOnElement(thankYouPageObjects.printDocumentsButton);
        }
    }


    @Then("^Verify Pickup failure inline error modal$")
    public  void verifyShipmentFailureInlineErrorModal() throws Exception {
        toverifyShipmentFailureInlineErrorModal(thankYouPageObjects,homePageObjects);
    }
}

