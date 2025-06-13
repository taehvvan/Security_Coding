/*
 * java.util 패키지의 Map 컬렉션 인터페이스를 구현 상속한 Hashtable 컬렉션 클래스 특징
 * 		1. 키, 값의 쌍으로 저장함
 * 		2. 키를 통해서 값을 검색하기 때문에 검색 속도가 빠름
 * 		3. 저장되는 순서를 보장하지 않음
 */

import java.util.Enumeration;
import java.util.Hashtable;

public class ListEx10 {

	public static void main(String[] args) {

		// 키, 값 쌍으로 문자열만 저장 가능한 컬렉션 제네릭 타입 <String>을 지정
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
		ht.put("apple", "사과");
		ht.put("orange", "오렌지");
		ht.put("grape", "포도");
		
		String val = ht.get("grape");	// grape 키에 대한 값을 구함
		if(val != null ) {
			System.out.println("grape => " + val);
		}
		
		Enumeration<String> enum2 = ht.keys();
		while(enum2.hasMoreElements()) {	// 읽을 수 있는 요소가 있다면 참
			String k = enum2.nextElement();	// 키를 구함
			String v = ht.get(k);			// 키에 대한 값을 구함
			System.out.println(k + " : " + v);	// 키 : 값 출력
		}
	}
}
