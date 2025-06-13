package lambda;

/* @FunctionalInterface 를 굳이 사용하지 않아도 추상메서드가 하나만 오면 람다식을 위한 함수형 인터페이스로 사용 가능하다.
 * 이 인터페이스로 외부클래스 메서드 내의 람다식 익명객체 구현에 사용한다.
 */

public interface MyFunInterface5 {
	
	void method();

}
