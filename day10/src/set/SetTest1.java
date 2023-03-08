package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTest1 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>(); 

		//중복을 허용 안 함
		//순서의 개념이 없음
		//1~ 10까지의 숫자를 10개 입력 하세요
		Random r = new Random ();
//		for (int i = 0; i < 10; i++) {
//			int num = r.nextInt(10)+1;
//			set.add(num);
//		}
		//중복을 허용하지 않기 때문에 for문이 아닌  While문으로 랜덤 숫자를 넣어야 size를 맞출 수 있다
		while(set.size() < 10) {
			int num = r.nextInt(10)+1;
			set.add(num);
		}
		
		for( int data: set) {
			System.out.println(data);
		}
	}
}