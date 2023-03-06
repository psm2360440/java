package shape;

public abstract class Shape {
	protected int x;
	protected int y;
	
	public Shape() {
		super();
	}

	public Shape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	//추상함수  Abstract Method
	//추상클래스에서 선언한 추상함수는 반드시 하위클래스에서 오버라이딩???해야 한다고???
	public abstract double getArea();
	public abstract double getCircumn();
	
	public String getXY() {
		return x+ " , " + y;
	}
	
}
