package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarHomePage 
{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css=".shifu-3-button-circle.HOTELS")
	WebElement btnAlojamientos;
	
	
	//Constructor	
	public DespegarHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Cambiar de pagina a Alojamientos
	public DespegarAlojamientosPage cambiarPaginaAlojamientos()
	{
		btnAlojamientos.click();
		return new DespegarAlojamientosPage(this.driver);
	}
}
