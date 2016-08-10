package testCaseAutomationInJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseAutomationInJava {
	private WebDriver driver;
	private String baseUrl;
	
	public TestCaseAutomationInJava(){
		driver = new ChromeDriver();
		baseUrl = "https://www.linkedin.com/in/codynicholson";
	}
	
	public void goToLinkedIn(){
		driver.get(baseUrl);
	}
	
	public String getLinkedInFullName(){
		return driver.findElement(By.xpath("//div[@class='profile-card vcard']//h1[@id='name'][@class='fn']")).getText();
	}
	
	@Test
	public void checkNameOnLinkedInPage(){
		goToLinkedIn();
		
		//ER1
		String expectedValue = "Cody Nicholson";
		String actualValue = getLinkedInFullName();
		String failureDetails = "ER1: The Full Name was incorrect on the profile page of LinkedIn. Actual Value: '" + actualValue + "'. Expected Value: '" + expectedValue + "'.";
		assert (expectedValue.equals(actualValue)) : failureDetails;
	}
	
}