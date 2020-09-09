package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ObjectsRepository.HomePageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class CustomerFeedback_Steps extends SeleniumReusableMethods {

    public HomePageObjects homePageObjects;
    public AddressEntryObjects addressEntryObjects;


    public CustomerFeedback_Steps(SharedDriverManager driver, HomePageObjects homePageObjects, AddressEntryObjects addressEntryObjects) {
        this.homePageObjects=homePageObjects;
        this.addressEntryObjects=addressEntryObjects;
    }


    @Then("User clicks on close icon button in customer feedback popup")
    public void userClicksOnCloseIconButtonInCustomerFeedbackPopup() {
        try{

            if(elementisDisplayedAndEnabled(homePageObjects.customerFeedbacknoThanks)&& getProp("level").equalsIgnoreCase("L6")){
                clickOnElement(homePageObjects.customerFeedbacknoThanks);
                clickOnElement(homePageObjects.customerFeedbackPopUpcloseIcon);

            }else if(elementisDisplayedAndEnabled(homePageObjects.customerFeedbackPopUpcloseIcon)&& getProp("level").equalsIgnoreCase("L6")){
                clickOnElement(homePageObjects.customerFeedbackPopUpcloseIcon);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
