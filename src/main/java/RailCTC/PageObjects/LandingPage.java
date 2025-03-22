package RailCTC.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RailCTC.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	  static WebDriver driver;
	  
	  public LandingPage(WebDriver driver) {
		  
		  super(driver);
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	  
	  @FindBy(css=".ng-tns-c57-8.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")
      WebElement startPlace;
	  
	 // @FindBy(xpath="(//span[text()=' "+OflName+" '])[1]")
	  //WebElement originPlace;
	  
	  //WebElement originplace=driver.findElement(By.xpath("(//span[text()=' "+OflName+" '])[1]"));
	  
	  @FindBy(xpath="(//input[@aria-autocomplete='list'])[2]")
	  WebElement destPlace;
	  
	  @FindBy(xpath="(//input[@type='text'])[3]")
	  WebElement clickatDatePlace;
	  
	  @FindBy(css=".ui-datepicker-month.ng-tns-c58-10.ng-star-inserted")
	  private WebElement ticketBookingMonth;
	  
	  public WebElement getTicketBookingMonth() {
		return ticketBookingMonth;
	}

	public void setTicketBookingMonth(WebElement ticketBookingMonth) {
		this.ticketBookingMonth = ticketBookingMonth;
	}

	@FindBy(xpath="//span[text()='2025']")
	  WebElement ticketBookingYear;
	  
	  @FindBy(css=".ui-datepicker-next-icon.pi.pi-chevron-right.ng-tns-c58-10")
	  WebElement nextIcon;
	  
	  @FindBy(xpath="//a[text()='10']")
	  WebElement travelDate;
	  
	  @FindBy(xpath="//p-dropdownitem[@class='ng-tns-c65-11 ng-star-inserted']")
	  List<WebElement> travelClass;
	  
	  @FindBy(xpath="(//div[@aria-haspopup='listbox'])[2]")
	  WebElement journeyQuotaDropDown;
	  
	  @FindBy(xpath="(//div[@aria-haspopup='listbox'])[1]")
	  WebElement classSelectionDropDown;
	  
	  @FindBy(xpath="//span[normalize-space()='LOWER BERTH/SR.CITIZEN']")
	  WebElement journeyQuota;
	  
	  @FindBy(css=".ui-button-text.ui-clickable")
	  WebElement confirmationOK;
	  
	  @FindBy(xpath="(//button[@class='search_btn train_Search'])[1]")
	  WebElement searchButton;
	  
	  
	  
	  public WebElement getOriginPlace(String OflName) {
	        return driver.findElement(By.xpath("(//span[text()=' " + OflName + " '])[1]"));
	    }
	  
	  public WebElement getDestinPlace(String desflName) {
	        return driver.findElement(By.xpath("(//span[text()=' "+desflName+" '])[1]"));
	  }
	  
	  public WebElement selecttravelDate(String dte) {
		  
		  return driver.findElement(By.xpath("//a[text()='"+dte+"']"));
	  }
	  
	  public WebElement journeyQuotaSelection1(String quota) {
		  
		  return driver.findElement(By.xpath("//span[normalize-space()='"+quota+"']"));
	  }
	  
	  public LandingPage updatefromPlace(String Opl,String OflName) {
		  startPlace.sendKeys(Opl);
		  waitForWebElementToAppear(getOriginPlace(OflName));
		  getOriginPlace(OflName).click();
		  LandingPage lp=new LandingPage(driver);
		  return lp;
	  }
	  
	  public void updateToPlace(String DesPl,String desflName) {
		  destPlace.sendKeys(DesPl);
		  waitForWebElementToAppear(getDestinPlace(desflName));
		  getDestinPlace(desflName).click();
		  
	  }
	  
	  public void selectDate() {
		  clickatDatePlace.click();
		  
	  }
	  
	  public void nextIconDateSelector() {
		  nextIcon.click();
	  }
	  
	  public void travelClassDropDownClick() {
		  classSelectionDropDown.click();
	  }
	  
	  public void travelClassSelection(String trClass) {
		  for(WebElement selectclass:travelClass) {
				
				if(selectclass.getText().contains(trClass)) {
					selectclass.click();
				}
				
			}
	  }
	  
	  public void journeyQuotaSelection() {
		  journeyQuotaDropDown.click();
		  //journeyQuotaSelection1(quota);
	  }
	  
	  public void confirmation() {
		  confirmationOK.click();
	  }
	  public void clickSearchButton() {
		  searchButton.click();
	  }

	public void goTo() {
		// TODO Auto-generated method stub
		driver.get("https://www.irctc.co.in/nget/train-search");
	}
	  
}
