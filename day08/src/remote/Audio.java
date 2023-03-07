package remote;

public class Audio implements Remote {

	@Override
	public void turnOn() {
		System.out.println("Audio On");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio Off");
	}
}
