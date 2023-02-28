package ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	//Initialization the pom class objects
	public Home(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

//Declaration the webelement
@FindBy(xpath="//ul[@class='sublist firstLevel active']/descendant::a[@href='/desktops']")
private WebElement desktop;
@FindBy(xpath="//input[@value='Add to cart']")
private WebElement cart;

//Getters to get the data or perform
public WebElement getDesktop() {
	return desktop;
}
public WebElement getCart() {
	return cart;
}
//business login for actions
public void home(WebDriver driver) {
	desktop.click();
	cart.click();
}
}
