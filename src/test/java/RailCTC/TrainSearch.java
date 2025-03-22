package RailCTC;

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
import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainSearch {
     
	public WebDriver driver;
	@Test(dataProvider="getData")
	public void TrainSearch(String OPl,String DesPl,String OflName,String desflName,String mnth,String dte) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		LandingPage lpage=new LandingPage(driver);
		lpage.updatefromPlace(OPl,OflName);
		//driver.findElement(By.cssSelector(".ng-tns-c57-8.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")).sendKeys(OPl);
		
		//WebElement originplace=driver.findElement(By.xpath("(//span[text()=' "+OflName+" '])[1]"));
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3000));
		
		//wait.until(ExpectedConditions.visibilityOf(originplace)).click();
		
		//driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys(DesPl);
		lpage.updateToPlace(DesPl,desflName);
		//WebElement destPlace=driver.findElement(By.xpath("(//span[text()=' "+desflName+" '])[1]"));
		//wait.until(ExpectedConditions.visibilityOf(destPlace)).click();
		
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		
		WebElement monthWeb=driver.findElement(By.cssSelector(".ui-datepicker-month.ng-tns-c58-10.ng-star-inserted"));
		String month=monthWeb.getText();
		String year=driver.findElement(By.xpath("//span[text()='2025']")).getText();
		
		while(!month.equalsIgnoreCase(mnth)) {
			driver.findElement(By.cssSelector(".ui-datepicker-next-icon.pi.pi-chevron-right.ng-tns-c58-10")).click();
			month=driver.findElement(By.cssSelector(".ui-datepicker-month.ng-tns-c58-10.ng-star-inserted")).getText();
			//month=monthWeb.getText();
		} 
		
		driver.findElement(By.xpath("//a[text()='"+dte+"']")).click();
		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[1]")).click();
		
		List<WebElement> travelclass=driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c65-11 ng-star-inserted']"));
		
		Iterator<WebElement> it=travelclass.iterator();
		
		
		for(WebElement selectclass:travelclass) {
			
			if(selectclass.getText().contains("Sleeper (SL)")) {
				selectclass.click();
			}
			
		}
		
		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[2]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='LOWER BERTH/SR.CITIZEN']")).click();
		
		driver.findElement(By.cssSelector(".ui-button-text.ui-clickable")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		driver.findElement(By.xpath("(//button[@class='search_btn train_Search'])[1]")).click();
		String text=driver.findElement(By.xpath("(//span[contains(text(),' Results for')])[1]")).getText();
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"SBC","GPB","KSR BENGALURU - SBC","GHATPRABHA - GPB","April","9"},{"SBC","BGM","KSR BENGALURU - SBC","BELAGAVI - BGM","May","10"}};
		
	}
}


