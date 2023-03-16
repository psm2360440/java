package com.kbstar.service;

import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.TrDAO;
import com.kbstar.dto.TrDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccNumber;

public class TrService implements CRUDService<String, TrDTO> {
	DAO<String, TrDTO> dao;

	public TrService() {
		dao = new TrDAO();
	}

	@Override
	public void register(TrDTO v) throws Exception {
		try {
			String id = MakeAccNumber.makeTrNum();
			v.setId(id);
			dao.insert(v);
			System.out.println("거래가 완료되었습니다!");
		} catch (Exception e) {
			throw new Exception("시스템 장애 입니다.");
		}
	}

	@Override
	public void remove(String k) throws Exception {
		System.out.println("삭제 불가능합니다.");// tr은 remove 안함

	}

	@Override
	public void modify(TrDTO v) throws Exception {
		System.out.println("변경 불가능합니다.");// tr은 modify 안함

	}

	@Override
	public TrDTO get(String k) throws Exception {
		return null;
	}

	@Override
	public List<TrDTO> get() throws Exception {
		List<TrDTO> list = null;
		try {
			list = dao.select();
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애 입니다.");
			}
			throw new Exception("시스템 장애 입니다.");
		}
		return list;
	}

	@Override
	public List<TrDTO> find(String k) throws Exception {
		List<TrDTO> myList = null;
		try {
			myList = dao.search(k);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("시스템 장애 입니다!");
		}
		return myList;
	}
}