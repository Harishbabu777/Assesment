package Generics;

import java.io.FileInputStream;
import java.util.Properties;
// Property file contains browsername, URL,UN and PW
public class Fu {
	public String getPropertykeyvalue(String key) throws Throwable{
		{
			FileInputStream fis = new FileInputStream("./demowebshop.txt");
			Properties pro = new Properties();
			pro.load(fis);
			String value = pro.getProperty(key);
			return value;
			}
	}
}
