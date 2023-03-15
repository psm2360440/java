
package com.kbstar.test;

import com.kbstar.dto.TrDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.TrService;

public class TrInsertTest {

	public static void main(String[] args) {
		CRUDService<String, TrDTO> crudService =
				new TrService();
		
		TrDTO tr = new TrDTO("0156", "4774", "out", 0.0);
		try {
			crudService.register(tr);
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}