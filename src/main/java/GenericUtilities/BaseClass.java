package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of Basic configuration annotations of TestNG
 * @author Chaitra M
 *
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
	   System.out.println("----- Database Connection successfull -----");
	}
    
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		// Step 2: Launch the browser - runtime polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----- "+BROWSER+" Launched succesfully-----");
			
		} else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("----- "+BROWSER+" Launched successfully-----");
			
		} else 
		{
			System.out.println("Invalid Browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);
		
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("----- Browser Closed successfully -----");
	}

	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("----- Database Connection successfull -----");
		
	}
}


