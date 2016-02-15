package com.training.utils;

import java.sql.*;

import com.training.entity.Employee;

public class ValidateUser {

	private Connection con;
	private ResultSet rs;

	public ValidateUser() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public ValidateUser(Connection con) {
		super();
		this.con = con;
	}

	private void getResultSet() {

		String sql = "select * from Employee";

		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public Boolean validate(Employee employeeIns) {
		getResultSet();

		Boolean result = false;
		String employeeName, employeePassword;

		try {
			while (rs.next()) {

				employeeName = rs.getString("employeeName");
				if (employeeName.equals(employeeIns.getEmployeeName())) {
					employeePassword = rs.getString("employeePassword");
					if (employeePassword.equals(employeeIns.getEmployeePassword())) {
						result = true;
						break;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
