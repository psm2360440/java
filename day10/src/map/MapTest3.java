package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest3 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(3, "B");
		map.put(5, "C");
		map.put(7, "D");
		map.put(13, "E");
		//(primary Key, data)
		
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.containsKey(8));
		System.out.println(map.containsValue("F"));
		//map.containsKey(): 주어진 키가 있는지 여부 (boolean)
		System.out.println(map.get(1));
		
		Set<Integer> keys = map.keySet();
		System.out.println((keys.toString()));
		for (int a : keys) {
			System.out.println(map.get(a));
		}
		
	
	}

}
