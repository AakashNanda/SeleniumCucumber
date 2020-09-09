@231185
Feature: 231185 - MVP Ship Address Entry
  This feature will provide logged in customers with easy means of managing address entries in the To/From fields.

  @10.2 @312550 @Dolphins @Desktop @oct09
  Scenario: Verify FROM section verification
    Given User:"Magsregister" logs in to Shipping application
    Then User clicks on start shipping button
    And User clicks on FromEdit summary card button
    Then Verify the from section address fields
    Then Verify Your contacts will appear once you start typing below. instruction message in From section
    Then Verify value displayed as:"US" for element:"AddressEntryObjects.fromfieldCountry"
    When User selects value:"WAL" in FROM Country
    Then Verify value displayed as:"GB" for element:"AddressEntryObjects.fromfieldCountry"
    When User Enters Value:"   " in FROM User Name
    When User Enters Value:"FEDEX" in FROM User Company
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserNameerror" jsonParentTag:"validationErrorSection.contactName" and keyValue:"required"
    When User selects value:"0" in FROM Country
    When User Enters Value:"12" in FROM Address Line 2
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserCountryerror" jsonParentTag:"addressSection" and keyValue:"countryRequired"
    When User Enters Value:" " in FROM User Address
    When User Enters Value:"Fisherville" in FROM User City
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserAddresserror" jsonParentTag:"validationErrorSection.address" and keyValue:"addressRequired"
    When User Enters Value:"10,Avenue Road,JP nagar(50037)" in FROM User Address
    Then Verify Element isNotDisplayed
      | AddressEntryObjects.fromUserAddresserror |
    When User Enters Value:"   " in FROM User Address
    When User Enters Value:"fedex" in FROM User Company
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserAddresserror" jsonParentTag:"validationErrorSection.address" and keyValue:"addressRequired"
    When User selects value:"US" in FROM Country
    When User Enters Value:" " in FROM User Postal
    Then Verify the label name displayed for element:"AddressEntryObjects.fromfieldPostalLabel" jsonParentTag:"addressSection" and keyValue:"zip"
    Then Verify the label name displayed for element:"AddressEntryObjects.userStateLabelfROM" jsonParentTag:"addressSection" and keyValue:"state"
    When User Enters Value:"1547" in FROM User Phone number
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserPostalerror" jsonParentTag:"validationErrorSection.postal" and keyValue:"requiredZIP"
    When User selects value:"IN" in FROM Country
    When User Enters Value:" " in FROM User Postal
    Then Verify the label name displayed for element:"AddressEntryObjects.fromfieldPostalLabel" jsonParentTag:"addressSection" and keyValue:"postal"
    Then Verify the label name displayed for element:"AddressEntryObjects.userStateLabelfROM" jsonParentTag:"addressSection" and keyValue:"state"
    When User Enters Value:"8745" in FROM User Phone number
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserPostalerror" jsonParentTag:"validationErrorSection.postal" and keyValue:"required"
    And User clicks on From cancel button
    And User clicks on FromEdit summary card button
    When User selects value:"CL" in FROM Country
    When User Enters Value:"" in FROM User Phone number
    Then Verify Element isNotDisplayed
      | AddressEntryObjects.fromfieldState |
    Then Verify the label name displayed for element:"AddressEntryObjects.fromfieldPostalLabel" jsonParentTag:"addressSection" and keyValue:"postalOptional"
    And User clicks on From cancel button
    And User clicks on FromEdit summary card button
    When User selects value:"CA" in FROM Country
    When User Enters Value:"" in FROM User Phone number
    Then Verify the label name displayed for element:"AddressEntryObjects.fromfieldPostalLabel" jsonParentTag:"addressSection" and keyValue:"postal"
    Then Verify the label name displayed for element:"AddressEntryObjects.userStateLabelfROM" jsonParentTag:"addressSection" and keyValue:"province"
    And User clicks on From cancel button
    And User clicks on FromEdit summary card button
    When User selects value:"IN" in FROM Country
    When User Enters Value:"5600" in FROM User Postal
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserStateerror" jsonParentTag:"addressSection" and keyValue:"stateRequired"
    When User selects value:"CA" in FROM Country
    When User Enters Value:"M1M" in FROM User Postal
    When User Enters Value:"90123456" in FROM User Phone number
    And User clicks on From update button
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserStateerror" jsonParentTag:"addressSection" and keyValue:"provinceRequired"
    And User clicks on From cancel button
    And User clicks on FromEdit summary card button
    When User selects value:"IN" in FROM Country
    When User Enters Value:"120 10 TEST ADDRESS" in FROM Address Line 2
    When User Enters Value:"560078" in FROM User Postal
    When User Enters Value:"90123456" in FROM User Phone number
    And User clicks on From update button
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserCityerror" jsonParentTag:"addressSection" and keyValue:"cityRequired"
    When User selects value:"AE" in FROM Country
    When User Enters Value:"9875478987" in FROM User Phone number
    And User clicks on From update button
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserCityerror" jsonParentTag:"addressSection" and keyValue:"cityRequired"
    When User selects value:"US" in FROM Country
    When User Enters Value:"120 10 TEST ADDRESS" in FROM Address Line 2
    When User Enters Value:"38017" in FROM User Postal
    When User Enters Value:"9875478987" in FROM User Phone number
    When User Selects Value:"TN" in FROM User State
    And User clicks on From update button
    Then Verify Error Message displayed for element:"AddressEntryObjects.fromUserCityerror" jsonParentTag:"addressSection" and keyValue:"cityRequired"

  @fromSection
  Scenario: Verify FROM section state ans city pre-fill
    Given User:"MAGICJP" logs in to Shipping application
    Then User clicks on start shipping button
    And User clicks on FromEdit summary card button
    When User selects value:"US" in FROM Country
    When User Enters Value:"120 10 TEST ADDRESS" in FROM Address Line 2
    When User Enters Value:"38225" in FROM User Postal custom
    Then Verify value displayed as:"TN" for element:"AddressEntryObjects.fromfieldState"
    Then Verify value displayed as:"DRESDEN" for element:"AddressEntryObjects.fromfieldCity"
    When User selects value:"IN" in FROM Country
    When User Enters Value:"120 10 TEST ADDRESS" in FROM Address Line 2
    When User Enters Value:"110003" in FROM User Postal custom
    Then Verify value displayed as:"DL" for element:"AddressEntryObjects.fromfieldState"
    Then Verify value displayed as:"NEW DELHI" for element:"AddressEntryObjects.fromfieldCity"
    When User selects value:"CA" in FROM Country
    When User Enters Value:"120 10 TEST ADDRESS" in FROM Address Line 2
    When User Enters Value:"A1A1A1" in FROM User Postal custom
    When User Enters Value:"9875478987" in FROM User Phone number
    Then Verify value displayed as:"ST. JOHN'S" for element:"AddressEntryObjects.fromfieldCity"
    When User Enters Value:"M1M1M1" in FROM User Postal custom
    When User Enters Value:"TORONTO" in FROM User City and selects from predictive list
    Then Verify value displayed as:"TORONTO" for element:"AddressEntryObjects.fromfieldCity"
    Then Verify value displayed as:"ON" for element:"AddressEntryObjects.fromfieldState"
    When User selects value:"AR" in FROM Country
    When User Enters Value:"9875478987" in FROM User Phone number
    When User Enters Value:"ab" in FROM User City and selects from predictive list
    Then Verify value displayed as:"ABASTO" for element:"AddressEntryObjects.fromfieldCity"
    When User selects value:"AE" in FROM Country
    When User Enters Value:"9875478987" in FROM User Phone number
    When User Enters Value:"ABU DH" in FROM User City and selects from predictive list
    Then Verify value displayed as:"ABU DHABI" for element:"AddressEntryObjects.fromfieldCity"
