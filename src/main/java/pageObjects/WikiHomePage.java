package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiHomePage {
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css="a[href=\"/wiki/Wikipedia:Bienvenidos\"]")
	WebElement tituloBienvenida;
	
	public WikiHomePage(WebDriver unDriver)
	{
		driver = unDriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	public boolean textoBienvenida()
	{
		wait.until(ExpectedConditions.visibilityOf(tituloBienvenida));
		return this.tituloBienvenida.isDisplayed();
	}

}
