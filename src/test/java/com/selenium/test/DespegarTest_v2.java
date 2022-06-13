package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.files.driver.DriverFactory;

import pageObjects.DespegarAlojamientosPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultsPage;

public class DespegarTest_v2 
{
	WebDriver driver = null;
	DespegarHomePage homePage = null;
	DespegarAlojamientosPage paginaAlojamientos = null;
	DespegarResultsPage paginaResultados = null;	
	
	@BeforeMethod
	public void inicioTest(ITestContext context) 
	{
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = DriverFactory.LevantaBrowser(this.driver, navegador, "https://www.despegar.com.ar/");
	}		
	
	@DataProvider(name = "Data Provider Despegar")
	public Object[][] dataProviderMethod()
	{
		return new Object[][] {{"Cordoba"}, {"Buenos Aires"}, {"Carlos Paz"}};
	}
	
	@Test(dataProvider = "Data Provider Despegar", description = "Validar alojamientos segun destino")
	public void testDespegar(String textoDestino) throws Exception
	{
		homePage = new DespegarHomePage(driver);
		homePage.cambiarPaginaAlojamientos();	
		
		paginaAlojamientos = homePage.cambiarPaginaAlojamientos();		
		paginaAlojamientos.clicDestino();
		paginaAlojamientos.enviarTextoDestino(textoDestino);
		paginaAlojamientos.ingresarFechas();
		paginaAlojamientos.clicHabitaciones();
		paginaAlojamientos.agregarAdulto();
		paginaAlojamientos.agregarMenor();
		paginaAlojamientos.aplicarOpcionesHabitaciones();
		
		paginaResultados = paginaAlojamientos.buscarAlojamientos();		
		Assert.assertTrue(paginaResultados.estaElPrimerResultado(), "No se encontraron resultados");		
	}
	
	@AfterMethod
	public void finTest() 
	{
		driver.close();
	}
}
