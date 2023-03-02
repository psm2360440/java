package cthis;

import java.util.Date;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("이종석", 500);
		System.out.println(e);
		Employee e2 = new Employee("이종식", 650);
		System.out.println(e2);
	}
	
	Date d = new Date ();
	java.sql.Date dd = new java.sql.Date(0);	//동일한 이름의 클래스를 임포트할 때, 두번째 임포트하는 클래스는 패키지 명까지 클래스 명 앞에 다 적어야ㅕ 함.
	
}