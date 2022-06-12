package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.files.driver.DriverFactory;

import pageObjects.DespegarAlojamientosPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultsPage;

public class DespegarTest_v2 
{
	WebDriver driver = DriverFactory.LevantaBrowser(this.driver, "CHROME", "https://www.despegar.com.ar/");
	DespegarHomePage homePage = null;
	DespegarAlojamientosPage paginaAlojamientos = null;
	DespegarResultsPage paginaResultados = null;
	
	@Test
	public void testDespegar() throws Exception
	{
		homePage = new DespegarHomePage(driver);
		homePage.cambiarPaginaAlojamientos();	
		
		paginaAlojamientos = homePage.cambiarPaginaAlojamientos();		
		paginaAlojamientos.clicDestino();
		paginaAlojamientos.enviarTextoDestino("Cordoba");
		paginaAlojamientos.ingresarFechas();
		paginaAlojamientos.clicHabitaciones();
		paginaAlojamientos.agregarAdulto();
		paginaAlojamientos.agregarMenor();
		paginaAlojamientos.aplicarOpcionesHabitaciones();
		
		paginaResultados = paginaAlojamientos.buscarAlojamientos();		
		Assert.assertTrue(paginaResultados.estaElPrimerResultado(), "No se encontraron resultados");	
		
		driver.close();
	}
}
