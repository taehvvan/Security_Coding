/*
 * java.util 패키지의 Enumeration 인터페이스 특징
 * 		1. jdk 10.0에서 추가된 인터페이스로 컬렉션에 저장된 복수개의 원소값을
 * 		   순방향으로 쉽게 읽어오는 용도로 활용되며 저장되는 용도로는 사용되지 않는다.
 * 		2. Iterator의 구버전으로 한 번 사용된 것은 다시 사용하지 못한다.
 * 		   다시 사용하려면 재생성해야 한다.
 * 		3. jdk 1.0에서 추가된 컬렉션 api와 궁합이 잘 맞는다.
 */

import java.util.Enumeration;
import java.util.Vector;

public class ListEx05 {

	public static void main(String[] args) {
		
		Vector vec = new Vector();
		
		for(int i = 1; i <= 5; i++) {
			vec.add(new Integer(i * 10));
		}
		
		Enumeration enu2 = vec.elements();
		while(enu2.hasMoreElements()) {		// 벡터에 요소가 있다면 참
			System.out.println(enu2.nextElement());	// 컬렉션의 다음 원소값을 가져옴
		}

	}

}
