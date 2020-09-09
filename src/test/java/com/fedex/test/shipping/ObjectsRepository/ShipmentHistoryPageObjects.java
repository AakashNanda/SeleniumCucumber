package com.fedex.test.shipping.ObjectsRepository;

import com.fedex.test.shipping.ResuableJavaFactory.DriverGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ShipmentHistoryPageObjects extends LoadableComponent<ShipmentHistoryPageObjects> {

  public final static String createShipment="menuTitle";
  public final static String shipmentHistoryTitle="//div/div[1]/h1";
  public final static String noOfShipment="//div/dl/dt";
  public final static String zeroShipments="//div/dl/dd";
  public final static String backArrow="//fdx-app-bar/nav/div[1]/button";
  public final static String searchPlaceholder="//input[@placeholder='Search']";
  public final static String searchInput="searchInput";
  public final static String shipmentHistoryDropdown="shipmentHistoryColumns";
  public final static String searchButton="searchButton";
  public final static String kababMenu="//button[@role='menuitem'][@aria-label='appBar.openMenu']";
  public final static String shipmentHistoryLink="//button[@role='menuitem'][@aria-label='Shipment History']";
  public final static String no_of_shipment_count="//div[2]/div[2]/div/div/div[1]/dl/dd";
  public final static String no_Results_Found="noResultFoundMsgAfterSearch";
  public final static String no_Results_Found_Additonal="noResultFoundMsgAfterSearchAdditionalText";
  public final static String reset_Button="//div[2]/div[3]/div/div/button";
  public final static String trackingNumber="trackingNumber";


    @FindBy(id = createShipment)
    public WebElement CreateShipment;

    @FindBy(xpath=kababMenu)
    public WebElement KababMenu;

    @FindBy(xpath=no_of_shipment_count)
    public WebElement No_of_shipment_count;

    @FindBy(xpath = shipmentHistoryLink)
    public WebElement ShipmentHistoryink;

    @FindBy(xpath = shipmentHistoryTitle)
    public WebElement  ShipmentHistoryTitle;

    @FindBy(xpath = noOfShipment)
    public WebElement  NoOfShipment;

   @FindBy(xpath = zeroShipments)
   public WebElement  ZeroShipments;

    @FindBy(xpath = backArrow)
    public WebElement BackArrow;

    @FindBy(xpath= searchPlaceholder)
    public WebElement SearchPlaceHolder;


    @FindBy(id= searchInput)
    public WebElement SearchInput;

    @FindBy(id=searchButton)
    public WebElement SearchButton;

    @FindBy(id=shipmentHistoryDropdown)
    public WebElement ShipmentHistoryDropdown;

    @FindBy(id=no_Results_Found)
    public WebElement No_Results_Found;

    @FindBy(id=no_Results_Found_Additonal)
    public WebElement No_Results_Found_Additonal;

    @FindBy(xpath=reset_Button)
    public WebElement Rest_Button;

    @FindBy(xpath="//div[1]/div/ul/li[1]/div/dl/dd[4]/a")
    public WebElement TrackingNumber_Link;

    @FindBy(id=trackingNumber)
    public WebElement TrackingNumber;

  public ShipmentHistoryPageObjects(){
    PageFactory.initElements(DriverGenerator.getDriver(),this);
  }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }

}
