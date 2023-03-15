package com.kbstar.frame;

public class MakeMessage {
	public static String makeMessage(String code) {
		String result = "";
		switch(code) {
		case "ER0001": result = "계좌 개설 실패"; break;
		case "ER0002": result = "음수 입력"; break;
		case "ER0003": result = "잔액 부족"; break;
		case "ER0007": result = "접근 제한 "; break;
		case "ER0008": result = "삭제 권한 없음 "; break;
		case "ER0009": result = "PK 수정 접근 제한 "; break;
		default: result = "고객센터에 문의하세요 1588-9999 ";
		}
		return result;
	}
}
