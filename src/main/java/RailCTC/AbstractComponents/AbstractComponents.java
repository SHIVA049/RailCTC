package RailCTC.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	 public void waitForElementToAppear(By findBy) {
			
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
	    
	 public void waitForWebElementToAppear(WebElement findBy) {
			
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
			
			wait.until(ExpectedConditions.visibilityOf(findBy));
		}

}
