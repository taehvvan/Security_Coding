package net.daum.dto;

/* 레코드 선언 => 
 * 		멤버변수 타입 앞에 private final이 자동으로 추가
 * 		멤버변수를 초기화하기 위해서 개수만큼 오버로딩된 생성자가 자동으로 추가
 * 		멤버변수명과 같은 getter() 메소드가 자동으로 추가
 * 		동등비교를 위한 equals(), hashCode() 메소드가 오버라이딩되어 자동으로 추가
 * 		문자열 반환을 위한 toString() 메소드가 오버라이딩되어 자동으로 추가
 */

public record Rectangle(int width, int height) {

}
