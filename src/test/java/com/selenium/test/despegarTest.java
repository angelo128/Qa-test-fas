package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;

public class despegarTest {
	WebDriver driver;
	
	@Test(description = "Actividad N°1")
	public void actividad1Despegar() throws Exception
	{		
		/*System.setProperty("webdriver.chrome.driver", "C:/BrowserDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.despegar.com.ar/");
		driver.manage().window().maximize();*/
		
		driver = DriverFactory.LevantaBrowser(driver, "CHROME", "https://www.despegar.com.ar/");
		
		//Elemetos
		By byElement = By.cssSelector(".sbox5-box-container .sbox-places-destination--1xd0k");
		WebDriverWait wait = new WebDriverWait (driver,1);
		
		WebElement alojamientos = driver.findElement(By.cssSelector(".shifu-3-button-circle.HOTELS"));
		alojamientos.click();	
		
		WebElement destino = driver.findElement(byElement);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sbox5-box-container .sbox-places-destination--1xd0k")));
		destino.click();
		//Thread.sleep(1000);		
		
		
		WebElement inputDestino = driver.findElement(By.cssSelector(".sbox5-box-container .sbox-places-destination--1xd0k .input-tag"));
		inputDestino.sendKeys("cordoba");
		Thread.sleep(1000);	
		inputDestino.sendKeys(Keys.CONTROL);	
		Thread.sleep(1000);	
		inputDestino.sendKeys(Keys.ENTER);
		
		//Seleccion de fechas
		
		WebElement btnFechaEntrada = driver.findElement(By.cssSelector(".sbox5-box-dates-checkbox-container .sbox5-dates-input1"));		
		btnFechaEntrada.click();
		//Thread.sleep(2000);	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today")));
		WebElement fechaEntrada = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today"));
		fechaEntrada.click();	
		//Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-weekday:nth-child(6)")));
		WebElement fechaSalida = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-weekday:nth-child(6)"));
		fechaSalida.click();
		//Thread.sleep(1000);	
		
		/*wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sbox5-floating-tooltip-opened .sbox5-3-btn")));
		WebElement btnAplicarFecha = driver.findElement(By.cssSelector(".sbox5-floating-tooltip-opened .sbox5-3-btn"));
		btnAplicarFecha.click();
		Thread.sleep(1000);	*/
		
		//Seleccion de personas
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sbox5-3-double-input")));

		WebElement btnHabitacion = driver.findElement(By.cssSelector(".sbox5-3-double-input"));
		btnHabitacion.click();		
		//Thread.sleep(1000);	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".stepper__room .stepper__distribution_container .stepper__room__row:nth-child(1) .steppers-icon-right")));
		WebElement addAdultos = driver.findElement(By.cssSelector(".stepper__room .stepper__distribution_container .stepper__room__row:nth-child(1) .steppers-icon-right"));
		addAdultos.click();
		
		WebElement addMenores = driver.findElement(By.cssSelector(".stepper__room .stepper__distribution_container .stepper__room__row:nth-child(2) .steppers-icon-right"));
		addMenores.click();
		//Thread.sleep(1000);			
		
		WebElement btnedadMenor = driver.findElement(By.cssSelector(".stepper__room .stepper__distribution_container .stepper__room__row:nth-child(3) .select__row__options__container"));
		btnedadMenor.click();
		//Thread.sleep(1000);
		
		//WebElement edadMenor = driver.findElement(By.cssSelector(".select__row__options__container .select-option:nth-child(12)"));
		//WebElement edadMenor = driver.findElement(By.cssSelector(".select-container .select .select-option:nth-child(12)"));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select-container .select .select-option[value='10']")));
		WebElement edadMenor = driver.findElement(By.cssSelector(".select-container .select .select-option[value='10']"));	
		edadMenor.click();		
			
		WebElement btnAplicar = driver.findElement(By.cssSelector(".distribution__container.distribution__type__rooms .stepper__room__footer  .sbox5-3-btn.-primary"));
		btnAplicar.click();
				
		WebElement btnBuscar = driver.findElement(By.cssSelector(".sbox5-box-button-ovr"));
		btnBuscar.click();
				
		
		driver.getCurrentUrl();
		
		//Validacion de un resultado
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".results-items-wrapper .results-cluster-container:nth-child(1) .accommodation-name-wrapper .accommodation-name")));
		WebElement txtResultado = driver.findElement(By.cssSelector(".results-items-wrapper .results-cluster-container:nth-child(1) .accommodation-name-wrapper .accommodation-name"));
		Assert.assertTrue(txtResultado.isDisplayed(),"Error");
		System.out.println("Texto encontrado = " + txtResultado.getText());
		
		driver.close();
	}
}
