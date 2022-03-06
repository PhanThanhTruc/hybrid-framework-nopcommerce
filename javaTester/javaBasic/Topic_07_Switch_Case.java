package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner input = new Scanner(System.in);

//	@Parameters("browser")
//	@Test
	public void TC_01_If_Else_If_Else(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\edgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Vui lòng input browser name");
			break;
		}
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();

	}

	@Parameters("browser")
	// @Test
	public void TC_02(String browserName) {
		driver = getDriverBrowser(browserName);
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}

	// @Test
	public void TC_03() {
		int month = input.nextInt();

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng vừa nhập có 28 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng vừa nhập có 30 ngày");
			break;

		default:
			System.out.println("Vui lòng nhập tháng từ 1 đến 12");
			break;
		}
	}

	public void TC_04() {
		int number = input.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;

		}
	}
	@Test
	public void TC_05() {
		int firtNumber=input.nextInt();
		int secondNumber=input.nextInt();
		String operator= input.next();
		
		switch (operator) {
		case "+":
			System.out.println("Tổng của 2 số đã nhập là:"+ (firtNumber+secondNumber));
			
			break;

		case "*":
			System.out.println("Tích của 2 số đã nhập là:"+ (firtNumber*secondNumber));
			
			break;
		case "-":
			System.out.println("HIệu của 2 số đã nhập là:"+ (firtNumber-secondNumber));
			
			break;
		case "%":
			System.out.println("Số dư của số thứ nhất chia số thứ hai:"+ (firtNumber-secondNumber));
			
			break;
		case "/":
			System.out.println("Phần nguyên của số thứ nhất chia cho số thứ hai:"+ (firtNumber/secondNumber));
			
			break;
		default:
			break;
		}
	}

	public WebDriver getDriverBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\edgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Vui lòng input browser name");
			break;
		}
		return driver;

	}

}
