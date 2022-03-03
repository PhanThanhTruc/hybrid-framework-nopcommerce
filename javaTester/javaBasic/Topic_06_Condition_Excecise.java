package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Excecise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// @Test
	public void TC_01() {
		Scanner input = new Scanner(System.in);
		System.out.println(" Hãy nhập vào một số bất kỳ");
		int number = input.nextInt();

		if (number % 2 == 0) {
			System.out.println(" Số vừa nhập là số chẵn");
		} else {
			System.out.println("Số vừa nhập là số lẻ");
		}

	}

	// @Test
	public void TC_02() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào 2 số a và b");
		System.out.println(" Nhập vào số a");
		int a = input.nextInt();
		System.out.println("Nhập vào số b:");
		int b = input.nextInt();
		if (a >= b) {
			System.out.println("a lớn hơn hoặc bằng b");
		} else {
			System.out.println("a nhỏ hơn b");
		}
	}

	// @Test
	public void TC_03() {
		Scanner input = new Scanner(System.in);
		System.out.println(" Nhập vào tên của người thứ nhất");
		String name1 = input.nextLine();
		System.out.println("Nhập tên của người thứ hai");
		String name2 = input.nextLine();
		if (name1.equals(name2)) {
			System.out.println("Hai người cùng tên");
		} else {
			System.out.println("Hai người khác tên");
		}
	}

	// @Test
	public void TC_04() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào 3 số a,b,c");
		System.out.println("a:");
		int a = input.nextInt();
		System.out.println("b:");
		int b = input.nextInt();
		System.out.println("c:");
		int c = input.nextInt();

		if (a > b && a > c) {
			System.out.println("Số lớn nhất là a:" + a);
		} else if (b > a && b > c) {
			System.out.println("Số lớn nhất là b:" + b);
		} else {
			System.out.println("Số lớn nhất là c:" + c);
		}
	}

	// @Test
	public void TC_05() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào số a:");
		int a = input.nextInt();

		if (a >= 10 && a <= 100) {
			System.out.println(a + " nằm trong [10;100]");
		} else {
			System.out.println(a + " không nằm trong [10;100]");
		}
	}

	// @Test
	public void TC_06() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào điểm của sinh viên");
		Float diem = input.nextFloat();
		if (diem >= 0 && diem < 5) {
			System.out.println("Điểm D");
		} else if (diem >= 5 && diem < 7.5) {
			System.out.println("Điểm C");
		} else if (diem >= 7.5 && diem < 8.5) {
			System.out.println("Điểm B");
		} else if (diem >= 8.5 && diem <= 10) {
			System.out.println("Điểm A");
		}
	}

	@Test
	public void TC_07() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào tháng:");
		int month = input.nextInt();
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println(month + " Có 31 ngày");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month + " Có 30 ngày");
		} else if (month == 2) {
			System.out.println(month + " CÓ 28 ngày");
		}
	}

}
