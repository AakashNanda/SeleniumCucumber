package com.fedex.test.shipping.SummaryCardValidate;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.SummaryCardObjectsRateServiceDetails;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPickUpDropOff;

public class SummaryCardPickUpDropOff extends Wrappers{
	
	public SummaryPageObjects summaryPageObjects;

    public SummaryCardPickUpDropOff(SummaryPageObjects summaryPageObjects){
        this.summaryPageObjects= summaryPageObjects;
    }
	
	public void validatePickUpDropOffSection() {
		
		ArrayList<SummaryPickUpDropOff> summaryPickupDropOffActual = new ArrayList<SummaryPickUpDropOff>();
        SummaryPickUpDropOff summaryPickUpDropOff = new SummaryPickUpDropOff();
        try {
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPickupDateAndtime)) {
//                summaryPickUpDropOff.setPickupDateTime(getInnerText(summaryPageObjects.summaryPickupDateAndtime));
                summaryPickUpDropOff.setPickUpDropOffSelected("CONTACT_FEDEX_TO_SCHEDULE");
                if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPickupInstructionlabel)) {
                    summaryPickUpDropOff.setPickupInstruction(getInnerText(summaryPageObjects.summaryPickupinstructions));
                }
            }
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryDropOffinstructions)) {
                summaryPickUpDropOff.setPickUpDropOffSelected(getInnerText(summaryPageObjects.summaryDropOffinstructions));
            }
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPreScheduledinstructions)) {
                summaryPickUpDropOff.setPickUpDropOffSelected(getInnerText(summaryPageObjects.summaryPreScheduledinstructions));
            }
            summaryPickupDropOffActual.add(summaryPickUpDropOff);
            CopyOnWriteArrayList<SummaryPickUpDropOff> summaryPickUpDropOffExpectedData = summaryPageObjects.summaryPickUpDropOffExpectedData;
            // ####################### Compare Actual with Expected values ###########################
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPickupDateAndtime)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPickupDropOffActual.get(0).getPickUpDropOffSelected(), summaryPickUpDropOffExpectedData.get(0).getPickUpDropOffSelected(),  "Pickup or Dropoff Selected option");
//                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPickupDropOffActual.get(0).getPickupDateTime(), summaryPickUpDropOffExpectedData.get(0).getPickupDateTime(),  "Pickup Date and Time");
            }
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryDropOffinstructions)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPickupDropOffActual.get(0).getPickUpDropOffSelected(), summaryPickUpDropOffExpectedData.get(0).getPickUpDropOffSelected(),  "Dropoff is selected as option");
            }
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryPreScheduledinstructions)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPickupDropOffActual.get(0).getPickUpDropOffSelected(), summaryPickUpDropOffExpectedData.get(0).getPickUpDropOffSelected(),  "Already Scheduled pickup is selected as option");
            }
        } catch (Exception e) {
            Assert.fail();
        }
	}

}
