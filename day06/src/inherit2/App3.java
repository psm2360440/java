package inherit2;

public class App3 {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Manager();
		Employee e3 = new Sales();
		
		Object obj = new Employee();
		Object oj2 = new Manager();
		//JAVA에서의 모든 클래스는  'extends Object'가 생략되어 있음
		//단일 상속이라 생략되어 있음, 자바의 모든 클래스는 옵젝에서 상속받은 상태이다.
	}

}
