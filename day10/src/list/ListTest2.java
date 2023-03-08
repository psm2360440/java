package list;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTest2 {

	public static void main(String[] args) {
		//List는 인터페이스의 개념.
		List<Integer> list = new LinkedList<Integer>();
		//데이터 양이 많아지면 linkedList가 ArrayList 보다 훨씬 빠르다
		//1~ 10까지의 숫자 20개를 입력한다.
		//단 while 문을 이용한다.
		
		Random r = new Random();

		while( list.size() < 20 ) {
			int num = r.nextInt(10)+1;
			list.add(num);
		}
		System.out.println(list);
		System.out.println(list.size());
		
	}

}
