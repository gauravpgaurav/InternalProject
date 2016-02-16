package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	private Employee getEmployee(ResultSet rs) {

		Employee emp = null;
		try {

			emp = new Employee(rs.getInt("employeeId"), rs.getString("employeeName"), rs.getString("employeeRole"),
					rs.getString("employeePassword"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}

	@Override
	public Employee find(int key) {
		String sql = "select * from " + tableName + " where employeeId =?";
		Employee resultEmployee = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				resultEmployee = getEmployee(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return resultEmployee;
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from " + tableName;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				empList.add(getEmployee(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return empList;
	}

	@Override
	public int update(int key, String newPassword) {
		Statement s;
		int rowUpdated = 0;

		try {
			s = (Statement) con.createStatement();
			rowUpdated = s.executeUpdate("update " + tableName + " set " + "employeePassword='" + newPassword
					+ "' where employeeId='" + key + "'");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return rowUpdated;
	}

	@Override
	public int delete(int key) {
		String sql = "delete from " + tableName + " where employeeId = " + key;
		int rowDeleted = 0;

		try {

			Statement stmt = con.createStatement();
			rowDeleted = stmt.executeUpdate(sql);
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowDeleted;
	}
	
	@Override
	public int deleteAll() {
		String sql = "delete from " + tableName;
		int rowDeleted = 0;

		try {

			Statement stmt = con.createStatement();
			rowDeleted = stmt.executeUpdate(sql);
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowDeleted;
	}

}
