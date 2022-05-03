package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		email= "Abc"+ranDom()+"@gmail.com";
	}

	@Test
	public void TC_01_Register_Emplty() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.id("FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.id("LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.id("Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.id("FirstName")).sendKeys("Test");
		driver.findElement(By.id("LastName")).sendKeys("Tester");
		driver.findElement(By.id("Email")).sendKeys("Abc123");
		driver.findElement(By.id("Password")).sendKeys("Abc@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Abc@123");
		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Wrong email");
	}

	@Test
	public void TC_03_Success() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.id("FirstName")).sendKeys("Test");
		driver.findElement(By.id("LastName")).sendKeys("Tester");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys("Abc@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Abc@123");
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

		driver.findElement(By.className("ico-logout")).click();
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.id("FirstName")).sendKeys("Test");
		driver.findElement(By.id("LastName")).sendKeys("Tester");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys("Abc@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Abc@123");
		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
		
	}

	@Test
	public void TC_05_Register_Pass_Less_Than_6_Chars() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.id("FirstName")).sendKeys("Test");
		driver.findElement(By.id("LastName")).sendKeys("Tester");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys("Abc12");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Abc@123");
		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
		
	}

	@Test
	public void TC_06_Register_Invalid_COnfirm_Pass() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.id("FirstName")).sendKeys("Test");
		driver.findElement(By.id("LastName")).sendKeys("Tester");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys("Abc12");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Abc@12345");
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
	}

	public int ranDom() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
