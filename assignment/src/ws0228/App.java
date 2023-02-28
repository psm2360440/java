package ws0228;

public class App {

	public static void main(String[] args) {
		Employee[] e= new Employee[5];
		Manager[] m= new Manager[5];
		int eSum=0;
		int mSum=0;
		
		m[0] = new Manager("2852671", "나은", 5000000, 2000000);
		m[1] = new Manager("2542729", "혜림", 3000000, 1000000);
		m[2] = new Manager("2467798", "성진", 9000000, 3000000);
		m[3] = new Manager("2099833", "선미", 8000000, 4000000);
		m[4] = new Manager("2987662", "루피", 7000000, 5000000);

		e[0] = new Employee("1998293", "딸기", 200000);
		e[1] = new Employee("1233454", "쿠키", 700000);
		e[2] = new Employee("1607995", "라떼", 800000);
		e[3] = new Employee("1277532", "그릭", 100000);
		e[4] = new Employee("1655782", "베리", 500000);
		
		
		for(int i=0;i<m.length;i++) {
			System.out.println((i+1)+"번째"+e[i].toString());
		}

		System.out.println();
		
		for(int i=0;i<e.length;i++) {
			System.out.println((i+1)+"번째"+m[i].toString());
		}
		
	//연봉,세금 출력
		for(int i=0;i<m.length;i++) {
			mSum+=m[i].mGetAnnSalary();
			System.out.printf("%d번째 manager 연봉: %d원 세금: %.1f원\n",i+1,m[i].mGetAnnSalary(),m[i].mgetTax());
		}

		System.out.println();
		
		for(int i=0;i<e.length;i++) {
			eSum+=e[i].eGetAnnSalary();
			System.out.printf("%d번째 employee 연봉: %d 세금: %.1f\n",i+1,e[i].eGetAnnSalary(),e[i].eGetTax());
		}
		
		System.out.printf("\n manager 연봉 합:%d \nemployee 연봉 합: %d\n",mSum,eSum);

	}

}
