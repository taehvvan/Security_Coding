// boards 테이블 전체 레코드 가져오기

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Boards_List {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "night";
		String password = "night";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select * from boards order by bno desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("no \t name \t title \t cont \t date");
			System.out.println("----------------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("bno") + "\t" 
									+ rs.getString("bwriter") + "\t"
									+ rs.getString("btitle") + "\t" 
									+ rs.getString("bcontent") + "\t" 
									+ rs.getDate("bdate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}

