package ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping {
	//Initialization the pom class objects
		public Shipping(WebDriver driver)
		{		
			PageFactory.initElements(driver, this);
		}

	//Declaration the webelement
	@FindBy(xpath="//label[text()='Next Day Air (0.00)']")
	private  WebElement Nxtbtn;
	@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
	private WebElement btn3;
	@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
	private WebElement btn4;

	
	//Getters to get the data or perform
	public WebElement getNxtbtn() {
		return Nxtbtn;
	}
	public WebElement getBtn3() {
		return btn3;
	}
	
	public WebElement getBtn5() {
		return btn4;
	}
	
//Business logic
	public void ship(WebDriver driver) {
		Nxtbtn.click();
		btn3.click();
		btn4.click();	
	}
}
