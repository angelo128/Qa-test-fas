package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;

import pageObjects.WikiHomePage;

public class WikipediaTest {
	WebDriver driver = null;
	WikiHomePage homePage = null;
	
	@BeforeMethod(alwaysRun=true)
	public void inicioTest(ITestContext context) 
	{
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = DriverFactory.LevantaBrowser(this.driver, navegador, "https://www.despegar.com.ar/");
	}	
	
	@Test(groups = {"grupo_1"})
	public void testWikipedia()
	{
		homePage = new WikiHomePage(driver);
		
		Assert.assertTrue(homePage.textoBienvenida(), "Error no se muestra el texto de bienvenida");
		driver.close();
	}
	
	@AfterMethod(alwaysRun=true)
	public void finTest() 
	{
		driver.close();
	}

}
