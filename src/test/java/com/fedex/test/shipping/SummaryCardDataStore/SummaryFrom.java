package com.fedex.test.shipping.SummaryCardDataStore;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;

public class SummaryFrom extends Wrappers{
	
	
   
	private String fromName;
    private String fromCompany;
    private String fromAptSuite;
    private String fromStreetLine;
    private String fromPostalCity;
    private String fromCountry;
    private String fromPhone;
    private String fromEmail;


    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromCompany() {
        return fromCompany;
    }

    public void setFromCompany(String fromCompany) {
        this.fromCompany = fromCompany;
    }

    public String getFromAptSuite() {
        return fromAptSuite;
    }

    public void setFromAptSuite(String fromAptSuite) {
        this.fromAptSuite = fromAptSuite;
    }

    public String getFromStreetLine() {
        return fromStreetLine;
    }

    public void setFromStreetLine(String fromStreetLine) {
        this.fromStreetLine = fromStreetLine;
    }

    public String getFromPostalCity() {
        return fromPostalCity;
    }

    public void setFromPostalCity(String fromPostalCity) {
        this.fromPostalCity = fromPostalCity;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }


/*    @Override
    public String toString() {
        return "SummaryFrom{" +
                "fromName='" + fromName + '\'' +
                ", fromCompany='" + fromCompany + '\'' +
                ", fromAptSuite='" + fromAptSuite + '\'' +
                ", fromStreetLine='" + fromStreetLine + '\'' +
                ", fromPostalCity='" + fromPostalCity + '\'' +
                ", fromCountry='" + fromCountry + '\'' +
                ", fromPhone='" + fromPhone + '\'' +
                ", fromEmail='" + fromEmail + '\'' +
                '}';
    }*/

    AddressEntryObjects addressEntryObjects= new AddressEntryObjects();	 
    public  CopyOnWriteArrayList<SummaryFrom> storeDesktopFromDetails() {
        CopyOnWriteArrayList<SummaryFrom> summaryFromDetails = new CopyOnWriteArrayList<SummaryFrom>();
        try {
            if (addressEntryObjects.fromfieldHeader.isDisplayed()) {
                SummaryFrom summaryFrom = new SummaryFrom();
                summaryFrom.setFromName(getText(addressEntryObjects.fromfieldName).replaceAll(" +", " "));
                summaryFrom.setFromCompany(getText(addressEntryObjects.fromfieldCompany));
                summaryFrom.setFromAptSuite(getText(addressEntryObjects.fromfieldAddress2));
                summaryFrom.setFromStreetLine(getText(addressEntryObjects.fromfieldAddress1));
                if (!elementisDisplayedAndEnabled(addressEntryObjects.fromfieldState)) {
                    summaryFrom.setFromPostalCity(getText(addressEntryObjects.fromfieldPostal) + " " + getText(addressEntryObjects.fromfieldCity));
                } else {
                    summaryFrom.setFromPostalCity(getText(addressEntryObjects.fromfieldPostal) + " " + getText(addressEntryObjects.fromfieldState) + " " + getText(addressEntryObjects.fromfieldCity));
                }
                summaryFrom.setFromCountry(getTextInSelectElement(addressEntryObjects.fromfieldCountry));
                summaryFrom.setFromPhone(getText(addressEntryObjects.fromfieldPhnNum));
                summaryFrom.setFromEmail(getText(addressEntryObjects.fromfieldEmail));
                summaryFromDetails.add(summaryFrom);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return summaryFromDetails;
    }

}
