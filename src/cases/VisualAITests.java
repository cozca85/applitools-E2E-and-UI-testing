package cases;

import static com.google.common.base.Strings.isNullOrEmpty;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import pages.LoginPage;
import utilities.TestBase;

public class VisualAITests extends TestBase{
	
	private EyesRunner runner;
	private Eyes eyes;
	private static BatchInfo batch;
	private WebDriver driver;

	@BeforeClass
	public static void setBatch() {
		// Must be before ALL tests (at Class-level)
		batch = new BatchInfo("AcmeDemoAppBatch");
	}
	
	@Before
	public void beforeEach() {
		//set webdriver
		driver = utilities.TestBase.open("chrome");
		// Initialize the Runner for your test.
		runner = new ClassicRunner();
		// Initialize the eyes SDK
		eyes = new Eyes(runner);
		// Raise an error if no API Key has been found.
		if(isNullOrEmpty(System.getenv("APPLITOOLS_API_KEY"))) {
		    throw new RuntimeException("No API Key found; Please set environment variable 'APPLITOOLS_API_KEY'.");
		}	
		// Set your personal Applitols API Key from your environment variables.
		eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
		// set batch name
		eyes.setBatch(batch);
		//		// Use Chrome browser
		//		driver = new ChromeDriver();
	}
	
	@Test
	public void test_visual_c1_v1_vs_v2_loginPageUIElements() {
		System.out.println("Test visual AI using Applitools SDK, case 1 starts...");
		
		batch = new BatchInfo("Login Page UI Elements");
		eyes.setBatch(batch);

		eyes.open(driver, "HackathonApp", "TestCase1-LoginUIElementsTest", new RectangleSize(800, 600));
		
		driver.get(TestBase.url);
		
		// Visual checkpoint #1 - Login page version 1
		eyes.checkWindow("Login Window");
		
		driver.get(TestBase.urlv2);
		
		// Visual checkpoint #2 - Login page version 2
		eyes.checkWindow("Login Window");

	}
	

	@Test
	public void test_visual_c2a_v1_v2_bothLoginParametersAreMissing() {
		System.out.println("Test visual AI using Applitools SDK, case 2a starts...");
		
		batch = new BatchInfo("DataDrivenTestLogin");
		eyes.setBatch(batch);

		eyes.open(driver, "HackathonApp", "TestCase2-NoParameters", new RectangleSize(800, 600));
		
		driver.get(TestBase.url);
		
		// Visual checkpoint #1 - Login page version 1
		eyes.checkWindow("Login Window v1");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("");
		
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window BothParamsMissing v1");

		driver.get(TestBase.urlv2);
		
		// Visual checkpoint #2 - Login page version 2
		eyes.checkWindow("Login Window v2");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("");
				
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("");
				
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window BothParamsMissing v2");
	}
	
	@Test
	public void test_visual_c2b_v1_v2_OnlyUsername() {
		System.out.println("Test visual AI using Applitools SDK, case 2b starts...");
		
		batch = new BatchInfo("DataDrivenTestLogin");
		eyes.setBatch(batch);

		eyes.open(driver, "HackathonApp", "TestCase2-OnlyUserName", new RectangleSize(800, 600));
		
		driver.get(TestBase.url);
		
		// Visual checkpoint #1 - Login page version 1
		eyes.checkWindow("Login Window v1");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("test");
		
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window OnlyUsername v1");

		driver.get(TestBase.urlv2);
		
		// Visual checkpoint #2 - Login page version 2
		eyes.checkWindow("Login Window v2");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("");
				
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("");
				
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window OnlyUserName v2");
	}
	
	@Test
	public void test_visual_c2c_v1_v2_OnlyPassword() {
		System.out.println("Test visual AI using Applitools SDK, case 2c starts...");
		
		batch = new BatchInfo("DataDrivenTestLogin");
		eyes.setBatch(batch);

		eyes.open(driver, "HackathonApp", "TestCase2-OnlyPassword", new RectangleSize(800, 600));
		
		driver.get(TestBase.url);
		
		// Visual checkpoint #1 - Login page version 1
		eyes.checkWindow("Login Window v1");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("");
		
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("test");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window OnlyPassword v1");

		driver.get(TestBase.urlv2);
		
		// Visual checkpoint #2 - Login page version 2
		eyes.checkWindow("Login Window v2");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("");
				
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("test");
				
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window OnlyPassword v2");
	}
	
	@Test
	public void test_visual_c2d_v1_v2_BothParametersPresent() {
		System.out.println("Test visual AI using Applitools SDK, case 2d starts...");
		
		batch = new BatchInfo("DataDrivenTestLogin");
		eyes.setBatch(batch);

		eyes.open(driver, "HackathonApp", "TestCase2-BothArePresent", new RectangleSize(800, 600));
		
		driver.get(TestBase.url);
		
		// Visual checkpoint #1 - Login page version 1
		eyes.checkWindow("Login Window v1");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("test");
		
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("test");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window Both Parameters v1");

		driver.get(TestBase.urlv2);
		
		// Visual checkpoint #2 - Login page version 2
		eyes.checkWindow("Login Window v2");
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("test");
				
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("test");
				
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		// Visual checkpoint #2 - Login page version 1
		eyes.checkWindow("Login Window BothParameteres v2");
	}
	
	@Test
	public void test_visual_c3_v1_v2_TableSort() {
		System.out.println("Test visual AI using Applitools SDK, case 3 starts...");
		
		batch = new BatchInfo("TableSortTest");
		eyes.setBatch(batch);

		eyes.open(driver, "HackathonApp", "TestCase3-TableSortTest", new RectangleSize(800, 600));
		
		driver.get(TestBase.urlloggedIn);
		
		boolean full = eyes.getForceFullPageScreenshot();
		
		//checkpoint #1 before sort
		eyes.checkWindow("Dashboard before table sort", full);
		
		driver.findElement(By.cssSelector("th#amount")).click();
		
		//checkpoint #1 after sort
		eyes.checkWindow("Dashboard before table sort", full);
		
		//version 2 test
		driver.get(TestBase.urlv2LoggedIn);
		
		//checkpoint #1 before sort
		eyes.checkWindow("Dashboard before table sort v2", full);
				
		driver.findElement(By.cssSelector("th#amount")).click();
		
		//checkpoint #2 after sort
		eyes.checkWindow("Dashboard after table sort v2", full);
	}
	
	@Test
	public void test_visual_c4_v1_v2_CanvasChartTest() {
		System.out.println("Test visual AI using Applitools SDK, case 4 starts...");
		
		batch = new BatchInfo("CanvasChartTest");
		eyes.setBatch(batch);

		eyes.open(driver, "HackathonApp", "TestCase4-CanvasChartTest", new RectangleSize(800, 600));
		
		driver.get(TestBase.urlloggedIn);
		
		boolean full = eyes.getForceFullPageScreenshot();
		
		//click on compare expenses
		driver.findElement(By.cssSelector("a#showExpensesChart")).isDisplayed();
		driver.findElement(By.cssSelector("a#showExpensesChart")).click();
				
		//verify that the bar chart is displayed
		driver.findElement(By.cssSelector("canvas#canvas")).isDisplayed();
		
		//checkpoint #1 initial version 2017-2018 
		eyes.checkWindow("Canvas Chart v1 2017 and 2018", full);
		
		//click on show data for next year
		driver.findElement(By.cssSelector("#addDataset")).click();
		
		//checkpoint #2 after click
		eyes.checkWindow("Canvas Chart v1 with 2019", full);
		// validate state in the applitools cloud
		
		//version 2 test starts
		driver.get(TestBase.urlv2LoggedIn);
		
		//click on compare expenses
		driver.findElement(By.cssSelector("a#showExpensesChart")).isDisplayed();
		driver.findElement(By.cssSelector("a#showExpensesChart")).click();
						
		//verify that the bar chart is displayed
		driver.findElement(By.cssSelector("canvas#canvas")).isDisplayed();
				
		//checkpoint #1 initial version 2017-2018 
		eyes.checkWindow("Canvas Chart v2 2017 and 2018", full);
				
		//click on show data for next year
		driver.findElement(By.cssSelector("#addDataset")).click();
				
		//checkpoint #2 after click
		eyes.checkWindow("Canvas Chart v2 with 2019", full);
		// validate state in the applitools cloud
	}
	
	@Test
	public void test_c5_v1_v2_dynamic_content() {
		//initiate the test v1
		System.out.println("Test visual AI using Applitools SDK, case 5 starts...");
		
		batch = new BatchInfo("Dynamic Content Test");
		eyes.setBatch(batch);
		
		eyes.open(driver, "HackathonApp", "TestCase5-DynamicContentTest", new RectangleSize(800, 600));
		
		//version 1
		driver.get(TestBase.urlwithAd);
		driver.manage().window().maximize();
		
		//login
		LoginPage user = new LoginPage(driver);
		user.loginSuccessfully();
		
		//verify that ads exist
		eyes.checkWindow("URL with flash sale ads v1");
		
		//version 2 test starts
		driver.get(TestBase.urlwithAdv2);
		driver.manage().window().maximize();
		
		//login
		LoginPage user2 = new LoginPage(driver);
		user2.loginSuccessfully();
		
		//verify that ads exist
		eyes.checkWindow("URL with flash sale ads v2");

	}
	
	@After
	public void afterEach() {
		// Wait and collect all test results (commented out for efficiency)
		//TestResultsSummary allTestResults = runner.getAllTestResults();
		// Print results
		//System.out.println(allTestResults);
		eyes.closeAsync();
		// Close the browser.
		driver.quit();
		// If the test was aborted before eyes.close was called, ends the test as
		// aborted.
		eyes.abortIfNotClosed();
	}

}
