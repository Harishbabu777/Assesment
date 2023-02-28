package ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	    //Initialization the pom class objects
		public Login(WebDriver driver)
			{		
				PageFactory.initElements(driver, this);
			}

		//Declaration the webelement
		@FindBy(xpath="//a[@class='ico-login']")
		private  WebElement lgnlink;
		@FindBy(xpath="//input[@id='Email']")
		private  WebElement EmailTextfield;
		@FindBy(xpath="//input[@class='password']")
		private WebElement PasswordTextfield;
		@FindBy(xpath="//input[@value='Log in']")
		private WebElement loginbtn;


		//Getters to get the data or perform
		public WebElement getLgnlink() {
			return lgnlink;
		}
		public WebElement getUsernameTextfield() {
			return EmailTextfield;
		}
		
		public WebElement getPasswordTextfield() {
			return PasswordTextfield;
		}
		public WebElement getSubmitbtn() {
			return loginbtn;
		}
		/**
		 * this method is used to login
		 * @param username
		 * @param password
		 */
		//Utilization
		public void Login(String username,String password)
		{
			lgnlink.click();
			EmailTextfield.sendKeys(username);
			PasswordTextfield.sendKeys(password);
			loginbtn.click();
		}
}
