package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Excecise {
	@Test
	public void TC_01() {
		int a=6;
		int b=2;
		int P1=a+b;
		int P2=a-b;
		int P3=a*b;
		float P4= a/b;
		System.out.println("Tổng của 2 số a và b là:"+P1);
		System.out.println(" Hiệu của 2 số a và b là:"+P2);
		System.out.println("Tích của 2 số a và b là:"+P3);
		System.out.println("Thương của 2 số a và b là:"+P4);
		
	}
	@Test
	public void TC_02() {
		float cd=7.5f;
		float cr=3.8f;
		System.out.println(" Chu vi của hình chữ nhật là:"+ (cd+cr)*2);
		System.out.println(" Diện tích của hình chữ nhật là:"+(cd*cr));
	}
	@Test
	public void TC_03() {
		String name =" Automation Testing";
		System.out.println("Hello"+ name);
	}

}
