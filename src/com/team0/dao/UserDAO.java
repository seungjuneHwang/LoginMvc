package com.team0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.team0.db.DBConn;
import com.team0.vo.UserVO;

public class UserDAO {
	public static void InsertUser(UserVO vo) throws Exception {
		// DB 접속
		Connection db = DBConn.getConnection();
		// 쿼리 날려서 유저 정보를 삽입
		// insert into user (name, phone, email, pw) values ('이름', '010-1234-1234', 'a@a.com', '1234')
		String sql  = "insert into user (name, phone, email, pw) values (?, ?, ?, ?)";
		PreparedStatement pstmt = db.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPhone());
		pstmt.setString(3, vo.getEmail());
		pstmt.setString(4, vo.getPw());
		
		// 쿼리 실행
		pstmt.executeUpdate();
		db.close();
	}
	
	// String email, pw 를 매개변수로 넣어서 UserVO 값을 반환
	// 들어가는 매개 변수 String email, String pw
	// 리턴 받는 형은 UserVO
	public static UserVO GetUser(String email, String pw) throws Exception {
		// DB 접속
		Connection db = DBConn.getConnection();
		// 쿼리 날려서 유저 정보를 검색
		// select * from user where email = ?
//		String sql  = "select * from user where email = ?";
		String sql  = "select * from user where email = ? and pw = ?";
		PreparedStatement pstmt = db.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, pw);
		
		UserVO vo = null;
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			vo = new UserVO();
			vo.setName(rs.getString("name"));
			vo.setEmail(rs.getString("email"));
			vo.setPhone(rs.getString("phone"));
		}	
		db.close();
		return vo;
	}
	
	// vo 객체를 넣어서 email pw 정보 확인
	public static Boolean GetUser(UserVO vo) throws Exception {
		// DB 접속
		Connection db = DBConn.getConnection();
		// 쿼리 날려서 유저 정보를 검색
		// select * from user where email = ?
		String sql  = "select * from user where email = ?";
//		String sql  = "select * from user where email = ? and pw = ?";
		PreparedStatement pstmt = db.prepareStatement(sql);
		pstmt.setString(1, vo.getEmail());
		// DB에서 email과 같이 검색 해서 넣어 줘도 됨.
		// 검색된 데이터가 있으면 로그인, 없으면 로그인 실패
//		pstmt.setString(4, vo.getPw());   
		// email만으로 검색해서 데이터가 있으면
		// pw DB데이터와 vo.getPW() 데이터와 비교
		// 쿼리 실행해서 결과값 반환 받음
		Boolean isLogin = false;
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			// 패스워드 체크 후 로그인 성공 여부
			String dbPw = rs.getString("pw");
			if (dbPw.equals(vo.getPw())) {
				// 패스워드가 맞음
				isLogin = true;
			} else {
				//패스워드 틀림
			}
		} else {
			// email 정보가 없음
		}
		db.close();
		return isLogin;
	}
}
