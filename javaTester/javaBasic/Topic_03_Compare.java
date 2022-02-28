package javaBasic;

public class Topic_03_Compare {
	int number=8;
	public static void main(String[] args) {
		int x = 5;

		int y = x;
		System.out.println("x= " + x);
		System.out.println("y= " + y);
		y = 10;
		System.out.println("x= " + x);
		System.out.println("y= " + y);
		
		Topic_03_Compare firtVariable= new Topic_03_Compare();
		Topic_03_Compare secondVariable= firtVariable;
		
		System.out.println("number= "+ firtVariable.number);
		System.out.println("number= "+ secondVariable.number);
	
		secondVariable.number=15;
		
		System.out.println("number= "+ firtVariable.number);
		System.out.println("number= "+ secondVariable.number);
	}

}
