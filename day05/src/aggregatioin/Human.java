package aggregatioin;

public class Human {
	private String name;
	private Car car;		//소유하고 있음을 의미;
	
	public Human() {
	}

	public Human(String name) {
		this.name = name;
	}

	public Human(String name, Car car) {
		this.name = name;
		this.car = car;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public void drive() {
		car.go();
	}

	public void stopCar() {
		car.stop();
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", car=" + car + "]";
	}
}
