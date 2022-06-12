package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientosPage 
{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css=".sbox5-box-container .sbox-places-destination--1xd0k .input-tag")
	WebElement inputDestino;
	
	@FindBy(css=".sbox5-box-dates-checkbox-container .sbox5-dates-input1")
	WebElement btnFechaEntrada;
	
	@FindBy(css="div.sbox5-floating-tooltip-opened div.calendar-container div.-today")
	WebElement fechaEntrada;
	
	/*@FindBy(css="div.sbox5-floating-tooltip-opened div.calendar-container div.-weekday:nth-child(26)")
	WebElement fechaSalida;*/
	
	@FindBy(css=".sbox5-floating-tooltip-opened .sbox5-monthgrid:nth-child(3) .sbox5-monthgrid-datenumber:nth-child(17)")
	WebElement fechaSalida;
	
	@FindBy(css=".sbox5-3-double-input")
	WebElement btnHabitacion;
	
	@FindBy(css=".stepper__room .stepper__distribution_container .stepper__room__row:nth-child(1) .steppers-icon-right")
	WebElement addAdultos;
	
	@FindBy(css=".stepper__room .stepper__distribution_container .stepper__room__row:nth-child(2) .steppers-icon-right")
	WebElement addMenores;
	
	@FindBy(css=".stepper__room .stepper__distribution_container .stepper__room__row:nth-child(3) .select__row__options__container")
	WebElement edadMenor;
	
	@FindBy(css=".select-container .select .select-option[value='10']")
	WebElement selectEdadMenor;
	
	@FindBy(css=".distribution__container.distribution__type__rooms .stepper__room__footer  .sbox5-3-btn.-primary")
	WebElement btnAplicar;
	
	@FindBy(css=".sbox5-box-button-ovr")
	WebElement btnBuscar;
	
	public DespegarAlojamientosPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	public void clicDestino()
	{
		wait.until(ExpectedConditions.visibilityOf(inputDestino));
		wait.until(ExpectedConditions.elementToBeClickable(inputDestino));
		inputDestino.click();
	}
	
	public void enviarTextoDestino(String txt) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(inputDestino));		
		inputDestino.sendKeys(txt);		
		Thread.sleep(1000);	
		inputDestino.sendKeys(Keys.CONTROL);
		Thread.sleep(1000);	
		inputDestino.sendKeys(Keys.ENTER);
	}
	
	public void ingresarFechas()
	{
		btnFechaEntrada.click();
		wait.until(ExpectedConditions.visibilityOf(fechaEntrada));
		wait.until(ExpectedConditions.elementToBeClickable(fechaEntrada));
		fechaEntrada.click();
		this.clicFechaSalida();
	}
	
	public void clicFechaSalida()
	{
		wait.until(ExpectedConditions.visibilityOf(fechaSalida));
		wait.until(ExpectedConditions.elementToBeClickable(fechaSalida));
		fechaSalida.click();
	}
	
	public void clicHabitaciones()
	{
		btnHabitacion.click();
	}
	
	public void agregarAdulto()
	{
		wait.until(ExpectedConditions.visibilityOf(addAdultos));
		wait.until(ExpectedConditions.elementToBeClickable(addAdultos));
		addAdultos.click();
	}
	
	public void agregarMenor()
	{
		addMenores.click();
		wait.until(ExpectedConditions.visibilityOf(edadMenor));
		wait.until(ExpectedConditions.elementToBeClickable(edadMenor));
		edadMenor.click();
		wait.until(ExpectedConditions.visibilityOf(edadMenor));
		wait.until(ExpectedConditions.elementToBeClickable(edadMenor));
		selectEdadMenor.click();
	}	
	
	public void aplicarOpcionesHabitaciones()
	{
		btnAplicar.click();
	}
	
	public DespegarResultsPage buscarAlojamientos()
	{
		btnBuscar.click();
		return new DespegarResultsPage(this.driver);
	}
	
}
