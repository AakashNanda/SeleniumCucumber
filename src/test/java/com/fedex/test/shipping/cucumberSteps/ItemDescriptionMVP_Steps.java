package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.HomePageObjects;
import com.fedex.test.shipping.ObjectsRepository.PackagingAndShipmentDetailsObjects;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

@SuppressWarnings("deprecation")
public class ItemDescriptionMVP_Steps extends SeleniumReusableMethods {

    public PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects;
    public HomePageObjects homePageObjects;

	public ItemDescriptionMVP_Steps(SharedDriverManager driver, PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects, HomePageObjects homePageObjects) {
        this.packagingAndShipmentDetailsObjects=packagingAndShipmentDetailsObjects;
        this.homePageObjects=homePageObjects;
	}


    
    @Then("^User enters value:\"([^\"]*)\" in Declared Value$")
    public void User_enters_value_in_Declared_Value(String valuetoEnter) throws InterruptedException, IOException{
    	enterValue(packagingAndShipmentDetailsObjects.declareValue, valuetoEnter);
    }
    
    @Then("^User is in \"([^\"]*)\" page$")
    public void User_is_in_page(String pagename){
        homePageObjects.verifyPageIsActive(pagename);
    }

    @Then("^User selects:\"([^\"]*)\" button in Shipment Details$")
    public void User_selects_items_Or_Documents_button(String valuetoSelect){
        packagingAndShipmentDetailsObjects.selectItemOrDocument(valuetoSelect);
        //scrollToElement(packagingAndShipmentDetailsObjects.hsCodeTip);
    }
    
    @Then("^User Enters Value:\"([^\"]*)\" Shipment Non Docs Item Description$")
    public void User_enters_value_items_description(String value) throws InterruptedException, IOException{
            enterValue(packagingAndShipmentDetailsObjects.itemsDesc, value);
    }
    
    @Then("^Verify help text is displaying in hs tooltip$")
    public void Verify_help_text_display_tooltip() throws Exception{
        scrollToElement(packagingAndShipmentDetailsObjects.hsCodeTip);
	    clickOnElement(packagingAndShipmentDetailsObjects.hsCodeTip);
    	verify_hs_tooltip(packagingAndShipmentDetailsObjects.hsCodeTip,packagingAndShipmentDetailsObjects.hstoolTip);
    }

    @Then("^User clicks on Document Shipment Details continue button$")
    public void User_clicks_shipment_continue_button() throws InterruptedException {
	    waitForElement(packagingAndShipmentDetailsObjects.shipmentContinue);
	    scrollToElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        clickOnElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        Thread.sleep(3000);
    }

    @Then("^User clicks on CI Document Shipment Details continue button$")
    public void User_clicks_shipment_continue_button_CI() throws InterruptedException {
	    waitForElement(packagingAndShipmentDetailsObjects.shipmentContinue);
        clickOnElement(packagingAndShipmentDetailsObjects.shipmentContinue);
    }
    
    @Then("^User Enter Value:\"([^\"]*)\" In Item name field in Save as new Item$")
    public  void enterTextInNewItemName(String newItemName) throws InterruptedException, IOException {
    	packagingAndShipmentDetailsObjects.random_item_name = newItemName + getCurrentTimeUsingDate();
        enterValue(packagingAndShipmentDetailsObjects.itemProfileName, packagingAndShipmentDetailsObjects.random_item_name);
    }
    @Then("User Selects previously saved item name from saved item names$")
    public void selectPreviouslySavedItem() throws Exception {
        enterTextInSavedItemField(packagingAndShipmentDetailsObjects.random_item_name);
        clickOnElement(packagingAndShipmentDetailsObjects.savedItem);
    }
    
    @Then("^User Enter Value:\"([^\"]*)\" In saved Item feild$")
    public  void enterTextInSavedItemField(String valueToEnter) {
        enterTextInGivenElement(packagingAndShipmentDetailsObjects.field_savedItem, valueToEnter);
    }
}