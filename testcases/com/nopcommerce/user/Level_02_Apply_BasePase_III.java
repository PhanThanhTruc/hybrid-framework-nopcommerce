package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePase_III extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		email = "Abc" + ranDom() + "@gmail.com";
	}

	@Test
	public void TC_01_Register_Emplty() {
		waitForElementClickAble(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForElementClickAble(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		waitForElementClickAble(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Test");
		sendKeyToElement(driver, "//input[@id='LastName']", "Tester");
		sendKeyToElement(driver, "//input[@id='Email']", "Abc123");
		sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");

		waitForElementClickAble(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Success() {
		waitForElementClickAble(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Test");
		sendKeyToElement(driver, "//input[@id='LastName']", "Tester");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");

		waitForElementClickAble(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		waitForElementClickAble(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		waitForElementClickAble(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Test");
		sendKeyToElement(driver, "//input[@id='LastName']", "Tester");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");

		waitForElementClickAble(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]//li"),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Register_Pass_Less_Than_6_Chars() {
		waitForElementClickAble(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Test");
		sendKeyToElement(driver, "//input[@id='LastName']", "Tester");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc12");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");

		waitForElementClickAble(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_COnfirm_Pass() {
		waitForElementClickAble(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Test");
		sendKeyToElement(driver, "//input[@id='LastName']", "Tester");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "Abc12");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@12345");

		waitForElementClickAble(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

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
