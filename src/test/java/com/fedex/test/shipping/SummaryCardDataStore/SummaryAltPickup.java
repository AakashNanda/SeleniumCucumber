package com.fedex.test.shipping.SummaryCardDataStore;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;

public class SummaryAltPickup extends Wrappers{
	
	
	
	private String altName;
    private String altAptSuite;
    private String altStreetLine;
    private String altPostalCity;
    private String altCountry;
    private String altPhone;

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public String getAltAptSuite() {
        return altAptSuite;
    }

    public void setAltAptSuite(String altAptSuite) {
        this.altAptSuite = altAptSuite;
    }

    public String getAltStreetLine() {
        return altStreetLine;
    }

    public void setAltStreetLine(String altStreetLine) {
        this.altStreetLine = altStreetLine;
    }

    public String getAltPostalCity() {
        return altPostalCity;
    }

    public void setAltPostalCity(String altPostalCity) {
        this.altPostalCity = altPostalCity;
    }

    public String getAltCountry() {
        return altCountry;
    }

    public void setAltCountry(String altCountry) {
        this.altCountry = altCountry;
    }

    public String getAltPhone() {
        return altPhone;
    }

    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }

    @Override
    public String toString() {
        return "SummaryAltPickup{" +
                "altName='" + altName + '\'' +
                ", altAptSuite='" + altAptSuite + '\'' +
                ", altStreetLine='" + altStreetLine + '\'' +
                ", altPostalCity='" + altPostalCity + '\'' +
                ", altCountry='" + altCountry + '\'' +
                ", altPhone='" + altPhone + '\'' +
                '}';
    }
    
    AddressEntryObjects addressEntryObjects=new AddressEntryObjects();

    public  CopyOnWriteArrayList<SummaryAltPickup> storeDesktopAltPickupDetails() {
        CopyOnWriteArrayList<SummaryAltPickup> summaryAltPickupDetails = new CopyOnWriteArrayList<SummaryAltPickup>();
        try {
            if (addressEntryObjects.alternativePickupAddressheading.isDisplayed()) {
                SummaryAltPickup summaryAltPickup = new SummaryAltPickup();
                summaryAltPickup.setAltName(getTextInUserInputElement(addressEntryObjects.alternativePickupname));
                summaryAltPickup.setAltAptSuite(getTextInUserInputElement(addressEntryObjects.alternativePickupAptsuite));
                summaryAltPickup.setAltStreetLine(getTextInUserInputElement(addressEntryObjects.alternativePickupaddress));
                if (!elementisDisplayedAndEnabled(addressEntryObjects.alternativePickupstate)) {
                    summaryAltPickup.setAltPostalCity(getTextInUserInputElement(addressEntryObjects.alternativePickuppostal) + " " + getTextInUserInputElement(addressEntryObjects.alternativePickupcity));
                } else {
                    summaryAltPickup.setAltPostalCity(getTextInUserInputElement(addressEntryObjects.alternativePickuppostal) + " " + getTextInUserInputElement(addressEntryObjects.alternativePickupstate) + " " + getTextInUserInputElement(addressEntryObjects.alternativePickupcity));
                }
                summaryAltPickup.setAltCountry(getTextInSelectElement(addressEntryObjects.alternativePickupcountry));
                summaryAltPickup.setAltPhone(getTextInUserInputElement(addressEntryObjects.alternativePickupPhonenumber));
                summaryAltPickupDetails.add(summaryAltPickup);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
        return summaryAltPickupDetails;
    }

   

}
