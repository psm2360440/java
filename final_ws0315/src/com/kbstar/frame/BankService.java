package com.kbstar.frame;

public interface BankService<V> {
	public V login(String id, String pwd) throws Exception;
	public void register(V v) throws Exception;
	public void transaction( String myAcc, String opositACC, double amount ) throws Exception;
}