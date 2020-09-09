package com.fedex.test.shipping.ObjectsRepository;



import java.io.IOException;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.json.JSONException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.openqa.selenium.support.PageFactory;


public class SummaryCardObjectsRateServiceDetails  {
	public final static String summaryDeliveryHeading = "summaryDeliveryHeading";
    public final static String summaryDeliveryServiceType = "summaryDeliveryServiceType";
    public final static String summaryDeliverySelectedFedExService = "//*[contains(text(),'FedEx International')]";
    public final static String summaryDeliveryTimeAndServiceType = "summaryDeliveryTimeAndServiceType";
    public final static String summaryDeliveryAdditionalOptions = "summaryDelvAdditionalOptions";
    public final static String summaryDeliveryAdditionalOptionsLabel = "summaryDelvAdditionalOptionsLabel";
    
    @FindBy(id = summaryDeliveryHeading)
    public WebElement summarydeliveryHeading;

    @FindBy(id = summaryDeliveryServiceType)
    public WebElement summarydeliveryServiceType;
    
    @FindBy(xpath = summaryDeliverySelectedFedExService)
    public WebElement summaryDeliveryselectedFedExService;
    
    @FindBy(id = summaryDeliveryTimeAndServiceType)
    public WebElement summaryDeliveryTimeAndserviceType;
    
    @FindBy(id = summaryDeliveryAdditionalOptions)
    public WebElement summaryDeliveryAdditionaloptions;
    
    @FindBy(id = summaryDeliveryAdditionalOptionsLabel)
    public WebElement summaryDeliveryAdditionaloptionsLabel;


    public SummaryCardObjectsRateServiceDetails(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }

}
