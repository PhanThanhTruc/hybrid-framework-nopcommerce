package javaBasic;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	//@Test
	public void TC_02_If_Else() {
		//Có tới 2 điều kiện- nếu đúng thì if nếu sai thì else
		//Nếu driver start với browser là chrome/firefox/Edge/Safari thì dùng hàm click
		// Thông thường (builtin) của selenium webdriver
		
		// Nếu IE thì dùng của javaScriptExcutor
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
//		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		if(driver.toString().contains("internet explorer")) {
			System.out.println("Click by javascriptExcutor");
		}else {
			System.out.println("Click by selenium webelement");
		}
		
	}
	@Parameters("browser")
	//@Test
	public void TC_03_If_Else_If_Else(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\edgedriver.exe");
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			throw new RuntimeException("Vui lòng input browser name");
		}
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
		
	}
	@Test
	public void TC_04_If_Else_If_Else() {
		
	}

}
