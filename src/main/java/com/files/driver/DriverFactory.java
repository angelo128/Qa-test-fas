package com.files.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class DriverFactory 
{
	private enum browsers 
	{
		CHROME, FIREFOX, EDGE
	}
	
	public static WebDriver LevantaBrowser(WebDriver driver, String browserName, String url) 
	{
		switch(browsers.valueOf(browserName))
		{
			case CHROME:
			{
				System.setProperty("webdriver.chrome.driver", "C:/BrowserDrivers/chromedriver.exe");
				Reporter.log("Abrir Navegador Chrome");
				driver = new ChromeDriver();
				break;
			}
			case FIREFOX:
			{
				System.setProperty("webdriver.gecko.driver", "C:/BrowserDrivers/geckodriver.exe");
				Reporter.log("Abrir Navegador Firefox");
				driver = new FirefoxDriver();
				break;
			}
			case EDGE:
			{
				System.setProperty("webdriver.edge.driver", "C:/BrowserDrivers/chromedriver.exe");
				Reporter.log("Abrir Navegador Edge");
				driver = new EdgeDriver();
				break;
			}
			default:
			{
				Reporter.log("No se selecciono un navegador correcto, se abre Chrome por defecto");
				System.setProperty("webdriver.chrome.driver", "C:/BrowserDrivers/chromedriver.exe");
				Reporter.log("Abrir Navegador Chrome");
				break;
			}
		}
		
		//Maximizar navegador
		driver.manage().window().maximize();
		
		//Navegar hacia la pagina
		driver.get(url);
		
		return driver;
	}
	
	public static void CloseBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
