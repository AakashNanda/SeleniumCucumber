package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class PickUpAndDropOffObjects extends LoadableComponent<PickUpAndDropOffObjects> {

    public final static String pickUpDropOffSelect = "pickUpDropOffSelection";
    public final static String pickupSubmit = "pickUpContinue";
    public final static String summaryPickUpEdit = "summaryPickupEdit";
    public final static String specialInstructionsASCIIerror = "pickUpInstrInputSpecialCharacterError";
    public final static String pickUpInstrselect = "pickUpInstrSelect";
    public final static String pickUpInstrInputFormcontrol = "pickUpInstrInputFormControl";
    public final static String pickupDetailsCancel = "pickupDetailsCancel";
    public final static String pickUpUpdate = "pickUpUpdate";
    public final static String pickUpDropOffHeading = "pickUpdropOffHeading";
    public final static String pickUpReadyTimeSelection = "pickUpReadyTimeSelection";
    public final static String dropOffPreSelection = "//*[@id='pickUp-dropOffComponent']/div/div[2]/div/div[1]/div";
    public final static String pickUpLatestTimeAvailableSelection = "pickUpLatestTimeAvailableSelection";
    public final static String pickupDateFormControl = "pickupDateFormControl";
    public final static String pickUpReadyTimeSelectionErrorMessage = "//*[@id=\"pickUp-dropOffComponent\"]/div/div/div/div[1]/div[2]/div[4]";

    @FindBy(id = pickUpDropOffSelect)
    public WebElement pickUpDropOffSelection;

    @FindBy(id = pickupSubmit)
    public WebElement pickUpSubmit;

    @FindBy(id = summaryPickUpEdit)
    public WebElement summaryPickupEdit;

    @FindBy(id = specialInstructionsASCIIerror)
    public WebElement specialInstructionsASCIIError;

    @FindBy(id = pickUpInstrselect)
    public WebElement pickUpInstrSelect;

    @FindBy(id = pickUpInstrInputFormcontrol)
    public WebElement pickUpInstrInputFormControl;
    
    @FindBy(id = pickupDetailsCancel)
    public  WebElement pickupDetailscancel;
    
    @FindBy(id = pickUpUpdate)
    public  WebElement pickUpupdate;
    
    @FindBy(id = pickUpDropOffHeading)
    public  WebElement pickUpDropOffheading;
    
    @FindBy(id =pickUpReadyTimeSelection)
    public  WebElement pickUpReadyTimeselection;
    

    @FindBy(xpath = dropOffPreSelection)
    public  WebElement dropOffPreselection;
    
    @FindBy(id = pickUpLatestTimeAvailableSelection)
    public  WebElement pickUpLatestTimeAvailableselection;
    
    @FindBy(id = pickupDateFormControl)
    public  WebElement pickupDateFormcontrol;
    
    @FindBy(xpath =pickUpReadyTimeSelectionErrorMessage)
    public  WebElement pickUpReadyTimeSelectionErrormessage;
    
    
    
    


    public PickUpAndDropOffObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }


    public void clickOnPickUpSubmit() throws InterruptedException {
        Wrappers.waitforSelectValue(pickUpDropOffSelection);
        Wrappers.clickOnElement(pickUpSubmit);
        Wrappers.waitForElement(summaryPickupEdit);
    }


    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
