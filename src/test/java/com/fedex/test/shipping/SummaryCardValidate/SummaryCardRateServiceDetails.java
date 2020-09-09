
package com.fedex.test.shipping.SummaryCardValidate;

import com.fedex.test.shipping.ObjectsRepository.SummaryCardObjectsRateServiceDetails;
import com.fedex.test.shipping.ObjectsRepository.SummaryPageObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import com.fedex.test.shipping.SummaryCardDataStore.SummaryRateService;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SummaryCardRateServiceDetails extends Wrappers {

    public SummaryCardObjectsRateServiceDetails summaryCardObjectsRateServiceDetails;
    public SummaryPageObjects  summaryPageObjects;

    public SummaryCardRateServiceDetails(SummaryCardObjectsRateServiceDetails summaryCardObjectsRateServiceDetails , SummaryPageObjects summaryPageObjects){
        this.summaryCardObjectsRateServiceDetails=summaryCardObjectsRateServiceDetails;
        this.summaryPageObjects=summaryPageObjects;
    }

	public void validateRateServiceSection() {
        CopyOnWriteArrayList<SummaryRateService> summaryRateServiceActual = new CopyOnWriteArrayList<SummaryRateService>();
        CopyOnWriteArrayList<SummaryRateService> summaryDeliveryExpected = summaryPageObjects.summaryDeliveryExpectedData;
      SummaryRateService summaryRateService = new SummaryRateService();
      try {
          waitForElement(summaryCardObjectsRateServiceDetails.summarydeliveryHeading);
          if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summarydeliveryServiceType)) {
              // Actual Service summary Details when there is No Date and Time is available for selected FedEx service
//              summaryRateService.setArrivesOnDate(getInnerText(summaryCardObjectsRateServiceDetails.summarydeliveryServiceType));
              summaryRateService.setFedexServiceSelected(getInnerText(summaryCardObjectsRateServiceDetails.summaryDeliveryselectedFedExService));
          } else {
              // Actual Service summary Details when Date and Time is available for selected FedEx service
              summaryRateService.setSummaryArrivesOnDateAndTime(getInnerText(summaryCardObjectsRateServiceDetails.summaryDeliveryTimeAndserviceType));
              summaryRateService.setFedexServiceSelected(getInnerText(summaryCardObjectsRateServiceDetails.summaryDeliveryselectedFedExService));
          }
          if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summaryDeliveryAdditionaloptionsLabel)) {
              summaryRateService.setSignatureOptionSelected(getInnerText(summaryCardObjectsRateServiceDetails.summaryDeliveryAdditionaloptions));
          }
          summaryRateServiceActual.add(summaryRateService);
          

          // ####################### Compare Actual with Expected values ###########################
          if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summarydeliveryServiceType)) {
//        	  SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getArrivesOnDate(), summaryDeliveryExpected.get(0).getArrivesOnDate(), "Delivery Date ");
        	  SeleniumReusableMethods.compareExpectedVSActualDesktopServiceType(summaryRateServiceActual.get(0).getFedexServiceSelected(), summaryDeliveryExpected.get(0).getFedexServiceSelected(), "Selected FedEx Service");
          } else {
//        	  SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getSummaryArrivesOnDateAndTime(), summaryDeliveryExpected.get(0).getArrivesOnDate()+ ", " + getSummaryDeliveryComponentData("before") + " " + summaryDeliveryExpected.get(0).getDeliveredByTime(), "Delivery Date and Time");
        	  SeleniumReusableMethods.compareExpectedVSActualDesktopServiceType(summaryRateServiceActual.get(0).getFedexServiceSelected(), summaryDeliveryExpected.get(0).getFedexServiceSelected(), "Selected FedEx Service");
          }
          if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summaryDeliveryAdditionaloptionsLabel)) {
        	  SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getSignatureOptionSelected(), summaryDeliveryExpected.get(0).getSignatureOptionSelected(), "Selected Signature Service");
          }

      } catch (Exception e) {
          e.printStackTrace();
          Assert.fail();
      }
	}

    public  void validateRateServiceSectionMobile() {
        CopyOnWriteArrayList<SummaryRateService> summaryRateServiceActual = new CopyOnWriteArrayList<SummaryRateService>();
        CopyOnWriteArrayList<SummaryRateService> summaryDeliveryExpected = summaryPageObjects.summaryDeliveryExpectedDataMobile;
        SummaryRateService summaryRateService = new SummaryRateService();
        try {
            waitForElement(summaryCardObjectsRateServiceDetails.summarydeliveryHeading);
            if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summarydeliveryServiceType)) {
                // Actual Service summary Details when there is No Date and Time is available for selected FedEx service
                summaryRateService.setArrivesOnDate(getText(summaryCardObjectsRateServiceDetails.summarydeliveryServiceType));
                summaryRateService.setFedexServiceSelected(getText(summaryCardObjectsRateServiceDetails.summaryDeliveryselectedFedExService));
            } else {
                // Actual Service summary Details when Date and Time is available for selected FedEx service
                summaryRateService.setSummaryArrivesOnDateAndTime(getText(summaryCardObjectsRateServiceDetails.summaryDeliveryTimeAndserviceType));
                summaryRateService.setFedexServiceSelected(getText(summaryCardObjectsRateServiceDetails.summaryDeliveryselectedFedExService));
            }
            if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summaryDeliveryAdditionaloptionsLabel)) {
                summaryRateService.setSignatureOptionSelected(getText(summaryCardObjectsRateServiceDetails.summaryDeliveryAdditionaloptionsLabel));
            }
            summaryRateServiceActual.add(summaryRateService);


            // ####################### Compare Actual with Expected values ###########################
            if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summarydeliveryServiceType)) {
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getArrivesOnDate(), summaryDeliveryExpected.get(0).getArrivesOnDate(),  "Delivery Date ");
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getFedexServiceSelected(), summaryDeliveryExpected.get(0).getFedexServiceSelected(), "Selected FedEx Service");
            } else {
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getSummaryArrivesOnDateAndTime(), summaryDeliveryExpected.get(0).getArrivesOnDate() + ", " + getSummaryDeliveryComponentData("before") + " " + summaryDeliveryExpected.get(0).getDeliveredByTime(),  "Delivery Date and Time");
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getFedexServiceSelected(), summaryDeliveryExpected.get(0).getFedexServiceSelected(),"Selected FedEx Service");
            }
            if (elementisDisplayedAndEnabled(summaryCardObjectsRateServiceDetails.summaryDeliveryAdditionaloptionsLabel)) {
                SeleniumReusableMethods.compareExpectedVSActualDesktop(summaryRateServiceActual.get(0).getSignatureOptionSelected(), summaryDeliveryExpected.get(0).getSignatureOptionSelected(),  "Selected Signature Service");
            }

        } catch (Exception e) {
            Assert.fail();
        }
    }
}

