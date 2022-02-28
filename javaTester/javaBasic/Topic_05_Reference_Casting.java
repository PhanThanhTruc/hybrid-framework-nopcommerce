package javaBasic;

public class Topic_05_Reference_Casting {
	public String studentName;

	public String getStudenName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void xuatThongTin() {
		System.out.println("Thong tin: " + studentName);
	}
	public static void main(String[] args) {
		Topic_05_Reference_Casting casting1= new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting casting2= new Topic_05_Reference_Casting();
		
		casting1.setStudentName("Ha noi");
		casting2.setStudentName("Da Nang");
		casting1.xuatThongTin();
	    casting2.xuatThongTin();
	    
	    //ép kiểu;
	    casting2= casting1;
	    
	    casting1.xuatThongTin();
	    casting2.xuatThongTin();
	    
	}
}
