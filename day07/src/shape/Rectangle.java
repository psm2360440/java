package shape;

public class Rectangle extends Shape {
	
	private double width;
	private double height;


	//constructor는 상속되지 않음!
	public Rectangle() {
		super();
	}
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	
	
	
	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getCircumn() {
		return (width + height) * 2;
	}
}
