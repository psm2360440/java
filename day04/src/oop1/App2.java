package oop1;

public class App2 {

	public static void main(String[] args) {
		Car car1 = new Car("k2", "blue", 2000); //new에 의해서 constructor가 동작하여 객체 'car1'가 생성
		car1.go();
		car1.stop();


		Car car2 = new Car("k3", "white", 3000); 
		car2.go();
		car2.stop();
		

	}
	
}
