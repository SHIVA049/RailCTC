package RailCTC;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RailCTC.PageObjects.LandingPage;
import RailCTC.PageObjects.PNREnquiryPage;
import TestComponents.BaseTest;

public class PNRStatusCheckTest extends BaseTest {
	
	@Test(dataProvider="getData")
	public void PNRStatusCheck(String pnrnum) throws IOException, InterruptedException {
		
		LandingPage lpage = launchApplication();
		PNREnquiryPage pnrpage=lpage.pnrstatuscheck();
		
		//Thread.sleep(2000);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentwindow=it.next();
		System.out.println(parentwindow);
		String childwindow=it.next();
		System.out.println(childwindow);
		driver.switchTo().window(childwindow);
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Welcome to Indian Railway Passenger Reservation Enquiry");
		String actualpageheading=driver.findElement(By.xpath("//h3[@class='text-center bg-primary']")).getText();
		String expectedpageheading="Passenger Current Status Enquiry";
		Assert.assertEquals(actualpageheading, expectedpageheading);
		pnrpage.inputPNRForEnquiry(pnrnum);
		//driver.findElement(By.id("inputPnrNo")).sendKeys(pnrnum);
		//driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		pnrpage.submitPNRForEnquiry();
		
		Thread.sleep(5000);
		/*Set<String> windows=driver.getWindowHandles();
		Iterator<String> it1=windows.iterator();
		String windows1=it1.next();
		System.out.println(windows1);
		String windows2=it1.next();
		System.out.println(windows2);
		driver.switchTo().window(windows1);
		driver.findElement(By.id("submitPnrNo")).click();
		driver.switchTo().window(windows2); */
		//String actualpageheading=driver.findElement(By.xpath("//h3[@class='text-center bg-primary']")).getText();
		//String expectedpageheading="Passenger Current Status Enquiry";
		//Assert.assertEquals(actualpageheading, expectedpageheading);
		//String statusPNR="4922353728";
		String pnrtitle="You Queried For :"+" PNR Number: "+pnrnum;
		System.out.println(pnrtitle);
		//You Queried For : PNR Number: 4922353728
		//String actpnrtitle=driver.findElement(By.cssSelector("#h4")).getText();
		String actpnrtitle=driver.findElement(By.xpath("//h4[contains(@id,'h4')]")).getText();
		System.out.println(actpnrtitle);
		Assert.assertEquals(actpnrtitle, pnrtitle);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"4922353728"}};
	}

}
