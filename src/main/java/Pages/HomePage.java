package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.FixedConstants;
import Utilities.Utilities;

public class HomePage{
	WebDriver driver;
	Utilities utility = new Utilities();
	public HomePage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(this.driver,this);

	}
	
	@FindBy(css=".cookie__accept")
	private WebElement acceptCookieBtn;
	
	@FindBy(css=".site-menu [data-element_text='STATS']")
	private WebElement statsBtn;
	
	@FindBy(css=".site-menu [data-element_text='TEAMS']")
	private WebElement teamsBtn;
	
	public void openIPLHomePage() {
		driver.get(FixedConstants.Home_URL);
		utility.clickElement(driver, acceptCookieBtn);
	}
	
	public void navigateToStatsPage() {
		utility.clickElement(driver, statsBtn);
	}
	

}
