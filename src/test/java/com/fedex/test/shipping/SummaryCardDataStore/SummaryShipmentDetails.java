package com.fedex.test.shipping.SummaryCardDataStore;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;

public class SummaryShipmentDetails extends Wrappers{

	    private String shipmentType;
	    private String shipmentItemsPurpose;
	    private String shipmentItemsDescription;
	    private String shipmentItemsQuantityAndUnit;
	    private String shipmentItemsWeightAndUnit;
	    private String shipmentItemsCustomsAndCurrency;
	    private String shipmentItemsManufactureCountry;
	    private String shipmentItemsHarmonizedCustomCode;
	    private String shipmentDocumentType;
	    private String shipmentDocumentCustomValueAndCurrency;

	    public String getShipmentType() {
	        return shipmentType;
	    }

	    public void setShipmentType(String shipmentType) {
	        this.shipmentType = shipmentType;
	    }

	    public String getShipmentItemsPurpose() {
	        return shipmentItemsPurpose;
	    }

	    public void setShipmentItemsPurpose(String shipmentItemsPurpose) {
	        this.shipmentItemsPurpose = shipmentItemsPurpose;
	    }

	    public String getShipmentItemsDescription() {
	        return shipmentItemsDescription;
	    }

	    public void setShipmentItemsDescription(String shipmentItemsDescription) {
	        this.shipmentItemsDescription = shipmentItemsDescription;
	    }

	    @Override
	    public String toString() {
	        return "SummaryShipmentDetails{" +
	                "shipmentType='" + shipmentType + '\'' +
	                ", shipmentItemsPurpose='" + shipmentItemsPurpose + '\'' +
	                ", shipmentItemsDescription='" + shipmentItemsDescription + '\'' +
	                ", shipmentItemsQuantityAndUnit='" + shipmentItemsQuantityAndUnit + '\'' +
	                ", shipmentItemsWeightAndUnit='" + shipmentItemsWeightAndUnit + '\'' +
	                ", shipmentItemsCustomsAndCurrency='" + shipmentItemsCustomsAndCurrency + '\'' +
	                ", shipmentItemsManufactureCountry='" + shipmentItemsManufactureCountry + '\'' +
	                ", shipmentItemsHarmonizedCustomCode='" + shipmentItemsHarmonizedCustomCode + '\'' +
	                ", shipmentDocumentType='" + shipmentDocumentType + '\'' +
	                ", shipmentDocumentCustomValueAndCurrency='" + shipmentDocumentCustomValueAndCurrency + '\'' +
	                '}';
	    }

	    public String getShipmentItemsQuantityAndUnit() {
	        return shipmentItemsQuantityAndUnit;
	    }

	    public void setShipmentItemsQuantityAndUnit(String shipmentItemsQuantityAndUnit) {
	        this.shipmentItemsQuantityAndUnit = shipmentItemsQuantityAndUnit;
	    }

	    public String getShipmentItemsWeightAndUnit() {
	        return shipmentItemsWeightAndUnit;
	    }

	    public void setShipmentItemsWeightAndUnit(String shipmentItemsWeightAndUnit) {
	        this.shipmentItemsWeightAndUnit = shipmentItemsWeightAndUnit;
	    }

	    public String getShipmentItemsCustomsAndCurrency() {
	        return shipmentItemsCustomsAndCurrency;
	    }

	    public void setShipmentItemsCustomsAndCurrency(String shipmentItemsCustomsAndCurrency) {
	        this.shipmentItemsCustomsAndCurrency = shipmentItemsCustomsAndCurrency;
	    }

	    public String getShipmentItemsManufactureCountry() {
	        return shipmentItemsManufactureCountry;
	    }

	    public void setShipmentItemsManufactureCountry(String shipmentItemsManufactureCountry) {
	        this.shipmentItemsManufactureCountry = shipmentItemsManufactureCountry;
	    }

	    public String getShipmentItemsHarmonizedCustomCode() {
	        return shipmentItemsHarmonizedCustomCode;
	    }

	    public void setShipmentItemsHarmonizedCustomCode(String shipmentItemsHarmonizedCustomCode) {
	        this.shipmentItemsHarmonizedCustomCode = shipmentItemsHarmonizedCustomCode;
	    }

	    public String getShipmentDocumentType() {
	        return shipmentDocumentType;
	    }

	    public void setShipmentDocumentType(String shipmentDocumentType) {
	        this.shipmentDocumentType = shipmentDocumentType;
	    }

	    public String getShipmentDocumentCustomValueAndCurrency() {
	        return shipmentDocumentCustomValueAndCurrency;
	    }

	    public void setShipmentDocumentCustomValueAndCurrency(String shipmentDocumentCustomValueAndCurrency) {
	        this.shipmentDocumentCustomValueAndCurrency = shipmentDocumentCustomValueAndCurrency;
	    }

	    ShipmentDetailsObjects ShipmentDetails=new ShipmentDetailsObjects();
	    ShipmentDetailsNonDocObjects ShipmentDetailsNonDocObjects =new ShipmentDetailsNonDocObjects();
	    
	    public  CopyOnWriteArrayList<SummaryShipmentDetails> storeDesktopShipmentDetails() {
			CopyOnWriteArrayList<SummaryShipmentDetails> summaryShipmentDetailsStore = new CopyOnWriteArrayList<>();
	        try {
	            SummaryShipmentDetails summaryShipmentDetails = new SummaryShipmentDetails();
//	            R_Sel.scrollToViewElement(D_ShipmentDetails.documents);
	            if(elementisDisplayedAndEnabled(ShipmentDetails.shipdocType)){
	                summaryShipmentDetails.setShipmentType("Document");
	                if (elementisDisplayedAndEnabled(ShipmentDetails.otherTypeDocumentdescription)) {
	                    summaryShipmentDetails.setShipmentDocumentType(getTextInUserInputElement(
	                    		ShipmentDetails.otherTypeDocumentdescription));
	                } else {
	                    summaryShipmentDetails.setShipmentDocumentType(getTextInSelectElement(ShipmentDetails.shipdocType));
	                }
	                String currencyCode = getTextInUserInputElement(ShipmentDetails.documentCustomscurrency);
	                summaryShipmentDetails.setShipmentDocumentCustomValueAndCurrency(
	                		SeleniumReusableMethods.getCurrencySymbol(currencyCode)
	                                + getTextInUserInputElement(ShipmentDetails.documentCustomsvalue)+ " " + currencyCode);
	            } else {
	                summaryShipmentDetails.setShipmentType("items");
	                String currencyCode = getTextInUserInputElement(ShipmentDetailsNonDocObjects.shipmentCurrencyperItem_0);
	                summaryShipmentDetails.setShipmentItemsPurpose(getTextInSelectElement(
	                		ShipmentDetailsNonDocObjects.shipmentpurpose ));
	                summaryShipmentDetails.setShipmentItemsDescription(getTextInUserInputElement(
	                		ShipmentDetailsNonDocObjects.itemDescriptioninput));
	                summaryShipmentDetails.setShipmentItemsHarmonizedCustomCode(getTextInUserInputElement(
	                		ShipmentDetailsNonDocObjects.harmonizedCodeinput));
	                summaryShipmentDetails.setShipmentItemsManufactureCountry(getTextInUserInputElement(
	                		ShipmentDetailsNonDocObjects.shipmentCountryOfmanufacture));
	                summaryShipmentDetails.setShipmentItemsCustomsAndCurrency(
	                		SeleniumReusableMethods.getCurrencySymbol(currencyCode)
	                                + getTextInUserInputElement(ShipmentDetailsNonDocObjects.shipmentItemCustomsvalue)
									+ " " + currencyCode);;
	                summaryShipmentDetails.setShipmentItemsQuantityAndUnit(getTextInUserInputElement(
	                		ShipmentDetailsNonDocObjects.shipmentquantity )
	                        + " " + getTextInUserInputElement(ShipmentDetailsNonDocObjects.shipmentpieces));
	                summaryShipmentDetails.setShipmentItemsWeightAndUnit(
	                		getTextInUserInputElement(ShipmentDetailsNonDocObjects.shipmentweight)
	                                + " " + getTextInUserInputElement(ShipmentDetailsNonDocObjects.shipmentWperItem_0));
	            }
	            summaryShipmentDetailsStore.add(summaryShipmentDetails);
	        } catch (Exception e) {
				e.printStackTrace();
	            Assert.fail();

	        }
	        return summaryShipmentDetailsStore;
	    }
}
