package com.fedex.test.shipping.cucumberSteps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.*;

import cucumber.api.Scenario;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects.userAddressBookSearchQueryTO;


@SuppressWarnings("deprecation")
public class AddressEntry_Steps extends SeleniumReusableMethods {


    public HomePageObjects homePageObjects;
    public AddressEntryObjects addressEntryObjects;
    public ShipmentHistoryPageObjects shipmentHistoryPageObjects;
    public PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects;
    public ThankYouPageObjects thankYouPageObjects;

    public AddressEntry_Steps(SharedDriverManager driver,ShipmentHistoryPageObjects shipmentHistoryPageObjects, ThankYouPageObjects thankYouPageObjects,HomePageObjects homePageObjects, AddressEntryObjects addressEntryObjects,PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects) throws IOException {
        this.homePageObjects = homePageObjects;
        this.addressEntryObjects = addressEntryObjects;
        this.packagingAndShipmentDetailsObjects = packagingAndShipmentDetailsObjects;
        this.thankYouPageObjects=thankYouPageObjects;
        this.shipmentHistoryPageObjects=shipmentHistoryPageObjects;
    }


    @After
    public void afterEachScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverGenerator.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/jpeg");

        }
    }

    @Given("^User:\"([^\"]*)\" logs in to Shipping application$")
    public void login_to_Shipping_Application(String reference) throws IOException, AWTException, InterruptedException {
       if(!Property.getProp("level").equalsIgnoreCase("L"))
        homePageObjects.login(reference);
       else
           homePageObjects.loginLocal(reference);
    }

    @Then("^User clicks on start shipping button$")
    public void clickOnSimpleShipping() throws Exception {
        homePageObjects.clickOnStartShipping();
     //   System.out.println("test123"+shipmentHistoryPageObjects.CreateShipment.getText());
        homePageObjects.feedbackPopupClose();
    }


    @When("^User clicks on FROM EDIT$")
    public void click_on_FROM_EDIT() throws InterruptedException {
        waitForElement(addressEntryObjects.fromfieldEdit);
        homePageObjects.feedbackPopupClose();
        scrollToElement(addressEntryObjects.fromfieldEdit);
        if (!(addressEntryObjects.fromfieldEdit.isDisplayed())) {
            scrollToElement(addressEntryObjects.fromfieldEdit);
        }
        waitForElement(addressEntryObjects.fromfieldEdit);
        clickOnElement(addressEntryObjects.fromfieldEdit);
    }


    @Then("^Verify the from section address fields$")
    public void verify_the_from_section_address_fields() {
        addressEntryObjects.verify_from_section_fields();
    }

    @Then("^User Enters Value:\"([^\"]*)\" in TO User Name$")
    public void enterValueTOUserName(String valueToEnter) throws InterruptedException, IOException {
        enterValue(addressEntryObjects.tofieldName, valueToEnter);
    }

    @When("User clicks on the element:\"([^\"]*)\"$")
    public void click_on_element(String classPath) throws Exception {
        click_on_feature_element(classPath);
    }

    @Then("^User clicks on ToSubmit button$")
    public void User_clicks_To_Update_Button() throws InterruptedException, IOException {
        clickOnUpdate(addressEntryObjects.tofieldUpdate);
        homePageObjects.feedbackPopupClose();
//        reClickOnElement(addressEntryObjects.tofieldUpdate);
    }

    @Then("^Verify Error Message displayed for element:\"([^\"]*)\" jsonParentTag:\"([^\"]*)\" and keyValue:\"([^\"]*)\"$")
    public void verify_error_message_displayed(String element, String jsonparent, String keyvalue) throws IOException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, Exception {
        if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
            verify_error_message_displayedMobile_ClasspathAndJSON(element, jsonparent, keyvalue, "-200");
        } else {
            verify_error_message_displayed_ClasspathAndJSON(element, jsonparent, keyvalue);
        }
    }

    @Then("Verify the label name displayed for element:\"([^\"]*)\" jsonParentTag:\"([^\"]*)\" and keyValue:\"([^\"]*)\"$")
    public void checkLabelNameDisplayedUsingClassPathAndJson(String element, String jsonparent, String keyvalue) throws IOException, Exception, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
            verify_label_name_displayedMobile_ClasspathAndJSON(element, jsonparent, keyvalue, "-200");
        } else {
            verify_label_name_displayed_ClasspathAndJSON(element, jsonparent, keyvalue);
        }
    }

    @Given("User:\"([^\"]*)\" logs in with password:\"([^\"]*)\"")
    public void user_logs_in_with_password(String userName, String password) throws IOException, InterruptedException {
        homePageObjects.loginWithCredentials(userName, password);
    }

    @When("^Verify NO error message for From User Email field when below values are entered$")
    public void errorValidationUserEmailNegative(List<String> valueToEnter) {
        ArrayList<String> values = new ArrayList<>(valueToEnter);
        for (String val : values) {
            verifyNoErrorMessageForGivenElement(addressEntryObjects.userEmailfROM, addressEntryObjects.fromuserEmailerror, val);
        }
    }

    @Then("User logs out from Shipping")
    public void user_logs_out_from_Shipping() throws InterruptedException {
        try {
            homePageObjects.feedbackPopupClose();
            if (thankYouPageObjects.CloseButtonpopup.isDisplayed() && thankYouPageObjects.CloseButtonpopup.isEnabled()) {
                clickOnElement(thankYouPageObjects.CloseButton);
                homePageObjects.logout();
            } else {
                homePageObjects.logout();
            }
        } catch (NoSuchElementException e) {
//            homePageObjects.logout();

        }

    }


    @Then("^Verify error message for From User Email field when below values are entered$")
    public void errorValidationUserEmail(List<String> valueToEnter) throws JSONException, IOException {
        ArrayList<String> values = new ArrayList<>(valueToEnter);
        for (String val : values) {
            verifyErrorMessageForGivenElement(addressEntryObjects.userEmailfROM, addressEntryObjects.fromuserEmailerror, val, getEmailValidationError("validationErrorSection.email", "pattern"));

        }

    }
    @When("^User clicks on FromSubmit button$")
    public void clickOnAddressSubmit() throws InterruptedException {
        clickOnElement(addressEntryObjects.fromfieldUpdate);
    }

    @And("^Verify whether active element in screen is matched to expected element:\"([^\"]*)\" using attribute:\"([^\"]*)\"$")
    public void verifyActiveElement(String elementToVerifyClassPath, String attribute)
            throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InstantiationException {
        verifyActiveElementIsWithExpected(getWebElementByClassPath(elementToVerifyClassPath), attribute);
    }

    @Then("Verify Your contacts will appear once you start typing below. instruction message in From section$")
    public void verifyYourContactsSavedFrom() throws JSONException, IOException, InterruptedException, Exception {
        waitForElement(addressEntryObjects.userNotefROM);
        getTextFromAndCompareTextWithUI(addressEntryObjects.userNotefROM, getAddressComponentData("addressBookHint"));

    }

    @Then("^User Enters Value:\"([^\"]*)\" in FROM User Name$")
    public void enterTextInFromUserName(String valueToEnter) throws InterruptedException, IOException {
        enterValue(addressEntryObjects.fromfieldName, valueToEnter);
    }

    @When("^User Enters Value:\"([^\"]*)\" in FROM User Company$")
    public void enter_value_FROM_Company(String valuetoEnter) throws InterruptedException, IOException {
        enterValue(addressEntryObjects.fromfieldCompany, valuetoEnter);
    }

    @Then("^Verify value displayed as:\"([^\"]*)\" for element:\"([^\"]*)\"$")
    public void Verify_value_in_Element(String value, String  element) throws InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {

         verifyValueInElement(value, element);
    }

    @Then("^Verify inner text value displayed as:\"([^\"]*)\" for element:\"([^\"]*)\"$")
    public void Verify_innerTextValue_in_Element(String value, String  element) throws Exception {
        // waitForElement(addressEntryObjects.fromfieldState1);
        verifyInnerTextValueInElement(value, element);
    }

    @Then("^Verify Element isNotDisplayed$")
    public void Verify_Element_is_not_displayed(List<String> element) throws IOException {
        verify_element_not_displayed(element);
        if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
            closekeyboard();
        }
    }

    @And("^User selects value:\"([^\"]*)\" in FROM Country$")
    public void selectFromUserCountry(String valueFROMSelect) throws InterruptedException {
        waitForElement(addressEntryObjects.fromfieldCountry);
        selectValuebyValue(addressEntryObjects.fromfieldCountry, valueFROMSelect);
    }

    @When("^User Enters Value:\"([^\"]*)\" in FROM Address Line 2$")
    public void enterTextInFromAddressLine2(String valueTOEnter) throws InterruptedException, IOException {
        enterValue(addressEntryObjects.fromfieldAddress2, valueTOEnter);
    }

    @Then("^User Enters Value:\"([^\"]*)\" in FROM User Address$")
    public void enterTextInFromAddress(String valueTOEnter) throws InterruptedException, IOException {
        enterValue(addressEntryObjects.fromfieldAddress1, valueTOEnter);
    }

  /*  @Then("^User Enters Value:\"([^\"]*)\" in FROM User City$")
    public static void enterTextInFromCity(String valueTOEnter) throws InterruptedException, IOException {
        enterValue(driver, AddressEntryObjects.fromfieldCity, valueTOEnter);
    }*/
     //System.out.println(" simple");

    @And("^User selects value:\"([^\"]*)\" in TO Country$")
    public void selectTOUserCountry(String valueToSelect) throws InterruptedException {
        selectValuebyValue(addressEntryObjects.tofieldCountry, valueToSelect);
        waitForElement(addressEntryObjects.tofieldPhnNum);
    }

    @Then("^User Enters Value:\"([^\"]*)\" in TO User Postal$")
    public void enterTextInTOPostal(String valueToEnter) throws InterruptedException, IOException {
        enterValue(addressEntryObjects.tofieldPostal, valueToEnter);
    }

    @When("^User clicks on From update button$")
    public void User_clicks_From_Update_Button() throws InterruptedException, IOException {
        waitForElement(addressEntryObjects.fromfieldUpdate);
        scrollToElement(addressEntryObjects.fromfieldUpdate);
        clickOnUpdate(addressEntryObjects.fromfieldUpdate);
    }

    @Then("^Verify Element isDisplayed$")
    public void Verify_Element_is_displayed(List<String> element) throws InterruptedException, IOException {
        verify_element_displayed(element);
        if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
            closekeyboard();
        }
    }

    @When("^User Enters Value:\"([^\"]*)\" in FROM User Postal$")
    public void enterTextInFromPostal(String valueTOEnter) throws  InterruptedException {
        enterTextInGivenElement(addressEntryObjects.fromfieldPostal, valueTOEnter);
        Thread.sleep(2000);
    }

    @Then("^User Enters Value:\"([^\"]*)\" in FROM User Postal custom$")
    public void enterTextInFromPostalCustom(String valueTOEnter) throws InterruptedException {
        enterTextInGivenElement(addressEntryObjects.fromfieldPostal, valueTOEnter);
        Thread.sleep(1000);
        addressEntryObjects.fromfieldPostal.sendKeys(Keys.BACK_SPACE);
        addressEntryObjects.fromfieldPostal.sendKeys("5");
        Thread.sleep(1000);
    }

    @When("^User Enters Value:\"([^\"]*)\" in FROM User Phone number$")
    public void enterTextInFromPhoneNumber(String valueTOEnter) {
        enterTextInGivenElement(addressEntryObjects.fromfieldPhnNum, valueTOEnter);
    }

    @When("^User:\"([^\"]*)\" fills in To section$")
    public void User_fill_in_To_section(String userName) throws JSONException, IOException, InterruptedException {
        homePageObjects.feedbackPopupClose();
        waitForElement(addressEntryObjects.tofieldName);
        addressEntryObjects.toSectionFill(userName);
    }

    @Then("^User Enters Value:\"([^\"]*)\" in FROM User State$")
    public void selectInFromUserState(String valueTOEnter) {
        enterTextInGivenElement(addressEntryObjects.fromfieldState, valueTOEnter);
    }

    @Then("^User Selects Value:\"([^\"]*)\" in FROM User State$")
    public  void selectInFromUserState1(String valueTOEnter) {
        selectValueInGivenElement(addressEntryObjects.fromfieldState, valueTOEnter);
    }

    @When("^User Enter Value:\"([^\"]*)\" in FROM User email$")
    public void enterTextInFromEmail(String valueTOEnter) {
        enterTextInGivenElement(addressEntryObjects.fromfieldEmail, valueTOEnter);
        //enterTextInGivenElement(addressEntryObjects.fromfieldEmail, valueTOEnter);
    }

    @When("User Enters Value:\"([^\"]*)\" in FROM User City and selects from predictive list$")
    public void user_select_from_city_combobox(String string) {
        enterTextInFromCity(string);
        addressEntryObjects.userCityDropDownListfrom.get(0).click();
    }

    @Then("^User Enters Value:\"([^\"]*)\" in FROM User City$")
    public void enterTextInFromCity(String valueTOEnter) {
        enterTextInGivenElement(addressEntryObjects.fromfieldCity, valueTOEnter);
    }

    @When("User select:\"([^\"]*)\" FROM address book$")
    public void user_select_from_address_book(String string) throws InterruptedException, IOException {
        enterTextInFromUserName(string);
        waitForElement(addressEntryObjects.userNameDropFromDownlist.get(0));
        addressEntryObjects.userNameDropFromDownlist.get(0).click();
        Thread.sleep(3000);
    }

    @When("^User Enters Value:\"([^\"]*)\" in TO Address Line 2$")
    public void enterTextInToAddressLine2(String valueTOEnter) {
        enterTextInGivenElement(addressEntryObjects.tofieldAddress2, valueTOEnter);
    }

    @When("User clicks on ALT PickUpAddress EDIT")
    public void altPickUpEDIT() throws InterruptedException {
        waitForElement(addressEntryObjects.userFromAltPickupedit);
        scrollToElement(addressEntryObjects.userFromAltPickupedit);
        clickOnElementJS(addressEntryObjects.userFromAltPickupedit);
    }

    @Then("^User enters Value:\"([^\"]*)\" in Alternative Pickup Address Line 2$")
    public void enterTextInAltAddressLine2(String valueToEnter) {
        enterTextInGivenElement(addressEntryObjects.alternativePickupAdressline2, valueToEnter);
    }

    @Then("^User clicks on To Address Book Icon$")
    public void clickOnToAddressBookIcon() throws Exception {
        clickOnElementJS(addressEntryObjects.userAddressBooktO);
        waitForElement(addressEntryObjects.userAddressBookSearchQuerytO);
    }

    @Then("^Enter Maxvalue as:\"([^\"]*)\" for element:\"([^\"]*)\"$")
    public  void enterMaxValueForElement(String textValue, String classPath) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InstantiationException, InterruptedException,IOException {
        WebElement element =getWebElementByClassPath(classPath);
        enterValue(element,textValue);
    }
    
    @When("^User clicks on From Edit summary card button$")
    public void clickOnFromAddressSectionEdit() throws InterruptedException {
    	clickOnElement(addressEntryObjects.summaryFromedit);
    }
    
    @Then("^User clicks on From cancel button$")
    public void clickOnFromCancel() throws InterruptedException {
    	clickOnElement(addressEntryObjects.fromAddresscancel);
        //waitForElement(addressEntryObjects.summaryFromedit);
    }
    
    @When("^User clicks on ToEdit summary card button$")
    public void clickOnToAddressSectionEdit() throws InterruptedException {
        scrollToElement(addressEntryObjects.summaryToedit);
    	clickOnElement(addressEntryObjects.summaryToedit);
    	//waitForElement(addressEntryObjects.toAddressupdate);
    }
    
    @Then("^User clicks on To cancel button$")
    public void clickOnToCancel() throws InterruptedException {
    	clickOnElement(addressEntryObjects.toAddresscancel);
    }
    
    @Then("^User Enters Value:\"([^\"]*)\" in FROM User Apartment or Suite field$")
    public void enterTextInFromAptSuite(String valueTOEnter) throws InterruptedException, IOException {
    	enterValue(addressEntryObjects.fromfieldAddress2, valueTOEnter);
    }

    @When("User Enters Value:\"([^\"]*)\" in FROM User Address and select from the predictive list")
    public void userEntersValueInFROMUserAddressAndSelectFromThePredictiveList(String valueToEnter) throws InterruptedException, IOException{
        enterValue(addressEntryObjects.fromfieldAddress1, valueToEnter);
        addressEntryObjects.googleAddressDropdown.click();
    }

    @Then("^User Enters Value:\"([^\"]*)\" in TO User Company$")
    public  void enterTextInTOUserCompany(String valueToEnter) throws InterruptedException, IOException {
        enterValue(addressEntryObjects.tofieldCompany, valueToEnter);
    }

    @When("Navigate to TO section after updating in FROM section")
    public void navigate_to_TO_section_after_updating_in_FROM_section() throws InterruptedException {
        waitForElement(addressEntryObjects.fromfieldUpdate);
        clickOnElement(addressEntryObjects.fromfieldUpdate);
    }

    @Then("^Error message \"([^\"]*)\" should display below \"([^\"]*)\" field in To module$")
    public void toFieldError(String errorMessage, String fieldName) throws Exception {
        fieldError(errorMessage ,fieldName ,addressEntryObjects);
    }

    @Then("^Application should not display error message \"([^\"]*)\" below \"([^\"]*)\" field in To module$")
    public void toNameFieldError(String errorMessage, String fieldName) throws Exception {
        NameFieldError(errorMessage ,fieldName ,addressEntryObjects);
    }

    @Then("^Error message \"([^\"]*)\" should display below \"([^\"]*)\" field in From module$")
    public void fromFieldError(String errorMessage, String fieldName) throws Exception {
        fieldError1(errorMessage ,fieldName ,addressEntryObjects);
    }

    @Then("^Application should not display error message \"([^\"]*)\" below \"([^\"]*)\" field in From module$")
    public void fromNameFieldError(String errorMessage, String fieldName) throws Exception {
        NameFieldError1(errorMessage ,fieldName ,addressEntryObjects);
    }
    @Then("^Verify filter out address are of:\"([^\"]*)\" in FROM field google address$")
    public void verifyGoogleAddressDropdownFROMField(String countryName) throws IOException {
        toverifyGoogleAddressDropdownField(countryName);
    }
    @Then("^Verify Error Element is Not Displayed$")
    public  void checkErrorElementNotDisplayedUsingClassPath(List<String> classPath)throws IOException {
        verify_element_not_displayed(classPath);
        if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
            closekeyboard();
        }
        }
    @When("^User:\"([^\"]*)\" logs in to Shipping application based on testlevel$")
    public  void loginBasedOnTestLevels(String reference) throws IOException {
        JSONObject loginDetails = homePageObjects.getLoginDetailsBasedOnTestLevels(getProp("level"),reference);
        logintoShipping(addressEntryObjects,homePageObjects,loginDetails.get("ID").toString(), loginDetails.get("PASSWORD").toString());
    }
    
    @Then("^User Enters Value:\"([^\"]*)\" in TO User Apartment or Suite field$")
    public  void enterTextInTOAptSuite(String valueToEnter) throws InterruptedException, IOException {
    	enterValue(addressEntryObjects.tofieldAddress2, valueToEnter);
    }
    
    @Then("^User Enters Value:\"([^\"]*)\" in TO User Address$")
    public  void enterTextInTOAddress(String valueToEnter) throws InterruptedException, IOException {
    	enterValue(addressEntryObjects.tofieldAddress1, valueToEnter);
    }
    
    @Then("^Verify filter out address are of:\"([^\"]*)\" in TO field google address$")
    public void verifyGoogleAddressDropdown(String countryName) throws IOException {
    	toverifyGoogleAddressDropdownField(countryName);
    }
    
    @When("User Enters Value:\"([^\"]*)\" in TO User Address and select from the predictive list")
    public void userEntersValueInTOUserAddressAndSelectFromThePredictiveList(String valueToEnter) throws InterruptedException, IOException {
    	enterValue(addressEntryObjects.tofieldAddress1, valueToEnter);
        addressEntryObjects.googleAddressDropdown.click();
    }
    
    @Then("^User Enters Value:\"([^\"]*)\" in TO User Phone number$")
    public  void enterTextInTOPhoneNumber(String valueToEnter) throws InterruptedException, IOException {
    	enterValue(addressEntryObjects.tofieldPhnNum, valueToEnter);
    }

    @Given("User:\"([^\"]*)\" logs in with password:\"([^\"]*)\" in mags$")
    public void user_logs_in_with_password_in_mags(String string, String string2) throws IOException, InterruptedException {
        if ((getProp("level")).equalsIgnoreCase("L3")) {
            homePageObjects.loginWithCredentials("L3AU798618105","Test1234");
        } else if ((getProp("level")).equalsIgnoreCase("L6")){
            homePageObjects.loginWithCredentials("L6AU798618105","Test1234");
        }else if((getProp("level")).equalsIgnoreCase("L2")){
            homePageObjects.loginWithCredentials("L2AU798618105","Test1234");
        }
    }
    
    }
