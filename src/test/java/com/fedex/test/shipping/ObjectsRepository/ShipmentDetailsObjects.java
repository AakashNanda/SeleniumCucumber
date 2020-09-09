package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.util.List;

public class ShipmentDetailsObjects extends LoadableComponent<ShipmentDetailsObjects>{
	
	public final static String shipDocType = "documentType";
	public final static String otherTypeDocumentDescription = "otherTypeDocumentDescription";
	public final static String documentCustomsCurrency = "currencyFormName";
	public final static String documentCustomsValue = "documentCustomsValue";
	public final static String shipmentDetailsHeading = "shipmentDetailsHeading";
	
	@FindBy(id = documentCustomsValue)
    public  WebElement documentCustomsvalue;
	
	@FindBy(id = documentCustomsCurrency)
    public  WebElement documentCustomscurrency;
	
	@FindBy(id = otherTypeDocumentDescription)
    public  WebElement otherTypeDocumentdescription;
	
	@FindBy(id = shipDocType)
    public  WebElement shipdocType;
	
	@FindBy(id = shipmentDetailsHeading)
    public  WebElement shipmentDetailsheading;
	
	  public ShipmentDetailsObjects(){
	        PageFactory.initElements(DriverGenerator.getDriver(),this);
	    }

	  @Override
	    protected void load() {
	    }

	    @Override
	    protected void isLoaded() throws Error {

	    }
	    
}
