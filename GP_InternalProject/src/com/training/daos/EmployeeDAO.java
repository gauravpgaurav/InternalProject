package com.training.daos;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return 0;
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
