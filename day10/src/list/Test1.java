package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 1; i <= 10; i++) {
			int num = r.nextInt(10) + 1;
			list.add(num); // 순서대로 들어가고 중복되어서도 들어갈 수 있다.
		}
		list.add(5, 100);
		list.remove(5);
		for (int data : list) {
			System.out.println(data);
		}
//		list.add(10);	//list에 데이터를 추가할 때  .add
//		list.add(20);
//		list.add(30);
		// auto-Unboxing

	}

}
