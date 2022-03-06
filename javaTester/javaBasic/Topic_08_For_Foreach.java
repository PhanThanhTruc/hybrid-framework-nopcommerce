package javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	WebDriver driver;
	public void TC_01_For() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		//Array
		String[] cityName= {"Da Nang", "Ha Noi", "Can Tho", "Tam Ky", "TP Ho Chi Minh"};
		for (int i = 0; i < cityName.length; i++) {
			System.out.println(cityName[i]);
		}
		//for kết hợp if thoả mãn điều kiện mới action
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[i].equals("Da Nang")) {
				//action
				System.out.println("Thành phố đà nẵng");
			}
		}
		//Dùng để chạy qua hết tất cả các giá trị
		for (String city : cityName) {
			System.out.println(city);
		}
		
		//
		int y=0;
		for (String city : cityName) {
			if (cityName[y].equals("Da Nang")) {
				System.out.println("Do action");
			}
			y++;
		}
	}
	@Test
	public void TC_02_For() {
		String[] cityName= {"Da Nang", "Ha Noi", "Can Tho", "Tam Ky", "TP Ho Chi Minh"};
//		for (String city : cityName) {
//			System.out.println(city);
//		}
		List<String> cityAddress= new ArrayList<String>();
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		for (String city : cityName) {
			cityAddress.add(city);
			
		}
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
		//Java generic
		List<WebElement> links= driver.findElements(By.xpath(""));
		for (WebElement link : links) {
			
		}
		
		
		
	}

}
