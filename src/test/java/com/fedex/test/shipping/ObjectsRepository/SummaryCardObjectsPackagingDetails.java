package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryCardObjectsPackagingDetails {

    public final static String sumryShipmentDetailsComponent = "summaryShipmentDetailsComponent";
    public final static String sumryShipDetailsHeading = "summaryShipDetailsHeading";

    public final static String sumryPackageComponent = "summaryPackageComponent";
    public final static String sumryPackageHeading = "summaryPackageHeading";
    public final static String sumryPackageNumberLabel = "summaryPackageNumberLabel";
    public final static String sumryPackageNumber = "summaryPackageNumber";
    public final static String sumryPackageWeightLabel = "summaryPackageWeightLabel";
    public final static String sumryPackageWeight = "summaryPackageWeight";
    public final static String sumryPackageDimensionsLabel = "summaryPackageDimensionsLabel";
    public final static String sumryPackageDimensions = "summaryPackageDimensions";
    public final static String sumryPackageDeclaredValueLabel = "summaryPackageDeclaredValueLabel";
    public final static String sumryPackageDeclaredValue = "summaryPackageDeclaredValue";
    public final static String sumryPackageDescribeYourGoods = "//*[@id='summaryShipmentDetailsComponent']/li/ul/div";
    public final static String sumryPackageTotalLabel = "summaryPackageTotalLabel";
    public final static String sumryPackageTotalQuantity = "summaryPackageTotalQuantity";
    public final static String sumryPackageTotalDeclaredValue = "summaryPackageTotalDeclaredValue";
    public final static String sumryPackageTotalWeight = "summaryPackageTotalWeight";
    public final static String sumryPackageEdit = "summaryPackageEdit";
    public final static String sumryCustomEdit = "summaryCustomEdit";



    @FindBy(id = sumryShipmentDetailsComponent)
    public WebElement summaryShipmentDetailsComponent;

    @FindBy(id = sumryShipDetailsHeading)
    public WebElement summaryShipDetailsHeading;

    @FindBy(id = sumryPackageComponent)
    public WebElement summaryPackageComponent;

    @FindBy(id = sumryPackageHeading)
    public WebElement summaryPackageHeading;

    @FindBy(id = sumryPackageNumberLabel)
    public WebElement summaryPackageNumberLabel;

    @FindBy(id = sumryPackageNumber)
    public WebElement summaryPackageNumber;

    @FindBy(id = sumryPackageWeightLabel)
    public WebElement summaryPackageWeightLabel;

    @FindBy(id = sumryPackageWeight)
    public WebElement summaryPackageWeight;

    @FindBy(id = sumryPackageDimensionsLabel)
    public WebElement summaryPackageDimensionsLabel;

    @FindBy(id = sumryPackageDimensions)
    public WebElement summaryPackageDimensions;

    @FindBy(id = sumryPackageDeclaredValueLabel)
    public WebElement summaryPackageDeclaredValueLabel;

    @FindBy(id = sumryPackageDeclaredValue)
    public WebElement summaryPackageDeclaredValue;

    @FindBy(id = sumryPackageDescribeYourGoods)
    public WebElement summaryPackageDescribeYourGoods;

    @FindBy(id = sumryPackageEdit)
    public WebElement summaryPackageEdit;

    @FindBy(id = sumryPackageTotalWeight)
    public WebElement summaryPackageTotalWeight;

    @FindBy(id = sumryCustomEdit)
    public WebElement summaryCustomEdit;

    public SummaryCardObjectsPackagingDetails(){
        PageFactory.initElements(DriverGenerator.getDriver(),this);
    }

}
