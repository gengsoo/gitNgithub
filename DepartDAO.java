package net.daum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.naver.DBConnect;


public class DepartDAO implements DBConnect {
	
	public DepartDAO() {
		try {
			Class.forName(DRIVER);
			System.out.println("driver 로딩 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(DepartDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into depart values(?, ?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connection 생성");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDid());
			pstmt.setString(2, dto.getDname());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<DepartDTO> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from depart order by did";
		
		ArrayList<DepartDTO> list = new ArrayList<DepartDTO>();
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				
				DepartDTO dto = new DepartDTO(did, dname);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public DepartDTO getDepartDTOByDid(String did) {
		DepartDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from depart where did = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, did);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dname = rs.getString("dname");
				dto = new DepartDTO(did, dname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void update(DepartDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update depart set dname = ? where did = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getDid());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void delete(String did) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from depart where did = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, did);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
