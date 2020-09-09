package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.ShipmentHistoryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ShipmentHistory_Steps extends SeleniumReusableMethods {

    public ShipmentHistoryPageObjects shipmentHistoryPageObjects;
    public ShipmentHistory_Steps(SharedDriverManager driver,ShipmentHistoryPageObjects shipmentHistoryPageObjects){
        this.shipmentHistoryPageObjects=shipmentHistoryPageObjects;
    }

    @When("User navigates to the shipment history page")
    public void user_navigates_to_the_shipment_history_page() {
        try {
            scrollToElement(shipmentHistoryPageObjects.KababMenu);
            clickOnElement(shipmentHistoryPageObjects.KababMenu);
            clickOnElement(shipmentHistoryPageObjects.ShipmentHistoryink);
//            DriverGenerator.getDriver().navigate().to(getAppURL()+"#/shipment-history");
//            DriverGenerator.getDriver().navigate().refresh();
            Thread.sleep(5000);
        }catch(Exception e){
            Assert.fail();
        }
    }
    @Given("^I change my locale to \"([^\"]*)\"$")
    public void iChangeMyLocaleTo(String fdxLoclae) {
        DriverGenerator.getDriver().manage().deleteCookieNamed("fdx_locale");
        DriverGenerator.getDriver().manage().addCookie(new Cookie("fdx_locale", fdxLoclae));
        DriverGenerator.getDriver().navigate().refresh();
    }

    @Then("Verify CreateShipment Appbar and shipmenthistory title")
    public void verify_CreateShipment_Appbar_and_shipmenthistory_title() {
        try {
             waitForElement(shipmentHistoryPageObjects.CreateShipment);
             getTextFromAndCompareTextWithUI(shipmentHistoryPageObjects.CreateShipment,getShippingNavbarDemoComponentData("createShipment"));
             getTextFromAndCompareTextWithUI(shipmentHistoryPageObjects.ShipmentHistoryTitle,"Your Shipment History");
             verifyElementIsDisplayed(shipmentHistoryPageObjects.NoOfShipment);
        }catch(Exception e){
         e.printStackTrace();
        }
    }

    @Then("Verify one Shipments are available in shipment history page")
    public void verify_one_Shipments_are_available_in_shipment_history_page() {
        waitForElement(shipmentHistoryPageObjects.ZeroShipments);
        try {
            getTextFromAndCompareTextWithUI(shipmentHistoryPageObjects.ZeroShipments, "1 Shipments");

        }catch(Exception e){

        }
    }
    @When("Verify error message for search result returns when invalid data enters")
    public void verify_error_message_for_search_result_returns_when_invalid_data_enters(List<String> valueToSelect , List<String> valueToEnter) {

        ArrayList<String> values = new ArrayList<>(valueToEnter);
        for (int i=0;i<=5;i++) {
           System.out.println("select"+valueToSelect.get(i)+"value"+valueToEnter.get(i));
          //  verifyErrorMessageForGivenElement(addressEntryObjects.userEmailfROM, addressEntryObjects.fromuserEmailerror, val, getEmailValidationError("validationErrorSection.email", "pattern"));
        }
    }



}
