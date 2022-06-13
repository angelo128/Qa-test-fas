package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;

import pageObjects.DespegarHomePage;

public class DespegarListaProductosTest 
{
	WebDriver driver = null;
	DespegarHomePage homePage = null;
	
	@BeforeMethod
	public void inicioTest(ITestContext context) 
	{
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = DriverFactory.LevantaBrowser(this.driver, navegador, "https://www.despegar.com.ar/");
	}
	
	@Test
	public void testListaProductos() throws Exception
	{
		homePage = new DespegarHomePage(driver);
		homePage.recorrerListaProductos();
	}
}
