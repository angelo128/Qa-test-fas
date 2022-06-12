package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarResultsPage 
{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css=".results-items-wrapper .results-cluster-container:nth-child(1) .accommodation-name-wrapper .accommodation-name")
	WebElement primerResultado;
	
	public DespegarResultsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	public boolean estaElPrimerResultado()
	{
		wait.until(ExpectedConditions.visibilityOf(primerResultado));
		return this.primerResultado.isDisplayed();
	}
	
}
