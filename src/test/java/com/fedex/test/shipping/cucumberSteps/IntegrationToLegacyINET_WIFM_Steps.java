package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ObjectsRepository.HomePageObjects;
import com.fedex.test.shipping.ObjectsRepository.INETWIFMPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class IntegrationToLegacyINET_WIFM_Steps extends SeleniumReusableMethods {

    public HomePageObjects homePageObjects;
    public INETWIFMPageObjects inetwifmPageObjects;
    public AddressEntryObjects addressEntryObjects;

    public IntegrationToLegacyINET_WIFM_Steps(SharedDriverManager driver,HomePageObjects homePageObjects, INETWIFMPageObjects inetwifmPageObjects
                                                   ,AddressEntryObjects addressEntryObjects){
        this.homePageObjects=homePageObjects;
        this.inetwifmPageObjects=inetwifmPageObjects;
        this.addressEntryObjects=addressEntryObjects;
    }


    @Then("Close the AEM header if it is displayed")
    public void close_the_AEM_header_if_it_is_displayed() {
        if (elementisDisplayedAndEnabled(homePageObjects.alertMessageOnHeader)){
            homePageObjects.alertMessageOnHeader.click();
        }
    }

    @Then("The information should be displayed in:\"([^\"]*)\" color on the \"([^\"]*)\"$")
    public void the_information_should_be_displayed_in_color_on_the(String color, String classPath) throws Exception  {
        scrollToElement(addressEntryObjects.summaryFromedit);
        WebElement element = getWebElementByClassPath(classPath);
        colorVerification(color,element);
    }

    @Then("For Logged in user the account name should be displayed in My Shipment Account-XXX format in app bar")
    public void for_Logged_in_user_the_account_name_should_be_displayed_in_My_Shipment_Account_XXX_format_in_app_bar(){
        logged_In_User_Account_Format(homePageObjects.Appbar,homePageObjects.accountdropDown);
    }

    @Then("A modal window should be displayed")
    public void a_modal_window_should_be_opened() throws Exception {
        Assert.assertTrue(elementisDisplayedAndEnabled(homePageObjects.ModalWindow),"Element is visible");
    }

    @Then("The cross icon should be available on the displayed modal window")
    public void the_cross_icon_should_be_available_on_the_displayed_modal_window() {
        Assert.assertTrue(elementisDisplayedAndEnabled(homePageObjects.CloseModalWindow),"Element is not visible");
    }

    @When("Click on cross icon available on modal window")
    public void click_on_cross_icon_available_on_modal_window() throws Exception {
        waitForElement(homePageObjects.CloseModalWindow);
        clickOnElement(homePageObjects.CloseModalWindow);
    }

    @Then("The model window should be closed and application should be visible")
    public void the_model_window_should_be_closed_and_application_should_be_visible() {
        verify_Element_Not_Displayed_WithoutClassPath(homePageObjects.ModalWindow,homePageObjects.Appbar);
    }

    @Then("Logged in user able select account in app bar")
    public void logged_in_user_able_select_account_in_app_bar() throws InterruptedException {
        select_Account_In_Appbar(homePageObjects.Appbar,homePageObjects.accountdropDown,homePageObjects.accountnameinList);
    }

    @Then("user should be routed to INET application in logged in state.")
    public void user_should_be_routed_to_INET_application_in_logged_in_state() {
        waitForElement(inetwifmPageObjects.inetLoginState);
        elementisDisplayedAndEnabled(inetwifmPageObjects.inetLoginState);
        elementisDisplayedAndEnabled(inetwifmPageObjects.inetCreateShipment);
    }

    @Then("Verify the Data is getting prepopulated in WIFM")
    public void dataVerificationiInWIFM(){
        inetwifmPageObjects.datapopulationinWIFM();
    }

    @Then("user should be routed to WIFM application in logged in state.")
    public void user_should_be_routed_to_WIFM_application_in_logged_in_state() {
        waitForElement(inetwifmPageObjects.wifmCreateShipment);
        elementisDisplayedAndEnabled(inetwifmPageObjects.inetLoginState);
        elementisDisplayedAndEnabled(inetwifmPageObjects.wifmCreateShipment);

    }

    @When("^Verify Account Selection from Account dropdown")
    public void verifyAppBarAccountDropwdown() {
        verifyAccountSelection(homePageObjects.appbarAccountList.get(1),homePageObjects.appbarAccountListItem);
    }

    @Then("^Verify Account Number selected is bold in font")
    public void verifyAccountInBoldFormat() {
        String actualValue=homePageObjects.appbarAccountListItem.getCssValue("class");
        String expectedValue="fdx-c-navbar__menu__item__button fdx-u-text--bold ng-star-inserted";
        compareTextValue(actualValue,expectedValue);
    }

    @And("^User clicks on Appbar dropdown$")
    public void userClicksOnAppbarDropdown() throws Throwable {
        scrollToElement(addressEntryObjects.summaryFromedit);
        clickOnElement(homePageObjects.accountdropDown);
    }
    @Then("application should navigate to \"([^\"]*)\" page")
    public void application_should_navigate_to_page(String page) {
        to_application_should_navigate_to_page(page,homePageObjects);
    }

    @Then("^User clicks on return to old version from appbar$")
    public void userClicksOnReturnToOldVersionFromAppbar() throws Throwable {
        scrollToElement(addressEntryObjects.summaryFromedit);
        clickOnElement(inetwifmPageObjects.returnToOldVersion);


    }

    @And("^User clicks on return to old version from modal$")
    public void userClicksOnReturnToOldVersionFromModal() throws Throwable {
        clickOnElement(inetwifmPageObjects.advancedShippingButton);
    }
}
