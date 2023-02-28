package ws0228;

public class Manager {
	private String id; // 프라이빗을 넣으면 처음 셋팅 이후에 접근이 막힘따라서 App.java에서 수정할 수가 없음
	private String name;
	private int salary;
	private int monthlyPs;

	public Manager() {
		this.id = "temp0001"; // default 컨스트럭터 : 유저가 아무것도 입력하지 않아도 생성되는 값
		this.name = "temp"; // default 컨스트럭터 : 유저가 아무것도 입력하지 않아도 생성되는 값
		this.salary = 10000000; // default 컨스트럭터 : 유저가 아무것도 입력하지 않아도 생성되는 값
	}

	public Manager(String id, String name, int salary, int monthlyPs) {
		this.id = id;
		this.name = name;
		if (salary < 0) {
			this.salary = 0;
		} else {
			this.salary = salary;
		}
		if (monthlyPs < 0) {
			this.monthlyPs = 0;
		} else {
			this.monthlyPs = monthlyPs;
		}
	}

	public String mgetId() {
		return id;
	}

	public String mgetName() {
		return name;
	}

	public int mgetSalary() {
		return salary;
	}

	public int mgetmonthlyPs() {
		return monthlyPs;
	}

	public int mGetAnnSalary() {
		return this.salary * 12;
	}

	public double mgetTax() {
		return (this.salary * 0.175 + +this.monthlyPs * 0.175);
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", monthlyPs=" + monthlyPs + "]";
	}

}