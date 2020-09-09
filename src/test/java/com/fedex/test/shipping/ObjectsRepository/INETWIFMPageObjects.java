package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class INETWIFMPageObjects extends LoadableComponent<INETWIFMPageObjects> {

    public final static String wifmfromedit="module.from._headerEdit";
    public final static String wifmfromname="fromData.contactName";
    public final static String wifmfromcountry="fromData.countryCode";
    public final static String wifmfromState="fromData.stateProvinceCode";
    public final static String wifmfromcompany="fromData.companyName";
    public final static String wifmfromAddress1="fromData.addressLine1";
    public final static String wifmfromAddress2="fromData.addressLine2";
    public final static String wifmfromPostal="fromData.zipPostalCode";
    public final static String wifmfromCity="fromData.city";
    public final static String wifmfromPhonenumber="fromData.phoneNumber";
    public final static String wifmtoedit="module.to._headerEdit";
    public final static String wifmtoname="toData.contactName";
    public final static String wifmtocountry="toData.countryCode";
    public final static String wifmtocompany="toData.companyName";
    public final static String wifmtoAddress1="toData.addressLine1";
    public final static String wifmtoAddress2="toData.addressLine2";
    public final static String wifmtoPostal="toData.zipPostalCode";
    public final static String wifmtoCity="toData.city";
    public final static String wifmtoPhonenumber="toData.phoneNumber";
    public final static String wifmtoState="toData.stateProvinceCode";
    public static final String inetloginState = "logoutLink";
    public static final String inetCreateshipment = "//*[@id='temp']/label";
    public static final String wifmCreateshipment = "//*[@id='menubar.nav.menu1_div']";
    public static final String returnToOldversion = "button[aria-label=“Return to old version”]";
    public static final String advancedShippingbutton = "e2e-onboarding-returnToOldVersion";

    @FindBy(id = wifmfromedit)
    public WebElement wifmFromEdit;

    @FindBy(id = wifmfromname)
    public WebElement wifmFromName;

    @FindBy(id = wifmfromcountry)
    public WebElement wifmFromCountry;

    @FindBy(id = wifmfromState)
    public WebElement wifmFromState;

    @FindBy(id = wifmfromcompany)
    public WebElement wifmFromCompany;

    @FindBy(id = wifmfromAddress1)
    public WebElement wifmFromAddress1;

    @FindBy(id = wifmfromAddress2)
    public WebElement wifmFromAddress2;

    @FindBy(id = wifmfromPostal)
    public WebElement wifmFromPostal;

    @FindBy(id = wifmfromCity)
    public WebElement wifmFromCity;

    @FindBy(id = wifmfromPhonenumber)
    public WebElement wifmFromPhonenumber;

    @FindBy(id = wifmtoedit)
    public WebElement wifmTodit;

    @FindBy(id = wifmtoname)
    public WebElement wifmToname;

    @FindBy(id = wifmtocountry)
    public WebElement wifmTocountry;

    @FindBy(id = wifmtocompany)
    public WebElement wifmTocompany;

    @FindBy(id = wifmtoAddress1)
    public WebElement wifmToAddress1;

    @FindBy(id = wifmtoAddress2)
    public WebElement wifmToAddress2;

    @FindBy(id = wifmtoPostal)
    public WebElement wifmToPostal;

    @FindBy(id = wifmtoCity)
    public WebElement wifmToCity;

    @FindBy(id = wifmtoPhonenumber)
    public WebElement wifmToPhonenumber;

    @FindBy(id = wifmtoState)
    public WebElement wifmToState;

    @FindBy(id = inetloginState)
    public WebElement inetLoginState;

    @FindBy(xpath = inetCreateshipment)
    public WebElement inetCreateShipment;

    @FindBy(xpath = wifmCreateshipment)
    public WebElement wifmCreateShipment;

    @FindBy(css = returnToOldversion)
    public WebElement returnToOldVersion;

   /* @FindBy(css = kebabicon)
    public WebElement kebabIcon;*/

    @FindBy(id = advancedShippingbutton)
    public WebElement advancedShippingButton;

    public INETWIFMPageObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }


    public void datapopulationinWIFM(){

        try {
            JSONObject users =  Wrappers.getUserAddressDetailsJson("Bindu TM");
            JSONObject usersLevel = Wrappers.getUserAddressDetailsJson("PRATIK BANARSE");
            Wrappers.getTextFromAndCompareTextWith(wifmFromName, usersLevel.get("Name").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmFromCountry, usersLevel.get("Country").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmFromAddress1, usersLevel.get("Address").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmFromCity, usersLevel.get("City").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmFromPostal, usersLevel.get("Postal").toString());

            if((Property.getProp("level").equalsIgnoreCase("L2")) || (Property.getProp("level").equalsIgnoreCase("L3"))){
                Wrappers.getTextFromAndCompareTextWith(wifmFromPhonenumber, usersLevel.get("Lphone").toString());
            }else if(Property.getProp("level").equalsIgnoreCase("L6")){
                Wrappers.getTextFromAndCompareTextWith(wifmFromPhonenumber, usersLevel.get("PhoneNumber").toString());
            }

            Wrappers.getTextFromAndCompareTextWith(wifmToname, users.get("Name").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmTocountry, users.get("Country").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmToAddress1, users.get("Address").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmToCity, users.get("City").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmToPostal, users.get("ZIP").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmToPhonenumber, users.get("PhoneNumber").toString());
            Wrappers.getTextFromAndCompareTextWith(wifmToState, users.get("State").toString());

        } catch (Exception e) {
            e.printStackTrace();
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
