package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ResultDAO {
	private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;

	public ResultDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Result> getResuList(){
		
		List<Result> resultList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from result;");
			
			while (rs.next()) {
				resultList.add(new Result(
						rs.getInt("id"),
						rs.getString("major"), 
						rs.getInt("seatnumber"), 
						rs.getString("name"), 
						rs.getInt("year"), 
						rs.getDouble("grade"), 
						rs.getBoolean("qualify")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return resultList;
	}
	
public Result getResult(int id){
		
		Result result = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from result "
			+ "where id='" +id+"';");
					
			
			while (rs.next()) {
				result = new Result(
						rs.getInt("id"),
						rs.getString("major"), 
						rs.getInt("seatnumber"), 
						rs.getString("name"), 
						rs.getInt("year"), 
						rs.getDouble("grade"), 
						rs.getBoolean("qualify"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}

	public int createResult( final Result result) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `result` "
					+ "(`major`, `seatnumber`, `name`, `year`, `grade`, `qualify`)"
					+ " VALUES (?, ?, ?, ?, ?, ?);"
					);
			
			pStmt.setString(1, result.getMajor());
			pStmt.setInt(2, result.getSeatNo());
			pStmt.setString(3, result.getName());
			pStmt.setInt(4, result.getYear());
			pStmt.setDouble(5, result.getGrade());
			pStmt.setBoolean(6, result.isQualify());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
		close();
	}
		return rowEffected;
}
	
	public int updateResult(final Result result) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("UPDATE `result` SET "
					+ "`major` = ?,"
					+ " `seatnumber` = ?,"
					+ " `name` = ?,"
					+ " `year` = ?, "
					+ "`grade` = ?, "
					+ "`qualify` = ? WHERE (`id` = ?);"
					);
			
			pStmt.setString(1, result.getMajor());
			pStmt.setInt(2, result.getSeatNo());
			pStmt.setString(3, result.getName());
			pStmt.setInt(4, result.getYear());
			pStmt.setDouble(5, result.getGrade());
			pStmt.setBoolean(6, result.isQualify());
			pStmt.setInt(7, result.getId());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowEffected;
	
	}
	
	public int deleteResult(int id) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from result where id = ?;");
			pStmt.setInt(1, id);
			rowEffected = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
		
	}
	
	
		
	

}
