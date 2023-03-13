package com.kbstar.frame;

import java.util.List;

public interface DAO<K,V>{
	public void insert(V v) throws Exception;
	public void delete(K k) throws Exception;
	public void update(V v) throws Exception;
	public V select(K k) throws Exception;
	public List<V> select() throws Exception;
	public List<V> search(Object obj) throws Exception;
//objetct 는 자바 최상위클래스이므로 어떤 걸 넣어도 됨!
}
//DAO : Database의 기능정의