/*
 * 람복 API가 설정된 DTO인 BoardDTO.java를 임포트해서 활용
 */

import net.daum.dto.BoardDTO;

public class BoardMain {

	public static void main(String[] args) {

		BoardDTO board = new BoardDTO("홍길동", "게시판 글제목입니다.", "게시판 글내용입니다.");
		
		System.out.println("게시판 글쓴이 : " + board.getWriter());
		System.out.println("게시판 글제목 : " + board.getTitle());
		System.out.println("게시판 글내용 : " + board.getContent());
	}

}
