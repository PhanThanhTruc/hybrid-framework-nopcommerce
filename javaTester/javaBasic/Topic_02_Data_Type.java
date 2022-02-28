package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	//primitive type/value  type: kiểu nguyên thuỷ
	byte bNumber;
	
	short sNumber;
	
	int iNumber;
	
	long lNumber;
	
	float fNumber;
	
	double dNumber;
	
	char cChar;
	
	boolean bStatus;
	
	
	//reference type: kiểu tham chiếu
	//String
	String address="TP Da Nang";
	//Array
	String[] studentNumber= {address,"Nha TRang"};
	Integer[] number= {1,4,15};

	//Class
	Topic_02_Data_Type topic;
	//Interface
	WebDriver driver;
	//Object
	Object aObject;
	//Collection
	//List/set/Queue/Map
	List<WebElement> homePageLink= driver.findElements(By.tagName("a"));
	Set<String> allWindow= driver.getWindowHandles();
	List<String> productName= new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
