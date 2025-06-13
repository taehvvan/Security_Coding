// 제네릭 클래스 설계

class GenericClass<T> {		// <T> 가상의 제네릭 T 타입
	private T member;
	
	public void setValue(T value) {
		member = value;
	}
	
	public T getValue() {
		return member;
	}
}

public class ListEx12 {

	public static void main(String[] args) {

		// 실수 숫자만 저장 가능한 제네릭
		GenericClass<Double> obj01 = new GenericClass<>();
		obj01.setValue(7.7);
		System.out.println("반환되는 값 = " + obj01.getValue());
		
		// 정수 숫자만 저장 가능한 제네릭
		GenericClass<Integer> obj02 = new GenericClass<>();
		obj02.setValue(100);
		System.out.println("반환되는 값 = " + obj02.getValue());
		
		GenericClass<String> obj03 = new GenericClass<>();
		obj03.setValue("홍길동");
		System.out.println("반환되는 값 = " + obj03.getValue());
		
	}

}
