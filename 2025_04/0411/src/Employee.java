/*
 * 봉인된 sealed 클래스 Person을 상속한 자손클래스 Employee는 
 * final 또는 봉인이 해제된 non-sealed로 선언하거나 sealed 키워드로 또 다른 봉인 클래스로 선언해야 함
 * 
 * final은 더 이상 상속을 할 수 없다는 의미이고, non-sealed로 선언된 자손클래스는 봉인이 해제되었기 때문에
 * 또 다른 자손클래스를 만들 수 있다. 
 * 
 * final로 선언된 자손클래스는 더 이상 또 다른 자손을 생성할 수 없다.
 */

public final class Employee extends Person {

	@Override
	public void work() {
		System.out.println("제품을 생산합니다.");
	}
	
	

}
