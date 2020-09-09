package com.fedex.test.shipping.cucumberSteps;

import com.fedex.test.shipping.ObjectsRepository.AddressEntryObjects;
import com.fedex.test.shipping.ResuableJavaFactory.SeleniumReusableMethods;
import com.fedex.test.shipping.ResuableJavaFactory.SharedDriverManager;
import cucumber.api.java.en.Then;

import java.awt.*;

public class ADAAutomation_WCAG extends SeleniumReusableMethods {

    public AddressEntryObjects addressEntryObjects;

    public ADAAutomation_WCAG(SharedDriverManager driver, AddressEntryObjects addressEntryObjects){
        this.addressEntryObjects= addressEntryObjects;
    }


    @Then("Validate To section tooltip are accessible with enter Key")
    public void toTooltipWithEnterKey() throws InterruptedException {
        tooltipEnterCheck(addressEntryObjects.toSectionToolTip);
    }

    @Then("Validate Semantic elements contains Tabindex in To Section")
    public void tabindexInTo() {
        tabindexCheck(addressEntryObjects.toElements);
    }

    @Then("Validate Div and Span tag contain Semantic role attribute value in To Section")
    public void divRoleCheckInTo() {
        attributeRoleCheck(addressEntryObjects.toElements);
    }

    @Then("Validate Semantic tags contains Semantic Role in To Section")
    public void semanticRoleCheckInTo() {
        semanticRoleCheck(addressEntryObjects.toElements);
    }

    @Then("Validate Image with Aria-Label and Alt attribute with file extension in To section")
    public void imgAltAttributeInTo() {
        imgCheck(addressEntryObjects.toSectionImage);
    }

    @Then("Validate a tag has missing href attribute in To section")
    public void aHrefCheckInTo() {
        verifyHrefTag(addressEntryObjects.toHref);
    }

    @Then("Validate elements contain visible focus in To section")
    public void focusCheckInToSection() throws InterruptedException, AWTException {
        focusCheck(addressEntryObjects.toModuleFocus);
    }
}
