package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fasterxml.jackson.core.JsonProcessingException;

import Pages.HomePage;
import Pages.StatsPage;
import Pages.TeamsPage;
import Utilities.API;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HackathonSteps {
	WebDriver driver;
	HomePage homePage;
	StatsPage statsPage;
	TeamsPage teamsPage;
	
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		homePage=new HomePage(driver);
		statsPage= new StatsPage(driver);
		teamsPage=new TeamsPage(driver);
		
	}
	
	@Given("user navigates to IPL Application")
	public void user_navigates_to_ipl_application() {
	   homePage.openIPLHomePage();
	}

	@When("user selects the required category of players")
	public void user_selects_the_required_category_of_players() throws InterruptedException {
	    homePage.navigateToStatsPage();
	    statsPage.selectBestBowlingStrikeRateCategory();
	}

	@When("user gets all the details of Players that satisfies given condition and makes API call")
	public void user_gets_all_the_details_of_players_that_satisfies_given_condition() throws JsonProcessingException {
		statsPage.getRequiredPlayersList();
		statsPage.makeAPICall();
	    
	}

	@Then("user takes the screenshot of that player and add it to report")
	public void user_takes_the_screenshot_of_that_player_and_add_it_to_report() throws InterruptedException {
	    statsPage.getScreenshot();
	}
	
	@When("user makes a Get call to API and get the Team required and Hovers on it to get year of winnings")
	public void user_makes_a_get_call_to_api_and_get_the_team_required() {
	
	   teamsPage.makeGetAPICall();
	   teamsPage.getYearsOfWinnings();
	}

//	@Then("user validates the years using API")
//	public void user_validates_the_years_using_api() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	
    @After
    public void closedriver() {
    	driver.quit();
    }
    
}
