package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapTest4 {

	public static void main(String[] args) {
		Map<String, UserDTO> db = new HashMap<String, UserDTO>();
		db.put("id01", new UserDTO("id01", "pwd01", "james"));
		db.put("id02", new UserDTO("id02", "pwd01", "james"));
		db.put("id03", new UserDTO("id03", "pwd01", "james"));
		
		UserDTO u = db.get("id03");
		//System.out.println(u);
		
		UserDTO uu = new UserDTO("id03", "pwd03", "james3");
		db.put(uu.getId(), uu);
		UserDTO a = db.get(uu.getId());
		//System.out.println(a);
		
		Collection<UserDTO> col = db.values();
		for(UserDTO user: col) {
			System.out.println(user);
		}
	}
}