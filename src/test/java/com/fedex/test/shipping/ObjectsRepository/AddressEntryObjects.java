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

public class AddressEntryObjects extends LoadableComponent<AddressEntryObjects> {

	public final static String fromHeader = "fx-mags-address-form-from h3";
	public static final String fromEdit = "summaryFromEdit";
	public static final String fromName = "field_contact_personName";
	public static final String fromCountry = "field_address_countryCode";
	public final static String fromUserNameError = "errors_contact_personName";
	public static final String fromAddressline1 = "field_address_streetLine1";
	public static final String fromAddressline2 = "field_address_streetLine2";
	public final static String fromUserPostalError = "errors_address_postalCode";
	public static final String fromPostal = "field_address_postalCode";
	public static final String fromPostallabel = "[for='field_address_postalCode']";
	public static final String fromState = "field_address_stateOrProvinceCode";
	public static final String fromState1="(//option[@id=\"0\"])[1]";
	public static final String fromCity = "field_address_city";
	public static final String fromPhoneNumber = "field_contact_phoneNumber";
	public static final String fromEmail = "field_contact_emailAddress";
	public static final String fromCompany = "field_contact_companyName";
	public static final String fromUpdate = "address-form-save";
	public final static String userStateLabelFROM = "[for='field_address_stateOrProvinceCode']";
	//public final static String fromUserNameError = "userNameFROMerror";
	public final static String userNameFROM = "field_contact_personName";
	public final static String fromUserCountryError = "errors_address_countryCode";
	public final static String fromUserAddressError = "errors_address_streetLine1";
	public final static String userEmailFROM = "field_contact_emailAddress";
	public final static String fromuserEmailError = "errors_contact_emailAddress";
	public final static String summaryFromEdit = "summaryFromEdit";
	public final static String userNoteFROM = "(//span[contains(text(),' Your contacts will appear once you start typing below.')])[1]";
	public final static String fromUserStateError = "errors_address_stateOrProvinceCode";
	public final static String fromUserCityError = "errors_address_city";
	public final static String userCityDropDownListFrom = "//*[@id='userCityFROMDropdown']/li[1]";
	public final static String userNameDropFromDownList = "//*[@id='userNameFROMDropdown']/li[1]";
	public final static String fromUserPhonenumberError = "errors_contact_phoneNumber";
	public final static String userFromAltPickupEdit = "summaryFromAltEdit";
	public final static String fromUserAddressLine2Error = "errors_address_streetLine2";
	/*********TO fields***************/
	public final static String toHeader = "fx-mags-address-form-to>h3";
	public static final String toName = "field_contact_personName";
	public final static String toCompany = "field_contact_companyName";
	public final static String toCountry = "field_address_countryCode";
	public final static String toAddressline1 = "field_address_streetLine1";
	public final static String toAddressline2 = "field_address_streetLine2";
	public final static String toCity = "field_address_city";
	public final static String toState = "field_address_stateOrProvinceCode";
	public final static String toPostal = "field_address_postalCode";
	public final static String toPhoneNumber = "field_contact_phoneNumber";
	public final static String toEmail = "field_notification_0_email";
	public final static String toUpdate = "address-form-save";
	public final static String toUserCountryerror = "errors_address_countryCode";
	public final static String toheading = "fx-mags-address-form-to>h3";
	public final static String toaddressdropDown = "//*[@class='pac-container pac-logo'][2]/div";

	public static final String toUserError = "toUserNameError";
	public static final String globalLoginDropDown = "HeaderLogin";
	public final static String toUserPostalError = "errors_address_postalCode";
	public final static String userPostalTO = "field_address_postalCode";
	public final static String userEmailTO= "field_notification_0_email";
	public final static String userCityTO = "field_address_city";
	public final static String userStateTO = "field_address_stateOrProvinceCode";
	public final static String userPhoneNumberTO = "field_contact_phoneNumber";
	public final static String userCountryTO = "field_address_countryCode";
	public final static String addressSubmitTO = "address-form-save";
	public final static String userCompanyTO = "field_contact_companyName";
	public final static String userNameTO = "field_contact_personName_firstName";
	public final static String userAddressBookTO= "[fxmagsmodal=addressBook]";
	public final static String userAddressBookCloseTO= "#e2e-addressBook-close > fdx-icon > svg";
	public final static String userAddressBookSearchQueryTO= "field_address_book_search_query";
	public final static String userAddressBookSearchResultFirstTO= "id_0";
	public final static String fromaddressdropDown = "//*[@class='pac-container pac-logo'][1]";

	public final static String alternativePickupAdressLine2 = "alternativePickupAptSuite";
	public final static String userCompanyError = "userCompanyFROMerror";
	public final static String alternativePickupPostal = "alternativePickupPostal";
	public final static String alternativePickupAdressLine2Error = "alternativePickupAptSuiteerror";
	public final static String fromAddressCancel = "address-form-cancel";
	public final static String summaryToEdit = "summaryToEdit";
	public final static String toAddressUpdate = "//button[@id='address-form-save']";
	public final static String toAddressCancel = "//button[@id='address-form-cancel'] ";
	public final static String alternativePickupCity = "alternativePickupCity";
	public final static String alternativePickupAddressHeading = "fx-mags-address-form-pickup > h3";
	public final static String alternativePickupName = "alternativePickupName";
	public final static String alternativePickupAptSuite = "alternativePickupAptSuite";
	public final static String alternativePickupAddress = "alternativePickupAddress";
	public final static String alternativePickupState = "alternativePickupState";
	public final static String alternativePickupCountry = "alternativePickupCountry";
	public final static String alternativePickupPhoneNumber = "alternativePickupPhoneNumber";
	public final static String fromAddressUpdate = "updateFROM";
	public final static String googleAddressDropdownFROM = "#body > div.pac-container.pac-logo.hdpi [class=pac-item-query]";
	public final static String googleAddressdropdown="body > div.pac-container.pac-logo > div:nth-child(1)";
	public final static String toUserAddresserror = "errors_address_streetLine1";
	public final static String toSectionTooltip = "//h2[contains(text(),'To')]/ancestor::section//button[@class='focusThis button-tooltip tooltipCollapse toolTipPosition']";
	public final static String toelements = "//h2[contains(text(),'To')]/ancestor::section//*";
	public final static String toSectionimage = "//h2[contains(text(),'To')]/ancestor::section//img";
	public final static String tohref = "//h2[contains(text(),'To')]/ancestor::section//a";
	public final static String toModulefocus = "//h2[contains(text(),'To')]/ancestor::section/div[@class='card__inner']";

	@FindBy(css = fromHeader)
	public WebElement fromfieldHeader;

	@FindBy(id = fromEdit)
	public WebElement fromfieldEdit;

	@FindBy(id = summaryFromEdit)
	public WebElement summaryFromedit;

	@FindBy(id = globalLoginDropDown)
	public WebElement globalLoginDropDowns;

	@FindBy(id =userEmailFROM)
	public WebElement userEmailfROM;

	@FindBy(id = fromUserNameError)
	public WebElement fromUserNameerror;

	@FindBy(id = fromuserEmailError)
	public WebElement fromuserEmailerror;

	@FindBy(id = fromName)
	public WebElement fromfieldName;

	@FindBy(id = fromCountry)
	public WebElement fromfieldCountry;

	@FindBy(id = fromAddressline1)
	public WebElement fromfieldAddress1;

	@FindBy(id = fromAddressline2)
	public WebElement fromfieldAddress2;

	@FindBy(id = fromPostal)
	public WebElement fromfieldPostal;

	@FindBy(css = fromPostallabel)
	public WebElement fromfieldPostalLabel;

	@FindBy(id = fromState)
	public WebElement fromfieldState;

	@FindBy(xpath = fromState1)
	public WebElement fromfieldState1;

	@FindBy(id = fromCity)
	public WebElement fromfieldCity;

	@FindBy(id = fromPhoneNumber)
	public WebElement fromfieldPhnNum;

	@FindBy(id = fromEmail)
	public WebElement fromfieldEmail;

	@FindBy(id = fromCompany)
	public WebElement fromfieldCompany;

	@FindBy(id = fromUpdate)
	public WebElement fromfieldUpdate;

	@FindBy(xpath = toUserError)
	public WebElement toErrorMsg;

	@FindBy(css = toHeader)
	public WebElement tofieldHeader;

	@FindBy(id = toName)
	public WebElement tofieldName;

	@FindBy(id = toCompany)
	public WebElement tofieldCompany;

	@FindBy(id = toCountry)
	public WebElement tofieldCountry;

	@FindBy(id = toAddressline1)
	public WebElement tofieldAddress1;

	@FindBy(id = toAddressline2)
	public WebElement tofieldAddress2;

	@FindBy(id = toPostal)
	public WebElement tofieldPostal;

	@FindBy(id = toState)
	public WebElement tofieldState;

	@FindBy(id = toCity)
	public WebElement tofieldCity;

	@FindBy(id = toPhoneNumber)
	public WebElement tofieldPhnNum;

	@FindBy(id = toEmail)
	public WebElement tofieldEmail;

	@FindBy(id = toUpdate)
	public WebElement tofieldUpdate;

	@FindBy(xpath = userNoteFROM)
	public WebElement userNotefROM;

	@FindBy(id = toUserPostalError)
	public WebElement toUserPostalerror;


	@FindBy(id = userNameFROM)
	public WebElement userNamefROM;

	@FindBy(id = fromUserCountryError)
	public WebElement fromUserCountryerror;

	@FindBy(id = fromUserAddressError)
	public WebElement fromUserAddresserror;

	@FindBy(id = fromUserPostalError)
	public WebElement fromUserPostalerror;

	@FindBy(css =userStateLabelFROM)
	public WebElement userStateLabelfROM;

	@FindBy(id = fromUserStateError)
	public WebElement fromUserStateerror;

	@FindBy(id = fromUserCityError)
	public WebElement fromUserCityerror;

	@FindBy(xpath = userCityDropDownListFrom)
	public List<WebElement> userCityDropDownListfrom;

	@FindBy(xpath = userNameDropFromDownList)
	public List<WebElement> userNameDropFromDownlist;

	@FindBy(id = fromUserPhonenumberError)
	public WebElement fromUserPhonenumbererror;

	@FindBy(id = userFromAltPickupEdit)
	public WebElement userFromAltPickupedit;

	@FindBy(id =alternativePickupAdressLine2)
	public WebElement alternativePickupAdressline2;

	@FindBy(id = fromUserAddressLine2Error)
	public WebElement fromUserAddressLine2error;

	@FindBy(id = userCompanyError)
	public WebElement userCompanyerror;

	@FindBy(id = alternativePickupPostal)
	public WebElement alternativePickuppostal;

	@FindBy(id = alternativePickupAdressLine2Error)
	public WebElement alternativePickupAdressLine2error;

	@FindBy(id = userPostalTO)
	public WebElement userPostaltO;

	@FindBy(id =userCityTO)
	public WebElement userCitytO;

	@FindBy(id =userStateTO)
	public WebElement userStatetO;

	@FindBy(id = userPhoneNumberTO)
	public WebElement userPhoneNumbertO;

	@FindBy(id = userEmailTO)
	public WebElement userEmailtO;

	@FindBy(id = userCountryTO)
	public WebElement userCountrytO;

	@FindBy(id = addressSubmitTO)
	public WebElement addressSubmittO;

	@FindBy(id = userCompanyTO)
	public WebElement userCompanytO;

	@FindBy(id = userNameTO)
	public WebElement userNametO;

	@FindBy(css= userAddressBookTO)
	public WebElement userAddressBooktO;

	@FindBy(css = userAddressBookCloseTO)
	public WebElement userAddressBookClosetO;

	@FindBy(id= userAddressBookSearchQueryTO)
	public WebElement userAddressBookSearchQuerytO;

	@FindBy(id= userAddressBookSearchResultFirstTO)
	public WebElement userAddressBookSearchResultFirstOptTo;


	@FindBy(id = fromAddressCancel)
	public  WebElement fromAddresscancel;

	@FindBy(id = summaryToEdit)
	public  WebElement summaryToedit;

	@FindBy(xpath = toAddressUpdate)
	public  WebElement toAddressupdate;

	@FindBy(xpath = toAddressCancel)
	public  WebElement toAddresscancel;

	@FindBy(id = alternativePickupCity)
	public  WebElement alternativePickupcity;

	@FindBy(css = alternativePickupAddressHeading)
	public  WebElement alternativePickupAddressheading;

	@FindBy(id = alternativePickupName)
	public  WebElement alternativePickupname;

	@FindBy(id = alternativePickupAptSuite)
	public  WebElement alternativePickupAptsuite;

	@FindBy(id = alternativePickupAddress)
	public  WebElement alternativePickupaddress;

	@FindBy(id = alternativePickupState)
	public  WebElement alternativePickupstate;

	@FindBy(id = alternativePickupCountry)
	public  WebElement alternativePickupcountry;

	@FindBy(id = alternativePickupPhoneNumber)
	public  WebElement alternativePickupPhonenumber;

	@FindBy(id = fromAddressUpdate)
	public  WebElement fromAddressupdate;

	@FindBy(css = googleAddressDropdownFROM)
	public  List<WebElement> googleAddressDropdownfROM;

	@FindBy(id = toUserCountryerror)
	public  WebElement toUserCountryError;

	@FindBy(css =toheading)
	public  WebElement toHeading;

	@FindBy(xpath = fromaddressdropDown)
	public WebElement fromaddressdropdown;

	@FindBy(css = googleAddressdropdown)
	public  WebElement googleAddressDropdown;

	@FindBy(id = toUserAddresserror)
	public  WebElement toUserAddressError;

	@FindBy(xpath = toaddressdropDown)
	public static WebElement toaddressdropdown;

	@FindBy(xpath = toSectionTooltip)
	public List<WebElement> toSectionToolTip;

	@FindBy(xpath = toelements)
	public List<WebElement> toElements;

	@FindBy(xpath = toSectionimage)
	public List<WebElement> toSectionImage;

	@FindBy(xpath = tohref)
	public List<WebElement> toHref;

	@FindBy(xpath = toModulefocus)
	public WebElement toModuleFocus;

	String recipientName;
	public static String random_name = "";




	public AddressEntryObjects(){
		PageFactory.initElements(DriverGenerator.getDriver(), this);
	}

	public void verify_from_section_fields() {

		try {
			Wrappers.waitForElement(userNamefROM);
			JSONObject users = Wrappers.getUserAddressDetailsJson("Bindu  TM");
			Wrappers.getTextFromAndCompareTextWith(userNamefROM, users.get("Name").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldCountry, users.get("Country").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldAddress1, users.get("Address").toString());
			//getTextFromAndCompareTextWith(driver,AddressEntryObjects.fromfieldAddress2,users.get("aptsuite").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldPostal, users.get("ZIP").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldState, users.get("State").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldCity, users.get("City").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldPhnNum, users.get("PhoneNumber").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldEmail, users.get("Email").toString());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void toSectionFill(String userName) throws IOException, JSONException, InterruptedException {
		try {
			Wrappers.waitForElement(tofieldName);
			JSONObject user = Wrappers.getUserAddressDetailsJson(userName);
			//Wrappers.enterValue(tofieldName, user.get("Name").toString());
			if (user.get("Name").toString().contains("RANDOM")) {
				random_name = user.get("Name").toString() + Wrappers.getCurrentTimeUsingDate();
				Wrappers.enterValue(tofieldName,random_name);
			} else {
				Wrappers.enterValue(tofieldName,user.get("Name").toString());
			}
			Wrappers.enterValue(tofieldCompany, user.get("Company").toString());
			if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
				Wrappers.selectbyValueMobile((MobileWebDriver) DriverGenerator.getDriver(), "id", toCountry, user.get("Country").toString());
			} else {
				Wrappers.selectValuebyValue(tofieldCountry, user.get("Country").toString());
			}
			Wrappers.enterValue(tofieldAddress1, user.get("Address").toString());
			Wrappers.enterValue(tofieldAddress2, user.get("APT/SUITE").toString());
			Thread.sleep(5000);
			Wrappers.enterValue(tofieldPostal, user.get("ZIP").toString());
			if (Wrappers.elementisDisplayedAndEnabled(tofieldState)) {
				if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
					Wrappers.selectbyValueMobile((MobileWebDriver) DriverGenerator.getDriver(), "id", toState, user.get("State").toString());
				} else {
					Wrappers.selectValuebyValue(tofieldState, user.get("State").toString());
				}
			}
			Thread.sleep(5000);
			Wrappers.enterValue(tofieldCity, user.get("City").toString());
			Wrappers.enterValue(tofieldPhnNum, user.get("PhoneNumber").toString());
			Wrappers.enterValue(tofieldEmail, user.get("Email").toString());
		}

	catch(Exception e) {
			e.printStackTrace();
	}
	}

	public void fromSectionFill(String userName) throws IOException, JSONException, InterruptedException {
		Wrappers.waitForElement(fromfieldHeader);
		JSONObject user = Wrappers.getUserAddressDetailsJson(userName);
		Wrappers.enterValue(fromfieldName,user.get("Name").toString());
		Wrappers.enterValue(fromfieldCompany, user.get("Company").toString());
		if(Property.getProp("platform").equalsIgnoreCase("mobile")){
			Wrappers.selectbyValueMobile((MobileWebDriver) DriverGenerator.getDriver(), "id","userCountryTO", user.get("Country").toString());
		}else {
			Wrappers.selectValuebyValue(fromfieldCountry, user.get("Country").toString());
		}
		Wrappers.enterValue(fromfieldAddress1,user.get("Address").toString());
		Wrappers.enterValue(fromfieldAddress2 ,user.get("APT/SUITE").toString());
		Wrappers.enterValue(fromfieldPostal ,user.get("ZIP").toString());
		Thread.sleep(4000);
		if (Wrappers.elementisDisplayedAndEnabled(fromfieldState)) {
			if(Property.getProp("platform").equalsIgnoreCase("mobile")){
				Wrappers.selectbyValueMobile((MobileWebDriver) DriverGenerator.getDriver(), "id","userStateTO", user.get("State").toString());
			}else{
				Wrappers.selectValuebyValue(fromfieldState, user.get("State").toString());
			}
		}
		Thread.sleep(4000);
		Wrappers.enterValue(fromfieldCity, user.get("City").toString());
		Wrappers.enterValue(fromfieldPhnNum,user.get("PhoneNumber").toString());
		Wrappers.enterValue(fromfieldEmail,user.get("Email").toString());
	}

	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {

	}
}
