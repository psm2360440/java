package board;

public class Service {
	DAO dao;
	
	public Service() {
		dao = new DAO();
	}
	public void register(String str) {
		//Security or Log
		dao.insert(str);
	}
	public void remove (int num) {
		dao.delete(num);
	}
	public void modify(int num, String str) {
		dao.update(num,  str);
	}
	public String get(int num) {
		return dao.select(num);
	}
}