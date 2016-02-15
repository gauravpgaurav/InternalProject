package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.training.entity.*;
import com.training.interfaces.*;
import com.training.utils.SqlConnection;

public class EmployeeDAO implements DAO<Employee> {

	private Connection con;
	private String tableName;

	public EmployeeDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public EmployeeDAO(String tableName) {
		super();
		con = SqlConnection.getOracleConnection();
		this.tableName = tableName;
	}

	public EmployeeDAO(Connection con, String tableName) {
		super();
		this.con = con;
		this.tableName = tableName;
	}

	@Override
	public int add(Employee t) {

		String sql = "insert into " + tableName + " values(?,?,?,?)";
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getEmployeeId());
			pstmt.setString(2, t.getEmployeeName());
			pstmt.setString(3, t.getEmployeeRole());
			pstmt.setString(4, t.getEmployeePassword());
			rowAdded = pstmt.executeUpdate();
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowAdded;
	}

	@Override
	public Employee find(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int key, String newInput) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

}
