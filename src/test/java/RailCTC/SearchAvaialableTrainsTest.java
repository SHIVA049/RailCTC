package RailCTC;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RailCTC.PageObjects.LandingPage;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAvaialableTrainsTest extends BaseTest{
     
	public WebDriver driver;
	//@Test
	@Test(dataProvider="getData")
	//public void TrainSearch(String OPl,String DesPl,String OflName,String desflName,String mnth,String dte) throws InterruptedException, IOException {
	public void TrainSearch(String OPl,String OflName,String DesPl,String desflName,String mnth,String Dte,String trClass,String quota) throws InterruptedException, IOException {	
		
		LandingPage lpage = launchApplication();
		lpage.updatefromPlace(OPl,OflName);
		lpage.updateToPlace(DesPl, desflName);
		lpage.selectDate();
		String month=lpage.getTicketBookingMonth().getText();
		while(!month.equalsIgnoreCase(mnth)) {
			//driver.findElement(By.cssSelector(".ui-datepicker-next-icon.pi.pi-chevron-right.ng-tns-c58-10")).click();
			lpage.nextIconDateSelector();
			//month=driver.findElement(By.cssSelector(".ui-datepicker-month.ng-tns-c58-10.ng-star-inserted")).getText();
			month=lpage.getTicketBookingMonth().getText();
		}
		lpage.selecttravelDate(Dte).click();
		lpage.travelClassDropDownClick();
		lpage.travelClassSelection(trClass);
		lpage.journeyQuotaSelection();
		lpage.journeyQuotaSelection1(quota).click();
		lpage.confirmation();
		lpage.clickSearchButton();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"SBC","KSR BENGALURU - SBC","GPB","GHATPRABHA - GPB","May","10","Sleeper (SL)","LOWER BERTH/SR.CITIZEN"}};
		
	} 
}


