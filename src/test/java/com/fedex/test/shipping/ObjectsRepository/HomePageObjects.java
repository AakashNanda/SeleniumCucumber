package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import com.fedex.test.shipping.ResuableJavaFactory.Property;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.fedex.test.shipping.ResuableJavaFactory.Wrappers.*;

public class HomePageObjects extends LoadableComponent<HomePageObjects> {

    public static final String SimpleShipmentButton = "//*[@id='welcomePageSimpleShippingButton']";
    public static final String AppBar ="fxg-app-bar";
    public static final String globalLoginLink = "#global-login-wrapper";
    public static final String loginId = "NavLoginUserId";
    public static final String loginPassword = "NavLoginPassword";
    public static final String loginbutton = "//*[text()='Log In']";
    public static final String headerLogin = "HeaderLogin";
    public static final String logout = "//*[contains(text(),'SIGN OUT')]";
    public final static String alertMsgOnHeader = ".fxg-alert__close-btn";
    public final static String feedbackpopup = "//span[@id='closeQualtricsButton']/img";
    public final static String noSurvey = "//*[@style='position: absolute; top: 0px; left: 0px; width: 87px; height: 22px; overflow: hidden; display: block;']";
    public final static String onBoardingStartshipping = "e2e-onboarding-startShipping";
    public final static String onBoardingWhatsnew = "e2e-onboarding-whatsNew";
    public final static String onBoardingcontent = "fdx-u-align--center fdx-u-pt--8 fdx-u-pr--8-medium";
    public final static String onBoardingnext = "e2e-onboarding-next";
    public final static String onBoardingback = "e2e-onboarding-back";
    public final static String onBoardingContentWhatsnewInMAGS = "fdx-u-pt--8";
    public final static String onBoardingreturntoOldVersion = "e2e-onboarding-returnToOldVersion";
    public final static String onBoardingYouHavebeenUpgraded = "fdx-c-notification__title fdx-u-align--center";
    public final static String onBoardingWelcometextMessage = "fdx-u-font-size--small fdx-u-mt--6 fdx-u-mb--6";
    public final static String pleaseLoginMessageafterLogout = "fdx-u-align--center fdx-u-pt--8";
    public final static String onBoardingClose = "e2e-onboarding-close";
    public final static String onBoardingStartShipping = "e2e-onboarding-startShipping";
    public static final String accountDropDown = "button[role=“menuitem”] use[href=“#chevron”]";

    public final static String accountDropDownSelection = "(//*[@class='fxg-app-bar__secondary'])[1]";
    public final static String systemErrorModal = "//*[contains(text(),'System error')]";

    public final static String customerFeedbackNoThanks = "body > div.QSIWebResponsive > div.QSIWebResponsive-creative-container-fade > div > div.QSIWebResponsiveDialog-Layout1-SI_a3Euv7YCuiLpJK5_button-container > button:nth-child(2)";
    public final static String customerFeedbackPopUpCloseIcon = "body > div.QSISlider.SI_bJxTYIBTlUi28QZ_SliderContainer > div:nth-child(2) > div";
    public final static String closeWarningl2 = "//*[@class='fxg-alert__close-btn']";
    public final static String alertMessageonHeader = ".fxg-alert__close-btn";
    public static final String modalWindow = "[class='fdx-c-modal__main fdx-c-modal__main--small']";
    public static final String closeModalWindow = "e2e-legacyShipping-close";
    public static final String accountnameinlist = "//li[@class='fxg-app-bar__dropdown-item'][2]/a";
    public final static String appbarAccountlist = "//*[@class='fdx-c-navbar__menu__item__button']";
    public final static String appbarAccountlistItem = "//*[@class='fdx-c-navbar__menu__item__button fdx-u-text--bold ng-star-inserted']";

    public final static String fxmodal = "//div[@id='modalContainerDiv'][@class='show']/div/div[@id='fxModal']";
    public final static String wifmPagetitle = "menubar.nav.menu1_div";
    public final static String welcomePageSimpleShippingbutton = "welcomePageSimpleShippingButton";
    public static final String applicationbar = "fdx-c-navbar";


    @FindBy(xpath = SimpleShipmentButton)
    public WebElement simpleShippingButton;

    @FindBy(id = AppBar)
    public WebElement Appbar;

    @FindBy(xpath = appbarAccountlist)
    public List<WebElement> appbarAccountList;

    @FindBy(xpath = appbarAccountlistItem)
    public WebElement appbarAccountListItem;

    @FindBy(css = globalLoginLink)
    public WebElement logindrpdown;

    @FindBy(id = headerLogin)
    public WebElement headerLoginEnabled;

    @FindBy(id = loginId)
    public WebElement userId;

    @FindBy(id = loginPassword)
    public WebElement userPassword;

    @FindBy(xpath = loginbutton)
    public WebElement login;

    @FindBy(xpath = logout)
    public WebElement logsout;

    @FindBy(xpath = closeWarningl2)
    public WebElement closeWarningL2;

    @FindBy(css = alertMsgOnHeader)
    public WebElement alertMessageHeader;

    @FindBy(xpath = feedbackpopup)
    public WebElement feedbackPopup;

    @FindBy(id = onBoardingClose)
    public WebElement onBoardingclose;

    @FindBy(xpath = feedbackpopup)
    public WebElement feedBackpopup;

    @FindBy(id = onBoardingStartShipping)
    public WebElement onBoardingStartShippings;


    @FindBy(id = onBoardingWhatsnew)
    public WebElement onBoardingWhatsNew;

    @FindBy(id = onBoardingreturntoOldVersion)
    public WebElement onBoardingreturnToOldVersion;

    @FindBy(className = onBoardingcontent)
    public WebElement onBoardingContent;

    @FindBy(id = onBoardingnext)
    public WebElement onBoardingNext;

    @FindBy(id = onBoardingback)
    public WebElement onBoardingBack;

    @FindBy(className = onBoardingContentWhatsnewInMAGS)
    public WebElement onBoardingContentWhatsNewInMAGS;

    @FindBy(className = onBoardingWelcometextMessage)
    public WebElement onBoardingWelcomeTextMessage;

    @FindBy(className = onBoardingYouHavebeenUpgraded)
    public WebElement onBoardingYouHaveBeenUpgraded;

    @FindBy(className = pleaseLoginMessageafterLogout)
    public WebElement pleaseLoginMessageAfterLogout;

    @FindBy(css = customerFeedbackNoThanks)
    public WebElement customerFeedbacknoThanks;

    @FindBy(xpath = accountDropDown)
    public WebElement accountdropDown;

    @FindBy(css = customerFeedbackPopUpCloseIcon)
    public WebElement customerFeedbackPopUpcloseIcon;

    @FindBy(xpath =accountDropDownSelection)
    public WebElement accountDropDownselection;

    @FindBy(xpath = systemErrorModal)
    public WebElement systemErrormodal;

    @FindBy(id = AddressEntryObjects.fromHeader)
    public WebElement fromfieldHeader;

    @FindBy(css = AddressEntryObjects.toHeader)
    public WebElement tofieldHeader;

    @FindBy(id = PackagingAndShipmentDetailsObjects.packagingDetailsHeading)
    public WebElement packagingheader;

    @FindBy(id = PackagingAndShipmentDetailsObjects.shipmentDetailsHeading)
    public WebElement shipmentDetailsHeader;

    @FindBy(xpath = PackagingAndShipmentDetailsObjects.itemDescription)
    public WebElement itemsDesc;

    @FindBy(id = ThankYouPageObjects.commercialInvoiceheading)
    public WebElement commercialInvoiceHeading;

    @FindBy(id = RateQuotesObjects.rateServicesbutton)
    public WebElement rateServicesButton;

    @FindBy(id = PickUpAndDropOffObjects.pickUpDropOffSelect)
    public WebElement pickUpDropOffSelection;

    @FindBy(id = PaymentObjects.transportationheading)
    public WebElement transportationHeading;

    @FindBy(id = SummaryPageObjects.summarymodalHeading)
    public WebElement summaryModalHeading;

    @FindBy(id = ThankYouPageObjects.confirmationheader)
    public WebElement confirmationHeader;

    @FindBy(css = alertMessageonHeader)
    public WebElement alertMessageOnHeader;

    @FindBy(css = modalWindow)
    public WebElement ModalWindow;

    @FindBy(id = closeModalWindow)
    public WebElement CloseModalWindow;

    @FindBy(xpath = accountnameinlist)
    public WebElement accountnameinList;

    @FindBy(xpath = fxmodal)
    public static WebElement fxModal;

    @FindBy(id = wifmPagetitle)
    public  WebElement wifmPageTitle;

    @FindBy(id = welcomePageSimpleShippingbutton)
    public WebElement welcomePageSimpleShippingButton;

    @FindBy(className = applicationbar)
    public  WebElement applicationBar;

    //    '''''''''''''''''''''''''''''''' Local login ''''''''''''''''''''''''''''''''''''''''''''''''

    @FindBy(id = "environment")
    public static WebElement environment;

    @FindBy(id="users")
    public static WebElement userList;

    @FindBy(id = "userName")
    public static WebElement userName;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(id = "submitButton")
    public static WebElement submitButton;

    @FindBy(id = "logoutButton")
    public static WebElement logoutButton;

    @FindBy(id = "done")
    public static WebElement done;


     public HomePageObjects() throws IOException {
      if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
          if(Property.getProp("mode").equalsIgnoreCase("jenkins")){
              String level = System.getProperty("level");
              DriverGenerator.getDriver().navigate().to(Property.getAppURLJenkins(level));
              DriverGenerator.getDriver().manage().deleteAllCookies();
              DriverGenerator.getDriver().navigate().to(Property.getAppURLJenkins(level));
          } else if(!prop.getProperty("level").equalsIgnoreCase("L")){
              DriverGenerator.getDriver().navigate().to(Property.getAppURL());
              DriverGenerator.getDriver().manage().deleteAllCookies();
              DriverGenerator.getDriver().navigate().to(Property.getAppURL());
          }
      }
      PageFactory.initElements(DriverGenerator.getDriver(), this);
     }

     public void loginLocal(String reference)throws InterruptedException, IOException{
         Thread.sleep(5000);
         JSONObject user = Wrappers.getUserCredentials(reference);

         File file = new File("src//test//java//com//fedex//test//shipping//cucumberSteps//login//index.html");
         String path = file.getAbsolutePath();
         DriverGenerator.getDriver().manage().deleteAllCookies();
         DriverGenerator.getDriver().get("file:///" + path);
         waitForElement(environment);

         String testLevel = prop.getProperty("level");
         if (testLevel.equalsIgnoreCase("L") )
             testLevel = "L6";
         selectValuebyValue(environment,testLevel);
         selectValuebyValue(userList,reference);

         userName.clear();
         userName.sendKeys(user.get("ID").toString());
         password.clear();
         password.sendKeys(user.get("PASSWORD").toString());
         submitButton.click();
         waitForElement(done);

         DriverGenerator.getDriver().get(prop.getProperty(prop.getProperty("level")));

     }

     public void login(String reference) throws InterruptedException, IOException {
       Thread.sleep(5000);
      JSONObject user = Wrappers.getUserCredentials(reference);
      if(Wrappers.elementisDisplayedAndEnabled(headerLoginEnabled)){
       Wrappers.enterValue(userId, user.get("ID").toString());
       Wrappers.enterValue(userPassword, user.get("PASSWORD").toString());
       Wrappers.clickOnElement(login);
      }else {
       if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
           Wrappers.clickOnElement(logindrpdown);
       } else {
           Wrappers.clickOnElementLoginDropDown(logindrpdown);
       }
       Wrappers.enterValue(userId, user.get("ID").toString());
       Wrappers.enterValue(userPassword, user.get("PASSWORD").toString());
       Wrappers.clickOnElement(login);
      }
      if (Property.getProp("level").equalsIgnoreCase("L")){
     DriverGenerator.getDriver().navigate().to("http://localhost:4200");
      }
     }

     public void loginWithCredentials(String userName, String password) throws InterruptedException {
         Thread.sleep(5000);
      try {
       if (Wrappers.elementisDisplayedAndEnabled(headerLoginEnabled)) {
        Wrappers.enterValue(userId, userName);
        Wrappers.enterValue(userPassword, password);
        Wrappers.clickOnElement(login);

       } else {
        //  clickOnElementJS(globalLoginLink, report);
           if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
               Wrappers.clickOnElement(logindrpdown);
           } else {
               Wrappers.clickOnElementLoginDropDown(logindrpdown);
           }
        Wrappers.waitForElement(headerLoginEnabled);
        Wrappers.enterValue(userId, userName);
        Wrappers.enterValue(userPassword, password);
        Wrappers.clickOnElement(login);
       }
      } catch (Exception e) {
       Assert.fail();
      }

     }

     public void logout() throws InterruptedException {
      //      waitForElement(HomePageObjects.logindrpdown);
      Wrappers.clickOnElement(logindrpdown);
      Wrappers.waitForElement(logsout);
      if(!(logsout.isDisplayed())){
       Assert.fail();
      }
      Wrappers.clickOnElement(logsout);
     }

     public void clickOnStartShipping() throws InterruptedException, IOException {
         try {
             Wrappers.waitForElement(onBoardingStartShippings);
             if (Wrappers.elementisDisplayedAndEnabled(onBoardingclose)
                     || Wrappers.elementisDisplayedAndEnabled(onBoardingStartShippings)
             ) {
                 Wrappers.waitForElement(onBoardingStartShippings);
                 Wrappers.clickOnElement(onBoardingStartShippings);
             }
             /*else {
                 Assert.fail();
             }*/
             if (Wrappers.elementisDisplayedAndEnabled(closeWarningL2) && Property.getProp("level").equalsIgnoreCase("L2")) {
                 Wrappers.clickOnElement(closeWarningL2);
             }
             /*else{
                 Assert.fail();
             }*/
         } catch (Exception e) {
            e.printStackTrace();
             //Assert.fail();
         }
     }

    public void feedbackPopupClose() {

        try{

            if( (Wrappers.elementisDisplayedAndEnabled(customerFeedbacknoThanks))
                    && (Property.getProp("level").equalsIgnoreCase("L6"))
                    ||(Property.getProp("level").equalsIgnoreCase("L3"))){
               // Wrappers.clickOnElement(customerFeedbacknoThanks);
                Wrappers.clickOnElement(customerFeedbackPopUpcloseIcon);

            }else if( (Wrappers.elementisDisplayedAndEnabled(customerFeedbackPopUpcloseIcon))&&
                    (Property.getProp("level").equalsIgnoreCase("L6"))||
                    (Property.getProp("level").equalsIgnoreCase("L3"))){
                Wrappers.clickOnElement(customerFeedbackPopUpcloseIcon);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


     public void verifyPageIsActive(String pageName) {
      switch (pageName) {
       case "From":
        Wrappers.verifyElementIsDisplayed(fromfieldHeader);
        break;
       case "To":
        Wrappers.verifyElementIsDisplayed(tofieldHeader);
        break;
       case "PackagingDetails":
        Wrappers.verifyElementIsDisplayed(packagingheader);
        break;
       case "ShipmentDetails":
        Wrappers.verifyElementIsDisplayed(shipmentDetailsHeader);
        break;
       case "ShipmentDetailsNonDocObjects":
        Wrappers.verifyElementIsDisplayed(itemsDesc);
        break;
       case "CommercialInvoice":
        Wrappers.verifyElementIsDisplayed(commercialInvoiceHeading);
        break;
       case "RateQuoteDetails":
        Wrappers.verifyElementIsDisplayed(rateServicesButton);
        break;
       case "Pickup":
        Wrappers.verifyElementIsDisplayed(pickUpDropOffSelection);
        break;
       case "Payment":
        Wrappers.verifyElementIsDisplayed(transportationHeading);
        break;
       case "SummaryModal":
        Wrappers.verifyElementIsDisplayed(summaryModalHeading);
        break;
       case "ThankYouDetails":
        Wrappers.verifyElementIsDisplayed(confirmationHeader);
        break;
      }
     }

    public String getApiErrorComponentData(String key) throws IOException{
        return getJsonDatalocale("en").getJSONObject("apiErrors").get(key).toString();
    }

    public  JSONObject getLoginDetailsBasedOnTestLevels(String testLevels,String referenceName) throws IOException {
        return getJsonData("loginDetailsBasedOnTestLevels").getJSONObject(testLevels).getJSONObject(referenceName);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }

}
