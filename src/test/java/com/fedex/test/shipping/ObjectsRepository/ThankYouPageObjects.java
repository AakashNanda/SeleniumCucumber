package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public class ThankYouPageObjects extends LoadableComponent<ThankYouPageObjects> {

    public final static String printDocButton = "printDocumentsButton";
    public final static String CloseBtn = "//*[@class='fdx-c-button fdx-c-button--secondary-outline fdx-u-m--7 ng-star-inserted']";
    public final static String commercialInvoiceheading = "commercialInvoiceHeading";
    public final static String confirmationheader = "confirmationPageHeading";
    public final static String pickupConfirmationNumber = "pickupConfirmationNumber";
    public final static String createAnotherShipmentbutton = "createAnotherShipmentButton";
    public final static String trackingNumber = "trackingNumber";
    public final static String printInvoiceDesctext = "printInvoiceDescText";
    public final static String printInvoiceCheckboxlabel = "printInvoiceCheckboxLabel";
    public final static String confirmationPrintSectionSubheading = "confirmationPrintSectionSubHeading";
    public final static String confirmationPrintSectionheading = "confirmationPrintSectionHeading";
    public final static String commercialnoRadio = "commercialNoRadioLabel";
    public final static String commercialImportantmessage = "commercialImportantMessage";
    public final static String printLabelDesctext = "printLabelDescText";
    public final static String pickupOrDropOfftext = "pickupOrDropOffText";
    public final static String pickupConfirmationTrackSectionheading = "pickupConfirmationTrackSectionHeading";
    public final static String dropOfftext = "dropOffText";
    public final static String dropOffTextdec = "dropOffTextDec";
    public final static String printLabelDesclink = "printLabelDescLink";
    public final static String alreadySchedulePickUptext = "alreadySchedulePickUpText";
    public final static String alreadyScheduleTextPickUpdec = "alreadyScheduleTextPickUpDec";
    public final static String printLabelCheckboxlabel = "printLabelCheckboxLabel";
    public final static String confirmationTrackSectionheading = "confirmationTrackSectionHeading";
    public final static String trackingNumberdesc = "trackingNumberDesc";
    public final static String Closebuttonpopup="//*[@id=\'fedex-mags-app\']/fx-mags-root/fdx-purple-engine/fx-mags-error-modal/div[2]/div/div";
    public final static String Headermessage = "HeaderMessage";
    public final static String Errordescription = "ErrorDescription";
    public final static String icon = "Icon";
    public final static String pickupConfirmationerror = "pickupConfirmationError";
    public final static String printInvoiceDescLink = "printInvoiceDescLink";


    @FindBy(id = printInvoiceDescLink)
    public WebElement printInvoiceDescLinkEl;

    @FindBy(id = printDocButton)
    public WebElement printDocumentsButton;

    @FindBy(xpath = CloseBtn)
    public WebElement CloseButton;

    @FindBy(id = commercialInvoiceheading)
    public WebElement commercialInvoiceHeading;

    @FindBy(id = confirmationheader)
    public WebElement confirmationHeader;

    @FindBy(id = pickupConfirmationNumber)
    public WebElement pickupConfirmationnumber;

    @FindBy(id = createAnotherShipmentbutton)
    public WebElement createAnothershipmentButton;

    @FindBy(id = trackingNumber)
    public WebElement trackingnumber;

    @FindBy(id = printInvoiceDesctext)
    public WebElement printInvoiceDescText;

    @FindBy(id = printInvoiceCheckboxlabel)
    public List<WebElement> printInvoiceCheckboxLabel;

    @FindBy(id = printLabelCheckboxlabel)
    public List<WebElement> printLabelCheckboxLabel;

    @FindBy(id = confirmationPrintSectionSubheading)
    public WebElement confirmationPrintSectionSubHeading;

    @FindBy(id = confirmationPrintSectionheading)
    public WebElement confirmationPrintSectionHeading;

    @FindBy(id = commercialnoRadio)
    public WebElement commercialNoRadio;

    @FindBy(id = commercialImportantmessage)
    public WebElement commercialImportantMessage;

    @FindBy(id = printLabelDesctext)
    public WebElement printLabelDescText;

    @FindBy(id = pickupOrDropOfftext)
    public WebElement pickupOrDropOffText;


    @FindBy(id = pickupConfirmationTrackSectionheading)
    public WebElement pickupConfirmationTrackSectionHeading;

    @FindBy(id = dropOfftext)
    public  WebElement dropOffText;

    @FindBy(id = dropOffTextdec)
    public  WebElement dropOffTextDec;

    @FindBy(id = alreadySchedulePickUptext)
    public  WebElement alreadySchedulePickUpText;

    @FindBy(id = alreadyScheduleTextPickUpdec)
    public  WebElement alreadyScheduleTextPickUpDec;

    @FindBy(id = printLabelDesclink)
    public  WebElement printLabelDescLink;

    @FindBy(id = confirmationTrackSectionheading)
    public  WebElement confirmationTrackSectionHeading;

    @FindBy(id = trackingNumberdesc)
    public  WebElement trackingNumberDesc;

    @FindBy(xpath = Closebuttonpopup)
    public  WebElement CloseButtonpopup;

    @FindBy(id = Headermessage)
    public WebElement HeaderMessage;

    @FindBy(id = Errordescription)
    public WebElement ErrorDescription;

    @FindBy(id = icon)
    public WebElement Icon;

    @FindBy(id = pickupConfirmationerror)
    public WebElement pickupConfirmationError;


    public ThankYouPageObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
