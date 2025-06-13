/*
 * java.util 패키지의 컬렉션 Set 인터페이스를 구현 상속한 HashSet 컬렉션 클래스 특징
 * 		1. 저장되는 순서를 보장하지 않는다.
 * 		2. 중복 원소값을 허용하지 않는다.
 */

import java.util.HashSet;
import java.util.Set;

public class ListEx01 {

	public static void main(String[] args) {

		Set set = new HashSet();
		set.add(100);	// 자바 최상위 클래스 Object 타입으로 업캐스팅하면서 저장
		set.add(100.6);	// 오토박싱, 업캐스팅
		set.add("Seoul");	// 업캐스팅
		set.add("Seoul");
		set.add(true);
		System.out.println("컬렉션 원소 개수 : " + set.size());
		System.out.println(set);
		
	}

}
