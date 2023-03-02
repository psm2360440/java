package oop2;

import java.util.Calendar;
import java.util.Random;

public class Employee {
	private String id;			//private : 접근을 못 하도록 막는다...! 
	private String name;
	private int salary;

	public Employee() {			//default constructor
		this.id = "temp0001";
		this.name = "temp";
		this.salary = 10000000;
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

	public Employee(String name, int salary) {
		this("10000",name, salary);					//동일 클래스 내의 다른 생성자에서 호출할 때는 this()를 쓰고 반드시 첫줄에 적어야 한다. 일일히 적지 않아서 유지보수성을 높임
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {			//접근 및 변경을 허용하는 방법: 우클릭->source ->getter&setter
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public int getSalary() {
		return salary;
	}

	public int getAnnSalary() {
		return this.salary * 12;
	}

	public int bonus() {
		return this.salary*4;
	}
	
	public double getTax() {
		return this.salary * 0.175;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
