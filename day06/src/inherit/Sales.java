package inherit;

public class Sales extends Employee {
	private String loc;
	private double rate;
	
	public Sales() {
	}
	
	public Sales(String id, String name, double salary) {
		super(id, name, salary);
	}

	public Sales(String id, String name, double salary, String loc, double rate) {
		super(id, name, salary);
		this.loc = loc;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return super.toString()+" "+loc+" "+rate;
	}

	@Override
	public double getAnnSalary() {
		double result = 0.0;
		result = (super.getSalary()*12) + (this.getIncentive()*12);
		return result;
	}
	
	public double getIncentive() {
		double result = 0.0;
		result = getSalary() * this.rate;
		return result;
	}

	
}
