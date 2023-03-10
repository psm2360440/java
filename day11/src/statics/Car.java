package statics;

public class Car {
	private String name;
	private String maker;
	public static String makerName = "HD";
	
//	static은 객체것이 아니라 class 고유 것이라 불러올 때 그냥 객체.static함수명으로 불러오면 됨.

	public Car() {
	}

	public Car(String name) {
		this.name = name;
	}
	
	public Car(String name, String maker) {
		super();
		this.name = name;
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", maker=" + maker + "]";
	}
}