package com.fedex.test.shipping.SummaryCardDataStore;

import com.experitest.selenium.MobileWebDriver;
import com.fedex.test.shipping.ObjectsRepository.PackagingAndShipmentDetailsObjects;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SummaryPackaging {


    private String packageNumberXType;
    private String packageWeightAndUnit;
    private String packageDimensionsAndUnit;
    private String packageDeclaredValueAndCurrency;
    private String describeYourGoods;


    public String getPackageNumberXType() {
        return packageNumberXType;
    }

    public void setPackageNumberXType(String packageNumberXType) {
        this.packageNumberXType = packageNumberXType;
    }

    public String getPackageWeightAndUnit() {
        return packageWeightAndUnit;
    }

    public void setPackageWeightAndUnit(String packageWeightAndUnit) {
        this.packageWeightAndUnit = packageWeightAndUnit;
    }

    public String getPackageDimensionsAndUnit() {
        return packageDimensionsAndUnit;
    }

    public void setPackageDimensionsAndUnit(String packageDimensionsAndUnit) {
        this.packageDimensionsAndUnit = packageDimensionsAndUnit;
    }

    public String getPackageDeclaredValueAndCurrency() {
        return packageDeclaredValueAndCurrency;
    }

    public void setPackageDeclaredValueAndCurrency(String packageDeclaredValueAndCurrency) {
        this.packageDeclaredValueAndCurrency = packageDeclaredValueAndCurrency;
    }


    public String getDescribeYourGoods() {
        return describeYourGoods;
    }
    public void setDescribeYourGoods(String describeYourGoods) {
        this.describeYourGoods = describeYourGoods;
    }

    PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects = new PackagingAndShipmentDetailsObjects();

    public CopyOnWriteArrayList<SummaryPackaging> storeDesktopPackagingDetails() {
        CopyOnWriteArrayList<SummaryPackaging> summaryPackagingDetails = new CopyOnWriteArrayList<>();
        String currencyCode;
        try {
            if (packagingAndShipmentDetailsObjects.packagingType.isDisplayed()) {
                SummaryPackaging summaryPackaging = new SummaryPackaging();
                summaryPackaging.setPackageNumberXType(Wrappers.getTextInSelectElement(packagingAndShipmentDetailsObjects.numberOfPackages));
                summaryPackaging.setPackageWeightAndUnit(Wrappers.getText(packagingAndShipmentDetailsObjects.packagingWeight)
                        + " " + Wrappers.getInnerText(packagingAndShipmentDetailsObjects.shipmentDetailsUnits.get(0)));
                if (Wrappers.elementisDisplayedAndEnabled(packagingAndShipmentDetailsObjects.dimLength)) {
                    summaryPackaging.setPackageDimensionsAndUnit(Wrappers.getText(packagingAndShipmentDetailsObjects.dimLength)
                            + " x " + Wrappers.getText(packagingAndShipmentDetailsObjects.dimWidth)
                            + " x " + Wrappers.getText(packagingAndShipmentDetailsObjects.dimHeight)
                            + " " + Wrappers.getInnerText(packagingAndShipmentDetailsObjects.shipmentDetailsUnits.get(1)));
                }
                if (Wrappers.elementisDisplayedAndEnabled(packagingAndShipmentDetailsObjects.coverageQuestion)) {
                    if (packagingAndShipmentDetailsObjects.yesCoverageStatus.isSelected()) {
                        if (Wrappers.getTextInSelectElement(packagingAndShipmentDetailsObjects.packagingType).trim().equalsIgnoreCase("Your Packaging")) {
                            currencyCode = Wrappers.getInnerText(packagingAndShipmentDetailsObjects.shipmentDetailsUnits.get(2));
                        }else{
                        currencyCode= Wrappers.getInnerText(packagingAndShipmentDetailsObjects.shipmentDetailsUnits.get(1));}
                        String currencySymbol = SeleniumReusableMethods.getCurrencySymbol(currencyCode);
                        summaryPackaging.setPackageDeclaredValueAndCurrency(currencySymbol
                                + Wrappers.getText(packagingAndShipmentDetailsObjects.coverageValue)+ " " + currencyCode);
                    }
                } else {
                    currencyCode = Wrappers.getTextInSelectElement(packagingAndShipmentDetailsObjects.declaredValueCurrency);
                    String currencySymbol = SeleniumReusableMethods.getCurrencySymbol(currencyCode);
                    summaryPackaging.setPackageDeclaredValueAndCurrency(currencySymbol
                            + Wrappers.getText(packagingAndShipmentDetailsObjects.shipmentDetailsUnits.get(2))+ " " + currencyCode);
                }
                if (Wrappers.elementisDisplayedAndEnabled(packagingAndShipmentDetailsObjects.describeYourGoods)) {
                    summaryPackaging.setDescribeYourGoods(Wrappers.getText(packagingAndShipmentDetailsObjects.describeYourGoods));
                }
                summaryPackagingDetails.add(summaryPackaging);
            } else{
                Assert.fail();
            }
        } catch(Exception e)

        {
            e.printStackTrace();
            Assert.fail();
        }
        return summaryPackagingDetails;
    }

    public CopyOnWriteArrayList<SummaryPackaging> storeMobilePackagingDetails() {
        CopyOnWriteArrayList<SummaryPackaging> summaryPackagingDetails = new CopyOnWriteArrayList<>();
        try {
            if (packagingAndShipmentDetailsObjects.packagingType.isDisplayed()) {
                SummaryPackaging summaryPackaging = new SummaryPackaging();
                summaryPackaging.setPackageNumberXType(Wrappers.getText(packagingAndShipmentDetailsObjects.numberOfPackages));
                summaryPackaging.setPackageWeightAndUnit(Wrappers.getText(packagingAndShipmentDetailsObjects.packagingWeight)
                        + " " +Wrappers.getInnerTextMobile((MobileWebDriver) DriverGenerator.getDriver(),packagingAndShipmentDetailsObjects.packageWeightUnit));
                if (Wrappers.elementisDisplayedAndEnabled(packagingAndShipmentDetailsObjects.dimLength)) {
                    summaryPackaging.setPackageDimensionsAndUnit(Wrappers.getText(packagingAndShipmentDetailsObjects.dimLength)
                            + " x " + Wrappers.getText(packagingAndShipmentDetailsObjects.dimWidth)
                            + " x " + Wrappers.getText(packagingAndShipmentDetailsObjects.dimHeight)
                            + " " + Wrappers.getInnerTextMobile((MobileWebDriver) DriverGenerator.getDriver(),packagingAndShipmentDetailsObjects.dimensionUnit));
                }
                if (Wrappers.elementisDisplayedAndEnabled(packagingAndShipmentDetailsObjects.coverageQuestion)) {
                    if (packagingAndShipmentDetailsObjects.yesCoverageStatus.isSelected()) {
                        String currencyCode =Wrappers.getText(packagingAndShipmentDetailsObjects.coverageValueCurrency);
                        String currencySymbol = SeleniumReusableMethods.getCurrencySymbol(currencyCode);
                        summaryPackaging.setPackageDeclaredValueAndCurrency(currencySymbol
                                + Wrappers.getText(packagingAndShipmentDetailsObjects.coverageValue)
                                + " " + currencyCode);
                    }
                } else {
                    String currencyCode = Wrappers.getInnerTextMobile((MobileWebDriver) DriverGenerator.getDriver(),packagingAndShipmentDetailsObjects.declaredValCurrency);
                    String currencySymbol = SeleniumReusableMethods.getCurrencySymbol(currencyCode);
                    summaryPackaging.setPackageDeclaredValueAndCurrency(currencySymbol
                            + Wrappers.getText(packagingAndShipmentDetailsObjects.declareValue)
                            + " " + currencyCode);
                }
                if (Wrappers.elementisDisplayedAndEnabled(packagingAndShipmentDetailsObjects.describeYourGoods)) {
                    summaryPackaging.setDescribeYourGoods(Wrappers.getText(packagingAndShipmentDetailsObjects.describeYourGoods));
                }
                summaryPackagingDetails.add(summaryPackaging);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
        return summaryPackagingDetails;
    }
}
