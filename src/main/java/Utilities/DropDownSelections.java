package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelections {

	WebDriver driver;

	public DropDownSelections(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectUsingText(WebElement element,String Text) {
		Select batch=new Select(element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		batch.selectByVisibleText(Text);
	}
	
	public void selectUsingValue(WebElement element,String Value) {
		Select batch=new Select(element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		batch.selectByValue(Value);
	}
	
	public void selectUsingIndex(WebElement element,int index) {
		Select batch=new Select(element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		batch.selectByIndex(index);
	}
	
}
