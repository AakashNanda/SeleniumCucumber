package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class PaymentObjects extends LoadableComponent<PaymentObjects> {

    public final static String paymentsubmit = "reviewSummary";
    public final static String transportationheading ="transportHeading";
    public final static String billTransportationto ="billTransport";
    public final static String fedexAccountNumberBilltransport ="fedexAccountNumberBillTransport";
    public final static String Reference = "reference";
    public final static String referenceASCIIerror="referenceASCIIError";
    public final static String toolTipduties = "toolTipDuties";
    public final static String billDutiestaxes = "billDutiesTaxes";
    public final static String fedexAccountnumber = "fedexAccountNumber";
    //public final static String isTransportationAccounterror ="isTransportationAccountError";
    public final static String isTransportationAccounterror ="//span[@id='isTransportationAccountError']";
    public final static String isDutiesAccounterror = "isDutiesAccountError";
    public final static String fedexAccountNumberBillduties ="fedexAccountNumber";
    public final static String ponumber = "poreference";
    public final static String invoicenumber = "invoicereference";
    public final static String deparmentnumber = "departmentreference";
    public final static String poReferenceerror = "poreferenceerror";
    public final static String invoiceReferenceerror = "invoicereferenceerror";
    public final static String deptReferenceerror = "departmentreferenceerror";
    public final static String summaryPoreference = "summaryPoReference";
    public final static String summaryInvoicereference = "summaryInvoiceReference";
    public final static String summaryDepartmentreference = "summaryDepartmentReference";
    public final static String summaryPriceBreakdownreference = "summaryPriceBreakdownReference";
    public final static String summaryPriceBreakdownPoreference = "summaryPriceBreakdownPoReference";
    public final static String summaryPriceBreakdownInvoicereference = "summaryPriceBreakdownInvoiceReference";
    public final static String summaryPriceBreakdownDepartmentreference = "summaryPriceBreakdownDepartmentReference";
    public final static String recepienttaxId = "recipientTaxId0";
    public final static String sendertaxId = "senderTaxId0";
    public final static String recipientTaxIdTooltip = "recipientTaxIdToolTip0";
    public final static String senderTaxIdTooltip = "senderTaxIdToolTip";
    public final static String summaryBillingTaxid = "summaryBillingTaxId";
    public final static String summaryTaxsender = "summaryTaxSender";
    public final static String summaryTaxrecipient = "summaryTaxRecipient";
    public final static String billingDetailsupdate = "reviewSummary";
    public final static String billingDetailsCancel = "billingDetailsCancel";
    public final static String recipientTaxiderror = "recipientTaxId0error";
    public final static String senderTaxiderror = "senderTaxId0error";
    public final static String rateMasktext = "//*[@id='summaryPriceBreakdownComponent']/li[1]/div/div[2]/span[2]";
    public final static String summaryPaymentedit= "summaryPaymentEdit";

    @FindBy(id = paymentsubmit)
    public WebElement paymentSubmit;

    @FindBy(id = transportationheading)
    public WebElement transportationHeading;

    @FindBy(id = billTransportationto)
    public WebElement billTransportationTo;

    @FindBy(id = fedexAccountNumberBilltransport)
    public WebElement fedexAccountNumberBillTransport;

    @FindBy(id = Reference)
    public WebElement reference;

    @FindBy(id = referenceASCIIerror)
    public WebElement referenceASCIIError;

    @FindBy(id = billingDetailsupdate)
    public  WebElement billingDetailsUpdate;

    @FindBy(id = billingDetailsCancel)
    public WebElement billingDetailscancel;

    @FindBy(id = toolTipduties)
    public  WebElement toolTipDuties;

    @FindBy(id = billDutiestaxes)
    public  WebElement billDutiesTaxes;

    @FindBy(id = fedexAccountnumber)
    public  WebElement fedexAccountNumber;

    @FindBy(xpath = isTransportationAccounterror)
    public  WebElement isTransportationAccountError;

    @FindBy(id = isDutiesAccounterror)
    public WebElement isDutiesAccountError;


    @FindBy(id = fedexAccountNumberBillduties)
    public WebElement fedexAccountNumberBillDuties;

    @FindBy(id = ponumber)
    public  WebElement poNumber;

    @FindBy(id = invoicenumber)
    public  WebElement invoiceNumber;

    @FindBy(id = deparmentnumber)
    public  WebElement deparmentNumber;

    @FindBy(id = poReferenceerror)
    public WebElement poReferenceError;

    @FindBy(id = invoiceReferenceerror)
    public  WebElement invoiceReferenceError;

    @FindBy(id = deptReferenceerror)
    public  WebElement deptReferenceError;

    @FindBy(id = summaryPoreference)
    public WebElement summaryPoReference;

    @FindBy(id = summaryInvoicereference)
    public WebElement summaryInvoiceReference;

    @FindBy(id = summaryDepartmentreference)
    public  WebElement summaryDepartmentReference;

    @FindBy(id = summaryPriceBreakdownreference)
    public WebElement summaryPriceBreakdownReference;

    @FindBy(id = summaryPriceBreakdownPoreference)
    public WebElement summaryPriceBreakdownPoReference;

    @FindBy(id = summaryPriceBreakdownInvoicereference)
    public WebElement summaryPriceBreakdownInvoiceReference;

    @FindBy(id = summaryPriceBreakdownDepartmentreference)
    public WebElement summaryPriceBreakdownDepartmentReference;

    @FindBy(id = recepienttaxId)
    public WebElement recepientTaxId;

    @FindBy(id = sendertaxId)
    public WebElement senderTaxId;

    @FindBy(id = recipientTaxIdTooltip)
    public WebElement recipientTaxIdToolTip;

    @FindBy(id = senderTaxIdTooltip)
    public WebElement senderTaxIdToolTip;

    @FindBy(id = summaryBillingTaxid)
    public WebElement summaryBillingTaxId;


    @FindBy(id = summaryTaxsender)
    public WebElement summaryTaxSender;

    @FindBy(id = summaryTaxrecipient)
    public WebElement summaryTaxRecipient;

    @FindBy(id = recipientTaxiderror)
    public  WebElement recipientTaxIderror;

    @FindBy(id = senderTaxiderror)
    public  WebElement senderTaxIderror;

    @FindBy(xpath = rateMasktext)
    public  WebElement rateMaskText;

    @FindBy(id = summaryPaymentedit)
    public WebElement summaryPaymentEdit;

    public PaymentObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }



    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
