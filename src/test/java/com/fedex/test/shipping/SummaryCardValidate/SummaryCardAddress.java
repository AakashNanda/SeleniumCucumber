package com.fedex.test.shipping.SummaryCardValidate;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.SummaryCardObjectsPackagingDetails;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import com.fedex.test.shipping.ObjectsRepository.summaryCardObjectsAddressDetails;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryAltPickup;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryFrom;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryTo;


public class SummaryCardAddress extends Wrappers {
	
	 public summaryCardObjectsAddressDetails summaryCardObjectsAddressDetails;
	 public SummaryPageObjects summaryPageObjects;

	    public SummaryCardAddress(summaryCardObjectsAddressDetails summaryCardObjectsAddressDetails,
	    		SummaryPageObjects summaryPageObjects){
	        this.summaryCardObjectsAddressDetails=summaryCardObjectsAddressDetails;
	        this.summaryPageObjects=summaryPageObjects;
	    }

	    public  void validateFromAddressSection() {
	    scrollToElement(summaryCardObjectsAddressDetails.summaryfromEdit);
        CopyOnWriteArrayList<SummaryFrom> summaryFromActual = new CopyOnWriteArrayList<SummaryFrom>();
        SummaryFrom summaryFrom = new SummaryFrom();
        try {
        	waitForElement(summaryCardObjectsAddressDetails.summaryFromheading);
            summaryFrom.setFromName(getInnerText(summaryCardObjectsAddressDetails.summaryFromname));
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryFromcompany)) {
                summaryFrom.setFromCompany(getInnerText(summaryCardObjectsAddressDetails.summaryFromcompany));
            }
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryFromAptsuite)) {
                summaryFrom.setFromAptSuite(getInnerText(summaryCardObjectsAddressDetails.summaryFromAptsuite));
            }
            summaryFrom.setFromStreetLine(getInnerText(summaryCardObjectsAddressDetails.summaryFromStreetline));
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryFromPostalstateCity)) {
                summaryFrom.setFromPostalCity(getInnerText(summaryCardObjectsAddressDetails.summaryFromPostalstateCity));
            } else {
                summaryFrom.setFromPostalCity(getInnerText(summaryCardObjectsAddressDetails.summaryFromPostalcity));
            }
            summaryFrom.setFromCountry(getInnerText(summaryCardObjectsAddressDetails.summaryFromcountry));
            summaryFrom.setFromPhone(getInnerText(summaryCardObjectsAddressDetails.summaryFromphone));
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryFromemail)) {
                summaryFrom.setFromEmail(getInnerText(summaryCardObjectsAddressDetails.summaryFromemail));
            }
            summaryFromActual.add(summaryFrom);
            CopyOnWriteArrayList<SummaryFrom> summaryFromExpected = summaryPageObjects.summaryFromExpectedData;
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromName(), summaryFromExpected.get(0).getFromName(),  "From Name");
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryFromcompany)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromCompany(), summaryFromExpected.get(0).getFromCompany(), "From Company");
            }
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryFromAptsuite)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromAptSuite(), summaryFromExpected.get(0).getFromAptSuite(), "From Apt Suite");
            }
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromStreetLine(), summaryFromExpected.get(0).getFromStreetLine(), "From Street Line");
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromPostalCity(), summaryFromExpected.get(0).getFromPostalCity(), "From Postal State City");
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromCountry(), summaryFromExpected.get(0).getFromCountry(),  "From Country");
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromPhone(), summaryFromExpected.get(0).getFromPhone(),  "From Phone");
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryFromemail)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryFromActual.get(0).getFromEmail(), summaryFromExpected.get(0).getFromEmail(), "From Email");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
	    }

	public  void validateToAddressSection() {
        CopyOnWriteArrayList<SummaryTo> summaryToActual = new CopyOnWriteArrayList<SummaryTo>();
        SummaryTo summaryTo = new SummaryTo();
        try {
            waitForElement(summaryCardObjectsAddressDetails.summaryToname);
            summaryTo.setToName(getInnerText(summaryCardObjectsAddressDetails.summaryToname));
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryTocompany)) {
                summaryTo.setToCompany(getInnerText(summaryCardObjectsAddressDetails.summaryTocompany));
            }
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryToAptsuite)) {
                summaryTo.setToAptSuite(getInnerText(summaryCardObjectsAddressDetails.summaryToAptsuite));
            }
            summaryTo.setToStreetLine(getInnerText(summaryCardObjectsAddressDetails.summaryTostreetLine));
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryToPostalstateCity)) {
                summaryTo.setToPostalCity(getInnerText(summaryCardObjectsAddressDetails.summaryToPostalstateCity));
            } else {
                summaryTo.setToPostalCity(getInnerText(summaryCardObjectsAddressDetails.summaryToPostalcity));
            }
            summaryTo.setToCountry(getInnerText(summaryCardObjectsAddressDetails.summaryTocountry));
            summaryTo.setToPhone(getInnerText(summaryCardObjectsAddressDetails.summaryTophone));
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryToemail)) {
                summaryTo.setToEmail(getInnerText(summaryCardObjectsAddressDetails.summaryToemail));
            }
            summaryToActual.add(summaryTo);
            CopyOnWriteArrayList<SummaryTo> summaryToExpected = summaryPageObjects.summaryToExpectedData;
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryToActual.get(0).getToName(), summaryToExpected.get(0).getToName(),"To Name");
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryTocompany)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryToActual.get(0).getToCompany(), summaryToExpected.get(0).getToCompany(), "To Company");
            }
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryToAptsuite)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryToActual.get(0).getToAptSuite(), summaryToExpected.get(0).getToAptSuite(), "To Apt Suite");
            }
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryToActual.get(0).getToStreetLine(), summaryToExpected.get(0).getToStreetLine(),  "To Street Line");
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryToActual.get(0).getToPostalCity(), summaryToExpected.get(0).getToPostalCity(),  "To Postal City");
//            SummaryPage.compareExpectedVSActualDesktop(summaryToActual.get(0).getToCountry(), summaryToExpected.get(0).getToCountry(), report, "To Country");
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryToActual.get(0).getToPhone(), summaryToExpected.get(0).getToPhone(),  "To Phone");
            if (elementisDisplayedAndEnabled(summaryCardObjectsAddressDetails.summaryToemail)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryToActual.get(0).getToEmail(), summaryToExpected.get(0).getToEmail(),  "To Email");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
		
	}
	
	public void validateAlternatePickupAddressSection() {
        CopyOnWriteArrayList<SummaryAltPickup> summaryAltPickupActual = new CopyOnWriteArrayList<SummaryAltPickup>();
        SummaryAltPickup summaryAltPickup = new SummaryAltPickup();
        try {
            waitForElement(summaryPageObjects.summaryAltAddressname);
            scrollToElement(summaryPageObjects.summaryAltAddressname);
            summaryAltPickup.setAltName(getInnerText(summaryPageObjects.summaryAltAddressname));
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryAltAddressAptsuite)) {
                summaryAltPickup.setAltAptSuite(getInnerText(summaryPageObjects.summaryAltAddressAptsuite));
            }
            summaryAltPickup.setAltStreetLine(getInnerText(summaryPageObjects.summaryAltAddressStreetline));
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryAltAddressPostalStatecity)) {
                summaryAltPickup.setAltPostalCity(getInnerText(summaryPageObjects.summaryAltAddressPostalStatecity));
            } else {
                summaryAltPickup.setAltPostalCity(getInnerText(summaryPageObjects.summaryAltAddressPostalcity));
            }
            summaryAltPickup.setAltCountry(getInnerText(summaryPageObjects.summaryAltAddresscountry));
            summaryAltPickup.setAltPhone(getInnerText(summaryPageObjects.summaryAltAddressphone));
            summaryAltPickupActual.add(summaryAltPickup);
            CopyOnWriteArrayList<SummaryAltPickup> summaryAltPickupExpected = summaryPageObjects.summaryAltPickupData;
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryAltPickupActual.get(0).getAltName(), summaryAltPickupExpected.get(0).getAltName(),  "Alternate Pickup Name");
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryAltAddressAptsuite)) {
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryAltPickupActual.get(0).getAltAptSuite(), summaryAltPickupExpected.get(0).getAltAptSuite(),  "Alternate Pickup Apt Suite");
            }
//            SummaryPage.compareExpectedVSActualDesktop(summaryAltPickupActual.get(0).getAltStreetLine(), summaryAltPickupExpected.get(0).getAltStreetLine(), report, "Alternate Pickup Street Line");
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryAltPickupActual.get(0).getAltPostalCity(), summaryAltPickupExpected.get(0).getAltPostalCity(), "Alternate Pickup Postal State City");
//            SummaryPage.compareExpectedVSActualDesktop(summaryAltPickupActual.get(0).getAltCountry(), summaryAltPickupExpected.get(0).getAltCountry(), report, "Alternate Pickup Country");
//            SummaryPage.compareExpectedVSActualDesktop(summaryAltPickupActual.get(0).getAltPhone(), summaryAltPickupExpected.get(0).getAltPhone(), report, "Alternate Pickup Phone");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
		
	}

}
