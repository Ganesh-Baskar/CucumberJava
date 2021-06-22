package com.telecom.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomerSteps {
	
	static WebDriver driver;
	 
	@Given("user launches telecom application")
	public void user_launches_telecom_application() {
		
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.get("http://demo.guru99.com/telecom/");
	 driver.manage().window().maximize();
	}

	@Given("user click on add customer button")
	public void user_click_on_add_customer_button() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	   
	}

	@When("user need to fill up the fields")
	public void user_need_to_fill_up_the_fields() {
		driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		driver.findElement(By.id("fname")).sendKeys("Ganesh");
		driver.findElement(By.id("lname")).sendKeys("Baskar");
		driver.findElement(By.id("email")).sendKeys("ganesh@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("neyveli");
		driver.findElement(By.id("telephoneno")).sendKeys("987456788");
	}
	

    @When("user need to fill up the fields by oneDim list")
    public void user_need_to_fill_up_the_fields_by_oneDim_list(DataTable dataTable) {
    	
    	List<String> data = dataTable.asList(String.class);
    	
    	driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get(0));
		driver.findElement(By.id("lname")).sendKeys(data.get(1));
		driver.findElement(By.id("email")).sendKeys(data.get(2));
		driver.findElement(By.name("addr")).sendKeys(data.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));
    	
    }
    
    @When("user need to fill up the fields by oneDim map")
    public void user_need_to_fill_up_the_fields_by_oneDim_map(DataTable dataTable) {
    	
    	Map<String, String> data = dataTable.asMap(String.class,String.class );
    	
    	driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get("fname"));
		driver.findElement(By.id("lname")).sendKeys(data.get("lname"));
		driver.findElement(By.id("email")).sendKeys(data.get("email"));
		driver.findElement(By.name("addr")).sendKeys(data.get("addr"));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get("telephoneno"));
    	   
    }
    
    @When("user need to fill up the fields by twoDim list")
    public void user_need_to_fill_up_the_fields_by_twoDim_list(DataTable dataTable) {
       
    	List<List<String>> data = dataTable.asLists(String.class);
    	
    	driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get(1).get(0));
		driver.findElement(By.id("lname")).sendKeys(data.get(1).get(1));
		driver.findElement(By.id("email")).sendKeys(data.get(1).get(2));
		driver.findElement(By.name("addr")).sendKeys(data.get(1).get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get(1).get(4));
    }
    
    @When("user need to fill up the fields by twoDim map")
    public void user_need_to_fill_up_the_fields_by_twoDim_map(DataTable dataTable) {
    	
    	List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
    	
    	driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get(1).get("fname"));
		driver.findElement(By.id("lname")).sendKeys(data.get(0).get("lname"));
		driver.findElement(By.id("email")).sendKeys(data.get(2).get("email"));
		driver.findElement(By.name("addr")).sendKeys(data.get(2).get("addr"));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get(2).get("telephoneno"));
		
    }

	@When("user click on submit button")
	public void user_click_on_submit_button() {
	    driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	}

	@Then("user verify customer id is generated")
	public void user_verify_customer_id_is_generated() {
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
		String txt = driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
	    System.out.println(txt);
	    driver.quit();
	}



}
