package com.azure.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase{
	
	public static WebDriver driver;
	public static Properties props;

	
	public TestBase() {
		props = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"C:/Users/THALA/eclipse-workspace/AzureWebsites/src/main/java/com/azure/qa/config/config.properties");
			props.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		// To get the name of browser
		System.out.println("Browser User = " + props.getProperty("browser") + "| URL = " + props.getProperty("url"));

		System.setProperty("webdriver.chrome.driver", "D:/Selenium Automation/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(props.getProperty("url"));
	}
	
	public static void implicitBreaks(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static WebDriverWait expilictWait() {
		WebDriverWait wait=new WebDriverWait(driver, 50);
		return wait;
	}
}