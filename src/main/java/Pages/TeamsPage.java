package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utilities.API;
import Utilities.Utilities;
import io.restassured.response.Response;

public class TeamsPage {

	WebDriver driver;
	Utilities utility = new Utilities();
	String yearOfWinnings;
	String requiredTeam;
	
	public TeamsPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(this.driver,this);

	}
	
	@FindBys({@FindBy(xpath="//div[@class=\"team-on-hover\"]/div")})
	private List<WebElement> years;
	
	public void makeGetAPICall() {
		Response response=API.GETRequest();
		requiredTeam=response.body().asString();
		System.out.println(requiredTeam);
	}
	
	public void getYearsOfWinnings() {
		System.out.println("Insode Function");
		switch("RR") {
		case "CSK":
			yearOfWinnings=years.get(0).getText();
			break;
		case "GT":
			yearOfWinnings=years.get(1).getText();
			break;
		case "KKR":
			yearOfWinnings=years.get(2).getText();
			break;
		case"MI":
			yearOfWinnings=years.get(3).getText();
			break;
		case "RR":
			System.out.println("INSIDE");
			yearOfWinnings=years.get(4).getText();
			break;
		case "SRH":
			yearOfWinnings=years.get(5).getText();
			break;
		default :
			System.out.println("No Years Won");
		}
		yearOfWinnings.replace(" | ", ",");
		System.out.println(yearOfWinnings);
		
		
	}
	
	
}
