package RailCTC;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainSearch {
     
	public WebDriver driver;
	@Test
	public void TrainSearch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.cssSelector(".ng-tns-c57-8.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")).sendKeys("SBC");
		
		WebElement originplace=driver.findElement(By.xpath("(//span[text()=' KSR BENGALURU - SBC '])[1]"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3000));
		//wait.until(ExpectedConditions.)
		wait.until(ExpectedConditions.visibilityOf(originplace));
		originplace.click();
		driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("GPB");
		WebElement destPlace=driver.findElement(By.xpath("(//span[text()=' GHATPRABHA - GPB '])[1]"));
		wait.until(ExpectedConditions.visibilityOf(destPlace));
		destPlace.click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ng-tns-c58-54.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ng-star-inserted")).click();
		WebElement monthWeb=driver.findElement(By.xpath("//span[@class='ui-datepicker-month ng-tns-c58-54 ng-star-inserted']"));
		String month=monthWeb.getText();
		while(!(month =="April")) {
			driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-54']")).click();
		}
		
		driver.findElement(By.xpath("//a[text()='9']")).click();
		wait.pollingEvery(Duration.ofSeconds(1000));
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript(null, null)
		//Thread.sleep(2000);
		/*List<WebElement> startplaces=driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		for(WebElement startcity:startplaces) {
			//System.out.println(startcity.getText());
			if(startcity.getText().contains("KSR")) {
				startcity.click();
			}
				
		}
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@class,'c57-9')][2]")).sendKeys("GPB");
		List<WebElement> destplaces=driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		for(WebElement destination:startplaces) {
			//System.out.println(startcity.getText());
			if(destination.getText().contains("GHAT")) {
				destination.click();
			}
				
		} */
		//driver.switchTo().alert().
	}
}
