package inherit2;

public class App2 {

	public static void main(String[] args) {
		// Manager is a Employee
		Employee e = new Manager("100", "James", 500, 50);
		// Manager m = new Employee("100", "James", 500);n 는 불가능

		Employee ea[] = new Employee [5];
		ea[0] = new Employee("100", "James", 500);
		ea[1] = new Employee("101", "Jamess", 500);
		ea[2] = new Employee("102", "Jamesss", 500);
		ea[3] = new Manager("103", "Jamessss", 500, 50);
		ea[4] = new Sales("104", "똠양꿍", 500, "Seoul", 0.35);
		
		for(Employee em:ea) {
			System.out.println(em.getAnnSalary());		//다형성의 예. getAnnSalary라는 표현방법은 같지만 실제 춮력값은 Employee 와 Manager가 다름
			System.out.println(em);
			//다형성 구현에서 specialization된 함수는 get 되지 않음;(employee class(상위 클래스)에 있는 method들만 보이기 때문)
			System.out.println(em.getIncentive());
			}
		System.out.println("----------------------------------------------------------");
		TaxCal t = new TaxCal();
		double result = t.getTax(ea[0]);
		System.out.println(result);
		
		double result2 = t.getTax(ea[3]);
		System.out.println(result2);
		
		double result3 = t.getTax(ea[4]);
		System.out.println(result3);
		
		}
		
	}
