package com.kbstar.test;

import java.util.List;
import com.kbstar.dto.CustDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustService;

public class CustSelectAll {

	public static void main(String[] args) {
		CRUDService<String, CustDTO> custService = new CustService();
		List<CustDTO> list = null;
		try {
			list = custService.get();
			if (list.size() == 0) {
				System.out.println("가입자 정보가 존재하지 않습니다!");
			} else {
				for (CustDTO cust : list) {
					System.out.println(cust);
				}
			}
			System.out.println("디지캠 은행 가입자 정보 수는 총 "+list.size()+"건 입니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}