package net.daum.controller;

import java.util.List;
import java.util.Scanner;

import net.daum.dao.BoardDAOImpl;
import net.daum.dto.BoardDTO;

public class BoardExample {
	
	private Scanner scan = new Scanner(System.in);
	
	// 게시판 목록
	public void list() {
		System.out.println();
		System.out.println("[게시판 목록]");
		System.out.println("----------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		/*
		 * %-6s : 문자열 출력형태 지정자. -는 왼쪽 정렬, 6은 최소 출력 너비 지정
		 * 		: 문자열을 왼쪽 정렬하고 전체 너비를 6칸으로 맞춘다. 칸이 남으면 오른쪽에 공백이 들어간다.
		 */
		System.out.println("----------------------------------------------------");
		
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		List<BoardDTO> blist = bdao.getBoardList();	// 게시판 목록을 가져옴
		
		if(blist != null && blist.size() > 0) {
			for(BoardDTO b : blist) {
				System.out.printf("%-6s%-12s%-16s%-40s \n", b.getBno(), b.getBwriter(), 
															b.getBdate(), b.getBtitle());
			}
		} else {
			System.out.println("게시판 목록이 없습니다.");
		}
		
		mainMenu();		// 메인 메뉴 메서드 호출
	} // list()
	
	// 메인 메뉴
	public void mainMenu() {
		
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("메인 메뉴 : 1. Create | 2. Read | 3. Clear | 4. Exit");
		System.out.print("메뉴 선택 : ");
		String menuNo = scan.nextLine();
		System.out.println();
		
		switch(menuNo) {
			case "1" : create(); break;
			case "2" : read(); break;
			case "4" : exit(); break;
		}
	} // mainMenu()
	
	// 게시판 저장
	public void create() {
		BoardDTO board = new BoardDTO();
		System.out.println("[새 게시물 입력]");
		System.out.print("글쓴이 >> ");
		board.setBwriter(scan.nextLine());
		System.out.print("글 제목 >> ");
		board.setBtitle(scan.nextLine());
		System.out.print("글 내용 >> " );
		board.setBcontent(scan.nextLine());
		
		// 보조 메뉴 출력
		System.out.println("----------------------------------------------------");
		System.out.println("보조 메뉴 : 1. OK | 2. Cancel");
		System.out.print("메뉴 선택 >> ");
		String menuNo = scan.nextLine();
		
		if(menuNo.equals("1")) {
			BoardDAOImpl bdao = new BoardDAOImpl();
			bdao.insertBoard(board);
			list();
		} else {
			list();
		}
	} // create()
	
	// 게시판 읽기
	public void read() {
		
		System.out.println("[게시물 읽기]");
		System.out.print("게시판 번호 입력 >> ");
		int bno = Integer.parseInt(scan.nextLine());
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		BoardDTO findBno = bdao.getFindNo(bno);		// db로부터 게시판 번호를 검색
		
		if(findBno != null) {
			BoardDTO bc = bdao.getBoardCont(bno);	// 번호에 해당하는 게시물 내용을 DB로부터 가져옴
		} else {
			System.out.println("해당 게시물 내용이 없습니다.");
			list();
		}
	} // read()
	
	// 게시판 종료
	public void exit() {
		System.out.println("** 게시판 종료 **");
		System.exit(0);		// 게시판 프로그램 정상 종료
	}
	
	public static void main(String[] args) {
		
		BoardExample boardExample = new BoardExample();
		boardExample.list();	// 게시판 목록 보기

	}
}
