package com.demoweb.com.demoweb;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generics.Bc;
import Generics.Wbu;
import ObjRepo.Home;
import ObjRepo.Login;
import ObjRepo.Shipping;

public class Main extends Bc{
@Test
public void script() throws Throwable {
Wbu w=new Wbu();
w.getImplicitwait(driver);
w.maximize(driver);
Login l=new Login(driver);
//validation for Userid
String exp="planittest78@gmail.com";
String act = driver.findElement(By.xpath("//a[text()='planittest78@gmail.com']")).getText();
Assert.assertEquals(act, exp);
//Clearing the items in cart
driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
driver.findElement(By.xpath("//input[@class='button-2 update-cart-button']")).click();
Thread.sleep(3000);
//Performing mouseover on computers tab on top
WebElement comp = driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href='/computers']"));
w.mouseOverOnElement(driver, comp);
Home h=new Home(driver);
h.home(driver);
WebElement ele2 = driver.findElement(By.xpath("//input[@id='addtocart_72_EnteredQuantity']"));
ele2.click();
ele2.clear();
ele2.sendKeys("2");
//Getting price details
WebElement a1 = driver.findElement(By.xpath("//span[@class='price-value-72']"));
String acc = a1.getText();
System.out.println(acc);
driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
//Validation for product added to the cart
String exp3="shopping cart";
WebElement ele3 = driver.findElement(By.xpath("//a[@href='/cart']"));
String act3 = ele3.getText();
System.out.println(act3);
Assert.assertNotEquals(act3, exp3);
//validation of product subtotal
driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
String expprice="1630.00";
WebElement ele4 = driver.findElement(By.xpath("//table[@class='cart-total']/descendant::span[text()='1630.00']"));
String actprice = ele4.getText();
Assert.assertEquals(actprice, expprice);
//Confirmation of booking
driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
driver.findElement(By.xpath("//button[@id='checkout']")).click();
//Address providing and proceeding further process
List<WebElement> cont = driver.findElements(By.xpath("//input[@title='Continue']"));
for (WebElement x : cont) {
	x.click();
}
Shipping s=new Shipping(driver);
s.ship(driver);
//Cash on delivery msg validation
String cod="You will pay by COD";
 WebElement ele6 = driver.findElement(By.xpath("//p[text()='You will pay by COD']"));
String actcod = ele6.getText();
Assert.assertEquals(actcod, cod);
driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();
driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")).click();
//Validation for Order confirmation msg
String expordermsg ="Your order has been successfully processed!";
String actordmsg = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText();
Assert.assertEquals(actordmsg, expordermsg);
//displaying orderid
String Oid = driver.findElement(By.xpath("//div[@class='section order-completed']/descendant::li[contains(text(),'number')]")).getText();
System.out.println(Oid);
driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']")).click();
driver.findElement(By.xpath("//a[text()='Log out']")).click();
}
}