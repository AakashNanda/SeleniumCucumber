package com.fedex.test.shipping.SummaryCardValidate;

import com.fedex.test.shipping.ObjectsRepository.SummaryCardObjectsPackagingDetails;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPackaging;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryShipmentDetails;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;


public class SummaryCardPackagingDetails extends Wrappers {

    public SummaryCardObjectsPackagingDetails summaryCardObjectsPackagingDetails;
    public SummaryPageObjects summaryPageObjects;

    public SummaryCardPackagingDetails(SummaryCardObjectsPackagingDetails summaryCardObjectsPackagingDetails,
    		SummaryPageObjects summaryPageObjects){
        this.summaryCardObjectsPackagingDetails=summaryCardObjectsPackagingDetails;
        this.summaryPageObjects= summaryPageObjects;
    }

    public void validatePackageDetailsSection() {
        CopyOnWriteArrayList<SummaryPackaging> summaryPackagingActual = new CopyOnWriteArrayList<SummaryPackaging>();
        SummaryPackaging summaryPackaging = new SummaryPackaging();
        try {
            waitForElement(summaryCardObjectsPackagingDetails.summaryPackageComponent);
            summaryPackaging.setPackageNumberXType(getInnerText(summaryCardObjectsPackagingDetails.summaryPackageNumber));
            if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDimensions)) {
                summaryPackaging.setPackageDimensionsAndUnit(getInnerText(summaryCardObjectsPackagingDetails.summaryPackageDimensions));
            }
            summaryPackaging.setPackageWeightAndUnit(getInnerText(summaryCardObjectsPackagingDetails.summaryPackageWeight));
            try {
                if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDeclaredValue)) {
//                    summaryPackaging.setPackageDeclaredValueAndCurrency(getInnerText(summaryCardObjectsPackagingDetails.summaryPackageDeclaredValue));
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDescribeYourGoods)) {
                summaryPackaging.setDescribeYourGoods(getInnerText(summaryCardObjectsPackagingDetails.summaryPackageDescribeYourGoods));
            }
            summaryPackagingActual.add(summaryPackaging);
            CopyOnWriteArrayList<SummaryPackaging> summaryPackagingExpected = summaryPageObjects.summaryPackagingExpectedData;
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageNumberXType(), summaryPackagingExpected.get(0).getPackageNumberXType(), "Package Count and Type");

                if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDimensions)) {
//                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageDimensionsAndUnit(), summaryPackagingExpected.get(0).getPackageDimensionsAndUnit(), "Package Dimension and Unit");
                }
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageWeightAndUnit(), summaryPackagingExpected.get(0).getPackageWeightAndUnit(), "Package Weight and Unit");
                try{
                if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDeclaredValue)) {
//                    SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageDeclaredValueAndCurrency(), summaryPackagingExpected.get(0).getPackageDeclaredValueAndCurrency(), "Package Declared Value and Currency");
                }} catch (Exception e){
                    e.printStackTrace();
                }

            if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDescribeYourGoods)) {
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getDescribeYourGoods(), summaryPackagingExpected.get(0).getDescribeYourGoods(), "Describe your goods");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception in Package Section");
        }
    }
    
    public void validatePackageSection() {
        CopyOnWriteArrayList<SummaryShipmentDetails> SummaryShipmentDetailsActual = new CopyOnWriteArrayList<>();
        SummaryShipmentDetails summaryShipmentDetails = new SummaryShipmentDetails();
        scrollToElement(summaryPageObjects.summaryCustomscomponent);
        try {
        	waitForElement(summaryPageObjects.summaryCustomscomponent);
            CopyOnWriteArrayList<SummaryShipmentDetails> SummaryShipmentDetailsExpected = summaryPageObjects.summaryShipmentDetailsExpectedData;
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryCustomShipmentpurposeLabel)){
                summaryShipmentDetails.setShipmentType(getInnerText(summaryPageObjects.summaryCustomtype).split(" ")[1]);
                summaryShipmentDetails.setShipmentItemsPurpose(getInnerText(summaryPageObjects.summaryCustomShipmentPurposevalue));
                summaryShipmentDetails.setShipmentItemsHarmonizedCustomCode(getInnerText(summaryPageObjects.summaryCustomHCcode));
                summaryShipmentDetails.setShipmentItemsManufactureCountry(getInnerText(summaryPageObjects.summaryCustomManufacturedin));
//                summaryShipmentDetails.setShipmentItemsCustomsAndCurrency(getInnerText(summaryPageObjects.summaryCustomCustomsvalue));
                summaryShipmentDetails.setShipmentItemsQuantityAndUnit(getInnerText(summaryPageObjects.summaryCustomdescription));
                summaryShipmentDetails.setShipmentItemsWeightAndUnit(getInnerText(summaryPageObjects.summaryCustomweight));
            } else {
                summaryShipmentDetails.setShipmentType(getInnerText(summaryPageObjects.summaryCustomdocType).replaceAll(":",""));
                summaryShipmentDetails.setShipmentDocumentType(getInnerText(summaryPageObjects.summaryCustomShipDocTypevalue));
                summaryShipmentDetails.setShipmentDocumentCustomValueAndCurrency(getInnerText(summaryPageObjects.summaryCustomCustomsDocTypevalue));
            }
            SummaryShipmentDetailsActual.add(summaryShipmentDetails);
            SeleniumReusableMethods.compareExpectedVSActualDesktop(
                    SummaryShipmentDetailsActual.get(0).getShipmentType(),
                    SummaryShipmentDetailsExpected.get(0).getShipmentType(), "Shipment Type");
            if (elementisDisplayedAndEnabled(summaryPageObjects.summaryCustomShipmentpurposeLabel)) {
            	//SeleniumReusableMethods.compareExpectedVSActualDesktop(
                      //  SummaryShipmentDetailsActual.get(0).getShipmentItemsCustomsAndCurrency(),
                       // SummaryShipmentDetailsExpected.get(0).getShipmentItemsCustomsAndCurrency(),  "Shipment Custom value and Currency ");
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(
                        SummaryShipmentDetailsActual.get(0).getShipmentItemsHarmonizedCustomCode(),
                        SummaryShipmentDetailsExpected.get(0).getShipmentItemsHarmonizedCustomCode(),  "Shipment HS code");
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(
                        SummaryShipmentDetailsActual.get(0).getShipmentItemsManufactureCountry(),
                        SummaryShipmentDetailsExpected.get(0).getShipmentItemsManufactureCountry(),  "Shipment Country of manufacture");
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(
                        SummaryShipmentDetailsActual.get(0).getShipmentItemsPurpose(),
                        SummaryShipmentDetailsExpected.get(0).getShipmentItemsPurpose().toUpperCase(),  "Shipment purpose ");
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(
                        SummaryShipmentDetailsActual.get(0).getShipmentItemsQuantityAndUnit(),
                        SummaryShipmentDetailsExpected.get(0).getShipmentItemsQuantityAndUnit(), "Shipment Quantity");
            	//SeleniumReusableMethods.compareExpectedVSActualDesktop(
                       // SummaryShipmentDetailsActual.get(0).getShipmentItemsWeightAndUnit(),
                        //SummaryShipmentDetailsExpected.get(0).getShipmentItemsWeightAndUnit().toUpperCase(), "Shipment Weight");
            } else {
//            	SeleniumReusableMethods.compareExpectedVSActualDesktop(
//                        SummaryShipmentDetailsActual.get(0).getShipmentDocumentCustomValueAndCurrency(),
//                        SummaryShipmentDetailsExpected.get(0).getShipmentDocumentCustomValueAndCurrency(),  "Shipment Doc Custom value");
            	SeleniumReusableMethods.compareExpectedVSActualDesktop(
                        SummaryShipmentDetailsActual.get(0).getShipmentDocumentType(),
                        SummaryShipmentDetailsExpected.get(0).getShipmentDocumentType(),  "Shipment Doc Type");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception in Shipment Section");
        }
    }

    public  void validatePackageDetailsSectionMobile() {
        CopyOnWriteArrayList<SummaryPackaging> summaryPackagingActual = new  CopyOnWriteArrayList<SummaryPackaging>();
        SummaryPackaging summaryPackaging = new SummaryPackaging();
        try {
            waitForElement(summaryCardObjectsPackagingDetails.summaryPackageComponent);
            summaryPackaging.setPackageNumberXType(getText(summaryCardObjectsPackagingDetails.summaryPackageNumber));
            if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDimensions)) {
                summaryPackaging.setPackageDimensionsAndUnit(getText(summaryCardObjectsPackagingDetails.summaryPackageDimensions));
            }
            summaryPackaging.setPackageWeightAndUnit(getText(summaryCardObjectsPackagingDetails.summaryPackageWeight));
            if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDeclaredValue)) {
                summaryPackaging.setPackageDeclaredValueAndCurrency(getText(summaryCardObjectsPackagingDetails.summaryPackageDeclaredValue));
            }
            summaryPackagingActual.add(summaryPackaging);
            CopyOnWriteArrayList<SummaryPackaging> summaryPackagingExpected = summaryPageObjects.summaryPackagingExpectedDataMobile;
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageNumberXType(), summaryPackagingExpected.get(0).getPackageNumberXType(), "Package Count and Type");
            if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDimensions)) {
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageDimensionsAndUnit(), summaryPackagingExpected.get(0).getPackageDimensionsAndUnit(), "Package Dimension and Unit");
            }
            SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageWeightAndUnit(), summaryPackagingExpected.get(0).getPackageWeightAndUnit(), "Package Weight and Unit");
            if (elementisDisplayedAndEnabled(summaryCardObjectsPackagingDetails.summaryPackageDeclaredValue)) {
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryPackagingActual.get(0).getPackageDeclaredValueAndCurrency(), summaryPackagingExpected.get(0).getPackageDeclaredValueAndCurrency(), "Package Declared Value and Currency");
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
}
