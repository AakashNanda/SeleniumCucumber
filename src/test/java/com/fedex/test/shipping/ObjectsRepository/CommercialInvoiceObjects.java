package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CommercialInvoiceObjects extends LoadableComponent<CommercialInvoiceObjects> {


    public final static String commercialYesProradio = "[for=commercialYesProRadio]";
    public final static String commercialYesradio = "[for=commercialYesRadio]";
    public final static String termsOfsale = "termsOfSale";
    public final static String additionalInvoiceInfo1 = "additionalInvoiceInfo1";
    public final static String additionalInvoiceInfo2 = "additionalInvoiceInfo2";
    public final static String additionalInvoiceInfoOneInvalidErr = "//span[@class='errorInfo infoMsg custom-value-error-msg ng-star-inserted']";
    public final static String additionalInvoiceInfoOneMaxLimitErr = "//span[@class='errorInfo infoMsg custom-value-error-msg ng-star-inserted']";

    public CommercialInvoiceObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }

    @FindBy(css = commercialYesProradio)
    public WebElement commercialYesProRadio;

    @FindBy(id = additionalInvoiceInfo1)
    public WebElement additionalInvoiceInfoOne;

    @FindBy(id = additionalInvoiceInfo2)
    public WebElement additionalInvoiceInfoTwo;

    @FindBy(id = termsOfsale)
    public  WebElement termsOfSale;

    @FindBy(css = commercialYesradio)
    public WebElement commercialYesRadioButton;

    @FindBy(xpath = additionalInvoiceInfoOneInvalidErr)
    public WebElement AdditionalInvoiceInfoOneInvalidError;

    @FindBy(xpath = additionalInvoiceInfoOneMaxLimitErr)
    public WebElement AdditionalInvoiceInfoOneMaxLimitErr;

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
