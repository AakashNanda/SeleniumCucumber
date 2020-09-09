package com.fedex.test.shipping.SummaryCardDataStore;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;

public class SummaryTo extends Wrappers {

    private String toName;
    private String toCompany;
    private String toAptSuite;
    private String toStreetLine;
    private String toState;
    private String toPostalCity;
    private String toCountry;
    private String toPhone;
    private String toEmail;

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToCompany() {
        return toCompany;
    }

    public void setToCompany(String toCompany) {
        this.toCompany = toCompany;
    }

    public String getToAptSuite() {
        return toAptSuite;
    }

    public void setToAptSuite(String toAptSuite) {
        this.toAptSuite = toAptSuite;
    }

    public String getToState() {
        return toState;
    }

    public void setToState(String toState) {
        this.toState = toState;
    }

    public String getToStreetLine() {
        return toStreetLine;
    }

    public void setToStreetLine(String toStreetLine) {
        this.toStreetLine = toStreetLine;
    }

    public String getToPostalCity() {
        return toPostalCity;
    }

    public void setToPostalCity(String toPostalCity) {
        this.toPostalCity = toPostalCity;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    /*@Override
    public String toString() {
        return "SummaryTo{" +
                "toName='" + toName + '\'' +
                ", toCompany='" + toCompany + '\'' +
                ", toAptSuite='" + toAptSuite + '\'' +
                ", toState='" + toState + '\'' +
                ", toStreetLine='" + toStreetLine + '\'' +
                ", toPostalCity='" + toPostalCity + '\'' +
                ", toCountry='" + toCountry + '\'' +
                ", toPhone='" + toPhone + '\'' +
                ", toEmail='" + toEmail + '\'' +
                '}';
    }*/

    AddressEntryObjects addressEntryObjects= new AddressEntryObjects();	 
    public  CopyOnWriteArrayList<SummaryTo> storeDesktopToDetails() {
        CopyOnWriteArrayList<SummaryTo> summaryToDetails = new CopyOnWriteArrayList<SummaryTo>();
        try {
            if (addressEntryObjects.tofieldHeader.isDisplayed()) {
                SummaryTo summaryTo = new SummaryTo();
                summaryTo.setToName(getText(addressEntryObjects.tofieldName));
                summaryTo.setToCompany(getText(addressEntryObjects.userCompanytO));
                summaryTo.setToAptSuite(getText(addressEntryObjects.tofieldAddress2));
                summaryTo.setToStreetLine(getText(addressEntryObjects.tofieldAddress1));
                if (!elementisDisplayedAndEnabled(addressEntryObjects.tofieldState)) {
                    summaryTo.setToPostalCity(getText(addressEntryObjects.tofieldPostal) + " " + getText(addressEntryObjects.tofieldCity));
                } else {
                    summaryTo.setToPostalCity(getText(addressEntryObjects.tofieldPostal) + " " + getText(addressEntryObjects.tofieldState) + " " + getText(addressEntryObjects.tofieldCity));
                }
                summaryTo.setToCountry(getTextInSelectElement(addressEntryObjects.userCountrytO));
                summaryTo.setToPhone(getText(addressEntryObjects.userPhoneNumbertO));
                summaryTo.setToEmail(getText(addressEntryObjects.userEmailtO));
                summaryToDetails.add(summaryTo);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
        return summaryToDetails;
    }
}
