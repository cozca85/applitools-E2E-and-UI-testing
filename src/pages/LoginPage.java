package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void loginSuccessfully()
	{
		
		// send string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("test");
		
		// send string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("test");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
	}

}
