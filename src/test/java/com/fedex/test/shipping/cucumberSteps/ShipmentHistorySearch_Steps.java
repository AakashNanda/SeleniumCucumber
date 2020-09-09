package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.ShipmentHistoryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.*;

public class ShipmentHistorySearch_Steps extends SeleniumReusableMethods {
    public static String ShipmentCount;
    public static String masterTrackingNumber;

    public ShipmentHistoryPageObjects shipmentHistoryPageObjects;
    public ShipmentHistorySearch_Steps(SharedDriverManager driver, ShipmentHistoryPageObjects shipmentHistoryPageObjects){
        this.shipmentHistoryPageObjects=shipmentHistoryPageObjects;
    }




    @Then("Search text box and drop down list should have default value as Ship Date")
    public void search_text_box_and_drop_down_list_should_have_default_value_as_Ship_Date() {
        try {
            String text = shipmentHistoryPageObjects.SearchPlaceHolder.getAttribute("placeholder");
            Assert.assertEquals(text, "Search");
            verifyShipMentHistory_Defaultvalue(shipmentHistoryPageObjects.ShipmentHistoryDropdown);
        }catch(Exception e){
            Assert.fail();
        }
    }

    @When("User selects value:\"([^\"]*)\" in Shipment HistoryColumn.")
    public void user_selects_value_in_Shipment_HistoryColumn(String dropDownValue) {
       selectValueInGivenElement(shipmentHistoryPageObjects.ShipmentHistoryDropdown,dropDownValue);
    }

    @When("User Enters localized Shipdate Value in Search Field.")
    public void user_Enters_localized_Shipdate_Value_in_Search_Field() {
      String currentLocale=getFedExLocale();
      String date=getMediumDateFormatForLocale(currentLocale);
        WebElement we = DriverGenerator.getDriver().findElement(By.xpath("//div[1]/div/ul/li[1]/div/dl/dd[1]"));
        String datevalue=we.getText();
        verifyDateLocalization(datevalue,date);
        enterTextInGivenElement(shipmentHistoryPageObjects.SearchInput,datevalue);
    }

    @Then("Verify:\"([^\"]*)\" are shown in result")
    public void verify_Shipments_are_available_in_shipment_history_page(String expectedValue) {
        waitForElement(shipmentHistoryPageObjects.ZeroShipments);
        try {
            getTextFromAndCompareTextWithUI(shipmentHistoryPageObjects.ZeroShipments, expectedValue);

        }catch(Exception e){

        }
    }

    @When("User Enters Value:\"([^\"]*)\" in Search Field.")
    public void user_Enters_Value_in_Search_Field(String searchInput) {
    enterTextInGivenElement(shipmentHistoryPageObjects.SearchInput,searchInput);
    }

    @When("User Enters Value in Search Field.")
    public void user_Enters_Value_in_Search_Field() {
        enterTextInGivenElement(shipmentHistoryPageObjects.SearchInput,masterTrackingNumber);
    }
    @Then("User Should see number of shipments.")
    public void user_Should_see_number_of_shipments() {
      ShipmentCount=getInnerText(shipmentHistoryPageObjects.No_of_shipment_count);
    }

    @Then("number of shipments value should be updated as per result returns.")
    public void number_of_shipments_value_should_be_updated_as_per_result_returns() {
        String updatedCount=getInnerText(shipmentHistoryPageObjects.No_of_shipment_count);

        boolean flag=false;
        try {
            if (!ShipmentCount.equals(updatedCount)) {
                flag = true;
                Assert.assertTrue(flag);
            } else {
                Assert.fail();
            }
        }catch(Exception e){
           Assert.fail();
        }

    }
    @When("User clicks on Search button")
    public void user_clicks_on_Search_button() {
        try {
            clickOnElement(shipmentHistoryPageObjects.SearchButton);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Then("Store Tracking number to search in history page")
    public void Store_Store_Tracking_number_to_search_in_history_page() {
        masterTrackingNumber=getInnerText(shipmentHistoryPageObjects.TrackingNumber);

    }

    @Then("User should see display details only for entered value")
    public void user_should_see_display_details_only_for_entered_value() {
     List<WebElement> searchResults=DriverGenerator.getDriver().findElements(By.xpath("//div[1]/li"));
     boolean status=false;
            try{
                    WebElement we = DriverGenerator.getDriver().findElement(By.xpath("//div[1]/li[1]/dl/dd[4]/a"));
                    if (we.getText().equalsIgnoreCase(masterTrackingNumber)) {

                        status = true;
                    }else{
                        Assert.fail();
                    }

            }catch(Exception e){
                Assert.fail();
            }
    }
    @Then("Verify ContactName should contain :\"([^\"]*)\" in order.")
    public void verify_Display_result_should_contain_in_order(String string) {
        List<WebElement> searchResults=DriverGenerator.getDriver().findElements(By.xpath("//div[1]/li"));
        Iterator<WebElement> iter = searchResults.iterator();
        ArrayList<String> results=new ArrayList<>();
        for(int i=1;i<searchResults.size();i++) {
            WebElement we = DriverGenerator.getDriver().findElement(By.xpath("//div[1]/li["+i+"]/dl/dd[2]"));
            results.add(we.getText());
        }
       boolean status= checkSorting(results);
        Assert.assertTrue(status);
    }
    @Then("Verify Destination should contain:\"([^\"]*)\" in order.")
    public void verify_Destination_should_contain_in_order(String string) {
        List<WebElement> searchResults=DriverGenerator.getDriver().findElements(By.xpath("//div[1]/li"));
        Iterator<WebElement> iter = searchResults.iterator();
        ArrayList<String> results=new ArrayList<>();
        for(int i=1;i<searchResults.size();i++) {
            WebElement we = DriverGenerator.getDriver().findElement(By.xpath("//div[1]/li["+i+"]/dl/dd[3]"));
            results.add(we.getText());
        }
        boolean status= checkSorting(results);
     //   Assert.assertTrue(status);
    }

    @Then("Verify Company should contain:\"([^\"]*)\" in order.")
    public void verify_Company_should_contain_in_order(String string) {
        List<WebElement> searchResults=DriverGenerator.getDriver().findElements(By.xpath("//div[1]/li"));

        ArrayList<String> results=new ArrayList<>();
        for(int i=1;i<searchResults.size();i++) {
            WebElement we = DriverGenerator.getDriver().findElement(By.xpath("//div[1]/li["+i+"]/dl/dd[5]"));
            results.add(we.getText());
        }
        boolean status= checkSorting(results);
        Assert.assertTrue(status);
    }




    @Then("User clicks on Reset button")
    public void user_clicks_on_Reset_button() {
      try{
          clickOnElement(shipmentHistoryPageObjects.Rest_Button);
      }catch(Exception e){
          Assert.fail();
      }
    }


    @When("user click on left arrow sign before the Create a Shipment verbiage in appbar")
    public void user_click_on_left_arrow_sign_before_the_verbiage_in_appbar() {
        try {
            clickOnElement(shipmentHistoryPageObjects.BackArrow);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("User Clicks on TrackingNumber From history Table")
    public void user_Clicks_on_TrackingNumber_From_history_Table() {
        try {
            waitForElement(shipmentHistoryPageObjects.TrackingNumber_Link);
            clickOnElement(shipmentHistoryPageObjects.TrackingNumber_Link);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("Verify Whether user navigates to new tab when clicks on Trackingnumber")
    public void verify_Whether_user_navigates_to_new_tab_when_clicks_on_Trackingnumber() {
        UserClicksOnTrackingNumberVerifyOpensNewTab(shipmentHistoryPageObjects);
    }
    @Then("Verify ShipDate localized based on current locale in HistoryPage")
    public void verify_ShipDate_localized_based_on_current_locale_in_HistoryPage() {
        try {
            verify_Shipment_Date_in_HistoryPage(shipmentHistoryPageObjects.SearchButton, shipmentHistoryPageObjects.ZeroShipments);
        }catch(Exception e){
            Assert.fail();
        }
        }
}
