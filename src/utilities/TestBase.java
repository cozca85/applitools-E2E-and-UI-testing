package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	WebDriver driver;
	public static String url = "https://demo.applitools.com/hackathon.html";
	public static String urlloggedIn = "https://demo.applitools.com/hackathonApp.html";
	public static String loginAndPasswordMustBePresent = "Both Username and Password must be present";
	public static String PasswordMustBePresent = "Password must be present";
	public static String UsernameMustBePresent = "Username must be present";
	public static String urlwithAd = "https://demo.applitools.com/hackathon.html?showAd=true";
	public static String urlv2 = "https://demo.applitools.com/hackathonV2.html";
	public static String urlv2LoggedIn = "https://demo.applitools.com/hackathonAppV2.html";
	public static String urlwithAdv2 = "https://demo.applitools.com/hackathonV2.html?showAd=true";
	public static String loginAndPasswordMustBePresentV2 = "Please enter both username and password";
	
	public static WebDriver open(String browserType)
	{
		if (browserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\software\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\software\\chromedriver.exe");
			return new ChromeDriver();
		}
	}

}
