package RailCTC.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RailCTC.AbstractComponents.AbstractComponents;

public class PNREnquiryPage extends AbstractComponents {
	
	  static WebDriver driver;
	  
	  public PNREnquiryPage(WebDriver driver) {
		  
		  super(driver);
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	  
	  @FindBy(id="inputPnrNo")
      WebElement inputPNR;
	  
	  @FindBy(xpath="(//input[@value='Submit'])[3]")
	  WebElement pnrenqsubmit;
	  
	 
	  public void inputPNRForEnquiry(String pnrnum) {
		  inputPNR.sendKeys(pnrnum);
	  }
	  
	  public void submitPNRForEnquiry() {
		  pnrenqsubmit.click();
	  }
	  
}
