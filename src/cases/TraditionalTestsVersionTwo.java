package cases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.LoginPage;
import utilities.TestBase;

public class TraditionalTestsVersionTwo extends TestBase{

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Initializing the test environment");
		driver = utilities.TestBase.open("chrome");
		driver.get(TestBase.urlv2);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test_v2_c1_loginPageUIElements() {

		System.out.println("Test for version 2, case 1 starts...");
		
		try {
		// verify that logo exists
		String logo = driver.findElement(By.tagName("img")).getAttribute("src");
		assertTrue("There is a logo ", 
				!logo.isEmpty());
		System.out.println("There is a logo. Logo link : "+ logo);
		
		// verify login form text exists
		String formHeaderText = driver.findElement(By.tagName("h4")).getText();
		System.out.println(formHeaderText);

		// verify username, password and remember me label texts are correct
		List<WebElement> labels = driver.findElements(By.tagName("label"));

		assertTrue("Username label is not correct", labels.get(0).getText().equalsIgnoreCase("Username"));
		assertTrue("Password label is not correct",labels.get(1).getText().equalsIgnoreCase("Password"));
		assertTrue("Remember me label is not correct",labels.get(2).getText().equalsIgnoreCase("Remember Me"));

		// verify username icon exists
		driver.findElement(By.cssSelector(".os-icon.os-icon-user-male-circle.pre-icon"));
		
		// verify password logo exists
		driver.findElement(By.cssSelector(".os-icon-fingerprint"));
		
		// verify username input field exists
		driver.findElement(By.cssSelector("input#username.form-control"));
		
		// verify password input field exists
		driver.findElement(By.cssSelector("input#password.form-control"));
		
		// verify login button exists 
		//<button id="log-in" class="btn btn-primary">Log In</button>
		driver.findElement(By.id("log-in"));
		
		// verify check box remember me exists 
		driver.findElement(By.cssSelector(".form-check-input"));

		// verify social media icons exist
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		assertTrue(images.get(1).getAttribute("src").contains("twitter"));
		assertTrue(images.get(2).getAttribute("src").contains("facebook"));
		assertTrue(images.get(3).getAttribute("src").contains("linkedin"));
		}
		catch(AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}
	}

	@Test
	public void test_v2_c2_loginTest_BothPassAndLoginMissing() {
				
		driver.get(urlv2);
		
		System.out.println("Test for version 2, case 2.1 starts...");
		
		try{
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("");
		
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		//verify error
		driver.findElement(By.cssSelector(".alert.alert-warning")).isDisplayed();
		String errorText = driver.findElement(By.cssSelector(".alert.alert-warning")).getText();
		assertEquals(loginAndPasswordMustBePresentV2, errorText);		
		}
		catch(AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}
	}
	
	@Test
	public void test_v2_c2_loginTest_OnlyUserNamePresent() {
				
		driver.get(urlv2);

		System.out.println("Test for version 2, case 2.2 starts...");
		
		try {
		// send string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("test");
		
		// send empty string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		//verify error
		driver.findElement(By.cssSelector(".alert.alert-warning")).isDisplayed();
		String errorText = driver.findElement(By.cssSelector(".alert.alert-warning")).getText();
		assertEquals(PasswordMustBePresent, errorText);
		}
		catch(AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}
	}
	
	@Test
	public void test_v2_c2_loginTest_OnlyUsernamePresent() {
				
		driver.get(urlv2);
		
		System.out.println("Test for version 2, case 2.3 starts...");
		try {
		
		// send empty string to username field
		driver.findElement(By.cssSelector("input#username.form-control")).clear();
		driver.findElement(By.cssSelector("input#username.form-control")).sendKeys("");
		
		// send string to password field
		driver.findElement(By.cssSelector("input#password.form-control")).clear();
		driver.findElement(By.cssSelector("input#password.form-control")).sendKeys("test");
		
		//click on login
		driver.findElement(By.cssSelector("#log-in")).click();
		
		//verify error 
		driver.findElement(By.cssSelector(".alert.alert-warning")).isDisplayed();
		String errorText = driver.findElement(By.cssSelector(".alert.alert-warning")).getText();
		assertEquals(UsernameMustBePresent, errorText);		
		}
		catch(AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}
	}
	
	@Test
	public void test_v2_c2_loginTest_BothArePresent() {
				
		driver.get(urlv2);
		
		System.out.println("Test for version 2, case 2.4 starts...");
		try {
		//login
		LoginPage user = new LoginPage(driver);
		user.loginSuccessfully();
		
		//verify logged in state 
		assertTrue(driver.getCurrentUrl().contains("hackathonAppV2.html"));
		
		driver.findElement(By.id("showExpensesChart")).isDisplayed();
		driver.findElement(By.className("element-balances")).isDisplayed();
		driver.findElement(By.className("balance-title")).isDisplayed();
		}
		catch (AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}

	}
	
	@Test
	public void test_v2_c3_TableSortTest() {
				
		driver.get(urlv2);

		System.out.println("Test for version 2, case 3 starts...");
		try {
		//login
		LoginPage customer = new LoginPage(driver);
		customer.loginSuccessfully();
		
		//verify login and table is present
		assertTrue(driver.getCurrentUrl().contains("hackathonAppV2.html"));
		driver.findElement(By.id("transactionsTable")).isDisplayed();
		
		//verify transaction table data and amount of rows
		List<WebElement> rows = driver.findElements(By.xpath(".//table[@id='transactionsTable']/tbody/tr"));
		int tableSize = rows.size();
		System.out.println(tableSize);
		
		//store text and data of all rows
		String dataInitialState = "";
		for (WebElement row : rows)
		{
			dataInitialState = dataInitialState + row.getText();
		}
		
		//store data of all amount cells 
 		List<Double> amountsBeforeSort = new ArrayList<Double>();
		for (int r=1; r <= tableSize; r++)
		{
			String currentCellValue = driver.findElement(By.xpath("/html//table[@id='transactionsTable']/tbody/tr[" + r + "]/td[5]")).getText();
			double amount = Double.parseDouble(currentCellValue.replaceAll("([\\s+|,|A-Z])", "")); 	
			amountsBeforeSort.add(amount);
		}
		
		//Sort the data in ascending order by clicking amount  
		driver.findElement(By.cssSelector("th#amount")).click();
		
		//find and verify the rows after sort action
		List<WebElement> rowsAfterSort = driver.findElements(By.xpath(".//table[@id='transactionsTable']/tbody/tr"));
		int tableSizeAfterSort = rowsAfterSort.size();
		
		//verify that the amount of rows are the same
		assertEquals(tableSize,tableSizeAfterSort);
		
		//populate data content
		String dataAfterSortState = "";
		for (WebElement rowAfterSort : rowsAfterSort)
		{
			dataAfterSortState = dataAfterSortState + rowAfterSort.getText();
		}
		
		//verify table data content is the same after the sort
		dataAfterSortState.contains(dataInitialState);

		//verify after sort that cell values are in ascending order
 		List<Double> amountsAfterSort = new ArrayList<Double>();
		for (int i=1; i <= tableSizeAfterSort; i++)
		{
			String currentCellValue = driver.findElement(By.xpath("/html//table[@id='transactionsTable']/tbody/tr[" + i + "]/td[5]")).getText();
			double amount = Double.parseDouble(currentCellValue.replaceAll("([\\s+|,|A-Z])", "")); 	
			amountsAfterSort.add(amount);
		}
		
		//Sort the before state and compare with already sorted List
		Collections.sort(amountsBeforeSort);
		boolean sorted = amountsBeforeSort.equals(amountsAfterSort);
		assertTrue("The amounts are not sorted in ascending order. ",sorted);
		}
		catch(AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}
	}

	@Test
	public void test_v2_c4_CanvasTest() {
		//canvas test requires image recognition test software or another skill
		//in this test, I will only perform the test that verifies the bar chart.
		driver.get(urlv2);
		
		System.out.println(driver.getTitle());
		System.out.println("Test for version 2, case 4 starts...");
		
		try {
		//login
		LoginPage user = new LoginPage(driver);
		user.loginSuccessfully();
		
		//click on compare expenses
		driver.findElement(By.cssSelector("a#showExpensesChart")).isDisplayed();
		driver.findElement(By.cssSelector("a#showExpensesChart")).click();
		
		//verify that the bar chart is displayed
		driver.findElement(By.cssSelector("canvas#canvas")).isDisplayed();
		}
		catch(AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}
	}
	
	@Test
	public void test_v2_c5_dynamic_content() {
		//initiate the test
		driver.get(urlwithAdv2);

		System.out.println("Test for version 2, case 5 starts...");
		
		//login
		LoginPage user = new LoginPage(driver);
		user.loginSuccessfully();
		try {
		//verify that ads exist
		driver.findElement(By.id("flashSale2"));	
		driver.findElement(By.id("flashSale"));
		
		//verify that gifs have src
		assertTrue(!driver.findElement(By.xpath("//div[@id='flashSale2']/img")).getAttribute("src").isEmpty());
		assertTrue(!driver.findElement(By.xpath("//div[@id='flashSale']/img")).getAttribute("src").isEmpty());
		}
		catch(AssertionError e)
		{
			fail("Assertion failed with the message: " + e.getMessage());
		}
		catch (Exception e)
		{
			fail("Test failed with an exception: " + e.getMessage());
		}
	}

}
