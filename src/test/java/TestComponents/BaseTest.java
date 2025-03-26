package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RailCTC.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest  {
     
	    public WebDriver driver;
	    public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RailCTC\\Resources\\GlobalData.Properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		return driver;
	}
	
   //@BeforeMethod(alwaysRun=true)	
   public LandingPage launchApplication() throws IOException {
		
		driver =initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();
		return lp;
		
	}
   
   public String getScreenShot(String testcaseName,WebDriver driver) throws IOException {
	   
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE);
	   File file=new File(System.getProperty("user.dir")+"//reportFiles"+testcaseName+".png");
	   FileUtils.copyFile(source, file);
	   return System.getProperty("user.dir")+"//reportFiles"+testcaseName+".png";
	   
   }
   
   @AfterMethod
   public void tearDown() {
	   //driver.close();
	   driver.quit();
   }
   
   
   
   
   
}
