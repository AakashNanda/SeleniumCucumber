package com.fedex.test.shipping.ResuableJavaFactory;

import com.experitest.selenium.MobileWebDriver;
import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.SummaryCardDataStore.*;
import com.fedex.test.shipping.cucumberSteps.ThankYouPage_Steps;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;


@SuppressWarnings("deprecation")
public class SeleniumReusableMethods extends Wrappers {

    public static String currentLocale;
    public static ArrayList<WebElement> focusedElem = new ArrayList<WebElement>();
    SummaryPageObjects summaryPageObjects = new SummaryPageObjects();

    
    public void click_on_feature_element(String classPath) throws Exception {
        WebElement ele =getWebElementByClassPath(classPath);
    	waitForElement(ele);
    	clickOnElement(ele);
        Thread.sleep(2000);
    }


    public static void verify_select_options(List<String> expectedOptions, WebElement element) {

        try {
            Boolean checkElementsPresent=(new ArrayList<>(expectedOptions)).containsAll(getAllAvailableOptionsInSelect(element));
            Assert.assertTrue(checkElementsPresent,"All Options not found");
        } catch (Exception e) {
            Assert.fail();
        }
    }


    public void verify_element_displayed(List<String> classPath) {
        try {
            for (String s : classPath) {
                WebElement element = getWebElementByClassPath(s);
                waitForElement(element);
                Boolean elementDisplayed = element.isDisplayed();
                Assert.assertTrue(elementDisplayed,"Element is not displayed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void verify_element_not_displayed(List<String> classPath) {
        try {
            for (String s : classPath) {
                WebElement element = getWebElementByClassPath(s);
                try {
                    Boolean elementDisplayed = element.isDisplayed();
                    Assert.assertFalse(elementDisplayed,"Element is displayed but it should not be displayed");
                } catch (NoSuchElementException e) {
                  Assert.assertEquals("Element is not displayed as expected","Element is not displayed as expected");
                }
            }
        }catch (Exception e) {
            Assert.fail();
        }
    }

    public void select_Account_In_Appbar(WebElement AppBar, WebElement accountDropDown, WebElement accountnameinlist) throws InterruptedException {
        waitForElement(AppBar);
        clickOnElement(accountDropDown);
        //clickOnElementJS(browser, accountDropDown);
        clickOnElement(accountnameinlist);
        //clickOnElementJS(browser, accountnameinlist);
        try {
            if (getProp("level").equalsIgnoreCase("L3")) {
                getTextFromAndCompareTextWithUI(accountDropDown,
                        "My Account-148");
            } else if (getProp("level").equalsIgnoreCase("L6")) {
                getTextFromAndCompareTextWithUI(accountDropDown,
                        "My Account-460");
            } else if (getProp("level").equalsIgnoreCase("L2")) {
                getTextFromAndCompareTextWithUI(accountDropDown,
                        "My Account-920");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void verifyAccountSelection(WebElement appbarAccountList, WebElement appbarAccountListItem) {
        try {
            clickOnElement(appbarAccountList);
            String accountNoInList = getTextInSelectElement(appbarAccountListItem);
            clickOnElement(appbarAccountListItem);
            String accountNoSelected = getTextInSelectElement(appbarAccountList);
            compareTextValue(accountNoInList.trim(), accountNoSelected.trim());

        } catch (Exception e) {

        }
    }

    public void verify_Element_Not_Displayed_WithoutClassPath(WebElement modalWindow, WebElement Appbar) {
        try {
            Boolean elementDisplayed = modalWindow.isDisplayed();
            Assert.assertFalse(elementDisplayed, "Element is displayed but it should not be displayed");
            elementisDisplayedAndEnabled(Appbar);
        } catch (NoSuchElementException e) {
            Assert.assertEquals("Element is not displayed as expected","Element is not displayed as expected");
        }
    }


    public void verify_other_document_error_messages(WebElement element, String key) throws IOException, Exception {
        getTextFromAndCompareTextWithUI(element, getShipmentErrorMessages(key));
    }

    public void verify_other_document_error_messages_CustomsValError(WebElement element, String key) throws IOException, Exception {
        getTextFromAndCompareTextWithUI_CustomsValueError(element, getShipmentErrorMessages(key));
    }


    public static String getCurrencySymbol(String currencyCode) throws IOException {
        JSONObject country = getJsonData("addressVScurrencyDetails");
        JSONArray addressDetails = country.getJSONArray("Countries");
        String details = null;
        for (int i = 0; i < addressDetails.length(); ) {
            if (((JSONObject) addressDetails.get(i)).get("CurrencyCodeExpected").toString().equalsIgnoreCase(currencyCode)) {
                details = ((JSONObject) addressDetails.get(i)).get("CurrencySymbols").toString();
                break;
            } else {
                i++;
            }
        }
        return details;
    }


    public void clickOnPrintDoc(WebElement printDoc, WebElement close) throws InterruptedException {
        if (printDoc.isEnabled()) {
            clickOnElement(printDoc);
        } else {
            clickOnElement(close);
            clickOnElement(printDoc);
        }
    }

    public void closekeyboard() {
        closeKeyboard();
    }


    public void verifyValueInElement(String valuetoEnter, String element) throws InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        WebElement ele = getWebElementByClassPath(element);
        waitForElement(ele);
        getTextFromAndCompareTextWithUI(ele, valuetoEnter);
    }

    public void verifyInnerTextValueInElement(String valuetoEnter, String element) throws Exception {
        WebElement ele = getWebElementByClassPath(element);
        getTextFromAndCompareTextWithUI(ele, valuetoEnter);
    }


    public void verify_error_message_displayedMobile_ClasspathAndJSON(String classPath, String jsonParent, String keyValue, String pixel) throws IOException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        ((MobileWebDriver) DriverGenerator.getDriver()).device().runJavascript("window.scrollBy(0," + pixel + ")");
        JSONObject error = getJsonDatalocale("en").getJSONObject(jsonParent);
        String element = getStringElementByClassPath(classPath);
        getTextFromAndCompareTextWithUIMobile(element, error.get(keyValue).toString());
    }

    public void verify_error_message_displayed_ClasspathAndJSON(String classPath, String jsonParent, String keyValue) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, Exception {
        WebElement ele = getWebElementByClassPath(classPath);
        waitForElement(ele);
        String errorMsg = null;
        try {
            if (jsonParent.contains(".")) {
                String[] jsonTag = jsonParent.split("\\.");
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonTag[0]).getJSONObject(jsonTag[1]).getString(keyValue);
            } else {
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonParent).getString(keyValue);
            }
            getTextFromAndCompareTextWithUI(ele, errorMsg);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void verify_label_name_displayedMobile_ClasspathAndJSON(String classPath, String jsonParent, String keyValue, String pixel) throws IOException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        ((MobileWebDriver) DriverGenerator.getDriver()).device().runJavascript("window.scrollBy(0," + pixel + ")");
        JSONObject error = getJsonDatalocale("en").getJSONObject(jsonParent);
        String element = getStringElementByClassPath(classPath);
        getTextFromAndCompareTextWithUIMobile(element, error.get(keyValue).toString());
    }

    public void verify_label_name_displayed_ClasspathAndJSON(String element, String jsonParent, String keyValue) throws Exception {
        WebElement ele = getWebElementByClassPath(element);
        waitForElement(ele);
        String errorMsg = null;
        try {
            if (jsonParent.contains(".")) {
                String[] jsonTag = jsonParent.split("\\.");
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonTag[0]).getJSONObject(jsonTag[1]).getString(keyValue);
            } else {
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonParent).getString(keyValue);
            }
            getTextFromAndCompareTextWithUI(ele, errorMsg);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }


    public String getEmailValidationError(String jsonParent, String keyValue) throws JSONException, IOException {
        String errorMsg = null;
        try {
            if (jsonParent.contains(".")) {
                String[] jsonTag = jsonParent.split("\\.");
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonTag[0]).getJSONObject(jsonTag[1]).getString(keyValue);
            } else {
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonParent).getString(keyValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return errorMsg;
    }

    public void verifyErrorMessageForGivenElement(WebElement inputElement, WebElement errorElement, String valueToEnter,
                                                  String expectedErrorMessage) {
        try {
            waitForElement(inputElement);
            inputElement.clear();
            enterValue(inputElement, valueToEnter);
            tabOut(inputElement);
            getTextFromAndCompareTextWithUI(errorElement, expectedErrorMessage);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }


    public void clickOnUpdate(WebElement element) throws InterruptedException, IOException {
        if (Property.getProp("platform").equalsIgnoreCase("mobile")) {
            waitForElement(element);
            if (element.isDisplayed()) {
                clickOnElement(element);
            }
        } else {
            scrollToElement(element);
            waitForElement(element);
            clickOnElement(element);
        }
    }


    public static void compareExpectedVSActualDesktop(String actual, String expected, String fieldName) {
        if (expected != null && actual != null) {
            Assert.assertEquals( actual.trim().replaceAll(" +", ""),expected.trim().replaceAll(" +", ""),
                    "Actual value - " + actual + "" + fieldName + " , does not match with Expected value  - " + expected);
        }
    }

    public static void compareExpectedVSActualDesktopServiceType(String actual, String expected, String fieldName) {
        if (expected != null && actual != null) {
            if(actual.contains(expected) || expected.equals(actual) || expected.contains(actual)) {
                Assert.assertEquals("Actual Selected Rate Service Matches Expected","Actual Selected Rate Service Matches Expected");
            } else {
                Assert.fail();
            }
        }
    }

    public void shipmentDetailsCurrencySymbolIsSameAsShipmentDetails(WebElement docCustomsCurrency) {
        CopyOnWriteArrayList<SummaryPackaging> summaryPagePackageDetails = summaryPageObjects.summaryPackagingExpectedData;
        try {
            String documentCurrencyCode = getText(docCustomsCurrency);
            String expectedDocumentCurrencyCode = summaryPagePackageDetails.get(0).getPackageDeclaredValueAndCurrency().trim();
            Boolean currencySymbolValidation = documentCurrencyCode.equals(expectedDocumentCurrencyCode.substring(expectedDocumentCurrencyCode.length() - 3));
            Assert.assertTrue(currencySymbolValidation, "Document currency code is Not same as currency code selected in shipment details");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Document currency code is Not same as currency code selected in shipment details");
        }
    }

    public void customsValueGreaterError(WebElement element) {
        CopyOnWriteArrayList<SummaryPackaging> summaryPagePackageDetails = summaryPageObjects.summaryPackagingExpectedData;
        try {
            String expectedShipmentCurrencyValueAndCode = summaryPagePackageDetails.get(0).getPackageDeclaredValueAndCurrency().trim();
            String actualMessage = getInnerText(element);
            String expectedMessage = getJsonDatalocale("en").getJSONObject("customsSection").getJSONObject("customsDocumentSection").getString("customsValueGreaterThanEqualRequired").replaceAll("\\{\\{customsCurrency\\}\\}", expectedShipmentCurrencyValueAndCode);
            compareTextValue(actualMessage, expectedMessage);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Customs Value less error message is not displayed");
        }
    }


    public void selectValueByValueMobile(String Method, String element, String value){
        selectbyValueMobile((MobileWebDriver) DriverGenerator.getDriver(),Method,element,value);
    }


    public void FieldIsEnabledOrDisabled(WebElement element){
        waitForElement(element);
        Boolean elementDisplayedAndEnabled = elementisDisplayedAndEnabled(element);
        Assert.assertFalse(elementDisplayedAndEnabled,"Element is Editable");
    }


    public void verifyNoErrorMessageForGivenElement(WebElement inputElement, WebElement errorElement, String valueToEnter) {
        try {
            waitForElement(inputElement);
            inputElement.clear();
            enterValue(inputElement, valueToEnter);
            clickOnTab();
            Boolean elementDisplayed = elementisDisplayedAndEnabled(errorElement);
            String errorMessage = getInnerText(errorElement);
             Assert.assertFalse(elementDisplayed,"Error Message displayed is "+errorMessage);
            inputElement.clear();
        } catch (Exception e) {
           Assert.assertEquals("No error message is displayed","No error message is displayed");

        }
    }

    public boolean verifyActiveElementIsWithExpected(WebElement expectedElement, String attribute) {
        boolean matched = false;
        try {
            WebElement activeElement = DriverGenerator.getDriver().switchTo().activeElement();
            String activeElementAttribute = activeElement.getAttribute(attribute);
            String expectedElementAttribute = expectedElement.getAttribute(attribute);
            if (activeElementAttribute.equals(expectedElementAttribute)) {
                matched = true;
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
        return matched;
    }

    public String getAddressComponentData(String key) throws JSONException, IOException {
    	return getJsonDatalocale("en").getJSONObject("addressSection").get(key).toString();
    }
   
    public void selectValueInGivenElement(WebElement element, String sendText) {
        try {
            waitForElement(element);
            waitforSelectValue(element);
            selectValuebyValue(element, sendText);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception Occured");
        }
    }


    public void verifySignatureServiceOption(WebElement signatureOptions){
        try {
            Thread.sleep(1000);
            waitForElement(signatureOptions);
            if (elementisDisplayedAndEnabled(signatureOptions)) {
                getTextFromAndCompareTextWithUI(signatureOptions, getRatingSectionSignatureComponentData("signatureOptionsTitle"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }


    public void enterTextInGivenElement(WebElement element, String sendText) {
        try {
            waitForElement(element);
            enterValue(element, sendText);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void verify_hs_tooltip(WebElement toolTip,WebElement element) throws Exception{
        JSONObject tooltip = getJsonDatalocale("en").getJSONObject("customsSection").getJSONObject("customsNonDocSection");
        waitForElement(toolTip);
        clickOnElement(toolTip);
        getTextFromAndCompareTextWithUI(element,tooltip.get("hsCodeToolTipMsg").toString()); //hsTooltip
    }

    public void verifyToolTipText(WebElement toolTip,WebElement toolTipMessage, String expectedText) {
        try {
            waitForElement(toolTip);
            clickOnElement(toolTip);
            getTextFromAndCompareTextWithUI(toolTipMessage, expectedText); //coverageTooltipmessage
            clickOnElement(toolTip);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void verifyWeightErrorInpackagesection(String errorKey, WebElement element, List<WebElement> elements) {
    	try {
            if (errorKey.equalsIgnoreCase("weightMaxLimit")) { //weightRequirederror
                int[] key = {2};
                getTextFromAndCompareTextWithUI(element, getPackageSectionWeightData(errorKey).replace("{{weight}}",getInnerText(element).split(" ")[2]).replace("{{units}}",getInnerText(elements.get(0)))); //shipmentDetailsUnits
            }else if (errorKey.equalsIgnoreCase("coverageNumericError")){
            	getTextFromAndCompareTextWithUI(element, getLiabilityCoverageComponentData(errorKey));
            } else {
            	getTextFromAndCompareTextWithUI(element, getPackageSectionWeightData(errorKey).replace("{{weight}}",getInnerText(element).split(" ")[2]).replace("{{units}}",getInnerText(elements.get(0)))); //shipmentDetailsUnits
            }
        } catch (Exception e) {
    	    e.printStackTrace();
            Assert.fail();
        }
    }

    public void clickonTermslink(String terms, WebElement termsOfUse, WebElement termsAndconditions) throws InterruptedException {
        switch(terms){
            case "Terms of Use": clickOnElement(termsOfUse);
                break;
            case "Terms and Conditions": clickOnElement(termsAndconditions);
                break;
        }
    }

    public void verifyShipDate_TwoDays(WebElement shipDateId) throws InterruptedException {
        clickOnElement(shipDateId);
        Select shipDate = new Select(shipDateId);
        int shipDateSize = shipDate.getOptions().size();
        Boolean shipDateValidation = shipDateSize == 2;
        Assert.assertTrue(shipDateValidation,"ShipDate list more than two days");
    }
    public void verifyShipMentHistory_Defaultvalue(WebElement shipMentDropdown) throws InterruptedException {

        Select shipMentDropdownList = new Select(shipMentDropdown);
        String defaultValue = shipMentDropdownList.getFirstSelectedOption().getText();
        Assert.assertEquals(defaultValue,"Ship Date");
    }

    public static String getMediumDateFormatForLocale(String locale) {
        String pattern;
        if (locale.equalsIgnoreCase("es_us")) {
            pattern = "d MMM. yyyy";
        } else {
            DateFormat shortDate = DateFormat.getDateInstance(DateFormat.MEDIUM,
                    new Locale(locale.split("_")[0].trim(), locale.split("_")[1].trim()));

            pattern = ((SimpleDateFormat) shortDate).toPattern();
        }
        return pattern;
    }
    public static String getShortTimeFormatForLocale(String locale) {
        DateFormat shortDate = DateFormat.getTimeInstance(DateFormat.SHORT, new Locale(locale.split("_")[0].trim(), locale.split("_")[1].trim()));
        return ((SimpleDateFormat) shortDate).toPattern();
    }

    public void verifyShipDate(String index, WebElement shipDateId, WebElement amountsshown) throws InterruptedException {
        clickOnElement(shipDateId);
        Select shipDate = new Select(shipDateId);
        int shipDateSize = shipDate.getOptions().size();
        if (shipDateSize == 2) {
            switch (index){
                case"0": shipDate.selectByIndex(0);
                    break;
                case"1": shipDate.selectByIndex(1);
                    break;
            }
            waitForElement(amountsshown);
        } else {
            Assert.fail("ShipDate list more than two days");
        }
    }
    
    public void verifyDimensionErrorInpackagesection(String errorKey, WebElement element, List<WebElement> elements) {
    	 try {
             if (errorKey.equalsIgnoreCase("coverageNumericError")) {
            	 getTextFromAndCompareTextWithUI(element, getLiabilityCoverageComponentData(errorKey));
             } else {
                 String dimensionUnitVal= getInnerText(elements.get(1));
                 getTextFromAndCompareTextWithUI(element, getPackageSectionDimensionComponentData(errorKey).replace("{{ unit }}",dimensionUnitVal));
             }
         } catch (Exception e) {
    	     e.printStackTrace();
             Assert.fail();
         }
    }

    public void verify_Shipment_Date(WebElement rateServicesButton, WebElement shipDateId ) throws IOException {
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            waitForElement(rateServicesButton);
            String currentLocale = getFedExLocale();

            String dateFormat = getFullDateFormatForLocale(currentLocale.trim());
            Select shipDate = new Select(shipDateId);
            int shipDateSize = shipDate.getOptions().size();
            String[][] dates = new String[shipDateSize + 1][shipDateSize + 1];
            dates[0][0] = "Occurance";
            dates[0][1] = "Shipment Date";
            dates[0][2] = "Format";
            for (int i = 0; i < shipDateSize; i++) {
                String shipmentDate = shipDate.getOptions().get(i).getText().trim();
                dates[i + 1][0] = String.valueOf(i + 1);
                dates[i + 1][1] = shipmentDate;
                dates[i + 1][2] = dateFormat;
                try {
                    String parseDate = parseDate(
                            new Locale(currentLocale.split("_")[0], currentLocale.split("_")[1]), shipmentDate, dateFormat);
                    if (parseDate == null) {
                        Assert.assertEquals("condition failed", "condition failed");
                    }
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void verify_Shipment_Date_in_HistoryPage(WebElement rateServicesButton, WebElement shipDateId ) throws IOException {
        if(Property.getProp("platform").equalsIgnoreCase("desktop")) {
            String currentLocale = getFedExLocale();
            System.out.println(currentLocale);
            String dateFormat = getFullDateFormatForLocale(currentLocale.trim());
            WebElement we = DriverGenerator.getDriver().findElement(By.xpath("//div[1]/li[1]/dl/dd[1]"));
            String shipmentDate = we.getText().trim();
            verifyDateLocalization(shipmentDate,dateFormat);

        }
    }

    public static void getTextAndArrayCompareWithDigitsInString(String actual, String expected, int[] digitPositionArray) {
        try {
            String[] act = actual.trim().replaceAll(" +", " ").split(" ");
            String[] exp = expected.trim().replaceAll(" +", " ").split(" ");
            if (exp.length == act.length) {
                for (int i : digitPositionArray) {
                    exp[i] = "\\d+";
                }
                for (int i = 0; i < exp.length; i++) {
                    Boolean checkMatch = act[i].matches(exp[i]);
                    Assert.assertTrue(checkMatch,"Expected string " + exp[i] + " array index " + i + " didn't match with actual " + act[i]);
                }
            }else{
                Assert.fail("Compare string length didn't match");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("compare exception");
        }
    }

    public void verifyInvoiceSection(String invoiceType, WebElement invoiceText, List<WebElement> invoiceLabel) {
        try {
            switch (invoiceType.toLowerCase()) {
                case "commercial":
                    String ci = "Commercial invoice";
                    String toMatchCI = getConfirmationSectionPrintComponentData("printInvoiceTextDesc").replaceAll("\\{\\{invoiceType}}", ci);
                    getTextAndArrayCompareWithDigitsInString(invoiceText.getText(), toMatchCI, new int[]{1});
                    getTextFromAndCompareTextWithUI(invoiceLabel.get(0), ci);
                    break;
                case "proforma":
                    String pi = "Pro Forma invoice";
                    String toMatchPI = getConfirmationSectionPrintComponentData("printInvoiceTextDesc").replaceAll("\\{\\{invoiceType}}", pi);
                    getTextAndArrayCompareWithDigitsInString(invoiceText.getText(), toMatchPI, new int[]{1});
                    getTextFromAndCompareTextWithUI(invoiceLabel.get(0), pi);
                    break;
                case "myown":
                    String ciOwn = "Commercial invoice";
                    String toMatchOwnCI = getConfirmationSectionPrintComponentData("printInvoiceTextDesc").replaceAll("\\{\\{invoiceType}}", ciOwn);
                    getTextAndArrayCompareWithDigitsInString(invoiceText.getText(), toMatchOwnCI, new int[]{1});
                    getTextFromAndCompareTextWithUI(invoiceLabel.get(0), ciOwn);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }


    public void user_Clicks_On_Field_Section(String classpath) throws InterruptedException {
        try {
            WebElement element = getWebElementByClassPath(classpath);
            try {
                if (elementisDisplayedAndEnabled(element)) {
                    scrollToElement(element);
                    clickOnElement(element);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("element is not clickable");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to fetch element");
        }
    }


    public void logged_In_User_Account_Format(WebElement AppBar, WebElement accountDropDown){
        waitForElement(AppBar);
        try {
            if (getProp("level").equalsIgnoreCase("L3")) {
                getTextFromAndCompareTextWithUI(accountDropDown, "641105562-562");
            } else if (getProp("level").equalsIgnoreCase("L6")) {
                getTextFromAndCompareTextWithUI(accountDropDown, "763181260_us-260");
            } else if (getProp("level").equalsIgnoreCase("L2")){
                getTextFromAndCompareTextWithUI(accountDropDown, "751254660-660");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void colorVerification(String colorcode ,WebElement element) {
        //scrollToElement(element);
        if (elementisDisplayedAndEnabled(element)) {
            String color = element.getCssValue("color");
            // RGB to HEX
            String[] color_hex;
            color_hex = color.replace("rgba(", "").split(",");
            try {
                String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
                Assert.assertEquals(colorcode,actual_hex,"Given color is not displayed");
            }catch(Exception e){
                e.printStackTrace();
                Assert.fail();
            }

        }
    }


    public void colorVerificationOfInformation(String color,String classPath) throws Exception {
        WebElement element = getWebElementByClassPath(classPath);
        final String Blue = "#0079b5";
        final String Grey = "#333333";

        if (color.equalsIgnoreCase("Blue")) {
            colorVerification( Blue,element);
        } else {
            colorVerification(Grey,element);
        }
    }



    public String getFedExLocale(){
          currentLocale = getCookieValue("fdx_locale");
        return currentLocale;
    }

    public String getCookieValue(String  cookieName) {
        return DriverGenerator.getDriver().manage().getCookieNamed(cookieName).getValue();
    }

    public String getFullDateFormatForLocale(String locale) {
        String pattern;
        if (locale.equalsIgnoreCase("es_us")) {
            pattern = "EEE d MMM. yyyy";
        } else {
            DateFormat fullDate = DateFormat.getDateInstance(DateFormat.FULL,
                    new Locale(locale.split("_")[0].trim(), locale.split("_")[1].trim()));
            pattern = ((SimpleDateFormat) fullDate).toPattern();
        }
        return pattern;
    }

    public String parseDate(Locale locale, String actualDate, String expectedFormat) {
        return LocalDate.parse(actualDate, DateTimeFormatter.ofPattern(expectedFormat, locale)).toString();
    }


    public void verifyTermsurl(String terms) {
    	 String getNewURL=windowHandleURL();
         switch(terms){
             case "Terms of Use":
                     Assert.assertEquals(getNewURL.contains("terms-of-use.html"),true);
                 break;
             case "Terms and Conditions":
                     Assert.assertEquals(getNewURL.contains("conditions-of-carriage.html"),true);
                 break;
             default:
                 break;
         }
    }

    public String windowHandleURL(){
        String currentUrl=null;
        ArrayList<String> win=new ArrayList<>(DriverGenerator.getDriver().getWindowHandles());
        DriverGenerator.getDriver().switchTo().window(win.get(1));
        currentUrl=DriverGenerator.getDriver().getCurrentUrl();
        DriverGenerator.getDriver().close();
        DriverGenerator.getDriver().switchTo().window(win.get(0));
        win.clear();
        return currentUrl;
    }

    
    public  void verifyDateLocalization( String actualString, String expectedFormat) {
        try {
//            String currentLocale = getFedExLocale(report);
            String parseDate = parseDate(new Locale(currentLocale.split("_")[0], currentLocale.split("_")[1]), actualString, expectedFormat);
            if (parseDate == null) {
                Assert.fail();
            } else {
                Assert.assertEquals("Given date is in expected format","Given date is in expected format");
            }
        } catch (DateTimeParseException e) {
            Assert.fail();
        }
    }

    
    
    public void toVerifyPickupOrDropOffPageDetails(PickUpAndDropOffObjects pickUpAndDropOffObjects, RateQuotesObjects rateQuotesObjects) {
    	

    	 try {
	            waitForElement(pickUpAndDropOffObjects.pickUpDropOffheading);
	            String pickUpDropOffSelected = getTextInUserInputElement(pickUpAndDropOffObjects.pickUpDropOffSelection);
	            if (elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpDropOffSelection) &&
	            		elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpReadyTimeselection) &&
	            		!elementisDisplayedAndEnabled(pickUpAndDropOffObjects.dropOffPreselection)) {
	                if (elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpReadyTimeselection) &&
	                		elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpLatestTimeAvailableselection)
	                		&& elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickupDateFormcontrol)) {
	                	selectValueInGivenElement(pickUpAndDropOffObjects.pickUpInstrSelect, "ENTER_LOCATION");
	                	enterTextInGivenElement(pickUpAndDropOffObjects.pickUpInstrInputFormControl, "Free text");
	                	toverifyPickupDate(pickUpAndDropOffObjects);
	                	toaltPickUpHeadingAndCB(pickUpAndDropOffObjects);
	                } else {
	                    Assert.fail();
	                }
	            } else if (elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpDropOffSelection)
	            		&& !elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpReadyTimeselection)
	            		&& elementisDisplayedAndEnabled(pickUpAndDropOffObjects.dropOffPreselection)) {
	                if (!elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickupDateFormcontrol)
	                		&& !elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpReadyTimeselection) &&
	                		!elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpLatestTimeAvailableselection) &&
	                		!elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpInstrInputFormControl)
	                		&& elementisDisplayedAndEnabled(pickUpAndDropOffObjects.dropOffPreselection)) {
	                    clickOnElement(rateQuotesObjects.summaryDeliveryEdit);
	                    waitForElement(rateQuotesObjects.rateServicesButton);
	                    if (elementisDisplayedAndEnabled(rateQuotesObjects.Headermessage)) {
                            toverifyPickupCutOffInlineErrorModal(rateQuotesObjects);
	                    	rateQuotesObjects.selectFedExServiceRateButton();
	                    }
	                } else {
	                    Assert.fail();
	                }
	            }
	        } catch (Exception e) {
    	        e.printStackTrace();
	            Assert.fail();
	        }
    }

    public void toaltPickUpHeadingAndCB(PickUpAndDropOffObjects pickUpAndDropOffObjects) throws IOException {
    	 waitForElement(pickUpAndDropOffObjects.pickUpDropOffheading);
//	        getTextAndCompareTranslationText(pickUpDropOffHeading, AddressDetails.getPickupDropOffSectionComponentData("heading"), report);
//	        getTextAndCompareTranslationText(browser, pickUpDropOffSelection, AddressDetails.getPickupDropOffSectionComponentData("pickUpLabel").toString(), report);
	        getLabelTextAndCompare(pickUpAndDropOffObjects.pickUpDropOffSelection, getPickupDropOffSectionComponentData("pickUpLabel").toString());
	        getLabelTextAndCompare(pickUpAndDropOffObjects.pickUpReadyTimeselection, getPickupDropOffSectionComponentData("readyTime").toString());
	        getLabelTextAndCompare(pickUpAndDropOffObjects.pickUpLatestTimeAvailableselection, getPickupDropOffSectionComponentData("timeAvailable").toString());
	        getLabelTextAndCompare(pickUpAndDropOffObjects.pickUpInstrSelect, getPickupDropOffSectionComponentData("pickUpInstructionsLabel").toString());
	        getLabelTextAndCompare(pickUpAndDropOffObjects.pickUpInstrInputFormControl, getPickupDropOffSectionComponentData("pickUpSpecialInstructionsLabel").toString());
    }

    public void toverifyPickupDate(PickUpAndDropOffObjects pickUpAndDropOffObjects) {
    	waitForElement(pickUpAndDropOffObjects.pickupDateFormcontrol);
//        String currentLocale = getFedExLocale(report);
        String dateFormat = getFullDateFormatForLocale(currentLocale.trim());
        String pickupDate = getTextInUserInputElement(pickUpAndDropOffObjects.pickupDateFormcontrol);
        verifyDateLocalization(pickupDate, dateFormat);
    }

    public void toverifyPickupCutOffInlineErrorModal(RateQuotesObjects rateQuotesObjects) {
    	 try {
	            waitForElement(rateQuotesObjects.rateServicesButton);
	            if (elementisDisplayedAndEnabled(rateQuotesObjects.Headermessage) && elementisDisplayedAndEnabled(rateQuotesObjects.icon)) {
//	                getTextAndCompareTranslationText(HeaderMessage, AddressDetails.getRatingSectionComponentData("dropOffNotification"), report);
	            } else {
	                Assert.fail();
	            }
	        } catch (Exception e) {
	            Assert.fail();
	        }
    }
  

   

    public void toUserClicksOnPrintDocumentLabelVerifyOpensNewTab(String labelFlag,String invoiceFlag,
                                                                  ThankYouPageObjects thankYouPageObjects,
                                                                  ThankYouPage_Steps thankYouPage_Steps)
    {

        thankYouPage_Steps.selectPrintLabelCheckBoxSelection(labelFlag);
        thankYouPage_Steps.selectPrintInvoiceCheckBoxSelection(invoiceFlag);

        try {
            waitForElement(thankYouPageObjects.confirmationPrintSectionHeading);
            thankYouPage_Steps.clickOnPrintLabel();
            ArrayList<String> browserTabs = new ArrayList<String>(DriverGenerator.getDriver().getWindowHandles());
            if (Boolean.valueOf(labelFlag) || Boolean.valueOf(invoiceFlag)) {
                if (browserTabs.size() > 0) {
                    DriverGenerator.getDriver().switchTo().window(browserTabs.get(0));
                } else {
                    Assert.fail();
                }
            } else {
                if (browserTabs.size() == 0) {
                    Assert.fail();
                } else {
                    DriverGenerator.getDriver().switchTo().window(browserTabs.get(1));
                    DriverGenerator.getDriver().switchTo().window(browserTabs.get(0));
                    Assert.fail();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    public void UserClicksOnPrintDocumentLabelVerifyOpensNewTab(String labelFlag,ThankYouPage_Steps thankYouPage_Steps,ThankYouPageObjects thankYouPageObjects) {
    	thankYouPage_Steps.selectPrintLabelCheckBoxSelection(labelFlag);
        try {
            waitForElement(thankYouPageObjects.confirmationPrintSectionHeading);
            ArrayList<String> browserTabs = new ArrayList<String>(DriverGenerator.getDriver().getWindowHandles());
            if (Boolean.valueOf(labelFlag) ) {
                if (browserTabs.size() > 0) {
                	 DriverGenerator.getDriver().switchTo().window(browserTabs.get(1));
                	 DriverGenerator.getDriver().switchTo().window(browserTabs.get(0));
                } else {
                    Assert.fail();
                }
            } else {
                if (browserTabs.size() == 0) {
                    Assert.fail();
                } else {
                	 DriverGenerator.getDriver().switchTo().window(browserTabs.get(1));
                	 DriverGenerator.getDriver().switchTo().window(browserTabs.get(0));
                    Assert.fail();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void UserClicksOnTrackingNumberVerifyOpensNewTab(ShipmentHistoryPageObjects shipmentHistoryObjects) {

        try {
          //  waitForElement(shipmentHistoryObjects.Tracking_Page);
            ArrayList<String> browserTabs = new ArrayList<String>(DriverGenerator.getDriver().getWindowHandles());

            if (browserTabs.size() != 2) {
                Assert.fail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }


    public void  toThankYouPageTextLanguage(ThankYouPageObjects thankYouPageObjects) throws Exception{
        getTextFromAndCompareTextWithUI(thankYouPageObjects.confirmationHeader, getConfirmationSectionComponentData("successMsg1"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.confirmationPrintSectionHeading, getConfirmationSectionPrintComponentData("printLabelText"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.confirmationPrintSectionSubHeading, getConfirmationSectionPrintComponentData("printSectionSubHeading"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.printLabelCheckboxLabel.get(0), getConfirmationSectionPrintComponentData("printLabelCheckboxLabel"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.printLabelDescText, getConfirmationSectionPrintComponentData("printLabelTextDec"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.printLabelDescLink, getConfirmationSectionComponentData("downloadHeader"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.printDocumentsButton, getConfirmationSectionPrintComponentData("printLabelButton"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.confirmationTrackSectionHeading, getConfirmationSectionTrackingComponentData("trackingTitle"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.trackingNumberDesc, getConfirmationSectionTrackingComponentData("trackingDescription"));
        getTextFromAndCompareTextWithUI(thankYouPageObjects.createAnothershipmentButton, getConfirmationSectionComponentData("createAnotherShipmentLabel"));
    }

    public void toDownloadLabelLink(ThankYouPageObjects thankYouPageObjects){
        try {
            String browserName = getBrowserName();
            if (browserName.toLowerCase().contains("internet") || browserName.toLowerCase().contains("safari")) {
                if (elementisDisplayedAndEnabled(thankYouPageObjects.printLabelDescLink)) {
                    Assert.fail("Links are displayed in IE or Safari");
                }
            } else {
                    Assert.assertTrue(elementisDisplayedAndEnabled(thankYouPageObjects.printLabelDescLink),"Links are not displayed in browser");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    public void toVerifyReadyTimeBeforeLatestTimeAlertMessageWhenReadyTimeIsAndAsLatestTime(String readyTime, String latestTime,PickUpAndDropOffObjects pickUpAndDropOffObjects) {
    	try {
            Select pickupReadyTime = new Select(pickUpAndDropOffObjects.pickUpReadyTimeselection);
            Select pickupLatestTime = new Select(pickUpAndDropOffObjects.pickUpLatestTimeAvailableselection);
            int pickupReadyTimeSize = pickupReadyTime.getOptions().size();
            int pickupLatestTimeSize = pickupLatestTime.getOptions().size();
            for (int i = 1; i < pickupReadyTimeSize - 1; i++) {
                if (readyTime.equalsIgnoreCase(pickupReadyTime.getOptions().get(i).getText().trim())) {
                	selectByIndex(pickUpAndDropOffObjects.pickUpReadyTimeselection, readyTime);
                	selectByIndex(pickUpAndDropOffObjects.pickUpLatestTimeAvailableselection, latestTime);
                    waitForElement(pickUpAndDropOffObjects.pickUpReadyTimeSelectionErrormessage);
                    if (elementisDisplayedAndEnabled(pickUpAndDropOffObjects.pickUpReadyTimeSelectionErrormessage)) {
                    	getTextFromAndCompareTextWithUI(pickUpAndDropOffObjects.pickUpReadyTimeSelectionErrormessage,getPickupDropOffSectionComponentDataPickup("pickupTimeErrorMessage"));
                    } else {
                        Assert.fail();
                    }
                    pickupLatestTime.selectByIndex(pickupLatestTimeSize - 1);
                    break;
                } else {

                   // Assert.fail();
                }
            }
        } catch (Exception e) {
    	    e.printStackTrace();
            Assert.fail();
        }
    }


    public void toVerifyMinimumAccessHourAlertMessageWhenReadyTimeIsAndAsLatestTime(String readyTime, String latestTime,String accessHour,PickUpAndDropOffObjects pickUpAndDropOffObjects) {
    	try {
            Select pickupReadyTime = new Select(pickUpAndDropOffObjects.pickUpReadyTimeselection);
            Select pickupLatestTime = new Select(pickUpAndDropOffObjects.pickUpLatestTimeAvailableselection);
            int pickupReadyTimeSize = pickupReadyTime.getOptions().size();
            int pickupLatestTimeSize = pickupLatestTime.getOptions().size();
            selectByIndex(pickUpAndDropOffObjects.pickUpReadyTimeselection, readyTime);
            selectByIndex(pickUpAndDropOffObjects.pickUpLatestTimeAvailableselection, latestTime);
            if (DriverGenerator.getDriver().getPageSource().contains("Please select a minimum time frame of 2 hours.")) {
            } else {
                Assert.fail();
            }
            pickupLatestTime.selectByIndex(pickupLatestTimeSize - 1);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void toVerifySignatureOptionListedRateBreakdown(RateQuotesObjects rateQuotesObjects) {
    	try {
            Thread.sleep(1000);
            if (checkStatusCheckBox(rateQuotesObjects.Signatureoptions)) {
                waitForElement(rateQuotesObjects.servicesButton11_breakdown);
                clickOnElement(rateQuotesObjects.servicesButton11_breakdown);
                waitForElement(rateQuotesObjects.servicesButton_11_Directsignaturerequired);
                if (elementisDisplayedAndEnabled(rateQuotesObjects.servicesButton_11_Directsignaturerequired)) {
                  Assert.assertEquals("Signature option is listed in rate breakdown as expectd ","Signature option is listed in rate breakdown as expectd ");
                } else {
                    Assert.fail();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void toVerifyFromFieldLabels(SummaryModalWindowObjects summaryModalWindowObjects) throws Exception {
    	 waitForElement(summaryModalWindowObjects.summaryModalCloseicon);
//	        getTextAndCompareTranslationText(summaryModalLegalStatement, SummaryModalWindow.getSummaryModalShipmentDetailsComponentData("finalizeShipmentLegalStatement").replace("<a tabindex='0' class='fx-modal-link termsOfUse' title='on click will open the new window.'>","").replace("<a tabindex='0' class='fx-modal-link serviceGuide' title='on click will open the new window.'>","").replace("<a tabindex='0' class='fx-modal-link termsConditions' title='on click will open the new window.'> ","").replace("</a>","").trim(), report);
	        String legalmessage= getInnerText(summaryModalWindowObjects.summaryModalLegalstatement);
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalFromToHeader, getSummaryModalComponentData("fromToHeader"));
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.shipmentDetailsHeader, getSummaryModalShipmentDetailsComponentData("summaryShipDetailsHeading"));
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalServiceheading, getSummaryModalComponentData("yourService"));

    }

    public void tovalidateSummaryModalWindowRecipientAddressDetails(SummaryModalWindowObjects summaryModalWindowObjects) throws Exception {
        CopyOnWriteArrayList<SummaryTo> summaryToExpected = summaryPageObjects.summaryToExpectedData;
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalRecipientstreet, summaryToExpected.get(0).getToStreetLine());
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalRecipientPostalstate, summaryToExpected.get(0).getToPostalCity());
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalRecipientcountry, summaryToExpected.get(0).getToCountry());
    }

    public void toValidateSummaryModalWindowSenderAddressDetails(SummaryModalWindowObjects summaryModalWindowObjects) throws Exception {
        CopyOnWriteArrayList<SummaryFrom> summaryFromExpected = summaryPageObjects.summaryFromExpectedData;
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalSenderstreet, summaryFromExpected.get(0).getFromStreetLine());
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalSenderPostalcity, summaryFromExpected.get(0).getFromPostalCity());
	        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalSendercountry, summaryFromExpected.get(0).getFromCountry());
    }

    public void toValidatePriceBreakDownSection(SummaryPageObjects summaryPageObjects) throws JSONException, IOException, Exception {
        CopyOnWriteArrayList<SummaryRateService> summaryRateExpected = summaryPageObjects.summaryDeliveryExpectedData;
        CopyOnWriteArrayList<SummaryPayment> summaryPaymentExpected = summaryPageObjects.summaryPaymentExpectedData;
        CopyOnWriteArrayList<SummaryPickUpDropOff> summaryPickupExpected = summaryPageObjects.summaryPickUpDropOffExpectedData;
        String currencySymbol = summaryRateExpected.get(0).getAmountShown();
        getTextFromAndCompareTextWithUI(summaryPageObjects.priceBreakdowntitle, (getPaymentSummaryComponentData("priceBreakDown")+" ("+currencySymbol+")"));
        getTextFromAndCompareTextWithUI(summaryPageObjects.summaryBillingTransportationtype, (getPaymentSummaryComponentData("transportationHeading")));
//        getTextAndCompareTranslationText(summaryBillingDutiesTaxesType, (Payment.getPaymentSummaryComponentData("dutiesTaxesHeading").split("\n")[0]), report);

        //###################  Transportation and Duties details ###################
        String billToTransportation = getInnerText(summaryPageObjects.summaryBillto).split(":")[1].trim();
        String billToDuties = getInnerText(summaryPageObjects.summaryBillingDutiesTaxesdescription).split(":")[1].trim();
       compareExpectedVSActualDesktop(billToTransportation, summaryPaymentExpected.get(0).getBillToTransportationCost(),  "Summary Rate BreakDown Bill To Transportation");
       compareExpectedVSActualDesktop(billToDuties, summaryPaymentExpected.get(0).getBillToTransportationCost(),  "Summary Rate BreakDown Bill To Duties and Taxes");

//        //###################  Total Rate  ###################
//        String totalRateActual=SummaryPage.getTextInSummaryElement(summaryBillingTransportationEstTotal,report);
//        if (totalRateActual==summaryRateExpected.get(0).getTotalRate()){
//
//        }
    }

    public void toValidateSummaryModalWindowFromAddressSection(SummaryPageObjects summaryPageObjects,SummaryModalWindowObjects summaryModalWindowObjects) throws Exception {
        CopyOnWriteArrayList<SummaryFrom> summaryFromExpected = summaryPageObjects.summaryFromExpectedData;
        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalSendername, summaryFromExpected.get(0).getFromName());
        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalSendercompany, summaryFromExpected.get(0).getFromCompany());
    }

    public void toValidateSummaryModalWindowTOAddressSection(SummaryPageObjects summaryPageObjects,SummaryModalWindowObjects summaryModalWindowObjects) throws Exception {
        CopyOnWriteArrayList<SummaryTo> summaryToExpected = summaryPageObjects.summaryToExpectedData;
//        String[] recipientPostalStateCity = summaryModalRecipientPostalState.getText().split(" ");
        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalRecipientname, summaryToExpected.get(0).getToName());
        getTextFromAndCompareTextWithUI(summaryModalWindowObjects.summaryModalRecipientcompany, summaryToExpected.get(0).getToCompany());
    }

    public void tovalidateSummaryModalWindowDeliverySection(SummaryPageObjects summaryPageObjects) {
        CopyOnWriteArrayList<SummaryRateService> summaryDeliveryExpected = summaryPageObjects.summaryDeliveryExpectedData;
//        getTextFromAndCompareTextWithUI(summaryModalServiceName, summaryDeliveryExpected.get(0).getFedexServiceSelected(), report);
//        getTextFromAndCompareTextWithUI(summaryModalTransportationHeading, AddressDetails.getRatingSectionComponentData, report);
//        getTextFromAndCompareTextWithUI(summaryModalDutiesBill,AddressDetails.getRatingSectionComponentData, report);
    }

    public void toValidateSummaryModalWindowPackageSection(SummaryPageObjects summaryPageObjects) {
        CopyOnWriteArrayList<SummaryPackaging> summaryPackageExpected = summaryPageObjects.summaryPackagingExpectedData;
//	        getTextFromAndCompareTextWithUI(shipmentDetailsHeader,, report);

    }

    public void tovalidateSummaryModalWindowPaymentSection(SummaryPageObjects summaryPageObjects) {
        CopyOnWriteArrayList<SummaryPayment> summaryPaymentExpected = summaryPageObjects.summaryPaymentExpectedData;
//	        String billToTransport=SummaryPage.getTextInSummaryElement(summaryModalTransportationBill,report);
//	        String billToDuties=SummaryPage.getTextInSummaryElement(summaryModalDutiesBill,report);
    }

    public  void visible(WebElement element) {
        if (element.isDisplayed()) {
            Assert.assertEquals("Element is Visible - ","Element is Visible - ");
        } else {
            Assert.fail();
        }

    }

    public static void notVisibleCheck(WebElement ele) throws Exception
    {
        try{
            if (ele.isDisplayed())
            {
                Assert.assertTrue(ele.isDisplayed(),"element is displayed");
            }else{
              Assert.fail();
            }
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }


    }


    public void fieldError(String errorMessage,String fieldName, AddressEntryObjects addressEntryObjects)
    {
        switch (fieldName.toLowerCase()) {
            case "country":
                visible(addressEntryObjects.toUserCountryError);
                break;
            default:
                break;

        }

    }

    public void NameFieldError(String errorMessage,String fieldName, AddressEntryObjects addressEntryObjects) throws Exception
    {
        switch (fieldName.toLowerCase()) {
            case "country":
                notVisibleCheck(addressEntryObjects.toUserCountryError);
                break;
            default:
                break;
        }

    }


    public void fieldError1(String errorMessage,String fieldName, AddressEntryObjects addressEntryObjects)
    {
        switch (fieldName.toLowerCase()) {
            case "country":
                visible(addressEntryObjects.fromUserCountryerror);
                break;
            default:
                break;

        }

    }

    public void NameFieldError1(String errorMessage,String fieldName, AddressEntryObjects addressEntryObjects) throws Exception
    {
        switch (fieldName.toLowerCase()) {
            case "country":
                notVisibleCheck(addressEntryObjects.fromUserCountryerror);
                break;
            default:
                break;
        }

    }

    public void toverifyGoogleAddressDropdownField(String countryName)
    {
        try {
            int pos =0;
            for(int i=1;i<=5;i++){
                WebElement googleapiFrom = DriverGenerator.getDriver().findElement(By.cssSelector("body > div.pac-container.pac-logo > div:nth-child("+i+")"));
                String getText=googleapiFrom.getText();
                if(getText.endsWith(countryName)){
                    pos++;
                }
            }
            compareValue(pos,5);
        }
        catch(Exception e){
            e.printStackTrace();
        }
         }

      public void to_verify_whether_is_displaying_below_field(String error, String field,ShipmentDetailsNonDocObjects shipmentDetailsNonDocObjects) {
          switch (field) {
              case "HARMONIZED CODE":
                  if (error.equalsIgnoreCase("Harmonized code is not in valid format.")) { //temp
                      visible(shipmentDetailsNonDocObjects.harmonizedCodeinput);
                  } else if (error.equalsIgnoreCase("Harmonized code must be at least 6 characters.")) { //temp, should add var for error
                      visible(shipmentDetailsNonDocObjects.hsCodeMinError);
                  }
                  break;
              default:
                  break;
          }
      }

      public void to_application_should_navigate_to_page (String page,HomePageObjects homePageObjects){
        switch (page) {

            case "WIFM":
                verifyElementIsDisplayed(homePageObjects.wifmPageTitle);
                break;
            case "MAGS":
                verifyElementIsDisplayed(homePageObjects.welcomePageSimpleShippingButton);
                break;

            default:
                break;

        }
    }

    public void toverifyShipmentFailureInlineErrorModal(ThankYouPageObjects thankYouPageObjects,HomePageObjects  homePageObjects) throws Exception{
        waitForElement(thankYouPageObjects.HeaderMessage);
        if (elementisDisplayedAndEnabled(thankYouPageObjects.HeaderMessage) && elementisDisplayedAndEnabled(thankYouPageObjects.Icon)) {
            getTextFromAndCompareTextWithUI(thankYouPageObjects.HeaderMessage, homePageObjects.getApiErrorComponentData("pickupErrorMsg"));
            getTextFromAndCompareTextWithUI(thankYouPageObjects.pickupConfirmationError, homePageObjects.getApiErrorComponentData("pickupConfirmationFailMsg"));
        } else {
            Assert.fail();
        }
    }


    public void logintoShipping(AddressEntryObjects addressEntryObjects, HomePageObjects homePageObjects, String userName, String password){
        try {
            if (addressEntryObjects.globalLoginDropDowns.isDisplayed()&&!getProp("level").equalsIgnoreCase("L1")) {
                Thread.sleep(2000);
                waitForElement(homePageObjects.userId);
                enterValue(homePageObjects.userId, userName);
                enterValue(homePageObjects.userPassword, password);
                clickOnElementJS(homePageObjects.login);
                waitForElement(homePageObjects.logindrpdown);
                isLoggedInStatus(homePageObjects.logindrpdown);
            } else {
                waitForElement(homePageObjects.logindrpdown);
                Thread.sleep(2000);
                DriverGenerator.getDriver().findElement(By.id("global-login-wrapper")).click();
                waitForElement(homePageObjects.userId);
                enterValue(homePageObjects.userId, userName);
                enterValue(homePageObjects.userPassword, password);
                clickOnElementJS(homePageObjects.login);
                waitForElement(homePageObjects.logindrpdown);
                isLoggedInStatus(homePageObjects.logindrpdown);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /** Method  for highlighting issue element
     * @param issueElement
     */
    public void setError(WebElement issueElement) {
        ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("arguments[0].scrollIntoView(false)", issueElement);
        ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("arguments[0].setAttribute('style', 'outline: red 3px dashed; outline-offset:5px;');", issueElement);
        ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("arguments[0].setAttribute('style', '');", issueElement);
    }

    public void checkError(WebElement element) {
        if (!focusedElem.contains(element) && !element.getCssValue("outline").equals("rgb(77, 20, 140) dashed 1px")) {
            setError(element);
            Assert.fail("Focus not present for the Element");
        }
    }

    public void radioCheck(WebElement radioElement) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        if (radioElement.getTagName().equals("input") && radioElement.getAttribute("type").equals("radio")) {
            WebElement firstRadioButton = radioElement;
            int radioElemSize = DriverGenerator.getDriver().findElements(By.name(radioElement.getAttribute("name"))).size(); //returns no. of radio buttons with same name.
            for (int i = 0; i < radioElemSize; i++) {
                WebElement currentRadioElement = DriverGenerator.getDriver().switchTo().activeElement();
                checkError(currentRadioElement);
                if (!focusedElem.contains(currentRadioElement)) {
                    focusedElem.add(currentRadioElement);
                }
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                Thread.sleep(100);
            }
            if (!DriverGenerator.getDriver().switchTo().activeElement().equals(firstRadioButton)) {
                setError(radioElement);
                Assert.fail("Radio buttons are not accessible with Down arrow key");
            }
        }
    }


    /************************************* WCAG Validation ************************************/

    public void tooltipEnterCheck(List<WebElement> allElements) throws InterruptedException {
        for (WebElement tooltip : allElements) {
            Thread.sleep(3000);
            try {
                if (tooltip.isDisplayed()) {
                    tooltip.sendKeys(Keys.ENTER);
                    String tooltipAttribute = tooltip.getAttribute("aria-expanded");
                    Thread.sleep(3000);
                    if (tooltipAttribute.equalsIgnoreCase("true")) {
                        Assert.assertEquals("Tool Tip Attribute Available","Tool Tip Attribute Available");
                    } else {
                        setError(tooltip);
                        Assert.fail("Tool Tip not Clicked");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tabindexCheck(List<WebElement> toElements) {
        List<WebElement> tabIndexElements = (List<WebElement>) ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("return $(arguments[0]).find('input[tabindex=\"0\"],button[tabindex=\"0\"],select[tabindex=\"0\"],h1[tabindex=\"0\"],h2[tabindex=\"0\"],h3[tabindex=\"0\"]')", toElements);
        for (WebElement element : tabIndexElements) {
            try {

                if (element.isDisplayed()) {
                    setError(element);
                    Assert.fail("Element contains TabIndex");
                } else {
                    Assert.assertEquals("Tabindex not Found as expected","Tabindex not Found as expected");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void attributeRoleCheck(List<WebElement> linkElements) {

        for (WebElement semanticElement : linkElements) {
            try {
                if (semanticElement.isDisplayed()) {
                    String tagName = semanticElement.getTagName();
                    if (tagName.equalsIgnoreCase("div") ||tagName.equalsIgnoreCase("span")) {
                        String semanticRole = semanticElement.getAttribute("role");
                        if (semanticRole != null) {
                            if (semanticRole.equalsIgnoreCase("Button") || semanticRole.equalsIgnoreCase("Link") || semanticRole.equalsIgnoreCase("navigation") || semanticRole.equalsIgnoreCase("header") || semanticRole.equalsIgnoreCase("footer")) {
                                Assert.assertEquals("Div and Span contain Semantic role attribute value","Div and Span contain Semantic role attribute value");
                            } else {
                                setError(semanticElement);
                                Assert.fail("Div and Span does not contain Semantic role attribute value");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void semanticRoleCheck(List<WebElement> semanticElements) {

        for (WebElement semanticElement : semanticElements) {

            String tagName = semanticElement.getTagName();
            try {
                String semanticRole;
                switch (tagName) {
                    case "button":
                        semanticRole = semanticElement.getAttribute("role");
                        if (semanticRole.equalsIgnoreCase("button")) {
                            Assert.assertEquals("Semantic Role is Present", "Semantic Role is Present");
                        } else {
                            setError(semanticElement);
                            Assert.fail("Semantic Role is not Present");
                        }
                        break;
                    case "nav":
                        semanticRole = semanticElement.getAttribute("role");
                        if (semanticRole.equalsIgnoreCase("navigation")) {
                            Assert.assertEquals("Semantic Role is Present", "Semantic Role is Present");
                        } else {
                            setError(semanticElement);
                            Assert.fail("Semantic Role is not Present");
                        }
                        break;
                    case "a":
                        semanticRole = semanticElement.getAttribute("role");
                        if (semanticRole.equalsIgnoreCase("link")) {
                            Assert.assertEquals("Semantic Role is Present", "Semantic Role is Present");
                        } else {
                            setError(semanticElement);
                            Assert.fail("Semantic Role is not Present");
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public void imgCheck(List<WebElement> allElements) {
        String altAttribute;
        String ariaLabel;
        for (WebElement imgElement : allElements) {
            try {
                if (imgElement.isDisplayed()) {
                    altAttribute = imgElement.getAttribute("alt");
                    if (altAttribute != null) {
                        if (altAttribute.contains(".jpg") || altAttribute.contains(".png") || altAttribute.contains(".jpeg")) {
                            setError(imgElement);
                        }
                    }
                    ariaLabel = imgElement.getAttribute("aria-label");
                    if (ariaLabel != null) {
                        Assert.fail("Image tag have ariaLabel attribute which is" +
                                " not recommended as per the WCGA guidelines  _");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void verifyHrefTag(List<WebElement> allElements) {
        for (WebElement wElement : allElements) {
            try {
                String hrefValue = wElement.getAttribute("href");
                if (hrefValue == null) {
                    Thread.sleep(3000);
                    setError(wElement);
                    Assert.fail("anchor tag doesn't have href attribute");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void focusCheck(WebElement module) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        WebElement element;
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        String elemText;
        ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("arguments[0].scrollIntoView();$(arguments[0]).find('select:first,button:first,input:first')[0].focus();", module);
        do {
            element = DriverGenerator.getDriver().switchTo().activeElement();
            elemText = element.getText();
            if (!(boolean) ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("return $.contains($('fx-mags-root')[0],arguments[0])", element))
                break;
            checkError(element); // to check for error
            //for radio buttons
            radioCheck(element);
            Thread.sleep(100);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        while (!"cancel".equalsIgnoreCase(elemText) &&
                !"Continue".equalsIgnoreCase(elemText) &&
                !"Make changes".equalsIgnoreCase(elemText)
        );
    }

}





