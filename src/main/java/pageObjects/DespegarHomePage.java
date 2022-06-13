package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DespegarHomePage 
{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	List<WebElement> listaElementos = null;
	
	@FindBy(css=".shifu-3-button-circle.HOTELS")
	WebElement btnAlojamientos;
	
	
	//Constructor	
	public DespegarHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		listaElementos = driver.findElements(By.cssSelector("ul.header-list-products > li"));
	}
	
	//Cambiar de pagina a Alojamientos
	public DespegarAlojamientosPage cambiarPaginaAlojamientos()
	{
		btnAlojamientos.click();
		return new DespegarAlojamientosPage(this.driver);
	}
	
	public void recorrerListaProductos() throws Exception
	{
		for (WebElement elemento : listaElementos) 
		{
			WebElement iElemento = elemento.findElement(By.cssSelector(".button-circle-icon"));
			Thread.sleep(5000);	
			iElemento.click();
			Assert.assertTrue(iElemento.isDisplayed(), "El elemento no es visible");
		}
	}
}
