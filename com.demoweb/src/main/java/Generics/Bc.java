package Generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ObjRepo.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Bc {
	public static WebDriver driver;
//preconditions such as launching browser
@BeforeClass
			public void BC() throws Throwable
			{
				 Fu f=new Fu();
				String BROWSER = f.getPropertykeyvalue("Browser");
				if (BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					} 
		
				else if (BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver= new FirefoxDriver();
					
				}
				else {
					driver=new ChromeDriver();
				}
				}
//preconditions such as launching browser based on external source
			@BeforeMethod
				public void BM () throws Throwable 
				{ 
				Fu f=new Fu();
					String url = f.getPropertykeyvalue("URL");
						String UserName = f.getPropertykeyvalue("UN");
						String PassWord = f.getPropertykeyvalue("PW");
						driver.get(url);
						Login l=new Login(driver);
						l.Login(UserName,PassWord);
				}
			//post conditions like logout from apps and close browser
				@AfterMethod
				public void AM()
				{
					System.out.println("Logout the Application");
				}
				@AfterClass
				public void AC()
				{
					driver.quit();
					System.out.println("Close the Browser");
				}
	}
