package com.fedex.test.shipping.ObjectsRepository;
import com.experitest.selenium.MobileWebDriver;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class summaryCardObjectsAddressDetails extends LoadableComponent<summaryCardObjectsAddressDetails> {

	public final static String summaryToName = "summaryToName";
	public final static String summaryToCompany = "summaryToCompany";
	public final static String summaryToAptSuite = "summaryToAptSuite";
	public final static String summaryToStreetLine = "summaryToStreetLine";
	public final static String summaryToPostalStateCity = "summaryToPostalStateCity";
	public final static String summaryToPostalCity = "summaryToPostalCity";
	public final static String summaryToCountry = "summaryToCountry";
	public final static String summaryToPhone = "summaryToPhone";
	public final static String summaryToEmail = "summaryToEmail";
	public final static String summaryFromEdit = "summaryFromEdit";
	public final static String summaryFromHeading = "summaryAddressComponent";
	public final static String summaryFromName = "summaryFromName";
	public final static String summaryFromCompany = "summaryFromCompany";
	public final static String summaryFromAptSuite = "summaryFromAptSuite";
    public final static String summaryFromStreetLine = "summaryFromStreetLine";
	public final static String summaryFromPostalStateCity = "summaryFromPostalStateCity";
	public final static String summaryFromPostalCity = "summaryFromPostalCity";
	public final static String summaryFromCountry = "summaryFromCountry";
	public final static String summaryFromPhone = "summaryFromPhone";
	public final static String summaryFromEmail = "summaryFromEmail";
	 
	
	
	
	   @FindBy(id = summaryToName)
	    public  WebElement summaryToname;
	   
	   @FindBy(id = summaryToCompany)
	    public  WebElement summaryTocompany;
	   
	   @FindBy(id = summaryToAptSuite)
	    public  WebElement summaryToAptsuite;
	   
	   @FindBy(id = summaryToStreetLine)
	    public  WebElement summaryTostreetLine;
	   
	   @FindBy(id = summaryToPostalStateCity)
	    public  WebElement summaryToPostalstateCity;
	   
	   @FindBy(id = summaryToPostalCity)
	    public  WebElement summaryToPostalcity;
	   
	   @FindBy(id = summaryToCountry)
	    public  WebElement summaryTocountry;
	   
	   @FindBy(id = summaryToPhone)
	    public  WebElement summaryTophone;
	   
	   @FindBy(id = summaryToEmail)
	    public  WebElement summaryToemail;
	   
	   @FindBy(id = summaryFromEdit)
	    public  WebElement summaryfromEdit;
	   
	   @FindBy(id = summaryFromHeading)
	    public  WebElement summaryFromheading;
	   
	   @FindBy(id = summaryFromName)
	    public  WebElement summaryFromname;
	   
	   @FindBy(id = summaryFromCompany)
	    public  WebElement summaryFromcompany;
	   
	   @FindBy(id = summaryFromAptSuite)
	    public  WebElement summaryFromAptsuite;
	   
	   @FindBy(id = summaryFromStreetLine)
	    public  WebElement summaryFromStreetline;
	   
	    @FindBy(id = summaryFromPostalStateCity)
	    public  WebElement summaryFromPostalstateCity;
	    
	    @FindBy(id = summaryFromPostalCity)
	    public  WebElement summaryFromPostalcity;
	    
	    @FindBy(id = summaryFromCountry)
	    public  WebElement summaryFromcountry;
	    
	    @FindBy(id = summaryFromPhone)
	    public  WebElement summaryFromphone;
	    
	    @FindBy(id = summaryFromEmail)
	    public  WebElement summaryFromemail;
	   
	  
	public summaryCardObjectsAddressDetails(){
		PageFactory.initElements(DriverGenerator.getDriver(), this);
	}

	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {

	}
}
