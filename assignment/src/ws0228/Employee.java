package ws0228;
public class Employee {
	private String id;
	private String name;
	private int salary;
	public Employee() {
		this.id = "default001";
		this.name = "김국민";
		this.salary = 1850000;
	}
	public Employee(String id, String name, int salary) {
		this.id = id;
		this.name = name;
		if(salary < 0) {
			this.salary = 0;
		}else {
			this.salary = salary;
		}
	}
	public int eGetAnnSalary() {
		return this.salary * 12;
	}
	public double eGetTax() {
		return this.salary * 0.175;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}