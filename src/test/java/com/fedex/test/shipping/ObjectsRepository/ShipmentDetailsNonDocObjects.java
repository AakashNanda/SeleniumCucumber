package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ShipmentDetailsNonDocObjects extends LoadableComponent<ShipmentDetailsNonDocObjects> {

	 public final static String shipmentCurrencyPerItem_0 = "currencyFormName";
	 public final static String shipmentPurpose = "shipmentPurpose";
	 public final static String itemDescriptionInput = "//input[@name='itemDescription']";
	 public final static String harmonizedCodeInput = "//input[@name='harmonizedCode']";
	 public final static String shipmentCountryOfManufacture = "countryOfManufacture";
	 public final static String shipmentItemCustomsValue = "itemCustomsValue";
	 public final static String shipmentQuantity = "//input[@name='quantity']";
	 public final static String shipmentPieces = "//select[@name='quantityUnit']";
	 public final static String shipmentWeight = "weight";
	 public final static String shipmentWPerItem_0 = "[name=weight]";
	 public final static String hsCodeMinerror = "//*[contains(text(),'Harmonized code must be at least 6 digits.')]";
	 public final static String packageDetaillink = "//a[@class='error-link']";

	  @FindBy(id = ShipmentDetailsNonDocObjects.shipmentPurpose)
	    public  WebElement shipmentpurpose;
	
	 @FindBy(id = ShipmentDetailsNonDocObjects.shipmentCurrencyPerItem_0)
	    public  WebElement shipmentCurrencyperItem_0;
	 
	 @FindBy(xpath = ShipmentDetailsNonDocObjects.itemDescriptionInput)
	    public  WebElement itemDescriptioninput;
	 
	 @FindBy(xpath = harmonizedCodeInput)
	    public  WebElement harmonizedCodeinput;
	 
	 @FindBy(id = ShipmentDetailsNonDocObjects.shipmentCountryOfManufacture)
	    public  WebElement shipmentCountryOfmanufacture;
	 
	 @FindBy(id = ShipmentDetailsNonDocObjects.shipmentItemCustomsValue)
	    public  WebElement shipmentItemCustomsvalue;
	 
	 @FindBy(xpath = ShipmentDetailsNonDocObjects.shipmentQuantity)
	    public  WebElement shipmentquantity;
	 
	 @FindBy(xpath = ShipmentDetailsNonDocObjects.shipmentPieces)
	    public  WebElement shipmentpieces;
	 
	 @FindBy(name = ShipmentDetailsNonDocObjects.shipmentWeight)
	    public  WebElement shipmentweight;
	 
	 @FindBy(css = ShipmentDetailsNonDocObjects.shipmentWPerItem_0)
	    public  WebElement shipmentWperItem_0;

	@FindBy(xpath = ShipmentDetailsNonDocObjects.hsCodeMinerror)
	   public WebElement hsCodeMinError;
	
	@FindBy(xpath =packageDetaillink)
    public  WebElement packageDetailLink;

	
	
	 public ShipmentDetailsNonDocObjects(){
	        PageFactory.initElements(DriverGenerator.getDriver(),this);
	    }

	  @Override
	    protected void load() {
	    }

	    @Override
	    protected void isLoaded() throws Error {

	    }
	    

}
