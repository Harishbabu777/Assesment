package Generics;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wbu {


		/**
		 * wait for page to load before identifying any synchronized in dom
		 * @author Harish
		 *
		 */	
			public void getImplicitwait(WebDriver driver) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			/**
			 * this method is  for explicit wait 
			 * @param driver(maximising screen)
			 */

			
			public void getExplicitwait(WebDriver driver) {
				
				

				WebDriverWait wait= new WebDriverWait(driver, 20);
				
			}
			
			/**
			 * after every action it will wait for next action to perform 
			 * @param driver
			 */
			
			
			public void scriptTimeout(WebDriver driver) {
				driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			}
			/**
			 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds
			 * @param driver
			 * @param element
			 * @param pollingtime
			 */
			
			
			
			public void waitForelementWithCustotimeout(WebDriver driver, WebElement element,int pollingtime) {
				FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
				wait.pollingEvery(Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			/**
			 * used to switch to window based on window title
			 * @param driver
			 * @param Partialwindowtitle
			 */
			
			
			public void switchToWindow(WebDriver driver, String Partialwindowtitle) {
				Set<String> allid = driver.getWindowHandles();
				Iterator<String> it = allid.iterator();
				while(it.hasNext()) {
					String wid=it.next();
					driver.switchTo().window(wid);
					if(driver.getTitle().contains(Partialwindowtitle)) {

						break;
					}
				}}
			/**
			 * used to switch to alert window and accept(click on ok button)
			 * @param driver
			 */
			
			
			public void switchToalertandaccept(WebDriver driver) {
				driver.switchTo().alert().accept();
			}
			/**
			 * used to switch to alert window and dismiss 
			 * @param driver
			 */
			
			
			public void switchToalertanddismiss(WebDriver driver) {
				driver.switchTo().alert().dismiss();
			}
			
			/**
			 * used to switch to frame based on index  
			 * @param driver
			 * @param index
			 */
			
			
			public void switchToframe(WebDriver driver, int index) {
				driver.switchTo().frame(index);
			}
			
			/**
			 * used to switch to frame window based on id or name attribute
			 * @param driver
			 * @param id_name_attribute
			 * @author Mr
			 */
			
			
			public void switchToframe(WebDriver driver,String id_name_attribute) {
				driver.switchTo().frame(id_name_attribute);
			
			}
			/**
			 * used to select the value from the Dropdown based on index 
			 * 
			 * 
			 */
		    
			
			public void Select(WebElement element, int index) {
		        	 Select sel =new Select(element);
		        	 sel.selectByIndex(index);
		        	 
		        	        }
		         /**
		          * used to select based on visible text
		          * @param element
		          * @param text
		          */
		    
			
			public void Select(WebElement element,String text) {
		        	 Select sel =new Select(element);
		        	 sel.selectByVisibleText(text);
		        			 
		         }
		         /**
		          * used to place mouse cursor on specified element
		          * @param driver
		          * @param element
		          */
		         
		    
			public void mouseOverOnElement(WebDriver driver, WebElement element) {
		        	 Actions act = new Actions(driver);
		        	 act.moveToElement(element).perform();
		         }
		         /**
		          * used to right click on specific element
		          * @param driver
		          * @param element
		          */
		    
			
			public void rightClickOnElement(WebDriver driver, WebElement element) {
		        	 Actions act= new Actions(driver);
		        	 act.contextClick(element).perform();
		         }
		         /**
		          * used to move by offSET
		          * @param driver
		          * @param x
		          * @param y
		          */
		    
			
			public void moveByOffset(WebDriver driver ,int x,int y) {
		        	 Actions act=new Actions(driver);
		        	 act.moveByOffset(x, y).click().perform();
		         }
			
			/**
			 * maximize the browser window
			 * @author Harish
			 *
			 */	
				public void maximize(WebDriver driver) {
					driver.manage().window().maximize();
				}
		         
		}

