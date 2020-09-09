package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryModalWindowObjects {

    public final static String summaryModalheading = "summaryModalHeading";
    public final static String summaryModalServiceHeading = "summaryModalServiceHeading";
    public final static String summaryModalServiceName = "summaryModalServiceName";
    public final static String shipmentDetailsPackageDesc = "shipmentDetailsPackageDesc";
    public final static String shipmentDetailsPackageCount = "shipmentDetailsPackageCount";
    public final static String summaryModalSenderName = "summaryModalSenderName";
    public final static String summaryModalFinalizeShipmentButton = "finaliseShipmentButton";
    public final static String summaryModalCloseIcon = "closeIcon";
    public final static String summaryModalMakeChanges = "makeChanges";
    public final static String summaryModalRecipientName = "summaryModalRecipientName";
    public final static String summaryModalTransportationBill = "summaryModalTransportationBill";
    public final static String summaryModalDutiesBill = "summaryModalDutiesBill";
    public final static String summayModalLegalStatement = "summayModalLegalStatement";
    public final static String addressDetailsTo = "addressDetailsTo";
    public final static String summaryModalRecipientStreet = "summaryModalRecipientStreet";
    public final static String summaryModalRecipientPostalState = "summaryModalRecipientPostalState";
    public final static String summaryModalRecipientCountry = "summaryModalRecipientCountry";
    public final static String addressDetailsFrom = "addressDetailsFrom";
    public final static String summaryModalSenderStreet = "summaryModalSenderStreet";
    public final static String summaryModalSenderPostalCity = "summaryModalSenderPostalCity";
    public final static String summaryModalSenderCountry = "summaryModalSenderCountry";
    public final static String summaryModalSenderCompany = "summaryModalSenderCompany";
    public final static String summaryModalRecipientCompany = "summaryModalRecipientCompany";
    public final static String summaryModalFromToheader = "summaryModalFromToHeader";
    public final static String shipmentDetailsheader = "shipmentDetailsHeader";
    public final static String nonIntraeuLegal = "nonIntraEuLegal";
    public final static String intraEulegal = "intraEuLegal";
    public final static String summayModalLegalstatement = "summayModalLegalStatement";
    public final static String Errordescription = "ErrorDescription";


    @FindBy(id = summaryModalheading)
    public  WebElement summaryModalHeading;
    
    @FindBy(id = summaryModalFromToheader)
    public  WebElement summaryModalFromToHeader;

    @FindBy(id = shipmentDetailsheader)
    public WebElement shipmentDetailsHeader;

    @FindBy(id = nonIntraeuLegal)
    public WebElement nonIntraEuLegal;

    @FindBy(id = intraEulegal)
    public WebElement intraEuLegal;

    @FindBy(id = summayModalLegalstatement)
    public WebElement summaryModalLegalStatement;

    @FindBy(id = Errordescription)
    public  WebElement ErrorDescription;





    @FindBy(id = summaryModalServiceHeading)
    public  WebElement summaryModalServiceheading;

    @FindBy(id = summaryModalServiceName)
    public  WebElement summaryModalServicename;

    @FindBy(id = shipmentDetailsPackageDesc)
    public  WebElement shipmentDetailsPackagedesc;

    @FindBy(id = shipmentDetailsPackageCount)
    public  WebElement shipmentDetailsPackagecount;

    @FindBy(id = summaryModalSenderName)
    public  WebElement summaryModalSendername;

    @FindBy(id = summaryModalFinalizeShipmentButton)
    public  WebElement summaryModalFinalizeShipmentbutton;

    @FindBy(id = summaryModalCloseIcon)
    public  WebElement summaryModalCloseicon;

    @FindBy(id = summaryModalMakeChanges)
    public  WebElement summaryModalMakechanges;

    @FindBy(id = summaryModalRecipientName)
    public  WebElement summaryModalRecipientname;

    @FindBy(id = summaryModalTransportationBill)
    public  WebElement summaryModalTransportationbill;

    @FindBy(id = summaryModalDutiesBill)
    public  WebElement summaryModalDutiesbill;

    @FindBy(id = summayModalLegalStatement)
    public  WebElement summaryModalLegalstatement;

    @FindBy(id = addressDetailsTo)
    public  WebElement addressDetailsto;

    @FindBy(id = summaryModalRecipientStreet)
    public  WebElement summaryModalRecipientstreet;

    @FindBy(id = summaryModalRecipientPostalState)
    public  WebElement summaryModalRecipientPostalstate;

    @FindBy(id = summaryModalRecipientCountry)
    public  WebElement summaryModalRecipientcountry;

    @FindBy(id = addressDetailsFrom)
    public  WebElement addressDetailsfrom;

    @FindBy(id = summaryModalSenderStreet)
    public  WebElement summaryModalSenderstreet;

    @FindBy(id = summaryModalSenderPostalCity)
    public  WebElement summaryModalSenderPostalcity;

    @FindBy(id = summaryModalSenderCountry)
    public  WebElement summaryModalSendercountry;

    @FindBy(id = summaryModalSenderCompany)
    public  WebElement summaryModalSendercompany;

    @FindBy(id = summaryModalRecipientCompany)
    public  WebElement summaryModalRecipientcompany;



    public SummaryModalWindowObjects() {
        PageFactory.initElements(DriverGenerator.getDriver(), this);
    }

}