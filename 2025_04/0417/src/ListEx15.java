/*
 * 두 번째 제네릭 와일드 카드 문법
 * <?>  : 모든 객체 타입 배치가 가능함
 */

import java.util.Arrays;
import java.util.List;

public class ListEx15 {
	static void printList(List<?> list) {
		//	List<?> 에서 <?>는 모든 객체 타입을 배치할 수 있음
		for(Object obj : list) {
			System.out.print(" " + obj);
		}
		System.out.println("\n==================\n");
	}
	public static void main(String[] args) {
		
		// Arrays.asList() : 배열을 컬렉션 List로 변환
		
		List<Integer> li01 = Arrays.asList(10, 20, 30);	
		printList(li01);
		
		List<String> li02 = Arrays.asList("one", "two");
		printList(li02);
		
	}

}
