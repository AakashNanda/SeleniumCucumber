package com.fedex.test.shipping.SummaryCardValidate;

import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.SummaryCardObjectsRateServiceDetails;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPayment;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPickUpDropOff;

public class SummaryCardPayment extends Wrappers{
	
	public SummaryPageObjects summaryPageObjects;

    public SummaryCardPayment(SummaryPageObjects summaryPageObjects){
        this.summaryPageObjects= summaryPageObjects;
    }
    
    public  void validatePaymentServiceSection() {
        ArrayList<SummaryPayment> summaryPaymentServiceActual = new ArrayList<SummaryPayment>();
        CopyOnWriteArrayList<SummaryPayment> summaryPaymentExpected = summaryPageObjects.summaryPaymentExpectedData;
        SummaryPayment summaryPaymentService = new SummaryPayment();
        try {
            waitForElement(summaryPageObjects.summaryPaymentBillingTransportationtype);
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentBillto) && elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentAccnum)) {
                summaryPaymentService.setBillToTransportationCostFedExAccountNumber(getInnerText(summaryPageObjects.summaryPaymentAccnum).split(":")[1].trim());
                summaryPaymentService.setBillToTransportationCost(getInnerText(summaryPageObjects.summaryPaymentBillto).split(":")[1].trim());
            } else if (!elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentAccnum)) {
                summaryPaymentService.setBillToTransportationCost(getInnerText(summaryPageObjects.summaryPaymentBillto).split(":")[1].trim());
                if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentreference)) {
                    summaryPaymentService.setBillToTransportationCostReference(getInnerText(summaryPageObjects.summaryPaymentreference).split(":")[1].trim());
                }
            }
            // ##############################  Duties and taxes ########################################
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentBillTolabel) && elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentFAccnumber)) {
                summaryPaymentService.setBillToDutiesTaxesAndFees(getInnerText(summaryPageObjects.summaryPaymentBillTolabel).split(":")[1].trim());
                if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentFAccnumber)) {
                    summaryPaymentService.setBillToDutiesTaxesAndFeesFedExAccountNumber(getInnerText(summaryPageObjects.summaryPaymentFAccnumber).split(":")[1].trim());
                }
            } else if (!elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentFAccnumber)) {
                summaryPaymentService.setBillToDutiesTaxesAndFees(getInnerText(summaryPageObjects.summaryPaymentBillTolabel).split(":")[1].trim());
            }
            summaryPaymentServiceActual.add(summaryPaymentService);

            // ####################### Compare Actual with Expected values ###########################

            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentBillto) && elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentAccnum)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPaymentServiceActual.get(0).getBillToTransportationCostFedExAccountNumber(), summaryPaymentExpected.get(0).getBillToTransportationCostFedExAccountNumber(),  "BillToTransportation FedEx Account number Details");
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPaymentServiceActual.get(0).getBillToTransportationCost(), summaryPaymentExpected.get(0).getBillToTransportationCost(),  "BillToTransportation Details");
            } else if (!elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentAccnum)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPaymentServiceActual.get(0).getBillToTransportationCost(), summaryPaymentExpected.get(0).getBillToTransportationCost(), "BillToTransportation Details");
                if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentreference)) {
                	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPaymentServiceActual.get(0).getBillToTransportationCostReference(), summaryPaymentExpected.get(0).getBillToTransportationCostReference(),  "BillToTransportation Details");
                }
            } else {
                Assert.fail();
            }
            // ##############################  Duties and taxes ########################################
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentBillTolabel) && elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentFAccnumber)){
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPaymentServiceActual.get(0).getBillToDutiesTaxesAndFees(), summaryPaymentExpected.get(0).getBillToDutiesTaxesAndFees(), "BillToDuties Details");
                if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentFAccnumber)) {
                	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPaymentServiceActual.get(0).getBillToDutiesTaxesAndFeesFedExAccountNumber(), summaryPaymentExpected.get(0).getBillToDutiesTaxesAndFeesFedExAccountNumber(),  "BillToDuties Fedex Account number Details");
                }
            } else if(!elementisDisplayedAndEnabled(summaryPageObjects.summaryPaymentFAccnumber)){
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPaymentServiceActual.get(0).getBillToDutiesTaxesAndFees(), summaryPaymentExpected.get(0).getBillToDutiesTaxesAndFees(), "BillToDuties Details");
            }else{
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
