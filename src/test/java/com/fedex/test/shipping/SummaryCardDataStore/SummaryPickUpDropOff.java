package com.fedex.test.shipping.SummaryCardDataStore;

import com.fedex.test.shipping.ObjectsRepository.*;
import com.fedex.test.shipping.ResuableJavaFactory.Wrappers;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SummaryPickUpDropOff extends Wrappers  {
	private String pickUpDropOffSelected;
    private String pickupDateTime;
    private String pickupInstruction;
    private String dropOffLocation;
    private String specialInstruction;
    private String pickUpReadyTimeSelection;
    private String pickUpLatestTimeAvailableSelection;
    private String pickUpInstrSelect;
    private String pickUpInstrInput;

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(String pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public String getPickupInstruction() {
        return pickupInstruction;
    }

    public void setPickupInstruction(String pickupInstruction) {
        this.pickupInstruction = pickupInstruction;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public String getPickUpReadyTimeSelection() {
        return pickUpReadyTimeSelection;
    }

    public void setPickUpReadyTimeSelection(String pickUpReadyTimeSelection) {
        this.pickUpReadyTimeSelection = pickUpReadyTimeSelection;
    }

    public String getPickUpLatestTimeAvailableSelection() {
        return pickUpLatestTimeAvailableSelection;
    }

    public void setPickUpLatestTimeAvailableSelection(String pickUpLatestTimeAvailableSelection) {
        this.pickUpLatestTimeAvailableSelection = pickUpLatestTimeAvailableSelection;
    }

    public String getPickUpInstrSelect() {
        return pickUpInstrSelect;
    }

    public void setPickUpInstrSelect(String pickUpInstrSelect) {
        this.pickUpInstrSelect = pickUpInstrSelect;
    }

    public String getPickUpInstrInput() {
        return pickUpInstrInput;
    }

    public void setPickUpInstrInput(String pickUpLatestTimeAvailableSelection) {
        this.pickUpInstrInput = pickUpInstrInput;
    }

    public String getPickUpDropOffSelected() {
        return pickUpDropOffSelected;
    }

    public void setPickUpDropOffSelected(String pickUpDropOffSelected) {
        this.pickUpDropOffSelected = pickUpDropOffSelected;
    }

    @Override
    public String toString() {
        return "SummaryPickUpDropOff{" +
                "pickupDateTime='" + pickupDateTime + '\'' +
                ", pickupInstruction='" + pickupInstruction + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", specialInstruction='" + specialInstruction + '\'' +
                ", pickUpReadyTimeSelection='" + pickUpReadyTimeSelection + '\'' +
                ", pickUpLatestTimeAvailableSelection='" + pickUpLatestTimeAvailableSelection + '\'' +
                ", pickUpInstrSelect='" + pickUpInstrSelect + '\'' +
                ", pickUpLatestTimeAvailableSelection='" + pickUpLatestTimeAvailableSelection + '\'' +
                ", pickUpInstrInput='" + pickUpInstrInput + '\'' +
                ",pickUpDropOffSelected='" + pickUpDropOffSelected + '\'' +
                '}';
    }

    PickUpAndDropOffObjects PickUpAndDropOffObjects=new PickUpAndDropOffObjects();
    public  CopyOnWriteArrayList<SummaryPickUpDropOff> storeDesktopPickupDropOff() {
        CopyOnWriteArrayList<SummaryPickUpDropOff> SummaryPickUpDropOff = new CopyOnWriteArrayList<SummaryPickUpDropOff>();
        try {
            if (PickUpAndDropOffObjects.pickUpDropOffheading.isDisplayed()) {
                SummaryPickUpDropOff summaryPickUpDropOff = new SummaryPickUpDropOff();
                if (elementisDisplayedAndEnabled(PickUpAndDropOffObjects.pickUpDropOffSelection)
                		&&elementisDisplayedAndEnabled(PickUpAndDropOffObjects.pickUpReadyTimeselection)&&
                		!elementisDisplayedAndEnabled(PickUpAndDropOffObjects.pickUpDropOffSelection)){
                    summaryPickUpDropOff.setPickUpDropOffSelected(getTextInUserInputElement(PickUpAndDropOffObjects.pickUpDropOffSelection));
                    summaryPickUpDropOff.setPickUpReadyTimeSelection(getTextInUserInputElement(PickUpAndDropOffObjects.pickUpReadyTimeselection));
                    summaryPickUpDropOff.setPickUpLatestTimeAvailableSelection(getTextInUserInputElement(PickUpAndDropOffObjects.pickUpLatestTimeAvailableselection));
                } else if (elementisDisplayedAndEnabled(PickUpAndDropOffObjects.pickUpDropOffSelection)&&!elementisDisplayedAndEnabled(PickUpAndDropOffObjects.pickUpReadyTimeselection)&& elementisDisplayedAndEnabled(PickUpAndDropOffObjects.dropOffPreselection)){
                    summaryPickUpDropOff.setPickUpDropOffSelected(getTextInSelectElement(PickUpAndDropOffObjects.pickUpDropOffSelection));
                } else if (elementisDisplayedAndEnabled(PickUpAndDropOffObjects.dropOffPreselection)&&!elementisDisplayedAndEnabled(PickUpAndDropOffObjects.pickUpReadyTimeselection)){
                    summaryPickUpDropOff.setPickUpDropOffSelected(getInnerText(PickUpAndDropOffObjects.dropOffPreselection).split("\n")[2]);
                }
                SummaryPickUpDropOff.add(summaryPickUpDropOff);
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
        return SummaryPickUpDropOff;
    }

}
