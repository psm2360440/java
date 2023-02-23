package variable;

public class P64 {

	public static void main(String[] args) {
		int a = 10;
		double d = 10.2345;
		String str1 = "abc";
		String str2 = "abc"; //str1과 str2의 Heap영역 주소는 같음
		str1 = "def";		//처음 주소의 "abc"가 변경되는 것이 아니라 "def" 새로운 주소로 연결이 되는 것.
		System.out.printf("%d\t %4.2f\t %s\n", a,d,str1); //4.2  .2는 소숫점이햐ㅏ 몇자리 표현할지를 뜻함
		if(str1 == str2) {
			System.out.println("OK"); 	//참조 주소의 비교 
		}
		
		if(str1.equals(str2)) {
			System.out.println("OK2");	 //실제 str1  과 str1의 비교 
		}
		String str3 = new String("abc"); 	//참조형은 'new'를 통해서도 만들 수 있다.
		String str4 = new String("abc");	//new를 통한 새로운  str은 참조형 Heap영역(string pool)에서 새로운 번지로 연결된다.
		//str3 == str4 는 false but, str3 equals str4는 "abc"자체를 비교하므로 같음

		//자바가 종료되면  stack영역의 메모리는 자동 삭제되지만 Heap영역의 참조는 남음, 후에 garbage collector가 삭제함
		//stack영역에 전체 다 담을 수 없는 string 같은 것들이 Heap영역에 
	}
	

}
