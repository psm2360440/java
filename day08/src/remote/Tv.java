package remote;

public class Tv implements Remote{

	@Override
	public void turnOn() {
		System.out.println("TV On");
	}

	@Override
	public void turnOff() {
		System.out.println("TV Off");
	}
}