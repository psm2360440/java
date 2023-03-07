package com.kbstar.frame;

public interface DAO<K,V> {
	public static final String IP = "127.0.0.1"; 
	//상수: 누구나 사용할 수 있으나 변경할 수 없고, 대문자로 사용. 'public static final'은 생략 가능.  ex. Math.PI(3.14...)
	public void insert(V v);
	public void delete(K k);
	public void update(V v);
	
	default void connect() {
		System.out.println(IP + " 에 접속하였습니다.");
	}
	default void close() {
		System.out.println(IP + " 에 접속을 해제하였습니다.");
	}
}
