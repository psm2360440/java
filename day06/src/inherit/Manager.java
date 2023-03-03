package inherit;

public class Manager extends Employee{				//상속 표현 extends 사용;
		private double bonus;

		public Manager() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Manager(String id, String name, double salary) {
			super(id, name, salary);
			// TODO Auto-generated constructor stub
		}

		public Manager(String id, String name, double salary, double bonus) {
			super(id, name, salary);
			this.bonus = bonus;
		}

		public double getBonus() {
			return bonus;
		}

		public void setBonus(double bonus) {			//bonus가 빠진 super 생성자로 manager 생성 후, setter로 bonus set 가능;
			this.bonus = bonus;
		}

		//함수의 재정의(overriding): 필요 시, 상위에 있는 함수를 재정의 할 수 있음. 
		@Override
		public double getAnnSalary() {
			double result = 0.0;
			result = super.getAnnSalary() + (this.bonus * 12); //(this.getSalary()+ this.bonus) * 12; //salary 값에 접근가능하도록  Employee 에서  접근 제어자를 'protected'로 바꿈
			return result;	//Employee class에서 private을 그대로 두고 getter를 추가함. 이때 this.salary가 아닌  getSalary로 바꾸어 사용;
		}

		@Override
		public String toString() {
			return super.toString() + " " + bonus;
		}	
}