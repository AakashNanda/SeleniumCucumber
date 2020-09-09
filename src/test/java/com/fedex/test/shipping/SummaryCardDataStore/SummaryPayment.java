package com.fedex.test.shipping.SummaryCardDataStore;

import com.fedex.test.shipping.ObjectsRepository.PaymentObjects;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;


public class SummaryPayment {

    private String billToTransportationCost;
    private String billToTransportationCostReference;
    private String billToTransportationCostFedExAccountNumber;
    private String billToDutiesTaxesAndFees;
    private String billToDutiesTaxesAndFeesFedExAccountNumber;


    public String getBillToTransportationCost() {
        return billToTransportationCost;
    }

    public void setBillToTransportationCost(String shipDate) {
        this.billToTransportationCost = billToTransportationCost;
    }

    public String getBillToTransportationCostReference() {
        return billToTransportationCostReference;
    }

    public void setBillToTransportationCostReference(String billToTransportationCostReference) {
        this.billToTransportationCostReference = billToTransportationCostReference;
    }

    public String getBillToTransportationCostFedExAccountNumber() {
        return billToTransportationCostFedExAccountNumber;
    }

    public void setBillToTransportationCostFedExAccountNumber(String billToTransportationCostFedExAccountNumber) {
        this.billToTransportationCostFedExAccountNumber = billToTransportationCostFedExAccountNumber;
    }

    public String getBillToDutiesTaxesAndFees() {
        return billToDutiesTaxesAndFees;
    }

    public void setBillToDutiesTaxesAndFees(String billToDutiesTaxesAndFees) {
        this.billToDutiesTaxesAndFees = billToDutiesTaxesAndFees;
    }

    public String getBillToDutiesTaxesAndFeesFedExAccountNumber() {
        return billToDutiesTaxesAndFeesFedExAccountNumber;
    }

    public void setBillToDutiesTaxesAndFeesFedExAccountNumber(String billToDutiesTaxesAndFeesFedExAccountNumber) {
        this.billToDutiesTaxesAndFeesFedExAccountNumber = billToDutiesTaxesAndFeesFedExAccountNumber;
    }

    @Override
    public String toString() {
        return "SummaryPayment{" +
                "billToTransportationCost='" + billToTransportationCost + '\'' +
                ", billToTransportationCostReference='" + billToTransportationCostReference + '\'' +
                ", billToTransportationCostFedExAccountNumber='" + billToTransportationCostFedExAccountNumber + '\'' +
                ", billToDutiesTaxesAndFees='" + billToDutiesTaxesAndFees + '\'' +
                ", billToDutiesTaxesAndFeesFedExAccountNumber='" + billToDutiesTaxesAndFeesFedExAccountNumber + '\'' +
                '}';
    }
      PaymentObjects paymentObjects =new PaymentObjects();
    public CopyOnWriteArrayList<SummaryPayment> storeDesktopPaymentServiceDetails() {
        CopyOnWriteArrayList<SummaryPayment> summaryPaymentServiceDetails = new CopyOnWriteArrayList<SummaryPayment>();
        SummaryPayment summaryPaymentService = new SummaryPayment();
        try {
            // ######################### Transportation cost #############################
            if (Wrappers.elementisDisplayedAndEnabled(paymentObjects.transportationHeading)) {
                summaryPaymentService.setBillToTransportationCost(Wrappers.getTextInSelectElement(paymentObjects.billTransportationTo));
                summaryPaymentService.setBillToTransportationCostReference(Wrappers.getInnerText(paymentObjects.reference));
                if (!Wrappers.getTextInUserInputElement(paymentObjects.billTransportationTo).equals("SENDER")) {
                    summaryPaymentService.setBillToTransportationCostFedExAccountNumber(Wrappers.getInnerText(paymentObjects.fedexAccountNumberBillTransport));
                }
                // ######################### Duties and Taxes #############################
                if (!Wrappers.getTextInUserInputElement(paymentObjects.billDutiesTaxes).equals("SENDER")) {
                    summaryPaymentService.setBillToDutiesTaxesAndFees(Wrappers.getTextInSelectElement(paymentObjects.billDutiesTaxes));
                    summaryPaymentService.setBillToDutiesTaxesAndFeesFedExAccountNumber(Wrappers.getInnerText(paymentObjects.fedexAccountNumber));
                }
                summaryPaymentServiceDetails.add(summaryPaymentService);
               // report.pass("Payment Details Stored " + summaryPaymentService);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return summaryPaymentServiceDetails;
    }
    
}

