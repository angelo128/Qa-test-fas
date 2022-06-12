package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;

import pageObjects.WikiHomePage;

public class WikipediaTest {
	WebDriver driver = DriverFactory.LevantaBrowser(this.driver, "CHROME", "https://es.wikipedia.org/wiki/Wikipedia:Portada");
	WikiHomePage homePage = null;
	
	@Test
	public void testWikipedia()
	{
		homePage = new WikiHomePage(driver);
		
		Assert.assertTrue(homePage.textoBienvenida(), "Error no se muestra el texto de bienvenida");
		driver.close();
	}

}
