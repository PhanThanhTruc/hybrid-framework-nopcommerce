package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Excecise {
	@Test
	public void TC_01() {

		Scanner input = new Scanner(System.in);

		System.out.println(" Input name:");
		String P1 = input.nextLine();
		System.out.println("Input Age:");
		int P2 = input.nextInt();
		P2+=15;
		System.out.println("After 15 year, age of "+ P1+" is" + P2);

	}
	@Test
	public void TC_02() {
		int a=3;
		int b=4;
		
		a=a+b;//7
		b=a-b;//b=3
		a=a-b;
		System.out.println("a is:"+ a);
		System.out.println("b is: "+b);
		
	}
	@Test
	public void TC_03() {
		Scanner input= new Scanner(System.in);
		System.out.println("Input a:");
		int a= input.nextInt();
		System.out.println("Inpt b:");
		int b=input.nextInt();
		boolean status=(a==b)?true:false;
		System.out.println(status);
		
	}

}
