package com.training.utils;

import java.sql.*;

import com.training.entity.Employee;

public class ValidateEmployee {

	private Connection con;
	private ResultSet rs;

	public ValidateEmployee() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public ValidateEmployee(Connection con) {
		super();
		this.con = con;
	}

	@SuppressWarnings("finally")
	private Boolean getResultSet(int empId, String passWord) {

		String sql = "select * from Employee where employeeId =? and employeePassword =?";
		Boolean result = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			pstmt.setString(2, passWord);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				result = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			return result;
		}

	}

	public Boolean validate(Employee employeeIns) {

		Boolean result = false;
		String employeePassword;
		int employeeId;

		employeeId = employeeIns.getEmployeeId();
		employeePassword = employeeIns.getEmployeePassword();

		result = getResultSet(employeeId, employeePassword);

		return result;
	}

}
