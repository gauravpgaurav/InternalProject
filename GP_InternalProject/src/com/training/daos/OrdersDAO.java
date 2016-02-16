package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.training.entity.Orders;
import com.training.interfaces.DAO;
import com.training.utils.SqlConnection;

public class OrdersDAO implements DAO<Orders> {

	private Connection con;
	private String tableName;

	public OrdersDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public OrdersDAO(String tableName) {
		super();
		con = SqlConnection.getOracleConnection();
		this.tableName = tableName;
	}

	public OrdersDAO(Connection con, String tableName) {
		super();
		this.con = con;
		this.tableName = tableName;
	}

	@Override
	public int add(Orders t) {
		String sql = "insert into " + tableName + " values(?,?,?,?,?,?)";
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getOrderId());
			pstmt.setInt(2, t.getWaiterId());
			pstmt.setInt(3, t.getNumberOfCustomers());
			pstmt.setInt(4, t.getTableNumber());
			pstmt.setString(5, Boolean.toString(t.isReady()));
			pstmt.setString(6, t.getComments());
			rowAdded = pstmt.executeUpdate();
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowAdded;
	}

	@Override
	public Orders find(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int key, String newStatus) {
		Statement s;
		int rowUpdated = 0;

		try {
			s = (Statement) con.createStatement();
			rowUpdated = s.executeUpdate("update " + tableName + " set " + "isReady='" + newStatus
					+ "' where orderId='" + key + "'");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return rowUpdated;
	}

	@Override
	public int delete(int key) {
		String sql = "delete from " + tableName + " where orderId = " + key;
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
