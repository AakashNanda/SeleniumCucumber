package com.fedex.test.shipping.ResuableJavaFactory;

import com.experitest.selenium.MobileWebDriver;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Class.forName;


@SuppressWarnings("deprecation")
public class Wrappers extends Property {



    /**
     * Method to Enter Value in a field
     *
     * @param element, value
     * @throws InterruptedException
     * @throws IOException
     */

    public static void enterValue(WebElement element, String value) throws InterruptedException, IOException {
        new WebDriverWait(DriverGenerator.getDriver(), 25).until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed()){
            BackSpace(element);
            element.sendKeys(value);
        }
    }


    /**
     * Method to close Keyboard in Mobile
     *
     */

    public static void closeKeyboard() {
        ((MobileWebDriver) DriverGenerator.getDriver()).device().closeKeyboard();
    }


    /**
     * Method to clear data from a field
     *
     * @param element
     */

    public static void BackSpace(WebElement element){
        String i=element.getAttribute("value").toString();
        int length=i.length();
        while(length!=0)
        {
            element.sendKeys(Keys.BACK_SPACE);
            length--;
        }
    }


    /**
     * Method to Click on a Element
     *
     * @param element
     */

    public static void clickOnElement(WebElement element) throws InterruptedException {
        waitForElement(element);
        if (element.isDisplayed()) {
            element.click();
        }
        else {
            Assert.fail();
        }
    }


    /**
     * Method to Re-Click on a Element
     *
     * @param element
     */

    public static void reClickOnElement(WebElement element) throws InterruptedException {
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                Thread.sleep(5000);
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Method to Click on LoginDropDown Element Mobile
     *
     * @param element
     */

    public static void clickOnElementLoginDropDown(WebElement element) {
        element.click();
    }


    /**
     * Method to Click on a Element using javascriptexecutor
     *
     * @param element
     */

    public static void clickOnElementJS(WebElement element) {
        new WebDriverWait(DriverGenerator.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed()) {
            ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("arguments[0].click();", element);
        } else {
            Assert.fail();
        }
    }


    /**
     * Method to Select a value from drop down using Value
     *
     * @param element
     * @throws InterruptedException
     */

    public static void selectValuebyValue(WebElement element, String valueToSelect) throws InterruptedException {
        try {
            waitforSelectValue(element);
            if (element.isDisplayed()) {
                Select select = new Select(element);
                select.selectByValue(valueToSelect);
            } else {
                Assert.fail();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }


    /**
     * Method to Select a value from drop down using Value
     *
     * @param element
     * @throws InterruptedException
     */

    public static void selectbyValueMobile(MobileWebDriver driver, String Method, String element, String valueToSelect){
        WebElement elem = driver.findElement(By.id(element));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(elem));
        driver.client.hybridSelect("", 0, Method, element, valueToSelect);
    }


    /**
     * Method to Select a value from drop down using Index
     *
     * @param element
     * @throws InterruptedException
     */

    public static void selectByIndex(WebElement element, String valueToSelect){

        if (element.isDisplayed()) {
            Select select = new Select(element);
            for (int i = 0; i < select.getOptions().size(); i++) {
                String SelectorValue=select.getOptions().get(i).getText().trim();
                if (valueToSelect.equalsIgnoreCase(SelectorValue)){
                    select.selectByIndex(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }


    /**
     * Method to get value from a field
     *
     * @param element
     */

    public static String getText(WebElement element) {
        String getText = null;
        if (element.isDisplayed() || element.isEnabled()) {
            getText = element.getAttribute("value");
        }
        else
         {
            Assert.fail();
        }
        return getText;
    }


    /**
     * Method to get 1st value from a dropdown field
     *
     * @param element
     */

    public static String getTextInSelectElement(WebElement element) {
        waitForElement(element);
        String text = new Select(element).getFirstSelectedOption().getText();
        return text;
    }


    /**
     * Method to get text from an element
     *
     * @param element
     */

    public static String getInnerText(WebElement element) {
        String getText = null;
        if (element.isDisplayed() || element.isEnabled()) {
            getText = element.getText();
        } else {
            Assert.fail();
        }
        return getText;
    }


    /**
     * Method to get text from an element in Mobile
     *
     * @param element
     */

    public static String getInnerTextMobile(MobileWebDriver driver, String element) {
        String getText = null;
        getText = driver.client.elementGetText("WEB", "id="+element, 0);
        return getText;
    }

    public static Boolean checkStatusCheckBoxMobile(MobileWebDriver driver,String element) {
        return Boolean.valueOf(driver.client.elementGetProperty("WEB", element, 0, "checked"));
    }

    public static String getSelectedValueFrom(MobileWebDriver driver,String element) {
        return driver.client.hybridRunJavascript("", 0, "var result = $('#" + element.replaceAll("id=", "") + "').val();");
    }



    /**
     * Method to compare a value with a given value
     *
     * @param textToCompare
     */

    public static void compareTextValue(String textToCompare, String compareWith) {
        if (textToCompare != null && textToCompare.length() > 0) {
            if (textToCompare.contains(compareWith) || textToCompare.equals(compareWith)
                    || textToCompare.equalsIgnoreCase(compareWith) || textToCompare.matches(compareWith)) {
                Assert.assertEquals("actual value matched with expected","actual value matched with expected");
            } else {
                Assert.fail("Expected value - " + compareWith + " , does not match with Actual value - " + textToCompare);
            }
        } else {
            Assert.fail();
        }
    }

    public static void compareTextValue_CustomValueError(String textToCompare, String compareWith) {
        if (textToCompare != null && textToCompare.length() > 0) {
            if (compareWith.contains(textToCompare) || textToCompare.contains(compareWith) || textToCompare.equals(compareWith)
                    || textToCompare.equalsIgnoreCase(compareWith) || textToCompare.matches(compareWith)) {
                Assert.assertEquals("actual value matched with expected","actual value matched with expected");
            } else {
                Assert.fail("Expected value - " + compareWith + " , does not match with Actual value - " + textToCompare);
            }
        } else {
            Assert.fail();
        }
    }


    /**
     * Method to get Text and compare a textvalue with a given value
     *
     * @param compareWith
     */

    public static void getTextFromAndCompareTextWith(WebElement element, String compareWith) throws InterruptedException {
        Thread.sleep(2000);
        if (element.isDisplayed() || element.isEnabled()) {
            String textToCompare = getText(element).trim();
            compareTextValue(textToCompare, compareWith);
        } else {
            Assert.fail("Element is not available");
        }
    }

    /**
     *Method to comapare the integer type values
     * @param actualValue
     */


    public static void compareValue(int actualValue, int expectedValue) {
        boolean flag=false;
        if (actualValue == expectedValue) {
            flag=true;
            Assert.assertTrue(flag,"Actual value matched with expected value");
        } else {
            Assert.fail();
        }
    }

    /**
     * Method to tabOut
     *
     * @param element
     */

    public static void tabOut(WebElement element){
        element.sendKeys(Keys.TAB);
    }


    /**
     * Method to tabOut
     *
     */

    public static void clickOnTab() {
        try {
            WebElement element = DriverGenerator.getDriver().switchTo().activeElement();
            element.sendKeys(Keys.TAB);

        } catch (Exception e) {
            Assert.fail();
        }
    }


    /**
     * Method to get UI Text and compare a textvalue with a given value
     *
     * @param compareWith
     */

    public static void getTextFromAndCompareTextWithUI(WebElement element, String compareWith) throws InterruptedException {
        Thread.sleep(3000);
        if (element.isDisplayed() || element.isEnabled()) {
            String textToCompare = getInnerText(element).trim();
            compareTextValue(textToCompare, compareWith);
        } else {
            Assert.fail("Element is not available");
        }
    }


    public static void getTextFromAndCompareTextWithUI_CustomsValueError(WebElement element, String compareWith) throws Exception{
        waitForElement(element);
        if (element.isDisplayed() || element.isEnabled()) {
            String textToCompare = getInnerText(element).trim();
            compareTextValue_CustomValueError(textToCompare, compareWith);
        } else {
            Assert.fail("Element is not available");
        }
    }


    /**
     * Method to get UI Text and compare a textvalue with a given value in Mobile
     *
     * @param compareWith
     */

    public static void getTextFromAndCompareTextWithUIMobile(String element, String compareWith) {
        WebElement elem = DriverGenerator.getDriver().findElement(By.id(element));
        if (elem.isDisplayed() || elem.isEnabled()) {
            String textToCompare = getInnerTextMobile((MobileWebDriver)DriverGenerator.getDriver(), element).trim();
            compareTextValue(textToCompare, compareWith);
        } else {
            Assert.fail("Element is not available");
        }
    }


    /**
     * Method to get Text from a Label
     *
     * @param element
     */

    public static String getLabelText(WebElement element) {
        try {
            return ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("return arguments[0].nextElementSibling.innerHTML;", element).toString();
        }catch (JavascriptException js) {
            //   waitForElement(element);
            return element.getText();
        }
    }


    /**
     * Method to get Text from a Label and Compare it with a value
     *
     * @param element
     */

    public static void getLabelTextAndCompare(WebElement element, String compareWith) {
        if (element.isDisplayed()) {
            String textToCompare = getLabelText(element).trim();
            compareTextValue(textToCompare, compareWith);
        } else {
            Assert.fail("Element is not displayed");
        }
    }


    /**
     * Method to scroll to an Element
     *
     * @param element
     */

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript(String.format("window.scroll(0, %s)", element.getLocation().getY() - 300));
    }


    /**
     * Method to scroll to an Element not in View
     *
     * @param element
     */

    public static void scrollToElementNotInView(WebElement element){
        ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * Method to scroll to an Element in Mobile
     *
     * @param pixel
     */

    public static void scrollToElementMobile1(String pixel){
        ((MobileWebDriver)DriverGenerator.getDriver()).device().runJavascript("window.scrollBy(0,"+ pixel +")");
    }


    /**
     * Method to wait for value in dropdown
     *
     * @param element
     */

    public static void waitforSelectValue(WebElement element) throws InterruptedException{
        Select select = new Select(element);
        for(int i=0;i<15;i++)
        {
            if(select.getOptions().size()>1){
                break;
            }else {
                Thread.sleep(1000);
                i++;
            }
        }
    }


    /**
     * Method to wait for an element
     *
     * @param element
     */

    public static void waitForElement(WebElement element){
        new WebDriverWait(DriverGenerator.getDriver(), 60).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverGenerator.getDriver(), 15).until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Method to verify element is displayed
     *
     * @param element
     */

    public static void verifyElementIsDisplayed(WebElement element){
        new WebDriverWait(DriverGenerator.getDriver(), 25).until(ExpectedConditions.visibilityOf(element));
        try{
            Boolean elementDisplayed= element.isDisplayed();
            Assert.assertTrue(elementDisplayed,"Element is not displayed");
        }catch (NoSuchElementException e){
            e.printStackTrace();
            Assert.fail();
        }
    }


    /**
     * Method to get WebElement with the provided classpath
     *
     * @param classPath
     */

    public static WebElement getWebElementByClassPath(String classPath) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
          WebElement element = null;
        classPath = "com.fedex.test.shipping.ObjectsRepository." + classPath;
        int packagePath = classPath.lastIndexOf(".");
        String pageObjectName = classPath.substring(0, packagePath);
        String elementName = classPath.substring(packagePath + 1);
        String elementCopy = elementName;
        Class pageObjectClass = forName(pageObjectName);
        Object obj = pageObjectClass.newInstance();
        Field webElementName;
        if (elementName.contains("[")) {
            elementCopy = elementCopy.replaceAll("\\[\\d]", "");
            webElementName = pageObjectClass.getDeclaredField(elementCopy);
            webElementName.setAccessible(true);
            element = ((List<WebElement>) webElementName.get(null)).get(Integer.valueOf(elementName.replaceAll("[^0-9]", "")));
        } else {
            webElementName = pageObjectClass.getDeclaredField(elementName);
            webElementName.setAccessible(true);
            element = (WebElement) webElementName.get(obj);
        }
        return element;
    }


    /**
     * Method to get select options from drop down
     *
     * @param element
     */

    public static ArrayList<String> getAllAvailableOptionsInSelect(WebElement element) {
        ArrayList<String> options = new ArrayList<String>();
        for (WebElement option : new Select(element).getOptions()) {
            if (!(option.getAttribute("value").equalsIgnoreCase(""))) {
                options.add(option.getAttribute("value"));
            }
        }
        return options;
    }


    /**
     * Method to get WebElement with the provided classpath
     *
     * @param classPath
     */

    public static String getStringElementByClassPath(String classPath) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        classPath = "test.java.shipping.mobilePageObjectsAndSteps.M_" + classPath;
        int packagePath = classPath.lastIndexOf(".");
        String pageObjectName = classPath.substring(0, packagePath);
        String elementName = classPath.substring(packagePath + 1);
        Class classObject = Class.forName(pageObjectName);
        Field fl = classObject.getDeclaredField(elementName);
        return fl.get(classObject).toString();
    }


    /**
     * Method to verify element is displayed and enabled
     *
     * @param element
     */

    public static boolean elementisDisplayedAndEnabled(WebElement element) {
        boolean displayed = false;
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                displayed = true;
            }

        } catch (Exception e) {
            displayed = false;
        }
        return displayed;
    }


    /**
     * Method to get text from an element usin JS
     *
     * @param element
     */

    public static String getTextInUserInputElement(WebElement element) {
        String getText = null;
        if (element.isDisplayed()) {
            getText = ((JavascriptExecutor) DriverGenerator.getDriver()).executeScript("return arguments[0].value", element).toString();
        } else {
            Assert.fail();
        }
        return getText;
    }


    /**
     * Method to check status of CheckBox
     *
     * @param element
     */

    public static boolean checkStatusCheckBox(WebElement element) {
        boolean flag = false;
        if (element.isDisplayed()|| element.isEnabled()) {
            flag = element.isSelected();
        } else {
            Assert.fail();
        }
        return flag;
    }
   public static boolean checkSorting(ArrayList< String > arraylist){
        boolean isSorted=true;
        for(int i=1;i < arraylist.size();i++){
            if(arraylist.get(i-1).compareTo(arraylist.get(i)) > 0){
                isSorted= false;
                break;
            }
        }
        return isSorted;
    }

    public static String getBrowserName() {
        return ((RemoteWebDriver) DriverGenerator.getDriver()).getCapabilities().getBrowserName().toLowerCase();
    }
    
    public void checkBoxSelect(String flag, WebElement element) {
        try {
            waitForElement(element);
            scrollToElement(element);
            if (Boolean.valueOf(flag)) {
                if (!checkStatusCheckBox(element)) {
                    clickOnElementJS(element);
                }
            } else {
                if (checkStatusCheckBox(element)) {
                    clickOnElementJS(element);
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }


    }

    public static boolean isLoggedInStatus(WebElement element) {
        boolean flag = false;
        if (element.isDisplayed()&&!element.getText().contains("Sign Up/Log In")) {
            flag = true;
        } else {
            Assert.fail();
        }
        return flag;
    }
    
    public static String getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "yyyy_MM_dd_HH_mm_ss";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        return formattedDate;

    }


    /************************************JSON PARSER : START*********************************************/

    public static JSONObject getUserAddressDetailsJson(String userReference) throws IOException {
        JSONObject userAddressDetails = Wrappers.getJsonData("userData");
        JSONArray users = userAddressDetails.getJSONArray("userData");
        JSONObject getUserAddressDetails = null;
        if (userReference.length() < 2) {
            userReference = "Markus Wainman";
        }
        for (int i = 0; i < users.length(); ) {
            if (((JSONObject) users.get(i)).get("Name").toString().equalsIgnoreCase(userReference)) {
                getUserAddressDetails = ((JSONObject) users.get(i));
                break;
            } else {
                i++;
            }
        }
        return getUserAddressDetails;
    }


    public static JSONObject getJsonData(String fileName) throws IOException {
        String filepath = (Property.prop.getProperty("jsonData") + fileName + ".json");
        File file = new File(filepath);
        String JSONdata = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(JSONdata);
    }


    public static JSONObject getJsonDatalocale(String fileName) throws IOException {
        String filepath = (Property.prop.getProperty("localeJson") + fileName + ".json");
        File file = new File(filepath);
        String JSONdata = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(JSONdata);
    }


    public static JSONObject getUserCredentials(String userReference) throws IOException{
        return Wrappers.getJsonData("USER_PROFILE").getJSONObject(userReference);
    }

    public static String getShipmentErrorMessages(String errorDesc) throws IOException {
        return Wrappers.getJsonDatalocale("en").getJSONObject("customsSection").getJSONObject("customsDocumentSection").get(errorDesc).toString();
    }

    public static String getPackageSectionComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("packageSection").get(key).toString();
    }

    public static String getPackageSectionDimensionComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("packageSection").getJSONObject("DimensionsValidation").get(key).toString();
    }

    public static String getLiabilityCoverageComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("liabilityCoverage").get(key).toString();
    }

    public static String getPackageSectionWeightData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("packageSection").getJSONObject("weightValidation").get(key).toString();
    }

    public static String getRatingSectionSignatureComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("ratingSection").getJSONObject("signatureSection").get(key).toString();
    }

    public static String getDocSectionData(String key) throws IOException {
        return getJsonDatalocale("en").getJSONObject("customsSection").getJSONObject("customsDocumentSection").getString(key);
    }

    public static String getSummaryDeliveryComponentData(String key) throws IOException {
        return getJsonDatalocale("en").getJSONObject("summarySection").getJSONObject("summaryDeliverySection").get(key).toString();
    }
    public static String getRatingSectionComponentData(String key) throws IOException {
        return getJsonDatalocale("en").getJSONObject("ratingSection").get(key).toString();
    }
    public static String getSummaryComponentData(String key) throws IOException {
        return getJsonDatalocale("en").getJSONObject("summarySection").get(key).toString();
    }

    public static String getConfirmationSectionPrintComponentData(String key) throws IOException {
        return getJsonDatalocale("en").getJSONObject("confirmationSection").getJSONObject("print").get(key).toString();
    }

    public static String getPickupDropOffSectionComponentData(String key) throws IOException{
        return  getJsonDatalocale("en").getJSONObject("pickUpDropOffSection").get(key).toString();
    }

    public static String getConfirmationSectionPickUpDropOffComponentData(String key) throws IOException {
        return  getJsonDatalocale("en").getJSONObject("confirmationSection").getJSONObject("pickupOrDropOff").get(key).toString();
    }

    public static String getConfirmationSectionComponentData(String key)  throws IOException {
        return getJsonDatalocale("en").getJSONObject("confirmationSection").get(key).toString();
    }
    
    public static String getPickupDropOffSectionComponentDataPickup(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("validationErrorSection").getJSONObject("pickUp").get(key).toString();
    }

    public static String getConfirmationSectionTrackingComponentData(String key) throws IOException {
        return getJsonDatalocale("en").getJSONObject("confirmationSection").getJSONObject("tracking").get(key).toString();
    }
    
    public static String getPaymentSummaryComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("summarySection").getJSONObject("summaryBillingSection").get(key).toString();
    }
    
    public static String getSummaryModalComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("summaryModalSection").get(key).toString();
    }
    
    public static String getSummaryModalShipmentDetailsComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("summarySection").getJSONObject("summaryShipDetailsSection").get(key).toString();
    }
    public static String getShippingNavbarDemoComponentData(String key) throws JSONException, IOException {
        return getJsonDatalocale("en").getJSONObject("ShippingNavbarDemo").get(key).toString();
    }

/************************************JSON PARSER : END*********************************************/

}
