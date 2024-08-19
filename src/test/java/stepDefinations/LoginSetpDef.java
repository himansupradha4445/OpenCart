package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class LoginSetpDef {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
	}
	
	@After
	public void tearDown()
	{
		if(driver==null)
		{
			driver.quit();
		}
	}

	@Given("I am on the OpenCart login page")
	public void i_am_on_the_open_cart_login_page() {
	    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	    loginPage=new LoginPage(driver);
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
	    loginPage.enterEmail("qatestertest@gmail.com");
	    loginPage.enterPassword("Test@123");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
	    loginPage.clickLoginButton();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
	    Assert.assertTrue(loginPage.checkLogoutLink());
	}

	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String string, String string2) {
	   loginPage.enterEmail(string);
	   loginPage.enterPassword(string2);
	}

	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String string) {
		Assert.assertEquals( driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
	}

	@When("I click on the {string} link")
	public void i_click_on_the_link(String string) {
		loginPage.clickForgottenPasswordLink();
	   
	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() {
		 Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
	}

}
