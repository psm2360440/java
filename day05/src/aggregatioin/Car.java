package aggregatioin;

public class Car {		//속성
	public String name;
	public String color;
	public int size;
	
	//생성자. (constructor)
	public Car() {
		this.name = "k1";
		this.color = "red";
		this.size = 1000;
	} //argument가 다르면 이름이 같은 생성자도 가능
	public Car(String name, String color, int size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + "]";
	}
	public void go() {			//오퍼레이션
		System.out.printf("%s, %s Go Car...",this.name, this.color);
	}
	public void stop() {
		System.out.printf("%s, %s Stop Car...\n", this.name, this.color);
	}
}
