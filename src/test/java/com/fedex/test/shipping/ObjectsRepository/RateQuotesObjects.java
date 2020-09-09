package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.util.List;

public class RateQuotesObjects extends LoadableComponent<RateQuotesObjects> {

    public final static String loadingIndicatorServiceSect = "fdx-c-loading-indicator__part";
    public final static String rateServicesbutton = "servicesButton_11";
    public final static String rateTableHeading = "rateTableHeading";
    public final static String summaryRateDeliveryEdit = "summaryDeliveryEdit";
    public final static String shipdateId = "shipDateId";
    public final static String amountsShown = "amountsShown";
    public final static String arrivesOn = "//*[@id='serviceRatequotes']/ul[1]/fx-mags-ratequote/li/div/div/div/div/text()";
    public final static String deliveredByTime = "//*[@id=\"serviceRatequotes\"]/ul[1]/fx-mags-ratequote/li/ul/li/div/span";
    public final static String deliveredByServiceType = "//*[@id=\"serviceRatequotes\"]/ul[1]/fx-mags-ratequote/li/ul/li/div/div[2]";
    public final static String SignatureOptions = "SignatureOptionsLabel";
    public final static String DIRECT = "DIRECTLabel";
    public final static String HeaderMessage = "HeaderMessage";
    public final static String Icon = "Icon";
    public final static String serviceDisclaimer = "divRateDisclaimer_breakdown";
    public final static String servicesButton_11_breakdown = "#serviceRatequotes > ul > li:nth-child(1) > ul > li > div.fxg-arrow-icon > button";
    public final static String servicesButton_11_Direct_signature_required = "servicesButton_11_Direct signature required";
    
    @FindBy(className = loadingIndicatorServiceSect)
    public List<WebElement> loadingIndicatorServiceSection;

    @FindBy(id = summaryRateDeliveryEdit)
    public WebElement summaryDeliveryEdit;

    @FindBy(id = shipdateId)
    public WebElement shipDateId;
    
    @FindBy(id = amountsShown)
    public WebElement amountShown;
    
    @FindBy(xpath = arrivesOn)
    public List<WebElement> arriveson;
    
    @FindBy(xpath = deliveredByTime)
    public WebElement deliveredbytime;

    @FindBy(xpath = deliveredByServiceType)
    public WebElement deliveredbyservicetype;
    
    @FindBy(id = SignatureOptions)
    public WebElement Signatureoptions;
    
    @FindBy(id = DIRECT)
    public WebElement directSignaturerequired;

    @FindBy(id = rateServicesbutton)
    public WebElement rateServicesButton;

    @FindBy(id = rateTableHeading)
    public WebElement rateTableheading;
    
    @FindBy(id = HeaderMessage)
    public  WebElement Headermessage;
    
    @FindBy(id = Icon)
    public  WebElement icon;
    
    @FindBy(id = serviceDisclaimer)
    public  WebElement servicedisclaimer;
    
    @FindBy(css = servicesButton_11_breakdown)
    public  WebElement servicesButton11_breakdown;
    
    @FindBy(id = servicesButton_11_Direct_signature_required)
    public  WebElement servicesButton_11_Directsignaturerequired;


    public RateQuotesObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }


    public void selectFedExServiceRateButton(){
        try {
            if (!loadingIndicatorServiceSection.get(3).isDisplayed()){
                Wrappers.waitForElement(rateServicesButton);
//                clickOnGivenElement(rateServicesButton, "FedEx Service Selected as First button");
                Wrappers.clickOnElementJS(rateServicesButton);
                Wrappers.waitForElement(summaryDeliveryEdit);
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void clickOnRatesButton() {
        try {
            if(rateServicesButton.isDisplayed()){
                Wrappers.clickOnElement(rateServicesButton);
            }
            Wrappers.waitForElement(summaryDeliveryEdit);
        }
        catch (Exception e) {
            Assert.fail();
        }
    }


    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
    
}
