package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPackaging;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPayment;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPickUpDropOff;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryRateService;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryShipmentDetails;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryAltPickup;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryFrom;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryTo;

import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SummaryPageObjects extends LoadableComponent<SummaryPageObjects> {

    public static JSONObject loadTextsForCurrentLocale;

    /*************DATA STORE******************/

    /*public static ArrayList<SummaryPackaging> summaryFromExpectedData;
    public static ArrayList<SummaryPackaging> summaryToExpectedData;
    public static ArrayList<SummaryPackaging> summaryAltPickupData;*/
    public CopyOnWriteArrayList<SummaryPackaging> summaryPackagingExpectedData;
    public CopyOnWriteArrayList<SummaryPackaging> summaryPackagingExpectedDataMobile;
    public CopyOnWriteArrayList<SummaryRateService> summaryDeliveryExpectedData;
    public CopyOnWriteArrayList<SummaryRateService> summaryDeliveryExpectedDataMobile;
    public CopyOnWriteArrayList<SummaryPayment> summaryPaymentExpectedData;
    public CopyOnWriteArrayList<SummaryFrom> summaryFromExpectedData;
    public CopyOnWriteArrayList<SummaryTo> summaryToExpectedData;
    public CopyOnWriteArrayList<SummaryShipmentDetails> summaryShipmentDetailsExpectedData;
    public CopyOnWriteArrayList<SummaryPickUpDropOff> summaryPickUpDropOffExpectedData;
    public CopyOnWriteArrayList<SummaryAltPickup> summaryAltPickupData;
    
   //public static ArrayList<SummaryRateService> summaryDeliveryExpectedData;
    /*public static ArrayList<SummaryPackaging> summaryShipmentDetailsExpectedData;
    public static ArrayList<SummaryPackaging> summaryDeliveryExpectedData;
    public static ArrayList<SummaryPackaging> summaryPickUpDropOffExpectedData;
    public static ArrayList<SummaryPackaging> summaryPaymentExpectedData;*/

    /*************DATA STORE******************/

    /*************Summary Page Objects******************/

    public final static String summarysubmit = "confirmButtonId";
    public final static String summarymodalHeading = "summaryModalHeading";
    public final static String summarymodalFinalizeShipmentButton = "finaliseShipmentButton";
    public final static String termsAndConditions = "#summayModalLegalStatement > a:nth-child(2)";
    public final static String termsOfUse = "#summayModalLegalStatement > a:nth-child(1)";
    public final static String intraEuTermsOfUse = "#nonIntraEuLegal > a:nth-child(1)";
    public final static String intraEuConditionsOfCarriage = "#nonIntraEuLegal > a:nth-child(2)";
    public final static String summaryCustomsComponent = "summaryCustomsComponent";
    public final static String summaryCustomShipmentPurposeLabel = "summaryCustomShipmentPurposeLabel";
    public final static String summaryCustomType = "summaryCustomType";
    public final static String summaryCustomShipmentPurposeValue = "summaryCustomShipmentPurposeValue";
    public final static String summaryCustomHCCode = "summaryCustomHCCode";
    public final static String summaryCustomManufacturedIn = "summaryCustomManufacturedIn";
    public final static String summaryCustomCustomsValue = "summaryCustomCustomsValue";
    public final static String summaryCustomDescription = "summaryCustomDescription";
    public final static String summaryCustomWeight = "summaryCustomWeight";
    public final static String summaryCustomDocType = "summaryCustomShipDocTypeLabel";
    public final static String summaryCustomShipDocTypeValue = "summaryCustomShipDocTypeValue";
    public final static String summaryCustomCustomsDocTypeValue = "summaryCustomCustomsDocTypeValue";
    public final static String summaryPickupDateAndTime = "summaryPickupDateAndTime";
    public final static String summaryPickupInstructions = "summaryPickupInstructions";
    public final static String summaryDropOffInstructions = "summaryDropOffInstructions";
    public final static String summaryPreScheduledInstructions = "summaryPreScheduledInstructions";
    public final static String summaryPickupInstructionLabel = "summaryPickupInstructionLabel";
    public final static String summaryPaymentBillingTransportationType = "summaryPaymentBillingTransportationType";
    public final static String summaryPaymentBillTo = "summaryPaymentBillTo";
    public final static String summaryPaymentAccNum = "summaryPaymentAccNum";
    public final static String summaryPaymentReference = "summaryPaymentReference";
    public final static String summaryPaymentBillToLabel = "summaryPaymentBillToLabel";
    public final static String summaryPaymentFAccNumber = "summaryPaymentFAccNumber";
    public final static String summaryModalMakeChanges = "makeChanges";
    public final static String summaryDeliveryEdit = "summaryDeliveryEdit";
    public final static String summaryFromAltOpenEdit = "summaryFromAltEdit";
    public final static String summaryAltAddressName = "summaryAltAddressName";
    public final static String summaryAltAddressAptSuite = "summaryAltAddressAptSuite";
    public final static String summaryAltAddressStreetLine = "summaryAltAddressStreetLine";
    public final static String summaryAltAddressPostalStateCity = "summaryAltAddressPostalStateCity";
    public final static String summaryAltAddressPostalCity = "summaryAltAddressPostalStateCity";
    public final static String summaryAltAddressCountry = "summaryAltAddressCountry";
    public final static String summaryAltAddressPhone = "summaryAltAddressPhone";
    public final static String summaryAltAddressHeading = "summaryAltAddressHeading";
    public final static String priceBreakdownTitle = "priceBreakdownTitle";
    public final static String summaryBillingTransportationType = "summaryBillingTransportationType";
    public final static String summaryBillTo = "summaryBillTo";
    public final static String summaryBillingDutiesTaxesDescription = "summaryBillingDutiesTaxesDescription";
   
   
    
    @FindBy(id = summarysubmit)
    public WebElement summarySubmit;

    @FindBy(id = summarymodalHeading)
    public WebElement summaryModalHeading;

    @FindBy(id = summarymodalFinalizeShipmentButton)
    public WebElement summaryModalFinalizeShipmentButton;

    @FindBy(css = termsOfUse)
    public WebElement termsOfuse;

    @FindBy(css = termsAndConditions)
    public WebElement termsAndconditions;


    @FindBy(css = intraEuTermsOfUse)
    public WebElement intraEuTermsOfuse;

    @FindBy(css = intraEuConditionsOfCarriage)
    public WebElement intraEuConditionsOfCarriages;


    @FindBy(id =summaryCustomsComponent)
    public  WebElement summaryCustomscomponent;
    
    @FindBy(id = summaryCustomShipmentPurposeLabel)
    public  WebElement summaryCustomShipmentpurposeLabel;
    
    @FindBy(id = summaryCustomType)
    public  WebElement summaryCustomtype;
    
    @FindBy(id =summaryCustomShipmentPurposeValue)
    public  WebElement summaryCustomShipmentPurposevalue;
    
    @FindBy(id = summaryCustomHCCode)
    public  WebElement summaryCustomHCcode;
    
    @FindBy(id = summaryCustomManufacturedIn)
    public  WebElement summaryCustomManufacturedin;
    
    @FindBy(id = summaryCustomCustomsValue)
    public  WebElement summaryCustomCustomsvalue;
    
    @FindBy(id = summaryCustomDescription)
    public  WebElement summaryCustomdescription;
    
    @FindBy(id = summaryCustomWeight)
    public  WebElement summaryCustomweight;
    
    @FindBy(id = summaryCustomDocType)
    public  WebElement summaryCustomdocType;
    
    @FindBy(id = summaryCustomShipDocTypeValue)
    public  WebElement summaryCustomShipDocTypevalue;
    
    @FindBy(id = summaryCustomCustomsDocTypeValue)
    public  WebElement summaryCustomCustomsDocTypevalue;
    
    @FindBy(id = summaryPickupDateAndTime)
    public  WebElement summaryPickupDateAndtime;
    
    @FindBy(id = summaryPickupInstructions)
    public  WebElement summaryPickupinstructions;
    
    @FindBy(id = summaryDropOffInstructions)
    public  WebElement summaryDropOffinstructions;
    
    @FindBy(id = summaryPreScheduledInstructions)
    public  WebElement summaryPreScheduledinstructions;
    
    @FindBy(id = summaryPickupInstructionLabel)
    public  WebElement summaryPickupInstructionlabel;
    
    @FindBy(id = summaryPaymentBillingTransportationType)
    public  WebElement summaryPaymentBillingTransportationtype;
    
    @FindBy(id = summaryPaymentBillTo)
    public  WebElement summaryPaymentBillto;
    
    @FindBy(id = summaryPaymentAccNum)
    public  WebElement summaryPaymentAccnum;
    
    @FindBy(id = summaryPaymentReference)
    public  WebElement summaryPaymentreference;
    
    @FindBy(id = summaryPaymentBillToLabel)
    public  WebElement summaryPaymentBillTolabel;
    
    @FindBy(id = summaryPaymentFAccNumber)
    public  WebElement summaryPaymentFAccnumber;
    
    @FindBy(id = summaryModalMakeChanges)
    public  WebElement summaryModalMakechanges;
    
    @FindBy(id = summaryDeliveryEdit)
    public  WebElement summaryDeliveryedit;
    
    @FindBy(id = summaryFromAltOpenEdit)
    public  WebElement summaryFromAltOpenedit;
    
    @FindBy(id = summaryAltAddressName)
    public  WebElement summaryAltAddressname;
    
    @FindBy(id = summaryAltAddressAptSuite)
    public  WebElement summaryAltAddressAptsuite;
    
    @FindBy(id = summaryAltAddressStreetLine)
    public  WebElement summaryAltAddressStreetline;
    
    @FindBy(id = summaryAltAddressPostalStateCity)
    public  WebElement summaryAltAddressPostalStatecity;
    
    @FindBy(id = summaryAltAddressPostalCity)
    public  WebElement summaryAltAddressPostalcity;
    
    @FindBy(id = summaryAltAddressCountry)
    public  WebElement summaryAltAddresscountry;
    
    @FindBy(id = summaryAltAddressPhone)
    public  WebElement summaryAltAddressphone;
    
    @FindBy(id = summaryAltAddressHeading)
    public  WebElement summaryAltAddressheading;
    
    @FindBy(id = priceBreakdownTitle)
    public  WebElement priceBreakdowntitle;
    
    @FindBy(id = summaryBillingTransportationType)
    public  WebElement summaryBillingTransportationtype;
    
    @FindBy(id =summaryBillTo)
    public  WebElement summaryBillto;
    
    @FindBy(id = summaryBillingDutiesTaxesDescription)
    public  WebElement summaryBillingDutiesTaxesdescription;


    public SummaryPageObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }


    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
    
}
