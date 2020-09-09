package com.fedex.test.shipping.cucumberSteps;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.fedex.test.shipping.ObjectsRepository.PickUpAndDropOffObjects;
import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PickupSelection_Steps extends SeleniumReusableMethods{
	
	 public PickUpAndDropOffObjects pickUpAndDropOffObjects;
	 
	    public PickupSelection_Steps(SharedDriverManager driver, PickUpAndDropOffObjects pickUpAndDropOffObjects) throws IOException {
	        this.pickUpAndDropOffObjects=pickUpAndDropOffObjects;
	    }

	@Then("^Verify readyTime before latestTime alert message when readyTime is :\"([^\"]*)\" and : \"([^\"]*)\" as latestTime$")
    public void verifyReadyTimeBeforeLatestTimeAlertMessageWhenReadyTimeIsAndAsLatestTime(String readyTime, String latestTime) throws Throwable {
		toVerifyReadyTimeBeforeLatestTimeAlertMessageWhenReadyTimeIsAndAsLatestTime(readyTime,latestTime,pickUpAndDropOffObjects);
    }
	
	@And("^Verify Minimum access hour alert message when readyTime is :\"([^\"]*)\" and : \"([^\"]*)\" as latestTime for :\"([^\"]*)\" hour as access hour$")
    public void verifyMinimumAccessHourAlertMessageWhenReadyTimeIsAndAsLatestTime(String readyTime, String latestTime,String accessHour) throws Throwable {
		toVerifyMinimumAccessHourAlertMessageWhenReadyTimeIsAndAsLatestTime(readyTime,latestTime,accessHour,pickUpAndDropOffObjects);
    }


}
