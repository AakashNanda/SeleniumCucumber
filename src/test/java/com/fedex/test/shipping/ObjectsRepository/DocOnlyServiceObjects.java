package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DocOnlyServiceObjects {


    
    public final static String toContinue="address-form-save";
    public final static String serviceDisclaimer = "divRateDisclaimer_breakdown";
    public final static String shipmentPieces = "//select[@name='quantityUnit']";
    public final static String amountsShown = "amountsShown";
    public final static String loadingIndicatorServiceSection = "fdx-c-loading-indicator__part";
    public final static String summaryDeliveryEdit = "summaryDeliveryEdit";
    public final static String summaryDeliveryHeading = "summaryDeliveryHeading";

   

    @FindBy(id = toContinue)
    public WebElement tocontinue;

    @FindBy(id = serviceDisclaimer)
    public WebElement servicedisclaimer;

    @FindBy(xpath = shipmentPieces)
    public WebElement shipmentpieces;

    @FindBy(id = amountsShown)
    public WebElement amountsshown;

    @FindBy(id = summaryDeliveryEdit)
    public WebElement summaryDeliveryedit;

    @FindBy(id = summaryDeliveryHeading)
    public WebElement summaryDeliveryheading;

    @FindBy(className = loadingIndicatorServiceSection)
    public List<WebElement> loadingIndicatorServicesection;

    public DocOnlyServiceObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }


}
