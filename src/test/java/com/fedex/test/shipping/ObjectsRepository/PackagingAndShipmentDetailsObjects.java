package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryPackaging;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PackagingAndShipmentDetailsObjects extends LoadableComponent<PackagingAndShipmentDetailsObjects> {

    public static String random_item_name="";

    public final static String packagingDetailsHeading = "packagingDetailsHeading";
    public static final String packageType = "//*[@id='package-details__package-type']";//"//*[@id='packageType']";
    public static final String packageTypeid = "packageType";
    public final static String numbOfPackages = "package-details__amount-0";
    public final static String numbOfPackagesRowTwo = "package-details__amount-1";
    public final static String numbOfPackagesRowThree = "package-details__amount-2";
    public final static String numbOfPackagesRowFour = "package-details__amount-3";
    public final static String numbOfPackagesRowFive = "package-details__amount-4";
    public final static String customValueCanNotBeLessErr = "//*[@id='customValueError']/p[5]/span";
    public final static String dimensionLength = "input[formcontrolname='length']";
    public final static String dimensionWidth = "input[formcontrolname='width']";
    public final static String dimensionHeight = "input[formcontrolname='height']";
    public final static String dimensionUnit = "dimensionUnit";
    public final static String dimensionsError = "//div[@id='package-details__dimensions-error']/span";
    public final static String dimensionImpactInfo = "#dimensionsError > span.errorInfo.infoMsg";
    public final static String saveDimensionProfile = "//button[@class='fdx-c-button fdx-c-button--text fdx-c-button--condensed']";
    public final static String packageWeight = "package-details__weight-0";
    public final static String packageWeightRowTwo = "package-details__weight-1";
    public final static String packageWeightRowThree = "package-details__weight-2";
    public final static String packageWeightRowFour = "package-details__weight-3";
    public final static String packageWeightRowFive = "package-details__weight-4";
    public final static String shipmentDetailsUnit = "fdx-c-form-group__suffix";
    public final static String packageWeightUnit = "package-details__unit";
    public final static String weightRequiredError = "package-details__weight-error";
    public final static String maxWeightInfo = "#errorSection > span.errorInfo.infoMsg";
    public final static String packageComponent="packageComponent";
    public final static String packageDetailsLabels="fdx-c-form-group__label";
    public final static String declaredValueRequired="//div[@id='package-details__value-error']";
    public final static String coverageTooltipMessage="#tooltip_message_liabilityCoverageTooltip";
    public final static String declaredValue = "declaredValue";
    public final static String declaredValCurrency = "package-details__currency";
    public final static String declaredValueError = "#packageComponent > form > div:nth-child(4) > span";

    public final static String coverageQues = "package-details__liability-coverage-description";
    public final static String yescoverageStatus = "package-details__liability-coverage-yes";
    public final static String coverageTooltip = "liabilityCoverageTooltip";
    public final static String coverageVal = "package-details__value-0";
    public final static String coverageValRowTwo = "package-details__value-1";
    public final static String coverageValRowThree = "package-details__value-2";
    public final static String coverageValRowFour = "package-details__value-3";
    public final static String coverageValRowFive = "package-details__value-4";
    public final static String coverageValueCncy = "package-details__currency";
    public final static String pleaseNoteCoverageValue = "#packageComponent > form > div:nth-child(5) > fx-mags-liability-coverage > div > form > div:nth-child(2) > p > span";
    public final static String coverageValueError = "error-area";
    public final static String coverageValueRequired = "#coverage-valueErrorMessage > p > span";
    public final static String noCoverage = "package-details__liability-coverage-no";

    public final static String packageSubmit = "packagingDetailsUpdateBtn";
    public final static String yesCoverge = "[for=package-details__liability-coverage-yes]";
    public final static String yesCoverageMobile = "//*[@for='package-details__liability-coverage-yes']";
    public final static String shipmentDetailsHeading = "shipmentDetailsHeading";
    public final static String itemDescription = "//*[@name='itemDescription']";
    public final static String itemDescriptionerror = "itemDescriptionRequired";
    public final static String itemDescriptionpattern = "itemDescriptionPattern";
    public final static String shipmentCountryOfManufactureerror = "countryOfManufactureRequired";
    public final static String shipmentQuantityerror = "quantityRequired";
    public final static String shipmentQuantityInvaliderror = "quantityPattern";
    public final static String shipmentWeighterror = "weightRequired";
    public final static String shipmentWeightInvaliderror = "weightPattern";
    public final static String shipmentCustomsValueerror = "customValueError";
    public final static String shipmentCountryOfmanufacture = "countryOfManufacture";
    public final static String shipmentweight = "//*[@name='weight']";
    public final static String shipmentquantity = "//*[@name='quantity']";
    public final static String shipmentItemCustomsVal = "itemCustomsValue";
    public final static String shipmentDetailsCancelbutton = "(//*[contains(text(),'Cancel')])[2]";
    public final static String shipmentUpdatebutton= "customsUpdateBtn";
    public final static String itemWeightunit = "//*[@name='weightUnit']";
    public final static String itemCustomscurrency = "currencyFormName";
    public final static String itemsButton = "tabButtonItems";
    public final static String items = "Items";
    public final static String item2 = "//*[@id='field_savedItem']";
    public final static String docType ="documentType";
    public final static String documentsButton = "tabButtonDocuments";
    public final static String documents = "Documents";
    public final static String shipDocTypeError = "//*[@id='documentTypeError']/span";
    public static final String itemProfilename = "itemProfileName";

    public static final String hsToolTipText = "//*[@id='tooltip_message_harmonizedCodeToolTip']";
    public final static String hscodeTip = "harmonizedCodeToolTip";

    public final static String shipmentPurpose = "shipmentPurpose";
    public final static String docCurrency = "//*[@id='shipmentDocumentComponent']/div/fx-mags-input[2]";
    public final static String othertypeDocumenDesc = "otherTypeDocumentDescription";
    public final static String documentDescError = "//span[contains(text(),'Invalid character in Document Description.')]";
    public final static String describeDocumenterror="//span[contains(text(),'Please describe your document.')]";
    public final static String documentCustomsValError = "customValueError";
    public final static String documentCustomsVal = "documentCustomsValue";
    public final static String documentCustomsCncy = "currencyFormName";
    public final static String documentCustomsInstction = "//*[@class='errorInfo infoMsg']";
    public final static String addAnotherItemButton = "//*[@class='fdx-c-button fdx-c-button--secondary-outline fdx-c-button--text fdx-u-m--8']";
    public final static String shipmentContinueButton = "customsUpdateBtn";
    public final static String describeyourGoods = "package-details__goods-description";
    public final static String packageDetailsCancel = "fx-mags-package-details+div>fx-mags-button +div>button";
    public final static String packagingDetailsSubmit = "packagingDetailsUpdateBtn";
    public final static String  quantitypattern = "quantityPattern";
    public static final String weightpattern = "weightPattern";
    public final static String otherTypeDocumentInvaliderror = "//*[contains(text(),'Invalid character in Document Description.')]";
    public static final String customValueerror = "customValueError";
    public static final String custWeighterror = "//div[@class='fxg-field__validation ng-star-inserted']";
    public static final String noCoverageid = "[for=package-details__liability-coverage-no]";
    public static final String saveAsNewitem = "//button[@class='fdx-c-button fdx-c-button--text u-mb--4 ng-star-inserted']";
    public static final String saveButtonInNewItemsave = "//button[@class='fdx-c-button fdx-c-button--secondary-outline fdx-c-button--modal']";
    public static final String updateItembutton = "//button[@class='fdx-c-button fdx-c-button--text']";
    public static final String perItemtab = "//button[@class='rtab-item--active']";
    public static final String totalItemtab = "//button[@class='rtab-item--inactive']";
    public static final String field_saveditem = "field_savedItem";
    public static final String saveditem = "id_0";
    public final static String describeYourGoodserror = "package-details__goods-description-error";
    public final static String dimensionsProfileName = "dimensionsProfileName";
    public final static String dimensionsProfileEmptyError = "//div[@class='fxg-field__validation ng-star-inserted']/span[@class='ng-star-inserted']";
    public final static String dimensionsProfileInvalidCharError = "//div[@class='fxg-field__validation ng-star-inserted']/span[@class='ng-star-inserted']";
    public final static String saveDimensionsProfileName = "//button[@class='fdx-c-button fdx-c-button--secondary-outline fdx-c-button--modal']";
    public final static String totalPackages = "//div[@class='fdx-o-grid__item fdx-o-grid__item--2@large fdx-o-grid__item--4']/dl/dd";
    public final static String totalPackagesWeight = "//div[@class='fdx-o-grid__item fdx-o-grid__item--8 fdx-o-grid__item--2@large']/dl/dd";
    public final static String secondRowDimenstionL = "//*[@id='package-details__dimensions-1']/input[1]";
    public final static String theardRowDimenstionL = "//*[@id='package-details__dimensions-2']/input[1]";
    public final static String forthRowDimentionL = "//*[@id='package-details__dimensions-3']/input[1]";
    public final static String fithRowDimenstionL = "//*[@id='package-details__dimensions-4']/input[1]";
    public final static String secondRowDimenstionW = "//*[@id='package-details__dimensions-1']/input[2]";
    public final static String theardRowDimenstionW = "//*[@id='package-details__dimensions-2']/input[2]";
    public final static String forthRowDimentionW = "//*[@id='package-details__dimensions-3']/input[2]";
    public final static String fithRowDimenstionW = "//*[@id='package-details__dimensions-4']/input[2]";
    public final static String secondRowDimenstionH = "//*[@id='package-details__dimensions-1']/input[3]";
    public final static String theardRowDimenstionH = "//*[@id='package-details__dimensions-2']/input[3]";
    public final static String forthRowDimentionH = "//*[@id='package-details__dimensions-3']/input[3]";
    public final static String fithRowDimenstionH = "//*[@id='package-details__dimensions-4']/input[3]";
    public final static String addAnotherPackage = "//button[@class='c-button c-button--condensed c-button--text c-button--small-text fdx-u-mt--1']";
    public final static String totalDeclaredValue = "//*[@class='fdx-o-grid__item fdx-o-grid__item--3@large fdx-o-grid__item--12 ng-star-inserted']/dl/dd";
    public final static String cancelButtonDimenstion = "//div[@class='package-line__button-delete ng-star-inserted']/*[@class='package-line__button-delete--content fdx-c-button fdx-c-button--icon fdx-c-button--icon-large']";



    @FindBy(xpath = totalDeclaredValue)
    public WebElement TotalDeclaredValue;

    @FindBy(xpath = cancelButtonDimenstion)
    public WebElement CancelButtonDimenstion;

    @FindBy(xpath = packageType)
    public WebElement packagingType;

    @FindBy(xpath = secondRowDimenstionL)
    public WebElement SecondRowDimenstionL;

    @FindBy(xpath = theardRowDimenstionL)
    public WebElement TheardRowDimenstionL;

    @FindBy(xpath = forthRowDimentionL)
    public WebElement ForthRowDimentionL;

    @FindBy(xpath = fithRowDimenstionL)
    public WebElement FithRowDimenstionL;

    @FindBy(xpath = secondRowDimenstionW)
    public WebElement SecondRowDimenstionW;

    @FindBy(xpath = theardRowDimenstionW)
    public WebElement TheardRowDimenstionW;

    @FindBy(xpath = forthRowDimentionW)
    public WebElement ForthRowDimentionW;

    @FindBy(xpath = fithRowDimenstionW)
    public WebElement FithRowDimenstionW;

    @FindBy(xpath = secondRowDimenstionH)
    public WebElement SecondRowDimenstionH;

    @FindBy(xpath = theardRowDimenstionH)
    public WebElement TheardRowDimenstionH;

    @FindBy(xpath = forthRowDimentionH)
    public WebElement ForthRowDimentionH;

    @FindBy(xpath = fithRowDimenstionH)
    public WebElement FithRowDimenstionH;

    @FindBy(xpath = addAnotherPackage)
    public WebElement addAnotherPackageButton;

    @FindBy(xpath = totalPackagesWeight)
    public WebElement totalPackagesweight;

    @FindBy(xpath = totalPackages)
    public WebElement totalPackagesCount;

    @FindBy(xpath = dimensionsProfileInvalidCharError)
    public WebElement dimensionsProfileInvalidCharErr;

    @FindBy(xpath = dimensionsProfileEmptyError)
    public WebElement dimensionsProfileEmptyErrorMessage;

    @FindBy(xpath = saveDimensionsProfileName)
    public WebElement saveDimensionsProfileNameButton;

    @FindBy(xpath = saveDimensionProfile)
    public WebElement saveDimensionProfileButton;

    @FindBy(xpath = customValueCanNotBeLessErr)
    public WebElement customValueCanotBeLessErr;

    @FindBy(id = packageWeight)
    public WebElement packagingWeight;

    @FindBy(id = packageWeightRowTwo)
    public WebElement packageWeightRowtwo;

    @FindBy(id = packageWeightRowThree)
    public WebElement packageWeightRowthree;

    @FindBy(id = packageWeightRowFour)
    public WebElement packageWeightRowfour;

    @FindBy(id = packageWeightRowFive)
    public WebElement packageWeightRowfive;

    @FindBy(id = dimensionsProfileName)
    public WebElement dimensionsProfileNameField;

    @FindBy(id = numbOfPackagesRowTwo)
    public WebElement numbOfPackagesRowtwo;

    @FindBy(id = numbOfPackagesRowThree)
    public WebElement numbOfPackagesRowthree;

    @FindBy(id = numbOfPackagesRowFour)
    public WebElement numbOfPackagesRowfour;

    @FindBy(id = numbOfPackagesRowFive)
    public WebElement numbOfPackagesRowfive;

    @FindBy(id = numbOfPackages)
    public WebElement numberOfPackages;

    @FindBy(id = declaredValue)
    public WebElement declareValue;

    @FindBy(id = declaredValCurrency)
    public WebElement declaredValueCurrency;

    @FindBy(id = packageSubmit)
    public WebElement packagingSubmit;

    @FindBy(css = yesCoverge)
    public WebElement yesCoverage;

    @FindBy(css = yesCoverageMobile)
    public WebElement yesCoverageMob;

    @FindBy(id = yescoverageStatus)
    public WebElement yesCoverageStatus;

    @FindBy(id = coverageQues)
    public WebElement coverageQuestion;

    @FindBy(id = packagingDetailsHeading)
    public WebElement packagingheader;

    @FindBy(id = shipmentDetailsHeading)
    public WebElement shipmentDetailsHeader;

    @FindBy(className = shipmentDetailsUnit)
    public List<WebElement> shipmentDetailsUnits;

    @FindBy(id = itemsButton)
    public WebElement itemsbutton;

    @FindBy(id = documentsButton)
    public WebElement documentsbutton;

    @FindBy(xpath = itemDescription)
    public WebElement itemsDesc;

    @FindBy(id = items)
    public WebElement Items;

    @FindBy(xpath = hsToolTipText)
    public WebElement hstoolTip;

    @FindBy(id = hscodeTip)
    public WebElement hsCodeTip;

    @FindBy(css = dimensionLength)
    public WebElement dimLength;

    @FindBy(css = dimensionHeight)
    public WebElement dimHeight;

    @FindBy(css = dimensionWidth)
    public WebElement dimWidth;

    @FindBy(id = shipmentPurpose)
    public WebElement shipmntPurpose;

    @FindBy(xpath = addAnotherItemButton)
    public WebElement addItemButton;

    @FindBy(id = shipmentContinueButton)
    public WebElement shipmentContinue;

    @FindBy(id = docType)
    public WebElement shipDocType;

    @FindBy(xpath = shipDocTypeError)
    public WebElement documentTypeError;

    @FindBy(id = documents)
    public WebElement Documents;

    @FindBy(xpath = docCurrency)
    public WebElement documentCurrency;

    @FindBy(xpath = documentDescError)
    public WebElement documentDescriptionError;

    @FindBy(xpath = describeDocumenterror)
    public WebElement describeDocumentError;

    @FindBy(id = othertypeDocumenDesc)
    public WebElement otherTypeDocumentDescription;

    @FindBy(id = documentCustomsVal)
    public WebElement documentCustomsValue;

    @FindBy(id = documentCustomsCncy)
    public WebElement documentCustomsCurrency;

    @FindBy(xpath = documentCustomsInstction)
    public WebElement documentCustomsInstruction;

    @FindBy(id = documentCustomsValError)
    public WebElement documentCustomsValueError;

    @FindBy(id = coverageVal)
    public WebElement coverageValue;

    @FindBy(id = coverageValRowTwo)
    public WebElement coverageValRowtwo;

    @FindBy(id = coverageValRowThree)
    public WebElement coverageValRowthree;

    @FindBy(id = coverageValRowFour)
    public WebElement coverageValRowfour;

    @FindBy(id = coverageValRowFive)
    public WebElement coverageValRowfive;

    @FindBy(id = coverageValueCncy)
    public WebElement coverageValueCurrency;

    @FindBy(id = describeyourGoods)
    public WebElement describeYourGoods;
    
    /*@FindBy(id = packageComponent)
    public static WebElement packagecomponent;*/

    @FindBy(id = noCoverage)
    public WebElement nocoverage;

    @FindBy(className = packageDetailsLabels)
    public List<WebElement> packagedetailsLabels;

    @FindBy(id = packageWeightUnit)
    public WebElement packageWeightunit;

    @FindBy(id = coverageTooltip)
    public WebElement coveragetooltip;

    @FindBy(css = coverageTooltipMessage)
    public WebElement coveragetooltipMessage;

    @FindBy(xpath =declaredValueRequired)
    public WebElement declaredvalueRequired;

    @FindBy(xpath = dimensionsError)
    public WebElement dimensionserror;

    @FindBy(id = weightRequiredError)
    public WebElement weightRequirederror;

    @FindBy(id = itemDescriptionerror)
    public WebElement itemDescriptionError;

    @FindBy(id = itemDescriptionpattern)
    public WebElement itemDescriptionPattern;

    @FindBy(id = shipmentCountryOfManufactureerror)
    public WebElement shipmentCountryOfManufactureError;

    @FindBy(id = shipmentQuantityerror)
    public WebElement shipmentQuantityError;

    @FindBy(id = shipmentQuantityInvaliderror)
    public WebElement shipmentQuantityInvalidError;

    @FindBy(id = shipmentWeighterror)
    public WebElement shipmentWeightError;

    @FindBy(id = shipmentWeightInvaliderror)
    public WebElement shipmentWeightInvalidError;

    @FindBy(id = shipmentCustomsValueerror)
    public WebElement shipmentCustomsValueError;

    @FindBy(id = shipmentCountryOfmanufacture)
    public WebElement shipmentCountryOfManufacture;

    @FindBy(xpath = shipmentweight)
    public WebElement shipmentWeight;

    @FindBy(id = shipmentItemCustomsVal)
    public WebElement shipmentItemCustomsValue;

    @FindBy(xpath = shipmentquantity)
    public WebElement shipmentQuantity;

    @FindBy(xpath = item2)
    public WebElement Item2;

    @FindBy(xpath = shipmentDetailsCancelbutton)
    public WebElement shipmentDetailsCancelButton;

    @FindBy(id = shipmentUpdatebutton)
    public WebElement shipmentUpdateButton;

    @FindBy(xpath = itemWeightunit)
    public WebElement itemWeightUnit;

    @FindBy(id = itemCustomscurrency)
    public WebElement itemCustomsCurrency;

    @FindBy(css = packageDetailsCancel)
    public  WebElement packageDetailscancel;

    @FindBy(id = packagingDetailsSubmit)
    public  WebElement packagingDetailssubmit;

    @FindBy(id = quantitypattern)
    public  WebElement quantityPattern;

    @FindBy(id =weightpattern)
    public  WebElement weightPattern;

    @FindBy(xpath = otherTypeDocumentInvaliderror)
    public  WebElement otherTypeDocumentInvalidError;

    @FindBy(id = customValueerror)
    public  WebElement customValueError;

    @FindBy(xpath = custWeighterror)
    public  WebElement custWeightError;

    @FindBy(css = noCoverageid)
    public  WebElement noCoverageId;

    @FindBy(xpath = saveAsNewitem)
    public  WebElement saveAsNewItem;

    @FindBy(xpath =saveButtonInNewItemsave)
    public  WebElement saveButtonInNewItemSave;

    @FindBy(xpath = updateItembutton)
    public  WebElement updateItemButton;

    @FindBy(xpath = perItemtab)
    public  WebElement perItemTab;

    @FindBy(xpath = totalItemtab)
    public  WebElement totalItemTab;

    @FindBy(id = field_saveditem)
    public  WebElement field_savedItem;

    @FindBy(id =itemProfilename)
    public WebElement itemProfileName;

    @FindBy(id = saveditem)
    public  WebElement savedItem;

    @FindBy(id =describeYourGoodserror)
    public  WebElement describeYourGoodsError;


    public PackagingAndShipmentDetailsObjects(){
        PageFactory.initElements(DriverGenerator.getDriver(), this);
    }

    public void selectItemOrDocument(String option){
        try {
            Wrappers.waitForElement(shipmentDetailsHeader);
            Wrappers.waitForElement(documentsbutton);
            switch (option.toLowerCase()) {
                case "items":
                    if (Wrappers.elementisDisplayedAndEnabled(itemsDesc) && Wrappers.elementisDisplayedAndEnabled(Items)){
                        Assert.assertEquals("User is landed to Items section","User is landed to Items section");
                    } else {
                        itemsbutton.click();
                    }
                    break;
                case "documents":
                    if (Wrappers.elementisDisplayedAndEnabled(shipDocType) && Wrappers.elementisDisplayedAndEnabled(Documents)) {
                    } else {
                        documentsbutton.click();
                    }
                    break;
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void documentShipmentPageDetails() throws IOException {
        Wrappers.getLabelTextAndCompare(shipDocType, Wrappers.getDocSectionData("shipDocType"));
        Wrappers.getLabelTextAndCompare(otherTypeDocumentDescription, Wrappers.getDocSectionData("otherDocType"));
        Wrappers.getLabelTextAndCompare(documentCustomsValue, Wrappers.getDocSectionData("customsValue"));
        Wrappers.getLabelTextAndCompare(documentCustomsCurrency, Wrappers.getDocSectionData("currency"));
        //Wrappers.getLabelTextAndCompare(documentCustomsInstruction, Wrappers.getDocSectionData("customsInstructionText"));
    }


    public void verifylabelInpackagesection() {
        String weightMax;
        try {
            //Wrappers.waitForElement(nocoverage);
            if (nocoverage.isSelected()) {
                Assert.assertEquals("No coverage value is selected","No coverage value is selected");
            }else{
                Assert.fail();
            }
            Wrappers.getTextFromAndCompareTextWithUI(packagingheader, Wrappers.getPackageSectionComponentData("enterPackageDetails"));
            Wrappers.getTextFromAndCompareTextWithUI(packagedetailsLabels.get(0), Wrappers.getPackageSectionComponentData("Packaging").toUpperCase());
            Wrappers.getTextFromAndCompareTextWithUI(packagedetailsLabels.get(3), Wrappers.getPackageSectionComponentData("noOfPackages").toUpperCase()+"\n"+Wrappers.getPackageSectionComponentData("max").replace("{{amount}}","1"));
            if (Wrappers.getInnerText(shipmentDetailsUnits.get(0)).equalsIgnoreCase ("kg")){
                weightMax="68";
            }else{
                weightMax="150";
            }
            Wrappers.getTextFromAndCompareTextWithUI(packagedetailsLabels.get(4),Wrappers.getPackageSectionComponentData("weight").toUpperCase()+"\n"+Wrappers.getPackageSectionWeightData("weightMaxLimit").replace("{{weight}}",weightMax).replace("{{units}}",Wrappers.getInnerText(shipmentDetailsUnits.get(0))));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }



    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
