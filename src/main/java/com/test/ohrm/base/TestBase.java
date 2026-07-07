package com.test.ohrm.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.ohrm.utils.testUtil;

public class TestBase {
	
	
	 public static WebDriver driver;
	 public static Properties prop;
	
	// Constructor
	public TestBase() {
		
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\MiscLearning"
				+ "\\src\\main\\java\\com\\test\\ohrm\\config\\config.properties");
		prop.load(ip);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	
@SuppressWarnings("deprecation")
public static void initBrowser() {
	
	String browserNamer = prop.getProperty("browser");
	if (browserNamer.equals("Chrome")) {
		
		System.setProperty("webdriver.chromedriver","C:\\Program Files\\Chrome_d\\chromedriver-win64\\chomedriver");
		driver = new ChromeDriver();
		
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(testUtil.Implicit_wait, TimeUnit.SECONDS);
		//Launch url
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	
	
}

