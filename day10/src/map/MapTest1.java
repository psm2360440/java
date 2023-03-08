package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapTest1 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(3, "B");
		map.put(5, "C");
		map.put(7, "D");
		map.put(13, "E");
		// (primary Key, data)

		Collection<String> col = map.values();
		System.out.println(col);
		System.out.println(col.size());

		for (String a : col) {
			System.out.println(a);
		}

	}
}