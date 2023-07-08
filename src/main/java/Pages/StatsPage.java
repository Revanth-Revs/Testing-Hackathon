package Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utilities.API;
import Utilities.FibonacciNonPrime;
import Utilities.Utilities;
import io.restassured.response.Response;
import pojo.PlayerPOJO;
import pojo.TeamPOJO;

public class StatsPage {
	WebDriver driver;
	Utilities utility = new Utilities();
	PlayerPOJO playerPojo;
	TeamPOJO teamPOJO = new TeamPOJO();
	String jsonString;
	String resultName;
	public StatsPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(this.driver,this);

	}

	@FindBy(css=".statsTypeFilter > .cSBDisplay")
	private WebElement dropDownFilter;

	@FindBy(css=".bowFItem")
	private WebElement bowlers;
	
	@FindBy(xpath="//div[.='Best Bowling Strike-Rate']")
	private WebElement bestBowlingStrikeRateOption;
	
	@FindBy(css="[ng-show='statsListLimit == 20 && tourBattingStats.length > 20'] > [href='javascript:void(0);']")
	private WebElement viewAllBtn;
	
	
	 @FindBys({@FindBy(xpath="//tr[@ng-class=\"{'np-bg-org' : key==0}\"]/td[@class='ng-binding'][1]")})
	private List<WebElement> positions;
	
	@FindBys({@FindBy(xpath="//div[@class='st-ply-name ng-binding']")})
	private List<WebElement> name;
	
	@FindBys({@FindBy(xpath="//tr[@ng-class=\"{'np-bg-org' : key==0}\"]/td[@class='ng-binding'][2]")})
	private List<WebElement> matchesPlayed;
	
	@FindBys({@FindBy(xpath="//tr[@ng-class=\"{'np-bg-org' : key==0}\"]/td[@class='ng-binding'][5]")})
	private List<WebElement> runs;
	
	@FindBys({@FindBy(xpath="//tr[@ng-class=\"{'np-bg-org' : key==0}\"]/td[@class='ng-binding'][6]")})
	private List<WebElement> wickets;
	
	@FindBys({@FindBy(xpath="//tr[@ng-class=\"{'np-bg-org' : key==0}\"]/td[@class='ng-binding'][7]")})
	private List<WebElement> average;
	
	@FindBys({@FindBy(xpath="//tr[@ng-class=\"{'np-bg-org' : key==0}\"]/td[@class='ng-binding'][8]")})
	private List<WebElement> economy;
	
	@FindBys({@FindBy(xpath="//td[@class='ng-binding np-tableruns']")})
	private List<WebElement> strikeRate;
	
	public void selectBestBowlingStrikeRateCategory() throws InterruptedException {
		utility.clickElement(driver, dropDownFilter);
		utility.clickElement(driver, bowlers);
		bestBowlingStrikeRateOption.click();
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
//		jsExecutor.executeScript("arguments[0].scrollIntoView();", viewAllBtn); 
//		Actions actions = new Actions(driver); actions.sendKeys(Keys.END).perform();
//		WebElement body = driver.findElement(By.tagName("body")); 
//		body.sendKeys(Keys.PAGE_DOWN);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewAllBtn);
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
//		jsExecutor.executeScript("scroll(0, 1600)");
//WebElement sectionElement = driver.findElement(By.cssSelector(".np-leaderInnserSection"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(sectionElement).perform();
//        viewAllBtn.click();
//		utility.clickElement(driver, viewAllBtn);
//		System.out.println(name.get(0).getText());
	}
	

	public void getRequiredPlayersList() throws JsonProcessingException {
//		List<Integer> requiredValues=FibonacciNonPrime.getNumbers();
		List<Integer> requiredValues= new ArrayList<Integer>(Arrays.asList(1,2,3,8));
		ArrayList<PlayerPOJO> allPlayers = new ArrayList<PlayerPOJO>();
		Iterator<Integer> i=requiredValues.iterator();
		while(i.hasNext()) {
			int x=i.next();
			System.out.println(name.get(x-1).getText());
			playerPojo=new PlayerPOJO();
			playerPojo.setPlayerName(name.get(x-1).getText());
			playerPojo.setMatchesPlayed(matchesPlayed.get(x-1).getAttribute("innerHTML"));
			playerPojo.setRunsConceded(runs.get(x-1).getAttribute("innerHTML"));
			playerPojo.setWickets(wickets.get(x-1).getAttribute("innerHTML"));
			playerPojo.setAverage(average.get(x-1).getAttribute("innerHTML"));
			playerPojo.setEconomy(economy.get(x-1).getAttribute("innerHTML"));
			playerPojo.setStrikeRate(strikeRate.get(x-1).getAttribute("innerHTML"));
			allPlayers.add(playerPojo);
		}
		teamPOJO.setCategories("BEST BOWLING STRIKE-RATE");
		teamPOJO.setTeamName("HAKUNA MATATA");
		teamPOJO.setPlayers(allPlayers);
		
		ObjectMapper objectMapper = new ObjectMapper();
		jsonString = objectMapper.writeValueAsString(teamPOJO);
	}
	
	public void makeAPICall() {
		Response response = API.POSTRequest("http://10.244.218.130:8080/bowlers",jsonString);
		resultName=response.body().asString();
		System.out.println(resultName);
	}
	
	public void getScreenshot() throws InterruptedException {
		int requiredIndex=0;
		for(int i=0;i<name.size();i++) {
			if((name.get(i).getText()).equals(resultName))
				requiredIndex=i;
		}
		utility.clickElement(driver, name.get(requiredIndex));
		utility.takeScreenshot(driver, "target/Screenshots/Screenshot1.jpg");
		
	}
	
	
	
	
}
