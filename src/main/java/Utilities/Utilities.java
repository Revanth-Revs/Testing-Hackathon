package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Utilities {
	
	public void clickElement(WebDriver driver,WebElement element) {
		WebDriverWait t = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		t.until(ExpectedConditions.visibilityOf(element));  
		t.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	 public static void takeScreenshot(WebDriver driver, String filePath) {
	        try {
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(screenshotFile, new File(filePath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	public void waitUntil(WebDriver driver,WebElement element) {
		WebDriverWait t = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		t.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void enterTextinTextBox(WebDriver driver,WebElement element,String text) {
		WebDriverWait t = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		t.until(ExpectedConditions.visibilityOf(element));  
		t.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(text);
	}

}
