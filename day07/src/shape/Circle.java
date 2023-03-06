package shape;

public class Circle extends Shape {

	private double radius;
	
	
	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}

	
	
	
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}

	@Override
	public double getCircumn() {
		return 2 * Math.PI * radius;
	}

}
