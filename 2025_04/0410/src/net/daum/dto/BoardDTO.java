package net.daum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data	// 기본 생성자, canEqual(), equals(), getter(), 
		// hashCode(), setter(), toString() 메소드 자동 추가
@AllArgsConstructor	// Constructor 는 생성자를 의미
					// @AllArgsConstructor 애노테이션을 사용하면 기본 생성자는 사라지고
					// 멤버변수 개수만큼 초기화할 수 있게 오버로딩된 생성자 자동 추가
public class BoardDTO {	// 게시판 데이터 저장빈 클래스 DTO
	
	private String writer;	// 글쓴이
	private String title;	// 제목
	private String content;	// 내용

}
