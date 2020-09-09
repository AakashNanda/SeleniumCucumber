package com.fedex.test.shipping.SummaryCardDataStore;

import com.experitest.selenium.MobileWebDriver;
import com.fedex.test.shipping.ObjectsRepository.RateQuotesObjects;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;


public class SummaryRateService extends Wrappers {
    private String shipDate;
    private boolean viewSignatureOptionFlag;
    private String signatureOptionSelected;
    private String fedexServiceSelected;
    private String arrivesOnDate;
    private String deliveredByTime;
    private String summaryArrivesOnDateAndTime;
    private String totalRate;
    private String amountShown;


    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public Boolean getViewSignatureOptionFlag() {
        return viewSignatureOptionFlag;
    }
    public String getAmountShown() {
        return amountShown;
    }

    public void setAmountShown(String amountShown) {
        this.amountShown = amountShown;
    }

    public void setViewSignatureOptionFlag(boolean viewSignatureOptionFlag) {
        this.viewSignatureOptionFlag = viewSignatureOptionFlag;
    }

    public String getSignatureOptionSelected() {
        return signatureOptionSelected;
    }

    public void setSignatureOptionSelected(String signatureOptionSelected) {
        this.signatureOptionSelected = signatureOptionSelected;
    }

    public String getFedexServiceSelected() {
        return fedexServiceSelected;
    }

    public void setFedexServiceSelected(String fedexServiceSelected) {
        this.fedexServiceSelected = fedexServiceSelected;
    }

    public String getSummaryArrivesOnDateAndTime() {
        return summaryArrivesOnDateAndTime;
    }

    public void setSummaryArrivesOnDateAndTime(String summaryArrivesOnDateAndTime) {
        this.summaryArrivesOnDateAndTime = summaryArrivesOnDateAndTime;
    }

    public String getArrivesOnDate() {
        return arrivesOnDate;
    }

    public void setArrivesOnDate(String arrivesOnDate) {
        this.arrivesOnDate = arrivesOnDate;
    }

    public String getDeliveredByTime() {
        return deliveredByTime;
    }

    public void setDeliveredByTime(String deliveredByTime) {
        this.deliveredByTime = deliveredByTime;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }

    @Override
    public String toString() {
        return "SummaryRateService{" +
                "shipDate='" + shipDate + '\'' +
                ", viewSignatureOptionFlag='" + viewSignatureOptionFlag + '\'' +
                ", signatureOptionSelected='" + signatureOptionSelected + '\'' +
                ", fedexServiceSelected='" + fedexServiceSelected + '\'' +
                ", arrivesOnDate='" + arrivesOnDate + '\'' +
                ", deliveredByTime='" +deliveredByTime+ '\'' +
                ", summaryArrivesOnDateAndTime='" + summaryArrivesOnDateAndTime + '\'' +
                ", totalRate='" + totalRate + '\'' +
                ", amountShown='" + amountShown + '\'' +
                '}';
    }

    RateQuotesObjects rateQuotesObjects = new RateQuotesObjects();

    public CopyOnWriteArrayList<SummaryRateService> storeDesktopRateServiceDetails() {
        CopyOnWriteArrayList<SummaryRateService> summaryRateServiceDetails = new CopyOnWriteArrayList<SummaryRateService>();
        try {
            if (rateQuotesObjects.shipDateId.isDisplayed()) {
                SummaryRateService summaryRateService = new SummaryRateService();
                String amountShownIn= getInnerText(rateQuotesObjects.amountShown);
                summaryRateService.setAmountShown(getInnerText(rateQuotesObjects.amountShown).substring(amountShownIn.length()-3));
                summaryRateService.setShipDate(getText(rateQuotesObjects.shipDateId));
                /*summaryRateService.setFedexServiceSelected(getInnerText(rateQuotesObjects.rateServicesButton));*/
           //     summaryRateService.setArrivesOnDate(getInnerText(rateQuotesObjects.arriveson.get(0)));
                summaryRateService.setDeliveredByTime(getInnerText(rateQuotesObjects.deliveredbytime));
                String FedExServiceType = getInnerText(rateQuotesObjects.deliveredbyservicetype);
//                if (!summaryRateService.getArrivesOnDate().contains("Business Days")) {
//                    summaryRateService.setDeliveredByTime(getInnerText(rateQuotesObjects.deliveredbytime));
//                 //   summaryRateService.setFedexServiceSelected("FedEx" + getInnerText(rateQuotesObjects.deliveredby.get(0)).split("DELIVERED BY")[1].replaceAll("\n", "").split("FedEx")[0]);
//                      summaryRateService.setFedexServiceSelected(FedExServiceType.substring(13));
//                } else {
//                      summaryRateService.setFedexServiceSelected(FedExServiceType.substring(28));
//                   // summaryRateService.setFedexServiceSelected("FedEx" + getInnerText(rateQuotesObjects.deliveredby.get(0)).split("DELIVERED BY")[1].replaceAll("\n", ""));
//                }
                summaryRateService.setFedexServiceSelected(FedExServiceType);
                if (elementisDisplayedAndEnabled(rateQuotesObjects.Signatureoptions)) {
                    boolean signatureCheckBoxFlagValue = Wrappers.checkStatusCheckBox(rateQuotesObjects.Signatureoptions);
                    SummaryRateService summarySignatureService = new SummaryRateService();
                    summarySignatureService.setViewSignatureOptionFlag(signatureCheckBoxFlagValue);
                    if (rateQuotesObjects.Signatureoptions.isDisplayed() && signatureCheckBoxFlagValue) {
                        summarySignatureService.setSignatureOptionSelected(getTextInUserInputElement(rateQuotesObjects.directSignaturerequired));
                    }
                }
                summaryRateServiceDetails.add(summaryRateService);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return summaryRateServiceDetails;
    }

    public  CopyOnWriteArrayList<SummaryRateService> storeMobileRateServiceDetails() {

        CopyOnWriteArrayList<SummaryRateService> summaryRateServiceDetails = new CopyOnWriteArrayList<SummaryRateService>();
        try {
            if (rateQuotesObjects.shipDateId.isDisplayed()) {
                SummaryRateService summaryRateService = new SummaryRateService();
                String amountShownIn= getText(rateQuotesObjects.amountShown);

                summaryRateService.setAmountShown(getText(rateQuotesObjects.amountShown).substring(amountShownIn.length()-3));
                summaryRateService.setShipDate(getText(rateQuotesObjects.shipDateId));
                summaryRateService.setFedexServiceSelected(getText(rateQuotesObjects.rateServicesButton));
                summaryRateService.setArrivesOnDate(getText(rateQuotesObjects.arriveson.get(0)).split("ARRIVES ON")[1].replaceAll("\n", ""));
                summaryRateService.setDeliveredByTime(getText(rateQuotesObjects.deliveredbytime));
                if (!summaryRateService.getArrivesOnDate().contains("Business Days")) {
                    summaryRateService.setDeliveredByTime(getText(rateQuotesObjects.deliveredbytime));
                    summaryRateService.setFedexServiceSelected("FedEx" + getText(rateQuotesObjects.deliveredbyservicetype));
                } else {
                    summaryRateService.setFedexServiceSelected("FedEx" + getText(rateQuotesObjects.deliveredbyservicetype));
                }
                if (elementisDisplayedAndEnabled(rateQuotesObjects.Signatureoptions)) {
                    boolean signatureCheckBoxFlagValue = checkStatusCheckBoxMobile((MobileWebDriver) DriverGenerator.getDriver(),rateQuotesObjects.SignatureOptions);
                    SummaryRateService summarySignatureService = new SummaryRateService();
                    summarySignatureService.setViewSignatureOptionFlag(signatureCheckBoxFlagValue);
                    if (rateQuotesObjects.Signatureoptions.isDisplayed()  && signatureCheckBoxFlagValue) {
                        summarySignatureService.setSignatureOptionSelected(getText(rateQuotesObjects.directSignaturerequired));
                    }
                }
                summaryRateServiceDetails.add(summaryRateService);

            } else {
                Assert.fail();

            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
        return summaryRateServiceDetails;
    }

}

