package variable;

public class P69 {

	public static void main(String[] args) {
		String str = "abcdef";
		str = str.toUpperCase();	//대문자로 바뀐 string "ABCDEF"가 Heap영역에 새로 생성됨(string pool에 들어감), 새로운 주소가 연결됨
		System.out.println(str);
		
		
		String str2 = str.replace('A', 'Z');	 //주소에 접근할 때는 '.'을 사용,
		System.out.println(str2);				// 새로운 스트링이 생성됨, not 변경
		
		int lng = str.length();
		System.out.println(lng);

		
		int t = str.indexOf('B');
		System.out.println(t);	 //'0'부터 시작하므로,,,
		
		
		char c = str.charAt(0);

		
		String str3 = str.substring(t, c);
		System.out.println(str3);
		
		String email = "jmlee@tonesol.com";
		
		String id = "";
		String domain = "";
		
		System.out.printf("%s , %s", id, domain);
		
	}
	

}
