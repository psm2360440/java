package com.kbstar.test;

import java.util.List;
import com.kbstar.dto.TrDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.TrService;

public class TrSearchTest {

	public static void main(String[] args) {
		CRUDService<String, TrDTO> trService = new TrService();
		List<TrDTO> myList = null;
		try {
			myList = trService.find("0156");
			if(myList.size()==0) {
				System.out.println("해당 계좌로 거래내역이 존재하지 않습니다!");
			} else {
				for( TrDTO tr : myList) {
					System.out.println(tr);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}