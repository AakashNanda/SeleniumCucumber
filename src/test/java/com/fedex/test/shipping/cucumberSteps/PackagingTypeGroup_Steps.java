package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ObjectsRepository.HomePageObjects;
import com.fedex.test.shipping.ObjectsRepository.PackagingAndShipmentDetailsObjects;
import com.fedex.test.shipping.ObjectsRepository.SummaryCardObjectsPackagingDetails;
import com.fedex.test.shipping.ResuableJavaFactory.DriverFactory;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
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
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("deprecation")

public class PackagingTypeGroup_Steps extends SeleniumReusableMethods {

    public PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects;
    public SummaryCardObjectsPackagingDetails SummaryCardObjectsPackagingDetails;
    public HomePageObjects HomePageObjects;

	public PackagingTypeGroup_Steps(SharedDriverManager driver, 
			PackagingAndShipmentDetailsObjects packagingAndShipmentDetailsObjects,
			SummaryCardObjectsPackagingDetails SummaryCardObjectsPackagingDetails,
                                    HomePageObjects HomePageObjects) {
		
        this.packagingAndShipmentDetailsObjects=packagingAndShipmentDetailsObjects;
        this.SummaryCardObjectsPackagingDetails=SummaryCardObjectsPackagingDetails;
        this.HomePageObjects =HomePageObjects;

	}

    
    @Then("^User selects YES for liability Coverage Declared value$")
    public void selectYesRadioButton() throws InterruptedException, IOException {
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            waitForElement(packagingAndShipmentDetailsObjects.yesCoverage);
            clickOnElement(packagingAndShipmentDetailsObjects.yesCoverage);
        } else {
            waitForElement(packagingAndShipmentDetailsObjects.yesCoverageMob);
            clickOnElement(packagingAndShipmentDetailsObjects.yesCoverageMob);
        }
    }

    @Then("^User clicks on Package Submit Button$")
    public void User_clicks_Submit_Button() throws InterruptedException {
	    waitForElement(packagingAndShipmentDetailsObjects.packagingSubmit);
        clickOnElement(packagingAndShipmentDetailsObjects.packagingSubmit);
//        reClickOnElement(packagingAndShipmentDetailsObjects.packagingSubmit);
    }
    
    @Then("^Verify label text of each field in packaging section is loaded wrt locale$")
    public void verifyLabelText() {
	    packagingAndShipmentDetailsObjects.verifylabelInpackagesection();
    }
    
    @Then("^Verify Package Type Default Option is Your Packaging$")
    public void verifyPackageTypeDefaultOptions() throws Exception{
        //feedbackPopupClose();
        getTextInSelectElement(packagingAndShipmentDetailsObjects.packagingType);
    }
   
    @Then("^User selects value:\"([^\"]*)\" in Package Weight Unit$")
    public void selectWeightUnit(String valueToSelect) {
    	selectByIndex(packagingAndShipmentDetailsObjects.packageWeightunit,valueToSelect);
    }
    
    @Then("^Verify dimension unit option is:\"([^\"]*)\"$")
    public void verifyDimensionUnitDefaultOptions(String valueToEnter) throws Exception {
    	getTextFromAndCompareTextWithUI(packagingAndShipmentDetailsObjects.shipmentDetailsUnits.get(1), valueToEnter);
    }
    
    @Then("^Verify liability coverage toolTip Text is as per language loaded$")
    public void verifyCoverageToolTip() throws JSONException, IOException {
        verifyToolTipText(packagingAndShipmentDetailsObjects.coveragetooltip,packagingAndShipmentDetailsObjects.coveragetooltipMessage, getLiabilityCoverageComponentData("coverageTooltipText"));
    }

    
    @When("^Verify liability coverage error message is displayed:\"([^\"]*)\"$")
    public void verifyLiabilityCoverage(String errorKey) {
        try {
            waitForElement(packagingAndShipmentDetailsObjects.declaredvalueRequired);
            getTextFromAndCompareTextWithUI(packagingAndShipmentDetailsObjects.declaredvalueRequired, getLiabilityCoverageComponentData(errorKey));
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Then("^User enters value:\"([^\"]*)\" in Dimension Length$")
    public void enterLengthDim(String length) throws InterruptedException, IOException{
        enterValue(packagingAndShipmentDetailsObjects.dimLength, length);
    }

    @Then("^User enters value:\"([^\"]*)\" in Dimension Heigth$")
    public void enterHeightDim(String height) throws InterruptedException, IOException{
        enterValue(packagingAndShipmentDetailsObjects.dimHeight, height);
    }

    @Then("^User enters value:\"([^\"]*)\" in Dimension Width$")
    public void enterWidthDim(String width) throws InterruptedException, IOException{
        enterValue(packagingAndShipmentDetailsObjects.dimWidth, width);
    }

    @Then("^User Enter Value:\"([^\"]*)\" dimention profile name feild$")
    public void enterTextInAdditionalInvoiceInfoTwo(String valueToEnter) throws IOException, InterruptedException {
        enterValue(packagingAndShipmentDetailsObjects.dimensionsProfileNameField,valueToEnter);
    }

    @Then("^User enters value:\"([^\"]*)\" X \"([^\"]*)\" X \"([^\"]*)\" in Dimension$")
    public void User_enters_value_in_Dimensions(String length, String height, String width) throws InterruptedException, IOException{
        enterLengthDim(length);
        enterWidthDim(width);
        enterHeightDim(height);
    }

    @Then("^User enters value:\"([^\"]*)\" X \"([^\"]*)\" X \"([^\"]*)\" in value:\"([^\"]*)\" Dimension$")
    public void User_enters_value_in_Dimensions(String length, String width, String height, Integer row) throws InterruptedException, IOException{
        if( row == 1 ) {
            enterValue(packagingAndShipmentDetailsObjects.SecondRowDimenstionL, length);
            enterValue(packagingAndShipmentDetailsObjects.SecondRowDimenstionW, width );
            enterValue(packagingAndShipmentDetailsObjects.SecondRowDimenstionH, height);
        } else if( row == 2 ) {
            enterValue(packagingAndShipmentDetailsObjects.TheardRowDimenstionL, length);
            enterValue(packagingAndShipmentDetailsObjects.TheardRowDimenstionW, width );
            enterValue(packagingAndShipmentDetailsObjects.TheardRowDimenstionH, height);
        } else if( row == 3 ) {
            enterValue(packagingAndShipmentDetailsObjects.ForthRowDimentionL, length);
            enterValue(packagingAndShipmentDetailsObjects.ForthRowDimentionW, width );
            enterValue(packagingAndShipmentDetailsObjects.ForthRowDimentionH, height);
        } else if( row == 4 ) {
            enterValue(packagingAndShipmentDetailsObjects.FithRowDimenstionL, length);
            enterValue(packagingAndShipmentDetailsObjects.FithRowDimenstionW, width );
            enterValue(packagingAndShipmentDetailsObjects.FithRowDimenstionH, height);
        }
    }

    @And("^User selects value:\"([^\"]*)\" from number of pakages$")
    public void selectFromUserCountry(String valueFROMSelect) throws InterruptedException {
        waitForElement(packagingAndShipmentDetailsObjects.numberOfPackages);
        selectValuebyValue(packagingAndShipmentDetailsObjects.numberOfPackages, valueFROMSelect);
    }

    @And("^User selects value:\"([^\"]*)\" from number of pakages in value:\"([^\"]*)\" row$")
    public void selectFromUserCountry(String valueFROMSelect, Integer row) throws InterruptedException {
	    if( row == 1 ){
            waitForElement(packagingAndShipmentDetailsObjects.numbOfPackagesRowtwo);
            selectValuebyValue(packagingAndShipmentDetailsObjects.numbOfPackagesRowtwo, valueFROMSelect);
        } else if( row == 2 ){
            waitForElement(packagingAndShipmentDetailsObjects.numbOfPackagesRowthree);
            selectValuebyValue(packagingAndShipmentDetailsObjects.numbOfPackagesRowthree, valueFROMSelect);
        } else if( row == 3 ){
            waitForElement(packagingAndShipmentDetailsObjects.numbOfPackagesRowfour);
            selectValuebyValue(packagingAndShipmentDetailsObjects.numbOfPackagesRowfour, valueFROMSelect);
        } else if( row == 4 ){
            waitForElement(packagingAndShipmentDetailsObjects.numbOfPackagesRowfive);
            selectValuebyValue(packagingAndShipmentDetailsObjects.numbOfPackagesRowfive, valueFROMSelect);
        }
    }

    @Then("user click on the saved dimension profile$")
    public void selectPreviouslySavedItem() throws Exception {
        clickOnElement(packagingAndShipmentDetailsObjects.savedItem);
    }

    @Then("^User Selects Packaging Type:\"([^\"]*)\" in Package Type Field$")
    public void User_selects_packagingType(String valuetoSelect) throws InterruptedException, IOException{
        HomePageObjects.feedbackPopupClose();
        if(Property.getProp("platform").equalsIgnoreCase("mobile")){
            selectValueByValueMobile("id" , packagingAndShipmentDetailsObjects.packageTypeid, valuetoSelect);
        }else{
            selectValuebyValue(packagingAndShipmentDetailsObjects.packagingType, valuetoSelect);
        }
    }

    @Then("^User enters value:\"([^\"]*)\" in Package Weight$")
    public void User_enters_value_in_Package_Weight(String valuetoEnter) throws InterruptedException, IOException{
        HomePageObjects.feedbackPopupClose();
        waitForElement(packagingAndShipmentDetailsObjects.packagingWeight);
        enterValue(packagingAndShipmentDetailsObjects.packagingWeight, valuetoEnter);
    }

    @Then("^User enters value:\"([^\"]*)\" in Package Weight in value:\"([^\"]*)\" row$")
    public void User_enters_value_in_Package_Weight(String valuetoEnter, Integer row) throws InterruptedException, IOException{
        if( row == 1 ){
            waitForElement(packagingAndShipmentDetailsObjects.packageWeightRowtwo);
            enterValue(packagingAndShipmentDetailsObjects.packageWeightRowtwo, valuetoEnter);
        } else if ( row == 2 ){
            waitForElement(packagingAndShipmentDetailsObjects.packageWeightRowthree);
            enterValue(packagingAndShipmentDetailsObjects.packageWeightRowthree, valuetoEnter);
        } else if ( row == 3 ){
            waitForElement(packagingAndShipmentDetailsObjects.packageWeightRowfour);
            enterValue(packagingAndShipmentDetailsObjects.packageWeightRowfour, valuetoEnter);
        } else if ( row == 4 ){
            waitForElement(packagingAndShipmentDetailsObjects.packageWeightRowfive);
            enterValue(packagingAndShipmentDetailsObjects.packageWeightRowfive, valuetoEnter);
        }
    }

    @Then("^User enters value:\"([^\"]*)\" in Coverage Value$")
    public void enterValueInCoverageDeclaredValue(String valuetoEnter) throws IOException, InterruptedException {
        waitForElement(packagingAndShipmentDetailsObjects.coverageValue);
	    enterValue(packagingAndShipmentDetailsObjects.coverageValue, valuetoEnter);
    }

    @Then("^User enters value:\"([^\"]*)\" in Coverage Value in value:\"([^\"]*)\" row$")
    public void enterValueInCoverageDeclaredValue(String valuetoEnter, Integer row) throws IOException, InterruptedException {
        if( row == 1 ){
            waitForElement(packagingAndShipmentDetailsObjects.coverageValRowtwo);
            enterValue(packagingAndShipmentDetailsObjects.coverageValRowtwo, valuetoEnter);
        } else if ( row == 2 ){
            waitForElement(packagingAndShipmentDetailsObjects.coverageValRowthree);
            enterValue(packagingAndShipmentDetailsObjects.coverageValRowthree, valuetoEnter);
        } else if ( row == 3 ){
            waitForElement(packagingAndShipmentDetailsObjects.coverageValRowfour);
            enterValue(packagingAndShipmentDetailsObjects.coverageValRowfour, valuetoEnter);
        } else if ( row == 4 ){
            waitForElement(packagingAndShipmentDetailsObjects.coverageValRowfive);
            enterValue(packagingAndShipmentDetailsObjects.coverageValRowfive, valuetoEnter);
        }
    }
    
    @Then("^Verify dimension error is displayed as per language app is loaded:\"([^\"]*)\"$")
    public void verifyDimensionError(String errorKey) {
	    verifyDimensionErrorInpackagesection(errorKey,packagingAndShipmentDetailsObjects.dimensionserror,packagingAndShipmentDetailsObjects.shipmentDetailsUnits);
    }
   
    @Then("^Verify weight error is displayed as per language app is loaded:\"([^\"]*)\"$")
    public void verifyWeightError(String errorKey) {
	    verifyWeightErrorInpackagesection(errorKey,packagingAndShipmentDetailsObjects.weightRequirederror,packagingAndShipmentDetailsObjects.shipmentDetailsUnits);
    }
    
    @When("^User clicks on PackageDetailsEdit summary card button$")
    public void clickOnPackageSectionEdit() throws InterruptedException {
	    scrollToElement(SummaryCardObjectsPackagingDetails.summaryPackageEdit);
    	clickOnElement(SummaryCardObjectsPackagingDetails.summaryPackageEdit);
        waitForElement(packagingAndShipmentDetailsObjects.packageWeightunit);
    }
    
    @Then("^User clicks on Package Cancel Button$")
    public void clickOnPackageCancel() throws InterruptedException {
    	clickOnElement(packagingAndShipmentDetailsObjects.packageDetailscancel);
    }

    @Then("^User enters value:\"([^\"]*)\" in Describe your goods$")
    public  void enterValueInDescribeYourGoods(String valueToEnter) throws InterruptedException,IOException {
        enterValue(packagingAndShipmentDetailsObjects.describeYourGoods, valueToEnter);
    }

    @Then("^User selects value:\"([^\"]*)\" in Describe your goods$")
    public  void enterValueInDescribeYourGood(String valueToEnter) throws InterruptedException,IOException {
        enterValue(packagingAndShipmentDetailsObjects.describeYourGoods, valueToEnter);
    }
    
    @Then("^User selects NO for liability Coverage Declared value$")
    public  void selectNoRadioButton() throws InterruptedException {
    	clickOnElement(packagingAndShipmentDetailsObjects.noCoverageId);
    }
    
}

