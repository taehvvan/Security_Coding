package net.daum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.daum.dto.CustomerDTO;

// 오라클 db 연동 클래스
public class CustomerDAOImpl {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "night";
	String pwd = "night";
	
	Connection con = null;	// 데이터베이스 연결 con
	PreparedStatement pstmt = null;		// 쿼리문 수행
	ResultSet rs = null;	// 검색 결과 레코드를 저장
	String sql = null;		// 쿼리문 저장 변수
	
	public CustomerDAOImpl() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 기본생성자
	
	// 고객번호 검색
	public CustomerDTO getCus_No(int cus_no) {
		CustomerDTO cusNo = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			sql = "select cus_no from customer where cus_no = ?";
			pstmt = con.prepareStatement(sql);	// 쿼리문을 미리 컴파일해서 수행할 pstmt 생성
			pstmt.setInt(1, cus_no);	// 쿼리문의 첫 번째 물음표에 정수 숫자로 고객번호 저장
			rs = pstmt.executeQuery();	// 검색 쿼리문 수행 후 결과 레코드를 rs에 저장
			
			if(rs.next()) {
				cusNo = new CustomerDTO();
				cusNo.setCus_no(rs.getInt("cus_no"));	// cus_no 컬럼으로부터 정수 숫자로 고객번호를 가져와 setter() 메서드에 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cusNo;
	} // getCus_No
	
}
