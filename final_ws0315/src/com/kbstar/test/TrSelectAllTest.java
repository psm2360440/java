package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.TrDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.TrService;

public class TrSelectAllTest {

		public static void main(String[] args) {
			CRUDService<String, TrDTO> crudService =
					new TrService();
			List<TrDTO> list = null;
			try {
				list = crudService.get();
				if(list.size() == 0) {
					System.out.println("데이터가 없습니다.");
				}else {
					for(TrDTO obj: list) {
						System.out.println(obj);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}