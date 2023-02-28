package Generics;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	public void onTestFailure(ITestResult result) {
		String data = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(Bc.driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try{
			File des = new File("./com.crm.seleniumframework/screenshot/"+data+".png");
			FileUtils.copyFile(src, des);
		}
		catch (Throwable e){
			e.printStackTrace();
		}
}}
